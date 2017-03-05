package com.newdifusion.www;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.RenderPriority;

public class Cliente extends Activity {
	WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(
			    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
			    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
		webview=(WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new WebViewClient(){	
			public boolean shouldOverrideUrlLoading(WebView v, String url){
        		return false;
        	}
			
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		         webview.loadUrl("file:///android_asset/home.html");
		         return;
		    }
		});
        webview.getSettings().setJavaScriptEnabled(true);
    	webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setRenderPriority(RenderPriority.HIGH);
        //webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webview.loadUrl("http://www.newdifusion.com/mobileD/user_insert.php");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente, menu);
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
