package di.smartliving.sensor.web.rest.resource;

import java.math.BigDecimal;

public class SendMessageOnceRequest {

	private String sensorId;
	private String topic;
	private String unit;
	private BigDecimal value;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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
		return "SendMessageOnceRequest [topic=" + topic + ", unit=" + unit + ", value=" + value + "]";
	}

}
