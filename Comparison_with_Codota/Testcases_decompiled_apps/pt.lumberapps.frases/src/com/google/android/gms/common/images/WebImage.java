package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();

    /* renamed from: a */
    private final int f4419a;

    /* renamed from: b */
    private final Uri f4420b;

    /* renamed from: c */
    private final int f4421c;

    /* renamed from: d */
    private final int f4422d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f4419a = i;
        this.f4420b = uri;
        this.f4421c = i2;
        this.f4422d = i3;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(m6030a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    /* renamed from: a */
    private static Uri m6030a(JSONObject jSONObject) {
        if (!jSONObject.has("url")) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString("url"));
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6493a() {
        return this.f4419a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzaa.equal(this.f4420b, webImage.f4420b) && this.f4421c == webImage.f4421c && this.f4422d == webImage.f4422d;
    }

    public int getHeight() {
        return this.f4422d;
    }

    public Uri getUrl() {
        return this.f4420b;
    }

    public int getWidth() {
        return this.f4421c;
    }

    public int hashCode() {
        return zzaa.hashCode(this.f4420b, Integer.valueOf(this.f4421c), Integer.valueOf(this.f4422d));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f4420b.toString());
            jSONObject.put("width", this.f4421c);
            jSONObject.put("height", this.f4422d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f4421c), Integer.valueOf(this.f4422d), this.f4420b.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m6049a(this, parcel, i);
    }
}
