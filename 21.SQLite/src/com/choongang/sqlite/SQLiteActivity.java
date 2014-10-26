package com.choongang.sqlite;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button insertB=(Button)findViewById(R.id.insert);
		Button selectOneB=(Button)findViewById(R.id.selectOne);
		Button selectAllB=(Button)findViewById(R.id.selectAll);

		insertB.setOnClickListener(this);
		selectOneB.setOnClickListener(this);
		selectAllB.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		DBHandler handler=DBHandler.open(this);

		int bId=view.getId();
		switch (bId) {
		case R.id.insert:
			EditText nameET=(EditText)findViewById(R.id.nameET);
			String car_name =nameET.getText().toString();
			long result=handler.insert(car_name); 
			String msg="";
			if(result>0){
				msg="insert success";
			}else{
				msg="insert fail";
			}
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
			break;
		case R.id.selectOne:
			EditText idET = (EditText)findViewById(R.id.idET);
			String idStr=idET.getText().toString();
			Cursor cursor=handler.selectOne(idStr);
			if(cursor!=null){
				if(cursor.moveToNext()){
					int id=cursor.getInt(0);
					String cn=cursor.getString(1);
					Toast.makeText(getApplicationContext(), id+":"+cn, Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getApplicationContext(),
							"NODATA",
							Toast.LENGTH_LONG).show();
				}
			}
			break;
		case R.id.selectAll:
			Cursor cursor1=handler.selectAll();
			ArrayList<Car> carList=new ArrayList<Car>(); 
			while(cursor1.moveToNext()){
				Car car=new Car();
				car.car_name=cursor1.getString(1);
				car._id=cursor1.getInt(0);
				carList.add(car);
			}
			cursor1.close();
			
			Intent intent=new Intent();
			intent.setClass(getApplicationContext(), ResultCarListActivity.class);
			intent.putExtra("carList",carList);
			startActivity(intent);
			
			
			break;
		}//end case
	}//end method
}//end class