package di.smartliving.sensor.web.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import di.smartliving.sensor.global.PublisherHandler;
import di.smartliving.sensor.web.mqtt.dto.SensorMessage;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;

public class RepeatMessageTask implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(RepeatMessageTask.class);

	private final PublisherHandler publisherHandler;
	private MqttClient mqttClient;
	private RepeatMessageRequest repeatMessageRequest;

	public RepeatMessageTask(PublisherHandler publisherHandler, MqttClient mqttClient,
			RepeatMessageRequest repeatMessageRequest) {
		this.publisherHandler = publisherHandler;
		this.mqttClient = mqttClient;
		this.repeatMessageRequest = repeatMessageRequest;
	}

	@Override
	public void run() {
		try {
			mqttClient.connect();
			sendMessages();
			mqttClient.disconnect();
		} catch (MqttException e) {
			LOGGER.error("Error connecting / disconnecting to broker.", e);
		}
		publisherHandler.stopAndRemove(mqttClient.getClientId());
	}

	private void sendMessages() {
		for (int i = 0; i < repeatMessageRequest.getTimes(); i++) {
			MqttMessage mqttMessage = new MqttMessage();
			try {
				mqttMessage.setPayload(
						new ObjectMapper().writeValueAsString(SensorMessage.from(repeatMessageRequest)).getBytes());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			try {
				mqttClient.publish(repeatMessageRequest.getTopic(), mqttMessage);
			} catch (MqttException e) {
				LOGGER.error("Error publishing message.", e);
			}
			try {
				Thread.sleep(repeatMessageRequest.getInterval());
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
