package com.example.futurewear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductDataSource {
    private SQLiteDatabase database;
    private DB_helper dbhelper;

    public ProductDataSource(Context context){
        dbhelper = new DB_helper(context);

    }

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
        //insertproduct();
    }

    public void close() {
        dbhelper.close();
    }

    public void insertproduct(){
        boolean didSucceed = false;
        ContentValues contentValues = new ContentValues();
        contentValues.put("product_id", "1001" );
        contentValues.put("productname","abc");
        contentValues.put("description","xyz");
        didSucceed = database.insert("product", null, contentValues) > 0;

    }

    public ArrayList<Product> getproduct(String query){
        String joinquery = "Select * from  product where  product_id in ("+query+");";
        ArrayList<Product> productlist=new ArrayList<Product>();
        try{
            Product product;
            Cursor cursor = database.rawQuery(joinquery, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                product = new Product();
                product.setProductid(cursor.getInt(0));
                product.setProductname(cursor.getString(1));
                product.setDescription(cursor.getString(2));
                productlist.add(product);
                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return productlist;
    }
}
