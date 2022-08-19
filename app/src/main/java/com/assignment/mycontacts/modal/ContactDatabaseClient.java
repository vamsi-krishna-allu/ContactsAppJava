package com.assignment.mycontacts.modal;

import android.content.Context;

import androidx.room.Room;

public class ContactDatabaseClient {

    private Context context;
    private static ContactDatabaseClient instance;
    private ContactDatabase contactDatabase;

    private ContactDatabaseClient(Context context) {
        this.context = context;
        contactDatabase = Room.databaseBuilder(this.context, ContactDatabase.class, "contacts").build();
    }

    public static synchronized ContactDatabaseClient getInstance(Context mCtx) {
        if (instance == null) {
            instance = new ContactDatabaseClient(mCtx);
        }
        return instance;
    }

    public ContactDatabase getAppDatabase() {
        return contactDatabase;
    }
}
