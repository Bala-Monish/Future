package com.example.futurewear;

/**
 * Created by saike on 23-04-2018.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ImageTextListViewActivity extends Activity implements
        OnItemClickListener {

    public static String[] titles = null;

    public static String[] descriptions = null;

    public static final Integer[] images = { R.drawable.jbl,
            R.drawable.jbl, R.drawable.jbl, R.drawable.jbl };

    ListView listView;
    List<RowItem> rowItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        ArrayList<Product> product_list = (ArrayList<Product>)intent.getSerializableExtra("product_list");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productlistview);
        initTitlesArray(product_list);
        initDescArray(product_list);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.products_list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.productlist, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void initTitlesArray( ArrayList<Product> product_list ){

        titles = new String[product_list.size()];
        for(int i=0;i< product_list.size();i++){
            titles[i] = product_list.get(i).getProductname();
        }
    }

    public void initDescArray( ArrayList<Product> product_list ){
        descriptions = new String[product_list.size()];
        for(int i=0;i< product_list.size();i++){
            descriptions[i] = product_list.get(i).getDescription();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}