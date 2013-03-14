package com.job528.invite;

import java.util.List;

import com.job528.invite.exception.ContactsException;




/**
 * 导入联系人的接口
 * 
 * @author flyerhzm
 * 
 */
public interface ContactsImporter {
	public List<Contact> getContacts() throws ContactsException;
}
