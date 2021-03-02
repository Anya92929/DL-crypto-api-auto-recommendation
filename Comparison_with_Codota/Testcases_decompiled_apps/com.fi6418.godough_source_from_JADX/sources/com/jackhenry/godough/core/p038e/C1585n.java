package com.jackhenry.godough.core.p038e;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Settings;

/* renamed from: com.jackhenry.godough.core.e.n */
public class C1585n {

    /* renamed from: a */
    private Context f6161a;

    public C1585n(Context context) {
        this.f6161a = context;
    }

    /* renamed from: a */
    private long m6167a(String str, long j) {
        return m6179j().getLong(str, j);
    }

    /* renamed from: a */
    private String m6168a(String str, int i) {
        try {
            Color.parseColor(str);
            return str;
        } catch (Exception e) {
            return this.f6161a.getString(i);
        }
    }

    /* renamed from: a */
    public static String m6169a(String str, String str2) {
        return C1364k.m5593d(str) + C1364k.m5593d(str2);
    }

    /* renamed from: a */
    private boolean m6170a(String str, boolean z) {
        return m6179j().getBoolean(str, z);
    }

    /* renamed from: b */
    private int m6171b(String str, int i) {
        return Color.parseColor(m6172b(str, this.f6161a.getString(i)));
    }

    /* renamed from: b */
    private String m6172b(String str, String str2) {
        return m6179j().getString(str, str2);
    }

    /* renamed from: b */
    private void m6173b(String str, long j) {
        m6179j().edit().putLong(str, j).commit();
    }

    /* renamed from: b */
    private void m6174b(String str, boolean z) {
        m6179j().edit().putBoolean(str, z).commit();
    }

    /* renamed from: c */
    private int m6175c(String str, int i) {
        return m6179j().getInt(str, i);
    }

    /* renamed from: c */
    private void m6176c(String str, String str2) {
        m6179j().edit().putString(str, str2).commit();
    }

    /* renamed from: d */
    private void m6177d(String str, int i) {
        m6179j().edit().putInt(str, i).commit();
    }

    /* renamed from: f */
    private void m6178f(String str) {
        SharedPreferences.Editor edit = m6179j().edit();
        edit.remove(str);
        edit.commit();
    }

    /* renamed from: j */
    private SharedPreferences m6179j() {
        return PreferenceManager.getDefaultSharedPreferences(this.f6161a);
    }

    /* renamed from: a */
    public int mo9803a() {
        return m6171b("THEME_MAIN_COLOR", C1491af.fiColorMain);
    }

    /* renamed from: a */
    public void mo9804a(long j) {
        m6173b("SESSION_TIMEOUT", j);
    }

    /* renamed from: a */
    public void mo9805a(Settings.Texture texture) {
        m6177d("THEME_TEXTURE_ID", texture.ordinal());
    }

    /* renamed from: a */
    public void mo9806a(String str) {
        m6176c("THEME_MAIN_COLOR", m6168a(str, C1491af.fiColorMain));
    }

    /* renamed from: b */
    public void mo9807b() {
        m6174b("DRAWER_LAUNCHED_FIRST_LOAD", true);
    }

    /* renamed from: b */
    public void mo9808b(String str) {
        m6176c("THEME_ACTION_ITEM_COLOR", m6168a(str, C1491af.fiColorActionItem));
    }

    /* renamed from: c */
    public void mo9809c(String str) {
        m6176c("THEME_BTN_LOCATIONS", str);
    }

    /* renamed from: c */
    public boolean mo9810c() {
        return m6170a("DRAWER_LAUNCHED_FIRST_LOAD", false);
    }

    /* renamed from: d */
    public int mo9811d() {
        return m6171b("THEME_ACTION_ITEM_COLOR", C1491af.fiColorActionItem);
    }

    /* renamed from: d */
    public void mo9812d(String str) {
        m6176c("THEME_BTN_LOGIN", str);
    }

    /* renamed from: e */
    public Settings.Texture mo9813e() {
        try {
            return Settings.Texture.values()[m6175c("THEME_TEXTURE_ID", Integer.parseInt(this.f6161a.getString(C1506am.theme_texture_id)))];
        } catch (Exception e) {
            return Settings.Texture.TRANSPARENT;
        }
    }

    /* renamed from: e */
    public void mo9814e(String str) {
        if (str == null) {
            m6178f("SERIAL_ID");
        } else {
            m6176c("SERIAL_ID", str);
        }
    }

    /* renamed from: f */
    public String mo9815f() {
        return m6172b("THEME_BTN_LOCATIONS", this.f6161a.getString(C1506am.btn_locations));
    }

    /* renamed from: g */
    public String mo9816g() {
        return m6172b("THEME_BTN_LOGIN", this.f6161a.getString(C1506am.btn_login));
    }

    /* renamed from: h */
    public long mo9817h() {
        return m6167a("SESSION_TIMEOUT", Long.MAX_VALUE);
    }

    /* renamed from: i */
    public String mo9818i() {
        return m6172b("SERIAL_ID", (String) null);
    }
}
