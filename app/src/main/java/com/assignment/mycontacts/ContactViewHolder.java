package com.assignment.mycontacts;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView contactTitle;
    private TextView contactName;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactTitle = itemView.findViewById(R.id.contactTitle);
        contactName = itemView.findViewById(R.id.contactName);
    }

    public TextView getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(TextView contactTitle) {
        this.contactTitle = contactTitle;
    }

    public TextView getContactName() {
        return contactName;
    }

    public void setContactName(TextView contactName) {
        this.contactName = contactName;
    }
}
