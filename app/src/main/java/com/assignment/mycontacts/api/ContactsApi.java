package com.assignment.mycontacts.api;

import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;

public class ContactsApi {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        contacts.add(new Contact(1,"fname1","lname1","phone","emailId"));
        contacts.add(new Contact(2,"fname2","lname2","phone","emailId"));
        contacts.add(new Contact(3,"fname3","lname3","phone","emailId"));
        contacts.add(new Contact(4,"fname4","lname4","phone","emailId"));
        contacts.add(new Contact(5,"fname5","lname5","phone","emailId"));
        contacts.add(new Contact(6,"fname6","lname6","phone","emailId"));
        contacts.add(new Contact(7,"fname7","lname7","phone","emailId"));
        contacts.add(new Contact(8,"fname8","lname8","phone","emailId"));
        contacts.add(new Contact(9,"fname9","lname9","phone","emailId"));
        contacts.add(new Contact(10,"fname10","lname10","phone","emailId"));
        return contacts;
    }

    public boolean updateContact(Contact contact) {
        for(Contact contactLocal : contacts){
            if(contactLocal.getId() == contact.getId()){
                contactLocal.setEmailId(contact.getEmailId());
                contactLocal.setFirstName(contact.getFirstName());
                contactLocal.setLastName(contact.getLastName());
                contactLocal.setPhoneNumber(contact.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    public boolean deleteContact(int contactId){
        for(Contact contactLocal : contacts){
            if(contactLocal.getId() == contactId){
                contacts.remove(contactLocal);
                return true;
            }
        }

        return false;
    }

    public boolean createContact(Contact contact){
        contacts.add(contact);
        return true;
    }
}
