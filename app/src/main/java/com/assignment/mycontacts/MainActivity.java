package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.assignment.mycontacts.api.ContactsApi;
import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList();
    private RecyclerView contactsRecyclerView;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        contactsRecyclerView = findViewById(R.id.contactsListView);
        ContactsApi contactsApi = new ContactsApi();
        contacts = contactsApi.getContacts();

        ContactAdapter adapter = new ContactAdapter(contacts, getApplicationContext());
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        contactsRecyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(this::addNewContact);
    }

    private void addNewContact(View view) {
        Intent intent = new Intent(MainActivity.this, AddContact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}