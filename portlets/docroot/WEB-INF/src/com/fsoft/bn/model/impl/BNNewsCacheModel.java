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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.BNNews;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing BNNews in entity cache.
 *
 * @author FSOFT
 * @see BNNews
 * @generated
 */
public class BNNewsCacheModel implements CacheModel<BNNews>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{newsId=");
		sb.append(newsId);
		sb.append(", newsTitle=");
		sb.append(newsTitle);
		sb.append(", newsContent=");
		sb.append(newsContent);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public BNNews toEntityModel() {
		BNNewsImpl bnNewsImpl = new BNNewsImpl();

		bnNewsImpl.setNewsId(newsId);

		if (newsTitle == null) {
			bnNewsImpl.setNewsTitle(StringPool.BLANK);
		}
		else {
			bnNewsImpl.setNewsTitle(newsTitle);
		}

		if (newsContent == null) {
			bnNewsImpl.setNewsContent(StringPool.BLANK);
		}
		else {
			bnNewsImpl.setNewsContent(newsContent);
		}

		if (createdDate == Long.MIN_VALUE) {
			bnNewsImpl.setCreatedDate(null);
		}
		else {
			bnNewsImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bnNewsImpl.setModifiedDate(null);
		}
		else {
			bnNewsImpl.setModifiedDate(new Date(modifiedDate));
		}

		bnNewsImpl.setDeleted(deleted);

		bnNewsImpl.resetOriginalValues();

		return bnNewsImpl;
	}

	public long newsId;
	public String newsTitle;
	public String newsContent;
	public long createdDate;
	public long modifiedDate;
	public boolean deleted;
}