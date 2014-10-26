package com.choongang.broadcast.send;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SendBroadcastActivity extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		((Button)findViewById(R.id.sendB)).setOnClickListener(this);
	}
		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			intent.setAction("com.choongang.my.receiver.MY_RECEIVER");
			sendBroadcast(intent);

		}
	}