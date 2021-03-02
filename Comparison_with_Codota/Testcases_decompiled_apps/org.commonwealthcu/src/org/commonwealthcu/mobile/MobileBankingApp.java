package org.commonwealthcu.mobile;

import android.app.Application;
import android.content.pm.PackageManager;
import android.support.p003v7.appcompat.C0137R;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public class MobileBankingApp extends Application {

    /* renamed from: a */
    public Timer f677a;

    /* renamed from: b */
    public boolean f678b = false;

    /* renamed from: c */
    private JSONObject f679c;

    /* renamed from: d */
    private String f680d;

    /* renamed from: e */
    private String f681e;

    /* renamed from: f */
    private Map f682f;

    /* renamed from: g */
    private String f683g;

    /* renamed from: h */
    private boolean f684h = false;

    /* renamed from: a */
    public final String mo5460a(String str) {
        String str2;
        if (this.f679c == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput("appsettings.pms")));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                str2 = sb.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                str2 = null;
            } catch (IOException e2) {
                e2.printStackTrace();
                str2 = null;
            }
            if (str2 != null) {
                try {
                    this.f679c = new JSONObject(str2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
        try {
            return this.f679c.getString(str);
        } catch (JSONException e4) {
            return null;
        }
    }

    /* renamed from: a */
    public final void mo5461a(Map map) {
        this.f682f = map;
    }

    /* renamed from: a */
    public final void mo5462a(JSONObject jSONObject) {
        this.f679c = jSONObject;
    }

    /* renamed from: a */
    public final boolean mo5463a() {
        return this.f684h;
    }

    /* renamed from: b */
    public final void mo5464b() {
        try {
            Toast makeText = Toast.makeText(getApplicationContext(), getString(C0137R.string.app_name) + " will automatically log out in 30 seconds.", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public final void mo5465b(String str) {
        this.f680d = str;
    }

    /* renamed from: c */
    public final JSONObject mo5466c() {
        return this.f679c;
    }

    /* renamed from: c */
    public final void mo5467c(String str) {
        this.f681e = str;
    }

    /* renamed from: d */
    public final String mo5468d() {
        return this.f680d;
    }

    /* renamed from: e */
    public final String mo5469e() {
        return this.f681e;
    }

    /* renamed from: f */
    public final Map mo5470f() {
        return this.f682f;
    }

    /* renamed from: g */
    public final String mo5471g() {
        return this.f683g;
    }

    public void onCreate() {
        super.onCreate();
        String userAgentString = new WebView(getApplicationContext()).getSettings().getUserAgentString();
        try {
            userAgentString = userAgentString + " AndVer:" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        this.f683g = userAgentString;
    }
}
