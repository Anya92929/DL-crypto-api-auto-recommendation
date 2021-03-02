package com.tapcrowd.tcanalytics;

import android.content.Context;
import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BulkTimerClass {
    final int PERIOD = 20000;
    private final String baseurl = "http://analytics.staging.tapcrowd.com/0.2/analyticsservice/bulk";
    Context context;
    private Timer timer = new Timer("TCAnalytics");

    public BulkTimerClass(Context context2) {
        this.context = context2;
    }

    public void start() {
        this.timer.cancel();
        this.timer = new Timer("TCAnalytics");
        this.timer.scheduleAtFixedRate(new Task(this, (Task) null), 0, 20000);
    }

    private class Task extends TimerTask {
        private Task() {
        }

        /* synthetic */ Task(BulkTimerClass bulkTimerClass, Task task) {
            this();
        }

        public void run() {
            C1271DB.openDataBase(BulkTimerClass.this.context);
            Cursor c = C1271DB.getQuery("SELECT * FROM request WHERE sessionid != ''");
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray bulk = new JSONArray();
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        JSONObject log = new JSONObject();
                        String action = c.getString(c.getColumnIndex("function"));
                        String parameters = c.getString(c.getColumnIndex("parameters"));
                        String sessionid = c.getString(c.getColumnIndex("sessionid"));
                        arrayList.add(String.valueOf(action) + "====" + parameters);
                        String[] values = parameters.replace("?", "").split("&");
                        try {
                            log.put("action", action);
                            for (String value : values) {
                                String[] tolog = value.split("=");
                                if (tolog.length == 2) {
                                    log.put(tolog[0], tolog[1]);
                                }
                            }
                            log.put("sessionid", sessionid);
                            bulk.put(log);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } while (c.moveToNext());
                }
                c.close();
            }
            if (bulk.length() > 0) {
                HttpResponse httpresponse = null;
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost("http://analytics.staging.tapcrowd.com/0.2/analyticsservice/bulk");
                    List<NameValuePair> nameValuePairs = new ArrayList<>();
                    nameValuePairs.add(new BasicNameValuePair("json", bulk.toString()));
                    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    httpresponse = client.execute(post);
                    HttpEntity httpentity = httpresponse.getEntity();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    httpentity.writeTo(out);
                    String r = out.toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (httpresponse != null && httpresponse.getStatusLine().getStatusCode() == 200) {
                    for (String remove : arrayList) {
                        String[] values2 = remove.split("====");
                        if (values2.length == 2) {
                            C1271DB.remove("request", "function=? AND parameters=?", new String[]{values2[0], values2[1]});
                        }
                    }
                }
            }
        }
    }
}
