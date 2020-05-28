package com.ellen.dhcsqltetest.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;

public class AppLibrary extends ZxyLibrary {

    public AppLibrary(Context context, String name, int version) {
        super(context, name, version);
    }

    public AppLibrary(Context context, String libraryPath, String name, int version) {
        super(context, libraryPath, name, version);
    }

    @Override
    public void onZxySQLiteCreate(SQLiteDatabase db) {

    }

    @Override
    public void onZxySQLiteUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
