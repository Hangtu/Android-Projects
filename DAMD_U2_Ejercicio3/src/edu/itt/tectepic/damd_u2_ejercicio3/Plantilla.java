package edu.itt.tectepic.damd_u2_ejercicio3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Plantilla extends Activity {
      
	EditText editext;
	Button  btn;
	Spinner spn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plantilla);
		editext=(EditText) findViewById(R.id.editText1);
	 	spn=(Spinner)findViewById(R.id.spinner1);
		btn=(Button)findViewById(R.id.button1);
		String spnText[]={"Etiqueta Y Campo De Texto","Solo Campos De Texto","CheckBox","RadioBoton","Items"};
		ArrayAdapter <String> spnAdp=new ArrayAdapter <String>(Plantilla.this,android.R.layout.simple_spinner_item,spnText);
		spn.setAdapter(spnAdp);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(!editext.getText().toString().equals("")){
				Intent i=new Intent(Plantilla.this, Plantilla2.class);
				i.putExtra("cadena",editext.getText().toString());
				i.putExtra("combo",spn.getSelectedItemPosition());	
				startActivity(i);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plantilla, menu);
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
