package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C0139a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@C1130ez
/* renamed from: com.google.android.gms.internal.ay */
public final class C0927ay implements SafeParcelable {
    public static final C0928az CREATOR = new C0928az();
    public final int height;
    public final int heightPixels;

    /* renamed from: of */
    public final String f2622of;

    /* renamed from: og */
    public final boolean f2623og;

    /* renamed from: oh */
    public final C0927ay[] f2624oh;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public C0927ay() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, (C0927ay[]) null);
    }

    C0927ay(int i, String str, int i2, int i3, boolean z, int i4, int i5, C0927ay[] ayVarArr) {
        this.versionCode = i;
        this.f2622of = str;
        this.height = i2;
        this.heightPixels = i3;
        this.f2623og = z;
        this.width = i4;
        this.widthPixels = i5;
        this.f2624oh = ayVarArr;
    }

    public C0927ay(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public C0927ay(Context context, AdSize[] adSizeArr) {
        int i;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 2;
        this.f2623og = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            this.widthPixels = m3913a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            int i2 = this.width;
            this.widthPixels = C1228gr.m4668a(displayMetrics, this.width);
            i = i2;
        }
        int c = z2 ? m3915c(displayMetrics) : this.height;
        this.heightPixels = C1228gr.m4668a(displayMetrics, c);
        if (z || z2) {
            this.f2622of = i + "x" + c + "_as";
        } else {
            this.f2622of = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.f2624oh = new C0927ay[adSizeArr.length];
            for (int i3 = 0; i3 < adSizeArr.length; i3++) {
                this.f2624oh[i3] = new C0927ay(context, adSizeArr[i3]);
            }
            return;
        }
        this.f2624oh = null;
    }

    public C0927ay(C0927ay ayVar, C0927ay[] ayVarArr) {
        this(2, ayVar.f2622of, ayVar.height, ayVar.heightPixels, ayVar.f2623og, ayVar.width, ayVar.widthPixels, ayVarArr);
    }

    /* renamed from: a */
    public static int m3913a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static int m3914b(DisplayMetrics displayMetrics) {
        return (int) (((float) m3915c(displayMetrics)) * displayMetrics.density);
    }

    /* renamed from: c */
    private static int m3915c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    /* renamed from: bc */
    public AdSize mo8022bc() {
        return C0139a.m20a(this.width, this.height, this.f2622of);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0928az.m3917a(this, out, flags);
    }
}
