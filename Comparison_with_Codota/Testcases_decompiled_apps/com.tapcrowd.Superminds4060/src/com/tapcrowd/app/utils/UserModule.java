package com.tapcrowd.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.RegisterFragment;
import com.tapcrowd.app.modules.notifications.NotificationsFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import twitter4j.conf.PropertyConfiguration;

public class UserModule {
    /* access modifiers changed from: private */
    public static ArrayList<String> ids = new ArrayList<>();
    /* access modifiers changed from: private */
    public static boolean stayLoggedIn = false;

    public static boolean doLogin(Context context, String launcherid) {
        if (stayLoggedIn) {
            Iterator<String> it = ids.iterator();
            while (it.hasNext()) {
                if (it.next().equals(launcherid)) {
                    return false;
                }
            }
        }
        SharedPreferences pref = context.getSharedPreferences("usermodule", 0);
        if (pref.getBoolean("stayloggedin", false)) {
            for (String id : pref.getString("ids", "").split(";")) {
                if (id.equals(launcherid)) {
                    return false;
                }
            }
        }
        if (C1199DB.getSize("securedmodules", DBFavorites.KEY_EVENT_ID, launcherid) > 0) {
            return true;
        }
        return false;
    }

    public static String getUserId(Context context) {
        return context.getSharedPreferences("usermodule", 0).getString("userid", "null");
    }

    public static void logout(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("usermodule", 0).edit();
        edit.putString("login", (String) null);
        edit.putString(PropertyConfiguration.PASSWORD, (String) null);
        edit.putBoolean("stayloggedin", false);
        edit.commit();
    }

    public static boolean isLoggedIn(Context context) {
        if (context == null) {
            return false;
        }
        if (context.getSharedPreferences("usermodule", 0).getBoolean("stayloggedin", false) || stayLoggedIn) {
            return true;
        }
        return false;
    }

    public static void setPref(Context context, boolean stayLoggedIn2, ArrayList<String> ids2, String userid) {
        SharedPreferences.Editor edit = context.getSharedPreferences("usermodule", 0).edit();
        edit.putBoolean("stayloggedin", stayLoggedIn2);
        String idvalue = "";
        Iterator<String> it = ids2.iterator();
        while (it.hasNext()) {
            idvalue = String.valueOf(idvalue) + it.next() + ";";
        }
        edit.putString("ids", idvalue);
        edit.putString("userid", userid);
        edit.commit();
    }

    public static class LoginDialog extends Dialog implements View.OnClickListener {
        Button btnOk;
        Button btnRegister;
        Fragment caller;
        Context context;
        EditText etLogin;
        EditText etPassword;
        String launcherid;
        String title;
        Fragment toLaunch;

        public LoginDialog(Context context2, Fragment caller2, TCLauncherItem launcheritem) {
            super(context2, C0846R.style.transparentDialogTheme);
            this.launcherid = launcheritem.getId();
            this.toLaunch = launcheritem.getFragment();
            this.title = launcheritem.getText();
            this.context = context2;
            this.caller = caller2;
        }

