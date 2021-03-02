package com.jackhenry.godough.core;

import android.app.Application;
import android.content.Context;
import com.jackhenry.godough.core.login.C1650av;
import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.p024a.C1373a;
import com.jackhenry.godough.p043d.C1945a;
import com.jackhenry.p021a.C1347a;
import java.net.CookieManager;
import java.util.List;
import javax.crypto.SecretKey;

public class GoDoughApp extends Application {
    public static final int RESULT_FINISH = 2;

    /* renamed from: a */
    private static GoDoughApp f5770a;

    /* renamed from: b */
    private static Settings f5771b;

    /* renamed from: c */
    private static UserSettings f5772c;

    /* renamed from: d */
    private static int f5773d;

    /* renamed from: e */
    private static boolean f5774e;

    /* renamed from: f */
    private static int f5775f = 0;

    /* renamed from: g */
    private static int f5776g;

    /* renamed from: h */
    private static List<Alert> f5777h;

    /* renamed from: i */
    private static SecretKey f5778i = null;

    /* renamed from: j */
    private static SecretKey f5779j = null;

    /* renamed from: k */
    private static byte[] f5780k = null;

    /* renamed from: l */
    private static int f5781l;
    public static List<GoDoughLocation> locations;

    /* renamed from: m */
    private static CookieManager f5782m = new CookieManager();

    /* renamed from: n */
    private static GodoughMenuItem.Type f5783n;

    public static List<Alert> getAlertsList() {
        return f5777h;
    }

    public static GoDoughApp getApp() {
        return f5770a;
    }

    public static CookieManager getCookieManager() {
        return f5782m;
    }

    public static boolean getInForeground() {
        return f5774e;
    }

    public static int getLandingPageCount() {
        return f5781l;
    }

    public static GodoughMenuItem.Type getLandingPageType() {
        return f5783n;
    }

    public static List<GoDoughLocation> getLocations() {
        return locations;
    }

    public static int getNotificationId() {
        f5775f++;
        return f5775f;
    }

    public static int getNotificationRedirect() {
        return f5776g;
    }

    public static byte[] getRdaIV() {
        return f5780k;
    }

    public static SecretKey getRdacode() {
        return f5778i;
    }

    public static SecretKey getRdacode2() {
        return f5779j;
    }

    public static Settings getSettings() {
        return f5771b;
    }

    public static UserSettings getUserSettings() {
        return f5772c;
    }

    public static int getuID() {
        return f5773d;
    }

    public static void removeAlertFromList(int i) {
        f5777h.remove(i);
        updateAlertCount(f5772c.getAlertCount() - 1);
    }

    public static void setAlertsList(List<Alert> list) {
        f5777h = list;
    }

    public static void setCookieManager(CookieManager cookieManager) {
        f5782m = cookieManager;
    }

    public static void setInForeground(boolean z) {
        f5774e = z;
    }

    public static void setLandingPageCount(int i) {
        f5781l = i;
    }

    public static void setLandingPageType(GodoughMenuItem.Type type) {
        f5783n = type;
    }

    public static void setLocations(List<GoDoughLocation> list) {
        locations = list;
    }

    public static void setNotificationId(int i) {
        f5775f = i;
    }

    public static void setNotificationRedirect(int i) {
        f5776g = i;
    }

    public static void setRdaIV(byte[] bArr) {
        f5780k = bArr;
    }

    public static void setRdacode(SecretKey secretKey) {
        f5778i = secretKey;
    }

    public static void setRdacode2(SecretKey secretKey) {
        f5779j = secretKey;
    }

    public static void setSettings(Settings settings) {
        f5771b = settings;
    }

    public static void setUserSettings(UserSettings userSettings) {
        f5772c = userSettings;
    }

    public static void setuID(int i) {
        f5773d = i;
    }

    public static void updateAlertCount(int i) {
        f5772c.setAlertCount(i);
    }

    public static void wipeRDACodes() {
        f5780k = null;
        f5778i = null;
        f5779j = null;
    }

    public void onCreate() {
        super.onCreate();
        f5770a = this;
        getCookieManager().getCookieStore().removeAll();
        C1373a.m5614a((Context) getApp(), C1347a.m5547a((Context) this), getString(C1506am.fi_name));
        C1945a.m6997b("App Started");
        C1650av.m6407b();
    }
}
