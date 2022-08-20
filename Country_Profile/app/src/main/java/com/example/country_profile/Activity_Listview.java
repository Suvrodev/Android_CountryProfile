package com.example.country_profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.common.util.ArrayUtils;

public class Activity_Listview extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    String[] Country_Names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


            Country_Names = getResources().getStringArray(R.array.CountryName);
            Toast.makeText(getApplicationContext(),"Length"+Country_Names.length,Toast.LENGTH_SHORT).show();

            listView = (ListView) findViewById(R.id.id_listview);
            adapter = new ArrayAdapter<String>(Activity_Listview.this, R.layout.listview_sample_view, R.id.id_listviewsampleview, Country_Names);

           // ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Activity_Listview.this,R.layout.)

            listView.setAdapter(adapter);


            ////List View Click
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String Value= adapter.getItem(i);

                  //  String Valuee= (String) adapterView.getItemAtPosition(i);

                    int Count_Position=0;

                    ////Find Position
                    for(int x=0;x<Country_Names.length;x++){
                        if(Value.equalsIgnoreCase(Country_Names[x])){
                            Count_Position=x;
                            break;
                        }
                    }

                    Toast.makeText(getApplicationContext(),Value+"\nPosition: "+(Count_Position+1),Toast.LENGTH_SHORT).show();
                }
            });




            ////Long Press
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String Value= adapter.getItem(i);
                    int Number=adapter.getCount();

                    Toast.makeText(getApplicationContext(),Value+"\nWhich Position: "+Number,Toast.LENGTH_SHORT).show();

                    return false;
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_icon,menu);

        MenuItem menuItem=menu.findItem(R.id.id_search);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}