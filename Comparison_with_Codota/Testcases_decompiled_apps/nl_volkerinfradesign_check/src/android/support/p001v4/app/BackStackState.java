package android.support.p001v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* renamed from: a */
    final int[] f102a;

    /* renamed from: b */
    final int f103b;

    /* renamed from: c */
    final int f104c;

    /* renamed from: d */
    final String f105d;

    /* renamed from: e */
    final int f106e;

    /* renamed from: f */
    final int f107f;

    /* renamed from: g */
    final CharSequence f108g;

    /* renamed from: h */
    final int f109h;

    /* renamed from: i */
    final CharSequence f110i;

    /* renamed from: j */
    final ArrayList<String> f111j;

    /* renamed from: k */
    final ArrayList<String> f112k;

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (BackStackRecord.C0046a aVar = backStackRecord.f57c; aVar != null; aVar = aVar.f93a) {
            if (aVar.f101i != null) {
                i += aVar.f101i.size();
            }
        }
        this.f102a = new int[(i + (backStackRecord.f59e * 7))];
        if (!backStackRecord.f66l) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (BackStackRecord.C0046a aVar2 = backStackRecord.f57c; aVar2 != null; aVar2 = aVar2.f93a) {
            int i3 = i2 + 1;
            this.f102a[i2] = aVar2.f95c;
            int i4 = i3 + 1;
            this.f102a[i3] = aVar2.f96d != null ? aVar2.f96d.f164p : -1;
            int i5 = i4 + 1;
            this.f102a[i4] = aVar2.f97e;
            int i6 = i5 + 1;
            this.f102a[i5] = aVar2.f98f;
            int i7 = i6 + 1;
            this.f102a[i6] = aVar2.f99g;
            int i8 = i7 + 1;
            this.f102a[i7] = aVar2.f100h;
            if (aVar2.f101i != null) {
                int size = aVar2.f101i.size();
                int i9 = i8 + 1;
                this.f102a[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.f102a[i9] = aVar2.f101i.get(i10).f164p;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.f102a[i8] = 0;
            }
        }
        this.f103b = backStackRecord.f64j;
        this.f104c = backStackRecord.f65k;
        this.f105d = backStackRecord.f68n;
        this.f106e = backStackRecord.f70p;
        this.f107f = backStackRecord.f71q;
        this.f108g = backStackRecord.f72r;
        this.f109h = backStackRecord.f73s;
        this.f110i = backStackRecord.f74t;
        this.f111j = backStackRecord.f75u;
        this.f112k = backStackRecord.f76v;
    }

    public BackStackState(Parcel parcel) {
        this.f102a = parcel.createIntArray();
        this.f103b = parcel.readInt();
        this.f104c = parcel.readInt();
        this.f105d = parcel.readString();
        this.f106e = parcel.readInt();
        this.f107f = parcel.readInt();
        this.f108g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f109h = parcel.readInt();
        this.f110i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f111j = parcel.createStringArrayList();
        this.f112k = parcel.createStringArrayList();
    }

    /* renamed from: a */
    public BackStackRecord mo162a(C2004v vVar) {
        BackStackRecord backStackRecord = new BackStackRecord(vVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f102a.length) {
            BackStackRecord.C0046a aVar = new BackStackRecord.C0046a();
            int i3 = i2 + 1;
            aVar.f95c = this.f102a[i2];
            if (C2004v.f7289a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.f102a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f102a[i3];
            if (i5 >= 0) {
                aVar.f96d = vVar.f7295f.get(i5);
            } else {
                aVar.f96d = null;
            }
            int i6 = i4 + 1;
            aVar.f97e = this.f102a[i4];
            int i7 = i6 + 1;
            aVar.f98f = this.f102a[i6];
            int i8 = i7 + 1;
            aVar.f99g = this.f102a[i7];
            int i9 = i8 + 1;
            aVar.f100h = this.f102a[i8];
            int i10 = i9 + 1;
            int i11 = this.f102a[i9];
            if (i11 > 0) {
                aVar.f101i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (C2004v.f7289a) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.f102a[i10]);
                    }
                    aVar.f101i.add(vVar.f7295f.get(this.f102a[i10]));
                    i12++;
                    i10++;
                }
            }
            backStackRecord.mo122a(aVar);
            i++;
            i2 = i10;
        }
        backStackRecord.f64j = this.f103b;
        backStackRecord.f65k = this.f104c;
        backStackRecord.f68n = this.f105d;
        backStackRecord.f70p = this.f106e;
        backStackRecord.f66l = true;
        backStackRecord.f71q = this.f107f;
        backStackRecord.f72r = this.f108g;
        backStackRecord.f73s = this.f109h;
        backStackRecord.f74t = this.f110i;
        backStackRecord.f75u = this.f111j;
        backStackRecord.f76v = this.f112k;
        backStackRecord.mo121a(1);
        return backStackRecord;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f102a);
        parcel.writeInt(this.f103b);
        parcel.writeInt(this.f104c);
        parcel.writeString(this.f105d);
        parcel.writeInt(this.f106e);
        parcel.writeInt(this.f107f);
        TextUtils.writeToParcel(this.f108g, parcel, 0);
        parcel.writeInt(this.f109h);
        TextUtils.writeToParcel(this.f110i, parcel, 0);
        parcel.writeStringList(this.f111j);
        parcel.writeStringList(this.f112k);
    }
}
