package com.assignment.mycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mycontacts.modal.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> contactsList;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contactsList, Context context) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int position) {
        Contact currentContact = this.contactsList.get(position);
        String text = String.format("%s %s", currentContact.getFirstName(), currentContact.getLastName());
        viewHolder.getContactName().setText(text);
        viewHolder.getContactTitle().setText(currentContact.getFirstName().substring(0,1));
    }

    @Override
    public int getItemCount() {
        return this.contactsList.size();
    }
}
