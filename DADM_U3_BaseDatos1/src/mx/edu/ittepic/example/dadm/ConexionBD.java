package mx.edu.ittepic.example.dadm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {
	int error;

	public ConexionBD(Context activity, String nombreBaseDatos,
			SQLiteDatabase.CursorFactory cf, int versionBaseDatos) {
		super(activity, nombreBaseDatos, cf, versionBaseDatos);
		error = 0;
	}

	public void onCreate(SQLiteDatabase db) {
		// cuando se crea la BD, se ejecuta este de nuevo
		// codigo de las tablas
		try {
			String SQLTablaEstudiante = "CREATE TABLE ALUMNO(ID INT NOT NULL PRIMARY KEY,NOMBRE VARCHAR(100), DOMICILIO VARCHAR(200),EDAD INT)";
			db.execSQL(SQLTablaEstudiante);
			db.close();
		} catch (SQLiteException e) {
			error = 1;// no se creo la tabla alumno
		}
	}

	// 1 constructor
	// 2 creador
	// 3 Actualizar
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
