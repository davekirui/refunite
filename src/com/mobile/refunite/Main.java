package com.mobile.refunite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class Main extends Activity {
SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Database dbhelper=new Database(this);
		
		db=dbhelper.getWritableDatabase();
		
		//EditText Ids
		
		
		//Send to DB
		
		ContentValues cv=new ContentValues();	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
  public void assist(View v)
  {
	  Intent i=new Intent(this,Mobile.class);
	  startActivity(i);
  }
  public void settings(View v)
  {
	  Intent i=new Intent(this,Settings.class);
	  startActivity(i);
  }
  public void sync(View v)
  {
	  Intent i=new Intent(this,Sync.class);
	  startActivity(i);
  }
}
