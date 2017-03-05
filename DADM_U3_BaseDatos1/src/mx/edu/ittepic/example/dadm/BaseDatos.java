package mx.edu.ittepic.example.dadm;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BaseDatos extends Activity {

Button nuevo, buscar, eliminar;
EditText id, nombre, domicilio, edad;
conSQL conexionConSQLite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_datos);
		
		nuevo=(Button)findViewById(R.id.button1);
		buscar=(Button) findViewById(R.id.button2);
		eliminar=(Button)findViewById(R.id.button3);
		
		id=(EditText) findViewById(R.id.editText1);
		nombre=(EditText) findViewById(R.id.editText2);
		domicilio=(EditText) findViewById(R.id.editText3);
		edad=(EditText) findViewById(R.id.editText4);
		
		conexionConSQLite=new conSQL(this,"escuela2",null,1);
		
	/*	if(conexionConSQLite.error==1){
			AlertDialog.Builder alerta= new AlertDialog.Builder(this);
			alerta.setTitle("Error");
			alerta.setMessage("No Se creo la Tabla Alumno");
			alerta.show();
					
		}*/
		nuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String SQLInsertar="INSERTAR INTO ALUMNO VALUES("+id.getText().toString()+
						","+nombre.getText().toString()+
						"','"+domicilio.getText().toString()+")" ;
				//RECUERDA QUE: ISERT INTO ALUMNO VALUES(8,'JORGE SALAS','ALLENDE 20',19)
				try{
					//1. se instancia puntero a BD
					//2. se ejecuta el SQL
					//3. se cierra la BD
					SQLiteDatabase baseDatos= conexionConSQLite.getWritableDatabase();
					baseDatos.execSQL(SQLInsertar);
					baseDatos.close();
					id.setText("");
					nombre.setText("");
					domicilio.setText("");
					edad.setText("");
					Toast.makeText(BaseDatos.this, "Se Inserto", Toast.LENGTH_LONG).show();
				}catch(SQLiteException e){
					AlertDialog.Builder alerta= new AlertDialog.Builder(BaseDatos.this);
					alerta.setTitle("Error");
					alerta.setMessage("No Se logro insertar dato\n"+e.getMessage());
					alerta.show();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_datos, menu);
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
