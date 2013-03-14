package com.job528.invite;

import java.util.List;

import com.job528.invite.email.OneSixThreeImporter;
import com.job528.invite.email.OneTwoSixImporter;
import com.job528.invite.email.SinaImporter;
import com.job528.invite.email.SohuImporter;
import com.job528.invite.email.TomImporter;
import com.job528.invite.email.YahooImporter;
import com.job528.invite.email.YeahImporter;
import com.job528.invite.google.GoogleImporter;
import com.job528.invite.msn.MSNImporter;

public class Test {
	private static ContactsImporter importer = null;

	public static void main(String[] args) throws Exception {
//		msn();
		t163(); //not
//		t126();
//		gmail();
//		yahoo();
//		tom();
//		sina();
//		sohu();
//		yeah();
	}
	
	public static void msn() throws Exception {
		MSNImporter importer = new MSNImporter("tanggaohong@163.com", "");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void t163() throws Exception  {
		importer = new OneSixThreeImporter("testjob36@163.com","aaaaaa");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
		
	}
	
	public static void t126() throws Exception {
		importer = new OneTwoSixImporter("testjob36@126.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void gmail() throws Exception {
		importer = new GoogleImporter("tanggaohong.com@gmail.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void yahoo() throws Exception {
		System.out.println("------------");
		importer = new YahooImporter("tanggaohong@yahoo.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void tom() throws Exception {
		
		System.out.println("------------");
		importer = new TomImporter("tanggaohong@tom.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void sina() throws Exception {
		System.out.println("------------");
		importer = new SinaImporter("testjob36@sina.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	public static void sohu() throws Exception {
		System.out.println("------------");
		importer = new SohuImporter("tanggaohong@sohu.com","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	public static void yeah() throws Exception {
		System.out.println("------------");
		importer = new YeahImporter("tanggaohong@yeah.net","");
		List<Contact> contacts = importer.getContacts();
		System.out.println("begin");
		for (Contact c : contacts) {
			System.out.println("name:" + c.getUsername() + " email:" + c.getEmail());
		}
		System.out.println("end");
	}
	
	
}
