/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fsoft.bn.service.impl;

import java.util.List;

import org.hsqldb.lib.StringUtil;

import com.fsoft.bn.model.Organizations;
import com.fsoft.bn.model.StaffInfo;
import com.fsoft.bn.model.impl.StaffInfoImpl;
import com.fsoft.bn.service.OrganizationsLocalServiceUtil;
import com.fsoft.bn.service.base.StaffInfoLocalServiceBaseImpl;
import com.fsoft.bn.service.persistence.StaffInfoUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the staff info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.service.StaffInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see com.fsoft.bn.service.base.StaffInfoLocalServiceBaseImpl
 * @see com.fsoft.bn.service.StaffInfoLocalServiceUtil
 */
public class StaffInfoLocalServiceImpl extends StaffInfoLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.StaffInfoLocalServiceUtil} to access the staff info local service.
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public List<StaffInfo> updateValueOrganizName(List<StaffInfo> staffInfosList) throws PortalException, SystemException{
		if(staffInfosList != null){
			for(int i = 0; i < staffInfosList.size(); i++){
				long organizationsId = staffInfosList.get(i).getOrganizations_id();
				Organizations organizations = OrganizationsLocalServiceUtil.getOrganizations(organizationsId);
				if(organizations != null){
					staffInfosList.get(i).setOrganizations_name(organizations.getOrganizations_name());
				}
			}
		}
		
		return staffInfosList;
	}
	
	public List<StaffInfo> getAllStaffInfoByDeleted(boolean deleted, int start, int end)
			throws SystemException {
		return StaffInfoUtil.findByDeleted(deleted, start, end);
	}
	
	public int getAllStaffInfoByDeletedCount(boolean deleted) throws SystemException {
		
		List<StaffInfo> staffInfos = StaffInfoUtil.findByDeleted(deleted);
		if(staffInfos == null){
			return 0;
		}
		return staffInfos.size();
	}

	public List<StaffInfo> searchStaffInfo(String content, String typeSearch,
			long organization, int begin, int end) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StaffInfoImpl.class).add(PropertyFactoryUtil.forName("deleted").eq(false));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		if (organization > 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("organizations_id", organization));
		}
		if(!StringUtil.isEmpty(content)){
			content = "%" + content + "%";
			if("All".equals(typeSearch)){
				junction.add(RestrictionsFactoryUtil.ilike("staff_role", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_phone", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_email", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_firstname", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_middlename", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_lastname", content));
			}else if ("Role".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_role", content));
			} else if ("Phone".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_phone", content));
			} else if ("Email".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_email", content));
			} else if ("Name".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_firstname", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_middlename", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_lastname", content));
			}
		}
		dynamicQuery.add(junction);
		List<StaffInfo> staffInfosList = StaffInfoUtil.findWithDynamicQuery(dynamicQuery, begin, end);
		return staffInfosList;
		//return StaffInfoFinderUtil.searchStaffInfo(content, typeSearch, organization, begin, end);
	}

	public int countResultSearchStaffInfo(String content, String typeSearch,
			long organization) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StaffInfoImpl.class).add(PropertyFactoryUtil.forName("deleted").eq(false));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		if (organization > 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("organizations_id", organization));
		}
		if(!StringUtil.isEmpty(content)){
			content = "%" + content + "%";
			if("All".equals(typeSearch)){
				junction.add(RestrictionsFactoryUtil.ilike("staff_role", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_phone", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_email", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_firstname", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_middlename", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_lastname", content));
			}else if ("Role".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_role", content));
			} else if ("Phone".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_phone", content));
			} else if ("Email".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_email", content));
			} else if ("Name".equals(typeSearch)) {
				junction.add(RestrictionsFactoryUtil.ilike("staff_firstname", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_middlename", content));
				junction.add(RestrictionsFactoryUtil.ilike("staff_lastname", content));
			}
		}
		dynamicQuery.add(junction);
		List<StaffInfo> staffInfosList = StaffInfoUtil.findWithDynamicQuery(dynamicQuery);
		if (staffInfosList == null) {
			return 0;
		}

		return staffInfosList.size();
		//return StaffInfoFinderUtil.countResultSearchStaffInfo(content, typeSearch, organization);
	}
	
	
}