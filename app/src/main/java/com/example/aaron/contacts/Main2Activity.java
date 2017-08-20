package com.example.aaron.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;


public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "ActivityTwo";
    ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: 2nd Activity");;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        contactListView = (ListView)findViewById(R.id.contactListView);
        AdapterContact adapterContact;
        final ArrayList<Contacts> contactList = b.getParcelableArrayList("contact");
        Log.d(TAG, "onCreate: CONTACT LIST ------ " + contactList.get(0).getLastName());
        adapterContact = new AdapterContact(this,1,contactList);
        contactListView.setAdapter(adapterContact);

    }
}
