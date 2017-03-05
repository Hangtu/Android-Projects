package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Conexion extends SQLiteOpenHelper {

	public Conexion(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			String sql="CREATE TABLE ESTUDIANTE (ID INT NOT NULL PRIMARY KEY, NOMBRE VARCHAR(200), DOMICILIO VARCHAR(200), EDAD INT)";
			db.execSQL(sql);
		}
		catch(Exception ex){
			Log.e("error",ex.getMessage());
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
