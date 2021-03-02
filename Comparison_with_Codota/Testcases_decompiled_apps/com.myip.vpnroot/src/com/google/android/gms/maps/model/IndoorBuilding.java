package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.maps.model.internal.C1892d;
import com.google.android.gms.maps.model.internal.C1895e;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final C1892d ajL;

    public IndoorBuilding(C1892d delegate) {
        this.ajL = (C1892d) C0348n.m861i(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.ajL.mo11128b(((IndoorBuilding) other).ajL);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.ajL.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.ajL.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.ajL.getLevels();
            ArrayList arrayList = new ArrayList(levels.size());
            for (IBinder bt : levels) {
                arrayList.add(new IndoorLevel(C1895e.C1896a.m6463bt(bt)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.ajL.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.ajL.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
