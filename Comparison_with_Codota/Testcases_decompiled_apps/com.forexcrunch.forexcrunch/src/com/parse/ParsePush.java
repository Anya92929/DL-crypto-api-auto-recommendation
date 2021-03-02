package com.parse;

import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.parse.gdata.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePush {
    private static final String TAG = "com.parse.ParsePush";
    private Set<String> channelSet = null;
    private JSONObject data;
    private Long expirationTime = null;
    private Long expirationTimeInterval = null;
    private Boolean pushToAndroid = null;
    private Boolean pushToIOS = null;
    private ParseQuery<ParseInstallation> query = null;

    public static void sendMessageInBackground(String message, ParseQuery<ParseInstallation> query2) {
        sendMessageInBackground(message, query2, (SendCallback) null);
    }

    public static void sendMessageInBackground(String message, ParseQuery<ParseInstallation> query2, SendCallback callback) {
        ParsePush push = new ParsePush();
        push.setQuery(query2);
        push.setMessage(message);
        push.sendInBackground(callback);
    }

    public static void sendDataInBackground(JSONObject data2, ParseQuery<ParseInstallation> query2) {
        sendDataInBackground(data2, query2, (SendCallback) null);
    }

    public static void sendDataInBackground(JSONObject data2, ParseQuery<ParseInstallation> query2, SendCallback callback) {
        ParsePush push = new ParsePush();
        push.setQuery(query2);
        push.setData(data2);
        push.sendInBackground(callback);
    }

    public void setChannel(String channel) {
        Preconditions.checkArgument(channel != null, "channel cannot be null");
        this.channelSet = new HashSet();
        this.channelSet.add(channel);
        this.query = null;
    }

    public void setChannels(Collection<String> channels) {
        Preconditions.checkArgument(channels != null, "channels collection cannot be null");
        for (String channel : channels) {
            Preconditions.checkArgument(channel != null, "channel cannot be null");
        }
        this.channelSet = new HashSet();
        this.channelSet.addAll(channels);
        this.query = null;
    }

    public void setQuery(ParseQuery<ParseInstallation> query2) {
        boolean z = true;
        Preconditions.checkArgument(query2 != null, "Cannot target a null query");
        if (!(this.pushToIOS == null && this.pushToAndroid == null)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        Preconditions.checkArgument(query2.getClassName().equals(ParseObject.getClassName(ParseInstallation.class)), "Can only push to a query for Installations");
        this.channelSet = null;
        this.query = query2;
    }

    public void setExpirationTime(long time) {
        this.expirationTime = Long.valueOf(time);
        this.expirationTimeInterval = null;
    }

    public void setExpirationTimeInterval(long timeInterval) {
        this.expirationTime = null;
        this.expirationTimeInterval = Long.valueOf(timeInterval);
    }

    public void clearExpiration() {
        this.expirationTime = null;
        this.expirationTimeInterval = null;
    }

    @Deprecated
    public void setPushToIOS(boolean pushToIOS2) {
        Preconditions.checkArgument(this.query == null, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        this.pushToIOS = Boolean.valueOf(pushToIOS2);
    }

    @Deprecated
    public void setPushToAndroid(boolean pushToAndroid2) {
        Preconditions.checkArgument(this.query == null, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        this.pushToAndroid = Boolean.valueOf(pushToAndroid2);
    }

    public void setData(JSONObject data2) {
        this.data = data2;
    }

    public void setMessage(String message) {
        JSONObject data2 = new JSONObject();
        try {
            data2.put("alert", message);
        } catch (JSONException e) {
            Parse.logE(TAG, "JSONException in setMessage", e);
        }
        setData(data2);
    }

    private Task<Void> sendAsync() {
        return buildCommand(ParseUser.getCurrentSessionToken()).performAsync().continueWith(new Continuation<Object, Void>() {
            public Void then(Task<Object> task) throws Exception {
                return null;
            }
        });
    }

    public void send() throws ParseException {
        Parse.waitForTask(sendAsync());
    }

    public void sendInBackground(SendCallback callback) {
        Parse.callbackOnMainThreadAsync(sendAsync(), callback);
    }

    public void sendInBackground() {
        sendInBackground((SendCallback) null);
    }

    /* access modifiers changed from: package-private */
    public ParseCommand buildCommand(String sessionToken) {
        boolean willPushToAndroid;
        boolean willPushToIOS;
        ParseCommand command = new ParseCommand("client_push", sessionToken);
        if (this.data == null) {
            throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
        }
        command.put("data", this.data);
        if (this.query != null) {
            command.put("where", this.query.getFindParams().optJSONObject("data"));
        } else if (this.channelSet == null) {
            command.put("channel", "");
        } else {
            command.put("channels", new JSONArray(this.channelSet));
        }
        if (this.expirationTime != null) {
            command.put("expiration_time", this.expirationTime.longValue());
        } else if (this.expirationTimeInterval != null) {
            command.put("expiration_time_interval", this.expirationTimeInterval.longValue());
        }
        if (this.query == null && !(this.pushToAndroid == null && this.pushToIOS == null)) {
            if (this.pushToAndroid == null || this.pushToAndroid.booleanValue()) {
                willPushToAndroid = true;
            } else {
                willPushToAndroid = false;
            }
            if (this.pushToIOS == null || !this.pushToIOS.booleanValue()) {
                willPushToIOS = false;
            } else {
                willPushToIOS = true;
            }
            if (!willPushToIOS || !willPushToAndroid) {
                if (willPushToIOS) {
                    command.put(ChartActivity.TYPE, "ios");
                } else if (willPushToAndroid) {
                    command.put(ChartActivity.TYPE, "android");
                } else {
                    throw new IllegalArgumentException("Cannot push if both pushToIOS and pushToAndroid are false");
                }
            }
        }
        return command;
    }
}
