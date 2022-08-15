package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

public class AddContact extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText emailId;

    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phonenumber);
        emailId = findViewById(R.id.emailId);
        saveButton = findViewById(R.id.save_btn);
        cancelButton = findViewById(R.id.cancel_btn);
        cancelButton.setOnClickListener(this::goBack);
        saveButton.setOnClickListener(this::addContact);
    }

    private void addContact(View view) {
        ContactViewModal viewModal = new ContactViewModal(getApplication());
        ContactEntity contact = new ContactEntity(firstName.getText().toString(),
                lastName.getText().toString(),
                phoneNumber.getText().toString(),
                emailId.getText().toString());
        viewModal.insert(contact);
        super.onBackPressed();
    }

    private void goBack(View view) {
        super.onBackPressed();
    }

}