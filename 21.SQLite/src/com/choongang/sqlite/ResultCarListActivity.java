package com.choongang.sqlite;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultCarListActivity extends Activity{
	ArrayList<Car> carList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_car_list);
	    ListView listView=(ListView)findViewById(R.id.carListView);
		
	    Intent intent = getIntent();
	    carList=(ArrayList<Car>)intent.getExtras().get("carList");
		
	    listView.setAdapter(new CarListAdapter());
	    
	    //Toast.makeText(getApplicationContext(), carList+"", Toast.LENGTH_LONG).show();
	}
	class CarListAdapter  extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return carList.size();
		}

		@Override
		public Car getItem(int position) {
			// TODO Auto-generated method stub
			return carList.get(position);
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=getLayoutInflater();
			View view=inflater.inflate(R.layout.list_cell, null);
			TextView idTV=(TextView)view.findViewById(R.id.idTV);
			TextView nameTV=(TextView)view.findViewById(R.id.nameTV);
			
			Car car=carList.get(position);
			//Car car=getItem(position);
			idTV.setText(car._id+"");
			nameTV.setText(car.car_name);
			
			return view;
		}
	}
}
