package com.ead.widi_1202152333_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView imgview, imageView2;
    TextView textView1, textView2;

    public ArrayList<Integer> galon;

    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int gambar = getIntent().getIntExtra("gambar",0);
        String judul = getIntent().getStringExtra("judul");

        imgview = (ImageView)findViewById(R.id.img_detail);
        textView1 =(TextView)findViewById(R.id.title_detail);
        imgview.setImageResource(gambar);
        textView1.setText(judul.toString());
        imageView2 = (ImageView)findViewById(R.id.gambar_battery);


        galon = new ArrayList<>();
        galon.add(R.drawable.galon_20);
        galon.add(R.drawable.galon_40);
        galon.add(R.drawable.galon_50);
        galon.add(R.drawable.galon_60);
        galon.add(R.drawable.galon_80);
        galon.add(R.drawable.galon_full);

        imageView2.setImageResource(galon.get(count));



    }

    public void tambah(View view) {
        if (count==6){
            Toast.makeText(DetailActivity.this,"Air penuh",Toast.LENGTH_LONG).show();
        }else {
            count++;
            imageView2.setImageResource(galon.get(count));


        }

    }

    public void kurang(View view) {
        if(count==1){
            Toast.makeText(DetailActivity.this,"Air sedikit",Toast.LENGTH_LONG).show();
        }
        else {
            count--;
            imageView2.setImageResource(galon.get(count));

        }
    }
}
