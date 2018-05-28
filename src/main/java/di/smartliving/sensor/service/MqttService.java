package di.smartliving.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import di.smartliving.sensor.properties.MqttProperties;
import di.smartliving.sensor.web.mqtt.client.MqttPublisher;
import di.smartliving.sensor.web.mqtt.dto.SensorMessage;
import di.smartliving.sensor.web.rest.resource.SendMessageOnceRequest;

@Service
public class MqttService {

	@Autowired
	private MqttProperties mqttProperties;

	public void sendMessage(SendMessageOnceRequest sendMessageOnceRequest) {
		MqttPublisher mqttPublisher = new MqttPublisher(mqttProperties.getBrokerUrl());
		mqttPublisher.sendMessage(sendMessageOnceRequest.getTopic(), SensorMessage.from(sendMessageOnceRequest));
	}
}
