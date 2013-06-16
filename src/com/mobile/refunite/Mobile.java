package com.mobile.refunite;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Mobile extends Activity {
	EditText num;
	Spinner sp;
	Button ass;
	String[] countries={"Mauritius(+230)","Kenya(+254)","Tanzania(+255)","Uganda(+256)"};
	String code,pnum;
	CheckBox cb;
	boolean isChecked;
			

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mobile);
		num=(EditText)this.findViewById(R.id.num);
		sp=(Spinner)this.findViewById(R.id.country);
		ass=(Button)this.findViewById(R.id.btnassign);
		cb=(CheckBox)this.findViewById(R.id.cb);
		
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, countries);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		
	sp.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			
			switch(pos){
			case 0:			
				
				code="+254";
				break;
		
			
		}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
			
				
		
		ass.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pnum=num.getText().toString();
				if(isChecked=true){
				Intent i= new Intent(getApplicationContext(),Assist.class);
				i.putExtra("number",pnum);
				i.putExtra("code", code);
				startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "Agree to terms and conditions first", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				cb.setChecked(true);
				if(cb.isChecked()){
					isChecked=true;
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
