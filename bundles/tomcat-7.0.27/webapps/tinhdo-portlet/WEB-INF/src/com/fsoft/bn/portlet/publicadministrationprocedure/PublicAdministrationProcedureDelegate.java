package com.fsoft.bn.portlet.publicadministrationprocedure;

import java.util.ArrayList;
import java.util.List;

import org.hsqldb.lib.StringUtil;

import com.fsoft.bn.domain.PublicAdministrationProcedure;

public class PublicAdministrationProcedureDelegate {
	
	public static List<PublicAdministrationProcedure> searchAllPublicProcedure(List<PublicAdministrationProcedure> publicAdministrationProcedures, 
			String publicFields, String publicOrganization, String levelProcedure, String txtKeySearch){
		List<PublicAdministrationProcedure> procedures = new ArrayList<PublicAdministrationProcedure>();	
		if(publicAdministrationProcedures != null){
			for (PublicAdministrationProcedure publicAdministrationProcedure : publicAdministrationProcedures) {
				if(checkSearch(publicAdministrationProcedure, publicFields, publicOrganization, levelProcedure, txtKeySearch)){
					procedures.add(publicAdministrationProcedure);
				}
			}
		}
		return procedures;
	}
	
	public static boolean checkSearch(PublicAdministrationProcedure administrationProcedure, 
			String publicFields, String publicOrganization, String levelProcedure, String txtKeySearch) {
		boolean flag = true;
		if(!StringUtil.isEmpty(publicFields) && !"0".equalsIgnoreCase(publicFields)){
			if(!publicFields.equalsIgnoreCase(administrationProcedure.getFields())){
				flag = false;
			}
		}
		
		if(!StringUtil.isEmpty(publicOrganization)&& !"0".equalsIgnoreCase(publicOrganization)){
			if(!publicOrganization.equalsIgnoreCase(administrationProcedure.getOrganizations())){
				flag = false;
			}
		}
		
		if(!StringUtil.isEmpty(levelProcedure)&& !"0".equalsIgnoreCase(levelProcedure)){
			if(!levelProcedure.equalsIgnoreCase(administrationProcedure.getLevel())){
				flag = false;
			}
		}
		
		// keys search
		if(!searchWithSubText(administrationProcedure, txtKeySearch)){
			flag = false;
		}	
		return flag;
	}
	
	public static boolean searchWithSubText(PublicAdministrationProcedure administrationProcedure, String keyWord){
		if (StringUtil.isEmpty(keyWord)) {
			return true;
		}
		
		return isContainInField(administrationProcedure.getTitle(), keyWord);
	}
	
	public static boolean isContainInField(String fullText, String keyWord) {
		String subKey = "";
		if(!StringUtil.isEmpty(fullText)) {
			String[] keyPublicNewsArray = keyWord.split(" ");
			for(int i = 0; i < keyPublicNewsArray.length; i++){
				subKey = keyPublicNewsArray[i];
				if(!(fullText.toLowerCase().contains(subKey.toLowerCase()))){
					return false;
				}
			}
		}
		
		return true;
	}
	
}
