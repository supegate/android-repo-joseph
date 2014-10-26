package com.choongang.http.html;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HttpGetHTMLActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
        Button viewB=(Button)findViewById(R.id.viewB);
        viewB.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		GetHTMLThread t=new GetHTMLThread();
		t.start();
	}
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				StringBuffer sb=(StringBuffer)msg.obj;
				EditText viewET=(EditText)findViewById(R.id.viewET);
				viewET.setText(sb.toString());
				break;
			case 1:
				Exception e=(Exception)msg.obj;
				Toast.makeText(getApplicationContext(), e.getMessage(), 3000).show();
				break;
			}
			

		};
	};
	
	class GetHTMLThread extends Thread{
		@Override
		public void run() {
			try {
				String urlStr="http://m.naver.com";
				//String urlStr="http://openapi.naver.com/search?key=38d29197789e1b4ee30924dfedec02e6&target=rank&query=nexearch";
				URL url=new URL(urlStr);
				InputStream in=url.openStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(in));
				StringBuffer sb=new StringBuffer();
				while(true){
					String readLine=br.readLine();
					if(readLine==null)break;
					sb.append(readLine+"\n");
				}
				br.close();
				Message msg=new Message();
				msg.what=0;
				msg.obj=sb;
				handler.sendMessage(msg);
			} catch (Exception e) {
				Message msg=new Message();
				msg.what=1;
				msg.obj=e;
				handler.sendMessage(msg);
			}
		}
	}
	
}









