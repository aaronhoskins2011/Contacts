package com.example.aaron.contacts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaron on 8/7/17.
 */

public class Contacts implements Parcelable {
    String firstName;
    String lastName;
    String eMailAddress;
    String phoneNumber;

    public Contacts(String firstName, String lastName, String eMailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.phoneNumber = phoneNumber;
    }

    protected Contacts(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        eMailAddress = in.readString();
        phoneNumber = in.readString();
    }

    public static final Creator<Contacts> CREATOR = new Creator<Contacts>() {
        @Override
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        @Override
        public Contacts[] newArray(int size) {
            return new Contacts[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(eMailAddress);
        parcel.writeString(phoneNumber);
    }
}
