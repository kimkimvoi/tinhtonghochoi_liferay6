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

/**
 * The extended model implementation for the BNNews service. Represents a row in the &quot;BN_BNNews&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.model.BNNews} interface.
 * </p>
 *
 * @author YenMC
 */
public class BNNewsImpl extends BNNewsBaseImpl {
	/**
	 *
	 */
	private static final long serialVersionUID = 7213560662041235923L;

	// TODO: add additional method to model other than auto-generated field getters and setters

	// constructor
	public BNNewsImpl() {

	}
	// add new properties
	private String dateToString;


	// getter and setter
	public String getDateToString() {
		return dateToString;
	}

	public void setDateToString(String dateToString) {
		this.dateToString = dateToString;
	}
}