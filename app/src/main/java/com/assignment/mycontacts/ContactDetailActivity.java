package com.assignment.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

public class ContactDetailActivity extends AppCompatActivity {

    TextView firstNameTextView;
    TextView lastNameTextView;
    TextView emailIdTextView;
    TextView phoneNumberTextView;
    Button backButton;
    Button editButton;
    Button deleteButton;

    public int contactId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_detail);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstNameTextView = findViewById(R.id.firstName);
        lastNameTextView = findViewById(R.id.lastName);
        emailIdTextView = findViewById(R.id.emailId);
        phoneNumberTextView = findViewById(R.id.phoneNumber);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this::goBack);
        bindIncomingData();

        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(this::editButtonListener);
        deleteButton = findViewById(R.id.delete_btn);
        deleteButton.setOnClickListener(this::deleteContact);
    }

    private void deleteContact(View view) {
        ContactViewModal viewModal = new ContactViewModal(getApplication());
        ContactEntity contact = new ContactEntity(firstNameTextView.getText().toString(),
                lastNameTextView.getText().toString(),
                phoneNumberTextView.getText().toString(),
                emailIdTextView.getText().toString());
        contact.setId(contactId);
        viewModal.delete(contact);
    }

    private void editButtonListener(View view) {
        Intent intent = new Intent(ContactDetailActivity.this, EditContact.class);
        intent.putExtra("contactId", contactId);
        intent.putExtra("firstName", firstNameTextView.getText());
        intent.putExtra("lastName", lastNameTextView.getText());
        intent.putExtra("emailId", emailIdTextView.getText());
        intent.putExtra("phoneNumber", phoneNumberTextView.getText());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goBack(View view) {
        super.onBackPressed();
    }

    private void bindIncomingData() {
        if(getIntent().hasExtra("firstName")){
            firstNameTextView.setText(getIntent().getStringExtra("firstName"));
        }
        if(getIntent().hasExtra("lastName")){
            lastNameTextView.setText(getIntent().getStringExtra("lastName"));
        }
        if(getIntent().hasExtra("emailId")){
            emailIdTextView.setText(getIntent().getStringExtra("emailId"));
        }
        if(getIntent().hasExtra("phoneNumber")){
            phoneNumberTextView.setText(getIntent().getStringExtra("phoneNumber"));
        }
        if(getIntent().hasExtra("contactId")){
            contactId = getIntent().getIntExtra("contactId", 0);
        }
    }
}
