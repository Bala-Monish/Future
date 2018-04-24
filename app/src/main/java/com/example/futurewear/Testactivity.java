package com.example.futurewear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Testactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testactivity);
        Intent intent = getIntent();
        String query = null;
        ArrayList<Service> hashMap = (ArrayList<Service>)intent.getSerializableExtra("map");
        if(hashMap.isEmpty()) {
             query = "Select product_id from filters";
        }else {
         query = "Select product_id from filters where ";
        }
        for(Service test_name: hashMap){
            if(test_name==hashMap.get(hashMap.size()-1)){
                String name = test_name.getName().replaceAll(" ", "_");
                query= query+name+"= 1";
            }else{
                String name = test_name.getName().replaceAll(" ", "_");

                query= query+name+"= 1 AND ";

            }
        }
        //Toast.makeText(Testactivity.this,query,Toast.LENGTH_LONG).show();
        ProductDataSource pds= new ProductDataSource(this);

        try{
            pds.open();
            ArrayList<Product> productlist =  pds.getproduct(query);
            Intent newintent = new Intent(Testactivity.this,ImageTextListViewActivity.class);
            newintent.putExtra("product_list",productlist);
            startActivity(newintent);
            pds.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
