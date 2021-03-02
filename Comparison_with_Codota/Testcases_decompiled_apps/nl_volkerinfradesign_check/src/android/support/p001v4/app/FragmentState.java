package android.support.p001v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* renamed from: android.support.v4.app.FragmentState */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: a */
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* renamed from: a */
    final String f209a;

    /* renamed from: b */
    final int f210b;

    /* renamed from: c */
    final boolean f211c;

    /* renamed from: d */
    final int f212d;

    /* renamed from: e */
    final int f213e;

    /* renamed from: f */
    final String f214f;

    /* renamed from: g */
    final boolean f215g;

    /* renamed from: h */
    final boolean f216h;

    /* renamed from: i */
    final Bundle f217i;

    /* renamed from: j */
    public Bundle f218j;

    /* renamed from: k */
    public Fragment f219k;

    public FragmentState(Fragment fragment) {
        this.f209a = fragment.getClass().getName();
        this.f210b = fragment.f164p;
        this.f211c = fragment.f173y;
        this.f212d = fragment.f130G;
        this.f213e = fragment.f131H;
        this.f214f = fragment.f132I;
        this.f215g = fragment.f135L;
        this.f216h = fragment.f134K;
        this.f217i = fragment.f166r;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f209a = parcel.readString();
        this.f210b = parcel.readInt();
        this.f211c = parcel.readInt() != 0;
        this.f212d = parcel.readInt();
        this.f213e = parcel.readInt();
        this.f214f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f215g = z;
        this.f216h = parcel.readInt() == 0 ? false : z2;
        this.f217i = parcel.readBundle();
        this.f218j = parcel.readBundle();
    }

    /* renamed from: a */
    public Fragment mo447a(FragmentHostCallback fragmentHostCallback, Fragment fragment) {
        if (this.f219k != null) {
            return this.f219k;
        }
        Context c = fragmentHostCallback.mo407c();
        if (this.f217i != null) {
            this.f217i.setClassLoader(c.getClassLoader());
        }
        this.f219k = Fragment.instantiate(c, this.f209a, this.f217i);
        if (this.f218j != null) {
            this.f218j.setClassLoader(c.getClassLoader());
            this.f219k.f162n = this.f218j;
        }
        this.f219k.mo195a(this.f210b, fragment);
        this.f219k.f173y = this.f211c;
        this.f219k.f124A = true;
        this.f219k.f130G = this.f212d;
        this.f219k.f131H = this.f213e;
        this.f219k.f132I = this.f214f;
        this.f219k.f135L = this.f215g;
        this.f219k.f134K = this.f216h;
        this.f219k.f126C = fragmentHostCallback.f196d;
        if (C2004v.f7289a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f219k);
        }
        return this.f219k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f209a);
        parcel.writeInt(this.f210b);
        parcel.writeInt(this.f211c ? 1 : 0);
        parcel.writeInt(this.f212d);
        parcel.writeInt(this.f213e);
        parcel.writeString(this.f214f);
        if (this.f215g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f216h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f217i);
        parcel.writeBundle(this.f218j);
    }
}
