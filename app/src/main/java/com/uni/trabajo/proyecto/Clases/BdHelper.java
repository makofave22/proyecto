package com.uni.trabajo.proyecto.Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Makofave on 25/04/2018.
 */

public class BdHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME="pryecto.sqlite";
    private static final int BD_VERSION=1;

    public BdHelper(Context context)
    {
        super(context, DB_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_CLIENTES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
