package com.example.basededatos2;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection  extends SQLiteOpenHelper{

	public Connection(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		try{
		String sql="CREATE TABLE ALUMNO (ID INT NOT NULL PRIMARY KEY, NOMBRE VARCHAR(200), TELEFONO VARCHAR(200), FECHA DATE)";
        arg0.execSQL(sql);
        String sql2="CREATE TABLE MAESTRO (ID INT NOT NULL PRIMARY KEY, NOMBRE VARCHAR(200), DOMICILIO VARCHAR(200), CORREO VARCHAR(200) )";
        arg0.execSQL(sql2);
		}catch(SQLiteException ex){
		    ex.getMessage();
        }
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
