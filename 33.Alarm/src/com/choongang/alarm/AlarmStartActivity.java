package com.choongang.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmStartActivity extends Activity{
	private AlarmManager mManager;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm);
		mManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
		mp=MediaPlayer.create(getApplicationContext(), R.raw.test);
		mp.start();
		//¹öÆ°
		Button b=(Button)findViewById(R.id.reset);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.stop();
				finish();
				//alarm cancle
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), AlarmStartActivity.class);
				PendingIntent pi=
					PendingIntent.getActivity(getApplicationContext(),
							0, intent, 0);
				mManager.cancel(pi);
			}
		});
	}
}
