package com.choongang.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		//Toast.makeText(context, "SMSReceiver.onReceive()",Toast.LENGTH_LONG).show();
		
		Object[] pdus=(Object[])intent.getExtras().get("pdus");
		SmsMessage[] msgs=null;
		String str="";
		
		msgs = new SmsMessage[pdus.length];
	
		for(int i=0;i<msgs.length;i++){
			msgs[i]= SmsMessage.createFromPdu((byte[])pdus[i]);
			str+="SMS µµÂø:"+msgs[i].getOriginatingAddress();
			str+=":"+msgs[i].getMessageBody();
			str+="\n";
			
			
			
			}
		Toast.makeText(context, str,Toast.LENGTH_LONG).show();
		
	
	}

}
