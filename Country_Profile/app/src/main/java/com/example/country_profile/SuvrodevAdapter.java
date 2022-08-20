package com.example.country_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SuvrodevAdapter extends BaseAdapter {

    Context context;
    String[] CountryNames;
    int[] Flags;

    LayoutInflater inflater;

    SuvrodevAdapter(Context context, String[] CountryNames,  int[] Flags){
        this.context=context;
        this.CountryNames=CountryNames;
        this.Flags=Flags;
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
            view= inflater.inflate(R.layout.gridview_sampleview,viewGroup,false);
        }

        ImageView imageView=(ImageView)view.findViewById(R.id.id_gridview_image);
        TextView textView=(TextView) view.findViewById(R.id.id_gridview_text);

        imageView.setImageResource(Flags[i]);
        textView.setText(CountryNames[i]);

        return view;
    }
}
