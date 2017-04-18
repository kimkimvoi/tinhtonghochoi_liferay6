package com.fsoft.bn.portlet.public_news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.PublicNews;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.journal.model.JournalArticle;

public class PublicNewsDelegate {
	/** logger */
	private static Logger log = Logger.getLogger(PublicNewsDelegate.class);
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMET_VI);
	
	private static DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
	
	
	/**
	 * get All PublicNews
	 */
	public static List<PublicNews> getAllPublicNews(List<JournalArticle> publicNewsLastVersionList) {
		List<PublicNews> publicNewsList = new ArrayList<PublicNews>();
        for (JournalArticle journalArticle : publicNewsLastVersionList) {
        	PublicNews publicNews = convertArticleToPublicNews(journalArticle);
    		publicNewsList.add(publicNews);
         }
		return publicNewsList;
	}
	
	/**
	 * get PublicNews start to end
	 */
	public static List<PublicNews> getPublicNewsStartToEnd(List<JournalArticle> publicNewsLastVersionList, int start, int end) {
		List<PublicNews> publicNewsList = new ArrayList<PublicNews>();
		List<JournalArticle> journalArticlesList = new ArrayList<JournalArticle>();
		int maxNumber = publicNewsLastVersionList.size();
		int number = start;
		while(number < end && number < maxNumber) {
			journalArticlesList.add(publicNewsLastVersionList.get(number));
			number ++;
		}
		
        for (JournalArticle journalArticle : journalArticlesList) {
        	PublicNews publicNews = PublicNewsDelegate.convertArticleToPublicNews(journalArticle);
    		publicNewsList.add(publicNews);
         }
		return publicNewsList;
	}
	
	/**
	 * convert Article to PublicNews
	 */
	public static PublicNews convertArticleToPublicNews(JournalArticle journalArticle) {
		PublicNews publicNews = new PublicNews();
    	
    	publicNews.setId(journalArticle.getArticleId());
    	publicNews.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
    	//2014/02/28 - PhuongLH: fixed bug FIBIXBP-120:
    	//- Incorrect published date of public news
    	//String publisher_date = simpleDateFormat.format(journalArticle.getCreateDate());
    	String publisher_date = simpleDateFormat.format(journalArticle.getDisplayDate());
    	publicNews.setPublisher_date(publisher_date);
    	publicNews.setFields(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "fields"));
    	publicNews.setKey(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "key"));
    	publicNews.setFields(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "fields"));
    	publicNews.setNumber(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "number"));
    	publicNews.setPublisher(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "publisher"));
    	publicNews.setQuote(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "quote"));
    	publicNews.setSigner(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "signer"));
    	publicNews.setType(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "type"));
    	//++KienNN fix bug 252
    	//effect is textbox input, does not need change type to date
    	publicNews.setEffect_date(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "effect_date"));
