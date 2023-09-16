package com.example.basket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class codes extends SQLiteOpenHelper {
    public static final String DBNAME = "codes";
    public codes( Context context) {
        super(context, "codes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table usedcodes (code TEXT primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists usedcodes");
    }

    public Boolean insertData(String used_code)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", used_code);
        long result = myDB.insert("usedcodes", null, contentValues);
        if (result == -1)
            return false;
        else {
            return true;
        }
    }
    public Boolean checkcode(String used_code) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from usedcodes where code = ?", new String[]{used_code});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}
