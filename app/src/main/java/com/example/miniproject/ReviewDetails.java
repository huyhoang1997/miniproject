package com.example.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.os.*;
import java.util.Calendar;

public class ReviewDetails extends AppCompatActivity {
    public static final String EST_NAME = "name";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView dateResult;
    private RatingBar overallRating;
    private RatingBar serviceRating;
    private RatingBar atmosphereRating;
    private RatingBar foodRating;
    private EditText mealCost;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private AutoCompleteTextView comment;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewdetails);
        dateResult = (TextView) findViewById(R.id.dateResult);
        TextView datePicker = (TextView) findViewById(R.id.dateResult);
        submit = (Button) findViewById(R.id.submitButton);
        datePicker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleDateTextView();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker datePicker, int year,int month,int day){
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                dateResult.setText(date);
            }
        };
        overallRating = (RatingBar) findViewById(R.id.ratingBar);
        serviceRating = (RatingBar) findViewById(R.id.ratingBar1);
        atmosphereRating = (RatingBar) findViewById(R.id.ratingBar2);
        foodRating = (RatingBar) findViewById(R.id.ratingBar3);
        comment = (AutoCompleteTextView) findViewById(R.id.additionalComment);
        checkBox1 = (CheckBox) findViewById(R.id.mealType1);
        checkBox2 = (CheckBox) findViewById(R.id.mealType2);
        checkBox3 = (CheckBox) findViewById(R.id.mealType3);
        mealCost = (EditText) findViewById(R.id.costOfMeal);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmitButton();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }

            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }

            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }

            }
        });

    }

    private void handleSubmitButton() {
            if(dateResult.getText().toString().trim().equals("mm/dd/yyyy")){
                dateResult.setError("Click here to add the date");
                dateResult.setFocusable(true);
                dateResult.setFocusableInTouchMode(true);
                dateResult.requestFocus();;
            }
            else{
                if(checkBox1.isChecked()){
                    String date = dateResult.getText().toString();
                    String mealType = checkBox1.getText().toString();
                    String MealCost = mealCost.getText().toString();
                    float oveRating = overallRating.getRating();
                    float serRating = serviceRating.getRating();
                    float atmRating = atmosphereRating.getRating();
                    float FoodRating = foodRating.getRating();
                    String Comment = comment.getText().toString();
                    Bundle extras = getIntent().getExtras();
                    String name = extras.getString(EST_NAME);
                    MyDatabaseHelper db = new MyDatabaseHelper(this);
                    db.AddreviewEst(name,date,mealType,MealCost,oveRating,serRating,atmRating,FoodRating,Comment);
                    new AlertDialog.Builder(this).setTitle("Details entered")
                            .setMessage( "Submitted Review! Thank you for your cooperation :) "  )
                            .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {}})
                            .show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(ReviewDetails.this, SearchActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 1000);

                }
                if(checkBox2.isChecked()){
                    String date = dateResult.getText().toString();
                    String mealType = checkBox2.getText().toString();
                    String MealCost = mealCost.getText().toString();
                    float oveRating = overallRating.getRating();
                    float serRating = serviceRating.getRating();
                    float atmRating = atmosphereRating.getRating();
                    float FoodRating = foodRating.getRating();
                    String Comment = comment.getText().toString();
                    Bundle extras = getIntent().getExtras();
                    String name = extras.getString(EST_NAME);
                    MyDatabaseHelper db = new MyDatabaseHelper(this);
                    db.AddreviewEst(name,date,mealType,MealCost,oveRating,serRating,atmRating,FoodRating,Comment);
                    new AlertDialog.Builder(this).setTitle("Details entered")
                            .setMessage( "Submitted Review! Thank you for your cooperation :) "    )
                            .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {}})
                            .show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(ReviewDetails.this, SearchActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 1000);

                }
                if(checkBox3.isChecked()){
                    String date = dateResult.getText().toString();
                    String mealType = checkBox3.getText().toString();
                    String MealCost = mealCost.getText().toString();
                    float oveRating = overallRating.getRating();
                    float serRating = serviceRating.getRating();
                    float atmRating = atmosphereRating.getRating();
                    float FoodRating = foodRating.getRating();
                    String Comment = comment.getText().toString();
                    Bundle extras = getIntent().getExtras();
                    String name = extras.getString(EST_NAME);
                    MyDatabaseHelper db = new MyDatabaseHelper(this);
                    db.AddreviewEst(name,date,mealType,MealCost,oveRating,serRating,atmRating,FoodRating,Comment);
                    new AlertDialog.Builder(this).setTitle("Details entered")
                            .setMessage( "Submitted Review! Thank you for your cooperation :) "      )
                            .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {}})
                            .show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(ReviewDetails.this, SearchActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }, 1000);

                }

            }


    }

    private void handleDateTextView() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                ReviewDetails.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

}
