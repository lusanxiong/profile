package com.job528.invite.msn;

import java.util.ArrayList;
import java.util.List;

import com.job528.invite.Contact;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnProtocol;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.MsnUserStatus;
import net.sf.jml.event.MsnAdapter;
import net.sf.jml.event.MsnContactListAdapter;
import net.sf.jml.impl.MsnMessengerFactory;
import net.sf.jml.message.MsnControlMessage;
import net.sf.jml.message.MsnDatacastMessage;
import net.sf.jml.message.MsnInstantMessage;
import net.sf.jml.message.MsnSystemMessage;
import net.sf.jml.message.MsnUnknownMessage;

public class MSNImporter {
	private String username;
	private String password;
	private MsnMessenger messenger;

	public boolean getComplete = false; // 获取用户列表完成
	public boolean loginError = false; // 登录失败
	public boolean getList = false;// 获取列表

	public MSNImporter(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public List<Contact> getContacts() throws InterruptedException {
		List<Contact> list = null;
		try {
			messenger = MsnMessengerFactory.createMsnMessenger(username, password);
			messenger.setSupportedProtocol(new MsnProtocol[] { MsnProtocol.MSNP12 });
			messenger.getOwner().setInitStatus(MsnUserStatus.ONLINE);
			messenger.setLogIncoming(true);
			messenger.setLogOutgoing(true);
			messenger.addListener(new MsnListener());
			messenger.login();
			messenger.addContactListListener(new MsnContactListAdapter() {
				public void contactStatusChanged(MsnMessenger msn, MsnContact con) {
				}

				public void contactListInitCompleted(MsnMessenger messenger) {
					getComplete = true;
				}
			});
			while (!this.getComplete && !this.loginError) {
				Thread.sleep(1000);
			}
			list = listContacts();
			this.getList = true;
			messenger.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	private List<Contact> listContacts() {
		MsnContact[] cons = messenger.getContactList().getContacts();
		List<Contact> ct = new ArrayList<Contact>();
		try {
			for (MsnContact con : cons) {
				ct.add(new Contact(con.getDisplayName(), con.getEmail().toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	private class MsnListener extends MsnAdapter {

		public void exceptionCaught(MsnMessenger messenger, Throwable throwable) {
			loginError = true;
		}
		public void loginCompleted(MsnMessenger messenger) {
		}
		public void logout(MsnMessenger messenger) {
		}
		public void instantMessageReceived(MsnSwitchboard switchboard, MsnInstantMessage message, MsnContact friend) {
			switchboard.sendMessage(message, false);
		}
		public void systemMessageReceived(MsnMessenger messenger, MsnSystemMessage message) {
		}
		public void controlMessageReceived(MsnSwitchboard switchboard, MsnControlMessage message, MsnContact contact) {
			switchboard.sendMessage(message, false);
		}
		public void datacastMessageReceived(MsnSwitchboard switchboard, MsnDatacastMessage message, MsnContact friend) {
			switchboard.sendMessage(message, false);
		}
		public void unknownMessageReceived(MsnSwitchboard switchboard, MsnUnknownMessage message, MsnContact friend) {
		}
		public void contactListInitCompleted(MsnMessenger messenger) {
		}
		public void contactListSyncCompleted(MsnMessenger messenger) {
		}
		public void contactStatusChanged(MsnMessenger messenger, MsnContact friend) {
		}
		public void ownerStatusChanged(MsnMessenger messenger) {
		}
		public void contactAddedMe(MsnMessenger messenger, MsnContact friend) {
		}
		public void contactRemovedMe(MsnMessenger messenger, MsnContact friend) {
		}
		public void switchboardClosed(MsnSwitchboard switchboard) {
		}
		public void switchboardStarted(MsnSwitchboard switchboard) {
		}
		public void contactJoinSwitchboard(MsnSwitchboard switchboard, MsnContact friend) {
		}
		public void contactLeaveSwitchboard(MsnSwitchboard switchboard, MsnContact friend) {
		}
	}
}