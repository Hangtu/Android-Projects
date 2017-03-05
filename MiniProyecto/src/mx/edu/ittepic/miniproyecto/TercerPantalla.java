package mx.edu.ittepic.miniproyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class TercerPantalla extends Activity {
    String services[]={
    		"Taxi Amarillo",
    		"Policia",
    		"Bomberos",
    		"Tower Pizza",
    		"Pipas Tepic",
    		"Sushi Matsuri"};
    AutoCompleteTextView autoText;
    ImageButton btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tercer__pantalla);
		autoText= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		btn=(ImageButton)findViewById(R.id.imageButton1);
		
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(TercerPantalla.this, android.R.layout.simple_dropdown_item_1line, services);
		autoText.setThreshold(1); // numero de caracteres para que empiece a buscar
		autoText.setAdapter(adapter);
		
		btn.setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
					try{
						String val= autoText.getText().toString();
						String num="";
						Toast.makeText(TercerPantalla.this,val, Toast.LENGTH_LONG).show();
						
						if(val.equalsIgnoreCase("taxi amarillo")){
							num="2137716";
						}
						else if(val.equalsIgnoreCase("policia")){
							num="2146168";
						}
						else if(val.equalsIgnoreCase("bomberos")){
							num="2131809";
						}
						else if(val.equalsIgnoreCase("tower pizza")){
							num="2139000";
						}
						else if(val.equalsIgnoreCase("pipas tepic")){
							num="2305596";
						}
						else if(val.equalsIgnoreCase("sushi matsuri")){
							num="2107000";
						}
						
						if(!num.equals("")){
							startActivity(new Intent(TercerPantalla.this, TercerPantalla2.class).putExtra("numero", num));
						}
					 }//fin try
					 catch(Exception ex){} 
					}
				});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tercer__pantalla, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
