package com.mobile.refunite;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class Listener extends BroadcastReceiver {
	
	//Syncm sync=new Syncm();
	@Override
	public void onReceive(Context context, Intent intent) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = manager.getActiveNetworkInfo();
		NetworkInfo mobNetInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifi=manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (activeNetInfo != null) {
			Toast.makeText(context,
					"Network available",
					Toast.LENGTH_SHORT).show();
		}
		
		
		if (mobNetInfo != null) {
			
			
			
			
			
			Intent i = new Intent(context, AutoSync.class);
		    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    context.startActivity(i);  
			
		}
		else if(wifi!=null){
			Intent i = new Intent(context, AutoSync.class);
		    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    context.startActivity(i);  
		}
		
		else{
			Toast.makeText(context,
					"No Internet connection info will be synced when network is available",
					Toast.LENGTH_SHORT).show();
			
		}
		
}
/*public	class Syncm extends Activity{
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			getSync();
		}

		private void getSync() {
			Toast.makeText(getApplicationContext(),
					"synchronisation started",
					Toast.LENGTH_SHORT).show();
			
			Intent snc=new Intent(getApplicationContext(),Sync.class);
			startActivity(snc);
			finish();
			
		}
	}*/
	}
