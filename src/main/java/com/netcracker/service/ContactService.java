package com.netcracker.service;

import java.util.List;

import com.netcracker.domain.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
