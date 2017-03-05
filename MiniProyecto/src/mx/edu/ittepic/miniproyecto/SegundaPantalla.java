package mx.edu.ittepic.miniproyecto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SegundaPantalla extends Activity {
	Button btn1, btn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda_pantalla);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
	}
	
	public void switchButton(View view) {
	    final TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
	    boolean on = ((Switch) view).isChecked();
	    
	    if (on) {
	    	btn1.setEnabled(false);
	    	btn2.setEnabled(true);
	    	btn2.setOnClickListener(
	    			new OnClickListener() {
						@Override
						public void onClick(View v) {
							 String data=tel.getDeviceId(); // Numero IMEI
						     Toast.makeText(SegundaPantalla.this,"NUMERO IMEI DE TU TELEFONO "+data, Toast.LENGTH_LONG).show();
						}
					});
	    } else {  //ID DE LA SIM
	    	btn1.setEnabled(true);
	    	btn2.setEnabled(false);
	    	btn1.setOnClickListener(
	    			new OnClickListener() {
						@Override
						public void onClick(View v) {
							String data=tel.getSimSerialNumber();
					    	Toast.makeText(SegundaPantalla.this,"EL ID DE TU TARJETA SIM "+data, Toast.LENGTH_LONG).show();
							
						}
					});
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.segunda_pantalla, menu);
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
