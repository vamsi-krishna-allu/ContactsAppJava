package com.assignment.mycontacts.api;

import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;

public class ContactsApi {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        contacts.add(new Contact(1,"mike","litekey","34253452675","mike.litekey@gmail.com"));
        contacts.add(new Contact(2,"alex","topley","54637548932","alex.topley@gmail.com"));
        contacts.add(new Contact(3,"chris","harris","43526454676","chris.harris@outlook.com"));
        contacts.add(new Contact(4,"david","miller","23456745609","david.miller@gmail.com"));
        contacts.add(new Contact(5,"craig","millan","34567897654","craig.millan@gmail.com"));
        contacts.add(new Contact(6,"simon","taufel","34567823233","simon.taufel@gmail.com"));
        contacts.add(new Contact(7,"simon","jones","12341234547","simon.jones@gmail.com"));
        contacts.add(new Contact(8,"daren","gough","65784896949","daren.gough@gmail.com"));
        contacts.add(new Contact(9,"ben","stone","65634829280","ben.stone@outlook.com"));
        contacts.add(new Contact(10,"cal","stone","34566542340","cal.stone@gmail.com"));
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
