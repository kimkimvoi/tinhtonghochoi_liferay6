package com.fsoft.bn.util;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.model.impl.AnswerModelImpl;

/**
 * @author ThangBN1
 * @version 1.1
 * @since 11/18/2013
 **/

public class BeanConverterUtil {
	/** logger */
	private static Logger logger = Logger.getLogger(BeanConverterUtil.class);
	public static final String[][] SAMPLE_MAP = new String[][] { {
			// {source field, target field}
			"_answer_id", "articleId" }, };

	public static final Object[][] CONVERTER_MAP = new Object[][] {
	// {source class, target class, converter properties map}
	{ AnswerModelImpl.class, News.class, SAMPLE_MAP } };
	
	
	public static final String[][] JOURNAL_2_STRUCT = new String[][] { {
		// {source field, target field}
		"_answer_id", "articleId" }, };

	/**
	 * Convert from one object to another object, in order to made it work, user must define class-to-class mapping in CONVERTER_MAP map
	 * object
	 * @param source : source object
	 * @param target : target object
	 * @exception RuntimeException throw if class-to-class mapping is not found
	 */
	public static <SOURCE, TARGET> void convert(SOURCE source, TARGET target) {
		Class<? extends Object> sourceClassName = source.getClass();
		Class<? extends Object> targetClassName = target.getClass();
		String[][] mapping = null;

		for (int i = 0; i < CONVERTER_MAP.length; i++) {
			if ((Class<?>) CONVERTER_MAP[i][0] == sourceClassName) {

				if ((Class<?>) CONVERTER_MAP[i][1] == targetClassName) {
					mapping = (String[][]) CONVERTER_MAP[i][2];
				}
			}
		}
		if (mapping == null) {
			throw new RuntimeException("Can not find mapping for source type" + source.getClass().getCanonicalName() + " : target type"
					+ target.getClass().getCanonicalName());
		}

		convert(source, target, mapping);
	}
	
	/**
	 * Convert from one object to another object
	 * object
	 * @param source : source object
	 * @param target : target object
	 * @exception RuntimeException throw if class-to-class mapping is not found
	 */
	public static <SOURCE, TARGET> void convert(SOURCE source, TARGET target, String[][] mapping) {
		for (int i = 0; i < mapping.length; i++) {
			try {
				Field sourceField = source.getClass().getDeclaredField(mapping[i][0]);
				sourceField.setAccessible(true);

				Field targetField = target.getClass().getDeclaredField(mapping[i][1]);
				targetField.setAccessible(true);
				targetField.set(target, sourceField.get(source));

			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		AnswerModelImpl source = new AnswerModelImpl();
		source.setAnswer_id("dasda");

		News target = new News();
		convert(source, target);

		System.out.println("");
	}
}
