package pl.capgemini.survival.common.to;

import java.util.List;

public class SearchResultTo {

	private List<LegoSetTo> legoSets;

	private long limit;

	private long offset;

	private long total;

	public List<LegoSetTo> getLegoSets() {
		return legoSets;
	}

	public void setLegoSets(List<LegoSetTo> legoSets) {
		this.legoSets = legoSets;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
