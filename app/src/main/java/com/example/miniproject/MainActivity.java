package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn = (Button) findViewById(R.id.buttonAdd);
        Button searchBtn = (Button) findViewById(R.id.buttonSearch);
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleAddButton();
            }
        });
        overridePendingTransition(R.anim.slide_right,R.anim.slide_right);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleSearchButton();
            }
        });


    }



    private void handleAddButton() {
        Intent i = new Intent(this,AddEst.class);
        startActivity(i);
    }

    private void handleSearchButton() {
        Intent i = new Intent(this,SearchActivity.class);
        startActivity(i);
    }
}
