package com.assignment.mycontacts;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView contactTitle;
    TextView contactName;
    RelativeLayout relativelayout;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactTitle = itemView.findViewById(R.id.contactTitle);
        contactName = itemView.findViewById(R.id.contactName);
        relativelayout = itemView.findViewById(R.id.relativeLayout);
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

    public RelativeLayout getRelativeLayout() {
        return relativelayout;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.relativelayout = relativeLayout;
    }
}
