package com.choongang.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/*
 * 클라이언트(Activity,View)의 요청을 받아
 * 데이타베이스에 insert,delete,select,update 작업을 하는클래스(DAO)
 * 
 * - DBHandler를 사용(Connection)
 * 
 */
public class DBHandler {
	private Context ctx;
	private DBHelper helper;
	private SQLiteDatabase db;//(Connection)
	private static DBHandler _instance;
	private DBHandler(Context ctx) {
		this.ctx=ctx;
		this.helper=new DBHelper(ctx,"dbdemo.db",1);
		this.db=helper.getWritableDatabase();
	}
	//singleton
	public static DBHandler open(Context ctx)
	throws SQLException{
		if(_instance==null){
			_instance=new DBHandler(ctx);
		}
		return _instance;
	}
	public void close(){
		helper.close();
	}
	//insert
	public long insert(String car_name){
			ContentValues values=new ContentValues();
			values.put("car_name", car_name);
			long result=db.insert("cars", null, values);
			return result;		
	}
	//query
	public Cursor selectOne(String _id){
		/*********case1***********/
		Cursor cursor=db.query(true,
				"cars",
				new String[]{"_id","car_name"},
				"_id=?",
				new String[]{_id}, null, null, null, null);
		/***********case2*********/
		//String sql="select _id,car_name from cars where _id=?";
		//Cursor cursor=db.rawQuery(sql, new String[]{_id});
		
		
		return cursor;
	
	}
	public Cursor selectAll() {
		db.query(true,"cars",new String[]{"_id","car_name"},
				null,null,null,
				null,"car_name asc",null);
		
		//db.rawQuery("select*from cars order by car_name asc",null);
		return null;
		
		
		
		
		
	}
	//delete
	//update
	

}
