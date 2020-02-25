package com.muhuo.hybird_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;

import static com.muhuo.hybird_android.MyApp.CACHED_ENGINE_ID;

/**
 * //                    .::::.
 * //                  .::::::::.
 * //                 :::::::::::
 * //             ..:::::::::::'
 * //           '::::::::::::'
 * //             .::::::::::
 * //        '::::::::::::::..
 * //             ..::::::::::::.
 * //           ``::::::::::::::::
 * //            ::::``:::::::::'        .:::.
 * //           ::::'   ':::::'       .::::::::.
 * //         .::::'      ::::     .:::::::'::::.
 * //        .:::'       :::::  .:::::::::' ':::::.
 * //       .::'        :::::.:::::::::'      ':::::.
 * //      .::'         ::::::::::::::'         ``::::.
 * //  ...:::           ::::::::::::'              ``::.
 * // ```` ':.          ':::::::::'                  ::::..
 * //                    '.:::::'                    ':'````..
 * Created by liaoli 2020-02-24
 */
public class MyFlutterWithCacheEngineActivity extends FlutterActivity {
    public final static String INIT_PARAMS = "initParams";
    private String initParams;

    public static void start(Context context, String initParams) {
        Intent intent = new Intent(context, MyFlutterWithCacheEngineActivity.class);
        intent.putExtra(INIT_PARAMS, initParams);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams = getIntent().getStringExtra(INIT_PARAMS);
    }

    //使用在MyApplication预先初始化好的Flutter引擎以提升Flutter页面打开速度，注意：在这种模式下回导致getInitialRoute 不被调用所以无法设置初始化参数
    @Override
    public String getCachedEngineId() {
        return CACHED_ENGINE_ID;
    }

    /**
     * 重载该方法来传递初始化参数
     * @return
     */
    @NonNull
    @Override
    public String getInitialRoute() {
        return initParams == null ? super.getInitialRoute() : initParams;
    }
}
