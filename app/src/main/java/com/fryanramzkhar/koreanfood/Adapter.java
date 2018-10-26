package com.fryanramzkhar.koreanfood;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    int[] gambarFood;
    String[] namaFood,detailFood;

    public Adapter(Context context, int[] gambarFood, String[] namaFood, String[] detailFood) {
        this.context = context;
        this.gambarFood = gambarFood;
        this.namaFood = namaFood;
        this.detailFood = detailFood;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_food,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtFood.setText(namaFood[i]);
        Glide.with(context).load(gambarFood[i]).into(viewHolder.imgFood);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailFood.class);
                pindah.putExtra("nf", namaFood[i]);
                pindah.putExtra("df",detailFood[i]);
                pindah.putExtra("gf",gambarFood[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarFood.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView txtFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgList);
            txtFood = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
