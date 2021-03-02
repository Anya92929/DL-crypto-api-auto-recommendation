package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.regex.Pattern;

public class CustomPropertyKey implements SafeParcelable {
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new C0495c();

    /* renamed from: Px */
    private static final Pattern f1090Px = Pattern.compile("[\\w.!@$%^&*()/-]+");

    /* renamed from: BR */
    final int f1091BR;

    /* renamed from: JH */
    final String f1092JH;
    final int mVisibility;

    CustomPropertyKey(int versionCode, String key, int visibility) {
        boolean z = true;
        C0348n.m857b(key, (Object) "key");
        C0348n.m859b(f1090Px.matcher(key).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(visibility == 0 || visibility == 1)) {
            z = false;
        }
        C0348n.m859b(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.f1091BR = versionCode;
        this.f1092JH = key;
        this.mVisibility = visibility;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        if (!customPropertyKey.getKey().equals(this.f1092JH) || customPropertyKey.getVisibility() != this.mVisibility) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.f1092JH;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.f1092JH + this.mVisibility).hashCode();
    }

    public String toString() {
        return "CustomPropertyKey(" + this.f1092JH + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0495c.m1380a(this, dest, flags);
    }
}
