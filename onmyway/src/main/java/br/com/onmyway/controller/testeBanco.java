package br.com.onmyway.controller;

import java.util.ArrayList;
import java.util.List;
import br.com.onmyway.dao.ContactDao;
import br.com.onmyway.dao.UserDao;
import br.com.onmyway.entity.Contact;
import br.com.onmyway.entity.User;

public class testeBanco {
	public static void main(String[] args){
		//insertContact();
		//selectContact();
		//insertUser();
		selectUser();
		System.out.println("Hello World!");
	}

	private static void insertContact() {
		ContactDao contactDao = new ContactDao();
		Contact contact = new Contact();
		contact.setCellphoneNumber(999999999);
		contact.setEmail("contact@email.com");
		contactDao.insert(contact);
	}
	private static void selectContact() {
		ContactDao contactDao = new ContactDao();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts = contactDao.selectAll();
		for (Contact contact : contacts) {
			System.out.println(contact.getCellphoneNumber());
			System.out.println(contact.getEmail());
		}
	}
	private static void insertUser() {
		UserDao userDao = new UserDao();
		User user = new User();
		userDao.insert(user);
	}
	private static void selectUser() {
		UserDao userDao = new UserDao();
		List<User> users = new ArrayList<User>();
		users = userDao.selectAll();
		for (User user : users) {
			System.out.println(user.getId());
		}
	}
}
