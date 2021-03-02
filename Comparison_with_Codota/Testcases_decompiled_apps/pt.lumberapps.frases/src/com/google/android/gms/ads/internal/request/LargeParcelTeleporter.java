package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import java.io.DataInputStream;
import java.io.IOException;

@zzin
public final class LargeParcelTeleporter extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzm();

    /* renamed from: a */
    final int f3905a;

    /* renamed from: b */
    ParcelFileDescriptor f3906b;

    /* renamed from: c */
    private Parcelable f3907c;

    /* renamed from: d */
    private boolean f3908d;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f3905a = i;
        this.f3906b = parcelFileDescriptor;
        this.f3907c = null;
        this.f3908d = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.f3905a = 1;
        this.f3906b = null;
        this.f3907c = safeParcelable;
        this.f3908d = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ParcelFileDescriptor mo5632a(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new C1300a(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
            zzkd.zzb("Error transporting the ad response", e);
            zzu.zzft().zzb((Throwable) e, true);
            zzo.zzb(autoCloseOutputStream);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f3906b == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f3907c.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.f3906b = mo5632a(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        zzm.m5753a(this, parcel, i);
    }

    /* JADX INFO: finally extract failed */
    public SafeParcelable zza(Parcelable.Creator creator) {
        if (this.f3908d) {
            if (this.f3906b == null) {
                zzkd.m5769e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f3906b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzo.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f3907c = (SafeParcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.f3908d = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th2) {
                zzo.zzb(dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.f3907c;
    }
}
