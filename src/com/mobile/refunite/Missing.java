package com.mobile.refunite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Missing extends Activity{
	ProgressDialog pd;
	String phone,email,fn,ln,nick,gender,age,country,city,tribe,clan,sclan,mum,extra,status;
	SQLiteDatabase db;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.missing);
			
			Database dbhelper=new Database(this);
			
			db=dbhelper.getWritableDatabase();
			
			//EditText Ids	
			
			//Send to DB
		    
			
		}

		public void missing(View v)
		{
			new AsyncTask<Integer,Integer,Boolean>()
			{
				 protected void onPreExecute()
		            {
		            	pd=new ProgressDialog(Missing.this);
		            	pd.setTitle("Saving...");
		            	pd.show();
		            	
		            }

				@Override
				protected Boolean doInBackground(Integer... params) {
					
					String p=getIntent().getStringExtra("phone");
					
					phone=p;
				    
				    status="0";
					
					fn=((EditText)findViewById(R.id.mfn)).getText().toString();
					
					ln=((EditText)findViewById(R.id.mln)).getText().toString();
					nick=((EditText)findViewById(R.id.mnick)).getText().toString();
					city=((EditText)findViewById(R.id.mcity)).getText().toString();
					country=((EditText)findViewById(R.id.mcountry)).getText().toString();
					tribe=((EditText)findViewById(R.id.mtribe)).getText().toString();
					clan=((EditText)findViewById(R.id.mclan)).getText().toString();
					sclan=((EditText)findViewById(R.id.msclan)).getText().toString();
					mum=((EditText)findViewById(R.id.mmum)).getText().toString();
					extra=((EditText)findViewById(R.id.mextra)).getText().toString();
					age=((EditText)findViewById(R.id.mage)).getText().toString();
					gender=((Spinner)findViewById(R.id.mgender)).getSelectedItem().toString();

				    

					
					ContentValues cv=new ContentValues();
					
					cv.put("by", phone);
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
					
					
					db.insert("missing", null,cv);
					
					
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
				}
			}.execute(0);
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.activity_main, menu);
			return true;
		}
		
		


}
