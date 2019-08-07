package com.example.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class EstDetail extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String LOCATION = "location";
    public static final String IMURL = "imurl";
    private TextView showEstName;
    private TextView showEstType;
    private TextView showEstLocation;
    private Button btnReview;
    private Context context;
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
        String imurl = extras.getString(IMURL);
        showEstName.setText(name);
        showEstType.setText(type);
        showEstLocation.setText(location);
        ImageView img =(ImageView) findViewById(R.id.showImageDetail);
        int resID = EstDetail.this.getResources().getIdentifier(imurl , "mipmap", EstDetail.this.getPackageName());
        img.setImageResource(resID);
        btnReview = (Button) findViewById(R.id.reviewButton);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleReviewButton();
            }
        });
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        if(db.showAllReview(name) != null){
            List<Review> review = db.showAllReview(name);
            ListView lv = (ListView) findViewById(R.id.resultReview);
            lv.setAdapter(new CustomReviewAdapter(this,review));
        }

    }



    private void handleReviewButton() {

        Bundle extras = getIntent().getExtras();
        String name = extras.getString(NAME);
        Intent i = new Intent(this, ReviewDetails.class);
        i.putExtra(ReviewDetails.EST_NAME, name);
        startActivity(i);
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        return resID;
    }
}
