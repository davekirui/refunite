package com.mobile.refunite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
	public static final String DB_NAME="refunite"; 
	String sql="CREATE TABLE IF NOT EXISTS missing(_id INTEGER PRIMARY KEY AUTOINCREMENT,by TEXT,fn TEXT,ln TEXT,nick TEXT,gender TEXT,age TEXT,country TEXT,city TEXT,tribe TEXT,clan TEXT,sclan TEXT,mum TEXT,extra TEXT,status TEXT)";
	String sql1="CREATE TABLE IF NOT EXISTS assist(_id INTEGER PRIMARY KEY AUTOINCREMENT,phone TXT,email TEXT,fn TEXT,ln TEXT,nick TEXT,gender TEXT,age TEXT,country TEXT,city TEXT,tribe TEXT,clan TEXT,sclan TEXT,mum TEXT,extra TEXT,status TEXT)";
	
	public Database(Context c)
	{
		super(c,DB_NAME,null,1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);	
		db.execSQL(sql1);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP IF EXISTS table missing");
		db.execSQL("DROP IF EXISTS table assist");
		onCreate(db);	
	}
}

