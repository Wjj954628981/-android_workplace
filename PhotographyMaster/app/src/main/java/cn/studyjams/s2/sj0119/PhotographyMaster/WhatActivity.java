package cn.studyjams.s2.sj0119.PhotographyMaster;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class WhatActivity extends AppCompatActivity {

    private ImageView whatimg;
    private TextView photographyintro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        whatimg = (ImageView) findViewById(R.id.What_img);
        whatimg.setImageResource(R.drawable.photo_what);
        photographyintro = (TextView) findViewById(R.id.Photography_intro);

        photographyintro.setText(this.getResources().getString(R.string.what));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
