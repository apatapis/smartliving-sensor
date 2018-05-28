package di.smartliving.sensor.web.rest.resource;

import java.math.BigDecimal;

public class RepeatMessageRequest {

	private String sensorId;
	private String topic;
	private String unit;
	private BigDecimal valueMin;
	private BigDecimal valueMax;
	private int times;
	private long interval; // in ms

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

	public BigDecimal getValueMin() {
		return valueMin;
	}

	public void setValueMin(BigDecimal valueMin) {
		this.valueMin = valueMin;
	}

	public BigDecimal getValueMax() {
		return valueMax;
	}

	public void setValueMax(BigDecimal valueMax) {
		this.valueMax = valueMax;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return "RepeatMessageRequest [sensorId=" + sensorId + ", topic=" + topic + ", unit=" + unit + ", valueMin="
				+ valueMin + ", valueMax=" + valueMax + ", times=" + times + ", interval=" + interval + "]";
	}

}
