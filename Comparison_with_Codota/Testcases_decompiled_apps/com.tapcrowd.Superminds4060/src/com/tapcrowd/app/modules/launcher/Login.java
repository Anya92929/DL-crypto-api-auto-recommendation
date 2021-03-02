package com.tapcrowd.app.modules.launcher;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.actionbarsherlock.app.ActionBar;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCActivity;
import com.tapcrowd.app.TCApplication;
import com.tapcrowd.app.modules.Register;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.wizard.WizardActivity;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import twitter4j.conf.PropertyConfiguration;

public class Login extends TCActivity {
    public static final int REGISTER = 634;
    ViewGroup container;
    HashMap<String, EditText> fields = new HashMap<>();
    String login;
    String password;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.conference_bag_layout);
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
        if (color.length() == 8) {
            color = color.substring(2);
        }
        ab.setDisplayShowTitleEnabled(true);
        ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + getString(C0846R.string.app_name).toUpperCase() + "</font>"));
        if (C1216LO.getLoDrawable(C1216LO.navbar) != null) {
            ab.setBackgroundDrawable(new BitmapDrawable(getResources(), ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbar)).getBitmap()));
        } else {
            ab.setBackgroundDrawable(new ColorDrawable(C1216LO.getLo(C1216LO.titleBackgroundColor)));
        }
        this.container = (ViewGroup) findViewById(C0846R.C0847id.container);
        findViewById(C0846R.C0847id.logincontainer).setVisibility(8);
        if (getIntent().getBooleanExtra("isPincode", false)) {
            addTextField("RIZIV / BIG", "pincode", 3);
        } else {
            addTextField("Name", DBFavorites.KEY_NAME, 1);
            addTextField("Password", PropertyConfiguration.PASSWORD, 129);
        }
        Button submitbutton = (Button) findViewById(C0846R.C0847id.submit);
        submitbutton.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        submitbutton.setText("Submit".toUpperCase());
        submitbutton.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        Button registerbutton = (Button) findViewById(C0846R.C0847id.register);
        registerbutton.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        registerbutton.setText("Register".toUpperCase());
        registerbutton.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
    }

    public void addTextField(String hint, String name, int inputtype) {
        FormEditText fet = new FormEditText(this, hint);
        fet.setInputType(inputtype);
        this.container.addView(fet);
        this.fields.put(name, fet);
    }

    public void submit(View v) {
        if (getIntent().getBooleanExtra("isPincode", false)) {
            this.login = this.fields.get("pincode").getText().toString();
            this.password = this.fields.get("pincode").getText().toString();
        } else {
            this.login = this.fields.get(DBFavorites.KEY_NAME).getText().toString();
            this.password = this.fields.get(PropertyConfiguration.PASSWORD).getText().toString();
        }
        String curtime = String.valueOf((int) (System.currentTimeMillis() / 1000));
        String hash = Converter.md5(String.valueOf(this.login) + curtime + Converter.md5(String.valueOf(this.password) + "wvcV23efGead!(va$43") + "wvcV23efGead!(va$43");
        String bundle = getPackageName();
        List<NameValuePair> postparams = new ArrayList<>();
        postparams.add(new BasicNameValuePair("appid", App.f2123id));
        postparams.add(new BasicNameValuePair("timestamp", C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp", "")));
        postparams.add(new BasicNameValuePair("currenttimestamp", curtime));
        postparams.add(new BasicNameValuePair("devicetype", "android__" + Build.MANUFACTURER + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Build.MODEL + "__" + Build.VERSION.RELEASE));
        postparams.add(new BasicNameValuePair("lang", User.getLanguage(this)));
        postparams.add(new BasicNameValuePair("deviceid", User.getDeviceId()));
        postparams.add(new BasicNameValuePair("bundleid", bundle));
        postparams.add(new BasicNameValuePair("login", this.login));
        postparams.add(new BasicNameValuePair("hash", hash));
        new DownloadTask(postparams).execute(new Void[0]);
        new LoginTask(postparams).execute(new Void[0]);
    }

    public void register(View v) {
        startActivityForResult(new Intent(this, Register.class), REGISTER);
    }

    private class DownloadTask extends AsyncTask<Void, Void, Boolean> {
        ProgressDialog dialog;
        List<NameValuePair> postparams;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(Login.this);
            this.dialog.setMessage(Login.this.getString(C0846R.string.loading));
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        public DownloadTask(List<NameValuePair> postparams2) {
            this.postparams = postparams2;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            boolean result = true;
            try {
                C1199DB.openDataBase();
                String json = Internet.request("getApp", this.postparams);
                try {
                    if (new JSONObject(json).getJSONObject("checklogin").getJSONObject("settings").getString("stayloggedin").equals("1")) {
                        Login.this.stayLoggedIn(Login.this.getBaseContext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (json.length() > 0) {
                    C1199DB.createTables();
                    result = C1199DB.jsonToDB(json, (String) null);
                    User.getLanguage(Login.this);
                    TCApplication.updatelanguage(Login.this.getBaseContext());
                    try {
                        C1216LO.downloadImages();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return Boolean.valueOf(result);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (result.booleanValue()) {
                Login.this.stayLoggedIn(Login.this.getBaseContext());
                Intent i = null;
                TCObject app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
                if (app != null && app.has("apptypeid")) {
                    if (C1199DB.getSize("launchers", "moduletypeid", "76") <= 0 || !Login.this.getSharedPreferences("first", 0).getBoolean("first", true)) {
                        i = new Intent(Login.this, TCLauncher.class);
                    } else {
                        i = new Intent(Login.this, WizardActivity.class);
                    }
                    App.typeid = app.get("apptypeid");
                    if (App.typeid.equals("3")) {
                        App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                        i.putExtra("eventid", App.curEventId);
                    } else if (App.typeid.equals("5")) {
                        i.putExtra("appid", App.f2123id);
                    } else if (App.typeid.equals("10")) {
                        App.curEventId = C1199DB.getObject("events", "appid == " + App.f2123id + " AND parentid", "0").get(DBFavorites.KEY_EVENT_ID);
                        i.putExtra("eventid", App.curEventId);
                    }
                }
                if (i != null) {
                    Login.this.startActivity(i);
                    Login.this.finish();
                }
            } else {
                new AlertDialog.Builder(Login.this).setMessage("Invalid password!").setPositiveButton("Ok", (DialogInterface.OnClickListener) null).show();
            }
            super.onPostExecute(result);
        }
    }

    /* access modifiers changed from: private */
    public void stayLoggedIn(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("usermodule", 0).edit();
        edit.putString("login", this.login);
        edit.putString(PropertyConfiguration.PASSWORD, this.password);
        edit.putBoolean("stayloggedin", true);
        edit.commit();
    }

    private class FormEditText extends EditText {
        public FormEditText(Context context, String hint) {
            super(context);
            setHint(hint);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, (int) Converter.convertDpToPixel(40.0f, context));
            lp.setMargins(0, 0, 0, (int) Converter.convertDpToPixel(10.0f, Login.this));
            setLayoutParams(lp);
            GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, -1});
            bg.setStroke((int) Converter.convertDpToPixel(2.0f, context), Color.parseColor("#e3e3e3"));
            setBackgroundDrawable(bg);
        }
    }

    public class LoginTask extends AsyncTask<Void, Void, Void> {
        List<NameValuePair> postparams;

        public LoginTask(List<NameValuePair> postparams2) {
            this.postparams = postparams2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                JSONObject json = new JSONObject(Internet.request("checkLogin", this.postparams));
                if (!json.has("settings")) {
                    return null;
                }
                JSONObject settings = json.getJSONObject("settings");
                if (settings.has("userid")) {
                    setPref(Login.this.getBaseContext(), settings.getString("userid"));
                }
                if (!settings.optString("stayloggedin").equals("1")) {
                    return null;
                }
                Login.this.stayLoggedIn(Login.this.getBaseContext());
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private void setPref(Context context, String userid) {
            SharedPreferences.Editor edit = context.getSharedPreferences("usermodule", 0).edit();
            edit.putString("userid", userid);
            edit.commit();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 634 && resultCode == -1) {
            String login2 = data.getStringExtra("login");
            String password2 = data.getStringExtra(PropertyConfiguration.PASSWORD);
            this.fields.get(DBFavorites.KEY_NAME).setText(login2);
            this.fields.get(PropertyConfiguration.PASSWORD).setText(password2);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
