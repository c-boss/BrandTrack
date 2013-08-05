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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

import org.json.*;

public class SingleBrandActivity extends Activity {
	private static final String TAG_ITEM = "items";
	
	String brand_name_in, url_api, curr_brand_name_in;
	String curr_url_api = "https://www.googleapis.com/shopping/search/v1/public/products?key=AIzaSyCMSePLJL3B2cF0H0x_q9SpN444mzvxlWw&country=US&q=brand+discounts+Coupon+&alt=json";
	String find_word = "brand";
	private ListView list;
	List<Image_Link_Webview> IMW = new ArrayList<Image_Link_Webview>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_brand_activity);
		
		Intent i = getIntent();
		brand_name_in = i.getStringExtra("Brand_id");
		TextView txt_brand_name = (TextView) findViewById(R.id.brand_name);
		txt_brand_name.setText(brand_name_in);
		curr_brand_name_in = brand_name_in.toLowerCase().replaceAll("\\s", "");
		url_api = curr_url_api.replace(find_word, curr_brand_name_in);
		Toast.makeText(getApplicationContext(), url_api, Toast.LENGTH_LONG).show();
		
		IMW = Get_Value(ParseJSON(url_api));
		List<String> Title = Seperate_Link_Title(ParseJSON(url_api));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				 this, R.layout.item_view, Title);
		list = (ListView) findViewById(R.id.BlistViewSingleBrand);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewclick, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SingleBrandActivity.this, WebViewActivity.class);
				TextView textview = (TextView) viewclick;
				String Title = textview.getText().toString();
				String web_url = Find_Url(Title);
				//Toast.makeText(getApplicationContext(), web_url, Toast.LENGTH_LONG).show();
				i.putExtra("Web_Url", web_url);
				startActivity(i);
			}
		});
		}
	
	public ArrayList ParseJSON(String url)
	{
		JSONParser parser = new JSONParser();
		ArrayList<HashMap<String, String>> Linklist = new ArrayList<HashMap<String, String>>();
		JSONObject json = parser.getJSONFromUrl(url);
		try {
			JSONArray item = json.getJSONArray(TAG_ITEM);
			for(int i = 0; i < item.length(); i++)
			{
				HashMap<String, String> map = new HashMap<String, String>();
				JSONObject itemtoload = item.getJSONObject(i);
				JSONObject product = itemtoload.getJSONObject("product");
				map.put("link", product.getString("link"));
				map.put("title", product.getString("title"));
				Linklist.add(map);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Linklist;
	}

	public List<Image_Link_Webview> Get_Value(ArrayList<HashMap<String, String>> Brands_and_images)
	{
		List<Image_Link_Webview> IMW_curr = new ArrayList<Image_Link_Webview>();
		for (HashMap<String, String> map: Brands_and_images)
		{
			Image_Link_Webview IMW_curr_personal = new Image_Link_Webview();
			IMW_curr_personal.setTitle(map.get("title"));
			IMW_curr_personal.setLink_webview(map.get("link"));
			IMW_curr.add(IMW_curr_personal);
		}
		return IMW_curr;
	}
	
	public ArrayList Seperate_Link_Title(ArrayList<HashMap<String, String>> Brands_and_images)
	{
		ArrayList<String> title = new ArrayList<String>();
		for (HashMap<String, String> map: Brands_and_images)
		{
			title.add(map.get("title"));
		}
		return title;
	}
	
	public String Find_Url(String Title)
	{
		String url = "";
		for (int i = 0; i < IMW.size(); i++)
		{
			if(IMW.get(i).getTitle().equals(Title))
			{
				url = IMW.get(i).getLink_webview();
			}
		}
		return url;
	}
}