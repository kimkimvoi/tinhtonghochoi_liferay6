package com.fsoft.bn.domain;

import java.util.List;

public class PublicAdministrationProcedure {
	private String id;
	private String title;
	private String fields;
	private String organizations;
	private String level;
	private String nameOfProcedures;
	private String execution;
	private String perform;
	private String profile;
	private String processing;
	private String object;
	private String agency;
	private String result;
	private String cost;
	private String formSheets;
	private String condition;
	private String legalBases;
	private String contact;
	private List<String> attachment;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getOrganizations() {
		return organizations;
	}

	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}

	public String getNameOfProcedures() {
		return nameOfProcedures;
	}

	public void setNameOfProcedures(String nameOfProcedures) {
		this.nameOfProcedures = nameOfProcedures;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getPerform() {
		return perform;
	}

	public void setPerform(String perform) {
		this.perform = perform;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProcessing() {
		return processing;
	}

	public void setProcessing(String processing) {
		this.processing = processing;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getFormSheets() {
		return formSheets;
	}

	public void setFormSheets(String formSheets) {
		this.formSheets = formSheets;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLegalBases() {
		return legalBases;
	}

	public void setLegalBases(String legalBases) {
		this.legalBases = legalBases;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<String> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<String> attachment) {
		this.attachment = attachment;
	}
	
	public PublicAdministrationProcedure(){
		super();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
