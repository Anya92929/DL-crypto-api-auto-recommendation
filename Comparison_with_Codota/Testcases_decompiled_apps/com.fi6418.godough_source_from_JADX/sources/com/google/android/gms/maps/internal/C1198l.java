package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.internal.zza;
import com.google.android.gms.p017b.C0605j;

/* renamed from: com.google.android.gms.maps.internal.l */
class C1198l implements zzc {

    /* renamed from: a */
    private IBinder f5097a;

    C1198l(IBinder iBinder) {
        this.f5097a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5097a;
    }

    public IMapViewDelegate zza(C0605j jVar, GoogleMapOptions googleMapOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            if (googleMapOptions != null) {
                obtain.writeInt(1);
                googleMapOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5097a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return IMapViewDelegate.zza.zzcp(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IStreetViewPanoramaViewDelegate zza(C0605j jVar, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            if (streetViewPanoramaOptions != null) {
                obtain.writeInt(1);
                streetViewPanoramaOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5097a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return IStreetViewPanoramaViewDelegate.zza.zzcM(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzd(C0605j jVar, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            obtain.writeInt(i);
            this.f5097a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzs(C0605j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5097a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IMapFragmentDelegate zzt(C0605j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5097a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return IMapFragmentDelegate.zza.zzco(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IStreetViewPanoramaFragmentDelegate zzu(C0605j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5097a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return IStreetViewPanoramaFragmentDelegate.zza.zzcL(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public ICameraUpdateFactoryDelegate zzwX() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.f5097a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return ICameraUpdateFactoryDelegate.zza.zzci(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zza zzwY() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.f5097a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return zza.C1950zza.zzcO(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
