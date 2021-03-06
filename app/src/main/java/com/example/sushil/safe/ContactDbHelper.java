package com.example.sushil.safe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import data.ContactContract.ContactEntry;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String TAG = ContactDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "contacts.db";

    private static final int DATABASE_VERSION =1;

    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_CONTACTS;
        SQL_CREATE_CONTACTS = "CREATE TABLE "+ ContactEntry.TABLE_NAME + " ("
                + ContactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ContactEntry.COLUMN_CONTACT_NAME + " TEXT NOT NULL, "
                + ContactEntry.COLUMN_CONTACT_NUMBER + " INTEGER NOT NULL UNIQUE, "
                + ContactEntry.COLUMN_CONTACT_PRIORITY + " INTEGER NOT NULL DEFAULT "+ContactEntry.CONTACT_PRIORITY_FRIENDS+");";

        sqLiteDatabase.execSQL(SQL_CREATE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
