package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zze;

public class zza extends zzp.zza {
    private Context mContext;
    private Account zzTI;
    int zzakz;

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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zza)) {
            return false;
        }
        return this.zzTI.equals(((zza) o).zzTI);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzakz) {
            return this.zzTI;
        }
        if (zze.zzf(this.mContext, callingUid)) {
            this.zzakz = callingUid;
            return this.zzTI;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
