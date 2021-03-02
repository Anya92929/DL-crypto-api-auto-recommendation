package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Map;

public class GoogleAuthApiResponse implements SafeParcelable {
    public static final GoogleAuthApiResponseCreator CREATOR = new GoogleAuthApiResponseCreator();

    /* renamed from: DA */
    final byte[] f386DA;

    /* renamed from: Dz */
    final Bundle f387Dz;
    final int responseCode;
    final int versionCode;

    public GoogleAuthApiResponse(int versionCode2, int responseCode2, Bundle headers, byte[] body) {
        this.versionCode = versionCode2;
        this.responseCode = responseCode2;
        this.f387Dz = headers;
        this.f386DA = body;
    }

    public GoogleAuthApiResponse(int responseCode2, Bundle headers, byte[] body) {
        this.versionCode = 1;
        this.responseCode = responseCode2;
        this.f387Dz = headers;
        this.f386DA = body;
    }

    public GoogleAuthApiResponse(int responseCode2, Map<String, String> headers, byte[] body) {
        this(responseCode2, m357B(headers), body);
    }

    /* renamed from: B */
    private static Bundle m357B(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getBody() {
        return this.f386DA;
    }

    public Bundle getHeaders() {
        return this.f387Dz;
    }

    public Map<String, String> getHeadersAsMap() {
        HashMap hashMap = new HashMap();
        for (String str : this.f387Dz.keySet()) {
            hashMap.put(str, this.f387Dz.getString(str));
        }
        return hashMap;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        GoogleAuthApiResponseCreator.m358a(this, parcel, flags);
    }
}
