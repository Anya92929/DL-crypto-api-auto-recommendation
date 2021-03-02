package com.tapcrowd.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.google.android.gcm.GCMConstants;
import com.google.android.gcm.GCMRegistrar;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.Login;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.modules.wizard.WizardActivity;
import com.tapcrowd.app.service.UpdateService;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Check;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Splash extends SherlockActivity {
    Thread delay = new Thread() {
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            App.act.runOnUiThread(new Runnable() {
                public void run() {
                    Splash.this.startNextActivity();
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Intent i = null;
            try {
                TCObject app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
                TCAnalytics.startSession(Splash.this, app.get("bundle", Splash.this.getPackageName()));
                if (app != null && app.has("apptypeid")) {
                    if (C1199DB.getSize("launchers", "moduletypeid", "76") <= 0 || !Splash.this.getSharedPreferences("first", 0).getBoolean("first", true)) {
                        i = new Intent(Splash.this, TCLauncher.class);
                    } else {
                        i = new Intent(Splash.this, WizardActivity.class);
                    }
                    App.typeid = app.get("apptypeid");
                    if (App.typeid.equals("3") && C1199DB.getSize("events", "appid", App.f2123id) == 1) {
                        App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                        i.putExtra("eventid", App.curEventId);
                    } else if (App.typeid.equals("4") && C1199DB.getSize("venues") == 1) {
                        i.putExtra("venueid", C1199DB.getObject("venues", "appid", App.f2123id).get(DBFavorites.KEY_EVENT_ID));
                    } else if (App.typeid.equals("5")) {
                        i.putExtra("appid", App.f2123id);
                    } else if (App.typeid.equals("8")) {
                        i.putExtra("venueid", C1199DB.getObject("venues", "appid", App.f2123id).get(DBFavorites.KEY_EVENT_ID));
                    } else if (App.typeid.equals("10")) {
                        App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                        i.putExtra("eventid", App.curEventId);
                    }
                }
                if (i != null) {
                    if (Splash.this.getIntent().hasExtra("notification") && !Splash.this.getIntent().hasExtra("linktomodule")) {
                        TCLauncher.message = Splash.this.getIntent().getStringExtra("notification");
                    }
                    if (Splash.this.getIntent().hasExtra("linktomodule")) {
                        TCLauncher.linktomodule = Splash.this.getIntent().getStringExtra("linktomodule");
                    }
                    Splash.this.startActivity(i);
                    Splash.this.finish();
                    return;
                }
                AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
                alertbox.setMessage(Splash.this.getString(C0846R.string.somethingwrong));
                alertbox.setPositiveButton(Splash.this.getString(C0846R.string.tryagain), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                        App.act.startActivity(new Intent(App.act, Splash.class));
                    }
                });
                alertbox.setNegativeButton(Splash.this.getString(C0846R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                    }
                });
                alertbox.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void onConfigurationChanged(Configuration newConfig) {
        setCorrectSplash();
        super.onConfigurationChanged(newConfig);
    }

    public void setCorrectSplash() {
        ImageView splashimg = (ImageView) findViewById(C0846R.C0847id.splash);
        if (getResources().getConfiguration().orientation == 2) {
            splashimg.setImageResource(C0846R.drawable.splash_landscape);
        } else {
            splashimg.setImageResource(C0846R.drawable.splash);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.splash);
        setCorrectSplash();
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        App.act = this;
        App.tablet = getResources().getBoolean(C0846R.bool.tablet);
        try {
            ((TextView) findViewById(C0846R.C0847id.version)).setText(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            C1232UI.hide(C0846R.C0847id.version);
            e.printStackTrace();
        }
        try {
            GCMRegistrar.checkDevice(this);
            GCMRegistrar.checkManifest(this);
            if (GCMRegistrar.getRegistrationId(this).equals("")) {
                GCMRegistrar.register(this, "1093850849822");
            }
        } catch (Exception e2) {
        }
        C1199DB.openDataBase();
        Configuration c = new Configuration();
        c.locale = new Locale(User.getLanguage(this));
        getResources().updateConfiguration(c, (DisplayMetrics) null);
        if (App.f2123id.equals("")) {
            findViewById(C0846R.C0847id.version).post(new Runnable() {
                public void run() {
                    Splash.this.registerForContextMenu(Splash.this.findViewById(C0846R.C0847id.version));
                    Splash.this.openContextMenu(Splash.this.findViewById(C0846R.C0847id.version));
                }
            });
        } else {
            getData();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        GCMRegistrar.onDestroy(this);
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (App.f2123id.equals("")) {
            menu.setHeaderTitle("Choose your app");
            for (int i = 0; i < App.apps.length; i++) {
                menu.add(0, i, 0, String.valueOf(App.apps[i].replace(":", " (")) + ")");
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (App.f2123id.equals("")) {
            App.f2123id = App.apps[item.getItemId()].split(":")[1];
            new getData().execute(new Void[0]);
        }
        return true;
    }

    private void getData() {
        App.starttime = new Date().getTime();
        C1199DB.openDataBase();
        TCObject app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
        if (app.has("apptypeid")) {
            App.typeid = app.get("apptypeid");
            if (App.typeid.equals("3")) {
                App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID, "");
            } else if (App.typeid.equals("10")) {
                App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID, "");
            }
        }
        boolean checklogin = false;
        boolean stayLogged = getSharedPreferences("usermodule", 0).getBoolean("stayloggedin", false);
        if (C1199DB.getSize("launchers", "moduletypeid", "49") > 0 && C1199DB.getSize("securedmodules") == 0 && !stayLogged) {
            checklogin = true;
        }
        if (checklogin) {
            Intent intent = new Intent(this, Login.class);
            intent.putExtra("homebutton", false);
            startActivity(intent);
            finish();
        } else if (app.has("apptypeid") && !checklogin) {
            if (Check.isConnectedToInternet()) {
                startService(new Intent(this, UpdateService.class));
            } else {
                C1232UI.notify(C0846R.drawable.default_warning, getString(C0846R.string.nointernet), App.defaultnoticolor, true, true);
            }
            this.delay.start();
        } else if (Check.isConnectedToInternet()) {
            startService(new Intent(this, UpdateService.class));
        } else {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
            alertbox.setMessage(getString(C0846R.string.nointernetanddb));
            alertbox.setPositiveButton(getString(C0846R.string.tryagain), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    App.act.finish();
                    App.act.startActivity(new Intent(App.act, Splash.class));
                }
            });
            alertbox.setNegativeButton(getString(C0846R.string.close), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    App.act.finish();
                }
            });
            alertbox.show();
        }
    }

    public class getData extends AsyncTask<Void, Void, Boolean> {
        TCObject app;

        public getData() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            App.starttime = new Date().getTime();
            this.app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
            if (this.app.has("apptypeid")) {
                App.typeid = this.app.get("apptypeid");
                if (App.typeid.equals("3")) {
                    App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID, "");
                } else if (App.typeid.equals("10")) {
                    App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID, "");
                }
            }
            boolean checklogin = true;
            if (C1199DB.getSize("launchers", "moduletypeid", "49") > 0) {
                checklogin = Splash.this.checkLogin();
            }
            return Boolean.valueOf(checklogin);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (this.app.has("apptypeid") && result.booleanValue()) {
                if (Check.isConnectedToInternet()) {
                    Splash.this.startService(new Intent(Splash.this, UpdateService.class));
                } else {
                    C1232UI.notify(C0846R.drawable.default_warning, Splash.this.getString(C0846R.string.nointernet), App.defaultnoticolor, true, true);
                }
                Splash.this.delay.start();
            } else if (!result.booleanValue()) {
                Splash.this.startActivity(new Intent(Splash.this, Login.class));
                Splash.this.finish();
            } else if (Check.isConnectedToInternet()) {
                Splash.this.startService(new Intent(Splash.this, UpdateService.class));
            } else {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
                alertbox.setMessage(Splash.this.getString(C0846R.string.nointernetanddb));
                alertbox.setPositiveButton(Splash.this.getString(C0846R.string.tryagain), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                        App.act.startActivity(new Intent(App.act, Splash.class));
                    }
                });
                alertbox.setNegativeButton(Splash.this.getString(C0846R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                    }
                });
                alertbox.show();
            }
        }
    }

    public void startNextActivity() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    C1216LO.downloadImages();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Splash.this.handler.sendEmptyMessage(0);
            }
        }).start();
    }

    public boolean updateVersion(String device, String db) {
        try {
            String[] versDevice = device.split("\\.");
            String[] versDb = db.split("\\.");
            int len = versDb.length <= versDevice.length ? versDb.length : versDevice.length;
            for (int i = 0; i < len; i++) {
                if (Integer.parseInt(versDb[i]) > Integer.parseInt(versDevice[i])) {
                    return true;
                }
            }
            if (versDb.length > versDevice.length) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkLogin() {
        SharedPreferences pref = getSharedPreferences("usermodule", 0);
        if (!pref.getBoolean("stayloggedin", false)) {
            return true;
        }
        String login = pref.getString("login", "");
        String hash = pref.getString("hash", "");
        String currentTimeStamp = pref.getString("currentTimeStamp", "");
        List<NameValuePair> postparams = new ArrayList<>();
        postparams.add(new BasicNameValuePair("bundle", "com.tapcrowd.Superminds4060"));
        postparams.add(new BasicNameValuePair("login", login));
        try {
            postparams.add(new BasicNameValuePair("timestamp", C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp")));
        } catch (Exception e) {
        }
        postparams.add(new BasicNameValuePair("hash", hash));
        postparams.add(new BasicNameValuePair("appid", App.f2123id));
        postparams.add(new BasicNameValuePair("currenttimestamp", currentTimeStamp));
        String response = Internet.request("checkLogin", postparams);
        if (response != null && response.contains("NOT OK")) {
            return false;
        }
        return true;
    }
}
