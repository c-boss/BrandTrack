package com.example.bandtrack;
import android.view.View;
import android.app.ListActivity;
import android.content.Intent;
import  android.widget.EditText;
import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    public final static String EXTRA_MESSAGE = "com.example.Brandtrack.MESSAGE";
    
    String[] Brands = {
    		 "American Eagle",
    		 "Aero postale",
    		 "Ann taylor",
    		 "ArmaniExchange",
    		 "Banana Republic",
    		 "Bath and body works",
    		 "bebe",
    		 "best buy",
    		 "Calvin Klein",
    		 "carters",
    		 "clarks",
    		 "Coach",
    		 "Columbia",
    		 "eddie bauer",
    		 "express",
    		 "forever21",
    		 "Fossil",
    		 "Gap",
    		 "guess",
    		 "gymboree",
    		 "h & m",
    		 "Hollister",
    		 "home depot",
    		 "jc penny",
    		 "jcrew",
    		 "juicy curture",
    		 "katespade",
    		 "kohls",
    		 "Levis",
    		 "loft",
    		 "lowes",
    		 "macys",
    		 "maurices",
    		 "Nine west",
    		 "nordstorm",
    		 "North Face",
    		 "Old Navy",
    		 "ralphlauren",
    		 "sears",
    		 "sephora",
    		 "sports authority",
    		 "target",
    		 "Tommy Hilfiger",
    		 "Victoria Secret",
    		 "walmart",
    		 "white black",
    		 "walgreens"
    		};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //---List View---
        setListAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, Brands));
        }
        public void onListItemClick(ListView parent, View v,
        int position, long id) {
        Toast.makeText(this, "You have selected " + Brands[position],
        Toast.LENGTH_SHORT).show();
        }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    } 
        /** Called when the user clicks the Send button */
        public void SearchMessage (View view) {
            // Do something in response to button

            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

        }
    }
    

