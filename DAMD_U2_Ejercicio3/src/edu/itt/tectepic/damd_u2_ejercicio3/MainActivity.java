package edu.itt.tectepic.damd_u2_ejercicio3;

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

public class MainActivity extends Activity {

	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * activity ppal3
	 * contenido listView : plantilla, crear arcivo , leer archivo
	 * menu : acerca de , salir
	 * 
	 * activity plantilla
	 * contenido : etiqueta , edittext, spinner , boton
	 * (EditText) seprado con un split, creara objetos dinamicos.
	 * items del spinner: etiqueta, y campo de texto, solo campos de texto , checkbox, radiobotons , item en combox
	 * activity : plantilla2 (Crea El activity Segun El Spinner)
	 *
	 */
	ListView lv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    lv=(ListView)findViewById(R.id.listView1);
	    
	    String arg []= {"Plantilla","Crear Archivo","Leer Archivo"};
	    ArrayAdapter <String > adp=new  ArrayAdapter <String>(MainActivity.this,android.R.layout.simple_list_item_1,arg);
	    lv.setAdapter(adp);
	    
	    lv.setOnItemClickListener(
	    		new OnItemClickListener(){
	    			public void onItemClick(AdapterView adv, View v, int i , long d ){
	    				switch(i){
	    				 case 0 :    startActivity(new Intent(MainActivity.this,Plantilla.class));
	    					 		break;
	    				 case 1 : 
	    					 		break;
	    				 case 2:    
	    					 		break;
	    			  }
	    			}
	    		});
		
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
			Toast.makeText(MainActivity.this,"Creado Por Hang Tu Wong Ley", Toast.LENGTH_LONG).show();
			return true;
		}
		
		if(id == R.id.salir){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
