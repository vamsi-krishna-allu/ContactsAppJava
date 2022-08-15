package com.assignment.mycontacts.modal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactViewModal extends AndroidViewModel {

    private ContactRepository repository;

    private LiveData<List<ContactEntity>> allContacts;

    public ContactViewModal(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }

    public void insert(ContactEntity model) {
        repository.insert(model);
    }

    public void update(ContactEntity model) {
        repository.update(model);
    }

    public void delete(ContactEntity model) {
        repository.delete(model);
    }

    public LiveData<List<ContactEntity>> getAllContacts() {
        return allContacts;
    }
}
