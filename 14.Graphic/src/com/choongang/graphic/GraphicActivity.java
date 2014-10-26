package com.choongang.graphic;

import android.app.Activity;
import android.os.Bundle;

public class GraphicActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView mv=new MyView(this);
        setContentView(mv);
    }
}