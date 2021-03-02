package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* renamed from: a */
    final int[] f333a;

    /* renamed from: b */
    final int f334b;

    /* renamed from: c */
    final int f335c;

    /* renamed from: d */
    final String f336d;

    /* renamed from: e */
    final int f337e;

    /* renamed from: f */
    final int f338f;

    /* renamed from: g */
    final CharSequence f339g;

    /* renamed from: h */
    final int f340h;

    /* renamed from: i */
    final CharSequence f341i;

    /* renamed from: j */
    final ArrayList<String> f342j;

    /* renamed from: k */
    final ArrayList<String> f343k;

    public BackStackState(Parcel parcel) {
        this.f333a = parcel.createIntArray();
        this.f334b = parcel.readInt();
        this.f335c = parcel.readInt();
        this.f336d = parcel.readString();
        this.f337e = parcel.readInt();
        this.f338f = parcel.readInt();
        this.f339g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f340h = parcel.readInt();
        this.f341i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f342j = parcel.createStringArrayList();
        this.f343k = parcel.createStringArrayList();
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int i = 0;
        for (BackStackRecord.C0093Op op = backStackRecord.f288c; op != null; op = op.f323a) {
            if (op.f331i != null) {
                i += op.f331i.size();
            }
        }
        this.f333a = new int[(i + (backStackRecord.f290e * 7))];
        if (!backStackRecord.f297l) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (BackStackRecord.C0093Op op2 = backStackRecord.f288c; op2 != null; op2 = op2.f323a) {
            int i3 = i2 + 1;
            this.f333a[i2] = op2.f325c;
            int i4 = i3 + 1;
            this.f333a[i3] = op2.f326d != null ? op2.f326d.f399p : -1;
            int i5 = i4 + 1;
            this.f333a[i4] = op2.f327e;
            int i6 = i5 + 1;
            this.f333a[i5] = op2.f328f;
            int i7 = i6 + 1;
            this.f333a[i6] = op2.f329g;
            int i8 = i7 + 1;
            this.f333a[i7] = op2.f330h;
            if (op2.f331i != null) {
                int size = op2.f331i.size();
                int i9 = i8 + 1;
                this.f333a[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.f333a[i9] = op2.f331i.get(i10).f399p;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.f333a[i8] = 0;
            }
        }
        this.f334b = backStackRecord.f295j;
        this.f335c = backStackRecord.f296k;
        this.f336d = backStackRecord.f299n;
        this.f337e = backStackRecord.f301p;
        this.f338f = backStackRecord.f302q;
        this.f339g = backStackRecord.f303r;
        this.f340h = backStackRecord.f304s;
        this.f341i = backStackRecord.f305t;
        this.f342j = backStackRecord.f306u;
        this.f343k = backStackRecord.f307v;
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f333a.length) {
            BackStackRecord.C0093Op op = new BackStackRecord.C0093Op();
            int i3 = i2 + 1;
            op.f325c = this.f333a[i2];
            if (FragmentManagerImpl.f439a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.f333a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f333a[i3];
            if (i5 >= 0) {
                op.f326d = fragmentManagerImpl.f445f.get(i5);
            } else {
                op.f326d = null;
            }
            int i6 = i4 + 1;
            op.f327e = this.f333a[i4];
            int i7 = i6 + 1;
            op.f328f = this.f333a[i6];
            int i8 = i7 + 1;
            op.f329g = this.f333a[i7];
            int i9 = i8 + 1;
            op.f330h = this.f333a[i8];
            int i10 = i9 + 1;
            int i11 = this.f333a[i9];
            if (i11 > 0) {
                op.f331i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (FragmentManagerImpl.f439a) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.f333a[i10]);
                    }
                    op.f331i.add(fragmentManagerImpl.f445f.get(this.f333a[i10]));
                    i12++;
                    i10++;
                }
            }
            backStackRecord.mo414a(op);
            i++;
            i2 = i10;
        }
        backStackRecord.f295j = this.f334b;
        backStackRecord.f296k = this.f335c;
        backStackRecord.f299n = this.f336d;
        backStackRecord.f301p = this.f337e;
        backStackRecord.f297l = true;
        backStackRecord.f302q = this.f338f;
        backStackRecord.f303r = this.f339g;
        backStackRecord.f304s = this.f340h;
        backStackRecord.f305t = this.f341i;
        backStackRecord.f306u = this.f342j;
        backStackRecord.f307v = this.f343k;
        backStackRecord.mo413a(1);
        return backStackRecord;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f333a);
        parcel.writeInt(this.f334b);
        parcel.writeInt(this.f335c);
        parcel.writeString(this.f336d);
        parcel.writeInt(this.f337e);
        parcel.writeInt(this.f338f);
        TextUtils.writeToParcel(this.f339g, parcel, 0);
        parcel.writeInt(this.f340h);
        TextUtils.writeToParcel(this.f341i, parcel, 0);
        parcel.writeStringList(this.f342j);
        parcel.writeStringList(this.f343k);
    }
}
