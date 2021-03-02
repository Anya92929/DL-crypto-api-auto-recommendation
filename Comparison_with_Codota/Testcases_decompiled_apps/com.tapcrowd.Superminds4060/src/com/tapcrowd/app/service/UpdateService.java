package com.tapcrowd.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.location.LocationRequest;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.Splash;
import com.tapcrowd.app.TCApplication;
import com.tapcrowd.app.modules.launcher.Login;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.User;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import twitter4j.conf.PropertyConfiguration;

public class UpdateService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        C1232UI.notify(getString(C0846R.string.noti_updating), Color.argb(170, 34, 34, 34));
        new DownloadTask(this, (DownloadTask) null).execute(new Void[0]);
        return 1;
    }

    private class DownloadTask extends AsyncTask<Void, Void, Integer> {
        private DownloadTask() {
        }

        /* synthetic */ DownloadTask(UpdateService updateService, DownloadTask downloadTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... params) {
            try {
                C1199DB.openDataBase();
                SharedPreferences pref = UpdateService.this.getSharedPreferences("usermodule", 0);
                boolean stayLogged = pref.getBoolean("stayloggedin", false);
                String language = User.getLanguage(UpdateService.this);
                boolean setTimeStamp = true;
                if (User.getPref("lastLang") != null && !User.getPref("lastLang").equals(language)) {
                    setTimeStamp = false;
                }
                User.setPref("lastLang", language);
                String curtime = String.valueOf((int) (System.currentTimeMillis() / 1000));
                List<NameValuePair> postparams = new ArrayList<>();
                postparams.add(new BasicNameValuePair("appid", App.f2123id));
                if (setTimeStamp) {
                    try {
                        postparams.add(new BasicNameValuePair("timestamp", C1199DB.getQueryFromDb("SELECT MAX(t) AS max FROM (SELECT MAX(timestamp) AS t FROM app UNION SELECT MAX(timestamp) AS t FROM events UNION SELECT MAX(timestamp) AS t FROM venues)").get(0).get("max")));
                    } catch (Exception e) {
                    }
                }
                postparams.add(new BasicNameValuePair("devicetype", "android__" + Build.MANUFACTURER + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Build.MODEL + "__" + Build.VERSION.RELEASE));
                postparams.add(new BasicNameValuePair("lang", language));
                postparams.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
                postparams.add(new BasicNameValuePair("currenttimestamp", curtime));
                postparams.add(new BasicNameValuePair("bundleid", "com.tapcrowd.Superminds4060"));
                if (stayLogged) {
                    String login = pref.getString("login", "");
                    String hash = Converter.md5(String.valueOf(login) + curtime + Converter.md5(String.valueOf(pref.getString(PropertyConfiguration.PASSWORD, "")) + "wvcV23efGead!(va$43") + "wvcV23efGead!(va$43");
                    postparams.add(new BasicNameValuePair("login", login));
                    postparams.add(new BasicNameValuePair("hash", hash));
                }
                InputStream json = Internet.getApp(postparams);
                if (json == null) {
                    return 0;
                }
                C1199DB.createTables();
                C1199DB.Response resp = C1199DB.jsonToDB(json, (String) null);
                if (resp == C1199DB.Response.Login) {
                    return 2;
                }
                if (resp == C1199DB.Response.Pincode) {
                    return 3;
                }
                User.getLanguage(UpdateService.this);
                TCApplication.updatelanguage(UpdateService.this.getBaseContext());
                try {
                    C1216LO.downloadImages();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 1;
            } catch (Exception e3) {
                e3.printStackTrace();
                return -1;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer r) {
            C1232UI.hideNotification(false);
            if (r.intValue() == 1) {
                C1232UI.notify(C0846R.drawable.default_warning, UpdateService.this.getString(C0846R.string.noti_updated), Color.argb(170, 34, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, 34), true, false);
            }
            if (r.intValue() == 0) {
                C1232UI.notify(17301642, UpdateService.this.getString(C0846R.string.noti_server), Color.argb(170, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, 34, 34), true, false);
            }
            if (r.intValue() == -1) {
                C1232UI.notify(17301642, UpdateService.this.getString(C0846R.string.noti_error), Color.argb(170, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, 34, 34), true, false);
            }
            if (r.intValue() != 2 && r.intValue() != 3) {
                try {
                    if (App.act != null && App.act.getClass() == Splash.class) {
                        Log.d("UPDATE_SERVICE", "START NEXT");
                        ((Splash) App.act).startNextActivity();
                    }
                } catch (Exception e) {
                }
            } else if (App.act != null) {
                Intent intent = new Intent(App.act, Login.class);
                intent.putExtra("homebutton", false);
                if (r.intValue() == 3) {
                    intent.putExtra("isPincode", true);
                }
                App.act.startActivity(intent);
                App.act.finish();
            }
            UpdateService.this.stopSelf();
        }
    }

    public static class GetAppTask extends AsyncTask<Void, Void, Void> {
        private Context context;

        public GetAppTask(Context context2) {
            this.context = context2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                C1199DB.openDataBase();
                SharedPreferences pref = this.context.getSharedPreferences("usermodule", 0);
                boolean stayLogged = pref.getBoolean("stayloggedin", false);
                List<NameValuePair> postparams = new ArrayList<>();
                postparams.add(new BasicNameValuePair("appid", App.f2123id));
                try {
                    postparams.add(new BasicNameValuePair("timestamp", C1199DB.getQueryFromDb("SELECT MAX(t) AS max FROM (SELECT MAX(timestamp) AS t FROM app UNION SELECT MAX(timestamp) AS t FROM events UNION SELECT MAX(timestamp) AS t FROM venues)").get(0).get("max")));
                } catch (Exception e) {
                }
                postparams.add(new BasicNameValuePair("devicetype", "android__" + Build.MANUFACTURER + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Build.MODEL + "__" + Build.VERSION.RELEASE));
                postparams.add(new BasicNameValuePair("lang", User.getLanguage(this.context)));
                postparams.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
                postparams.add(new BasicNameValuePair("currenttimestamp", pref.getString("currentTimeStamp", String.valueOf((int) (System.currentTimeMillis() / 1000)))));
                postparams.add(new BasicNameValuePair("bundleid", "com.tapcrowd.Superminds4060"));
                if (stayLogged) {
                    String login = pref.getString("login", "");
                    String hash = pref.getString("hash", "");
                    postparams.add(new BasicNameValuePair("login", login));
                    postparams.add(new BasicNameValuePair("hash", hash));
                }
                InputStream json = Internet.getApp(postparams);
                if (json != null) {
                    C1199DB.jsonToDB(json, (String) null);
                }
            } catch (Exception e2) {
            }
            return null;
        }
    }
}
