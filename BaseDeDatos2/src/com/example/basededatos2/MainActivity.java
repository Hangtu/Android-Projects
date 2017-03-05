package com.example.basededatos2;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
			
	Spinner spn;
	EditText id,nom,tel,fecha; 
	public static Connection con;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		id=(EditText)findViewById(R.id.id);
		nom=(EditText)findViewById(R.id.nombre);
		tel=(EditText)findViewById(R.id.phone);
		fecha=(EditText)findViewById(R.id.fecha);
		spn=(Spinner)findViewById(R.id.spinner1);
		
		con=new Connection(this,"MyDB",null,1);
		String[]cad={"Masculino","Femenino"};
		ArrayAdapter <String> adp=new ArrayAdapter <String>(MainActivity.this,android.R.layout.simple_list_item_1,cad);
		spn.setAdapter(adp);
		
		  findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
						
					insertar();
					
				}
			});
			
	        
	        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				   startActivity(new Intent(MainActivity.this, Maestro.class));
				}
			});
	}
	
	
	public void insertar(){
		try{ 
			String sql="INSERT INTO ALUMNO VALUES ("+id.getText().toString()+", '";
			sql+=nom.getText().toString()+"', '";
			sql+=tel.getText().toString()+"', ";
			sql+=fecha.getText().toString()+")";
			
			SQLiteDatabase db= con.getWritableDatabase();
			db.execSQL(sql);
			Toast.makeText(MainActivity.this,"Se Inserto", Toast.LENGTH_LONG).show();
		}catch(Exception ex){
			Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
		}
		// Toast.makeText(MainActivity.this, spn.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
