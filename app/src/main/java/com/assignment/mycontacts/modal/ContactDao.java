package com.assignment.mycontacts.modal;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface ContactDao {
    @Insert
    void insert(ContactEntity model);

    @Update
    void update(ContactEntity model);

    @Delete
    void delete(ContactEntity model);

    @Query("SELECT * FROM contacts ORDER BY id ASC")
    LiveData<List<ContactEntity>> getAllContacts();
}
