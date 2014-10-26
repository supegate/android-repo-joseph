package com.choongang.file;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FileMainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "파일읽기")
		.setIcon(android.R.drawable.stat_notify_voicemail);
		menu.add(0, 1, 0, "파일쓰기")
		.setIcon(android.R.drawable.ic_menu_camera);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Intent intent1=new Intent();
			intent1.setClass(getApplicationContext(),FileReadActivity.class );
			startActivity(intent1);
			break;

		case 1:
			Intent intent2=new Intent();
			intent2.setClass(getApplicationContext(),FileWriteActivity.class );
			startActivity(intent2);
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}









