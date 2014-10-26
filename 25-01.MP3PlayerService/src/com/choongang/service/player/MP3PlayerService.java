package com.choongang.service.player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MP3PlayerService extends Service{














	MediaPlayer mp;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d("MP3PlayerService","onCreate()...");
		mp=MediaPlayer.create(getApplicationContext(),R.raw.test);
	}
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.d("MP3PlayerService","onStart()...");
		if(!mp.isPlaying()&& mp!=null){
			mp.start();
		}
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("MP3PlayerService","onDestroy()...");
		mp.stop();
	}

}
