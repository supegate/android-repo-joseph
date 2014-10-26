package com.choongang.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 데이타베이스 객체생성과 사용,업그레이드에 관련된작업을수행
 * 
 * @author Administrator
 *
 */
public class DBHelper extends SQLiteOpenHelper{
	
	public DBHelper(Context context,String dbName,int version) {
		super(context, dbName, null, version);
	}
	/*최초한번호출(새로운데이타베이스가 생성될때)*/
	public void onCreate(SQLiteDatabase db) {
		String table_cars="CREATE TABLE cars("+
		"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
		"car_name TEXT NOT NULL);";
		db.execSQL(table_cars);
		
	}
	/* 기존버전번호보다 큰번호가 입력되면 호출*/
	public void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS cars");
		onCreate(db);
	}
	 /*
    DBHelper helper1=new DBHelper(this, "dbdemo.db", 1);
    onCreate 호출
    DBHelper helper2=new DBHelper(this, "dbdemo.db", 1);
    DBHelper helper3=new DBHelper(this, "dbdemo.db", 2);
    onUpgrade 호출
     */
}