package com.tapcrowd.tcanalytics;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.p000v4.app.NotificationCompat;
import com.tapcrowd.tcanalytics.actions.ActionActivity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.cordova.Globalization;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class TcaGCMIntentService {
    /* access modifiers changed from: private */
    public static Timer timer;

    public static boolean onMessage(Context context, Intent intent, String appname, int icon) {
        if (!intent.hasExtra("message") || !intent.hasExtra("payload")) {
            return false;
        }
        String payload = intent.getStringExtra("payload");
        try {
            if (!new JSONObject(payload).getString("action").equals("webview")) {
                return false;
            }
            Intent resultIntent = new Intent(context, ActionActivity.class);
            resultIntent.putExtra("payload", payload);
            resultIntent.addFlags(268435456);
            if (getForegroundApp(context)) {
                context.startActivity(resultIntent);
            } else {
                NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context).setSmallIcon(icon).setContentTitle(appname).setContentText(intent.getStringExtra("message")).setContentIntent(PendingIntent.getActivity(context, 0, resultIntent, 268435456)).setAutoCancel(true);
                long[] jArr = new long[3];
                jArr[0] = 200;
                jArr[2] = 200;
                ((NotificationManager) context.getSystemService("notification")).notify(0, autoCancel.setVibrate(jArr).build());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean getForegroundApp(Context context) {
        List<ActivityManager.RunningAppProcessInfo> l = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo info : l) {
            if (info.processName.equals(packageName)) {
                if (info.importance == 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void onRegistered(Context context, String regId, String TCAnalyticsBundleId) {
        onRegistered(context, regId, TCAnalyticsBundleId, "live");
    }

    public static void onRegistered(Context context, String regId, String TCAnalyticsBundleId, String environment) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new RegisterTask(context, regId, TCAnalyticsBundleId, environment), 0, 60000);
    }

    private static class RegisterTask extends TimerTask {
        static final int PERIOD = 60000;
        private String TCAnalyticsBundleId;
        private Context context;
        private String environment;
        private String regId;

        public RegisterTask(Context context2, String regId2, String TCAnalyticsBundleId2, String environment2) {
            this.context = context2;
            this.regId = regId2;
            this.TCAnalyticsBundleId = TCAnalyticsBundleId2;
            this.environment = environment2;
        }

        public void run() {
            List<NameValuePair> nvp = new ArrayList<>();
            nvp.add(new BasicNameValuePair("bundle", this.TCAnalyticsBundleId));
            nvp.add(new BasicNameValuePair("push", this.regId));
            nvp.add(new BasicNameValuePair(Globalization.TYPE, "android"));
            nvp.add(new BasicNameValuePair("deviceid", TcaGCMIntentService.getDeviceId(this.context)));
            nvp.add(new BasicNameValuePair("environment", this.environment));
            String response = "";
            try {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost("http://analytics.staging.tapcrowd.com/0.2/analyticsservice/registerForPush");
                post.setEntity(new UrlEncodedFormEntity(nvp));
                HttpEntity httpentity = client.execute(post).getEntity();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                httpentity.writeTo(out);
                response = out.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (response.equalsIgnoreCase("ok")) {
                TcaGCMIntentService.timer.cancel();
            }
        }
    }

    /* access modifiers changed from: private */
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
