package com.example.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class AddEst extends AppCompatActivity {
    private EditText UserID;
    private EditText estName;
    private EditText foodType;
    private EditText Location;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private static final int MODE_CREATE = 1;
    private static final int MODE_EDIT = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addest);
        UserID =(EditText)findViewById(R.id.UserID);
        estName = (EditText) findViewById(R.id.estName);
        foodType = (EditText) findViewById(R.id.foodType);
        Location = (EditText) findViewById(R.id.estLocation);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox2);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_right);
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

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonClick();
            }
        });
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleSaveButton();
            }
        });
        Button searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleSearchButton();
            }
        });

    }
    private void handleButtonClick(){
        if( (UserID.getText().toString().trim().equals("")) ) {
            UserID.setError("Please enter valid userID number");
            UserID.requestFocus();
        }
        if( estName.getText().toString().trim().equals("")) {
            estName.setError("Please enter valid establishment name number");
            estName.requestFocus();
        }
        if( checkBox1.isChecked() == false && checkBox2.isChecked() == false && checkBox3.isChecked() == false) {
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( "please check a establishment type" )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();
        }
        if ((checkBox1.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox1.isChecked() &&   !(estName.getText().toString().trim().equals("")))  ) {

            String ID = UserID.getText().toString();
            String EstName = estName.getText().toString();
            String FoodType = foodType.getText().toString();
            String location = Location.getText().toString();
            String estType = checkBox1.getText().toString();
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( ID + "\n\n "  + EstName  +"\n\n"  +estType+  "\n\n " + FoodType +  "\n\n"  +location )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();


        }
        if ((checkBox2.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox2.isChecked() &&   !(estName.getText().toString().trim().equals("")))) {

            String ID = UserID.getText().toString();
            String EstName = estName.getText().toString();
            String FoodType = foodType.getText().toString();
            String location = Location.getText().toString();
            String estType = checkBox2.getText().toString();
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage(ID + "\n\n "  + EstName  +"\n\n"  +estType+  "\n\n " + FoodType +  "\n\n"  +location)
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();


        }
        if ((checkBox3.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox3.isChecked() &&   !(estName.getText().toString().trim().equals("")))  ) {

            String ID = UserID.getText().toString();
            String EstName = estName.getText().toString();
            String FoodType = foodType.getText().toString();
            String location = Location.getText().toString();
            String estType = checkBox3.getText().toString();
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( ID + "\n\n "  + EstName  +"\n\n"  +estType+  "\n\n " + FoodType +  "\n\n"  +location)
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();


        }
    }
    private void handleSaveButton(){
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        if( (UserID.getText().toString().trim().equals("")) ) {
            UserID.setError("Please enter valid userID number");
            UserID.requestFocus();
        }
        if( estName.getText().toString().trim().equals("")) {
            estName.setError("Please enter valid establishment name number");
            estName.requestFocus();
        }
        if( checkBox1.isChecked() == false && checkBox2.isChecked() == false && checkBox3.isChecked() == false) {

        }
        if ((checkBox1.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox1.isChecked() &&   !(estName.getText().toString().trim().equals("")))  ) {
            String name = estName.getText().toString();
            String type = checkBox1.getText().toString();
            String foodtype = foodType.getText().toString();
            String location = Location.getText().toString();
            Establishment est1 = new Establishment(name,type,foodtype,location);
            db.addEst(est1);
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( "Saved : " + db.getEstCount()  )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .setPositiveButton("Save",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();

        }
        if ((checkBox2.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox2.isChecked() &&   !(estName.getText().toString().trim().equals("")))) {

            String name = estName.getText().toString();
            String type = checkBox2.getText().toString();
            String foodtype = foodType.getText().toString();
            String location = Location.getText().toString();
            Establishment est2 = new Establishment(name,type,foodtype,location);
            db.addEst(est2);

            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( "Saved : " + db.getEstCount()  )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .setPositiveButton("Save",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();


        }
        if ((checkBox3.isChecked() &&   !(UserID.getText().toString().trim().equals("")) ) && (checkBox3.isChecked() &&   !(estName.getText().toString().trim().equals("")))  ) {

            String name = estName.getText().toString();
            String type = checkBox3.getText().toString();
            String foodtype = foodType.getText().toString();
            String location = Location.getText().toString();
            Establishment est3 = new Establishment(name,type,foodtype,location);
            db.addEst(est3);

            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( "Saved : " + db.getEstCount()  )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .setPositiveButton("Save",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();

        }



    }
    private void handleSearchButton(){
        Intent i = new Intent(this,SearchActivity.class);
        startActivity(i);
    }

}
