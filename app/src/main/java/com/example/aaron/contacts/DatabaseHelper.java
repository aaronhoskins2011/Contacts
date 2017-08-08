package com.example.aaron.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by aaron on 8/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDatabase";
    private static final int DATABASE_VERSION =  1;
    public static final String TABLE_NAME = "Contacts";
    public static final String CONTACT_FIRST_NAME = "FirstName";
    public static final String CONTACT_LAST_NAME = "LastName";
    public static final String CONTACT_PHONE_NUMBER = "PhoneNumber";
    public static final String CONTACT_EMAIL_ADDRESS = "EmailAddress";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
                                    + CONTACT_FIRST_NAME + " TEXT, "
                                    + CONTACT_LAST_NAME + " TEXT, "
                                    + CONTACT_EMAIL_ADDRESS + " TEXT, "
                                    + CONTACT_PHONE_NUMBER + " TEXT PRIMARY KEY )";

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d(TAG, "onCreate: TABLE " + TABLE_NAME + " Created........");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public void saveNewContact(Contacts passedContact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CONTACT_FIRST_NAME , passedContact.getFirstName());
        cv.put(CONTACT_LAST_NAME , passedContact.getLastName());
        cv.put(CONTACT_EMAIL_ADDRESS , passedContact.eMailAddress);
        cv.put(CONTACT_PHONE_NUMBER, passedContact.getPhoneNumber());
        db.insert(TABLE_NAME,null,cv);

        Log.d(TAG, "saveNewContact: New Contact Created");
    }

    public ArrayList<Contacts> getContact(Contacts passedContact){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + CONTACT_LAST_NAME + " = \"" + passedContact.getLastName() + "\"";
        ArrayList<Contacts> contacts = new ArrayList<Contacts>();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()) {
            do {
                Contacts newContact = new Contacts("","","","");
                newContact.setFirstName(cursor.getString(0));
                newContact.setLastName(cursor.getString(1));
                newContact.seteMailAddress(cursor.getString(2));
                newContact.setPhoneNumber(cursor.getString(3));
                contacts.add(newContact);
            }while(cursor.moveToNext());


        }


        return contacts;
    }

    public void updateContact(Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET "
                                    + CONTACT_FIRST_NAME + " = \"" + contact.getFirstName() + "\" , "
                                    + CONTACT_LAST_NAME + " = \"" + contact.getLastName() + "\" , "
                                    + CONTACT_EMAIL_ADDRESS + " = \"" + contact.geteMailAddress() + "\""
                                    + " WHERE " + CONTACT_PHONE_NUMBER + " = \"" + contact.getPhoneNumber()+ "\"";
        db.execSQL(query);
    }

    public boolean removeContact(Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Delete FROM " + TABLE_NAME + " WHERE " + CONTACT_PHONE_NUMBER + " = \"" + contact.getPhoneNumber() + "\"";

        db.execSQL(query);
        return true;
    }


}
