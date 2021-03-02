package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.google.android.gms.tagmanager.cz */
class C2101cz {
    /* renamed from: a */
    static void m7067a(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m7068a(edit);
    }

    /* renamed from: a */
    static void m7068a(final SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new Runnable() {
                public void run() {
                    editor.commit();
                }
            }).start();
        }
    }
}
