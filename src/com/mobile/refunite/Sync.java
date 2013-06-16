package com.mobile.refunite;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class Sync extends Activity{
	
	String m_code,from,meal;
	int tumepata;
	JSONParser jParser = new JSONParser();
	ProgressDialog pd;
	String Sync_url= "http://192.168.43.38/refunite/assist.php";
	String Sync_url2= "http://192.168.43.38/refunite/missing.php";
	String mcode;
	String phone;
	SQLiteDatabase db;
	SharedPreferences sp1;
	
	public void onCreate(Bundle s)
	{
		super.onCreate(s);
		Database dbhelper=new Database(this);
		db=dbhelper.getWritableDatabase();
	place(null);
	}
	
	
	public void place(View v)
	{
		new AsyncTask<Integer,Integer,Boolean>()
		{
			public void onPreExecute()
			{
				pd=new ProgressDialog(Sync.this);
				pd.setMessage("Placing Sync...");
				pd.show();
				
			}

			@Override
			protected Boolean doInBackground(Integer... arg0) {
				request(null);
				missing(null);
				
				return true;
			}
			public void onPostExecute(Boolean result)
			{
				pd.hide();
				
			        Toast.makeText(Sync.this,"Successfully Placed Sync",Toast.LENGTH_LONG).show() ; 
			       
			}
			
		}.execute(0);
		
		
		
	}

	public void request(View v)
	{ 
	       
		String selection="status=?";
		String []selectionArgs={"0"};
		Cursor c=db.query("assist",null,selection,selectionArgs,null,null,null);	   
		
		  c.moveToFirst();
		   
		   while(!c.isAfterLast())
		   {
			  
			   
			   String phone=c.getString(c.getColumnIndex("phone"));
			   String email=c.getString(c.getColumnIndex("email"));
			   String fn=c.getString(c.getColumnIndex("fn"));
			   String ln=c.getString(c.getColumnIndex("ln"));
			   String nick=c.getString(c.getColumnIndex("nick"));
			   String gender=c.getString(c.getColumnIndex("gender"));
			   String _id=c.getString(c.getColumnIndex("_id"));
			   String age=c.getString(c.getColumnIndex("age"));
			   String country=c.getString(c.getColumnIndex("country"));
			   String city=c.getString(c.getColumnIndex("city"));
			   String tribe=c.getString(c.getColumnIndex("tribe"));
			   String clan=c.getString(c.getColumnIndex("clan"));
			   String sclan=c.getString(c.getColumnIndex("sclan"));
			   String mum=c.getString(c.getColumnIndex("mum"));
			   String extra=c.getString(c.getColumnIndex("extra"));
			   
		
		    List<NameValuePair> params=new ArrayList<NameValuePair>(); 			
				params.add(new BasicNameValuePair("phone",phone));	
				params.add(new BasicNameValuePair("email",email));
				params.add(new BasicNameValuePair("fn",fn));
				params.add(new BasicNameValuePair("ln",ln));
				params.add(new BasicNameValuePair("nick",nick));
				params.add(new BasicNameValuePair("gender",gender));
				params.add(new BasicNameValuePair("age",age));
				params.add(new BasicNameValuePair("country",country));
				params.add(new BasicNameValuePair("city",city));
				params.add(new BasicNameValuePair("tribe",tribe));
				params.add(new BasicNameValuePair("clan",clan));
				params.add(new BasicNameValuePair("sclan",sclan));
				params.add(new BasicNameValuePair("mum",mum));
				params.add(new BasicNameValuePair("extra",extra));
				
	        JSONObject json=jParser.makeHttpRequest(Sync_url, "POST", params);
	        
	        ContentValues cvU=new ContentValues();
	        cvU.put("status","1");
	        String whereClause="_id=?";
	        String[] whereArgs={_id};
	        
	        db.update("assist",cvU, whereClause, whereArgs);
	        
	       c.moveToNext(); 
	        
		  }	
	     /*   try{
	        	tumepata=json.getInt("tumepata");
	        }
	        catch(Exception e)
	        {
	        	//Log.d("Waitress App : ", e.getMessage());
	        }
	        */ 
	        
	     
	       
	           
		}
	
	
	public void missing(View v)
	{ 
	       
		String selection="status=?";
		String []selectionArgs={"0"};
		Cursor c=db.query("missing",null,selection,selectionArgs,null,null,null);	   
		
		  c.moveToFirst();
		   
		   while(!c.isAfterLast())
		   {
			  
			   
			   String phone=c.getString(c.getColumnIndex("by"));
			   String fn=c.getString(c.getColumnIndex("fn"));
			   String ln=c.getString(c.getColumnIndex("ln"));
			   String nick=c.getString(c.getColumnIndex("nick"));
			   String gender=c.getString(c.getColumnIndex("gender"));
			   String _id=c.getString(c.getColumnIndex("_id"));
			   String age=c.getString(c.getColumnIndex("age"));
			   String country=c.getString(c.getColumnIndex("country"));
			   String city=c.getString(c.getColumnIndex("city"));
			   String tribe=c.getString(c.getColumnIndex("tribe"));
			   String clan=c.getString(c.getColumnIndex("clan"));
			   String sclan=c.getString(c.getColumnIndex("sclan"));
			   String mum=c.getString(c.getColumnIndex("mum"));
			   String extra=c.getString(c.getColumnIndex("extra"));
			   
		
		    List<NameValuePair> params=new ArrayList<NameValuePair>(); 			
				params.add(new BasicNameValuePair("phone",phone));
				params.add(new BasicNameValuePair("fn",fn));
				params.add(new BasicNameValuePair("ln",ln));
				params.add(new BasicNameValuePair("nick",nick));
				params.add(new BasicNameValuePair("gender",gender));
				params.add(new BasicNameValuePair("age",age));
				params.add(new BasicNameValuePair("country",country));
				params.add(new BasicNameValuePair("city",city));
				params.add(new BasicNameValuePair("tribe",tribe));
				params.add(new BasicNameValuePair("clan",clan));
				params.add(new BasicNameValuePair("sclan",sclan));
				params.add(new BasicNameValuePair("mum",mum));
				params.add(new BasicNameValuePair("extra",extra));
				
	        JSONObject json=jParser.makeHttpRequest(Sync_url2, "POST", params);
	        
	        ContentValues cvU2=new ContentValues();
	        cvU2.put("status","1");
	        String whereClause="_id=?";
	        String[] whereArgs={_id};
	        
	        db.update("missing",cvU2, whereClause, whereArgs);
	        
	       c.moveToNext();
	        
		  }	
	     /*   try{
	        	tumepata=json.getInt("tumepata");
	        }
	        catch(Exception e)
	        {
	        	//Log.d("Waitress App : ", e.getMessage());
	        }
	        */ 
	        
	     
	       
	           
		}
	


}
