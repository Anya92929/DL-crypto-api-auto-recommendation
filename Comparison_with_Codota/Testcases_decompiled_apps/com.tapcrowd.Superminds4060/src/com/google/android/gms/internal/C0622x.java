package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.x */
public final class C0622x implements SafeParcelable {
    public static final C0623y CREATOR = new C0623y();

    /* renamed from: ew */
    public final String f1581ew;

    /* renamed from: ex */
    public final boolean f1582ex;
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public C0622x() {
        this(1, "interstitial_mb", 0, 0, true, 0, 0);
    }

    C0622x(int i, String str, int i2, int i3, boolean z, int i4, int i5) {
        this.versionCode = i;
        this.f1581ew = str;
        this.height = i2;
        this.heightPixels = i3;
        this.f1582ex = z;
        this.width = i4;
        this.widthPixels = i5;
    }

    public C0622x(Context context, AdSize adSize) {
        int i;
        boolean z = true;
        this.versionCode = 1;
        this.f1582ex = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z2 = this.width == -1;
        z = this.height != -2 ? false : z;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z2) {
            this.widthPixels = m1958a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            int i2 = this.width;
            this.widthPixels = C0343cm.m722a(displayMetrics, this.width);
            i = i2;
        }
        int c = z ? m1960c(displayMetrics) : this.height;
        this.heightPixels = C0343cm.m722a(displayMetrics, c);
        if (z2 || z) {
            this.f1581ew = i + "x" + c + "_as";
        } else {
            this.f1581ew = adSize.toString();
        }
    }

    /* renamed from: a */
    public static int m1958a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static int m1959b(DisplayMetrics displayMetrics) {
        return (int) (((float) m1960c(displayMetrics)) * displayMetrics.density);
    }

    /* renamed from: c */
    private static int m1960c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0623y.m1961a(this, out, flags);
    }
}
