package pl.capgemini.survival.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;

@Entity
public class LegoSet {

	@Id
	@SequenceGenerator(name = "LEGO_SET_ID_GENERATOR", sequenceName = "SEQ_LEGO_SET")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEGO_SET_ID_GENERATOR")
	private long id;

	private long legoVersion;

	@NotNull
	@Size(min = 5, max = 200)
	private String legoName;

	@NotNull
	private String externallId;

	@NotNull
	private Status legoStatus;

	@NotNull
	private Condition legoCondition;

	private String legoComment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLegoVersion() {
		return legoVersion;
	}

	public void setLegoVersion(long legoVersion) {
		this.legoVersion = legoVersion;
	}

	public String getLegoName() {
		return legoName;
	}

	public void setLegoName(String legoName) {
		this.legoName = legoName;
	}

	public String getExternallId() {
		return externallId;
	}

	public void setExternallId(String externallId) {
		this.externallId = externallId;
	}

	public Status getLegoStatus() {
		return legoStatus;
	}

	public void setLegoStatus(Status legoStatus) {
		this.legoStatus = legoStatus;
	}

	public Condition getLegoCondition() {
		return legoCondition;
	}

	public void setLegoCondition(Condition legoCondition) {
		this.legoCondition = legoCondition;
	}

	public String getLegoComment() {
		return legoComment;
	}

	public void setLegoComment(String legoComment) {
		this.legoComment = legoComment;
	}

}
