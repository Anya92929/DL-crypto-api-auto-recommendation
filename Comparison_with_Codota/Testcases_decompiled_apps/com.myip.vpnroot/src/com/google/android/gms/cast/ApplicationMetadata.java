package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1326ik;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new C0262a();

    /* renamed from: BR */
    private final int f390BR;

    /* renamed from: EA */
    List<WebImage> f391EA;

    /* renamed from: EB */
    List<String> f392EB;

    /* renamed from: EC */
    String f393EC;

    /* renamed from: ED */
    Uri f394ED;

    /* renamed from: Ez */
    String f395Ez;
    String mName;

    private ApplicationMetadata() {
        this.f390BR = 1;
        this.f391EA = new ArrayList();
        this.f392EB = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.f390BR = versionCode;
        this.f395Ez = applicationId;
        this.mName = name;
        this.f391EA = images;
        this.f392EB = namespaces;
        this.f393EC = senderAppIdentifier;
        this.f394ED = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.f392EB != null && this.f392EB.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return C1326ik.m4984a(this.f395Ez, applicationMetadata.f395Ez) && C1326ik.m4984a(this.f391EA, applicationMetadata.f391EA) && C1326ik.m4984a(this.mName, applicationMetadata.mName) && C1326ik.m4984a(this.f392EB, applicationMetadata.f392EB) && C1326ik.m4984a(this.f393EC, applicationMetadata.f393EC) && C1326ik.m4984a(this.f394ED, applicationMetadata.f394ED);
    }

    /* renamed from: fv */
    public Uri mo3883fv() {
        return this.f394ED;
    }

    public String getApplicationId() {
        return this.f395Ez;
    }

    public List<WebImage> getImages() {
        return this.f391EA;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.f393EC;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f390BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f390BR), this.f395Ez, this.mName, this.f391EA, this.f392EB, this.f393EC, this.f394ED);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.f392EB != null && this.f392EB.contains(namespace);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0262a.m448a(this, out, flags);
    }
}
