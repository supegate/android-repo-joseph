package com.choonag.intent.two;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneActivity extends Activity implements android.view.View.OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        Button callB=(Button)findViewById(R.id.callB);
        callB.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), TwoActivity.class);
		intent.putExtra("name","±è¿µ±Ù");
		intent.putExtra("age",26);
		startActivity(intent);
		
	}

	
		
	}
