package mx.edu.ittepic.example.dadm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class conSQL  extends SQLiteOpenHelper{

	public conSQL(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			String a="CREATE  TABLE alumno (`idalumno` INT NOT NULL , `nombre` VARCHAR(45) NULL ,`domicilio` VARCHAR(45) NULL ,`telefono` VARCHAR(45) NULL ,PRIMARY KEY (`idalumno`));";
			db.execSQL(a);
			db.close();
		}
		catch( Exception e ){
			e.getCause();
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}
}
