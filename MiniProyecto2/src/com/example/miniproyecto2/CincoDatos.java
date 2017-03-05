package com.example.miniproyecto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CincoDatos extends Activity {
    
	private EditText nombre,edad,correo,tel,codP;
	private ArrayList <Usuarios> lista=new ArrayList<Usuarios>();
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cinco_datos);
		nombre=(EditText)findViewById(R.id.editText1);
		edad=(EditText)findViewById(R.id.editText2);
		correo=(EditText)findViewById(R.id.editText3);
		tel=(EditText)findViewById(R.id.editText4);
		codP=(EditText)findViewById(R.id.editText5);
	}
	
	
	
	public void guardar(View v){
		try{
		String name,email;
		int age,phone,code;
		name=nombre.getText().toString();
		age=Integer.parseInt(edad.getText().toString());
		email=correo.getText().toString();
		phone=Integer.parseInt(tel.getText().toString());
		code=Integer.parseInt(codP.getText().toString());
		lista.add(new Usuarios(name,email,age,phone,code));
		Toast.makeText(CincoDatos.this,"Se Guardo El Usuario "+name, Toast.LENGTH_LONG).show();
		}catch (Exception e){
			Toast.makeText(CincoDatos.this,"Introduzca Los Datos Correctamente", Toast.LENGTH_LONG).show();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void ordenar(View v){
		try{
		Collections.sort(lista ,new Comparator <Usuarios>() {
			public int compare(Usuarios p1, Usuarios p2) {
				return new Integer(p2.getEdad()).compareTo(new Integer(p1.getEdad()));
			}
		});
		Toast.makeText(CincoDatos.this,"El Mas Grande Es " + lista.get(0).getNom(), Toast.LENGTH_LONG).show();
		}catch(Exception e){
			Toast.makeText(CincoDatos.this,"Error Al Ordenar", Toast.LENGTH_LONG).show();
		}
	}
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cinco_datos, menu);
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
