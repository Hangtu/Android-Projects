package itt.edu.ittepic.damd_u2_ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Dinamico extends Activity {
	
	Button generar;
	EditText cantidad, articulos [];
	LinearLayout layin;
	Button sumar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dinamico);
		generar=(Button)findViewById(R.id.button1);
		cantidad=(EditText)findViewById(R.id.editText1);
		layin=(LinearLayout)findViewById(R.id.layot);
		sumar= new Button(this);
		sumar.setText("Sumar");
		
		generar.setOnClickListener(// se crea una clase anonima apartir de aqui
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						int tam=2; //integer....
						   articulos = new EditText[tam];
						for(int i=0;i<articulos.length;i++){
							articulos[i]=new EditText(Dinamico.this);
							articulos[i].setInputType(InputType.TYPE_CLASS_NUMBER);
							layin.addView(articulos[i]);
						}
						layin.addView(sumar);
					}
				});// aqui termina
		
		 sumar.setOnClickListener(
				 new OnClickListener(){
					 //try catch //  mensaj de error en un toast // catch (){return //evita que siga el siguiente codigo debajo de la excepcion}
					 public void onClick(View v){
						int sum=0;
						for(int i=0;i<articulos.length;i++){
						  sum=sum+Integer.parseInt(articulos[0].getText().toString());
						}
				       //sout // sum;		
					 }
				 });
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dinamico, menu);
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
