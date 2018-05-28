package di.smartliving.sensor.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import di.smartliving.sensor.global.PublisherHandler;
import di.smartliving.sensor.properties.MqttProperties;

@Configuration
@EnableConfigurationProperties(value = MqttProperties.class)
public class SensorAppConfig {

	@Bean
	@Scope("singleton")
	public PublisherHandler publisherHandler() {
		return new PublisherHandler();
	}
}
