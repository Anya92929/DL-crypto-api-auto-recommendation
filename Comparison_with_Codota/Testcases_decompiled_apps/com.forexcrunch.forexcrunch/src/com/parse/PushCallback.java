package com.parse;

import android.app.Service;
import org.json.JSONObject;

public abstract class PushCallback implements Runnable {
    protected String channel;
    protected JSONObject localData;
    protected JSONObject pushData;
    protected Service service;

    public void setLocalData(JSONObject theLocalData) {
        this.localData = theLocalData;
    }

    public void setPushData(JSONObject thePushData) {
        this.pushData = thePushData;
    }

    public void setService(Service theService) {
        this.service = theService;
    }

    public void setChannel(String theChannel) {
        this.channel = theChannel;
    }
}
