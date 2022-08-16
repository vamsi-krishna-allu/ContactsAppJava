package com.assignment.mycontacts.modal.asyncoperations;

import android.os.AsyncTask;

import com.assignment.mycontacts.modal.ContactDao;
import com.assignment.mycontacts.modal.ContactEntity;

public class DeleteContact extends AsyncTask<ContactEntity, Void, Void> {

    private ContactDao contactDao;

    public DeleteContact(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    protected Void doInBackground(ContactEntity... contactEntities) {
        contactDao.delete(contactEntities[0]);
        return null;
    }
}
