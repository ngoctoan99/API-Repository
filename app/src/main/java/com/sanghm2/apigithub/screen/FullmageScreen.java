package com.sanghm2.apigithub.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sanghm2.apigithub.R;

import java.util.Objects;

public class FullmageScreen extends AppCompatActivity {
    ImageView imageFull ;
    ImageButton backbtn ;
    String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullmage_screen);
        url = getIntent().getStringExtra("image");
        initView();
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    private void initView() {
        imageFull = findViewById(R.id.imageFull);
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Glide.with(getApplicationContext()).load(url).into(imageFull);
    }
}