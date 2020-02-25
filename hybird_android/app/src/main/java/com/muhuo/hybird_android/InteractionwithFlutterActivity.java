package com.muhuo.hybird_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;

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
public class InteractionwithFlutterActivity extends FlutterActivity implements View.OnClickListener ,IShowMessage{
    public final static String INIT_PARAMS = "initParams";
    private String initParams;
    private BasicMessageChannelPlugin basicMessageChannelPlugin;

    Activity activity;
    TextView textShow;
    TextView channel;
    EditText input;
    private EventChannelPlugin eventChannelPlugin;
    private boolean isBasic;

    public static void start(Context context, String initParams) {
        Intent intent = new Intent(context, InteractionwithFlutterActivity.class);
        intent.putExtra(INIT_PARAMS, initParams);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initParams = getIntent().getStringExtra(INIT_PARAMS);

        basicMessageChannelPlugin =new  BasicMessageChannelPlugin( this,getFlutterEngine().getDartExecutor());
        MethodChannelPlugin methodChannelPlugin = new MethodChannelPlugin(getFlutterEngine().getDartExecutor(),this);
         eventChannelPlugin = new EventChannelPlugin(getFlutterEngine().getDartExecutor());


        initview(this);

        updateChannel();

    }

    private void updateChannel() {
        String s = isBasic? "basicMessageChannelPlugin":"eventChannelPlugin";
        channel.setText(s);
    }

    private void initview(Activity activity) {
        ViewGroup contentView = activity.findViewById(android.R.id.content);
        View view = LayoutInflater.from(activity).inflate(R.layout.interaction, null);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        contentView.addView(view, layoutParams);


        textShow = view.findViewById(R.id.textShow);
        channel = view.findViewById(R.id.channel);

        input = view.findViewById(R.id.input);
        TextView titleView = view.findViewById(R.id.title);
        view.findViewById(R.id.btnSend).setOnClickListener(this);


        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(isBasic){
                    basicMessageChannelPlugin.send(charSequence.toString(),InteractionwithFlutterActivity.this::onShowMessage);
                }else {
                    eventChannelPlugin.send(charSequence.toString());
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Switch mySwitch  =  view.findViewById(R.id.my_switch);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isBasic = isChecked;
                updateChannel();
            }
        });

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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onShowMessage(String message) {

        textShow.setText(message);
    }

    @Override
    public void sendMessage(String message, boolean useEventChannel) {




    }
}
