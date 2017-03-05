package com.example.actionb;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {

	MenuItem searchItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(false);
	    
	      TabListener listener = new TabListener() {
	    	               
	    	  	            @Override
	    	  	            public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	    	  	                
	    	  	            	Toast.makeText(MainActivity.this,"Unselecte",Toast.LENGTH_SHORT).show();

	    	  	            }
	    	  	             
	    	  	            @Override
	    	  	            public void onTabSelected(Tab tab, FragmentTransaction ft) {
	    	  	            	Toast.makeText(MainActivity.this,"Selected",Toast.LENGTH_SHORT).show();

	    	  	                 
	    	 	            }
	    	  	             
	    	  	            @Override
	    	  	            public void onTabReselected(Tab tab, FragmentTransaction ft) {
	    	  	            	Toast.makeText(MainActivity.this,""+ft.toString(),Toast.LENGTH_SHORT).show();
	    	  	            }
	    	 	        };
	    
	    actionBar.addTab(actionBar.newTab().setText("Tab1").setTabListener(listener));
	    actionBar.addTab(actionBar.newTab().setText("Tab2").setTabListener(listener));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		searchItem = menu.findItem(R.id.menu_buscar);
	    SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		return true;
	}
	
	private void buscar(){
		
		Toast.makeText(MainActivity.this,""+searchItem.toString(),Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.menu_buscar) {
			buscar();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
