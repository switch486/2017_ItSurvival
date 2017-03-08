package pl.capgemini.survival.common.to;

import pl.capgemini.survival.common.typ.Condition;
import pl.capgemini.survival.common.typ.Status;

public class SearchCriteriaTo {

	private int page;

	private int pageSize;

	private String name;

	private String externallId;

	private Status status;

	private Condition condition;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

}
