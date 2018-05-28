package di.smartliving.sensor.global;

import java.util.HashMap;
import java.util.Map;

import di.smartliving.sensor.web.mqtt.client.MqttPublisher;

public class PublisherHandler {

	private Map<String, MqttPublisher> publishers = new HashMap<>();

	public synchronized void add(MqttPublisher publisher) {
		publishers.put(publisher.getClientId(), publisher);
	}

	public synchronized void stopAndRemove(String clientId) {
		MqttPublisher mqttPublisher = publishers.get(clientId);
		if (mqttPublisher != null) {
			mqttPublisher.stop();
			publishers.remove(mqttPublisher.getClientId());
		}
	}
}
