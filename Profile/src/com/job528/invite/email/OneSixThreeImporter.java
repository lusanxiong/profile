package com.job528.invite.email;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.NameValuePair;
import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.job528.invite.Contact;
import com.job528.invite.exception.ContactsException;


/**
 * 导入163联系人列表
 * 
 * @author flyerhzm
 * 
 */
public class OneSixThreeImporter extends EmailImporter {
    // 登录url

    private String loginUrl = "http://reg.163.com/login.jsp?type=1&url=http://entry.mail.163.com/coremail/fcg/ntesdoor2?lightweight%3D1%26verifycookie%3D1%26language%3D-1%26style%3D3";
    //http://entry.mail.163.com/coremail/fcg/ntesdoor2?lightweight=1&verifycookie=1&language=-1&style=35&username=xxx
    //http://entry.mail.163.com/coremail/fcg/ntesdoor2?username=testjob36&lightweight=1&verifycookie=1&language=-1&style=3
    /**
     * 构造函数
     *
     * @param email
     * @param password
     */
    public OneSixThreeImporter(String email, String password) {
        super(email, password, "GBK");
    }

    /**
     * 登录163邮箱
     *
     * @throws ContactsException
     */
    public void doLogin() throws ContactsException {
        try {
            NameValuePair params[] = {new NameValuePair("verifycookie", "1"),
                new NameValuePair("product", "mail163"),
                new NameValuePair("username", getUsername(email)),
                new NameValuePair("password", password),
                new NameValuePair("selType", "jy")};
            Calendar calendar = Calendar.getInstance();
            calendar.set(2099, 11, 31);
            client.getState().addCookies(
                    new Cookie[]{
                        new Cookie(".163.com", "ntes_mail_firstpage",
                        "normal", "/", calendar.getTime(), false),
                        new Cookie(".163.com", "loginType",
                        "js", "/", calendar.getTime(), false)});
            String responseStr = doPost(loginUrl, params,
                    "http://mail.163.com/");

            String redirectUrl = getJSRedirectLocation(responseStr);
            //redirectUrl += "%26verifycookie%3D1%26language%3D-1%26style%3D35";
            doGet(redirectUrl, loginUrl);
        } catch (Exception e) {
            throw new ContactsException("163 protocol has changed", e);
        }
    }

    /**
     * 进入联系人列表页面，并读取所有的联系人信息
     *
     * @return 所有的联系人信息
     * @throws ContactsException
     */
    public List<Contact> parseContacts() throws ContactsException {
        try {
        	String sid = getSID(lastUrl);
        	if(null == sid) {
        		throw new NullPointerException("contactsUrl is error");
        	}
//          String contactsUrl = lastUrl.replace("main", "address/addrlist") + "&gid=all";
        	String contactsUrl = "http://g4a30.mail.163.com/jy3/address/addrlist.jsp?sid="+sid+"&gid=all";
            String content = doGet(contactsUrl);
            List<Contact> contacts = new ArrayList<Contact>();
            DOMParser parser = new DOMParser();
            InputSource is = new InputSource(new ByteArrayInputStream(content.getBytes("GBK")));
            is.setEncoding("GBK");
            parser.parse(is);
            NodeList nodes = parser.getDocument().getElementsByTagName("td");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getAttributes().getNamedItem("class").getNodeValue().equals("Ibx_Td_addrName")) {
                	String username = node.getFirstChild().getTextContent().trim();
                    i++;
                    String email = nodes.item(i).getFirstChild().getTextContent().trim();
                    contacts.add(new Contact(username, email));
                }
            }
            return contacts;
        } catch (Exception e) {
            throw new ContactsException("163 protocol has changed", e);
        }
    }
    
    private String getSID(String url) {
    	if(null == url) {
    		return null;
    	}
    	int index = url.indexOf("sid=");
		if(index>=0){
			return url.substring(index+4);
		}
    	return null;
    }
    
    public static void main(String[] args) {
		String url = "http://twebmail.mail.163.com/jy3/main.jsp?sid=UDJwhhUCAqzsyLqnPYCCBgePKkkpeZQL";
		int index = url.indexOf("sid=");
		if(index>=0){
			String sid = url.substring(index+4);
			System.out.println(sid);
		}
	}
}
