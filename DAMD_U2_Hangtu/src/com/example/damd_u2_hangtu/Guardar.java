package com.example.damd_u2_hangtu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Guardar extends Activity {
	EditText edit;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guardar);
		edit=(EditText)findViewById(R.id.editText1);
		btn=(Button)findViewById(R.id.button1);
		
		btn.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						String dato= edit.getText().toString();
					    if(dato.isEmpty()){
					    	AlertDialog.Builder alerta=new AlertDialog.Builder(Guardar.this);
					    	alerta.setTitle("Error");
					    	alerta.setMessage("Rellena El Campo");
					    	alerta.setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int arg1) {
								    dialog.cancel();
								}
							} );
					    	alerta.show();// muestra el boton
					    	return; // impide que el siguiente condigo se siga ejecutando
					    } //fin del if
					    try{
					    /*	//contiene un metodo que se llama write escribir    
					    	OutputStreamWriter archivo=new OutputStreamWriter(new FileOutputStream("archivo.txt",Context.MODE_PRIVATE)); //dentro del constructordonde guarda el archivo;
					    	//fileOutputStream recibe txt y Context
					    	archivo.write(dato);
					    	archivo.close();*/
					    	
					    	FileOutputStream fOut= openFileOutput("textfile.txt", MODE_PRIVATE);
					    	OutputStreamWriter osw= new OutputStreamWriter(fOut);
					    	osw.write(dato);
					    	osw.close();
					    	Toast.makeText(Guardar.this,"Guardar", Toast.LENGTH_LONG).show();
					    	
					    	//open file output
					    	//new fileoutpt stream
					    }
					    catch(Exception ex){
					    	Toast.makeText(Guardar.this,"Error", Toast.LENGTH_LONG).show();
					    }
					}
				});
		
			findViewById(R.id.button2).setOnClickListener(
					new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							//Saber Si Esta Disponible LA SD
							//Revisar CREAR CARPETA DE PROYECTO
							//CREAR OBJETO A ARCHIVO CON RUTA CARPETA
							//DAR PERMISOS PARA ACCEDER A LA SD
							try{
								if(Environment.getExternalStorageState().compareTo(Environment.MEDIA_MOUNTED)==0){
									//opneFileOutput Guarda  solo en memoria interna
									//crear carpeta 
									String ruta= Environment.getExternalStorageDirectory().getAbsolutePath();
									File carpeta=new File(ruta,"reporteador");
									if(!carpeta.exists()){
										carpeta.mkdir();
									}
									ruta+="/reporteador";
									File f=new File(ruta, "archivo.txt");
							   		OutputStreamWriter archivo = new OutputStreamWriter(new FileOutputStream(f));
									Toast.makeText(Guardar.this,ruta, Toast.LENGTH_LONG).show();
									archivo.write(edit.getText().toString());
									archivo.close();
								}
								else{
							    	Toast.makeText(Guardar.this,"ERROR", Toast.LENGTH_LONG).show();
								}
							}catch(Exception ex){
								
							}
						}
					});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guardar, menu);
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
