package com.choongang.intent.other.call;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OtherAppActivityCallActivity extends Activity implements OnClickListener { 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button callB=(Button)findViewById(R.id.callB);
        callB.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		Intent intent=new Intent();
		intent.setAction("com.choongang.intent.other.called.MY_ACTIVITY");
		startActivity(intent);
		
	}
}