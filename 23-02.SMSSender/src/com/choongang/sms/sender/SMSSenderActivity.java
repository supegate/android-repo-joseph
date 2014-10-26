package com.choongang.sms.sender;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SMSSenderActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((Button)findViewById(R.id.sendB)).setOnClickListener(this);
        
        
    }

 @Override
 public void onClick(View v) {
  SmsManager smsManager = SmsManager.getDefault();
  smsManager.sendTextMessage("01022061591",null,"fuck",null,null);
 }
}
