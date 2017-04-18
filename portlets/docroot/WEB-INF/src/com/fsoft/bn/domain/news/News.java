package com.fsoft.bn.domain.news;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.portlet.news.NewsContants.XSD_ELEMENT_NAME;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;

public class News {

	private String id;
	private String title;
	private String imageURL;
	private String summary;
	private String content;
	private String createdDate;
	private String urlDetail;
	private String source;
	private String author;
	private int viewCount;
	private String cateName; 

	private Map<String, String> otherProps;

	@Deprecated
	public News(JournalArticle article, String urlDetail) {
		this(article, urlDetail, StringUtils.EMPTY);
	}

	public News(JournalArticle article, String urlDetail, String languageId) {
		//set value to this news
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		setId(article.getArticleId());
		setTitle(article.getTitleCurrentValue());
		setCreatedDate(DATE_FORMAT.format(article.getCreateDate()));
		setSummary(article.getDescriptionCurrentValue());
		setImageURL(article.getSmallImageURL());
		setUrlDetail(urlDetail);
		setViewCount(NewsUtils.getViewCountArticle(article.getResourcePrimKey()));
		//get JournalStructure of news
		JournalStructure journalStructure = StructureUtil.getStructureById(article.getStructureId());
		Map<String , String> structureProps = StructureUtil.extractXSDPropNamesStructure(journalStructure.getXsd());
		String xmlContent = article.getContent();
		otherProps = StructureUtil.extractJournalXML(xmlContent, languageId , structureProps);
		Iterator<Map.Entry<String, String>> it = otherProps.entrySet().iterator();
		for (; it.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			if (key.equalsIgnoreCase(XSD_ELEMENT_NAME.CONTENT)) {
				setContent(entry.getValue());
				it.remove();
			} else if (key.equalsIgnoreCase(XSD_ELEMENT_NAME.SOURCE)) {
				setSource(entry.getValue());
				it.remove();
			} else if (key.equalsIgnoreCase(XSD_ELEMENT_NAME.AUTHOR)) {
				setAuthor(entry.getValue());
				it.remove();
			}
		}
	}
	

	public News() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUrlDetail() {
		return urlDetail;
	}

	public void setUrlDetail(String urlDetail) {
		this.urlDetail = urlDetail;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Map<String, String> getOtherProps() {
		return otherProps;
	}

	public void setOtherProps(Map<String, String> otherProps) {
		this.otherProps = otherProps;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", imageURL=" + imageURL + ", summary=" + summary + ", content=" + content
				+ ", createdDate=" + createdDate + ", urlDetail=" + urlDetail + ", source=" + source + ", author=" + author
				+ ", viewCount=" + viewCount + ", otherProps=" + otherProps + "]";
	}
}