package com.example.futurewear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView)findViewById(R.id.listView1);
        final ListView listView2 = (ListView)findViewById(R.id.listView2);
        final ListView listView3 = (ListView)findViewById(R.id.listView3);
        listView.setAdapter(new ServiceAdapter(this,sampleData()));
        listView2.setAdapter(new ServiceAdapter(this,sampleData2()));
        listView3.setAdapter(new ServiceAdapter(this,sampleData3()));
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Service> actorList = ((ServiceAdapter)listView.getAdapter()).getSelectActorList();
                ArrayList<Service> actorList2 = ((ServiceAdapter)listView2.getAdapter()).getSelectActorList();
                ArrayList<Service> actorList3 = ((ServiceAdapter)listView3.getAdapter()).getSelectActorList();
                actorList.addAll(actorList2);
                actorList.addAll(actorList3);
                // HashMap<String,ArrayList<String>>  filterlist=  getHash(actorList);
                Intent intent = new Intent(MainActivity.this, Testactivity.class);
                intent.putExtra("map", actorList);
                startActivity(intent);

            }




        });

    }
    public HashMap<String,ArrayList<String>> getHash(ArrayList<Service> actorList){
        HashMap<String,ArrayList<String>> dataList = new  HashMap<String,ArrayList<String>>();
        ArrayList<String> names = new ArrayList<String>();
        String name= getResources().getResourceEntryName(R.array.socialimpact);

        for(Service actor: actorList){
            String listname = actor.getName();
            names.add(listname);

        }
        dataList.put(name,names);

        return dataList;
    }


    public ArrayList<Service> sampleData(){
        ArrayList<Service> dataList = new ArrayList<>();
        String filters[];

        filters=getResources().getStringArray(R.array.socialimpact);
        for(int i=0;i<filters.length;i++){
            Service servic = new Service();
            servic.setName(filters[i]);
            dataList.add(servic);
        }

        return dataList;
    }

    public ArrayList<Service> sampleData2(){
        ArrayList<Service> dataList = new ArrayList<>();

        String filters[];
        filters=getResources().getStringArray(R.array.environmentalimpact);
        for(int i=0;i<filters.length;i++){
            Service servic = new Service();
            servic.setName(filters[i]);
            dataList.add(servic);
        }
        return dataList;
    }

    public ArrayList<Service> sampleData3(){
        ArrayList<Service> dataList = new ArrayList<>();

        String filters[];
        filters=getResources().getStringArray(R.array.certifications);
        for(int i=0;i<filters.length;i++){
            Service servic = new Service();
            servic.setName(filters[i]);
            dataList.add(servic);
        }
        return dataList;
    }
}