//    	String effDateStr = StructureUtil.getXsdContentArticle(journalArticle.getContent(), "effect_date");
//    	Date effDate = null;
//    	if (effDateStr != null && effDateStr.length() > 0) {
//    		try {
//    			effDate = df.parse(effDateStr);
//    		} catch (ParseException e) {
//    			log.info(e.getMessage());
//    		}
//    		String effectDate = simpleDateFormat.format(effDate);
//    		publicNews.setEffect_date(effectDate);
//    	} else {
//    		publicNews.setEffect_date(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "effect_date"));
//		}
    	//--KienNN fix bug 252
		
    	List<String> file_attach = StructureUtil.getXsdContentArticleList(journalArticle.getContent(), "file_attach");
    	publicNews.setAttachUrlList(file_attach);
    	return publicNews;
	}
	
	/**
	 * Get start to end PublicNews follow search
	 */
	public static List<PublicNews> searchPublicNewsStartToEnd(List<PublicNews> publicNewsListAll, int start, int end) {
		List<PublicNews> publicNewsList = new ArrayList<PublicNews>();
		int maxNumber = publicNewsListAll.size();
		int number = start;
		while (number < end && number < maxNumber) {
			publicNewsList.add(publicNewsListAll.get(number));
			number ++;
		}
		
		return publicNewsList;
	}
	
	/**
	 * Get All PublicNews follow search
	 */
	public static List<PublicNews> searchAllPublicNew(List<PublicNews> publicNewsListAll, Map<String, String> searchConditions) {
		List<PublicNews> publicNewsResult = new ArrayList<PublicNews>();
		
		if (publicNewsListAll != null) {
			for (PublicNews publicNews : publicNewsListAll) {
				if (checkSearchPublicNews(publicNews, searchConditions)) {
					publicNewsResult.add(publicNews);
				}
			}
		}
		return publicNewsResult;
	}
	
	/**
	 * Check PublicNews follow search
	 */
	private static boolean checkSearchPublicNews(PublicNews publicNews, Map<String, String> searchConditions) {
		
		String numberPublicNews 	= searchConditions.get("numberPublicNews");
		String keyPublicNews 		= searchConditions.get("keyPublicNews");
		String yearPublish 			= searchConditions.get("yearPublish");
		String signer 				= searchConditions.get("signer");
		String typePublicNews 		= searchConditions.get("typePublicNews");
		String fieldsPublicNews 	= searchConditions.get("fieldsPublicNews");
		String quote 				= searchConditions.get("quote");
		String publisher 			= searchConditions.get("publisher");
		
		if (!CommonConstants.STRING_0.equalsIgnoreCase(numberPublicNews) && !publicNews.getNumber().equalsIgnoreCase(numberPublicNews)) {
			return false;
		}
		
		if (!StringUtil.isEmpty(publisher) && !CommonConstants.STRING_0.equalsIgnoreCase(publisher)) {
			if (!publisher.equalsIgnoreCase(publicNews.getPublisher())) {
				return false;
			}
		}
		
		if (!searchWithSubText(publicNews.getKey(), keyPublicNews)) {
			return false;
		}
		
		if (!StringUtil.isEmpty(yearPublish) && !CommonConstants.STRING_0.equalsIgnoreCase(yearPublish)) {
			Date date = new Date();
			try {
				date = simpleDateFormat.parse(publicNews.getPublisher_date());
			} catch (ParseException e) {
				log.info(e.getMessage());
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			if (!yearPublish.equals(String.valueOf(year))) {
				return false;
			}
		}
		
		if (!searchWithSubText(publicNews.getSigner(), signer)) {
			return false;
		}
		
		if (!StringUtil.isEmpty(typePublicNews) && !CommonConstants.STRING_0.equalsIgnoreCase(typePublicNews)) {
			if (!typePublicNews.equalsIgnoreCase(publicNews.getType())) {
				return false;
			}
		}
		
		if (!StringUtil.isEmpty(fieldsPublicNews) && !CommonConstants.STRING_0.equalsIgnoreCase(fieldsPublicNews)) {
			if (!fieldsPublicNews.equalsIgnoreCase(publicNews.getFields())) {
				return false;
			}
		}
		
		if (!searchWithSubText(publicNews.getQuote(), quote)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Split full keyword to array subkeyword, then search
	 */
	private static boolean searchWithSubText(String fullText, String keyWord) {
		
		if (StringUtil.isEmpty(keyWord)) {
			return true;
		} 
		
		if (!StringUtil.isEmpty(keyWord) && StringUtil.isEmpty(fullText)) {
			return false;
		}
		
		if (!StringUtil.isEmpty(keyWord) && !StringUtil.isEmpty(fullText)) {
			String[] keyPublicNewsArray = keyWord.split(StringPool.SPACE);
			for (int i = 0; i < keyPublicNewsArray.length; i++) {
				String subKey = keyPublicNewsArray[i];
				if (fullText.toLowerCase().contains(subKey.toLowerCase())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * get All PublicNews Number
	 */
	public static List<Integer> getPublicNewsNumberList(List<JournalArticle> publicNewsLastVersionList) {
		List<Integer> publicNewsNumberList = new ArrayList<Integer>();
		String content;
		String numberString;
		Integer number = 0;
        for (JournalArticle journalArticle : publicNewsLastVersionList) {
        	content = journalArticle.getContent();
        	numberString = StructureUtil.getXsdContentArticle(content, "number");
        	try {
        		number = Integer.parseInt(numberString);
        		if (!publicNewsNumberList.contains(number)) {
        			publicNewsNumberList.add(number);
        		}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
         }
        publicNewsNumberList = sortIntegerList(publicNewsNumberList);
		return publicNewsNumberList;
	}
	
	/**
	 * get MAx PublicNews Number
	 */
	public static int getMaxPublicNewsNumber(List<JournalArticle> publicNewsLastVersionList) {
		int maxNumber = 0;
		String content = null;
		String numberString = null;
		Integer number = 0;
        for (JournalArticle journalArticle : publicNewsLastVersionList) {
        	content = journalArticle.getContent();
        	numberString = StructureUtil.getXsdContentArticle(content, "number");
        	try {
        		number = Integer.parseInt(numberString);
        		if (number > maxNumber) {
        			maxNumber = number;
        		}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
         }
		return maxNumber;
	}
	
	/**
	 * Sorting PublicNews Number list
	 */
	private static List<Integer> sortIntegerList(List<Integer> inputIntegers) {
		for(int i = 0; i < inputIntegers.size() - 1; i ++) {
			int valueMax = inputIntegers.get(i);
			int intdexMax = i;
			for(int j = i+1; j < inputIntegers.size(); j ++) {
				int current = inputIntegers.get(j);
				if (valueMax < current) {
					valueMax = current;
					intdexMax = j;
				}
			}
			if (intdexMax != i) {
				inputIntegers = swapped(inputIntegers, i, intdexMax);
			}
		}
		return inputIntegers;
	}
	
	/**
	 * swapped
	 */
	private static List<Integer> swapped(List<Integer> inputIntegers, int m, int n) {
		int temp = inputIntegers.get(m);
		inputIntegers.set(m, inputIntegers.get(n));
		inputIntegers.set(n, temp);
		return inputIntegers;
	}
}
