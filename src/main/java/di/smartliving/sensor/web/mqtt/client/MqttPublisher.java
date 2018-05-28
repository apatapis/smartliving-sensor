package di.smartliving.sensor.web.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import di.smartliving.sensor.web.mqtt.dto.SensorMessage;

public class MqttPublisher {

	private MqttClient mqttClient;

	public MqttPublisher(String brokerUrl) {
		try {
			mqttClient = new MqttClient(brokerUrl, MqttClient.generateClientId());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String topic, SensorMessage sensorMessage) {
		try {
			mqttClient.connect();
			MqttMessage mqttMessage = new MqttMessage();
			mqttMessage.setPayload(sensorMessage.toString().getBytes());
			mqttClient.publish(topic, mqttMessage);
			mqttClient.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
