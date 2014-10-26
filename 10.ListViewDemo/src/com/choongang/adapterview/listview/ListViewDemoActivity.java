package com.choongang.adapterview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewDemoActivity extends Activity {
    /** Called when the activity is first created. */
    String[] carNames={"SM3","SM5","SM7","SONATA","GRANDEUR","AUDI","LEXUS"};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView=(ListView)findViewById(R.id.listView1);
        //ArrayAdapter adapter=
        	//new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,carNames );
      ArrayAdapter adapter=
    	new ArrayAdapter(this,R.layout.row,carNames );
        
        listView.setAdapter(adapter);
        
	}
}