package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class EditContact extends AppCompatActivity {

    EditText first_name;
    EditText last_name;
    EditText phonenumber;
    EditText emailId;
    private int contactId;
    Button save_btn;
    Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        first_name = findViewById(R.id.firstName);
        last_name = findViewById(R.id.lastName);
        phonenumber = findViewById(R.id.phonenumber);
        emailId = findViewById(R.id.emailId);
        save_btn = findViewById(R.id.save_btn);
        cancel_btn = findViewById(R.id.cancel_btn);

        cancel_btn.setOnClickListener(this::goBack);
        bindIncomingData();
    }

    private void goBack(View view) {
        super.onBackPressed();
    }

    private void bindIncomingData() {
        if(getIntent().hasExtra("firstName")){
            first_name.setText(getIntent().getStringExtra("firstName"));
        }
        if(getIntent().hasExtra("lastName")){
            last_name.setText(getIntent().getStringExtra("lastName"));
        }
        if(getIntent().hasExtra("emailId")){
            emailId.setText(getIntent().getStringExtra("emailId"));
        }
        if(getIntent().hasExtra("phoneNumber")){
            phonenumber.setText(getIntent().getStringExtra("phoneNumber"));
        }
        if(getIntent().hasExtra("contactId")){
            contactId = getIntent().getIntExtra("contactId", 0);
        }
    }
}