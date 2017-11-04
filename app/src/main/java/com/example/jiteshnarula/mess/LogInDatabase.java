package com.example.jiteshnarula.mess;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 04/11/2017.
 */

public class LogInDatabase extends SQLiteOpenHelper {
    public LogInDatabase(Context context) {
        super(context, "FAVOURITES", null, 1);
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS loginCheck(check INT);");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS loginCheck(check INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addCheck(int check) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("check", check);
        db.insert("loginCheck", null, values);
        db.close();
    }
//    public int getCheck() {
//       int check;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM favData", null);
//        count = cursor.getCount();
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                do {
//                    imgLink.add(cursor.getString(cursor.getColumnIndex("imageLink")));
//                    Log.d("Raman", "database image" + imgLink.get(0));
//                } while (cursor.moveToNext());
//            }
//        }
//        return imgLink;
//    }
}
