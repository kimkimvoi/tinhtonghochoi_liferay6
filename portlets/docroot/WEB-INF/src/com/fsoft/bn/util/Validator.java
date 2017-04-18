package com.fsoft.bn.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
public class Validator {

	public static boolean isBlankOrNull(Object obj) {
		if (obj instanceof String) {
			String strObj = (String) obj;
			if (null == strObj || "".equals(strObj.trim()) || "null".equalsIgnoreCase(strObj) || "undefined".equalsIgnoreCase(strObj)) {
				return true;
			}
		}

		if (obj instanceof List) {
			@SuppressWarnings("rawtypes")
			List listObj = (List) obj;
			if (null == listObj || listObj.isEmpty()) {
				return true;
			}
		}

		if (obj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map mapObj = (Map) obj;
			if (null == mapObj || mapObj.isEmpty()) {
				return true;
			}
		}

		if (obj instanceof Set) {
			@SuppressWarnings("rawtypes")
			Set setObj = (Set) obj;
			if (null == setObj || setObj.isEmpty()) {
				return true;
			}
		}

		if (null == obj) {
			return true;
		}

		return false;
	}
}