        public LoginDialog(Context context2, Fragment caller2, String launcherid2, Fragment toLaunch2, String title2) {
            super(context2, C0846R.style.transparentDialogTheme);
            this.launcherid = launcherid2;
            this.toLaunch = toLaunch2;
            this.title = title2;
            this.context = context2;
            this.caller = caller2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (!Check.isConnectedToInternet()) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(this.context);
                alertbox.setPositiveButton(this.context.getString(17039370), (DialogInterface.OnClickListener) null);
                alertbox.setMessage(C0846R.string.internetrequired);
                alertbox.show();
                dismiss();
            }
            View v = getLayoutInflater().inflate(C0846R.layout.layout_user_module, (ViewGroup) null);
            v.setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
            View title2 = v.findViewById(C0846R.C0847id.title);
            TextView titleTxt = (TextView) title2.findViewById(C0846R.C0847id.textview_header_title);
            this.etLogin = (EditText) v.findViewById(C0846R.C0847id.login);
            this.etPassword = (EditText) v.findViewById(C0846R.C0847id.password);
            this.btnOk = (Button) v.findViewById(C0846R.C0847id.f1990ok);
            this.btnRegister = (Button) v.findViewById(C0846R.C0847id.register);
            title2.setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.navbar));
            title2.setVisibility(0);
            titleTxt.setText(this.context.getString(C0846R.string.login).toUpperCase());
            titleTxt.setTextColor(C1216LO.getLo(C1216LO.navigationColor));
            this.btnOk.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            this.btnOk.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            this.btnOk.setOnClickListener(this);
            this.btnRegister.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            this.btnRegister.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            this.btnRegister.setOnClickListener(this);
            setContentView(v, new ViewGroup.LayoutParams((((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth() / 5) * (App.tablet ? 3 : 5), App.tablet ? -2 : ((Activity) this.context).getWindowManager().getDefaultDisplay().getHeight()));
        }

        public void onClick(View view) {
            if (view.getId() == C0846R.C0847id.f1990ok) {
                new LoginTask().execute(new Void[0]);
            } else if (view.getId() == C0846R.C0847id.register) {
                Fragments.add(this.caller, RegisterFragment.newInstance(), this.context.getString(C0846R.string.register));
                dismiss();
            }
        }

        public class LoginTask extends AsyncTask<Void, Void, Integer> {
            ProgressDialog dialog;
            String login;
            String password;
            boolean stayloggedin;

            public LoginTask() {
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                UserModule.ids = new ArrayList();
                this.login = LoginDialog.this.etLogin.getText().toString();
                this.password = LoginDialog.this.etPassword.getText().toString();
                this.dialog = new ProgressDialog(LoginDialog.this.context);
                this.dialog.setMessage(LoginDialog.this.context.getString(C0846R.string.loading));
                this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        LoginTask.this.cancel(true);
                    }
                });
                this.dialog.show();
                super.onPreExecute();
            }

            /* access modifiers changed from: protected */
            public Integer doInBackground(Void... params) {
                try {
                    JSONObject json = new JSONObject(UserModule.getLoginResponse(LoginDialog.this.context, this.login, this.password));
                    if (json.has("settings")) {
                        String userid = null;
                        JSONObject settings = json.getJSONObject("settings");
                        if (settings.has("stayloggedin")) {
                            if (settings.getString("stayloggedin").equals("0")) {
                                UserModule.stayLoggedIn = true;
                            } else {
                                this.stayloggedin = true;
                            }
                        }
                        if (settings.has("userid")) {
                            userid = settings.getString("userid");
                        }
                        if (settings.has("launcherids")) {
                            boolean showNext = false;
                            JSONArray launcherids = settings.getJSONArray("launcherids");
                            int len = launcherids.length();
                            for (int i = 0; i < len; i++) {
                                String id = launcherids.getString(i);
                                UserModule.ids.add(id);
                                if (id.equals(LoginDialog.this.launcherid)) {
                                    showNext = true;
                                }
                            }
                            UserModule.setPref(LoginDialog.this.context, this.stayloggedin, UserModule.ids, userid);
                            if (showNext) {
                                return 0;
                            }
                            return 2;
                        }
                    }
                    return 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    return 3;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer result) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(LoginDialog.this.context);
                alertbox.setPositiveButton(LoginDialog.this.context.getString(17039370), (DialogInterface.OnClickListener) null);
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                if (result.intValue() == 0) {
                    if (App.tablet) {
                        Fragments.clear();
                    }
                    Fragments.add(LoginDialog.this.caller, LoginDialog.this.toLaunch, LoginDialog.this.title);
                    LoginDialog.this.dismiss();
                } else if (result.intValue() == 2) {
                    alertbox.setMessage(C0846R.string.no_access);
                    alertbox.show();
                } else if (result.intValue() == 3) {
                    alertbox.setMessage(C0846R.string.login_failed_internet);
                    alertbox.show();
                } else {
                    alertbox.setMessage(C0846R.string.login_failed);
                    alertbox.show();
                }
                new Thread(new Runnable() {
                    public void run() {
                        NotificationsFragment.sync(LoginDialog.this.context);
                    }
                }).start();
                super.onPostExecute(result);
            }
        }
    }

    public static class LoginUserTask extends AsyncTask<Void, Void, Void> {
        private Context context;
        private String login;
        private String password;

        public LoginUserTask(Context context2, String login2, String password2) {
            this.context = context2;
            this.login = login2;
            this.password = password2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            boolean stayloggedin = false;
            try {
                JSONObject json = new JSONObject(UserModule.getLoginResponse(this.context, this.login, this.password));
                if (!json.has("settings")) {
                    return null;
                }
                String userid = null;
                JSONObject settings = json.getJSONObject("settings");
                if (settings.has("stayloggedin")) {
                    if (settings.getString("stayloggedin").equals("0")) {
                        UserModule.stayLoggedIn = true;
                    } else {
                        stayloggedin = true;
                    }
                }
                if (settings.has("userid")) {
                    userid = settings.getString("userid");
                }
                if (!settings.has("launcherids")) {
                    return null;
                }
                JSONArray launcherids = settings.getJSONArray("launcherids");
                int len = launcherids.length();
                for (int i = 0; i < len; i++) {
                    UserModule.ids.add(launcherids.getString(i));
                }
                UserModule.setPref(this.context, stayloggedin, UserModule.ids, userid);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static String getLoginResponse(Context context, String login, String password) {
        String curtime = String.valueOf((int) (System.currentTimeMillis() / 1000));
        String hash = Converter.md5(String.valueOf(login) + curtime + Converter.md5(String.valueOf(password) + "wvcV23efGead!(va$43") + "wvcV23efGead!(va$43");
        String bundle = context.getPackageName();
        if (bundle.equals("com.tapcrowd.demotabapp")) {
            bundle = "com.tapcrowd.Superminds4060";
        }
        List<NameValuePair> postparams = new ArrayList<>();
        postparams.add(new BasicNameValuePair("appid", App.f2123id));
        postparams.add(new BasicNameValuePair("timestamp", C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp", "")));
        postparams.add(new BasicNameValuePair("currenttimestamp", curtime));
        postparams.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
        postparams.add(new BasicNameValuePair("bundle", bundle));
        postparams.add(new BasicNameValuePair("login", login));
        postparams.add(new BasicNameValuePair("hash", hash));
        return Internet.request("checkLogin", postparams);
    }
}
