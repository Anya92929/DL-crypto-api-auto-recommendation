package com.tapcrowd.app.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class User {
    static final SharedPreferences pref = App.act.getSharedPreferences("TapCrowd", 0);

    public static String getLanguage(Context context) {
        String defaultLang = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("defaultlanguage", "");
        String devlang = Locale.getDefault().getLanguage().split("_")[0];
        List<TCObject> tclangs = C1199DB.getListFromDb("languages", "appid", App.f2123id);
        List<String> langs = new ArrayList<>();
        for (TCObject tco : tclangs) {
            langs.add(tco.get("language"));
        }
        String toSet = defaultLang;
        if (langs.contains(devlang) || toSet.equals("")) {
            toSet = devlang;
        }
        if ((getPref("language") == null || !getPref("language").equals(toSet)) && toSet != null && langs.contains(toSet)) {
            TCAnalytics.log(context, "/language", toSet);
        }
        setPref("language", toSet);
        return toSet;
    }

    public static void setPref(String key, String value) {
        SharedPreferences.Editor e = pref.edit();
        e.putString(key, value);
        e.commit();
    }

    public static String getPref(String key) {
        return pref.getString(key, (String) null);
    }

    public static void getUserEmail(Fragment f, Method m) {
        if (pref.getString("email", "").equals("")) {
            new ConfDialog((Context) f.getActivity(), f, m).show();
            return;
        }
        try {
            m.invoke(f, new Object[0]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static void editUserEmail(Fragment f) {
        new ConfDialog((Context) f.getActivity(), f, pref.getString("email", "")).show();
    }

    private static class ConfDialog extends Dialog implements View.OnClickListener {
        Context context;
        EditText email;
        String emailStr;

        /* renamed from: f */
        Fragment f2136f;

        /* renamed from: m */
        Method f2137m;

        /* renamed from: ok */
        Button f2138ok;
        TextView title;

        public ConfDialog(Context context2, Fragment f, Method m) {
            super(context2, C0846R.style.transparentDialogTheme);
            requestWindowFeature(1);
            this.f2136f = f;
            this.f2137m = m;
            this.context = context2;
        }

        public ConfDialog(Context context2, Fragment f, String email2) {
            super(context2, C0846R.style.transparentDialogTheme);
            requestWindowFeature(1);
            this.context = context2;
            this.f2136f = f;
            this.emailStr = email2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View v = getLayoutInflater().inflate(C0846R.layout.confbag_dialog, (ViewGroup) null);
            this.title = (TextView) v.findViewById(C0846R.C0847id.title);
            this.f2138ok = (Button) v.findViewById(C0846R.C0847id.f1990ok);
            this.email = (EditText) v.findViewById(C0846R.C0847id.email);
            if (this.emailStr != null) {
                this.email.setText(this.emailStr);
            }
            v.setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
            this.title.setText(C1199DB.getFirstObject("launchers", "moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).toUpperCase());
            this.title.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            this.title.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            this.f2138ok.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            this.f2138ok.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            this.f2138ok.setOnClickListener(this);
            setContentView(v, new ViewGroup.LayoutParams((((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth() / 5) * (App.tablet ? 3 : 4), -1));
        }

        public void onClick(View v) {
            if (this.email.getText().toString().contains("@")) {
                SharedPreferences.Editor editor = User.pref.edit();
                editor.putString("email", this.email.getText().toString());
                editor.commit();
                C1199DB.getQueryFromDb("UPDATE personal SET synced = 0");
                Internet.synchConferencebag((Handler) null);
                try {
                    if (this.f2137m != null) {
                        this.f2137m.invoke(this.f2136f, new Object[0]);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                dismiss();
                return;
            }
            Toast.makeText(App.act, App.act.getString(C0846R.string.invalidemail), 1).show();
        }
    }

    public static void getUserEmail(final Activity a, final Method m) {
        if (pref.getString("email", "").equals("")) {
            final Dialog dialog = new Dialog(App.act);
            dialog.setContentView(C0846R.layout.dialog_confbag);
            final EditText text = (EditText) dialog.findViewById(C0846R.C0847id.EmailText);
            text.setPadding(20, 20, 20, 20);
            text.setText("");
            text.setInputType(32);
            ((Button) dialog.findViewById(C0846R.C0847id.SubmitBtn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (text.getText().toString().contains("@")) {
                        SharedPreferences.Editor editor = User.pref.edit();
                        editor.putString("email", text.getText().toString());
                        editor.commit();
                        try {
                            m.invoke(a, new Object[0]);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                        dialog.dismiss();
                        return;
                    }
                    Toast.makeText(App.act, App.act.getString(C0846R.string.invalidemail), 1).show();
                }
            });
            dialog.show();
            return;
        }
        try {
            m.invoke(a, new Object[0]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static String getDeviceId() {
        return Settings.Secure.getString(App.act.getContentResolver(), "android_id");
    }
}
