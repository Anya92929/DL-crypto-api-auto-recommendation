package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class Contents implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new C0362a();

    /* renamed from: BR */
    final int f797BR;

    /* renamed from: Kx */
    final ParcelFileDescriptor f798Kx;

    /* renamed from: MN */
    final int f799MN;

    /* renamed from: MO */
    final DriveId f800MO;

    /* renamed from: MP */
    final boolean f801MP;

    /* renamed from: MQ */
    private boolean f802MQ = false;

    /* renamed from: MR */
    private boolean f803MR = false;
    private boolean mClosed = false;

    /* renamed from: uQ */
    final int f804uQ;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection) {
        this.f797BR = versionCode;
        this.f798Kx = parcelFileDescriptor;
        this.f804uQ = requestId;
        this.f799MN = mode;
        this.f800MO = driveId;
        this.f801MP = validForConflictDetection;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.f800MO;
    }

    public InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.f799MN != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.f802MQ) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.f802MQ = true;
            return new FileInputStream(this.f798Kx.getFileDescriptor());
        }
    }

    public int getMode() {
        return this.f799MN;
    }

    public OutputStream getOutputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.f799MN != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.f803MR) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.f803MR = true;
            return new FileOutputStream(this.f798Kx.getFileDescriptor());
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.mClosed) {
            return this.f798Kx;
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public int getRequestId() {
        return this.f804uQ;
    }

    /* renamed from: hJ */
    public void mo4561hJ() {
        this.mClosed = true;
    }

    /* renamed from: hK */
    public boolean mo4562hK() {
        return this.mClosed;
    }

    /* renamed from: hL */
    public boolean mo4563hL() {
        return this.f801MP;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0362a.m972a(this, dest, flags);
    }
}
