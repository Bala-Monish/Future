package com.example.futurewear;

/**
 * Created by saike on 17-04-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "future_wear.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String CREATE_TABLE_PRODUCT =
            "create table if not exists product (product_id text primary key, "+"Productname text not null, Description text);";


    private static final String CREATE_TABLE_FILTER =
            "create table if not exists filters (product_id text primary key, "+"Fair_Trade_Sourcing text  not null," +
                    " Fair_Wages text  not null," +
                    " Gender_Equal_Hiring text," +
                    " Gives_Back_To_Charity text," +
                    " Local_Production text," +
                    " Biodegradable_products text," +
                    " Carbon_natrual text," +
                    " Energy_Saving_Practices text," +
                    " Organic_Materials text," +
                    " Recycled_materials text," +
                    " B_Corporation text," +
                    " Fair_Trade_USA text," +
                    " Fairtrade_International text," +
                    " WRAP text," +
                    " GOTS text);";
    private static final String sql =
            "INSERT INTO filters(product_id,Fair_Trade_Sourcing,Fair_Wages,Gender_Equal_Hiring,Gives_Back_To_Charity,Local_Production,Biodegradable_products,Carbon_natrual,Energy_Saving_Practices,Organic_Materials,Recycled_materials,B_Corporation,Fair_Trade_USA,Fairtrade_International,WRAP,GOTS) VALUES('1001','1','0','0','0','1','1','1','1','1','1','1','1','1','1','1');" ;

    public DB_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_FILTER);
        database.execSQL(CREATE_TABLE_PRODUCT);
        database.execSQL(sql);
        insertproduct(database);

    }
    public  void insertproduct(SQLiteDatabase database){
        try{
            boolean didSucceed = false;
            ContentValues initialValues = new ContentValues();

            initialValues.put("product_id","1001");
            initialValues.put("productname","abc" );
            initialValues.put("Description","xyz" );

            didSucceed = database.insert("product", null, initialValues) > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DB_helper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS filters");
        db.execSQL("DROP TABLE IF EXISTS product");
        onCreate(db);
    }

}
