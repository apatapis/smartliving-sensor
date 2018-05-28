package di.smartliving.sensor.web.mqtt.dto;

import java.math.BigDecimal;

import di.smartliving.sensor.util.MathUtils;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;
import di.smartliving.sensor.web.rest.resource.SendMessageRequest;

public class SensorMessage {

	private String sensorId;
	private String unit;
	private BigDecimal value;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SensorMessage [sensorId=" + sensorId + ", unit=" + unit + ", value=" + value + "]";
	}

	public static SensorMessage from(SendMessageRequest sendMessageRequest) {
		SensorMessage sensorMessage = new SensorMessage();
		sensorMessage.setSensorId(sendMessageRequest.getSensorId());
		sensorMessage.setUnit(sendMessageRequest.getUnit());
		sensorMessage.setValue(sendMessageRequest.getValue());
		return sensorMessage;
	}

	public static SensorMessage from(RepeatMessageRequest repeatMessageRequest) {
		SensorMessage sensorMessage = new SensorMessage();
		sensorMessage.setSensorId(repeatMessageRequest.getSensorId());
		sensorMessage.setUnit(repeatMessageRequest.getUnit());
		sensorMessage
				.setValue(MathUtils.random(repeatMessageRequest.getValueMin(), repeatMessageRequest.getValueMax()));
		return sensorMessage;
	}

}
