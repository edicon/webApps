package com.edicon.lib.webapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

/**
 * @date	2013.1010
 * 			Android Chrome Version 25부터, 그이전버전은 <iframe src="paulsawesomeapp://page1"> </iframe>
 * 			설치되어 있지 않거나 scheme://host/가 Match되지 않으면 패키지 이름으로 Player Store로 이동함.
 * @link	https://developers.google.com/chrome/mobile/docs/intents?hl=ko
 * 
 * @author 	EDICON. HyunSoo Lee
 *
 */
public class WebAppActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_app);
		
		Intent i = getIntent();
		
		String action 	= i.getAction();
		String scheme 	= i.getScheme();
		String data		= i.getDataString(); 
		String type		= i.getType();
		String pkg		= i.getPackage();
		Uri uriData 	= i.getData();
		String webIntent	
					= "Action: " 	+ action + "\n"
					+ " scheme: "	+ scheme + "\n"
					+ " data: " 	+ data + "\n"
					+ " type: " 	+ type + "\n"
					+ " pkg: " 		+ pkg + "\n"
					+ " uriData: " 	+ uriData;
		TextView webText = (TextView) findViewById(R.id.webapp_text);
		webText.setText(webIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_app, menu);
		return true;
	}

}
