package com.muhuo.hybird_android;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

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
public class EventChannelPlugin implements EventChannel.StreamHandler {

    private EventChannel.EventSink eventSink;

    public EventChannelPlugin(BinaryMessenger messenger) {

        EventChannel channel = new EventChannel(messenger,"EventChannelPlugin");
        channel.setStreamHandler(this);
    }

    void send(Object params) {
        if (eventSink != null) {
            eventSink.success(params);
        }
    }
    @Override
    public void onListen(Object arguments, EventChannel.EventSink events) {

        this.eventSink = events;
    }

    @Override
    public void onCancel(Object arguments) {
        this.eventSink = null;
    }
}
