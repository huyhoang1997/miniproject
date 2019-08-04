package com.example.miniproject;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {
    private AutoCompleteTextView txt;
    private Button btn;
    private TextView result;
    private ListView lv;
    private Spinner spnCategory;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        txt = (AutoCompleteTextView) findViewById(R.id.searchBar);
        lv = (ListView) findViewById(R.id.resultSearch1);
        result = (TextView) findViewById(R.id.resultNumber);
        btn = (Button) findViewById(R.id.searchingButton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleSearchingButton();
            }
        });
        overridePendingTransition(R.anim.slide_right,R.anim.slide_right);
        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.APPEARING);
        lv.setLayoutTransition(l);

        spnCategory = (Spinner) findViewById(R.id.spnCategory);

        List<String> list = new ArrayList<>();
        list.add("Coffee");
        list.add("Bar");
        list.add("Restaurant");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory.setAdapter(adapter);
    }

    private void handleSearchingButton() {
        String estName = txt.getText().toString();
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        if(db.searchData(estName).size() == 0){
            new AlertDialog.Builder(this).setTitle("Details entered")
                    .setMessage( "No information about that establishment"  )
                    .setNeutralButton("Back",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}})
                    .show();
            result.setText("Found" +" " + db.returnSearchResultCount(estName)+" " + "results");

        }else{
            result.setText("Found" +" " + db.returnSearchResultCount(estName)+" " + "results");
            ArrayAdapter<Establishment> arrayAdapter = new ArrayAdapter<Establishment>(this, android.R.layout.simple_list_item_1 , db.searchData(estName));
            lv.setAdapter(arrayAdapter);

        }

    }
}

