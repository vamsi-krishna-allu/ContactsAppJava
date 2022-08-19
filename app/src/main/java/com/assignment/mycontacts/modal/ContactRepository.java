package com.assignment.mycontacts.modal;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.assignment.mycontacts.modal.asyncoperations.DeleteContact;
import com.assignment.mycontacts.modal.asyncoperations.InsertContact;
import com.assignment.mycontacts.modal.asyncoperations.UpdateContact;

import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private LiveData<List<ContactEntity>> allContacts;

    public ContactRepository(Application application) {
        ContactDatabaseClient databaseClient = ContactDatabaseClient.getInstance(application);
        ContactDatabase database = databaseClient.getAppDatabase();
        contactDao = database.ContactDao();
        allContacts = contactDao.getAllContacts();
    }

    public void insert(ContactEntity model) {
        new InsertContact(contactDao).execute(model);
    }

    public void update(ContactEntity model) {
        new UpdateContact(contactDao).execute(model);
    }

    public void delete(ContactEntity model) {
        new DeleteContact(contactDao).execute(model);
    }

    public LiveData<List<ContactEntity>> getAllContacts() {
        return allContacts;
    }
}
