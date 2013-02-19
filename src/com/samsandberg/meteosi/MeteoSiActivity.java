package com.samsandberg.meteosi;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MeteoSiActivity extends Activity {
	protected String METEO_URL = "http://www.meteo.si/uploads/probase/www/observ/radar/si1_zm_si_latest.jpg";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        
        ImageView iv = new ImageView(this);
        URL url = null;
		try {
			url = new URL(METEO_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Toast.makeText(this, "Error: Malformed URL", Toast.LENGTH_SHORT).show();
			finish();
		}
		
        InputStream content = null;
		try {
			content = (InputStream)url.getContent();
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "Error: Unable to download latest image", Toast.LENGTH_SHORT).show();
			finish();
		}
		
        Drawable d = Drawable.createFromStream(content , "src"); 
        iv.setImageDrawable(d);
        setContentView(iv);
    }
}