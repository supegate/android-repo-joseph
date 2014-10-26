package com.choonag.intent.two;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		String name=bundle.getString("name");
		int age=bundle.getInt("age");
		TextView displayTV=(TextView)findViewById(R.id.displayTV);
		displayTV.setText("name:"+name+",age"+age);
		
		
	}

}
