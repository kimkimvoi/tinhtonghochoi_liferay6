/**
 *
 */
package com.fsoft.bn.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @author YenMC
 *
 */
public class LoginPreAction extends Action {

	@Override
	public void run(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ActionException {
		logging.info("============== override login pre-action================");
	}

	private static Logger logging = Logger.getLogger(com.fsoft.bn.hook.LoginPreAction.class);
}