package com.job528.util.config;

import java.util.ResourceBundle;

import com.job528.util.log.MyLog;


/**
 * 解析全局配置文件即:src/config/spring/jdbc.properties
 * 
 * @author 
 * 
 */
public class ConfigUtil {

    private static ResourceBundle rb = null;
    private static final MyLog log = MyLog.getLogger(ConfigUtil.class);
    /*
     * refactor
     */
    private static final String CONFIG_FILE = "spring.jdbc";
    
    static {
        try {
            rb = ResourceBundle.getBundle(CONFIG_FILE);
        } catch (Exception e) {
        	log.error(e);
        }
    }

    /**
     * 根据配置文件中的 Key 返回 Value
     * 
     * @param key
     *            String
     * @return String
     */
    public static String getResourceByKey(String key) {
        String value = null;
        try {
            //value = ParamServiceImpl.getInstance().getConfValue(rb.getString(key));
        } catch (Exception e) {
        	log.error(e);
        }
        return value;
    }
}
