package com.choongang.notification1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NotificationActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button toastB=(Button)findViewById(R.id.toastB);
        Button dialogB=(Button)findViewById(R.id.dialogB);
        toastB.setOnClickListener(this);
        dialogB.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		int bId=v.getId();
		switch (bId) {
		case R.id.toastB:
			Toast t = Toast.makeText(this,"�ȳ�",Toast.LENGTH_LONG);
			t.show();
			
			break;

		case R.id.dialogB:
			AlertDialog.Builder adb=new AlertDialog.Builder(this);
			adb.setTitle("�迵��");
			adb.setMessage("���ִ�");
			adb.setIcon(android.R.drawable.sym_call_outgoing);
			adb.setNeutralButton("����",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(),"Ȯ�ι�ưó�� �������� ���ϱ��",Toast.LENGTH_SHORT).show();
					
				}
			});
			adb.setNegativeButton("������",null);
			adb.show();
			break;
		}
	}
}









