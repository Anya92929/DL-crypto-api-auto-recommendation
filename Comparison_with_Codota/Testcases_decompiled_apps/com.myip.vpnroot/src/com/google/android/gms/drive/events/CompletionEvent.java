package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0389ae;
import com.google.android.gms.drive.internal.C0478v;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C1389jy;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new C0371b();
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;

    /* renamed from: BR */
    final int f857BR;

    /* renamed from: Dd */
    final String f858Dd;

    /* renamed from: Fa */
    final int f859Fa;

    /* renamed from: MO */
    final DriveId f860MO;

    /* renamed from: NF */
    final ParcelFileDescriptor f861NF;

    /* renamed from: NG */
    final ParcelFileDescriptor f862NG;

    /* renamed from: NH */
    final MetadataBundle f863NH;

    /* renamed from: NI */
    final ArrayList<String> f864NI;

    /* renamed from: NJ */
    final IBinder f865NJ;

    /* renamed from: NK */
    private boolean f866NK = false;

    /* renamed from: NL */
    private boolean f867NL = false;

    /* renamed from: NM */
    private boolean f868NM = false;

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, ArrayList<String> trackingTags, int status, IBinder releaseCallback) {
        this.f857BR = versionCode;
        this.f860MO = driveId;
        this.f858Dd = accountName;
        this.f861NF = baseParcelFileDescriptor;
        this.f862NG = modifiedParcelFileDescriptor;
        this.f863NH = modifiedMetadataBundle;
        this.f864NI = trackingTags;
        this.f859Fa = status;
        this.f865NJ = releaseCallback;
    }

    /* renamed from: L */
    private void m981L(boolean z) {
        m982hU();
        this.f868NM = true;
        C1389jy.m5221a(this.f861NF);
        C1389jy.m5221a(this.f862NG);
        if (this.f865NJ == null) {
            C0478v.m1344q("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            C0389ae.C0390a.m1126X(this.f865NJ).mo4911L(z);
        } catch (RemoteException e) {
            C0478v.m1344q("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    /* renamed from: hU */
    private void m982hU() {
        if (this.f868NM) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        m981L(false);
    }

    public String getAccountName() {
        m982hU();
        return this.f858Dd;
    }

    public InputStream getBaseContentsInputStream() {
        m982hU();
        if (this.f861NF == null) {
            return null;
        }
        if (this.f866NK) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.f866NK = true;
        return new FileInputStream(this.f861NF.getFileDescriptor());
    }

    public DriveId getDriveId() {
        m982hU();
        return this.f860MO;
    }

    public InputStream getModifiedContentsInputStream() {
        m982hU();
        if (this.f862NG == null) {
            return null;
        }
        if (this.f867NL) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.f867NL = true;
        return new FileInputStream(this.f862NG.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        m982hU();
        if (this.f863NH != null) {
            return new MetadataChangeSet(this.f863NH);
        }
        return null;
    }

    public int getStatus() {
        m982hU();
        return this.f859Fa;
    }

    public List<String> getTrackingTags() {
        m982hU();
        return new ArrayList(this.f864NI);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        m981L(true);
    }

    public String toString() {
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.f860MO, Integer.valueOf(this.f859Fa), this.f864NI == null ? "<null>" : "'" + TextUtils.join("','", this.f864NI) + "'"});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0371b.m997a(this, dest, flags);
    }
}
