package com.fsoft.bn.domain;

import java.util.List;
public class DataDictionarySet {

	private String name;
	private List<DataDictionary> records;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DataDictionary> getRecords() {
		return records;
	}

	public void setRecords(List<DataDictionary> records) {
		this.records = records;
	}

}