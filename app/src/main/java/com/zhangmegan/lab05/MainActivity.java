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

    int lifeonCreate;
    int lifeonStart;
    int lifeonResume;
    int lifeonPause;
    int lifeonStop;
    int lifeonRestart;
    int lifeonDestroy;
    TextView current;
    TextView lifetime;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countonCreate++;
        lifeonCreate++;
        current = findViewById(R.id.first);
        lifetime = findViewById(R.id.second);
        sp = getSharedPreferences("zmlab05", MODE_PRIVATE);
        editor = sp.edit();
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();

    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        lifeonStart++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        setVal();
        getVal();
    }

    @Override
    protected void onResume() {
        super.onResume();
        countonResume++;
        lifeonResume++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        lifeonPause++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countonRestart++;
        lifeonRestart++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countonStop++;
        lifeonStop++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countonDestroy++;
        lifeonDestroy++;
        current.setText(getString(R.string.event_counts, countonCreate, countonStart,
                countonResume, countonPause, countonStop, countonRestart, countonDestroy));
        lifetime.setText(getString(R.string.event_counts, lifeonCreate, lifeonStart, lifeonResume,
                lifeonPause, lifeonStop, lifeonRestart, lifeonDestroy));
        getVal();
        setVal();
    }

    private void setVal() {
        editor.putInt("onCreate", lifeonCreate);
        editor.putInt("onStart", lifeonStart);
        editor.putInt("onResume", lifeonResume);
        editor.putInt("onPause", lifeonPause);
        editor.putInt("onStop", lifeonStop);
        editor.putInt("onRestart", lifeonRestart);
        editor.putInt("onDestroy", lifeonDestroy);

        editor.apply();
    }

    private void getVal() {
        lifeonCreate = sp.getInt("onCreate", 0);
        lifeonStart = sp.getInt("onStart", 0);
        lifeonResume = sp.getInt("onResume", 0);
        lifeonPause = sp.getInt("onPause", 0);
        lifeonStop = sp.getInt("onStop", 0);
        lifeonRestart = sp.getInt("onRestart", 0);
        lifeonDestroy = sp.getInt("onDestroy", 0);
    }
}