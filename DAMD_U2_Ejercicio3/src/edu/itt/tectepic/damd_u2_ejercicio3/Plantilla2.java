package edu.itt.tectepic.damd_u2_ejercicio3;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Plantilla2 extends Activity {

	private int opcion;
	private String cad;
	private LinearLayout ly;
	private EditText editText[];
	private TextView textView[];
	private CheckBox check[];
	private RadioButton radio[];
	private RadioGroup radiogroup;
	private Spinner spn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plantilla2);
		ly=(LinearLayout)findViewById(R.id.linear);
		opcion=getIntent().getIntExtra("combo",0);
		cad=getIntent().getStringExtra("cadena");
		
		radiogroup=new RadioGroup(this);

		String arr[]=cad.split(",");
		editText=new EditText[arr.length];
		textView=new TextView[arr.length];
		check=new CheckBox[arr.length];
		radio=new RadioButton[arr.length];
		
		//opciones del spinner
		if(opcion==0){
		   	for (int i = 0; i < arr.length; i++) {
		   		 textView[i]=new TextView(Plantilla2.this);
		   		 textView[i].setText(arr[i]);
		   	     textView[i].setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
		   		 ly.addView(textView[i]);
				 editText[i]=new EditText(Plantilla2.this);
			     ly.addView(editText[i]);
			}
		}else if (opcion==1){
			for (int i = 0; i < arr.length; i++) {
				 editText[i]=new EditText(Plantilla2.this);
			      ly.addView(editText[i]);
			}	
		}else if(opcion==2){
			for (int i = 0; i < arr.length; i++) {
				 check[i]=new CheckBox(Plantilla2.this);
				 check[i].setText(arr[i]);
			     ly.addView(check[i]);
			}	
		}else if(opcion==3){
			for (int i = 0; i < arr.length; i++) {
				 radio[i]=new RadioButton(Plantilla2.this);
				 radio[i].setText(arr[i]);
				 radiogroup.addView(radio[i]);
			}	
			 ly.addView(radiogroup);
		}
		else{
			 spn=new Spinner(this);
			 ArrayAdapter <String> adp=new ArrayAdapter<String>(Plantilla2.this, android.R.layout.simple_spinner_dropdown_item,arr);
			 spn.setAdapter(adp);
			 ly.addView(spn);
		}
			

			// Toast.makeText(Plantilla2.this,Integer.toString(arr.length) , Toast.LENGTH_LONG).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.plantilla2, menu);
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
