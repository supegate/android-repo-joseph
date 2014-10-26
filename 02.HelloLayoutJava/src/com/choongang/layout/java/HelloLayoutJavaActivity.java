package com.choongang.layout.java;



import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HelloLayoutJavaActivity extends Activity 
implements View.OnClickListener {
	/** Called when the activity is first created. */
	Button b;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		b=new Button(this);
		b.setText("자바코드로만든버튼");
		this.setContentView(b);
		b.setOnClickListener(this);
	}
	public void onClick(View v){
		Date d=new Date();
		b.setText(d.toString());

		}	




	}