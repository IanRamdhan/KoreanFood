package com.fryanramzkhar.koreanfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFood extends AppCompatActivity {

    @BindView(R.id.imgFood)
    ImageView imgFood;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        ButterKnife.bind(this);

        txtTitle.setText(getIntent().getStringExtra("nf"));
        txtDetail.setText(getIntent().getStringExtra("df"));
        Glide.with(this).load(getIntent().getIntExtra("gf",0)).into(imgFood);
    }
}
