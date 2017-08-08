package com.example.aaron.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    EditText etFirstName;
    EditText etLastName;
    EditText etPhoneNumber;
    EditText etEMailAddress;

    Button btnAddContact;
    Button btnUpdateContact;
    Button btnDeleteContact;
    Button btnFindContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind EditText
        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etEMailAddress = (EditText)findViewById(R.id.etEMailAddress);
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        //Bind Buttons
        btnAddContact = (Button)findViewById(R.id.btnAddContact);
        btnDeleteContact = (Button)findViewById(R.id.btnRemoveContact);
        btnUpdateContact = (Button)findViewById(R.id.btnUpdateContact);
        btnFindContact = (Button)findViewById(R.id.btnFindContact);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
    }

    public void clickAddContact(View view){
        Contacts newContact = new Contacts(etFirstName.getText().toString(),
                                           etLastName.getText().toString(),
                                           etEMailAddress.getText().toString(),
                                           etPhoneNumber.getText().toString());
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.saveNewContact(newContact);

    }

    public void clickFindContact(View view) {
        Contacts newContact = new Contacts(etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etEMailAddress.getText().toString(),
                etPhoneNumber.getText().toString());
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        ArrayList<Contacts> retrievedContacts = dbHelper.getContact(newContact);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putParcelableArrayListExtra("contacts",retrievedContacts);
        startActivity(intent);
        //etFirstName.setText(retrievedContacts.getFirstName());
        //etLastName.setText(retrievedContacts.getLastName());
        //etPhoneNumber.setText(retrievedContacts.getPhoneNumber());
        //etEMailAddress.setText(retrievedContacts.geteMailAddress());

    }
    public void clickRemoveContact(View view){
        Contacts newContact = new Contacts(etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etEMailAddress.getText().toString(),
                etPhoneNumber.getText().toString());
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.removeContact(newContact);
    }

    public void clickUpdateContact(View view){
        Contacts newContact = new Contacts(etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etEMailAddress.getText().toString(),
                etPhoneNumber.getText().toString());
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.updateContact(newContact);
    }


}
