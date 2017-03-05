/*
 * Para que sirve la clase sqliteopenhelper
 * cuales son los pasos para realizar una operacion sql en android
 * cual es la clase de expecion sql
 * como funciona la clase cursor
 * 
 * id
 * nombre 
 * telefono
 * tpo
 * fecha de cumpleaños   - Consultar y Insertar;
 */


package com.example.basededatos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BaseDatos extends Activity {
    
	
	Button  add,search,delete,mod;
	EditText id,nom,dom,edad;
	Conexion conexion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_datos);
		id=(EditText)findViewById(R.id.editText1);
		nom=(EditText)findViewById(R.id.editText2);
		dom=(EditText)findViewById(R.id.editText3);
		edad=(EditText)findViewById(R.id.editText4);
		add=(Button)findViewById(R.id.button1);
		search=(Button)findViewById(R.id.button2);
		delete=(Button)findViewById(R.id.button3);
		mod=(Button)findViewById(R.id.button4);
		conexion=new Conexion(this,"escuelita", null, 1);
		
		add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			  insertar();
			}
		});
		
		search.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						buscar();
					}
				});
		delete.setOnClickListener(
		  new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			   if(id.getText().length()==0){
				   Toast.makeText(BaseDatos.this,"Introduzca Un ID", Toast.LENGTH_SHORT).show();
			   }else{
				   AlertDialog.Builder a=new AlertDialog.Builder(BaseDatos.this);
				   a.setTitle("Atencion");
				   a.setMessage("Seguro Que Quiere Eliminar");
				   a.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						eliminar();
					    arg0.dismiss(); //Cierra La Pregunta
					}
				});
				   a.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						arg0.cancel();
					}
				});
				   a.show();
			   }
			}
		});
		
		
		mod.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				modificar();
			}
		});
		
	}   
	
	
	
	public void limpiar(){
		id.setText("");
		nom.setText("");
		dom.setText("");
		edad.setText("");
	}
	
	
	public void modificar(){
		 try{
			 String sql="UPDATE ESTUDIANTE SET NOMBRE='"+nom.getText().toString()+"', ";
			 sql+="DOMICILIO='"+dom.getText().toString()+"', ";
			 sql+="EDAD="+edad.getText().toString()+" WHERE ID="+id.getText().toString();
			
			 SQLiteDatabase base= conexion.getWritableDatabase();
			 base.execSQL(sql);
			 base.close();
			 Toast.makeText(BaseDatos.this,"SE MODIFICO", Toast.LENGTH_SHORT).show();
			 limpiar();
			 
		 }catch(SQLiteException ex){
			  AlertDialog.Builder a=new AlertDialog.Builder(this);
			  a.setTitle("Error");
			  a.setMessage(ex.getMessage());
			  a.show();
		 }
	}
	
	public void eliminar(){
		String sql="DELETE FROM ESTUDIANTE WHERE ID="+id.getText().toString();
		try{
			SQLiteDatabase base= conexion.getWritableDatabase();
			base.execSQL(sql);
			 Toast.makeText(BaseDatos.this,"Se Elimino", Toast.LENGTH_SHORT).show();
			 base.close();
			 limpiar();
		}catch(SQLiteException ex){
			AlertDialog.Builder a=new AlertDialog.Builder(this);
			a.setTitle("Error");
			a.setMessage(ex.getMessage());
			a.show();
		}
	}
	
	public void buscar(){
		  //var char siempre van entre  ' ' los interos solos 
		  String sql= "SELECT * FROM ESTUDIANTE  WHERE ID="+id.getText().toString();

		 try{
			SQLiteDatabase base = conexion.getWritableDatabase();
			Cursor reg=base.rawQuery(sql, null);
			if(reg.moveToFirst()){
				nom.setText(reg.getString(1));
				dom.setText(reg.getString(2));
				edad.setText(""+reg.getString(3));
				base.close();
			}else{ // No se encontro coincidencia
				 AlertDialog.Builder a=new AlertDialog.Builder(this);
				 a.setTitle("Alerta");
				 a.setMessage("No Existe Ese Valor");
				 a.show();
			}
		}catch(SQLiteException ex){ //codigo mal 
			 AlertDialog.Builder a=new AlertDialog.Builder(this);
			 a.setTitle("Error");
			 a.setMessage(ex.getMessage());
			 a.show();
		}
		
	}
	
	
	public void insertar(){
      try{
			 String sql="INSERT INTO ESTUDIANTE VALUES (";
			 sql+=id.getText().toString()+",'";
			 sql+=nom.getText().toString()+"','";
			 sql+=dom.getText().toString()+"',";
			 sql+=edad.getText().toString()+")";
			 
			 SQLiteDatabase base = conexion.getWritableDatabase();
			 base.execSQL(sql);
			 Toast.makeText(BaseDatos.this,"SE INSERTO", Toast.LENGTH_LONG).show();
	         base.close();
	         limpiar();
		 }
		 catch(SQLException ex){
			 AlertDialog.Builder a=new AlertDialog.Builder(this);
			 a.setTitle("Error");
			 a.setMessage(ex.getMessage());
			 a.show();
		 }
		 
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
