package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class reviewdetails extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView dateResult;
    private RatingBar ratingBar;
    private TextView ratingResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewdetails);
        dateResult = (TextView) findViewById(R.id.dateResult);
        TextView datePicker = (TextView) findViewById(R.id.dateResult);
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
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);


    }

    private void handleDateTextView() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                reviewdetails.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

}
