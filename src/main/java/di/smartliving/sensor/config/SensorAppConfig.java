package di.smartliving.sensor.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import di.smartliving.sensor.properties.MqttProperties;

@Configuration
@EnableConfigurationProperties(value = MqttProperties.class)
public class SensorAppConfig {

}
