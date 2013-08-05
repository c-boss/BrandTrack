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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity{
	String curr_web_url, web_url; 
	private WebView mWebview ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		 mWebview  = new WebView(this);

	        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

	        final Activity activity = this;

	        mWebview.setWebViewClient(new WebViewClient() {
	            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
	                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
	            }
	        });
	        Intent i = getIntent();
			web_url = i.getStringExtra("Web_Url");
	        mWebview .loadUrl(web_url);
	        setContentView(mWebview );
		//Toast.makeText(getApplicationContext(), web_url, Toast.LENGTH_LONG).show();
	}
}