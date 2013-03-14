package com.job528.invite;

import com.job528.invite.email.HotmailImporter;
import com.job528.invite.email.OneEightNineImporter;
import com.job528.invite.email.OneSixThreeImporter;
import com.job528.invite.email.OneThreeNineImporter;
import com.job528.invite.email.OneTwoSixImporter;
import com.job528.invite.email.SinaImporter;
import com.job528.invite.email.SohuImporter;
import com.job528.invite.email.TomImporter;
import com.job528.invite.email.YahooImporter;
import com.job528.invite.email.YeahImporter;
import com.job528.invite.google.GoogleImporter;

/**
 * ContactsImporter工厂类
 * 
 * @author flyerhzm
 * 
 */
public class ContactsImporterFactory {

	/**
	 * 获取Hotmail Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return Hotmail Importer实例
	 */
	public static ContactsImporter getHotmailContacts(String email,
			String password) {
		return new HotmailImporter(email, password);
	}

	/**
	 * 获取Gmail Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return Gmail Importer实例
	 */
	public static ContactsImporter getGmailContacts(String email,
			String password) {
		return new GoogleImporter(email, password);
	}

	/**
	 * 获取Yahoo Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return Yahoo Importer实例
	 */
	public static ContactsImporter getYahooContacts(String email,
			String password) {
		return new YahooImporter(email, password);
	}

	/**
	 * 获取163 Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return 163 Importer实例
	 */
	public static ContactsImporter getOneSixThreeContacts(String email,
			String password) {
		return new OneSixThreeImporter(email, password);
	}

	/**
	 * 获取126 Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return 126 Importer实例
	 */
	public static ContactsImporter getOneTwoSixContacts(String email,
			String password) {
		return new OneTwoSixImporter(email, password);
	}

	/**
	 * 获取sina Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return sina Importer实例
	 */
	public static ContactsImporter getSinaContacts(String email, String password) {
		return new SinaImporter(email, password);
	}

	/**
	 * 获取sohu Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return sohu Importer实例
	 */
	public static ContactsImporter getSohuContacts(String email, String password) {
		return new SohuImporter(email, password);
	}

	/**
	 * 获取tom Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return tom Importer实例
	 */
	public static ContactsImporter getTomContacts(String email, String password) {
		return new TomImporter(email, password);
	}

	/**
	 * 获取yeah Importer实例
	 * 
	 * @param email
	 *            email地址
	 * @param password
	 *            密码
	 * @return yeah Importer实例
	 */
	public static ContactsImporter getYeahContacts(String email, String password) {
		return new YeahImporter(email, password);
	}

    /**
     * 获取189 Importer实例
     *
     * @param email
     *            email地址
     * @param password
     *            密码
     * @return 189 Import实例
     */
    public static ContactsImporter getOneEightNineContacts(String email, String password) {
        return new OneEightNineImporter(email, password);
    }

    /**
     * 获取139 Importer实例
     *
     * @param email
     *            email地址
     * @param password
     *            密码
     * @return 139 Import实例
     */
    public static ContactsImporter getOneThreeNineContacts(String email, String password) {
        return new OneThreeNineImporter(email, password);
    }

	/**
	 * 获取MSN Importer实例
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return MSN Importer实例
	 */
	public static ContactsImporter getMSNContacts(String username,
			String password) {		
		return new HotmailImporter(username, password);
	}
}
