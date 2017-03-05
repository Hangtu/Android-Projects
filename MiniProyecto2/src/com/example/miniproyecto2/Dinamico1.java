package com.example.miniproyecto2;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dinamico1 extends Activity {
    EditText num,vector[];
    LinearLayout lay;
    Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dinamico1);
		num=(EditText)findViewById(R.id.numero);
		lay=(LinearLayout)findViewById(R.id.layot);
		btn=new Button(this);
		findViewById(R.id.button1).setOnClickListener(
			new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					try{
					 vector=new EditText[Integer.parseInt(num.getText().toString())];
					 for(int i=0;i<vector.length;i++){
					     vector[i]=new EditText(Dinamico1.this);
					     vector[i].setInputType(InputType.TYPE_CLASS_NUMBER);
					     lay.addView(vector[i]);
					 }
					 btn.setText("Multiplicar");
					 lay.addView(btn);	 
					}catch(Exception e){ Log.e("Error", "Error");}
				}
			});
		
		btn.setOnClickListener(
				 new OnClickListener(){
					 public void onClick(View v){
						int mul=0;
						for(int i=0;i<vector.length;i++){
						  mul=mul+Integer.parseInt(vector[i].getText().toString());
						}
					Toast.makeText(Dinamico1.this,Integer.toString(mul),Toast.LENGTH_LONG).show();
					 } 
				 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dinamico1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
