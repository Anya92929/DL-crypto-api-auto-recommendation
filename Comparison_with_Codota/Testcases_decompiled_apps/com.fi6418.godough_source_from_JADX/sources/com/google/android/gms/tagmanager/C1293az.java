package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.google.android.gms.tagmanager.az */
class C1293az {
    /* renamed from: a */
    static void m5323a(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m5324a(edit);
    }

    /* renamed from: a */
    static void m5324a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C1295ba(editor)).start();
        }
    }
}
