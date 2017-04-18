package com.fsoft.bn.util;

import java.util.List;

import org.apache.commons.collections.Predicate;

public class ListUtils extends org.apache.commons.collections.ListUtils {

	public static int locate(List list, Predicate predicate) {

		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			if (!predicate.evaluate(object)) {
				continue;
			}
			return i;
		}
		return -1;
	}

	public static String[] toArray(List<String> input) {
		String[] output = new String[input.size()];
		input.toArray(output);
		return output;
	}
}
