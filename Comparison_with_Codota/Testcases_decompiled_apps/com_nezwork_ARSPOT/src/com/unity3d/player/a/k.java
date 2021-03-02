package com.unity3d.player.a;

import android.text.TextUtils;

final class k {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;

    k() {
    }

    public final String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.d, this.e, Long.valueOf(this.f)});
    }
}
