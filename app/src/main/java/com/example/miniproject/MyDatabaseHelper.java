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
    private static final String COLUMN_IMAGE = "Est_Image";

    private static final String TABLE_REVIEW = "reviewEst";
    private static final String COLUMN_REVIEW_ID = "R_id";
    private static final String COLUMN_DATE = "R_date";
    private static final String COLUMN_MEAL_TYPE = "R_MealType";
    private static final String COLUMN_MEAL_COST = "R_MealCost";
    private static final String COLUMN_OVERALL_RATING = "R_oveRating";
    private static final String COLUMN_SERVICE_RATING = "R_sevRating";
    private static final String COLUMN_ATMOSPHERE_RATING = "R_atmRating";
    private static final String COLUMN_FOOD_RATING = "R_foodRating";
    private static final String COLUMN_COMMENT = "R_Comment";
    private static final String COLUMN_FOREIGN_ID ="R_EstID";
    public static final String CREATE_TABLE_EST = "CREATE TABLE " + TABLE_EST + "("
            + COLUMN_EST_ID + " INTEGER PRIMARY KEY," + COLUMN_EST_NAME + " TEXT,"
            + COLUMN_EST_TYPE + " TEXT,"  + COLUMN_FOOD_TYPE + " TEXT," + COLUMN_LOCATION + " TEXT," + COLUMN_IMAGE + " TEXT"  +")";
    public static final String CREATE_TABLE_REVIEW = "CREATE TABLE " + TABLE_REVIEW + "("
            + COLUMN_REVIEW_ID + " INTEGER PRIMARY KEY," + COLUMN_DATE + " TEXT,"
            + COLUMN_MEAL_TYPE + " TEXT,"
            + COLUMN_MEAL_COST + " NUMERIC,"  + COLUMN_OVERALL_RATING + " REAL,"
            + COLUMN_SERVICE_RATING + " REAL," + COLUMN_ATMOSPHERE_RATING + " REAL,"
            + COLUMN_FOOD_RATING + " REAL,"+COLUMN_COMMENT + " TEXT,"
            + COLUMN_FOREIGN_ID + " INTEGER,"
            + " FOREIGN KEY ("+COLUMN_FOREIGN_ID+") REFERENCES "+TABLE_EST+"("+COLUMN_EST_ID+"));";
    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");


        db.execSQL(CREATE_TABLE_EST);
        db.execSQL(CREATE_TABLE_REVIEW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");


        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEW);


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
        values.put(COLUMN_IMAGE, est.getImageURL());


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

    public List<Establishment> searchData(String n,String item){
        if(n.trim().equals("")){
            List<Establishment> estList = new ArrayList<Establishment>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE Est_Type =" + "\"" + item + "\""  ,null);
            if (cursor.moveToFirst()) {
                do {
                    Establishment est = new Establishment();
                    est.setEstName(cursor.getString(1));
                    est.setEstType(cursor.getString(2));
                    est.setFoodType(cursor.getString(3));
                    est.setLocation(cursor.getString(4));
                    est.setImageURL(cursor.getString(5));
                    estList.add(est);
                } while (cursor.moveToNext());
            }

            return estList;
        }else{
            List<Establishment> estList = new ArrayList<Establishment>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE lower(Est_Name) =" + "\"" + n.toLowerCase() + "\"" + "AND Est_Type =" + "\"" + item + "\""  ,null);
            if (cursor.moveToFirst()) {
                do {
                    Establishment est = new Establishment();
                    est.setEstName(cursor.getString(1));
                    est.setEstType(cursor.getString(2));
                    est.setFoodType(cursor.getString(3));
                    est.setLocation(cursor.getString(4));
                    est.setImageURL(cursor.getString(5));
                    estList.add(est);
                } while (cursor.moveToNext());
            }

            return estList;

        }


    }
    public int returnSearchResultCount(String n,String item){
        if(n.trim().equals("")){
            int count = 0;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE Est_Type =" + "\"" + item + "\""  ,null);
            if (cursor.moveToFirst()) {
                do {
                    count++;
                } while (cursor.moveToNext());
            }

            return count;
        }
        else{
            int count = 0;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE lower(Est_name) =" + "\"" + n.toLowerCase() + "\"" + "AND Est_Type =" + "\"" + item + "\""  ,null);
            if (cursor.moveToFirst()) {
                do {
                    count++;


                } while (cursor.moveToNext());
            }

            return count;
        }
    }

    public int estID(String name){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Establishment WHERE Est_Name =" + "\"" + name + "\""  ,null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        return cursor.getInt(0);

    }

    public void AddreviewEst(String estName,String date,String mealType, String mealCost, float overallRating,float serviceRating,float atmosphereRating,float foodRating,String comment){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_MEAL_TYPE, mealType);
        values.put(COLUMN_MEAL_COST, mealCost);
        values.put(COLUMN_OVERALL_RATING, overallRating);
        values.put(COLUMN_SERVICE_RATING, serviceRating);
        values.put(COLUMN_ATMOSPHERE_RATING, atmosphereRating);
        values.put(COLUMN_FOOD_RATING, foodRating);
        values.put(COLUMN_COMMENT, comment);
        values.put(COLUMN_FOREIGN_ID,this.estID(estName));


        db.insert(TABLE_REVIEW, null, values);
        db.close();

    }
    public List<Review> showAllReview(String estName){
//        int id = this.estID(estName);
        List<Review> r = new ArrayList<Review>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM reviewEst WHERE R_EstID =" + "\""+ this.estID(estName)+ "\""  ,null);
        if (cursor.moveToFirst()) {
            do {
                Review review = new Review();
                review.setDate(cursor.getString(1));
                review.setMealType(cursor.getString(2));
                review.setMealCost(cursor.getInt(3));
                review.setOverallRating(cursor.getFloat(4));
                review.setServiceRating(cursor.getFloat(5));
                review.setAtmosphereRating(cursor.getFloat(6));
                review.setFoodRating(cursor.getFloat(7));
                review.setComment(cursor.getString(8));
                r.add(review);
            } while (cursor.moveToNext());
        }
        return r;
    }



}
