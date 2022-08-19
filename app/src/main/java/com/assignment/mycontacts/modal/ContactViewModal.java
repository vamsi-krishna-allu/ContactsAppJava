package com.assignment.mycontacts.modal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactViewModal extends AndroidViewModel {

    private ContactRepository repository;

    private LiveData<List<ContactEntity>> allContacts;

    /**
     * Used in the activity to trigger the database operations
     * @param application
     */
    public ContactViewModal(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }

    /**
     * Calls repository to perform insert operation
     * @param model
     */
    public void insert(ContactEntity model) {
        repository.insert(model);
    }

    /**
     * Calls repository to perform update operation
     * @param model
     */
    public void update(ContactEntity model) {
        repository.update(model);
    }

    /**
     * Calls repository to perform delete operation
     * @param model
     */
    public void delete(ContactEntity model) {
        repository.delete(model);
    }

    /**
     * returns all contacts from database
     * @return
     */
    public LiveData<List<ContactEntity>> getAllContacts() {
        return allContacts;
    }
}
