package di.smartliving.sensor.web.mqtt.dto;

import java.math.BigDecimal;

import di.smartliving.sensor.web.rest.resource.SendMessageOnceRequest;

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

	public static SensorMessage from(SendMessageOnceRequest sendMessageOnceRequest) {
		SensorMessage sensorMessage = new SensorMessage();
		sensorMessage.setSensorId(sendMessageOnceRequest.getSensorId());
		sensorMessage.setUnit(sendMessageOnceRequest.getUnit());
		sensorMessage.setValue(sendMessageOnceRequest.getValue());
		return sensorMessage;
	}
}
