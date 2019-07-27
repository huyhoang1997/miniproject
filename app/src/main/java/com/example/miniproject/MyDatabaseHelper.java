package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;



public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";


    // Phiên bản
    private static final int DATABASE_VERSION = 1;


    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Establishment";


    // Tên bảng: Note.
    private static final String TABLE_EST = "Establishment";

    private static final String COLUMN_EST_ID ="Est_Id";
    private static final String COLUMN_EST_NAME ="Est_Title";
    private static final String COLUMN_EST_TYPE = "Est_Content";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");

        String script = "CREATE TABLE " + TABLE_EST + "("
                + COLUMN_EST_ID + " INTEGER PRIMARY KEY," + COLUMN_EST_NAME + " TEXT,"
                + COLUMN_EST_TYPE + " TEXT" + ")";

        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EST);



        onCreate(db);
    }

    public void addEst(String name, String type) {

        Log.i(TAG, "MyDatabaseHelper.addEst ... " + name);

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EST_NAME, name);
        values.put(COLUMN_EST_TYPE, type);



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
}
