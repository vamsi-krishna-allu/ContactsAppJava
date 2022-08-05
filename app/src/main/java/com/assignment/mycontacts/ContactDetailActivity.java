package com.assignment.mycontacts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    TextView firstNameTextView;
    TextView lastNameTextView;
    TextView emailIdTextView;
    TextView phoneNumberTextView;
    Button backButton;

    public int contactId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_detail);
        firstNameTextView = findViewById(R.id.firstName);
        lastNameTextView = findViewById(R.id.lastName);
        emailIdTextView = findViewById(R.id.emailId);
        phoneNumberTextView = findViewById(R.id.phoneNumber);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this::goBack);
        bindIncomingData();
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
