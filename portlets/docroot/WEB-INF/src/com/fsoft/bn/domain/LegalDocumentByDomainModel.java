package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.List;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * model class for legal document
 * @author VangND1
 *
 */
public class LegalDocumentByDomainModel implements Serializable {

	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	/***/
	private String no;
	/***/
	private String id;
	/***/
	private String title;
	/** document symbol*/
	private String symbol;
	/** document domain*/
	private String domain;
	/** document type*/
	private String type;
	/** document description*/
	private String description;
	/** document effect date*/
	private String effectDate;
	/** document publish date*/
	private String publishDate;
	/** grade publisher*/
	private String gradePublisher;
	/** organization publisher*/
	private String organPublisher;
	/** signer*/
	private String signer;
	/** list attched file*/
	private List<String> attachedFiles;
	/***/
	private String createdDate;
	
	/**
	 * default constructor
	 */
	public LegalDocumentByDomainModel() {
	}
	/**
	 * constructor using generate document from JournalArticle
	 * @param article 
	 * @param languageId 
	 */
	public LegalDocumentByDomainModel(JournalArticle article, String languageId) {
		String content = article.getContent();
		this.id = article.getArticleId();
		this.title = StructureUtil.getXsdTitleArticleMultiLanguage(article.getTitle(), languageId);
		this.symbol = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.DOCUMENT_SYMBOL, languageId);
		this.domain = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.DOCUMENT_DOMAIN, languageId);
		this.type = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.DOCUMENT_FORM, languageId);
		this.description = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.DOCUMENT_DESCRIPTION, languageId);
		this.effectDate = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.EFFECT_DATE, languageId);
		this.publishDate = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.PUBLISH_DATE, languageId);
		this.gradePublisher = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.GRADE_PUBLISHER, languageId);
		this.organPublisher = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.ORGAN_PUBLISHER, languageId);
		this.signer = StructureUtil.getXsdContentArticleMultiLanguage(content,
				CommonConstants.PORTLET.LEGAL_DOCUMENT_BYDOMAIN.SIGNER, languageId);
		this.createdDate = DateUtils.date2String(article.getCreateDate(), CommonConstants.DATE_FORMAT.DD_MM_YYYY_HHMM);

	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the effectDate
	 */
	public String getEffectDate() {
		return effectDate;
	}

	/**
	 * @param effectDate the effectDate to set
	 */
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the gradePublisher
	 */
	public String getGradePublisher() {
		return gradePublisher;
	}

	/**
	 * @param gradePublisher the gradePublisher to set
	 */
	public void setGradePublisher(String gradePublisher) {
		this.gradePublisher = gradePublisher;
	}

	/**
	 * @return the organPublisher
	 */
	public String getOrganPublisher() {
		return organPublisher;
	}

	/**
	 * @param organPublisher the organPublisher to set
	 */
	public void setOrganPublisher(String organPublisher) {
		this.organPublisher = organPublisher;
	}

	/**
	 * @return the signer
	 */
	public String getSigner() {
		return signer;
	}

	/**
	 * @param signer the signer to set
	 */
	public void setSigner(String signer) {
		this.signer = signer;
	}

	/**
	 * @return the attachedFiles
	 */
	public List<String> getAttachedFiles() {
		return attachedFiles;
	}

	/**
	 * @param attachedFiles the attachedFiles to set
	 */
	public void setAttachedFiles(List<String> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	
}

