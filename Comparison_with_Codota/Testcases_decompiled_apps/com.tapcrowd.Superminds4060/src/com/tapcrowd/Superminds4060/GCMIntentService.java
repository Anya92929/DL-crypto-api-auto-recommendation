package com.tapcrowd.Superminds4060;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.app.Splash;
import com.tapcrowd.app.modules.notifications.NotificationsFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.Notifications;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.tcanalytics.TcaGCMIntentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class GCMIntentService extends GCMBaseIntentService {
    /* access modifiers changed from: private */
    public Timer registerTimer = new Timer("PushRegister");

    public GCMIntentService() {
        super("1093850849822");
        Log.v("GCMIntentService", "constructor");
    }

    public GCMIntentService(String senderId) {
        super(senderId);
        Log.v("GCMIntentService", "constructor");
    }

    /* access modifiers changed from: protected */
    public void onError(Context arg0, String regId) {
    }

    /* access modifiers changed from: protected */
    public void onMessage(final Context context, Intent intent) {
        if (intent.hasExtra("message") && !TcaGCMIntentService.onMessage(context, intent, context.getString(C0846R.string.app_name), C0846R.drawable.notification_ics)) {
            String message = intent.getStringExtra("message");
            Intent notiintent = new Intent(context, Splash.class);
            notiintent.putExtra("notification", message);
            if (intent.hasExtra("payload")) {
                try {
                    JSONObject json = new JSONObject(intent.getStringExtra("payload"));
                    if (json.getString("action").equals("linktomodule")) {
                        notiintent.putExtra("linktomodule", json.getString("path"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            C1199DB.openDataBase(context);
            new Thread(new Runnable() {
                public void run() {
                    NotificationsFragment.sync(context);
                }
            }).start();
            if (getForegroundApp(context)) {
                notiintent.addFlags(268435456);
                context.startActivity(notiintent);
                return;
            }
            Notifications.createNotification(context, notiintent, new StringBuilder().append((int) (Math.random() * 1.0E7d)).toString(), context.getString(C0846R.string.app_name), message, C0846R.drawable.notification_ics, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onRegistered(final Context context, final String regId) {
        new Thread(new Runnable() {
            public void run() {
                List<NameValuePair> nvp = new ArrayList<>();
                nvp.add(new BasicNameValuePair("key", Converter.md5("tcadm" + App.f2123id)));
                nvp.add(new BasicNameValuePair("phoneid", regId));
                nvp.add(new BasicNameValuePair("appid", App.f2123id));
                nvp.add(new BasicNameValuePair("environment", "live"));
                nvp.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
                if (!Internet.request("activatePushAndroid", nvp).equalsIgnoreCase("ok")) {
                    GCMIntentService.this.registerTimer.cancel();
                    GCMIntentService.this.registerTimer = new Timer("PushRegister");
                    GCMIntentService.this.registerTimer.scheduleAtFixedRate(new RegisterTask(context, regId), 60000, 60000);
                }
                TcaGCMIntentService.onRegistered(context, regId, C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get("bundle", context.getPackageName()), "live");
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(Context arg0, String regId) {
    }

    private class RegisterTask extends TimerTask {
        static final int PERIOD = 60000;
        Context context;
        String regId;

        public RegisterTask(Context context2, String regId2) {
            this.context = context2;
            this.regId = regId2;
        }

        public void run() {
            List<NameValuePair> nvp = new ArrayList<>();
            nvp.add(new BasicNameValuePair("key", Converter.md5("tcadm" + App.f2123id)));
            nvp.add(new BasicNameValuePair("phoneid", this.regId));
            nvp.add(new BasicNameValuePair("appid", App.f2123id));
            nvp.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
            if (Internet.request("activatePushAndroid", nvp, this.context).equalsIgnoreCase("ok")) {
                GCMIntentService.this.registerTimer.cancel();
            }
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
}
