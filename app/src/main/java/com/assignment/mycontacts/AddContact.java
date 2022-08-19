package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.assignment.mycontacts.modal.ContactEntity;
import com.assignment.mycontacts.modal.ContactViewModal;

public class AddContact extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText emailId;

    Button saveButton;
    ImageButton cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstName = findViewById(R.id.addfirstName);
        lastName = findViewById(R.id.addlastName);
        phoneNumber = findViewById(R.id.addphonenumber);
        emailId = findViewById(R.id.addemailId);
        saveButton = findViewById(R.id.saveContact);
        cancelButton = findViewById(R.id.newCancelButton);
        cancelButton.setOnClickListener(this::goBack);
        saveButton.setOnClickListener(this::addContact);
    }

    /**
     * Adds the contact to the database
     * @param view
     */
    private void addContact(View view) {
        ContactViewModal viewModal = new ContactViewModal(getApplication());
        ContactEntity contact = new ContactEntity(firstName.getText().toString(),
                lastName.getText().toString(),
                phoneNumber.getText().toString(),
                emailId.getText().toString());
        viewModal.insert(contact);
        super.onBackPressed();
    }

    /**
     * Go back to previous activity on cancel
     * @param view
     */
    private void goBack(View view) {
        super.onBackPressed();
    }

}