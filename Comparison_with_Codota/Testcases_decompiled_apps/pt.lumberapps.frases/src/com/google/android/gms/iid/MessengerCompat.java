package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.iid.zzb;

public class MessengerCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1405a();

    /* renamed from: a */
    Messenger f4811a;

    /* renamed from: b */
    zzb f4812b;

    public MessengerCompat(Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4811a = new Messenger(handler);
        } else {
            this.f4812b = new C1406b(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4811a = new Messenger(iBinder);
        } else {
            this.f4812b = zzb.zza.zzgq(iBinder);
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    private static int m6259a(Message message) {
        return message.sendingUid;
    }

    public static int zzc(Message message) {
        return Build.VERSION.SDK_INT >= 21 ? m6259a(message) : message.arg2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public IBinder getBinder() {
        return this.f4811a != null ? this.f4811a.getBinder() : this.f4812b.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) {
        if (this.f4811a != null) {
            this.f4811a.send(message);
        } else {
            this.f4812b.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f4811a != null) {
            parcel.writeStrongBinder(this.f4811a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f4812b.asBinder());
        }
    }
}
