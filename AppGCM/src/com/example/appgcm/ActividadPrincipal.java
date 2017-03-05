package com.example.appgcm;
import static com.example.appgcm.utilidadesGCM.SENDER_ID;
import static com.example.appgcm.utilidadesGCM.mostrarMensaje;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;


public class ActividadPrincipal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       final TextView tv1= (TextView)findViewById(R.id.textView1);
       final TextView tv2= (TextView)findViewById(R.id.textView2);
      
       final ImageView imageView=(ImageView)findViewById(R.id.imageView1);
        
        GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
        
        if(getIntent().hasExtra("mensaje")){
        	Bundle extras = getIntent().getExtras();
        	String mensaje= extras.getString("mensaje");
        	mostrarMensaje(ActividadPrincipal.this,"Mensaje");
        	mostrarMensaje(ActividadPrincipal.this, mensaje);
        }
        
        Handler pauser = new Handler();
        pauser.postDelayed (new Runnable() {
            public void run() {

                tv1.setText("");
                tv2.setText("");
                imageView.setVisibility(View.INVISIBLE);

            }
        }, 2000);
       
        
        registrarUsuarioGCM();
        paginaWeb();
    }
    
    
    public void registrarUsuarioGCM(){ //quitare View v
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
    
    
    public void desregistrarUsuarioGCM (){
    	final String regId=GCMRegistrar.getRegistrationId(ActividadPrincipal.this);
    	if(!regId.equals("")){
    		GCMRegistrar.unregister(ActividadPrincipal.this);
    	}
    	else{
    		mostrarMensaje(ActividadPrincipal.this, "No estas registrado");
    	}
    }
    
    public void paginaWeb(){
    	WebView webView = (WebView) findViewById(R.id.webView1);
    	webView.setWebViewClient(new Callback());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://ecotec2014.blogspot.mx/");
    }
    
    private class Callback extends WebViewClient{
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {return (false);} 
    }
}
