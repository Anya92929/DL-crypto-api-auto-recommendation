package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();

    /* renamed from: a */
    private final int f2887a;

    /* renamed from: b */
    private final Uri f2888b;

    /* renamed from: c */
    private final int f2889c;

    /* renamed from: d */
    private final int f2890d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f2887a = i;
        this.f2888b = uri;
        this.f2889c = i2;
        this.f2890d = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(m3883a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    /* renamed from: a */
    private static Uri m3883a(JSONObject jSONObject) {
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
    public int mo5354a() {
        return this.f2887a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.equal(this.f2888b, webImage.f2888b) && this.f2889c == webImage.f2889c && this.f2890d == webImage.f2890d;
    }

    public int getHeight() {
        return this.f2890d;
    }

    public Uri getUrl() {
        return this.f2888b;
    }

    public int getWidth() {
        return this.f2889c;
    }

    public int hashCode() {
        return zzw.hashCode(this.f2888b, Integer.valueOf(this.f2889c), Integer.valueOf(this.f2890d));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f2888b.toString());
            jSONObject.put("width", this.f2889c);
            jSONObject.put("height", this.f2890d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.f2889c), Integer.valueOf(this.f2890d), this.f2888b.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m3890a(this, parcel, i);
    }
}
