package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.model.internal.zze;

public final class IndoorLevel {

    /* renamed from: a */
    private final zze f5152a;

    public IndoorLevel(zze zze) {
        this.f5152a = (zze) C1009bf.m4528a(zze);
    }

    public void activate() {
        try {
            this.f5152a.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.f5152a.zza(((IndoorLevel) obj).f5152a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.f5152a.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.f5152a.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f5152a.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
