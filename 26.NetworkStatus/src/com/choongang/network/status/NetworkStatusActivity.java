package com.choongang.network.status;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NetworkStatusActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    TextView displayTV;
    NetworkInfo network1;
    NetworkInfo network2;
    NetworkInfo network3;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn=(Button)findViewById(R.id.Button01);
        btn.setOnClickListener(this);
        
        ConnectivityManager cMgr =
        	(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        network1=cMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        network2=cMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        network3=cMgr.getActiveNetworkInfo();
        displayTV=(TextView)findViewById(R.id.displayTV);
        
    }
	@Override
	public void onClick(View v) {
		StringBuffer sb=new StringBuffer();
		sb.append("========ConnectivityManager.TYPE_MOBILE====\n");
		sb.append("isAvailable:"+network1.isAvailable()+"\n");
		sb.append("isConnected:"+network1.isConnected()+"\n");
		sb.append("isFailover:"+network1.isFailover()+"\n");
		sb.append("isRoaming:"+network1.isRoaming()+"\n");
		sb.append("=====ConnectivityManager.TYPE_WIFI======\n");
		sb.append("isAvailable:"+network2.isAvailable()+"\n");
		sb.append("isConnected:"+network2.isConnected()+"\n");
		sb.append("isFailover:"+network2.isFailover()+"\n");
		sb.append("isRoaming:"+network2.isRoaming()+"\n");
		sb.append("======getActiveNetworkInfo=====\n");
		sb.append("isAvailable:"+network3.isAvailable()+"\n");
		sb.append("isConnected:"+network3.isConnected()+"\n");
		sb.append("isFailover:"+network3.isFailover()+"\n");
		sb.append("isRoaming:"+network3.isRoaming()+"\n");
		displayTV.setText(sb.toString());
	}
	
}








