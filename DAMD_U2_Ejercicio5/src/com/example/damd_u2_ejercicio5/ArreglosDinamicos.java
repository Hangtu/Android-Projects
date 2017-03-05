package com.example.damd_u2_ejercicio5;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ArreglosDinamicos extends ActionBarActivity {
	
	EditText nombre, edad;
	Spinner carreras;
	List <Estudiante> ArregloEstudiante=new ArrayList <Estudiante>();
	int pos=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arreglos_dinamicos);
		carreras=(Spinner)findViewById(R.id.spinner1);
		nombre=(EditText)findViewById(R.id.editText1);
		edad=(EditText)findViewById(R.id.editText2);
			
		findViewById(R.id.guardar).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						guardar();
					}
				});
		findViewById(R.id.anterior).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {	
						  try {
						   anterior(); 
						  }catch(Exception ex){
					       Toast.makeText(ArreglosDinamicos.this,"No Hay Datos",Toast.LENGTH_LONG).show();
						  } 
						}
				});
		
		findViewById(R.id.siguiente).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						  try {
							   siguiente(); 
							  }catch(Exception ex){
						       Toast.makeText(ArreglosDinamicos.this,"No Hay Datos",Toast.LENGTH_LONG).show();
							  } 
					}
				});
		
		findViewById(R.id.eliminiar).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {

					}
				});
	}
	
	public void eliminar(){
		  ArregloEstudiante.remove(pos);
		  Toast.makeText(ArreglosDinamicos.this,"",Toast.LENGTH_LONG).show();
		  if(pos==0 && ArregloEstudiante.size()==0){
			  pos=-1;
		  }
		  
		  if(pos==ArregloEstudiante.size()){
			  pos--;
		  }
	}
	
	
	public void mostrar(){
		 Estudiante a=(Estudiante) ArregloEstudiante.get(pos);
	     nombre.setText(a.getNombre());
	     edad.setText(" "+a.getEdad());
	     carreras.setSelection(a.getCarrera());
	
	}
	 public void guardar(){
		 try{
		 ArregloEstudiante.add(new Estudiante(nombre.getText().toString(),Integer.parseInt(edad.getText().toString()), carreras.getSelectedItemPosition()));
		 Toast.makeText(ArreglosDinamicos.this,"Se Guardo",Toast.LENGTH_LONG).show();
		 carreras.setSelection(0);
		 nombre.setText("");
		 edad.setText("");
		 }catch(Exception ex){
			 Toast.makeText(ArreglosDinamicos.this,"Borre Los Datos Y Vuelva A Guardar",Toast.LENGTH_LONG).show();
		 }
	 }
	 
	 public void anterior(){
		 pos--;
		 if(pos<=-1){
			 pos=ArregloEstudiante.size()-1;
		 }
		 mostrar();
	 }
	 
	 public void siguiente(){
		 pos++;
		 if(pos>=ArregloEstudiante.size()){
			 pos=0;
		 }
		 mostrar();
	 }
	 
	 public void serializar(){
	    	 
	 }
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arreglos_dinamicos, menu);
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
