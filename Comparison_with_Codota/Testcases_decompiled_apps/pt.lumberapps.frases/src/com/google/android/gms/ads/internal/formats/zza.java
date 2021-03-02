package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import com.google.android.gms.internal.zzin;
import java.util.List;

@zzin
public class zza {

    /* renamed from: a */
    static final int f3639a = f3642d;

    /* renamed from: b */
    static final int f3640b = f3641c;

    /* renamed from: c */
    private static final int f3641c = Color.rgb(12, 174, 206);

    /* renamed from: d */
    private static final int f3642d = Color.rgb(204, 204, 204);

    /* renamed from: e */
    private final String f3643e;

    /* renamed from: f */
    private final List f3644f;

    /* renamed from: g */
    private final int f3645g;

    /* renamed from: h */
    private final int f3646h;

    /* renamed from: i */
    private final int f3647i;

    /* renamed from: j */
    private final int f3648j;

    /* renamed from: k */
    private final int f3649k;

    public zza(String str, List list, Integer num, Integer num2, Integer num3, int i, int i2) {
        this.f3643e = str;
        this.f3644f = list;
        this.f3645g = num != null ? num.intValue() : f3639a;
        this.f3646h = num2 != null ? num2.intValue() : f3640b;
        this.f3647i = num3 != null ? num3.intValue() : 12;
        this.f3648j = i;
        this.f3649k = i2;
    }

    public int getBackgroundColor() {
        return this.f3645g;
    }

    public String getText() {
        return this.f3643e;
    }

    public int getTextColor() {
        return this.f3646h;
    }

    public int getTextSize() {
        return this.f3647i;
    }

    public List zzkp() {
        return this.f3644f;
    }

    public int zzkq() {
        return this.f3648j;
    }

    public int zzkr() {
        return this.f3649k;
    }
}
