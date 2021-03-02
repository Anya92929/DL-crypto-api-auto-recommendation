package com.jackhenry.godough.core.p038e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: com.jackhenry.godough.core.e.m */
public class C1584m {

    /* renamed from: a */
    Context f6160a;

    public C1584m(Context context) {
        this.f6160a = context;
    }

    /* renamed from: a */
    private SharedPreferences m6161a() {
        return PreferenceManager.getDefaultSharedPreferences(this.f6160a);
    }

    /* renamed from: a */
    public String mo9798a(String str, String str2) {
        return m6161a().getString(str, str2);
    }

    /* renamed from: a */
    public void mo9799a(String str) {
        SharedPreferences.Editor edit = m6161a().edit();
        edit.remove(str);
        edit.commit();
    }

    /* renamed from: a */
    public boolean mo9800a(String str, boolean z) {
        return m6161a().getBoolean(str, z);
    }

    /* renamed from: b */
    public void mo9801b(String str, String str2) {
        m6161a().edit().putString(str, str2).commit();
    }

    /* renamed from: b */
    public void mo9802b(String str, boolean z) {
        m6161a().edit().putBoolean(str, z).commit();
    }
}
