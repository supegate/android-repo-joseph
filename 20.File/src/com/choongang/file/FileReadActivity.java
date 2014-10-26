package com.choongang.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileReadActivity  extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		Button viewB=(Button)findViewById(R.id.viewB);
		viewB.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		try {
			/*******1.SDCARD로부터읽기******/
			//FileInputStream is=new FileInputStream("/sdcard/");
			//InputStreamReader isr=new InputStreamReader(is);
			//BufferedReader br=new BufferedReader(isr);

			/*******2.내장메모리 로부터읽기******/
			FileInputStream is=openFileInput("in_memory.txt");
			/*******3.res로부터읽기******/
			//InputStream is=getResources().openRawResource(R.raw.res_text);
			
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			StringBuffer sb=new StringBuffer();
			
			while(true){
				String readLine=br.readLine();
				if(readLine==null)break;
				sb.append(readLine+"\n");
			}
			br.close();
			((EditText)findViewById(R.id.viewET)).setText(sb.toString());




		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"애로:"+e.getMessage(),
					Toast.LENGTH_LONG).show();

		}



	}
}













