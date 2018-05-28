package di.smartliving.sensor.web.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di.smartliving.sensor.global.PublisherHandler;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;

@Component
public class RepeatMessageTaskFactory {

	@Autowired
	private PublisherHandler publisherHandler;

	public RepeatMessageTask create(MqttClient mqttClient, RepeatMessageRequest repeatMessageRequest) {
		return new RepeatMessageTask(publisherHandler, mqttClient, repeatMessageRequest);
	};
}
