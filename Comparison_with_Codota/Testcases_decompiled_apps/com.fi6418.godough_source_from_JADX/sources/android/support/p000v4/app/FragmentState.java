package android.support.p000v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* renamed from: android.support.v4.app.FragmentState */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };

    /* renamed from: a */
    final String f485a;

    /* renamed from: b */
    final int f486b;

    /* renamed from: c */
    final boolean f487c;

    /* renamed from: d */
    final int f488d;

    /* renamed from: e */
    final int f489e;

    /* renamed from: f */
    final String f490f;

    /* renamed from: g */
    final boolean f491g;

    /* renamed from: h */
    final boolean f492h;

    /* renamed from: i */
    final Bundle f493i;

    /* renamed from: j */
    Bundle f494j;

    /* renamed from: k */
    Fragment f495k;

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.f485a = parcel.readString();
        this.f486b = parcel.readInt();
        this.f487c = parcel.readInt() != 0;
        this.f488d = parcel.readInt();
        this.f489e = parcel.readInt();
        this.f490f = parcel.readString();
        this.f491g = parcel.readInt() != 0;
        this.f492h = parcel.readInt() == 0 ? false : z;
        this.f493i = parcel.readBundle();
        this.f494j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.f485a = fragment.getClass().getName();
        this.f486b = fragment.f399p;
        this.f487c = fragment.f408y;
        this.f488d = fragment.f365G;
        this.f489e = fragment.f366H;
        this.f490f = fragment.f367I;
        this.f491g = fragment.f370L;
        this.f492h = fragment.f369K;
        this.f493i = fragment.f401r;
    }

    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(FragmentHostCallback fragmentHostCallback, Fragment fragment) {
        if (this.f495k != null) {
            return this.f495k;
        }
        Context b = fragmentHostCallback.mo696b();
        if (this.f493i != null) {
            this.f493i.setClassLoader(b.getClassLoader());
        }
        this.f495k = Fragment.instantiate(b, this.f485a, this.f493i);
        if (this.f494j != null) {
            this.f494j.setClassLoader(b.getClassLoader());
            this.f495k.f397n = this.f494j;
        }
        this.f495k.mo493a(this.f486b, fragment);
        this.f495k.f408y = this.f487c;
        this.f495k.f359A = true;
        this.f495k.f365G = this.f488d;
        this.f495k.f366H = this.f489e;
        this.f495k.f367I = this.f490f;
        this.f495k.f370L = this.f491g;
        this.f495k.f369K = this.f492h;
        this.f495k.f361C = fragmentHostCallback.f430d;
        if (FragmentManagerImpl.f439a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f495k);
        }
        return this.f495k;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f485a);
        parcel.writeInt(this.f486b);
        parcel.writeInt(this.f487c ? 1 : 0);
        parcel.writeInt(this.f488d);
        parcel.writeInt(this.f489e);
        parcel.writeString(this.f490f);
        parcel.writeInt(this.f491g ? 1 : 0);
        if (!this.f492h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f493i);
        parcel.writeBundle(this.f494j);
    }
}
