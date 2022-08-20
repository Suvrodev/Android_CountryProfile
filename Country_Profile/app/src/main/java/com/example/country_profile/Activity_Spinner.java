package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Spinner extends AppCompatActivity {

    Spinner spinner;
    String[] CoutryName;
    String[] Populations;
    int[] Flags={
            R.drawable.bangladesh_flag, R.drawable.india_flag, R.drawable.sri_lanka_flag, R.drawable.pakistan_flag, R.drawable.nepal_flag,
            R.drawable.bhutan_flag, R.drawable.australia_flag, R.drawable.nz_flag, R.drawable.finland_flag, R.drawable.ireland_flag,
            R.drawable.usa_flag, R.drawable.uk_flag, R.drawable.canada_flag, R.drawable.german_flag, R.drawable.south_africa_flag, R.drawable.brazil_flag,
            R.drawable.argentina_flag, R.drawable.china_flagg, R.drawable.greenland_flag,R.drawable.japan_flag
    };

    boolean isFirstSelection=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        CoutryName=getResources().getStringArray(R.array.CountryName);
        Populations=getResources().getStringArray(R.array.population);

        spinner= (Spinner) findViewById(R.id.id_spinner_);
        Spinner_Adapter spinnerAdapter=new Spinner_Adapter(this,CoutryName,Populations,Flags);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(isFirstSelection==true){
                    isFirstSelection=false;
                }else {
                    Toast.makeText(getApplicationContext(), CoutryName[i], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private class Spinner_Adapter extends BaseAdapter {

        Context context;
        String[] CountryName;
        String[] Population;
        int[] Flags;

        LayoutInflater inflater;


        public Spinner_Adapter(Context context, String[] countryName, String[] population, int[] flags) {
            this.context = context;
            CountryName = countryName;
            Population = population;
            Flags = flags;
        }

        @Override
        public int getCount() {
            return CountryName.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null){
               inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               view = inflater.inflate(R.layout.spinnersampleview,viewGroup,false);
            }

            ImageView imageView=view.findViewById(R.id.id_spinner_image);
            TextView Title=view.findViewById(R.id.id_spinner_title);
            TextView Desc=view.findViewById(R.id.id_spinner_desc);

            imageView.setImageResource(Flags[i]);
            Title.setText(CountryName[i]);
            Desc.setText(Population[i]);



            return view;
        }
    }
}