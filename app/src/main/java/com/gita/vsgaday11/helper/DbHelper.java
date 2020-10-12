package com.gita.vsgaday11.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "digitalent.db";

    private static final String TABLE_SQLite = "sqlite";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE" + TABLE_SQLite + "(" +
                COLUMN_ID + "INTEGER, " +
                COLUMN_NAME + "TEXT NOT NULL," +
                COLUMN_ADDRESS + "TEXT NOT NULL" +
                ")";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }
}
