package com.mobile.refunite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Listen extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
	
			  ConnectivityManager cm = (ConnectivityManager) arg0.getSystemService(arg0.CONNECTIVITY_SERVICE);
			  NetworkInfo ni = cm.getActiveNetworkInfo();
			  if (ni == null) {	
				  Toast.makeText(arg0, "No working Connection", Toast.LENGTH_SHORT).show();
			  }
			  else
			  {
				  Toast.makeText(arg0, "Working Connection", Toast.LENGTH_SHORT).show();  
			  }
	}
	

}
