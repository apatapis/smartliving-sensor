package di.smartliving.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import di.smartliving.sensor.global.PublisherHandler;
import di.smartliving.sensor.properties.MqttProperties;
import di.smartliving.sensor.web.mqtt.client.MqttPublisher;
import di.smartliving.sensor.web.mqtt.client.MqttPublisherFactory;
import di.smartliving.sensor.web.mqtt.dto.SensorMessage;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;
import di.smartliving.sensor.web.rest.resource.SendMessageRequest;

@Service
public class MqttService {

	@Autowired
	private MqttProperties mqttProperties;

	@Autowired
	private MqttPublisherFactory mqttPublisherFactory;

	@Autowired
	private PublisherHandler publisherHandler;

	public void sendMessage(SendMessageRequest sendMessageRequest) {
		MqttPublisher mqttPublisher = mqttPublisherFactory.create(mqttProperties.getBrokerUrl());
		mqttPublisher.sendMessage(sendMessageRequest.getTopic(), SensorMessage.from(sendMessageRequest));
	}

	public String repeatMessage(RepeatMessageRequest repeatMessageRequest) {
		MqttPublisher mqttPublisher = mqttPublisherFactory.create(mqttProperties.getBrokerUrl());
		publisherHandler.add(mqttPublisher);
		mqttPublisher.repeatMessage(repeatMessageRequest);
		return mqttPublisher.getClientId();
	}

	public void stopMessage(String clientId) {
		publisherHandler.stopAndRemove(clientId);
	}
}
