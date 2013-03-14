package com.job528.sina.weibo;

import org.apache.log4j.Logger;

public class OauthLog {
	
	static Logger log = Logger.getLogger(OauthLog.class.getName());
	
    public static void logDebug(String message) {
			log.debug(message);
	}

	public static void logInfo(String message) {
			log.info(message);
	}
	
	public static void logError(String message, Throwable t) {
		log.error(message, t);
	}


}
