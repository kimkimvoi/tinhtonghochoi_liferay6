package com.fsoft.bn.service.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.UserScheduleModel;
import com.fsoft.bn.model.Schedule;
import com.fsoft.bn.model.impl.ScheduleImpl;
import com.fsoft.bn.model.impl.UserScheduleImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ScheduleFinderImpl extends BasePersistenceImpl implements
		ScheduleFinder {
	/** logger */
	private static Logger logger = Logger.getLogger(ScheduleFinderImpl.class);
	public List<User> findUserByUserId(String jobTitle) throws Exception {
		List<User> users = new ArrayList<User>();
		Session session = null;
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" SELECT u.*, j.* from user_ u join BN_USERSCHEDULE j on j.user_id = u.userid ");

		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sqlStr.toString());
			query.addEntity("User_", PortalClassLoaderUtil.getClassLoader()
					.loadClass("com.liferay.portal.model.impl.UserImpl"));
			QueryPos qPos = QueryPos.getInstance(query);
			List objectListUser = (List) query.list();
			QueryPos objectList = null;
			objectList.add(objectListUser);
			session = openSession();
			query = session.createSQLQuery(sqlStr.toString());
			query.addEntity("JobTitle", UserScheduleImpl.class);
			qPos = QueryPos.getInstance(query);
			users = query.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;

		} finally {
			closeSession(session);
		}

		return users;
	}
	
	public List<UserScheduleModel> findActiveUserSchedule() {
		/// This stuff is basic set up
        Session session = null;
        StringBuffer sqlStr = new StringBuffer();
        List<UserScheduleModel> result = new ArrayList<UserScheduleModel>();
        try {
            session = openSession();
        	sqlStr.append(" SELECT u.userid as userId, CONCAT(u.firstname, CONCAT(CONCAT(' ', u.middlename), COALESCE(CONCAT(' ', u.lastname), ''))) as userName, u.jobtitle as jobTitleName from user_ u join BN_USERSCHEDULE j on j.user_id = u.userid ");
            
        	SQLQuery query = session.createSQLQuery(sqlStr.toString());
            query.setCacheable(false);
            query.addScalar("userId", Type.STRING);
            query.addScalar("userName", Type.STRING);
            query.addScalar("jobTitleName", Type.STRING);
            
            List<Object[]> lst = (List<Object[]>)QueryUtil.list(query, getDialect(), 0, 20);
            result = assembleUserSchedule(lst);
            return result;
        } catch (Exception e) {
        } finally {
            closeSession(session);
        }
		return result;
	}
	
	public List<UserScheduleModel> findActiveUserSchedule(long userId) {
        Session session = null;
        StringBuffer sqlStr = new StringBuffer();
        List<UserScheduleModel> result = new ArrayList<UserScheduleModel>();
        try {
            session = openSession();
        	sqlStr.append(" SELECT u.userid as userId, CONCAT(u.firstname, CONCAT(CONCAT(' ', u.middlename), COALESCE(CONCAT(' ', u.lastname), ''))) as userName, u.jobtitle as jobTitleName from user_ u join BN_USERSCHEDULE j on j.user_id = u.userid where u.userid = ? ");
            
        	SQLQuery query = session.createSQLQuery(sqlStr.toString());
            query.setCacheable(false);
            query.addScalar("userId", Type.STRING);
            query.addScalar("userName", Type.STRING);
            query.addScalar("jobTitleName", Type.STRING);
            QueryPos qPos = QueryPos.getInstance(query);
            qPos.add(userId);
            
            List<Object[]> lst = (List<Object[]>)QueryUtil.list(query, getDialect(), 0, 20);
            result = assembleUserSchedule(lst);
            return result;
        } catch (Exception e) {
        } finally {
            closeSession(session);
        }
		return result;
	}
	
	public List<Schedule> findSchedule(String userId, Date date) {
		Session session = null;
        StringBuffer sqlStr = new StringBuffer();
        List<Schedule> result = new ArrayList<Schedule>();
        try {
            session = openSession();
        	sqlStr.append(" select * from bn_schedule where user_id = ? and date_ = ? ");
            
        	SQLQuery query = session.createSQLQuery(sqlStr.toString());
            QueryPos qPos = QueryPos.getInstance(query);
            qPos.add(userId);
            qPos.add(date);
            
            List<Object[]> lst = (List<Object[]>)QueryUtil.list(query, getDialect(), 0, 20);
            result = assembleSchedule(lst);
            return result;
        } catch (Exception e) {
        } finally {
            closeSession(session);
        }
		return result;
	}
	
	private List<UserScheduleModel> assembleUserSchedule(List<Object[]> lst) {
		List<UserScheduleModel> userSchedules = new ArrayList<UserScheduleModel>();
        for (Object[] obj: lst) {
        	UserScheduleModel u = new UserScheduleModel();
            u.setUserId((String) (null == obj[0] ? StringPool.BLANK : obj[0]));
            u.setUserName((String) (null == obj[1] ? StringPool.BLANK : obj[1]));
            u.setJobTitleName((String) (null == obj[2] ? StringPool.BLANK : obj[2]));
            userSchedules.add(u);
        }
        return userSchedules;
    }
	
	private List<Schedule> assembleSchedule(List<Object[]> lst) {
		List<Schedule> schedules = new ArrayList<Schedule>();
		for (Object[] obj: lst) {
			Schedule s = new ScheduleImpl();
			s.setSchedule_id((String) (null == obj[0] ? StringPool.BLANK : obj[0]));
			s.setSchedule_date((Date) (null == obj[1] ? StringPool.BLANK : obj[1]));
			s.setContent((String) (null == obj[2] ? StringPool.BLANK : obj[2]));
			s.setUser_id((String) (null == obj[3] ? StringPool.BLANK : obj[3]));
			s.setCreated_date((Date) (null == obj[4] ? StringPool.BLANK : obj[4]));
			s.setModified_date((Date) (null == obj[5] ? StringPool.BLANK : obj[5]));
			s.setDeleted((Boolean) (null == obj[6] ? StringPool.BLANK : obj[6]));
			schedules.add(s);
		}
		return schedules;
	}

}
