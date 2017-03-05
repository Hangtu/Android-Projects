package com.newdifusion.www;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    
	ProgressDialog dialogo;
	private Thread thread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		if(conexion()==false){
			aviso();
			return;
		}
		thread=new Thread(){
	        @Override
	        public void run(){
	            try {
	                synchronized(this){
	                    wait(1500);
	                    startActivity(new Intent(MainActivity.this, Diffusion.class));
	                }
	            }
	            catch(InterruptedException ex){                    
	            }           
	        }
	    };

	    thread.start(); 
	}
	
	public void aviso(){
		AlertDialog.Builder a=new AlertDialog.Builder(this);
		a.setTitle("Estimado Usuario");
		a.setMessage("No tienes conexion a internet");
		a.show();
		
	}
	@Override
	protected void onPause() {
	   super.onPause();
       finish();
	}
	 
	 private boolean conexion(){
		 ConnectivityManager con= (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		 NetworkInfo info= con.getActiveNetworkInfo();
		 if((info == null || !info.isConnected() || !info.isAvailable())){
		  return false;
		 }
		  return true;
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}
}
