package com.example.country_profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button BangladeshButton,IndiaButton,FinladButton,NewZealandButton,USAButton;
    Button GridviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BangladeshButton= (Button) findViewById(R.id.id_Bangladesh);
        IndiaButton= (Button) findViewById(R.id.id_India);
        FinladButton= (Button) findViewById(R.id.id_Finland);
        NewZealandButton= (Button) findViewById(R.id.id_NZ);
        USAButton= (Button) findViewById(R.id.id_USA);


        GridviewButton= (Button) findViewById(R.id.id_gridview_button);

        BangladeshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),BangladeshButton.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
                intent.putExtra("NameKey","Bangladesh");
                startActivity(intent);
            }
        });
        IndiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),IndiaButton.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
                intent.putExtra("NameKey","India");
                startActivity(intent);
            }
        });
        FinladButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),FinladButton.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
                intent.putExtra("NameKey","FL");
                startActivity(intent);
            }
        });
        NewZealandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),NewZealandButton.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
                intent.putExtra("NameKey","NZ");
                startActivity(intent);
            }
        });
        USAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),USAButton.getText().toString(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
                intent.putExtra("NameKey","USA");
                startActivity(intent);
            }
        });

        try {
            GridviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Activity_GridView.class);
                    startActivity(intent);
                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.id_list_view){
            Intent intent=new Intent(MainActivity.this,Activity_Listview.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId()==R.id.id_custom_list_view){
            Intent intent=new Intent(MainActivity.this,Activity_Listview_Custom.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId()==R.id.id_gridview){
            Intent intent=new Intent(MainActivity.this,Activity_GridView.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId()==R.id.id_recycleview){
            Intent intent=new Intent(MainActivity.this,Activity_Recycleview.class);
            startActivity(intent);
            return true;
        }

        if(item.getItemId()==R.id.id_Spinner){
            Intent intent=new Intent(MainActivity.this,Activity_Spinner.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.id_fragment_option){
            Intent intent=new Intent(MainActivity.this,Activity_Fragment.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}