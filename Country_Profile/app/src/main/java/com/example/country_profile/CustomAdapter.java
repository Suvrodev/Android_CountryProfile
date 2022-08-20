package com.example.country_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class CustomAdapter extends BaseAdapter {

    int[] flags;
    String[] CountryNames;

    Context context;

    LayoutInflater inflater;

    CustomAdapter(Context context,String[] CountryNames,int[] flags){
        this.context=context;
        this.CountryNames=CountryNames;
        this.flags=flags;
    }


    @Override
    public int getCount() {
        return CountryNames.length;
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
            view= inflater.inflate(R.layout.custom_listview_sampleview,viewGroup,false);

        }


        ImageView imageView=(ImageView)view.findViewById(R.id.id_imview);

        TextView textView=(TextView) view.findViewById(R.id.id_country_name_s);

        imageView.setImageResource(flags[i]);
        textView.setText(CountryNames[i]);

        return view;

    }


}
