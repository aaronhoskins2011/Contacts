package com.example.aaron.contacts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aaron on 8/8/17.
 */

class AdapterContact extends ArrayAdapter<Contacts> {
    private Activity activity;
    private ArrayList<Contacts> contact;
    private static LayoutInflater inflater = null;

    public AdapterContact(Activity activity, int textViewResourceId, ArrayList<Contacts> contactsArrayList) {
        super(activity, textViewResourceId, contactsArrayList);
        try {
            this.activity = activity;
            this.contact  = contact;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return contact.size();
    }

    public Contacts getItem(Contacts position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView name;
        public TextView eMail;
        public TextView phone;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview, null);
                holder = new ViewHolder();

                holder.name = (TextView) vi.findViewById(R.id.Name);
                holder.eMail = (TextView) vi.findViewById(R.id.Email);
                holder.phone = (TextView) vi.findViewById(R.id.Phone);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.name.setText(contact.get(position).getFirstName() + contact.get(position).getLastName());
            holder.eMail.setText(contact.get(position).geteMailAddress());
            holder.phone.setText(contact.get(position).getPhoneNumber());


        } catch (Exception e) {


        }
        return vi;
    }
}
