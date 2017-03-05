package com.example.appgcm;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class utilidadesGCM {
  //static final String SERVER_URL="http://cursoandroid.hol.es/notificaciones/";
  static final String SERVER_URL="http://tecnologicoecotec.hol.es/";
  static final String SENDER_ID="943251864261";
  static final String DISPLAY_MESSAGE_ACTION="com.example.appgcm.DISPLAY_MESSAGE";
  
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
