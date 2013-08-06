/*
* /**
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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Initiating Menu XML file (menu.xml)
	    
	  
	 
	        
		Button button1= (Button) findViewById (R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
						@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(v.getContext(), ButtonActivity.class);
				startActivityForResult(intent, 0);		
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
     CharSequence abc="Copyright � 2013 Dipika Jain and Minh Nhat Vu It is a Open Source and can redistribute it and/or modify it under the terms of the GNU General Public License  as published by the Free Software Foundation, either version 3 of the License,  See the GNU General Public License for more details";
     
    switch (item.getItemId())
    {

    case R.id.menu_about:
        Toast.makeText(MainActivity.this, abc, Toast.LENGTH_SHORT).show();
        return true;

   

    default:
        return super.onOptionsItemSelected(item);
    }
    
	}
}
