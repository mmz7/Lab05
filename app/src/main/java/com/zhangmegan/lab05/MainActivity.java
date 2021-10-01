package com.zhangmegan.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int countonCreate=0;
    int countonStart=0;
    int countonResume=0;
    int countonPause=0;
    int countonStop=0;
    int countonRestart=0;
    int countonDestroy=0;
    TextView current;
    TextView lifetime;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countonCreate++;
        current = findViewById(R.id.first);
        lifetime = findViewById(R.id.second);
        sp = getSharedPreferences("zmlab05", MODE_PRIVATE);
        editor = sp.edit();
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();

    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        setVal();
        getVal();
    }

    private void setVal() {
        editor.putInt("onCreate", countonCreate);
        editor.putInt("onStart", countonStart);
        editor.putInt("onResume", countonResume);
        editor.putInt("onPause", countonPause);
        editor.putInt("onStop", countonStop);
        editor.putInt("onRestart", countonRestart);
        editor.putInt("onDestroy", countonDestroy);

        editor.apply();
    }

    private void getVal() {
        lifetime.setText(getString(R.string.event_counts, sp.getInt("onCreate",0),
                sp.getInt("onStart",0), sp.getInt("onResume",0),
                sp.getInt("onPause",0), sp.getInt("onStop",0),
                sp.getInt("onRestart",0), sp.getInt("onDestroy",0);
    }
}