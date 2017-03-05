package com.example.basededatos2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Maestro extends Activity {
    EditText id,nom,dom,correo;
    Connection con= MainActivity.con;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maestro);
		id=(EditText)findViewById(R.id.editText1);
		nom=(EditText)findViewById(R.id.editText2);
		dom=(EditText)findViewById(R.id.editText3);
		correo=(EditText)findViewById(R.id.editText4);
	}
	
	
	public void agregar(View v){
		try{ 
			String sql="INSERT INTO MAESTRO VALUES ("+id.getText().toString()+", '";
			sql+=nom.getText().toString()+"', '";
			sql+=dom.getText().toString()+"', '";
			sql+=correo.getText().toString()+"')";			
			SQLiteDatabase db= con.getWritableDatabase();
			db.execSQL(sql);
			Toast.makeText(Maestro.this,"Se Inserto", Toast.LENGTH_LONG).show();
		}catch(Exception ex){
			Toast.makeText(Maestro.this, ex.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	public void volver(View v){
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maestro, menu);
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
