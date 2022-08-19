package com.assignment.mycontacts;

import android.widget.EditText;

import java.util.regex.Pattern;

public class CustomValidator {
    /**
     * Common validation method to validate the contact edited or created
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param emailId
     * @return
     */
    public static String validateContact(EditText firstName, EditText lastName, EditText phoneNumber, EditText emailId) {
        if(firstName.getText() == null || firstName.getText().toString().isEmpty()){
            return "first name can't be empty";
        }
        if(lastName.getText() == null || lastName.getText().toString().isEmpty()){
            return "last name can't be empty";
        }
        if(phoneNumber.getText() == null || phoneNumber.getText().toString().isEmpty()){
            return "phone number can't be empty";
        }
        if(emailId.getText() == null || emailId.getText().toString().isEmpty()){
            return "email id can't be empty";
        }
        if(firstName.getText() != null && firstName.getText().toString().length() > 15){
            return "first name can't have more than 15 characters";
        }
        if(lastName.getText() != null && lastName.getText().toString().length() > 15){
            return "last name can't have more than 15 characters";
        }
        if(phoneNumber.getText() != null && phoneNumber.getText().toString().length() > 15){
            return "phone number can't have more than 15 characters";
        }
        String emailIdRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if(emailId.getText() != null && !Pattern.compile(emailIdRegex).matcher(emailId.getText().toString()).matches()){
            return "invalid email id";
        }

        return null;
    }
}
