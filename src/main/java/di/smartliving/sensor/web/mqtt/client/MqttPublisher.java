package di.smartliving.sensor.web.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import di.smartliving.sensor.web.mqtt.dto.SensorMessage;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;

public class MqttPublisher {

	private final RepeatMessageTaskFactory repeatMessageTaskFactory;

	private MqttClient mqttClient;
	private Thread thread;

	public MqttPublisher(RepeatMessageTaskFactory repeatMessageTaskFactory, String brokerUrl) {
		this.repeatMessageTaskFactory = repeatMessageTaskFactory;
		try {
			mqttClient = new MqttClient(brokerUrl, MqttClient.generateClientId());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public String getClientId() {
		return mqttClient.getClientId();
	}

	public void sendMessage(String topic, SensorMessage sensorMessage) {
		try {
			mqttClient.connect();
			MqttMessage mqttMessage = new MqttMessage();
			try {
				mqttMessage.setPayload(new ObjectMapper().writeValueAsString(sensorMessage).getBytes());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			mqttClient.publish(topic, mqttMessage);
			mqttClient.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public void repeatMessage(RepeatMessageRequest repeatMessageRequest) {
		thread = new Thread(repeatMessageTaskFactory.create(mqttClient, repeatMessageRequest));
		thread.start();
	}

	public void stop() {
		if (thread.isAlive()) {
			thread.interrupt();
		}
	}

}
