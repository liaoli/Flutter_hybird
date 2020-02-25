package com.muhuo.hybird_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void flutterView(View view) {

        Intent i = new Intent(this, FlutterViewdemoActivity.class);

        startActivity(i);

    }

    public void flutterActivity(View view) {
//        Intent i = new Intent(this, FlutterActivity.class);
//
//        startActivity(i);


        startActivity(FlutterActivity.createDefaultIntent(this));

    }

    public void MyflutterActivity(View view) {
        MyFlutterActivity.start(this,"{\"name\": \"SO JSON在线\",\"url\": \"https://www.sojson.com\", \"address\": {\"city\": \"北京\",\"country\": \"中国\"},\"domain_list\": [{\"name\": \"ICP备案查询\",\"url\": \"https://icp.sojson.com\"},{\"name\": \"JSON在线解析\",\"url\": \"https://www.sojson.com\"},{\"name\": \"房贷计算器\",\"url\": \"https://fang.sojson.com\"]}");
    }

    public void flutterActivityWithkRoute(View view) {

        startActivity(
                FlutterActivity
                        .withNewEngine()
                        .initialRoute("/my_route")
                        .build(this)
        );
    }

    public void flutterActivityWithEngine(View view) {

        startActivity(
                FlutterActivity
                        .withCachedEngine("MY_CACHED_ENGINE_ID")
                        .build(this)
        );
    }



    public void flutterActivityWithEngine2(View view) {

        MyFlutterWithCacheEngineActivity.start(this,"{\"name\": \"SO JSON在线\",\"url\": \"https://www.sojson.com\", \"address\": {\"city\": \"北京\",\"country\": \"中国\"},\"domain_list\": [{\"name\": \"ICP备案查询\",\"url\": \"https://icp.sojson.com\"},{\"name\": \"JSON在线解析\",\"url\": \"https://www.sojson.com\"},{\"name\": \"房贷计算器\",\"url\": \"https://fang.sojson.com\"]}");

    }

    public void InteractionwithFlutterActivity(View view) {

        InteractionwithFlutterActivity.start(this,"{\"name\": \"SO JSON在线\",\"url\": \"https://www.sojson.com\", \"address\": {\"city\": \"北京\",\"country\": \"中国\"},\"domain_list\": [{\"name\": \"ICP备案查询\",\"url\": \"https://icp.sojson.com\"},{\"name\": \"JSON在线解析\",\"url\": \"https://www.sojson.com\"},{\"name\": \"房贷计算器\",\"url\": \"https://fang.sojson.com\"]}");
    }
}
