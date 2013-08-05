/*
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

import java.io.*;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.json.*;

import android.util.Log;
import java.net.*;

public class JSONParser {

    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JSONParser() {}

    public JSONObject getJSONFromUrl(String url) {
    	
        // Making HTTP request
        try {
            // defaultHttpClient
            URL brand = new URL(url);
            URLConnection brandname = brand.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(brandname.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            json = sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
         return jObj;
    }
}