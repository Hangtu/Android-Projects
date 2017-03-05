package com.example.appgcm;
import static com.example.appgcm.utilidadesGCM.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentService extends GCMBaseIntentService {

	@Override
	protected void onError(Context context, String msgError) {
		
		mostrarMensaje(context, msgError);
		
	}

	@Override
	protected void onMessage(Context context, Intent intent) {
	String mensaje = intent.getExtras().getString("mensaje");
	//	mostrarMensaje(context, "Nuevo Mensaje");
   		mostrarMensaje(context, mensaje);
   		mostrarAvisoBarraEstado(context , mensaje);
		
	}

	

	@Override
	protected void onRegistered(Context context, String regId) {
	   registrarDispositivosEnServidorWeb(context, regId);
		mostrarMensaje(context, "Registrado Con Exito");
		
		
	}
	@Override
	protected void onUnregistered(Context context, String regId) {
		desRegistrarDispositivosEnServidorWeb(context, regId);
		mostrarMensaje(context, "Desregistrado con exito");
		
	}
		



	private void registrarDispositivosEnServidorWeb(Context context,String regId) {
		
		String serverUrl = SERVER_URL + "registrar.php";
		List <NameValuePair> params = new ArrayList <NameValuePair>();
		params.add(new BasicNameValuePair("iddevice", regId ));
		params.add(new BasicNameValuePair("idapp",SENDER_ID));
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serverUrl);
		
		try{
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = httpClient.execute(httpPost);
			GCMRegistrar.setRegisteredOnServer(context, true);
			mostrarMensaje(context, "Registrado Al Servidor Web");
		}
		catch(IOException e){
			mostrarMensaje(context, "Error En El Registro");
		}
	}
	
	

	
	private void desRegistrarDispositivosEnServidorWeb(Context context,
			String regId) {
		String serverUrl = SERVER_URL + "desregistrar.php";
		List <NameValuePair> params = new ArrayList <NameValuePair>();
		params.add(new BasicNameValuePair("iddevice", regId));
		params.add(new BasicNameValuePair("idapp",SENDER_ID));
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(serverUrl);
		
		try{
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = httpClient.execute(httpPost);
			GCMRegistrar.setRegisteredOnServer(context, false);
			mostrarMensaje(context, "DesRegistrado Al Servidor Web");
		}
		catch(IOException e){
			mostrarMensaje(context, "Error En El DesRegistro");
		}
		
	}
	
	private void mostrarAvisoBarraEstado(Context context, String mensaje) {
		
		int icon =R.drawable.escudo_itt;
		long when = System.currentTimeMillis();
		NotificationManager notificationManager = (NotificationManager)
				context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification notification = new Notification(icon, mensaje ,when);
		String title = context.getString(R.string.app_name);
		
		Intent notificationIntent = new
				Intent(context.getApplicationContext(), ActividadPrincipal.class);
		
		notificationIntent.putExtra("Mensaje", mensaje);
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | 
				Intent.FLAG_ACTIVITY_SINGLE_TOP);
		
		Random r = new Random();
		PendingIntent intent = PendingIntent.getActivity(context, r.nextInt(),notificationIntent , 0);
		
		notification.setLatestEventInfo(context,title, mensaje, intent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notificationManager.notify(0,notification);
		
		Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
		v.vibrate(2000);
	}
		
}
