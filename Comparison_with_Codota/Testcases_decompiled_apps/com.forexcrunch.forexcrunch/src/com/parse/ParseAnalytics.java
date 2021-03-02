package com.parse;

import android.content.Intent;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseAnalytics {
    private static final String TAG = "com.parse.ParseAnalytics";

    public static void trackAppOpened(Intent intent) {
        String parseData = null;
        if (!(intent == null || intent.getExtras() == null)) {
            parseData = intent.getExtras().getString("com.parse.Data");
        }
        trackAppOpened(parseData);
    }

    public static void trackEvent(String name) {
        trackEvent(name, (Map<String, String>) null);
    }

    public static void trackEvent(String name, Map<String, String> dimensions) {
        if (name == null || name.trim().length() == 0) {
            throw new RuntimeException("A name for the custom event must be provided.");
        }
        ParseCommand command = new ParseCommand("client_events", ParseUser.getCurrentSessionToken());
        command.put("at", Parse.dateToObject(new Date()));
        command.put("name", name);
        if (dimensions != null) {
            command.put("dimensions", Parse.encodeJSONObject(dimensions, false));
        }
        Parse.getCommandCache().runEventuallyAsync(command, (ParseObject) null);
    }

    private static void trackAppOpened(String pushData) {
        ParseCommand command = new ParseCommand("client_app_opened", ParseUser.getCurrentSessionToken());
        command.put("at", Parse.dateToObject(new Date()));
        if (pushData != null) {
            try {
                String pushHash = new JSONObject(pushData).optString("push_hash");
                if (pushHash.length() > 0) {
                    command.put("push_hash", pushHash);
                }
            } catch (JSONException e) {
                Parse.logE(TAG, "Failed to parse push data: " + e.getMessage());
            }
        }
        Parse.getCommandCache().runEventuallyAsync(command, (ParseObject) null);
    }
}
