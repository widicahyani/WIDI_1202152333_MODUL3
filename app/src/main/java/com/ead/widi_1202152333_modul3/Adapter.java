package com.ead.widi_1202152333_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<String> merk;
    private ArrayList<Integer> gambar;

    public Adapter(ArrayList<String> kota, ArrayList<Integer> gambar){
        this.merk = kota;
        this.gambar =gambar;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder viewHolder, int i) {

        viewHolder.txtkota.setText(merk.get(i));

        viewHolder.relativeLayout.setBackgroundResource(gambar.get(i));
    }

    @Override
    public int getItemCount() {
        return merk.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtkota;
        private ImageView imageView;
        private RelativeLayout relativeLayout;
        public ViewHolder(View view) {
            super(view);
            txtkota = (TextView)view.findViewById(R.id.judul);

            relativeLayout =(RelativeLayout)view.findViewById(R.id.background_list);
        }
    }
}

