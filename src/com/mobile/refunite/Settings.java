package com.mobile.refunite;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class Settings extends Activity{
	
	 SharedPreferences sp,sp1;

	 CheckBox ch;
	public void onCreate(Bundle x)
	{
		super.onCreate(x);
		setContentView(R.layout.sett);
		
        sp=this.getSharedPreferences("pr",MODE_PRIVATE);
		
		final SharedPreferences.Editor se= sp.edit();
		
		ch=(CheckBox) findViewById(R.id.ch);
		
		
				
		ch.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(ch.isChecked())
				{		
				se.putString("name","checked");
				}
				else
				{
			    se.putString("name","not");	
				}
				
				se.commit();
				
			}
			
		});
		
	}
	public void c(View v)
	{
		sp1=this.getSharedPreferences("pr",MODE_PRIVATE);     
	     
	     String name=sp1.getString("name", "");
	     
	     Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();
	}
}
