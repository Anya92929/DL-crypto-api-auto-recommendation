package com.unity3d.player.a;

import android.content.SharedPreferences;

public final class j {
    private final SharedPreferences a;
    private final h b;
    private SharedPreferences.Editor c = null;

    public j(SharedPreferences sharedPreferences, h hVar) {
        this.a = sharedPreferences;
        this.b = hVar;
    }

    public final void a() {
        if (this.c != null) {
            this.c.commit();
            this.c = null;
        }
    }

    public final void a(String str, String str2) {
        if (this.c == null) {
            this.c = this.a.edit();
        }
        this.c.putString(str, this.b.a(str2));
    }

    public final String b(String str, String str2) {
        String string = this.a.getString(str, (String) null);
        if (string == null) {
            return str2;
        }
        try {
            return this.b.b(string);
        } catch (l e) {
            return str2;
        }
    }
}
