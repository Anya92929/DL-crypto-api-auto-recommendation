package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0137R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.commonwealthcu.mobile.p038a.C0580b;
import org.json.JSONException;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

public class MainActivity extends C0584aa {

    /* renamed from: a */
    private C0644w f666a;

    /* renamed from: b */
    private String f667b;

    /* renamed from: c */
    private String f668c;

    /* renamed from: d */
    private ActionBar.Tab f669d;

    /* renamed from: e */
    private ActionBar.Tab f670e;

    /* renamed from: f */
    private ActionBar.Tab f671f;

    /* renamed from: g */
    private ActionBar.Tab f672g;

    /* renamed from: h */
    private int f673h = 0;

    /* renamed from: i */
    private int f674i = 0;

    /* renamed from: j */
    private boolean f675j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f676k = new C0646y(this);

    /* renamed from: a */
    private void m1251a() {
        String[] fileList = getApplicationContext().fileList();
        for (String fileStreamPath : fileList) {
            new Date(getFileStreamPath(fileStreamPath).lastModified());
        }
    }

    /* renamed from: a */
    private void m1252a(String str, int i) {
        new C0647z(this, str.replace(" ", "%20"), i).start();
    }

    /* renamed from: a */
    static /* synthetic */ void m1253a(MainActivity mainActivity) {
        mainActivity.f674i++;
        if (mainActivity.f673h == mainActivity.f674i) {
            mainActivity.m1257c();
        }
    }

