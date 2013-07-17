package com.oss.track_brand;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
//import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends Activity {
	private List <Brand> mybrands = new ArrayList<Brand>();
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_activity);
		populatebrandlist();
		populatelistView();
		registerclickcallback();
	}
	
	

	private void populatebrandlist() {
		// TODO Auto-generated method stub
		mybrands.add(new Brand(R.drawable.aeg));
		mybrands.add(new Brand(R.drawable.aerop));
		mybrands.add(new Brand(R.drawable.anntylor));
		mybrands.add(new Brand(R.drawable.ax));
		mybrands.add(new Brand(R.drawable.bbuy));
		mybrands.add(new Brand(R.drawable.bnbw));
		mybrands.add(new Brand(R.drawable.br));
		mybrands.add(new Brand(R.drawable.ck));
		mybrands.add(new Brand(R.drawable.coach));
		mybrands.add(new Brand(R.drawable.columbia));
		mybrands.add(new Brand(R.drawable.eb));
		mybrands.add(new Brand(R.drawable.exp));
		mybrands.add(new Brand(R.drawable.f21));
		mybrands.add(new Brand(R.drawable.fossil));
		mybrands.add(new Brand(R.drawable.gap));
		mybrands.add(new Brand(R.drawable.guess));
		mybrands.add(new Brand(R.drawable.hd));
		mybrands.add(new Brand(R.drawable.holister));
		mybrands.add(new Brand(R.drawable.jc));
		mybrands.add(new Brand(R.drawable.jcrew));
		mybrands.add(new Brand(R.drawable.kohls));
		mybrands.add(new Brand(R.drawable.levi));
		mybrands.add(new Brand(R.drawable.macys));
		mybrands.add(new Brand(R.drawable.oldn));
		mybrands.add(new Brand(R.drawable.rl));
		mybrands.add(new Brand(R.drawable.sephora));
		mybrands.add(new Brand(R.drawable.spau));
		mybrands.add(new Brand(R.drawable.thl));
		mybrands.add(new Brand(R.drawable.vs));
		
	}
	private void populatelistView() {
		// TODO Auto-generated method stub
	ArrayAdapter<Brand> adapter	= new MyListAdapter();
	ListView list= (ListView)findViewById(R.id.BlistView);
	list.setAdapter(adapter);
	}
	private class MyListAdapter extends ArrayAdapter<Brand>{
		public MyListAdapter(){
			super(ButtonActivity.this, R.layout.item_view, mybrands);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure to have a view to work with
			View ItemView = convertView;
			if (ItemView == null){
				ItemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
			}
				//Finding the brand to work with
			   Brand currentbrand = mybrands.get(position);
			// Fill the Value
			   ImageView imageview = (ImageView)ItemView.findViewById(R.id.item_icon);
			   imageview.setImageResource(currentbrand.geticonID());
			return ItemView;
			
		}
		
	}
	private void registerclickcallback() {
		// TODO Auto-generated method stub
		ListView list= (ListView)findViewById(R.id.BlistView);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View viewclicked, int position,
					long Id) {
				// TODO Auto-generated method stub
			//TextView textview = (TextView) viewclicked;
			String message = "fetching in store coupons";
			Toast.makeText(ButtonActivity.this, message, Toast.LENGTH_LONG).show();
			//item details
			}
		});
	}
}
