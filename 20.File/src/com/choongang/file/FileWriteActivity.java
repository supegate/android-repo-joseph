package com.choongang.file;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileWriteActivity  extends Activity implements android.view.View.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write);
		((Button)findViewById(R.id.saveB)).setOnClickListener(this);
	
	
	}

	@Override
	public void onClick(View v) {
	 try {
		 String saveStr=
			 ((EditText)findViewById(R.id.writeET)).getText().toString();
		 
		 /*******1.sd카드*******/
		 //FileOutputStream fos=new FileOutputStream("/sdcard/sdcard_out.txt");
		 /*******2.내장메모리쓰기********/
		 FileOutputStream fos = openFileOutput("in_memory.txt",Context.MODE_PRIVATE);
		 
		 OutputStreamWriter osw=new OutputStreamWriter(fos);
		 osw.write(saveStr);
		 osw.flush();
		 osw.close();
		 
		 Toast.makeText(getApplicationContext(),"save success!",Toast.LENGTH_LONG).show();
	 
	 } catch (Exception e) {
		
		// TODO: handle exception
	}
			
			
	}
}
	

