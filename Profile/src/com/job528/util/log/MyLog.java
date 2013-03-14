package com.job528.util.log;

import org.apache.log4j.Logger;

public class MyLog{
	private static Logger dbLogger = Logger.getLogger("dataBase");
    private static Logger defLogger = null;
    private String className = null;
    protected MyLog(Class<?> clazz) {
        className = clazz.getName();
        setDefLogger(Logger.getLogger(clazz));
    } 
    public static MyLog getLogger(Class<?> clazz){
        MyLog log = new MyLog(clazz);
        return log;
    }
    public void debug(Object message) {
        defLogger.debug(message);
    }
    public void debug(Object message,Throwable t) {
        defLogger.debug(message,t);
    }
    
    public void info(Object message) {
        defLogger.info(message);
    }
    public void info(Object message,Throwable t) {
        defLogger.info(message,t);
    }
    public void error(Object message) {
        defLogger.error(message);
    }
    public void error(Object message,Throwable t) {
        defLogger.error(message,t);
    }
    
    public void warn(Object message) {
        defLogger.warn(message);
    }
    public void warn(Object message,Throwable t) {
        defLogger.warn(message,t);
    }
    
    public void fatal(Object message) {
        defLogger.fatal(message);
    }
    public void fatal(Object message,Throwable t) {
        defLogger.fatal(message,t);
    }
    public void db(Object message){
        dbLogger.log(LoggerLevel.DB, "["+className+"]-"+message);
    }
    public void db(Object message,Throwable t){
        dbLogger.log(LoggerLevel.DB, "["+className+"]-"+message, t);
    }
    public static void setDefLogger(Logger defLogger) {
        MyLog.defLogger = defLogger;
    }
    public static Logger getDefLogger() {
        return defLogger;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
