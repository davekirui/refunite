package com.mobile.refunite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Assist extends Activity {
String phone,email,fn,ln,nick,gender,age,country,city,tribe,clan,sclan,mum,extra,status;
SQLiteDatabase db;
ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assist);
		Database dbhelper=new Database(this);
		
		db=dbhelper.getWritableDatabase();
		
		Intent i=getIntent();
		String p=i.getStringExtra("code")+i.getStringExtra("number");
		
		phone=p;
		
		
		
	}
	 public void assist(View v)
	  {
		 new AsyncTask<Integer,Integer,Boolean>()
		 {
			 protected void onPreExecute()
	            {
	            	pd=new ProgressDialog(Assist.this);
	            	pd.setTitle("Saving...");
	            	pd.show();
	            	
	            }
			@Override
			protected Boolean doInBackground(Integer... arg0) {
				
				fn=((EditText)findViewById(R.id.fn)).getText().toString();		
				ln=((EditText) findViewById(R.id.ln)).getText().toString();
				nick=((EditText) findViewById(R.id.nick)).getText().toString();
				city=((EditText)findViewById(R.id.city)).getText().toString();
				country=((EditText) findViewById(R.id.country)).getText().toString();
				tribe=((EditText)findViewById(R.id.tribe)).getText().toString();
				clan=((EditText) findViewById(R.id.clan)).getText().toString();
				sclan=((EditText) findViewById(R.id.sclan)).getText().toString();
				mum=((EditText) findViewById(R.id.mum)).getText().toString();
				extra=((EditText)findViewById(R.id.extra)).getText().toString();
				email=((EditText) findViewById(R.id.email)).getText().toString();
				age=((EditText) findViewById(R.id.age)).getText().toString();
				gender=((Spinner) findViewById(R.id.gender)).getSelectedItem().toString();

			    status="0";
			 
			 ContentValues cv=new ContentValues();
				
				cv.put("phone", phone);
				cv.put("email", email);
				cv.put("fn", fn);
				cv.put("ln", ln);
				cv.put("gender", gender);
				cv.put("age", age);
				cv.put("country", country);
				cv.put("city", city);
				cv.put("tribe", tribe);
				cv.put("clan", clan);
				cv.put("mum", mum);
				cv.put("extra", extra);
				cv.put("status", status);
				cv.put("sclan", sclan);
				cv.put("nick", nick);
				
				
				db.insert("assist", null,cv);
				
				
				
				return true;
			}
			protected void onPostExecute(Boolean result)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pd.hide();
				Toast.makeText(getApplicationContext(), "Posted",Toast.LENGTH_LONG).show();
				
				Intent i=new Intent(Assist.this,Missing.class);
				i.putExtra("phone", phone);
				  startActivity(i);
			}
			 
		 }.execute(0);
		 
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
