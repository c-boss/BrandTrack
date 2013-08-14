/*
/**
Open-Android-BrandTrack
Copyright © 2013
Dipika Jain and Minh Vu

* @author Dipika Jain
* @author Minh Vu
**/
/** This file is part of BrandTrack.

BrandTrack is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
https://github.com/jdipika/BrandTrack/blob/master/License.txt

BrandTrack is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with BrandTrack. If not, see <http://www.gnu.org/licenses/gpl.html>

For feedback please mail at dipika_87@yahoo.com/vnm241191@gmail.com
*/
package com.oss.track_brand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends Activity {
	String[] myItems = {"American Eagle", "Aero postale","Ann taylor",
			 "ArmaniExchange","Banana Republic","Bath and body works",
			 "bebe", "Best buy", "Calvin Klein", "carters", "clarks",
			 "Coach", "Columbia", "Eddie bauer", "Express", "Forever21",
			 "Fossil", "Gap", "Guess", "Gymboree", "H & M", "Hollister",
			 "Home depot", "JC penny", "Jcrew", "Juicy curture",
			 "Katespade", "Kohls", "Levis", "Loft", "lowes", "macys",
            "maurices", "Nine west", "Nordstorm", "North Face",
			 "Old Navy", "Ralph Lauren", "sears", "Sephora",
			 "Sports authority", "Target", "Tommy Hilfiger",
            "Victoria Secret", "Walmart", "White black", "Walgreens"};
	
	private ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_activity);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				 this, R.layout.item_view, myItems);
		list = (ListView) findViewById(R.id.BlistView);
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View viewclick, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ButtonActivity.this, SingleBrandActivity.class);
				TextView textview = (TextView) viewclick;
				String message =  "fetching in for" + textview.getText().toString();			
				CharSequence brand_id = textview.getText().toString();
				i.putExtra("Brand_id", brand_id);
				startActivity(i);
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu)
	{
	    MenuInflater menuInflater = getMenuInflater();
	    menuInflater.inflate(R.layout.menu, menu);
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	     CharSequence abc="Copyright © 2013 Dipika Jain and Minh Nhat Vu It is a Open Source and can redistribute it and/or modify it under the terms of the GNU General Public License  as published by the Free Software Foundation, either version 3 of the License,  See the GNU General Public License for more details";
	     
	    switch (item.getItemId())
	    {

	    case R.id.menu_about:
	        Toast.makeText(ButtonActivity.this, abc, Toast.LENGTH_SHORT).show();
	        return true;

	   

	    default:
	        return super.onOptionsItemSelected(item);
	    }
	    /**
	     * Event Handling for Individual menu item selected
	     * Identify single menu item by it's id
	     * */
		}
}
