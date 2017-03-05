package com.example.damd_u2_hangtu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class Abrir extends Activity {

	
	EditText ed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abrir);
		ed=(EditText)findViewById(R.id.editText1);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try{
				BufferedReader archivo=new BufferedReader(
						new InputStreamReader(
								openFileInput("textfile.txt")));
				String contenido  = archivo.readLine();
				archivo.close();
				/* try{
				 	 FileInputStream read= openFileInput("textfile.txt");
				 	 InputStreamReader isr =new InputStreamReader (read);
				 	 char[] inputBuffer =new char [100]; //blocks de 100 bytes
				 	 String s="";
				 	 int charRead;
				 	 
				 	 while((charRead=isr.read(inputBuffer))>0){
				 		 String readString= String.copyValueOf(inputBuffer,0,charRead);
				 		 s+=readString;
				 	 }
				 	 isr.close();		 	 
				 	 ed.setText(s); */
				   ed.setText(contenido);
				 }catch(Exception ex){
					 
				 }
			}
		});
		
		
		findViewById(R.id.button2).setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						
						
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.abrir, menu);
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
