package com.assignment.mycontacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private List<ContactEntity> contacts = new ArrayList();
    private RecyclerView contactsRecyclerView;
    Button addButton;
    SearchView searchBox;
    ContactAdapter adapter;
    ContactViewModal contactViewModal;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        context = getApplicationContext();

        contactsRecyclerView = findViewById(R.id.contactsListView);

        contactViewModal = new ContactViewModal(getApplication());
        adapter = new ContactAdapter(contacts, context);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        contactsRecyclerView.setAdapter(adapter);

        contactViewModal.getAllContacts().observe(this, models -> {
            models.sort(Comparator.comparing(ContactEntity::getFirstName));
            adapter = new ContactAdapter(models, context);
            contactsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            contactsRecyclerView.setAdapter(adapter);
        });

        searchBox = findViewById(R.id.searchContact);

        searchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(!s.isEmpty()) {
                    contacts = contactViewModal.getAllContacts().getValue().stream().filter(contact -> contact.getFirstName().contains(s) ||
                            contact.getLastName().contains(s)).collect(Collectors.toList());
                }else {
                    contacts = contactViewModal.getAllContacts().getValue();
                }
                contacts.sort(Comparator.comparing(ContactEntity::getFirstName));
                adapter = new ContactAdapter(contacts, context);
                contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                contactsRecyclerView.setAdapter(adapter);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(!s.isEmpty()) {
                    contacts = contactViewModal.getAllContacts().getValue().stream().filter(contact -> contact.getFirstName().contains(s) ||
                            contact.getLastName().contains(s)).collect(Collectors.toList());
                }else {
                    contacts = contactViewModal.getAllContacts().getValue();
                }
                contacts.sort(Comparator.comparing(ContactEntity::getFirstName));
                adapter = new ContactAdapter(contacts, context);
                contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                contactsRecyclerView.setAdapter(adapter);
                return false;
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