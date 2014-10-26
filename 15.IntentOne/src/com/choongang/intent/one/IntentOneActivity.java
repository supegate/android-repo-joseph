package com.choongang.intent.one;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentOneActivity extends Activity  implements OnClickListener{
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
		intent.setAction(Intent.ACTION_DIAL);
		Uri data =Uri.parse("tel:5556");
		intent.setData(data);
		startActivity(intent);
		
		
	}
}