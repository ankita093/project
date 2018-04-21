package com.example.ankita.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ankita on 31-Mar-18.
 */

public class databasehelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";

    // user table
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    // admin table
    private static final String TABLE_ADMIN="admin";
    private static final String COLUMN_ANAME="adminusername";
    private static final String COLUMN_APASS="adminpass";

    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table contacts (id integer primary key not null ," +
    "name text not null , email text not null , uname text not null , pass text not null);";

    private static final String TABLE_Admin_CREATE="create table admin (adminusername text not null , adminpass text not null);";

    public databasehelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_Admin_CREATE);
        this.db = db;
    }


    public void insertcontact(contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS,c.getPass());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

   /* public void insertadmin (contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from admin";
        Cursor cursor = db.rawQuery(query,null);


        values.put(COLUMN_ANAME,c.getAdminusername());
        values.put(COLUMN_APASS,c.getAdminpass());

    }
*/
    public String searchpass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname,pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if (a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    public String searchadminpass (String adminusername)
    {
        db = this.getReadableDatabase();
        String query = "select adminusername,adminpass from "+TABLE_ADMIN;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if (a.equals(adminusername))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        this.onCreate(db);

    }
}
