package com.muhuo.hybird_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import io.flutter.embedding.android.FlutterFragment;


public class FlutterViewdemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter_viewdemo);
    }

    public void loadFlutter(View view) {
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();


        transaction.add(R.id.content, FlutterFragment.createDefault(),"flutter");


        transaction.commitAllowingStateLoss();
    }
}
