package com.example.gestion_commandes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydatabase.db";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_NAME = "Gestionde_commands";
        private static final String COLUMN_ID = "Num";
        private static final String COLUMN_NAME = "Nom";
        private static final String COLUMN_Qunity = "Quantite";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_Qunity + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

    public boolean addCommande(Integer Num, String Nom, String Quantite ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, Num);
        values.put(COLUMN_NAME, Nom);
        values.put(COLUMN_Qunity, Quantite);


        // Inserting Row
        long result = db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection

        // check if data is saved to database
        if (result == -1) {
            // data is not saved to database
            Log.e("Database", "Error inserting data into " + TABLE_NAME);
            return false;
        } else {
            // data is saved to database
            return true;
        }




    }



    public List<String> getAllCommandes() {
            List<String> commandes = new ArrayList<String>();

            // Select All Query
            String selectQuery = "SELECT * FROM " + TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(0);
                    String nom = cursor.getString(1);
                    String quantite = cursor.getString(2);
                   // String date = cursor.getString(3);

                    // Adding command to list
                    commandes.add(id + "," + nom + "," + quantite );
                } while (cursor.moveToNext());
            }


            cursor.close();
            db.close();


            return commandes;
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }



    public Cursor AFFICHER_STATE() {
        SQLiteDatabase sqlDb = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME ;
        Cursor row = sqlDb.rawQuery(query, null);
        if (row == null) {
            row.moveToFirst();
        }
        return row;
    }


    public   Cursor AFFICHERRESTOREDDATA()
    {
        SQLiteDatabase sqlDb = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor row = sqlDb.rawQuery(query, null);
        if (row == null) {
            row.moveToFirst();
        }
        return row;
    }


    public   String Testtt()
    {

        return "row";
    }





}

