package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzall;
    int zzalm;
    String zzaln;
    IBinder zzalo;
    Scope[] zzalp;
    Bundle zzalq;
    Account zzalr;

    public GetServiceRequest(int serviceId) {
        this.version = 2;
        this.zzalm = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzall = serviceId;
    }

    GetServiceRequest(int version2, int serviceId, int clientVersion, String callingPackage, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, Account clientRequestedAccount) {
        this.version = version2;
        this.zzall = serviceId;
        this.zzalm = clientVersion;
        this.zzaln = callingPackage;
        if (version2 < 2) {
            this.zzalr = zzaO(accountAccessorBinder);
        } else {
            this.zzalo = accountAccessorBinder;
            this.zzalr = clientRequestedAccount;
        }
        this.zzalp = scopes;
        this.zzalq = extraArgs;
    }

    private Account zzaO(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzp.zza.zzaP(iBinder));
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public GetServiceRequest zzb(zzp zzp) {
        if (zzp != null) {
            this.zzalo = zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzc(Account account) {
        this.zzalr = account;
        return this;
    }

    public GetServiceRequest zzcG(String str) {
        this.zzaln = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzalp = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.zzalq = bundle;
        return this;
    }
}
