package org.example.notificaciones;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public final class UtilidadesGCM {
	
	static String hola="hola";
	static final String SERVER_URL="http://newdifusion.com/notificaciones/";
	static final String SENDER_ID="598121680057";
	static final String DISPLAY_MESSAGE_ACTION="org.example.notificaciones.DISPLAY_MESSAGE";
	  
	  private static Handler manejador = new Handler();
	   static void mostrarMensaje (final Context context, final String mensaje){
		   	manejador.post(new Runnable() {
				
				@Override
				public void run() {
					Toast.makeText(context,mensaje, Toast.LENGTH_SHORT).show();
					
				}
			});
	    }
}
