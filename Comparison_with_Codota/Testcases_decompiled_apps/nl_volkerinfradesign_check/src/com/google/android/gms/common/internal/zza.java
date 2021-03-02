package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zze;

public class zza extends zzp.zza {

    /* renamed from: a */
    int f2935a;

    /* renamed from: b */
    private Account f2936b;

    /* renamed from: c */
    private Context f2937c;

    public static Account zza(zzp zzp) {
        Account account = null;
        if (zzp != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzp.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        return this.f2936b.equals(((zza) obj).f2936b);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f2935a) {
            return this.f2936b;
        }
        if (zze.zzf(this.f2937c, callingUid)) {
            this.f2935a = callingUid;
            return this.f2936b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
