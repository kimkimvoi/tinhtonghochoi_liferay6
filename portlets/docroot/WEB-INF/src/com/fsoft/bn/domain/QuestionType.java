package com.fsoft.bn.domain;

public class QuestionType {

	public QuestionType() {
		// TODO Auto-generated constructor stub
	}

	public QuestionType(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String id;
	private String name;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}