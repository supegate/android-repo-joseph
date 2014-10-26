package com.choongang.alarm;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class AlarmActivity extends Activity implements OnDateChangedListener,OnTimeChangedListener{
    /** Called when the activity is first created. */
    private AlarmManager mManager;
	private GregorianCalendar mCalendar;
	
	private DatePicker mDate;
	private TimePicker mTime;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_set);
        mManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        mCalendar=new GregorianCalendar();
        
        mDate=(DatePicker)findViewById(R.id.date_picker);
        mDate.init(mCalendar.get(Calendar.YEAR),
        		   mCalendar.get(Calendar.MONTH),
        		   mCalendar.get(Calendar.DAY_OF_MONTH),
        						this);
        
        mTime=(TimePicker)findViewById(R.id.time_picker);
        mTime.setCurrentHour(mCalendar.get(Calendar.HOUR_OF_DAY));
        mTime.setCurrentMinute(mCalendar.get(Calendar.MINUTE));
        mTime.setOnTimeChangedListener(this);
        
        Button setB=(Button)findViewById(R.id.set);
        setB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				setAlarm();
				
			}

			
		});
        
        
        Button resetB=(Button)findViewById(R.id.reset);
        resetB.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 resetAlarm();
				
			}
		});
        
        
    }
	private void setAlarm() {
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), AlarmStartActivity.class);
		PendingIntent operationPI=
			PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
		
		mManager.set(AlarmManager.RTC_WAKEUP, 
				mCalendar.getTimeInMillis(),
				operationPI);
	//	finish();
	}
	private void resetAlarm() {
		Intent intent=new Intent();
		intent.setClass(getApplicationContext(), AlarmStartActivity.class);
		PendingIntent operationPI=
			PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
		mManager.cancel(operationPI);
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		mCalendar.set(year, monthOfYear, 
				dayOfMonth, mTime.getCurrentHour(),
				mTime.getCurrentMinute());
		
	}


	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		mCalendar.set(mDate.getYear(), mDate.getMonth(),
				mDate.getDayOfMonth(), hourOfDay,
				minute);
		
	}
}




