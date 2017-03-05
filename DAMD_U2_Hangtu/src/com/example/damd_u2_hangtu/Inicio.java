package com.example.damd_u2_hangtu;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Inicio extends Activity {

	
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		lv=(ListView)findViewById(R.id.listView1);
		lv.setOnItemClickListener(
				new OnItemClickListener() {
					public void onItemClick(AdapterView <?> p, View v, int i , long n){
						switch(i){
						 case 0: startActivity(new Intent(Inicio.this, Guardar.class));
							  break;
						 case 1: //startActivity(new Intent(Inicio.this, Leer.class));
							    startActivity(new Intent(Inicio.this, Abrir.class));
							  break;
						}
					}
				});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
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
