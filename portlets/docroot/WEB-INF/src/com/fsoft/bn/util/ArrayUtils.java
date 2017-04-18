package com.fsoft.bn.util;


public class ArrayUtils extends org.apache.commons.lang.ArrayUtils {

	public static long[] toLong(String[] input) {
		if (input == null || input.length == 0 ){
			return null;
		}
		long[] output = new long[input.length];

		for (int i = 0; i < input.length; i++) {
			output[i] = Long.parseLong(input[i]);
		}
		return output;
	}
}
