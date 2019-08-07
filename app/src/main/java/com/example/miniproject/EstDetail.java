package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EstDetail extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String LOCATION = "location";
    public static final String IMURL = "imurl";
    private TextView showEstName;
    private TextView showEstType;
    private TextView showEstLocation;
    private Button btnReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_est_detail);
        showEstName = (TextView) findViewById(R.id.showName);
        showEstType = (TextView) findViewById(R.id.showType);
        showEstLocation = (TextView) findViewById(R.id.showLocation);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString(NAME);
        String type = extras.getString(TYPE);
        String location = extras.getString(LOCATION);
        showEstName.setText(name);
        showEstType.setText(type);
        showEstLocation.setText(location);
        btnReview = (Button) findViewById(R.id.reviewButton);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleReviewButton();
            }
        });

    }

    private void handleReviewButton() {
        Bundle extras = getIntent().getExtras();
        String name = extras.getString(NAME);
        Intent i = new Intent(this, ReviewDetails.class);
        i.putExtra(ReviewDetails.EST_NAME, name);
        startActivity(i);
    }
}
