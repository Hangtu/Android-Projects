package org.example.notificaciones;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gcm.GCMRegistrar;

import static org.example.notificaciones.UtilidadesGCM.SENDER_ID;
import static org.example.notificaciones.UtilidadesGCM.mostrarMensaje;



public class ActividadPrincipal extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//GCMRegistrar.checkDevice(this);
		//GCMRegistrar.checkManifest(this);
		
		if(getIntent().hasExtra("mensaje")){
        	Bundle extras = getIntent().getExtras();
        	String mensaje= extras.getString("mensaje");
        	mostrarMensaje(ActividadPrincipal.this,"Mensaje");
        	mostrarMensaje(ActividadPrincipal.this, mensaje);
        }
		
	}
	public void registrar(View v){ //quitare View v
    	//mostrarMensaje(MainActivity.this,"Iniciando Registro");
    	final String regId = GCMRegistrar.getRegistrationId(ActividadPrincipal.this);
    	if(regId.equals("")){
    		GCMRegistrar.register(ActividadPrincipal.this, SENDER_ID);
    		mostrarMensaje(ActividadPrincipal.this, "Registrando Su Dispositivo");
    	}
    	else{
    		mostrarMensaje(ActividadPrincipal.this, "Bienvenido");
    	}
    	
    }
    
    
    public void desregistrar(View v){
    	final String regId=GCMRegistrar.getRegistrationId(ActividadPrincipal.this);
    	if(!regId.equals("")){
    		GCMRegistrar.unregister(ActividadPrincipal.this);
    	}
    	else{
    		mostrarMensaje(ActividadPrincipal.this, "No estas registrado");
    	}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad_principal, menu);
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
