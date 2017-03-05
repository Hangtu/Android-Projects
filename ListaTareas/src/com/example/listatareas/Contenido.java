package com.example.listatareas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Contenido extends Activity {
	
	private EditText titulo,comen,fecha;
	private Button btn;
	private LinearLayout layin;
	int actividad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contenido);
		titulo=(EditText)findViewById(R.id.editText1);
		comen=(EditText)findViewById(R.id.editText2);
		fecha=(EditText)findViewById(R.id.editText3);
		layin=(LinearLayout)findViewById(R.id.layin);
		
		actividad=getIntent().getIntExtra("valor", 0);
		btn=new Button(this);
		
		if(actividad==-1){
			autoFecha();
		    btn.setText("Agregar");
		    layin.addView(btn);
		    btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					agregar();
					finish();
				}
			});
		}
		else{
			titulo.setText(MainActivity.listaNotas.get(actividad).getTitulo().toString());
			comen.setText(MainActivity.listaNotas.get(actividad).getNota().toString());
			fecha.setText(MainActivity.listaNotas.get(actividad).getFecha().toString());
			btn.setText("Eliminar");
			layin.addView(btn);
		  
		  btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					MainActivity.listaNotas.remove(actividad);
					finish();
				}
			});
		}
		
	}
	
			
	private void  agregar(){
	  MainActivity.listaNotas.add(new Tareas(titulo.getText().toString(),comen.getText().toString(), fecha.getText().toString()));
	}
	
	private void  autoFecha(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = df.format(c.getTime());
	    fecha.setText(formattedDate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contenido, menu);
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
