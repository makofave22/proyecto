package com.uni.trabajo.proyecto.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makofave on 25/04/2018.
 */

public class DataBaseManager
{
    public static final String TABLE_CLIENTES="clientes";

    //
    public static final String ID_CLIENTE="id";
    public static final String NAME_CLIENTE="Nombre";
    public static final String APELLIDO_CLIENTE="Apellido";
    public static final String DIRECCION_CLIENTE="Direccion";
    public static final String CORREO_CLIENTE="Correo";
    //Creacion de la tabla Clientes
    public static final String CREATE_TABLE_CLIENTES =" create table "+TABLE_CLIENTES+" ("
            + ID_CLIENTE +  " integer primary key autoincrement,"
            + NAME_CLIENTE + " text ,"
            + APELLIDO_CLIENTE + " text ,"
            + DIRECCION_CLIENTE + " text ,"
            +CORREO_CLIENTE+" text );";

    //se crea la base de datos
    private BdHelper helper;
    private SQLiteDatabase db;


    public DataBaseManager(Context context) {

        helper=new BdHelper(context);
        db= helper.getWritableDatabase();
    }

    public ContentValues generarContentClientes(String _nombre,String _apellido,String _direccion, String _correo) {

        ContentValues valores=new ContentValues();
        valores.put(NAME_CLIENTE,_nombre);
        valores.put(APELLIDO_CLIENTE,_apellido);
        valores.put(DIRECCION_CLIENTE,_direccion);
        valores.put(CORREO_CLIENTE,_correo);
        return valores;
    }

    //          meotdo para insertar en la tabla  Clientes
    public void insertClientes(String _nombre,String _apellido,String _direccion, String _correo)
    {

        db.insert(TABLE_CLIENTES,null,generarContentClientes( _nombre, _apellido, _direccion,_correo));
    }

    public List<Clientes> clientes()
    {
        List<Clientes> clientesList=new ArrayList<>();
        String cadenaSQL="SELECT * FROM "+TABLE_CLIENTES;
        Cursor c = db.rawQuery(cadenaSQL, null);

        try {
            if (c.moveToFirst()) {
                do {
                    Clientes clientes=new Clientes();
                    clientes.setId(c.getString(0));
                    clientes.setNombre(c.getString(1));
                    clientes.setApellido(c.getString(2));
                    clientes.setDireccion(c.getString(3));
                    clientes.setCorreo(c.getString(4));

                    clientesList.add(clientes);

                } while (c.moveToNext());

            }
        }catch (Exception e){
            // Toast.makeText(contexto, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return clientesList;
    }
    public void eliminarClientes(String id)
    {
        db.execSQL("DELETE FROM "+TABLE_CLIENTES+" WHERE "+ID_CLIENTE+"="+id);
    }


}
