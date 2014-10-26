package com.ch.thread;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadActivity extends Activity {
	int mMainValue= 0;
	int mBackValue= 0;
	TextView mMainText;
	TextView mBackText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mMainText= (TextView)findViewById(R.id.mainvalue);
		mBackText= (TextView)findViewById(R.id.backvalue);
		Button btn= (Button)findViewById(R.id.increase);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mMainValue++;
				mMainText.setText("MainValue: " + mMainValue);
				//mBackText.setText("BackValue: " + mBackValue);
			}});
		BackThread thread = new BackThread();
		thread.setDaemon(true);
		thread.start();
	}
	/*************case 1******************/
	/*
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0){
				mBackText.setText("mBackValue:"+mBackValue);
			}
		};
	};
	*/
	/*************case 2******************/
	Handler handler=new Handler();

	class BackThread extends Thread {
		public void run() {
			while (true) {
				mBackValue++;
				//mBackText.setText("BackValue: " + mBackValue);
				/**************case1***************/
				//Message msg=new Message();
				//msg.what = 0;
				//handler.sendMessage(msg);
				/**************case2***************/
				handler.post(new Runnable() {
					public void run() {
						mBackText.setText("BackValue: " + mBackValue);
					}
				});

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
				
					
				
			}//end while
		}//run method end
	}//inner class end
}//outer class end