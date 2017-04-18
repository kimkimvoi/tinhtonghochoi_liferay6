package com.fsoft.bn.domain.news;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;

public class Config {
	
	private static final String PREF_SEPARATOR = StringUtils.repeat(StringPool.COMMA, 3);
	protected static final Logger logger = Logger.getLogger(Config.class);
	protected boolean configured;
	protected PortletPreferences prefs;

	public Config() {
		super();
	}

	public Config(PortletRequest req) {
		prefs = PortalUtil.getPortletPreferences(req);
		if (prefs.getMap().isEmpty()) {
			return;
		}
		configured = true;
	}

	protected KeyValuePair toKeyValue(String paramName) {
		List<KeyValuePair> keyValueList = toKeyValueList(paramName);
		if (CollectionUtils.isNotEmpty(keyValueList)) {
			return keyValueList.get(0);
		}
		return null;
	}

	protected List<KeyValuePair> toKeyValueList(String prefPropKey) {
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();
		String rawValue = prefs.getValue(prefPropKey, StringUtils.EMPTY);
		if (StringUtils.isBlank(rawValue)) {
			return list;
		}
		String[] value = rawValue.split(PREF_SEPARATOR);
		for (String s : value) {
			KeyValuePair pair = new KeyValuePair(s.substring(0, s.indexOf(StringPool.COLON)), s.substring(s.indexOf(StringPool.COLON) + 1));
			list.add(pair);
		}
		return list;
	}

	protected List<String> toStringList(String prefPropKey) {
		String rawValue = prefs.getValue(prefPropKey, StringUtils.EMPTY);

		if (StringUtils.isBlank(rawValue)) {
			return new ArrayList<String>();
		}

		String[] values = rawValue.split(PREF_SEPARATOR);

		return new ArrayList<String>(Arrays.asList(values));
	}

	/**
	 * will get value from two parallel params .eg: key : key1, key2, key3, etc. and value : value1, value2, value2
	 */
	protected String parallelParams2Pref(ActionRequest actionRequest, String param1, String param2) {
		List<String> names = new ArrayList<String>();
		List<String> types = new ArrayList<String>();
		SortedMap<String, String[]> sortedMap = new TreeMap<String, String[]>(actionRequest.getParameterMap());

		for (Entry<String, String[]> entry : sortedMap.entrySet()) {
			String key = entry.getKey();
			if (key.contains(param1)) {
				names.add(entry.getValue()[0]);
			} else if (key.contains(param2)) {
				types.add(entry.getValue()[0]);
			}
		}

		String prefsValues = "";
		for (int i = 0; i < names.size(); i++) {
			if (i == 0) {
				prefsValues = prefsValues + names.get(i) + StringPool.COLON + types.get(i);
			} else {
				prefsValues = PREF_SEPARATOR + prefsValues + names.get(i) + StringPool.COLON + types.get(i);
			}
		}
		return prefsValues;
	}

	protected String StringList2Pref(List<String> list) {
		String prefString = "";
		boolean first = true;

		for (String t : list) {
			if (first) {
				prefString = t;
				first = false;
			} else {
				prefString += PREF_SEPARATOR + t;
			}
		}
		return prefString;
	}

	protected <T extends KeyValuePair> String KVList2Pref(List<T> list) {
		String prefString = "";
		boolean first = true;

		for (T t : list) {
			if (first) {
				prefString = KVtoPref(t);
				first = false;
			} else {
				prefString += PREF_SEPARATOR + KVtoPref(t);
			}
		}
		return prefString;
	}

	protected <T extends KeyValuePair> String KVtoPref(T t) {
		return t.getKey() + StringPool.COLON + t.getValue();
	}

	@Override
	public String toString() {
		return "Config [configured=" + configured + ", prefs=" + prefs + "]";
	}

}