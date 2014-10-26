package com.choongang.layout.xml;

import java.util.Date;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloLayoutXMLActiviry extends Activity implements OnClickListener{
	
    /** Called when the activity is first created. */
    Button b;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        b = (Button)this.findViewById(R.id.myButton);
        b.setOnClickListener(this);
	}
	public void onClick(View arg0) {
		Date d=new Date();
		b.setText(d.toString());
	}
}