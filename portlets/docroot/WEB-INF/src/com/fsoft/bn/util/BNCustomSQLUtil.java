package com.fsoft.bn.util;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;

public class BNCustomSQLUtil {

	public static String getOrderby(List<KeyValuePair> orderBys) {
		String orderStr = StringUtils.EMPTY;
		boolean first = true;
		for (KeyValuePair order : orderBys) {
			if (first) {
				first = false;
				orderStr = order.getKey() + StringPool.SPACE + order.getValue();
			} else {
				orderStr += StringPool.COMMA + order.getKey() + StringPool.SPACE + order.getValue();
			}
		}

		return orderStr;
	}

	public static int getCount(SQLQuery q) {
		Iterator<Long> itr = q.iterate();
		if (itr.hasNext()) {
			Long count = itr.next();
	
			if (count != null) {
				return count.intValue();
			}
		}
		return 0;
	}
}
