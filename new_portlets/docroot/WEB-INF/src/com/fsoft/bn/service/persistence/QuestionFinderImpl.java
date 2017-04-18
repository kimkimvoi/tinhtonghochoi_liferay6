package com.fsoft.bn.service.persistence;

import com.fsoft.bn.model.QuesTestModel;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.impl.QuestionImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;
public class QuestionFinderImpl extends BasePersistenceImpl<Question> implements QuestionFinder {
	public List<Question> searchQuestion(String quesType, String quesSts, String content, int begin, int end) {
		/// This stuff is basic set up
		Session session = null;
		StringBuffer query = new StringBuffer();
		List<Question> result = new ArrayList<Question>();
		try {
			session = openSession();
			// Here ends the basic set up;
			//now we build the query. Note that we use the name of the tables from the database!
			query.append(" SELECT * ");
			query.append(" FROM ");
			query.append(" (SELECT BN_QUESTION.* ");
			query.append(" FROM ");
			query.append(" BN_QUESTION ");
			query.append(" ORDER BY ");
			query.append(" CREATED_DATE ");
			query.append(" DESC)");
//			query.append(" WHERE");
//			query.append(" 		ROWNUMBER > :startIndex ");
//			query.append(" 		AND ROWNUMBER <= :endIndex");


			String sql = query.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("QUESTION", QuestionImpl.class);
			result = (List<Question>) QueryUtil.list(q, getDialect(), 0, 20);
		} catch (Exception e) {
		} finally {
			//must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}

		return result;
	}

	public List<Question> searchQues(String quesType, String quesSts, String content, int begin, int end) {

		return null;
	}


	public List searchContent(String quesType, String quesSts, String content,
			int begin, int end) {
		/// This stuff is basic set up
		Session session = null;
		StringBuffer queryB = new StringBuffer();
		List<QuesTestModel> result = new ArrayList<QuesTestModel>();
		QuesTestModel test = new QuesTestModel();
		try {
			session = openSession();
			// Here ends the basic set up;
			queryB.append(" select ques.question_title as title,ques.question_content as contentQues,ans.answer_content contentAns from ");
			queryB.append(" bn_question ques inner join bn_answer ans");
			queryB.append(" on ques.answer_id = ans.answer_id and ans.answer_id='1'");

			String sql = queryB.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
//            q.addEntity("QUESTION", QuestionImpl.class);
//            q.addEntity("ANSWER", AnswerImpl.class);
			//execute the query and return a list from the db
			result = (List<QuesTestModel>) QueryUtil.list(query, getDialect(), 0, 20);
		} catch (Exception e) {
		} finally {
			closeSession(session);
		}

		return result;
	}

//	public void addScalar(SQLQuery query, Class objClazz) {
//		String sqlQuery = query.getQueryString();
//		int separateIdx = sqlQuery.indexOf("");
//		if (separateIdx >= 0) {
//			sqlQuery = sqlQuery.substring(0, separateIdx);
//		} else {
//			throw new RuntimeException("ADD_SCALAR_MARK (/*select_end*/) has not been added to SQL string.");
//		}
//		List<String> aliases = new ArrayList<String>();
//
//		Pattern pattern = Pattern.compile("\\s+(as|AS)\\s+(\\w+)\\W");
//		Matcher matcher = pattern.matcher(sqlQuery);
//		while (matcher.find()) {
//			aliases.add(matcher.group(2));
//		}
//
//		for (String alias : aliases) {
//			query.addScalar(alias, getHibernateType(alias, objClazz));
//		}
//	}
//
//	private Type getHibernateType(String property, Class clazz) {
//		try {
//			Method method = clazz.getMethod("get" + StringUtils.capitalize(property),
//					(Class[]) null);
//
//			Class fieldClass = method.getReturnType();
//			if (fieldClass.getName().equals(BigDecimal.class.getName())) {
//				return StandardBasicTypes.BIG_DECIMAL;
//
//			} else if (fieldClass.getName().equals(String.class.getName())) {
//				return StandardBasicTypes.STRING;
//
//			} else if (fieldClass.getName().equals(Integer.class.getName())) {
//				return StandardBasicTypes.INTEGER;
//
//			} else if (fieldClass.getName().equals(Date.class.getName())) {
//				return StandardBasicTypes.TIMESTAMP;
//			}
//		} catch (Exception e) {
//
//		}
//		return null;
//	}
}