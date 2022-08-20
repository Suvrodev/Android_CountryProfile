package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activity_Fragment extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String[] CountryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        String[] CountryName={"Bangladesh","India","Sri Lanka", "Pakistan","Greenland","Finland","Ireland","Nederland","Argentina","Brazil","Australia","New Zealand"};
        listView= (ListView) findViewById(R.id.id_list_view_f);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,CountryName);
        listView.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.id_fragment,new FragmentBangladesh()).commit();
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Fragment Selected_fragment=null;

        if(i==0){
            Toast.makeText(getApplicationContext(),"Its Bangladesh",Toast.LENGTH_SHORT).show();
            Selected_fragment=new FragmentBangladesh();
        }
        else if(i==1){
            Toast.makeText(getApplicationContext(),"It's India",Toast.LENGTH_SHORT).show();
            Selected_fragment=new FragmentIndia();

        }
        else if(i==2){
            Toast.makeText(getApplicationContext(),"It's Sri Lanka",Toast.LENGTH_SHORT).show();
            Selected_fragment=new FragmentSL();

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.id_fragment,Selected_fragment).commit();
    }
}