package com.tapcrowd.app.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class PersonalProgramSync {
    private static String token;

    public interface onFinishedListener {
        void onFinish();
    }

    public static void add(final Context context, final String eventid, final String type, final String typeid) {
        if (UserModule.isLoggedIn(context)) {
            new Thread(new Runnable() {
                public void run() {
                    String hash = Converter.md5("tcadm" + PersonalProgramSync.getToken() + UserModule.getUserId(context) + type + typeid);
                    List<NameValuePair> postparams = new ArrayList<>();
                    postparams.add(new BasicNameValuePair("appid", App.f2123id));
                    postparams.add(new BasicNameValuePair("userid", UserModule.getUserId(context)));
                    postparams.add(new BasicNameValuePair("externaluserid", ""));
                    postparams.add(new BasicNameValuePair("token", PersonalProgramSync.getToken()));
                    postparams.add(new BasicNameValuePair("hash", hash));
                    postparams.add(new BasicNameValuePair("eventid", eventid));
                    postparams.add(new BasicNameValuePair("object", type));
                    postparams.add(new BasicNameValuePair("objectid", typeid));
                    Log.d("ADD", Internet.request("http://api.tapcrowd.com/api/2.0/myprogram/add", postparams));
                }
            }).start();
        }
    }

    public static void remove(final Context context, final String eventid, final String type, final String typeid) {
        if (UserModule.isLoggedIn(context)) {
            new Thread(new Runnable() {
                public void run() {
                    String hash = Converter.md5("tcadm" + PersonalProgramSync.getToken() + UserModule.getUserId(context) + type + typeid);
                    List<NameValuePair> postparams = new ArrayList<>();
                    postparams.add(new BasicNameValuePair("appid", App.f2123id));
                    postparams.add(new BasicNameValuePair("userid", UserModule.getUserId(context)));
                    postparams.add(new BasicNameValuePair("externaluserid", ""));
                    postparams.add(new BasicNameValuePair("token", PersonalProgramSync.getToken()));
                    postparams.add(new BasicNameValuePair("hash", hash));
                    postparams.add(new BasicNameValuePair("eventid", eventid));
                    postparams.add(new BasicNameValuePair("object", type));
                    postparams.add(new BasicNameValuePair("objectid", typeid));
                    Log.d("REMOVE", Internet.request("http://api.tapcrowd.com/api/2.0/myprogram/remove", postparams));
                }
            }).start();
        }
    }

    public static void search(final Context context, final String eventid) {
        new Thread(new Runnable() {
            public void run() {
                PersonalProgramSync.searchMethod(context, eventid);
            }
        }).start();
    }

    public static void search(final Context context, final String eventid, final onFinishedListener listener) {
        new Thread(new Runnable() {
            public void run() {
                PersonalProgramSync.searchMethod(context, eventid);
                final onFinishedListener onfinishedlistener = listener;
                ((Activity) context).runOnUiThread(new Runnable() {
                    public void run() {
                        onfinishedlistener.onFinish();
                    }
                });
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static void searchMethod(Context context, String eventid) {
        if (UserModule.getUserId(context) == null) {
        }
        List<NameValuePair> postparams = new ArrayList<>();
        postparams.add(new BasicNameValuePair("appid", App.f2123id));
        postparams.add(new BasicNameValuePair("userid", UserModule.getUserId(context)));
        postparams.add(new BasicNameValuePair("externaluserid", ""));
        postparams.add(new BasicNameValuePair("eventid", eventid));
        postparams.add(new BasicNameValuePair("token", getToken()));
        String response = Internet.request("http://api.tapcrowd.com/api/2.0/myprogram/search", postparams);
        Log.d("SEARCH", response);
        try {
            C1199DB.remove("persprog", "origin", "'api'");
            JSONArray array = new JSONArray(response);
            int len = array.length();
            for (int i = 0; i < len; i++) {
                JSONObject item = array.getJSONObject(i);
                String table = item.getString("table");
                if (table.endsWith("s")) {
                    table.substring(0, table.length() - 1);
                }
                if (C1199DB.getSize("persprog", String.valueOf(table) + DBFavorites.KEY_EVENT_ID, item.getString("tableid")) > 0) {
                    C1199DB.remove("persprog", String.valueOf(table) + DBFavorites.KEY_EVENT_ID, item.getString("tableid"));
                }
                ContentValues cv = new ContentValues();
                cv.put(String.valueOf(table) + DBFavorites.KEY_EVENT_ID, item.getString("tableid"));
                cv.put("eventid", item.getString("eventid"));
                cv.put("origin", "api");
                C1199DB.add("persprog", cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static String getToken() {
        if (token == null) {
            token = C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get("token");
        }
        return token;
    }
}
