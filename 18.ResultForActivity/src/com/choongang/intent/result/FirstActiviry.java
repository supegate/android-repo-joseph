package com.choongang.intent.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActiviry extends Activity {
	/** Called when the activity is first created. */
	public static final int REQUEST_DATA=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		Button callB=(Button)findViewById(R.id.callB);
		callB.setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent=new Intent();
						intent.setClass(getApplicationContext(),SecondActivity.class );
						//startActivity(intent);
						startActivityForResult(intent,REQUEST_DATA);
					}

				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_DATA) {
			if (resultCode == Activity.RESULT_OK) {

				String name = data.getExtras().getString("name");
				int age = data.getExtras().getInt("age");
				((TextView)findViewById(R.id.resultTV))
				.setText("name="+name+",age="+age);
			}

		}
	}

}
