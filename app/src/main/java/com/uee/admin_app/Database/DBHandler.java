package com.example.myueeapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {



    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";

    public DBHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    //create the database
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + admin.Orders.TABLE_NAME + " (" +
                    admin.Orders._ID + " INTEGER PRIMARY KEY," +
                    admin.Orders.COLUMN_1 + " TEXT," +
                    admin.Orders.COLUMN_2 + " TEXT," +
                    admin.Orders.COLUMN_3 + " TEXT," +
                    admin.Orders.COLUMN_4 + " TEXT," +
                    admin.Orders.COLUMN_5 + " TEXT)" ;


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + admin.Orders.TABLE_NAME;




    //Insert data into the database
    public long addinfo (String productname, String modelname, String wattage,String warranty, String price ){

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(admin.Orders.COLUMN_1, productname);
        values.put(admin.Orders.COLUMN_2, modelname);
        values.put(admin.Orders.COLUMN_3, wattage);
        values.put(admin.Orders.COLUMN_4, warranty);
        values.put(admin.Orders.COLUMN_5, price);


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(admin.Orders.TABLE_NAME, null, values);

        return newRowId;
    }

}
