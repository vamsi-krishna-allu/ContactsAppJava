package com.assignment.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends AppCompatActivity {

    EditText first_name;
    EditText last_name;
    EditText phonenumber;
    EditText emailId;

    Button save_btn;
    Button cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        first_name = findViewById(R.id.firstName);
        last_name = findViewById(R.id.lastName);
        phonenumber = findViewById(R.id.phonenumber);
        emailId = findViewById(R.id.emailId);
        save_btn = findViewById(R.id.save_btn);
        cancel_btn = findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(this::goBack);
    }

    private void goBack(View view) {
        super.onBackPressed();
    }

}