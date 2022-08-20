package com.example.country_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Profile extends AppCompatActivity {

    ImageView imageView;
    TextView Title,Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView= (ImageView) findViewById(R.id.id_Picture);
        Title= (TextView) findViewById(R.id.id_country_name);
        Description= (TextView) findViewById(R.id.id_Country_description);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String CountryName=bundle.getString("NameKey");

            if(CountryName.equalsIgnoreCase("Bangladesh")){
                imageView.setImageResource(R.drawable.bangladesh);
                Title.setText("Bangladesh");
                Description.setText(R.string.Bangladesh_Desc);
            }
            if(CountryName.equalsIgnoreCase("India")){
                imageView.setImageResource(R.drawable.india_desc_img);
                Title.setText("India");
                Description.setText(R.string.India_Desc);
            }
            if(CountryName.equalsIgnoreCase("FL")){
                imageView.setImageResource(R.drawable.finland_flag);
                Title.setText("Finland");
                Description.setText(R.string.Finland_Desc);
            }
            if(CountryName.equalsIgnoreCase("Nz")){
                imageView.setImageResource(R.drawable.nz_flag);
                Title.setText("New Zealand");
                Description.setText(R.string.NZ_Desc);
            }
            if(CountryName.equalsIgnoreCase("USA")){
                imageView.setImageResource(R.drawable.usa_flag);
                Title.setText("USA");
                Description.setText(R.string.USA_Desc);
            }
        }
    }
}