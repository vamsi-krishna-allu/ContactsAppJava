package com.assignment.mycontacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.mycontacts.modal.Contact;
import com.assignment.mycontacts.modal.ContactEntity;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<ContactEntity> contactsList;
    private Context context;

    public ContactAdapter(List<ContactEntity> contactsList, Context context) {
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

    /**
     * This is to bind the contact data to recycler view using contact view holder
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int position) {
        ContactEntity currentContact = this.contactsList.get(position);
        String text = String.format("%s %s", currentContact.getFirstName(), currentContact.getLastName());
        viewHolder.getContactName().setText(text);
        if(!currentContact.getFirstName().isEmpty()){
            // sets the title as in circle beside each contact
            viewHolder.getContactTitle().setText(currentContact.getFirstName().substring(0,1).toUpperCase());
        }

        // listener for each item click in recycler view, it passes data of the selected contact item through intent
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

    /**
     * returns total count of contacts in recycler view
     * @return
     */
    @Override
    public int getItemCount() {
        return this.contactsList != null ? this.contactsList.size() : 0;
    }
}
