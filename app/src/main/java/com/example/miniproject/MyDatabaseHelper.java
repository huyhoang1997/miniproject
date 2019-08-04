package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";


    // Phiên bản
    private static final int DATABASE_VERSION = 1;


    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "The Establishment";


    // Tên bảng: Note.
    private static final String TABLE_EST = "Establishment";

    private static final String COLUMN_EST_ID ="Est_Id";
    private static final String COLUMN_EST_NAME ="Est_Name";
    private static final String COLUMN_EST_TYPE = "Est_Type";
    private static final String COLUMN_FOOD_TYPE = "Est_Food";
    private static final String COLUMN_LOCATION = "Est_Location";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        String script = "CREATE TABLE " + TABLE_EST + "("
                + COLUMN_EST_ID + " INTEGER PRIMARY KEY," + COLUMN_EST_NAME + " TEXT,"
                + COLUMN_EST_TYPE + " TEXT,"  + COLUMN_FOOD_TYPE + " TEXT," + COLUMN_LOCATION + " TEXT" +")";

        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EST);



        onCreate(db);
    }

    public void addEst(Establishment est) {

        Log.i(TAG, "MyDatabaseHelper.addEst ... " + est.getEstName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EST_NAME, est.getEstName());
        values.put(COLUMN_EST_TYPE, est.getEstType());
        values.put(COLUMN_FOOD_TYPE, est.getFoodType());
        values.put(COLUMN_LOCATION, est.getLocation());



        db.insert(TABLE_EST, null, values);



        db.close();
    }
    public int getEstCount() {
        Log.i(TAG, "MyDatabaseHelper.getESTCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_EST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();


        return count;
    }
    public List<Establishment> getAllData(){
        List<Establishment> estList = new ArrayList<Establishment>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Establishment "  ,null);
        if (cursor.moveToFirst()) {
            do {
                Establishment est = new Establishment();
                est.setEstName(cursor.getString(1));
                est.setEstType(cursor.getString(2));
                est.setFoodType(cursor.getString(3));
                est.setLocation(cursor.getString(4));

                estList.add(est);
            } while (cursor.moveToNext());
        }
        return estList;

    }

    public List<Establishment> searchData(String n){

        List<Establishment> estList = new ArrayList<Establishment>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE Est_name =" + "\"" + n + "\""  ,null);
        if (cursor.moveToFirst()) {
            do {
                Establishment est = new Establishment();
                est.setEstName(cursor.getString(1));
                est.setEstType(cursor.getString(2));
                est.setFoodType(cursor.getString(3));
                est.setLocation(cursor.getString(4));

                estList.add(est);
            } while (cursor.moveToNext());
        }

        return estList;

    }
    public int returnSearchResultCount(String n){
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE Est_name =" + "\"" + n + "\""  ,null);
        if (cursor.moveToFirst()) {
            do {
                count++;
            } while (cursor.moveToNext());
        }

        return count;
    }


}
