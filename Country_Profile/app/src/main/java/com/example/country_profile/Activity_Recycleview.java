package com.example.country_profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Recycleview extends AppCompatActivity {

    RecyclerView recyclerView;
    int[] Flags={
            R.drawable.bangladesh_flag, R.drawable.india_flag, R.drawable.sri_lanka_flag, R.drawable.pakistan_flag, R.drawable.nepal_flag,
            R.drawable.bhutan_flag, R.drawable.australia_flag, R.drawable.nz_flag, R.drawable.finland_flag, R.drawable.ireland_flag,
            R.drawable.usa_flag, R.drawable.uk_flag, R.drawable.canada_flag, R.drawable.german_flag, R.drawable.south_africa_flag, R.drawable.brazil_flag,
            R.drawable.argentina_flag, R.drawable.china_flagg, R.drawable.greenland_flag,R.drawable.japan_flag
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        recyclerView= (RecyclerView) findViewById(R.id.id_recycleview);
        String[] CountryNames=getResources().getStringArray(R.array.CountryName);
        String[] Population=getResources().getStringArray(R.array.population);


        MyRadapter myRadapter=new MyRadapter(this,CountryNames,Population,Flags);
        recyclerView.setAdapter(myRadapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
    }


    private class MyRadapter extends RecyclerView.Adapter<MyRadapter.MyViewHolder>{

        Context context;
        String[] CountryName;
        String[] Population;
        int[] Flags;

        public MyRadapter(Context context, String[] countryName, String[] population, int[] flags) {
            this.context = context;
            CountryName = countryName;
            Population = population;
            Flags = flags;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater=LayoutInflater.from(context);
            View view= layoutInflater.inflate(R.layout.recyclebinsampleview,parent,false);


            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
             holder.imageView.setImageResource(Flags[position]);
             holder.Title.setText(CountryName[position]);
             holder.Desc.setText(Population[position]);
        }

        @Override
        public int getItemCount() {
            return CountryName.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

             TextView Title,Desc;
             ImageView imageView;

            public MyViewHolder(View view) {
                super(view);

                imageView=view.findViewById(R.id.id_rcv_image);
                Title=view.findViewById(R.id.id_rcb_title);
                Desc=view.findViewById(R.id.id_rcb_desc);
            }
        }
    }
}