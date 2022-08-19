package com.assignment.mycontacts.modal;

import android.content.Context;

import androidx.room.Room;

public class ContactDatabaseClient {

    private Context context;
    private static ContactDatabaseClient instance;
    private ContactDatabase contactDatabase;

    /**
     * Creates a database based on the entity binded to the ContactDatabase with the name contacts
     * @param context
     */
    private ContactDatabaseClient(Context context) {
        this.context = context;
        contactDatabase = Room.databaseBuilder(this.context, ContactDatabase.class, "contacts").build();
    }

    /**
     * Creating a singleton instance of ContactDatabaseClient that supports multithreading
     * @param mCtx
     * @return
     */
    public static synchronized ContactDatabaseClient getInstance(Context mCtx) {
        if (instance == null) {
            instance = new ContactDatabaseClient(mCtx);
        }
        return instance;
    }

    /**
     * returns the current database
     * @return
     */
    public ContactDatabase getAppDatabase() {
        return contactDatabase;
    }
}
