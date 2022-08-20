package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Activity_GridView extends AppCompatActivity {

    GridView gridView;
    SuvrodevAdapter suvrodevAdapter;
    int[] Flagss={
            R.drawable.bangladesh_flag, R.drawable.india_flag, R.drawable.sri_lanka_flag, R.drawable.pakistan_flag, R.drawable.nepal_flag,
            R.drawable.bhutan_flag, R.drawable.australia_flag, R.drawable.nz_flag, R.drawable.finland_flag, R.drawable.ireland_flag,
            R.drawable.usa_flag, R.drawable.uk_flag, R.drawable.canada_flag, R.drawable.german_flag, R.drawable.south_africa_flag, R.drawable.brazil_flag,
            R.drawable.argentina_flag, R.drawable.china_flagg, R.drawable.greenland_flag,R.drawable.japan_flag
    };

    Button ClickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);



        gridView= (GridView) findViewById(R.id.id_gridviews);
        String[] CountryNamess=getResources().getStringArray(R.array.CountryName);


        int Length= CountryNamess.length;
        Toast.makeText(getApplicationContext(),"Length"+Length,Toast.LENGTH_SHORT).show();



        ClickButton= (Button) findViewById(R.id.click_id);
        ClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });



        try {
            suvrodevAdapter = new SuvrodevAdapter(this, CountryNamess, Flagss);
            gridView.setAdapter(suvrodevAdapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String Value= CountryNamess[i];
                Toast.makeText(getApplicationContext(),"Item: "+Value,Toast.LENGTH_SHORT).show();
            }
        });




    }
}