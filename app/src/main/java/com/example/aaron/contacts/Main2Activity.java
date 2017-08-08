package com.example.aaron.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;


public class Main2Activity extends AppCompatActivity {
    ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = new Intent();
        contactListView = (ListView)findViewById(R.id.contactListView);
        AdapterContact adapterContact;
        final ArrayList<Contacts> contactList = intent.getParcelableArrayListExtra("contacts");

        adapterContact = new AdapterContact(this,0,contactList);
        contactListView.setAdapter(adapterContact);







    }
}
