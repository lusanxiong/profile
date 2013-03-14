package com.job528.invite.email;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.job528.invite.Contact;
import com.job528.invite.exception.ContactsException;

/**
 *导入139联系人列表
 * 
 * @author flyerhzm
 */
public class OneThreeNineImporter extends EmailImporter {
    // 登录url
    private String loginUrl = "https://mail.139.com/Login/Login.ashx";
    
    /**
     * 构造函数
     * 
     * @param email
     * @param password
     */
    public OneThreeNineImporter(String email, String password) {
        super(email, password, "GBK");
    }

    /**
     * 登录139邮箱
     * @throws com.job528.invite.exception.ContactsException
     */
    @Override
    protected void doLogin() throws ContactsException {
        try {
            NameValuePair params[] = {
                new NameValuePair("UserName", getUsername(email)),
                new NameValuePair("Password", password),
                new NameValuePair("VerifyCode", "")
            };
            String responseStr = doPost(loginUrl, params,
                    "http://mail.139.com");
            String redirectUrl = getHrefUrl(responseStr, "http://");
            responseStr = doGet(redirectUrl, loginUrl);
        } catch (Exception e) {
            throw new ContactsException("139 protocol has changed", e);
        }
    }

    @Override
    protected List<Contact> parseContacts() throws ContactsException {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            String sid = getSid();
            String randNum = "0.0754233067456439";
            String contactsUrl = "http://mail.139.com/addr/apiserver/GetContactsDataByJs.ashx?sid=" + sid + "&rnd=" + randNum;
            String content = doGet(contactsUrl);
            JSONObject jsonObj = parseJSON(content, "GetUserAddrDataResp=");
            JSONArray jsonContacts = jsonObj.getJSONArray("Contacts");
            for (int i = 0; i < jsonContacts.length(); i++) {
                JSONObject jsonContact = (JSONObject) jsonContacts.get(i);
                String username = jsonContact.getString("c");
                String email = jsonContact.getString("y");
                contacts.add(new Contact(username, email));
            }
            return contacts;
        } catch (Exception e) {
            throw new ContactsException("139 protocol has changed", e);
        }
    }

    /**
     * 得到contacts url的sid
     *
     * @return sid
     */
    private String getSid() {
        String sid = null;
        Cookie[] cookies = client.getState().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Os_SSo_Sid")) {
                sid = cookie.getValue();
                break;
            }
        }
        return sid;
    }

}
