package datarepo;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="col")
public class Examination {
	
	@Id
	private BigDecimal id;
	private BigDecimal patientId;
	private long pulse;
	private long power;
	private long ppValue;
	private long meanValue;
	
	public BigDecimal getid() {
		return id;
	}
	public void setid(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getpatientId() {
		return patientId;
	}
	public void setpatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}
	public long getPulse() {
		return pulse;
	}
	public void setPulse(long pulse) {
		this.pulse = pulse;
	}
	public long getPower() {
		return power;
	}
	public void setPower(long power) {
		this.power = power;
	}
	public long getPpValue() {
		return ppValue;
	}
	public void setPpValue(long ppValue) {
		this.ppValue = ppValue;
	}
	public long getMeanValue() {
		return meanValue;
	}
	public void setMeanValue(long meanValue) {
		this.meanValue = meanValue;
	}
	@PersistenceConstructor
	public Examination(BigDecimal id, BigDecimal patientId, long pulse, long power, long ppValue,
			long meanValue) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.pulse = pulse;
		this.power = power;
		this.ppValue = ppValue;
		this.meanValue = meanValue;
	}
	public Examination() {
		super();
	}
	@Override
	public String toString() {
		return "Badanie [id=" + id + ", patientId=" + patientId + ", pulse=" + pulse
				+ ", power=" + power + ", ppValue=" + ppValue + ", meanValue=" + meanValue + "]";
	}
	
}
