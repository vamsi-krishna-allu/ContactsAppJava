package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.assignment.mycontacts.api.ContactsApi;
import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private List<Contact> contacts = new ArrayList();
    private RecyclerView contactsRecyclerView;
    Button addButton;
    EditText searchBox;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        contactsRecyclerView = findViewById(R.id.contactsListView);
        ContactsApi contactsApi = new ContactsApi();
        contacts = contactsApi.initContacts();

        adapter = new ContactAdapter(contacts, getApplicationContext());
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        contactsRecyclerView.setAdapter(adapter);

        searchBox = findViewById(R.id.editTextSearchContact);

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!searchBox.getText().toString().isEmpty()) {
                    contacts = contactsApi.getContacts().stream().filter(contact -> contact.getFirstName().contains(searchBox.getText().toString()) ||
                            contact.getLastName().contains(searchBox.getText().toString())).collect(Collectors.toList());
                }else {
                    contacts = contactsApi.getContacts();
                }
                adapter = new ContactAdapter(contacts, getApplicationContext());
                contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                contactsRecyclerView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(this::addNewContact);
    }

    private void addNewContact(View view) {
        Intent intent = new Intent(MainActivity.this, AddContact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}