package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1326ik;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new C0264c();

    /* renamed from: BR */
    private final int f435BR;

    /* renamed from: Fb */
    private boolean f436Fb;

    /* renamed from: Fc */
    private String f437Fc;

    public static final class Builder {

        /* renamed from: Fd */
        private LaunchOptions f438Fd = new LaunchOptions();

        public LaunchOptions build() {
            return this.f438Fd;
        }

        public Builder setLocale(Locale locale) {
            this.f438Fd.setLanguage(C1326ik.m4988b(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.f438Fd.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, C1326ik.m4988b(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.f435BR = versionCode;
        this.f436Fb = relaunchIfRunning;
        this.f437Fc = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.f436Fb == launchOptions.f436Fb && C1326ik.m4984a(this.f437Fc, launchOptions.f437Fc);
    }

    public String getLanguage() {
        return this.f437Fc;
    }

    public boolean getRelaunchIfRunning() {
        return this.f436Fb;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f435BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Boolean.valueOf(this.f436Fb), this.f437Fc);
    }

    public void setLanguage(String language) {
        this.f437Fc = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.f436Fb = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.f436Fb), this.f437Fc});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0264c.m454a(this, out, flags);
    }
}
