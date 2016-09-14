package com.netcracker.service;
 
import java.util.List;

import com.netcracker.dao.ContactDAOImpl;
import com.netcracker.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.netcracker.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;
 
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.add(contact);
    }
 
    @Transactional
    public List<Contact> listContact() {
 
        return contactDAO.list();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.remove(id);
    }
}
