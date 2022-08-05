package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.assignment.mycontacts.api.ContactsApi;
import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList();
    private RecyclerView contactsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsRecyclerView = findViewById(R.id.contactsListView);
        ContactsApi contactsApi = new ContactsApi();
        contacts = contactsApi.getContacts();

        ContactAdapter adapter = new ContactAdapter(contacts, getApplicationContext());
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        contactsRecyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}