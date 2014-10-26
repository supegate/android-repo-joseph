package com.choongang.service.player.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MP3PlayerServiceUIActivity extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button playB=(Button)findViewById(R.id.playB);
		Button stopB=(Button)findViewById(R.id.stopB);
		playB.setOnClickListener(this);
		stopB.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int bId=v.getId();
		if(bId==R.id.playB){
			
			Intent intent=new Intent();
			intent.setAction("com.choongang.service.player.MY_PLAYER");
			
			//startActivity(intent);
			startService(intent);
			//sendBroadcast(intent);
			
		}else if(bId==R.id.stopB){
			Intent intent1=new Intent();
			intent1.setAction("com.choongang.service.player.MY_PLAYER");
			stopService(intent1);
		}

	}
}