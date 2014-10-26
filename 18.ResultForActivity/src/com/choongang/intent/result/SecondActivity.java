package com.choongang.intent.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		((Button)findViewById(R.id.finishB)).setOnClickListener(
		
				new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						//데이터저장
						Intent intent=new Intent();
						intent.putExtra("name","김영근");
						intent.putExtra("age",26);
						setResult(Activity.RESULT_OK,intent);
						//종료
						finish();
					}
				}
		
		
		
		
		);
	}
}
