package com.fsoft.bn.portlet.operatorsteering;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.RequestMeeting;
import com.fsoft.bn.domain.Structure;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class OperatorSteeringDelegate {
	private static final String TITLE_NAME_STRUCTURE = ".title";
	private static final String TITLE_PORTLET_HEADER = ".portlet.header";
	private static final String STRUCTURE_KEY_NAME_REQUEST_MEETING = "portal.structure.name.request_meeting";
	private static final String STRUCTURE_KEY_NAME_ADMINISTRATIVE_PENALTY = "portal.structure.name.administrative_penalty";
	
	/**
	 * get operator Steering start to end
	 */
	public static List<Object> getObjectsStartToEnd(PortletRequest request, String structureId, List<JournalArticle> journalArticleLastVersionList, int start, int end) {
		List<Object> operatorSteeringList = null;
		List<JournalArticle> journalArticlesList = new ArrayList<JournalArticle>();
		int maxNumber = journalArticleLastVersionList.size();
		int number = start;
		while(number < end && number < maxNumber){
			journalArticlesList.add(journalArticleLastVersionList.get(number));
			number ++;
		}
		
		operatorSteeringList = convertArticleToOperatorSteering(request, 
				journalArticlesList, structureId, CommonConstants.OPERATOR_STEERING_STRUCTURE_NAME);
       
		return operatorSteeringList;
	}
	
	/**
	 * 	List header in view
	 * */
	public static List<String> getHeaderInViewList(Structure operatorSteeringStructure, RenderRequest renderRequest){
		List<String> headersList = new ArrayList<String>();
		
		//get keyname choosed
		String keyname = operatorSteeringStructure.getKeyName();
		
		if(STRUCTURE_KEY_NAME_REQUEST_MEETING.equals(keyname)){
			headersList = CommonUtil.getHeaderList(renderRequest, CommonConstants.requestMeetingListHeaderKeys);
		}
		
		return headersList;
	}
	
	/**
	 * Get name structure by id
	 * */
	public static Structure getStructureNameById(PortletRequest request, String id, String[] keyNameArray){
		String structureId = null;
		String keyName = null;
		String nameCurrent = null;
		String keyNameDisplay = null;
		String keyPortletHeaderDisplay = null;
		Structure operatorSteeringStructure = new Structure();
		for(int i = 0; i < keyNameArray.length; i++){
			keyName = keyNameArray[i];
			keyNameDisplay = keyName + TITLE_NAME_STRUCTURE;
			nameCurrent = CommonUtil.getText(request, keyName);
			structureId = StructureUtil.getStructureId(nameCurrent);
			keyPortletHeaderDisplay = keyName + TITLE_PORTLET_HEADER;
			
			if(id.equals(structureId)){
				operatorSteeringStructure.setId(structureId);
				operatorSteeringStructure.setName(nameCurrent);
				operatorSteeringStructure.setKeyName(keyName);
				operatorSteeringStructure.setKeyNameDisplay(keyNameDisplay);
				operatorSteeringStructure.setKeyPortletHeaderDisplay(keyPortletHeaderDisplay);
			}
		}
		return operatorSteeringStructure;
	}
	
	/**
	 * Get List structure
	 * */
	public static List<Structure> getStructureNameList(PortletRequest request, String[] keyNameArray){
		List<Structure> operatorSteeringStructures = new ArrayList<Structure>();
		Structure operatorSteeringStructure = null;
		String keyName = null;
		String keyNameDisplay = null;
		String name = null;
		String structureId = null;
		String keyPortletHeaderDisplay = null;
				
		for(int i = 0; i < keyNameArray.length; i++){
			operatorSteeringStructure = new Structure();
			keyName = keyNameArray[i];
			keyNameDisplay = keyName + TITLE_NAME_STRUCTURE;
			name = CommonUtil.getText(request, keyName);
			structureId = StructureUtil.getStructureId(name);
			keyPortletHeaderDisplay = keyName + TITLE_PORTLET_HEADER;
			
			operatorSteeringStructure.setId(structureId);
			operatorSteeringStructure.setName(name);
			operatorSteeringStructure.setKeyName(keyName);
			operatorSteeringStructure.setKeyNameDisplay(keyNameDisplay);
			operatorSteeringStructure.setKeyPortletHeaderDisplay(keyPortletHeaderDisplay);
			
			operatorSteeringStructures.add(operatorSteeringStructure);
		}
		return operatorSteeringStructures;
	}
	
	/**
	 * convert Article to OperatorSteering Delegate 
	 */
	public static List<Object> convertArticleToOperatorSteering(PortletRequest request, List<JournalArticle> journalArticleList, String structureIdChoosed, String[] structureNameArray){
		List<Object> operatorSteerings = null;
		
		//get list structure
		List<Structure> operatorSteeringStructures = OperatorSteeringDelegate.getStructureNameList(request, CommonConstants.OPERATOR_STEERING_STRUCTURE_NAME);
		
		operatorSteerings = delegateOperatorSteeringtoChildren(journalArticleList, operatorSteeringStructures, structureIdChoosed);
		
		return operatorSteerings;
	} 
	
	/**
	 * convert Article to RequestMeeting
	 */
	public static List<Object> convertArticleToRequestMeeting(List<JournalArticle> journalArticleList){
		List<Object> requestMeetingsList = new ArrayList<Object>();
		RequestMeeting requestMeeting = null;
		for (JournalArticle journalArticle : journalArticleList) {
			requestMeeting = new RequestMeeting();
			requestMeeting.setId(journalArticle.getArticleId());
			requestMeeting.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
			requestMeeting.setCreate_date(journalArticle.getCreateDate());
			requestMeeting.setRequestMeetingPlate(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "plate"));
			requestMeeting.setRequestMeetingOperator(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "operator"));
			requestMeeting.setRequestMeetingAttended(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "attended"));
			requestMeeting.setSummary(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "summary"));
			requestMeeting.setTimeStart(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "time_start"));
			requestMeeting.setTimeEnd(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "time_end"));
			requestMeeting.setContent(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "content"));
			
	    	List<String> fileAttach = StructureUtil.getXsdContentArticleList(journalArticle.getContent(), "attach_file");
	    	requestMeeting.setAttachUrlList(fileAttach);
	    	requestMeetingsList.add(requestMeeting);
		}
    	return requestMeetingsList;
	}
	
	/**
	 * Delegate OperatorSteering to Children
	 */
	private static List<Object> delegateOperatorSteeringtoChildren(List<JournalArticle> journalArticleList, List<Structure> operatorSteeringStructures, String structureIdChoosed){
		List<Object> operatorSteeringsList = new ArrayList<Object>();
		if(operatorSteeringStructures == null){
			return new ArrayList<Object>();
		}
		
		//get keyname choosed
		String keyname = "";
		for(Structure steeringStructure : operatorSteeringStructures){
			if(steeringStructure.getId().equals(structureIdChoosed)){
				keyname = steeringStructure.getKeyName();
			}
		}
		
		//Delegate Convert Object
		if(STRUCTURE_KEY_NAME_REQUEST_MEETING.equals(keyname)){
			operatorSteeringsList = convertArticleToRequestMeeting(journalArticleList);
		}
		
		return operatorSteeringsList;
	}
	
	
}
