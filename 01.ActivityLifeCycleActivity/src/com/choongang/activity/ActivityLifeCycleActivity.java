package com.choongang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifeCycleActivity extends Activity {
    /** Called when the activity is first created. */
    public ActivityLifeCycleActivity(){
    	Log.d("guard","ActivityLifeCycleActivity()");
    }
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	Log.d("guard","onStart()");
    }
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	Log.d("guard","onRetart()");
    }
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	Log.d("guard","onResume()");
    }
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	Log.d("guard","onPause()");
    }
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	Log.d("guard","onStop()");
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	Log.d("guard","onDestroy()");
    }
}