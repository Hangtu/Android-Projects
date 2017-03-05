package com.example.listatareas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/*
 * Sqlite open helper
 * Cursor Factory
 * Cursor
 * SqliteDatabase
 * 
 * dbms sqlite
 * caracteristicas
 * funcionaminto
 */

public class MainActivity extends Activity {
	
	public static ArrayList <Tareas> listaNotas;
	private ListView lv;
	private String notas[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.listView1);
		listaNotas=new ArrayList <Tareas>();
		fileToList();
		adaptador();
		lv.setOnItemClickListener(
				new OnItemClickListener() {
					public void onItemClick(AdapterView adpv, View v, int pos , long l){
				    startActivity(new Intent(MainActivity.this,Contenido.class).putExtra("valor",pos));
			}
		});
	}
    
	private void adaptador(){
		notas=new String [listaNotas.size()];
		for(int i=0;i<listaNotas.size();i++){
			notas[i]=(i+1)+"-"+listaNotas.get(i).getTitulo().toString();
		}
		ArrayAdapter <String> adp=new ArrayAdapter <String>(MainActivity.this, android.R.layout.simple_list_item_1,notas);
		lv.setAdapter(adp);
	}
	
	@Override
	protected void onRestart() {
	   super.onRestart();
	   adaptador();
	   
	}
	
	@Override
	protected void onDestroy() {
	   super.onDestroy();;
       guardar();
	}
	

	private void fileToList(){
		try{
		   String tareas[]=abrir().split("@");
		   for(int i=0;i<tareas.length;i++){
			  String cad[]=tareas[i].split(",");
			  listaNotas.add(new Tareas(cad[0],cad[1], cad[2]));
		   }
		}catch(Exception ex){
			Toast.makeText(MainActivity.this,"No Hay Datos",Toast.LENGTH_SHORT).show();
		}
	}
	
	
     private String  abrir(){
		try {
			FileInputStream fIn = openFileInput("archivo.txt");
			InputStreamReader isr = new InputStreamReader(fIn);
			char[] inputBuffer = new char[100];
			String s = "";
			int charRead;
			while ((charRead = isr.read(inputBuffer)) > 0) {
				String readString = String
						.copyValueOf(inputBuffer, 0, charRead);
				s += readString;
				inputBuffer = new char[100];
			}
			isr.close();
			return s;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return ioe.getMessage();
		}
	}
	
	
	public void guardar(){
		String cad = "";
		for (int i = 0; i < listaNotas.size(); i++) {
			cad += listaNotas.get(i).getTitulo().toString();
			cad += "," + listaNotas.get(i).getNota();
			cad += "," + listaNotas.get(i).getFecha() + "@";
		}
		try {
			FileOutputStream fOut = openFileOutput("archivo.txt", MODE_PRIVATE);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			osw.write(cad);
			osw.close();
			//Toast.makeText(getBaseContext(), "Archivo Guardado",
				//	Toast.LENGTH_LONG).show();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		if (id == R.id.agregar) {
			startActivity(new Intent(MainActivity.this,Contenido.class).putExtra("valor", -1));
			return true;
		}

		if (id == R.id.acerca) {
			startActivity(new Intent(MainActivity.this,Acerca.class));
			return true;
		}
		if (id == R.id.salir) {
			guardar();
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
