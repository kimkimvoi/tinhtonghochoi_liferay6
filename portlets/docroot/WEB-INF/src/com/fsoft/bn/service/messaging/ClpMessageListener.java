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

package com.fsoft.bn.service.messaging;

import com.fsoft.bn.service.AnswerAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.AnswerLocalServiceUtil;
import com.fsoft.bn.service.BNContactLocalServiceUtil;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.service.BNJournalArticleServiceUtil;
import com.fsoft.bn.service.BNNewsLocalServiceUtil;
import com.fsoft.bn.service.ClpSerializer;
import com.fsoft.bn.service.InvestmentProjectsLocalServiceUtil;
import com.fsoft.bn.service.InvestmentProjectsServiceUtil;
import com.fsoft.bn.service.OrganizationsLocalServiceUtil;
import com.fsoft.bn.service.QuestionAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.service.ScheduleLocalServiceUtil;
import com.fsoft.bn.service.StaffInfoLocalServiceUtil;
import com.fsoft.bn.service.UserScheduleLocalServiceUtil;
import com.fsoft.bn.service.UserfulContactPhoneLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AnswerLocalServiceUtil.clearService();

			AnswerAttachedFileLocalServiceUtil.clearService();

			BNContactLocalServiceUtil.clearService();

			BNJournalArticleLocalServiceUtil.clearService();

			BNJournalArticleServiceUtil.clearService();
			BNNewsLocalServiceUtil.clearService();

			InvestmentProjectsLocalServiceUtil.clearService();

			InvestmentProjectsServiceUtil.clearService();
			OrganizationsLocalServiceUtil.clearService();

			QuestionLocalServiceUtil.clearService();

			QuestionAttachedFileLocalServiceUtil.clearService();

			ScheduleLocalServiceUtil.clearService();

			StaffInfoLocalServiceUtil.clearService();

			UserfulContactPhoneLocalServiceUtil.clearService();

			UserScheduleLocalServiceUtil.clearService();
		}
	}
}