package com.newdifusion.www;


import com.google.android.gcm.GCMRegistrar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import static com.newdifusion.www.UtilidadesGCM.mostrarMensaje;
import static com.newdifusion.www.UtilidadesGCM.SENDER_ID;;


public class Diffusion extends Activity {

	private WebView webview;
	ProgressDialog dialogo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(
			    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
			    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diffusion);
		webview=(WebView)findViewById(R.id.webView1);
		//paginaWeb();
		webview.setWebViewClient(new WebViewClient(){
			
			public boolean shouldOverrideUrlLoading(WebView v, String url){
        		return false;
        	}
			public void  onPageStarted(WebView view, String url, Bitmap favicon){
				dialogo = new ProgressDialog(Diffusion.this);
				dialogo.setMessage("Cargando...");
				dialogo.setCancelable(true);
				dialogo.show();
		     	}
			
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		         webview.loadUrl("file:///android_asset/home.html");//verifica esto
		         return;
		    }
			
			public void onPageFinished(WebView view, String url){
				 dialogo.dismiss();
			}
		});
		paginaWeb();
		registrar();
	}
     public void paginaWeb(){
    	webview.getSettings().setJavaScriptEnabled(true);
    	webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setRenderPriority(RenderPriority.HIGH);
        //webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webview.loadUrl("http://www.newdifusion.com/mobileD/index.php");
    }

     private boolean conexion(){
		 ConnectivityManager con= (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		 NetworkInfo info= con.getActiveNetworkInfo();
		 if((info == null || !info.isConnected() || !info.isAvailable())){
		  return false;
		 }
		  return true;
	 }
     
     
     public void registrar(){ //quitare View v
     	//mostrarMensaje(MainActivity.this,"Iniciando Registro");
     	final String regId = GCMRegistrar.getRegistrationId(Diffusion.this);
     	if(regId.equals("")){
     		GCMRegistrar.register(Diffusion.this, SENDER_ID);
     		mostrarMensaje(Diffusion.this, "Registrando Su Dispositivo");
     	}
     	else{
     		mostrarMensaje(Diffusion.this, "Bienvenido");
     	}
     	
     }
     
     
     public void desregistrar(){
     	final String regId=GCMRegistrar.getRegistrationId(Diffusion.this);
     	if(!regId.equals("")){
     		GCMRegistrar.unregister(Diffusion.this);
     	}
     	else{
     		mostrarMensaje(Diffusion.this, "No estas registrado");
     	}
     }

 
 @Override
 public void onBackPressed() {
     if (webview.canGoBack()) {
         webview.goBack();
     } else {
         super.onBackPressed();
     }
 }
 

 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diffusion, menu);
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
		if (id == R.id.cliente) {
			startActivity(new Intent(Diffusion.this, Cliente.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
