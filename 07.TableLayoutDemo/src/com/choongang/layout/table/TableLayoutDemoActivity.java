package com.choongang.layout.table;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TableLayoutDemoActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    EditText et;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et=(EditText)findViewById(R.id.editText1);
        Button b1=(Button)findViewById(R.id.button1);
        Button b2=(Button)findViewById(R.id.button2);
        Button b3=(Button)findViewById(R.id.button3);
        Button b4=(Button)findViewById(R.id.button4);
    
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
	
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int bID=v.getId();
		switch (bID) {
		case R.id.button1:
			et.append("1");
			break;
		case R.id.button2:
			et.append("2");
			break;
		case R.id.button3:
			et.append("3");
			break;
		case R.id.button4:
			et.append("4");
			break;	
		default:
			break;
		}
	
	
	}
}