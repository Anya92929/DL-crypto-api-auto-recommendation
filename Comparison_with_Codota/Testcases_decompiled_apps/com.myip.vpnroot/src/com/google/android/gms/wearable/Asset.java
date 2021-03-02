package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Asset implements SafeParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new C2225a();

    /* renamed from: BR */
    final int f4650BR;
    private byte[] acw;
    private String auF;
    public ParcelFileDescriptor auG;
    public Uri uri;

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri2) {
        this.f4650BR = versionCode;
        this.acw = data;
        this.auF = digest;
        this.auG = fd;
        this.uri = uri2;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, (String) null, (ParcelFileDescriptor) null, (Uri) null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, (byte[]) null, (String) null, fd, (Uri) null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, (byte[]) null, digest, (ParcelFileDescriptor) null, (Uri) null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri2) {
        if (uri2 != null) {
            return new Asset(1, (byte[]) null, (String) null, (ParcelFileDescriptor) null, uri2);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return C0345m.equal(this.acw, asset.acw) && C0345m.equal(this.auF, asset.auF) && C0345m.equal(this.auG, asset.auG) && C0345m.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.acw;
    }

    public String getDigest() {
        return this.auF;
    }

    public ParcelFileDescriptor getFd() {
        return this.auG;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return C0345m.hashCode(this.acw, this.auF, this.auG, this.uri);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.auF == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.auF);
        }
        if (this.acw != null) {
            sb.append(", size=");
            sb.append(this.acw.length);
        }
        if (this.auG != null) {
            sb.append(", fd=");
            sb.append(this.auG);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2225a.m7480a(this, dest, flags | 1);
    }
}
