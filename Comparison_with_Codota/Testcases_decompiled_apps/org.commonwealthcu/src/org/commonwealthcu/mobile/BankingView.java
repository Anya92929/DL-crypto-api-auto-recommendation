package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.appcompat.C0137R;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import org.commonwealthcu.mobile.p038a.C0581c;
import org.commonwealthcu.mobile.p038a.C0583e;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

public class BankingView extends C0589af implements C0583e {

    /* renamed from: a */
    public WebView f647a;

    /* renamed from: b */
    private boolean f648b = false;

    /* renamed from: c */
    private String f649c;

    /* renamed from: d */
    private String f650d;

    /* renamed from: e */
    private AlertDialog f651e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0619bi f652f;

    /* renamed from: g */
    private FragmentManager f653g;

    /* renamed from: h */
    private C0583e f654h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f655i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f656j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f657k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f658l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f659m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f660n;

    /* renamed from: o */
    private String f661o;

    /* renamed from: p */
    private String f662p;

    /* renamed from: q */
    private double f663q;

    /* renamed from: r */
    private int f664r;

    /* renamed from: s */
    private String f665s;

    /* renamed from: a */
    public static Map m1232a(URI uri) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : uri.getQuery().split("&")) {
            int indexOf = str.indexOf("=");
            linkedHashMap.put(URLDecoder.decode(str.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private void m1233a(String str, int i, String str2) {
        FragmentTransaction beginTransaction = this.f653g.beginTransaction();
        C0643v vVar = new C0643v();
        vVar.f858a = str;
        vVar.f859b = i;
        if (str2 != null) {
            vVar.mo5574c(str2);
        }
        beginTransaction.add(16908305, vVar, "EUA_View");
        beginTransaction.commit();
    }

    /* renamed from: c */
    private static String m1238c(String str) {
        return str.replace("+", "%2B").replace("&", "%26").replace("?", "%3F").replace(" ", "%20");
    }

    /* renamed from: d */
    private HashMap m1241d(String str) {
        HashMap hashMap = new HashMap();
        Map f = ((MobileBankingApp) getApplicationContext()).mo5470f();
        if (f != null) {
            for (Map.Entry entry : f.entrySet()) {
                if (((String) entry.getKey()).equals("membser")) {
                    hashMap.put("member", "453700041");
                } else {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        hashMap.put("action", str);
        return hashMap;
    }

    /* renamed from: a */
    public final void mo5449a() {
        this.f647a.zoomOut();
        this.f664r++;
        if (((double) this.f647a.getScale()) != this.f663q && ((double) this.f647a.getScale()) > 1.6d && this.f664r < 3) {
            new Timer().schedule(new C0632k(this), 500);
        }
    }

    /* renamed from: a */
    public final void mo5450a(String str) {
    }

    /* renamed from: a */
    public final void mo5451a(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getBoolean("IsInputValid")) {
            switch (jSONObject.getInt("LoginValidation")) {
                case 0:
                    this.f648b = true;
                    Intent intent = new Intent(this, VertifiActivity.class);
                    intent.putExtra("DEPOSIT_LIMIT", jSONObject.getDouble("DepositLimit"));
                    startActivityForResult(intent, C0137R.styleable.Theme_switchStyle);
                    break;
                case 1:
                    m1233a(jSONObject.getString("DeniedContents"), 1, "REGISTRATION STATUS");
                    break;
                case 2:
                    m1233a(jSONObject.getString("PendingContents"), 2, "REGISTRATION PENDING");
                    break;
                case 3:
                    m1233a(jSONObject.getString("EUAContents"), 3, (String) null);
                    break;
            }
        }
        this.f652f.mo5546b();
    }

    public void acceptButtonPressed(View view) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("EUA_View");
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.remove(findFragmentByTag);
            beginTransaction.commit();
        }
        String d = ((MobileBankingApp) getApplicationContext()).mo5468d();
        new C0581c(this.f654h, m1241d("useraccept"), (File) null, (File) null).execute(new String[]{d + "/commonfiles/iphone/asppages/vertifi.aspx", this.f665s});
    }

    /* renamed from: b */
    public final void mo5453b() {
        String d = ((MobileBankingApp) getApplicationContext()).mo5468d();
        new C0581c(this.f654h, m1241d("userquery"), (File) null, (File) null).execute(new String[]{d + "/commonfiles/iphone/asppages/vertifi.aspx", this.f665s});
    }

    /* renamed from: b */
    public final void mo5454b(String str) {
    }

    /* renamed from: c */
    public final void mo5455c() {
        this.f647a.removeAllViews();
        CookieManager.getInstance().removeSessionCookie();
        CookieSyncManager.getInstance().sync();
    }

    public void cancelButtonPressed(View view) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("EUA_View");
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.remove(findFragmentByTag);
            beginTransaction.commit();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 106 && i2 == -1) {
            this.f655i = true;
            mo5455c();
            Intent intent2 = new Intent();
            intent2.putExtra("EXIT_MESSAGE", "You have successfully logged off.");
            setResult(-1, intent2);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 && ((double) this.f647a.getScale()) != this.f663q && ((double) this.f647a.getScale()) > 1.6d) {
            this.f664r = 0;
            new Timer().schedule(new C0630i(this), 500);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0137R.layout.webview);
        this.f647a = (WebView) findViewById(C0137R.C0139id.main_webview);
        Bundle extras = getIntent().getExtras();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("There was an error connecting, retry?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new C0628g(this));
        builder.setNegativeButton("Exit", new C0629h(this));
        this.f651e = builder.create();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f653g = supportFragmentManager;
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        C0619bi biVar = new C0619bi();
        beginTransaction.add((int) C0137R.C0139id.webview_pb, (Fragment) biVar);
        this.f652f = biVar;
        beginTransaction.commit();
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getApplicationContext();
        this.f665s = mobileBankingApp.mo5471g();
        this.f647a.getSettings().setJavaScriptEnabled(true);
        this.f647a.addJavascriptInterface(new C0642u(this, this), "HtmlViewer");
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.f647a.setWebChromeClient(new C0634m(this));
        this.f647a.setWebViewClient(new C0638q(this));
        this.f647a.setOnTouchListener(new C0639r(this));
        this.f647a.getSettings().setSupportZoom(true);
        this.f647a.getSettings().setSavePassword(false);
        this.f647a.getSettings().setSaveFormData(false);
        this.f647a.setVerticalScrollBarEnabled(false);
        this.f647a.setHorizontalScrollBarEnabled(false);
        this.f647a.getSettings().setBuiltInZoomControls(true);
        this.f647a.getSettings().setUseWideViewPort(true);
        this.f647a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        this.f647a.getSettings().setLoadWithOverviewMode(true);
        this.f647a.getSettings().setUserAgentString(this.f665s);
        String a = mobileBankingApp.mo5460a("VertifiIntegration");
        if (a != null && a.equalsIgnoreCase("true")) {
            this.f656j = true;
        }
        String a2 = mobileBankingApp.mo5460a("VertifiIntegrationDemoMode");
        if (a2 != null && a2.equalsIgnoreCase("true")) {
            this.f657k = true;
        }
        this.f658l = mobileBankingApp.mo5460a("VertifiIntegrationDemoUsers");
        this.f659m = mobileBankingApp.mo5460a("VertifiAppMissingMessage");
        this.f662p = mobileBankingApp.mo5469e();
        CookieManager instance = CookieManager.getInstance();
        CookieSyncManager.getInstance().sync();
        instance.getCookie(mobileBankingApp.mo5468d());
        if (this.f662p.toLowerCase(Locale.US).contains("mobileweb")) {
            this.f661o = mobileBankingApp.mo5468d();
            this.f647a.loadUrl(extras.getString("EXTRA_URL"));
        } else {
            this.f649c = extras.getString("EXTRA_USERNAME");
            this.f650d = extras.getString("EXTRA_PWORD");
            this.f650d = m1238c(this.f650d);
            this.f649c = m1238c(this.f649c);
            this.f661o = mobileBankingApp.mo5468d();
            this.f647a.postUrl(this.f661o + this.f662p + "/index.asp", C0250b.m100a("username=" + this.f649c + "&password=" + this.f650d + "&PG=THREEWAY", "BASE64"));
        }
        this.f663q = (double) this.f647a.getScale();
        this.f654h = this;
        ((MobileBankingApp) getApplication()).f678b = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("EUA_View");
            if (findFragmentByTag == null || !findFragmentByTag.isVisible()) {
                if (this.f647a.canGoBack()) {
                    WebBackForwardList copyBackForwardList = this.f647a.copyBackForwardList();
                    String replace = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1).getUrl().replace("index.asp", "");
                    String replace2 = this.f647a.getUrl().replace("index.asp", "");
                    String str = this.f661o + this.f662p + "/";
                    if (replace.toLowerCase().contains("#/login") && replace2.toLowerCase().contains("#/login")) {
                        this.f655i = true;
                        mo5455c();
                        finish();
                    } else if ((!replace.toLowerCase().contains("#/login") || replace2.toLowerCase().contains("#/login")) && ((!replace2.equalsIgnoreCase(replace) && !str.equalsIgnoreCase(replace2)) || !replace.toLowerCase().contains("#/login"))) {
                        this.f647a.goBack();
                    }
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Do you want to log out?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new C0640s(this));
                builder.setNegativeButton("Cancel", new C0641t(this));
                this.f651e = builder.create();
                this.f651e.show();
            } else {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                beginTransaction.remove(findFragmentByTag);
                beginTransaction.commit();
            }
        }
        return true;
    }

    public void onPause() {
        super.mo5494a(!this.f648b && !this.f655i);
    }

    public void onResume() {
        super.mo5495b(!this.f648b);
    }
}
