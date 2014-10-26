package com.choongang.intent.menu;

import java.io.File;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;

public class MenuIntentActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	public static final int CALL_TEL=Menu.FIRST;
	public static final int WEB_SEARCH=Menu.FIRST+1;
	public static final int GOOGLE_MAP=Menu.FIRST+2;
	public static final int CONTACTS=Menu.FIRST+3;
	public static final int AUDIO1=Menu.FIRST+4;
	public static final int AUDIO2=Menu.FIRST+5;
	public static final int VIDEO=Menu.FIRST+6;
	public static final int SMS=Menu.FIRST+7;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE,CALL_TEL,Menu.NONE,"콜텔")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,WEB_SEARCH,Menu.NONE,"웹서치")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,GOOGLE_MAP,Menu.NONE,"구글맵")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,CONTACTS,Menu.NONE,"콘택츠")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,AUDIO1,Menu.NONE,"오디1")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,AUDIO2,Menu.NONE,"오디2")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,VIDEO,Menu.NONE,"비디")
		.setIcon(android.R.drawable.editbox_background_normal);
		menu.add(Menu.NONE,SMS,Menu.NONE,"sms")
		.setIcon(android.R.drawable.editbox_background_normal);

		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId){
		case CALL_TEL:
			Intent intent1 =new Intent();
			intent1.setAction(android.content.Intent.ACTION_CALL);
			intent1.setData(Uri.parse("tel:5544"));
			startActivity(intent1);





			break;

		case WEB_SEARCH:
			Intent intent2 =new Intent(Intent.ACTION_WEB_SEARCH);
			intent2.putExtra(SearchManager.QUERY, "android");
			startActivity(intent2);



			break;
		case GOOGLE_MAP:
			Intent intent3 =new Intent(Intent.ACTION_VIEW,Uri.parse("geo:127,37?q=seoul"));
			startActivity(intent3);


			break;
		case CONTACTS:
			Intent intent4 =new Intent();
			intent4.setAction(android.content.Intent.ACTION_VIEW);
			intent4.setData(ContactsContract.Contacts.CONTENT_URI);
			startActivity(intent4);



			break;
		case AUDIO1:
			Intent intent5 =new Intent(Intent.ACTION_GET_CONTENT);
			intent5.setType("audio/*");
			startActivity(intent5);


			break;
		case AUDIO2:
			Intent intent6 =new Intent(Intent.ACTION_VIEW);
			File file1=new File("/sdcard/test.mp3");
			intent6.setDataAndType(Uri.fromFile(file1),"audio/*");
			startActivity(intent6);



			break;
		case VIDEO:
			break;
		case SMS:
			Intent intent8=new Intent();
			intent8.setAction(Intent.ACTION_SENDTO);
			intent8.setData(Uri.parse("sms:01091000055"));
			intent8.putExtra("sms_body", "낼봐요");
			startActivity(intent8);


			break;






		}




		return super.onOptionsItemSelected(item);
	}




}