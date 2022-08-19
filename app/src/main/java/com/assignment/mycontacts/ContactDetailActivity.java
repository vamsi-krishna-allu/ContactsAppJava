package com.assignment.mycontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

public class ContactDetailActivity extends AppCompatActivity {

    EditText firstNameTextView;
    EditText lastNameTextView;
    EditText emailIdTextView;
    EditText phoneNumberTextView;
    ImageButton backButton;
    ImageButton editButton;
    ImageButton deleteButton;

    public int contactId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_detail);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstNameTextView = findViewById(R.id.viewfirstName);
        lastNameTextView = findViewById(R.id.viewLastName);
        emailIdTextView = findViewById(R.id.viewEmailAddress);
        phoneNumberTextView = findViewById(R.id.viewPhoneNumber);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this::goBack);
        bindIncomingData();

        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(this::editButtonListener);
        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(this::deleteContact);
    }

    /**
     * below method is to delete contact
     * @param view
     */
    private void deleteContact(View view) {
        ContactViewModal viewModal = new ContactViewModal(getApplication());
        ContactEntity contact = new ContactEntity(firstNameTextView.getText().toString(),
                lastNameTextView.getText().toString(),
                phoneNumberTextView.getText().toString(),
                emailIdTextView.getText().toString());
        contact.setId(contactId);
        viewModal.delete(contact);
        goBack(view);
    }

    /**
     * Listener to edit button
     * When user clicks on edit button data gets added to intent and navigated to next screen
     * @param view
     */
    private void editButtonListener(View view) {
        Intent intent = new Intent(ContactDetailActivity.this, EditContact.class);
        intent.putExtra("contactId", contactId);
        intent.putExtra("firstName", firstNameTextView.getText().toString());
        intent.putExtra("lastName", lastNameTextView.getText().toString());
        intent.putExtra("emailId", emailIdTextView.getText().toString());
        intent.putExtra("phoneNumber", phoneNumberTextView.getText().toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * this is used to go back to previous screen
     * @param view
     */
    private void goBack(View view) {
        super.onBackPressed();
    }

    /**
     * It binds the data that is passed while navigation
     */
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
