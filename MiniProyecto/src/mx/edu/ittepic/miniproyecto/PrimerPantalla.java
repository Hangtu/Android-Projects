package mx.edu.ittepic.miniproyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class PrimerPantalla extends Activity {
    private final float val=0.01f; 
	Spinner spin;
	Button btn;
	EditText num,porc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primer_pantalla);
		spin = (Spinner) findViewById(R.id.spinner1);
		btn = (Button) findViewById(R.id.button1);
		num = (EditText) findViewById(R.id.editText1);
		porc = (EditText) findViewById(R.id.editText2);

		final String arr[] = { "Restar El Porcentaje A La Cantidad ", "Sumar El Pocentaje A La Cantidad", "Calcular El Porcentaje De La Cantidad" };
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PrimerPantalla.this, android.R.layout.simple_spinner_item, arr);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spin.setAdapter(dataAdapter);
		 
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			   try{
				float x=Float.parseFloat(num.getText().toString());
				float y=Float.parseFloat(porc.getText().toString());
			    
				
				if(spin.getSelectedItem().equals(arr[1])){
					float ecu=x+((y*val)*x);
			    	Toast.makeText(PrimerPantalla.this,"Resultado = "+Float.toString(ecu),Toast.LENGTH_LONG).show();
			    }
			    else if(spin.getSelectedItem().equals(arr[0])){
			    	float ecu=x-((y*val)*x);
			    	Toast.makeText(PrimerPantalla.this,"Resultado = "+Float.toString(ecu),Toast.LENGTH_LONG).show();
			    }
			    else{
			    	float ecu=(y*x)/100;
			    	Toast.makeText(PrimerPantalla.this,"El "+porc.getText().toString()+
			    			"% De La Cantidad Es "+Float.toString(ecu),Toast.LENGTH_LONG).show();
			    }
			   }catch(Exception ex){Toast.makeText(PrimerPantalla.this,"Ocurrio Un Error D:"+"\nVuelve A Intentarlo",Toast.LENGTH_LONG).show();}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.primer_pantalla, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.regresar){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
