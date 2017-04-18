package com.fsoft.bn.domain;

import java.util.Date;
import java.util.List;

public class LegalDocumentModel {
	private String id;
	private String document_symbol;
	private String document_domain;
	private String document_form;
	private String document_description;
	private Date publish_date;
	private String effect_date;
	private String grade_publisher;
	private String organ_publisher;
	private String signer;
	private List<String> file_attach;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocument_symbol() {
		return document_symbol;
	}
	public void setDocument_symbol(String document_symbol) {
		this.document_symbol = document_symbol;
	}
	public String getDocument_domain() {
		return document_domain;
	}
	public void setDocument_domain(String document_domain) {
		this.document_domain = document_domain;
	}
	public String getDocument_form() {
		return document_form;
	}
	public void setDocument_form(String document_form) {
		this.document_form = document_form;
	}
	public String getDocument_description() {
		return document_description;
	}
	public void setDocument_description(String document_description) {
		this.document_description = document_description;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getOrgan_publisher() {
		return organ_publisher;
	}
	public void setOrgan_publisher(String organ_publisher) {
		this.organ_publisher = organ_publisher;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	public List<String> getFile_attach() {
		return file_attach;
	}
	public void setFile_attach(List<String> file_attach) {
		this.file_attach = file_attach;
	}
	public String getGrade_publisher() {
		return grade_publisher;
	}
	public void setGrade_publisher(String grade_publisher) {
		this.grade_publisher = grade_publisher;
	}
	public String getEffect_date() {
		return effect_date;
	}
	public void setEffect_date(String effect_date) {
		this.effect_date = effect_date;
	}
	
}