    /* renamed from: b */
    private void m1255b() {
        boolean z;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        ActionBar supportActionBar = getSupportActionBar();
        View view = (View) supportActionBar.getTabAt(0).getCustomView().getParent();
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        int tabCount = supportActionBar.getTabCount();
        int i2 = 0;
        while (true) {
            if (i2 >= tabCount) {
                z = false;
                break;
            } else if (((TextView) supportActionBar.getTabAt(i2).getCustomView().findViewById(C0137R.C0139id.tab_title)).getText().length() > 11) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < tabCount; i3++) {
            TextView textView = (TextView) supportActionBar.getTabAt(i3).getCustomView().findViewById(C0137R.C0139id.tab_title);
            textView.setMaxWidth(((i / tabCount) - paddingLeft) - 1);
            if (z) {
                textView.setTextSize(7.5f);
                textView.setGravity(17);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static InputStream m1256c(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m1257c() {
        int i;
        boolean z;
        int parseColor;
        boolean z2 = true;
        int i2 = 0;
        setContentView((int) C0137R.layout.activity_main);
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplicationContext();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setNavigationMode(2);
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setDisplayUseLogoEnabled(false);
        supportActionBar.setDisplayShowHomeEnabled(false);
        String a = mobileBankingApp.mo5460a("TabBarColor");
        String a2 = mobileBankingApp.mo5460a("TabBarTextColor");
        String a3 = mobileBankingApp.mo5460a("TabBarImageUnselectedColor");
        try {
            i = Color.parseColor(a2);
            z = true;
        } catch (Exception e) {
            i = 0;
            z = false;
        }
        try {
            parseColor = Color.parseColor(a3);
        } catch (Exception e2) {
            parseColor = Color.parseColor("#777777");
        }
        try {
            i2 = Color.parseColor(a);
        } catch (Exception e3) {
            z2 = false;
        }
        Drawable drawable = getResources().getDrawable(C0137R.C0138drawable.indicator_hidden);
        if (z2) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        } else {
            drawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        }
        supportActionBar.setBackgroundDrawable(drawable);
        supportActionBar.setStackedBackgroundDrawable(drawable);
        String a4 = mobileBankingApp.mo5460a("LoginBarItemLabel") != null ? mobileBankingApp.mo5460a("LoginBarItemLabel") : getString(C0137R.string.tab_login);
        String a5 = mobileBankingApp.mo5460a("LoginBarItemImage");
        this.f669d = supportActionBar.newTab().setTabListener(new C0594ak(this, "tab_login", C0644w.class));
        this.f669d.setCustomView((int) C0137R.layout.custom_tab);
        ImageView imageView = (ImageView) this.f669d.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (a5 != null && a5.contains("#customhd_")) {
            imageView.setImageDrawable(Drawable.createFromPath(new File(getFilesDir(), a5.replace("#customhd_", "").replace(".", "@2x.")).getAbsolutePath()));
        } else if (a5 != null) {
            imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(a5.replace(".png", ""), "drawable", getPackageName())));
        } else {
            imageView.setImageResource(C0137R.C0138drawable.login);
        }
        TextView textView = (TextView) this.f669d.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView.setText(a4);
        textView.setTypeface(C0250b.m81a(getApplicationContext()));
        if (z) {
            textView.setTextColor(i);
        }
        imageView.setColorFilter(parseColor);
        supportActionBar.addTab(this.f669d);
        String a6 = mobileBankingApp.mo5460a("LocationImage");
        if (mobileBankingApp.mo5460a("LocationURL") != null) {
            String a7 = mobileBankingApp.mo5460a("LocationLabel") != null ? mobileBankingApp.mo5460a("LocationLabel") : getString(C0137R.string.tab_location);
            this.f670e = supportActionBar.newTab().setTabListener(new C0594ak(this, "tab_location", C0620bj.class));
            this.f670e.setCustomView((int) C0137R.layout.custom_tab);
            ImageView imageView2 = (ImageView) this.f670e.getCustomView().findViewById(C0137R.C0139id.tab_icon);
            if (a6 != null && a6.contains("#customhd_")) {
                imageView2.setImageDrawable(Drawable.createFromPath(new File(getFilesDir(), a6.replace("#customhd_", "").replace(".", "@2x.")).getAbsolutePath()));
            } else if (a6 != null) {
                imageView2.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(a6.replace(".png", ""), "drawable", getPackageName())));
            } else {
                imageView2.setImageResource(C0137R.C0138drawable.location);
            }
            TextView textView2 = (TextView) this.f670e.getCustomView().findViewById(C0137R.C0139id.tab_title);
            textView2.setText(a7);
            textView2.setTypeface(C0250b.m81a(getApplicationContext()));
            if (z) {
                textView2.setTextColor(i);
            }
            imageView2.setColorFilter(parseColor);
            supportActionBar.addTab(this.f670e);
        }
        if (mobileBankingApp.mo5460a("SuppressAds") == null) {
            String a8 = mobileBankingApp.mo5460a("AdsImage");
            String a9 = mobileBankingApp.mo5460a("AdsLabel") != null ? mobileBankingApp.mo5460a("AdsLabel") : getString(C0137R.string.tab_ads);
            this.f671f = supportActionBar.newTab().setTabListener(new C0594ak(this, "tab_ads", C0578a.class));
            this.f671f.setCustomView((int) C0137R.layout.custom_tab);
            ImageView imageView3 = (ImageView) this.f671f.getCustomView().findViewById(C0137R.C0139id.tab_icon);
            if (a8 != null && a8.contains("#customhd")) {
                imageView3.setImageDrawable(Drawable.createFromPath(new File(getFilesDir(), a8.replace("#customhd_", "").replace(".", "@2x.")).getAbsolutePath()));
            } else if (a8 != null) {
                imageView3.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(a8.replace(".png", ""), "drawable", getPackageName())));
            } else {
                imageView3.setImageResource(C0137R.C0138drawable.transfer);
            }
            TextView textView3 = (TextView) this.f671f.getCustomView().findViewById(C0137R.C0139id.tab_title);
            textView3.setText(a9);
            textView3.setTypeface(C0250b.m81a(getApplicationContext()));
            if (z) {
                textView3.setTextColor(i);
            }
            imageView3.setColorFilter(parseColor);
            supportActionBar.addTab(this.f671f);
        }
        String a10 = mobileBankingApp.mo5460a("MoreLabel") != null ? mobileBankingApp.mo5460a("MoreLabel") : getString(C0137R.string.tab_more);
        String a11 = mobileBankingApp.mo5460a("MoreImage");
        this.f672g = supportActionBar.newTab().setTabListener(new C0594ak(this, "tab_more", C0596am.class));
        this.f672g.setCustomView((int) C0137R.layout.custom_tab);
        ImageView imageView4 = (ImageView) this.f672g.getCustomView().findViewById(C0137R.C0139id.tab_icon);
        if (a11 != null && a11.contains("#customhd_")) {
            imageView4.setImageDrawable(Drawable.createFromPath(new File(getFilesDir(), a11.replace("#customhd_", "").replace(".", "@2x.")).getAbsolutePath()));
        } else if (a11 != null) {
            imageView4.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(a11.replace(".png", ""), "drawable", getPackageName())));
        } else {
            imageView4.setImageResource(C0137R.C0138drawable.more);
        }
        TextView textView4 = (TextView) this.f672g.getCustomView().findViewById(C0137R.C0139id.tab_title);
        textView4.setText(a10);
        textView4.setTypeface(C0250b.m81a(getApplicationContext()));
        if (z) {
            textView4.setTextColor(i);
        }
        imageView4.setColorFilter(parseColor);
        supportActionBar.addTab(this.f672g);
        m1255b();
        String a12 = mobileBankingApp.mo5460a("DefaultView");
        if (a12 != null) {
            if (a12.equalsIgnoreCase("loginview") && this.f669d != null) {
                supportActionBar.setSelectedNavigationItem(this.f669d.getPosition());
            } else if (a12.equalsIgnoreCase("moreview") && this.f672g != null) {
                supportActionBar.setSelectedNavigationItem(this.f672g.getPosition());
            } else if (a12.equalsIgnoreCase("findatmview") && this.f670e != null) {
                supportActionBar.setSelectedNavigationItem(this.f670e.getPosition());
            } else if (this.f671f != null) {
                supportActionBar.setSelectedNavigationItem(this.f671f.getPosition());
            }
        } else if (this.f671f != null) {
            supportActionBar.setSelectedNavigationItem(this.f671f.getPosition());
        }
    }

    /* renamed from: a */
    public final void mo5457a(String str) {
        if (str == null) {
            new AlertDialog.Builder(this).setTitle("Connection Error").setMessage("No connection to the Internet was detected. This App requires an Internet Connection.").setPositiveButton(17039370, new C0645x(this)).setCancelable(false).create().show();
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("appsettings.pms", 0));
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplicationContext();
        mobileBankingApp.mo5467c(this.f668c);
        mobileBankingApp.mo5465b(this.f667b);
        mobileBankingApp.mo5462a(jSONObject);
        Log.d("MA", "UsingDemoDir? " + this.f675j + " Directory: " + mobileBankingApp.mo5460a("MainDirectory"));
        if (mobileBankingApp.mo5460a("MainDirectory") != null && !this.f675j) {
            mobileBankingApp.mo5467c(mobileBankingApp.mo5460a("MainDirectory"));
            this.f668c = mobileBankingApp.mo5460a("MainDirectory");
        } else if (mobileBankingApp.mo5460a("DemoDirectory") != null && this.f675j) {
            mobileBankingApp.mo5467c(mobileBankingApp.mo5460a("DemoDirectory"));
            this.f668c = mobileBankingApp.mo5460a("DemoDirectory");
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.indexOf("IMG") >= 0 && next.length() <= 5) {
                m1252a(mobileBankingApp.mo5468d() + "/resources/MobileMarketing/" + jSONObject.getString(next), 1);
                this.f673h++;
            }
            if (next.indexOf("Image") >= 0) {
                String string = jSONObject.getString(next);
                if (string.indexOf("#customhd") >= 0) {
                    String substring = string.substring(string.indexOf("_") + 1);
                    m1252a(mobileBankingApp.mo5468d() + "/resources/mobile/" + (substring.substring(0, substring.indexOf(".")) + "@2x" + substring.substring(substring.indexOf("."))), 2);
                    this.f673h++;
                }
            }
        }
        m1251a();
        if (this.f673h == 0) {
            m1257c();
        }
    }

    /* renamed from: b */
    public final void mo5458b(String str) {
        try {
            if (this.f666a != null) {
                this.f666a.mo5577c();
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getString("errorMessage") != "null") {
                Log.d("MainActivity", "Login Error");
                new AlertDialog.Builder(this).setTitle("Login Error").setMessage(jSONObject.getString("errorMessage")).setPositiveButton("OK", (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                return;
            }
            Log.d("MainActivity", "Going to next page");
            Intent intent = new Intent(this, BankingView.class);
            intent.putExtra("EXTRA_URL", this.f667b + this.f668c + "/index.asp#/login/nextPage");
            startActivityForResult(intent, C0137R.styleable.Theme_spinnerStyle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loginButtonClicked(View view) {
        this.f666a = (C0644w) getSupportFragmentManager().findFragmentByTag("tab_login");
        this.f666a.mo5576b();
        this.f666a.mo5575a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 105 && i2 == -1) {
            String stringExtra = intent.getStringExtra("EXIT_MESSAGE");
            intent.removeExtra("EXIT_MESSAGE");
            new AlertDialog.Builder(this).setTitle("Log Off Message").setMessage(stringExtra).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
            ((MobileBankingApp) getApplication()).f678b = false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0137R.layout.splashview);
        if (getString(C0137R.string.demo_url).length() <= 0 || getString(C0137R.string.goLiveDate).length() < 8) {
            this.f667b = getString(C0137R.string.main_url);
            this.f668c = getString(C0137R.string.main_directory);
            this.f675j = false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            try {
                date = simpleDateFormat.parse(getString(C0137R.string.goLiveDate));
            } catch (ParseException e) {
            }
            if (date.after(new Date())) {
                this.f667b = getString(C0137R.string.demo_url);
                this.f668c = getString(C0137R.string.demo_directory);
                this.f675j = true;
            } else {
                this.f667b = getString(C0137R.string.main_url);
                this.f668c = getString(C0137R.string.main_directory);
                this.f675j = false;
            }
        }
        new C0580b(this).execute(new String[]{this.f667b + "/commonfiles/iphone/mobilesettings.asp"});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 4
            if (r4 != r0) goto L_0x0027
            int r0 = r5.getRepeatCount()
            if (r0 != 0) goto L_0x0027
            android.support.v4.app.FragmentManager r0 = r3.getSupportFragmentManager()
            java.lang.String r1 = "Ad_Browser"
            android.support.v4.app.Fragment r1 = r0.findFragmentByTag(r1)
            if (r1 == 0) goto L_0x0027
            boolean r2 = r1.isVisible()
            if (r2 == 0) goto L_0x0027
            android.support.v4.app.FragmentTransaction r0 = r0.beginTransaction()
            r0.remove(r1)
            r0.commit()
            r0 = 1
        L_0x0026:
            return r0
        L_0x0027:
            boolean r0 = super.onKeyDown(r4, r5)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonwealthcu.mobile.MainActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }
}
