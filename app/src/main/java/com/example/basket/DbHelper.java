package com.example.basket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "Login.db";

    public DbHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users (username TEXT primary key, fullname TEXT, password TEXT, email TEXT, points INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String fullname, String password, String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("fullname", fullname);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("points", 0);
        long result = myDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else {
            return true;
        }
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }




    public void redeem_points(String ID)
    {

        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int pts = -1;
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{ID});
        if (cursor.moveToFirst()) {
            pts = cursor.getInt(cursor.getColumnIndex("points"));
        }
        contentValues.put("points",pts + 1);
        myDB.update("users",contentValues, "username = " + ID  , null);

    }

    public String fetch_Fullname(String ID)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String word = new String("");
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{ID});
        if (cursor.moveToFirst()) {
            word = cursor.getString(cursor.getColumnIndex("fullname"));
        }
        return  word;
    }

    public String fetch_useID(String ID)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String word = new String("");
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{ID});
        if (cursor.moveToFirst()) {
            word = cursor.getString(cursor.getColumnIndex("username"));
        }
        return  word;
    }
    public String fetch_Email(String ID)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String word = new String("");
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{ID});
        if (cursor.moveToFirst()) {
            word = cursor.getString(cursor.getColumnIndex("email"));
        }
        return  word;
    }

    public int fetch_points(String ID)
    {

        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int pts = -1;
        Cursor cursor = myDB.rawQuery("select * from users where username = ? ", new String[]{ID});
        if (cursor.moveToFirst()) {
            pts = cursor.getInt(cursor.getColumnIndex("points"));
        }
        return pts;

    }

}
