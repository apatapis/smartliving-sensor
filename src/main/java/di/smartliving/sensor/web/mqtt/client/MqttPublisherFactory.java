package di.smartliving.sensor.web.mqtt.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisherFactory {

	@Autowired
	private RepeatMessageTaskFactory repeatMessageTaskFactory;

	public MqttPublisher create(String brokerUrl) {
		return new MqttPublisher(repeatMessageTaskFactory, brokerUrl);
	};
}
