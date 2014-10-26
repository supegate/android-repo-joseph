package com.choongang.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * ����Ÿ���̽� ��ü������ ���,���׷��̵忡 ���õ��۾�������
 * 
 * @author Administrator
 *
 */
public class DBHelper extends SQLiteOpenHelper{
	
	public DBHelper(Context context,String dbName,int version) {
		super(context, dbName, null, version);
	}
	/*�����ѹ�ȣ��(���ο��Ÿ���̽��� �����ɶ�)*/
	public void onCreate(SQLiteDatabase db) {
		String table_cars="CREATE TABLE cars("+
		"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
		"car_name TEXT NOT NULL);";
		db.execSQL(table_cars);
		
	}
	/* ����������ȣ���� ū��ȣ�� �ԷµǸ� ȣ��*/
	public void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS cars");
		onCreate(db);
	}
	 /*
    DBHelper helper1=new DBHelper(this, "dbdemo.db", 1);
    onCreate ȣ��
    DBHelper helper2=new DBHelper(this, "dbdemo.db", 1);
    DBHelper helper3=new DBHelper(this, "dbdemo.db", 2);
    onUpgrade ȣ��
     */
}