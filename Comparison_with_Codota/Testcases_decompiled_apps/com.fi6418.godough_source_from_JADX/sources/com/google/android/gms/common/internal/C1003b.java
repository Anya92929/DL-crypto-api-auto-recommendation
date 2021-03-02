package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0853e;

/* renamed from: com.google.android.gms.common.internal.b */
public class C1003b extends C0994ar {

    /* renamed from: a */
    int f4720a;

    /* renamed from: b */
    private Account f4721b;

    /* renamed from: c */
    private Context f4722c;

    /* renamed from: a */
    public static Account m4519a(C0993aq aqVar) {
        Account account = null;
        if (aqVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = aqVar.mo7546a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    /* renamed from: a */
    public Account mo7546a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f4720a) {
            return this.f4721b;
        }
        if (C0853e.m4242a(this.f4722c, callingUid)) {
            this.f4720a = callingUid;
            return this.f4721b;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1003b)) {
            return false;
        }
        return this.f4721b.equals(((C1003b) obj).f4721b);
    }
}
