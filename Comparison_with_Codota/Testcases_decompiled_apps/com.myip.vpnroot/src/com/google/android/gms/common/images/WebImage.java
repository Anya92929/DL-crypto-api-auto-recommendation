package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new C0312b();

    /* renamed from: BR */
    private final int f721BR;

    /* renamed from: KJ */
    private final Uri f722KJ;

    /* renamed from: lf */
    private final int f723lf;

    /* renamed from: lg */
    private final int f724lg;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.f721BR = versionCode;
        this.f722KJ = url;
        this.f723lf = width;
        this.f724lg = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(m660d(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    /* renamed from: d */
    private static Uri m660d(JSONObject jSONObject) {
        if (!jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: bL */
    public JSONObject mo4380bL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.f722KJ.toString());
            jSONObject.put("width", this.f723lf);
            jSONObject.put("height", this.f724lg);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return C0345m.equal(this.f722KJ, webImage.f722KJ) && this.f723lf == webImage.f723lf && this.f724lg == webImage.f724lg;
    }

    public int getHeight() {
        return this.f724lg;
    }

    public Uri getUrl() {
        return this.f722KJ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f721BR;
    }

    public int getWidth() {
        return this.f723lf;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f722KJ, Integer.valueOf(this.f723lf), Integer.valueOf(this.f724lg));
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.f723lf), Integer.valueOf(this.f724lg), this.f722KJ.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0312b.m674a(this, out, flags);
    }
}
