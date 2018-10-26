package com.fryanramzkhar.koreanfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleKorean extends AppCompatActivity {

    @BindView(R.id.my_recycle_korean)
    RecyclerView myRecycleKorean;

    String[] namaFood,detailFood;
    int[] gambarFood;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_korean);
        ButterKnife.bind(this);

        namaFood = getResources().getStringArray(R.array.korean_food);
        detailFood = getResources().getStringArray(R.array.detail_makanan);
        gambarFood = new int[]{R.drawable.japchae,R.drawable.bibimbap,R.drawable.ramyeon,R.drawable.tteokbokki,R.drawable.kimchi,R.drawable.kimbap,R.drawable.jajangmyeon,R.drawable.sannakji,R.drawable.miyeokguk,R.drawable.haejangguk};

        com.fryanramzkhar.koreanfood.Adapter adapter = new com.fryanramzkhar.koreanfood.Adapter(RecycleKorean.this, gambarFood,namaFood,detailFood);
        myRecycleKorean.setHasFixedSize(true);
        myRecycleKorean.setLayoutManager(new LinearLayoutManager(RecycleKorean.this));
        myRecycleKorean.setAdapter(adapter);

    }
}
