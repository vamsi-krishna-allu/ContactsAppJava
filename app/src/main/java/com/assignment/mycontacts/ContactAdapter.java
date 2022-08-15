package com.assignment.mycontacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contactsList;
    private Context context;

    public ContactAdapter(List<Contact> contactsList, Context context) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int position) {
        Contact currentContact = this.contactsList.get(position);
        String text = String.format("%s %s", currentContact.getFirstName(), currentContact.getLastName());
        viewHolder.getContactName().setText(text);
        viewHolder.getContactTitle().setText(currentContact.getFirstName().substring(0,1).toUpperCase());

        viewHolder.relativelayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, ContactDetailActivity.class);
            intent.putExtra("contactId", currentContact.getId());
            intent.putExtra("firstName", currentContact.getFirstName());
            intent.putExtra("lastName", currentContact.getLastName());
            intent.putExtra("emailId", currentContact.getEmailId());
            intent.putExtra("phoneNumber", currentContact.getPhoneNumber());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.contactsList.size();
    }
}
