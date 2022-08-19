package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

public class EditContact extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText emailId;
    private int contactId;
    Button saveButton;
    ImageButton cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstName = findViewById(R.id.editfirstName);
        lastName = findViewById(R.id.editlastName);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailId = findViewById(R.id.editemailId);
        saveButton = findViewById(R.id.editSaveButton);
        cancelButton = findViewById(R.id.editCancelButton);

        cancelButton.setOnClickListener(this::goBack);
        saveButton.setOnClickListener(this::updateContact);
        bindIncomingData();
    }

    /**
     * Update contact data when user clicks on Done
     * @param view
     */
    private void updateContact(View view) {
        ContactViewModal viewModal = new ContactViewModal(getApplication());
        ContactEntity contact = new ContactEntity(firstName.getText().toString(),
                lastName.getText().toString(),
                phoneNumber.getText().toString(),
                emailId.getText().toString());
        contact.setId(contactId);
        viewModal.update(contact);
    }

    /**
     * Go back when user clicks on cancel
     * @param view
     */
    private void goBack(View view) {
        super.onBackPressed();
    }

    /**
     * Bind the incoming data from previous activity
     */
    private void bindIncomingData() {
        if(getIntent().hasExtra("firstName")){
            firstName.setText(getIntent().getStringExtra("firstName"));
        }
        if(getIntent().hasExtra("lastName")){
            lastName.setText(getIntent().getStringExtra("lastName"));
        }
        if(getIntent().hasExtra("emailId")){
            emailId.setText(getIntent().getStringExtra("emailId"));
        }
        if(getIntent().hasExtra("phoneNumber")){
            phoneNumber.setText(getIntent().getStringExtra("phoneNumber"));
        }
        if(getIntent().hasExtra("contactId")){
            contactId = getIntent().getIntExtra("contactId", 0);
        }
    }
}