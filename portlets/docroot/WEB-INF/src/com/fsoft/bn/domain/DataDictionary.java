package com.fsoft.bn.domain;


public class DataDictionary implements Comparable<DataDictionary>{

	private long key;
	private String value;
	private long display_order;
	
	public DataDictionary() {
		super();
		value = "";
	}

	public DataDictionary(long key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getDisplay_order() {
		return display_order;
	}

	public void setDisplay_order(long display_order) {
		this.display_order = display_order;
	}

	@Override
	public int compareTo(DataDictionary next) {
		int result = (this.display_order - next.display_order > 0) ? 1 : ((this.display_order - next.display_order < 0) ? -1 : 0);
		return result;
	}

}