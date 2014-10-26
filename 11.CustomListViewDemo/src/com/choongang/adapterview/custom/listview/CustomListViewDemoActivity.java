package com.choongang.adapterview.custom.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListViewDemoActivity extends Activity {
    /** Called when the activity is first created. */
    Car[] cars={
    		new Car(R.drawable.car1,"SM3"),
    		new Car(R.drawable.car2,"SM5"),
    		new Car(R.drawable.car3,"SM7"),
    		new Car(R.drawable.car4,"SONATA"),
    		new Car(R.drawable.car5,"AUDI"),
    		new Car(R.drawable.car6,"LEXUS")
    		};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listview=(ListView)findViewById(R.id.listView1);
        listview.setAdapter(new CarListAdapter());
    }
    /************adapter(inner class)*******/
    class CarListAdapter extends BaseAdapter{
		
    	@Override
		public int getCount() {
			return cars.length;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = getLayoutInflater();
			View view=inflater.inflate(R.layout.row,null);
			ImageView CarImage=(ImageView)view.findViewById(R.id.carImage);
			TextView carName=(TextView)view.findViewById(R.id.carName);
			CarImage.setImageResource(cars[position].carImage);
			carName.setText(cars[position].carName);
			
			return view;
		}
		@Override
		public Object getItem(int position) {
			return null;
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
    }
    
    /***************************************/
}