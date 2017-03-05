package com.example.miniproyecto2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.listView1);
		String arr[]={"Linterna","Dinamico","5 Datos","Credito"};
		ArrayAdapter <String> adp=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
		lv.setAdapter(adp);
		lv.setOnItemClickListener(
				new OnItemClickListener(){
					public void onItemClick(AdapterView <?> adpv, View v , int i , long l){
						
						switch(i){
						
						case 0:   startActivity(new Intent (MainActivity.this, Libre.class));
							break;
						
						case 1:	 startActivity(new Intent (MainActivity.this, Dinamico1.class));
							break;
						
						case 2:  startActivity(new Intent (MainActivity.this, CincoDatos.class));
							break;
						
						case 3:  startActivity(new Intent (MainActivity.this, Credito.class));
							break;
							
						}
						
					}
				});
		
		
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}


/* Ideas:
  
 	
 
*/