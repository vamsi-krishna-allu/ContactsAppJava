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

    /**
     * Connects to the database and fetches all contacts using dao
     * @param application
     */
    public ContactRepository(Application application) {
        ContactDatabaseClient databaseClient = ContactDatabaseClient.getInstance(application);
        ContactDatabase database = databaseClient.getAppDatabase();
        contactDao = database.ContactDao();
        allContacts = contactDao.getAllContacts();
    }

    /**
     * Use the async insert class to execute ionsert operation in the background
     * @param model
     */
    public void insert(ContactEntity model) {
        new InsertContact(contactDao).execute(model);
    }

    /**
     * Use the async update class to execute update operation in the background
     * @param model
     */
    public void update(ContactEntity model) {
        new UpdateContact(contactDao).execute(model);
    }

    /**
     * Use the async delete class to execute delete operation in the background
     * @param model
     */
    public void delete(ContactEntity model) {
        new DeleteContact(contactDao).execute(model);
    }

    /**
     * Returns all the contacts generated at the constructor from database
     * @return
     */
    public LiveData<List<ContactEntity>> getAllContacts() {
        return allContacts;
    }
}
