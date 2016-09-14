package com.netcracker.dao;

import java.util.List;

import com.netcracker.domain.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends BaseDAOImpl<Contact> implements ContactDAO {

    public ContactDAOImpl(){
        super(Contact.class);
    }
}
