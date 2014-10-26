package com.choongang.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WidgetDemoActivity extends Activity {
	/** Called when the activity is first created. */
	Button b;
	TextView tv;
	EditText et;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		b=(Button)findViewById(R.id.button1);
		tv=(TextView)findViewById(R.id.textview1);
		et=(EditText)findViewById(R.id.editText1);

		Object oo=new Object(){

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "ÈÄÈÄÈÄ";
			}


		};



		/**************case 1***************/
		//b.setOnClickListener(new ButtonHandler());
		/**************case 2***************
		b.setOnClickListener(
				new OnClickListener(){
					public void onClick(View v) {

						String str=et.getText().toString();
						tv.setText(str);
						et.setText("");
					}

				}
		);
		 **************************************/
		/****************case3******************/
		b.setOnClickListener(bh);
	}
	/*************case3************/
	public OnClickListener bh = new OnClickListener(){
		public void onClick(View v) {

			String str=et.getText().toString();
			tv.setText(str);
			et.setText("");
		};
	};

		/**************case 1***************
	class ButtonHandler implements OnClickListener{
		public void onClick(View v) {

			String str=et.getText().toString();
			tv.setText(str);
			et.setText("");
		}

	}
		 **************************/
	}	

