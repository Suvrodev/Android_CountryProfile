package com.example.country_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String[] CountryName;
    String[] Population;
    int[] Flags;

    public MyAdapter(Context context, String[] countryName,String[] Population, int[] flags) {
        this.context = context;
        CountryName = countryName;
        this.Population=Population;
        Flags = flags;
    }





    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.recyclebinsampleview, parent,false);

        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(Flags[position]);
        holder.Title.setText(CountryName[position]);
        holder.Desc.setText(Population[position]);
    }

    @Override
    public int getItemCount() {
        return CountryName.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Title;
        TextView Desc;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.id_rcv_image);
            Title= itemView.findViewById(R.id.id_rcb_title);
            Desc=itemView.findViewById(R.id.id_rcb_desc);

        }
    }


}
