package com.ead.widi_1202152333_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> merk;
    private ArrayList<Integer> img;
    private  ArrayList<String> diksripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

    }
    private void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        img = new ArrayList<>();
        img.add(R.drawable.ades);
        img.add(R.drawable.amidis);
        img.add(R.drawable.aqua);
        img.add(R.drawable.cleo);
        img.add(R.drawable.club);
        img.add(R.drawable.equil);
        img.add(R.drawable.evian);
        img.add(R.drawable.leminerale);
        img.add(R.drawable.nestle);
        img.add(R.drawable.pristine);
        img.add(R.drawable.vit);

        merk = new ArrayList<>();
        merk.add("Ades");
        merk.add("Amidis");
        merk.add("Aqua");
        merk.add("Cleo");
        merk.add("Club");
        merk.add("Equil");
        merk.add("Evian");
        merk.add("Mineral");
        merk.add("Nestle");
        merk.add("Prestine");
        merk.add("VIT");

        diksripsi = new ArrayList<>();
        diksripsi.add(
                "Ades merupakan pelopor botol air minum yang dapat diremas sebelum dibuang.");
        diksripsi.add("");

        RecyclerView.Adapter adapter = new Adapter(merk , img);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                    intent.putExtra("gambar",img.get(position));
                    intent.putExtra("judul",merk.get(position));
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), kota.get(position), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
}}
