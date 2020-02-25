package com.muhuo.hybird_android;

import android.app.Activity;
import android.widget.Toast;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;

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
 * Created by liaoli 2020-02-25
 */
public class BasicMessageChannelPlugin implements BasicMessageChannel.MessageHandler<String>, BasicMessageChannel.Reply<String> {


    private Activity activity;

    private BasicMessageChannel<String> messageChannel;

    public BasicMessageChannelPlugin(Activity activity, BinaryMessenger messenger) {
        this.activity = activity;
        this.messageChannel = new BasicMessageChannel<>(messenger, "BasicMessageChannelPlugin", StringCodec.INSTANCE);
        messageChannel.setMessageHandler(this);
    }

    //MessageHandler 接口
    @Override
    public void onMessage(String message, BasicMessageChannel.Reply<String> reply) {
        reply.reply("BasicMessageChannel收到：" + message);//可以通过reply进行回复

        if (activity instanceof IShowMessage) {
            ((IShowMessage) activity).onShowMessage(message);
        }

        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 向Dart发送消息，并接受Dart的反馈
     *
     * @param message  要给Dart发送的消息内容
     * @param callback 来自Dart的反馈
     */
    void send(String message, BasicMessageChannel.Reply<String> callback) {
        messageChannel.send(message, callback);
    }

    //Reply 接口
    @Override
    public void reply(String reply) {

    }
}
