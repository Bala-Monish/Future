package com.example.futurewear;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
/**
 * Created by dhanuskodi on 3/6/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "details.db";
    private static final int VERSION  = 1;
    private static final String col1="name";
    private static final String col2="password";
    private static final String col4="email";
    private static final String col3 ="phonenumber";
    private static final String create =
   "CREATE TABLE record (_id integer primary key autoincrement, "
           + "name text not null, password text, "
           + "phonenumber text, "
           + "email text unique);";




    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  db) {

      db.execSQL(create);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS record");
        onCreate(db);
    }
    public boolean addData(String name,String pass,String email,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,name);
        contentValues.put(col2,pass);
        contentValues.put(col4,email);
        contentValues.put(col3,phone);
        long result = db.insert("record",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }


    }
    public String verify(String uname)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT email,password from record ";
        Cursor cursor = db.rawQuery(query,null);
        String a;
        String b;
        Cursor data = db.rawQuery("SELECT * FROM " + "record", null);
        b = "Not Found";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);

                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }
}

