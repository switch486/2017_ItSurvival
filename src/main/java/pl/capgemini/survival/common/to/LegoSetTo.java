package pl.capgemini.survival.common.to;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;

public class LegoSetTo {

	private long id;

	private long version;

	@NotNull
	@Size(min = 5, max = 200)
	private String name;

	@NotNull
	private String externallId;

	@NotNull
	private Status status;

	@NotNull
	private Condition condition;

	private String comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternallId() {
		return externallId;
	}

	public void setExternallId(String externallId) {
		this.externallId = externallId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
