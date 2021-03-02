package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final C0299f CREATOR = new C0299f();

    /* renamed from: Kc */
    private static final C0293a f668Kc = new C0293a(new String[0], (String) null) {
    };

    /* renamed from: BR */
    private final int f669BR;

    /* renamed from: HF */
    private final int f670HF;

    /* renamed from: JU */
    private final String[] f671JU;

    /* renamed from: JV */
    Bundle f672JV;

    /* renamed from: JW */
    private final CursorWindow[] f673JW;

    /* renamed from: JX */
    private final Bundle f674JX;

    /* renamed from: JY */
    int[] f675JY;

    /* renamed from: JZ */
    int f676JZ;

    /* renamed from: Ka */
    private Object f677Ka;

    /* renamed from: Kb */
    private boolean f678Kb;
    boolean mClosed;

    /* renamed from: com.google.android.gms.common.data.DataHolder$a */
    public static class C0293a {
        /* access modifiers changed from: private */

        /* renamed from: JU */
        public final String[] f679JU;
        /* access modifiers changed from: private */

        /* renamed from: Kd */
        public final ArrayList<HashMap<String, Object>> f680Kd;

        /* renamed from: Ke */
        private final String f681Ke;

        /* renamed from: Kf */
        private final HashMap<Object, Integer> f682Kf;

        /* renamed from: Kg */
        private boolean f683Kg;

        /* renamed from: Kh */
        private String f684Kh;

        private C0293a(String[] strArr, String str) {
            this.f679JU = (String[]) C0348n.m861i(strArr);
            this.f680Kd = new ArrayList<>();
            this.f681Ke = str;
            this.f682Kf = new HashMap<>();
            this.f683Kg = false;
            this.f684Kh = null;
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.f678Kb = true;
        this.f669BR = versionCode;
        this.f671JU = columns;
        this.f673JW = windows;
        this.f670HF = statusCode;
        this.f674JX = metadata;
    }

    private DataHolder(C0293a builder, int statusCode, Bundle metadata) {
        this(builder.f679JU, m592a(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.f678Kb = true;
        this.f669BR = 1;
        this.f671JU = (String[]) C0348n.m861i(columns);
        this.f673JW = (CursorWindow[]) C0348n.m861i(windows);
        this.f670HF = statusCode;
        this.f674JX = metadata;
        mo4315gB();
    }

    /* renamed from: a */
    public static DataHolder m591a(int i, Bundle bundle) {
        return new DataHolder(f668Kc, i, bundle);
    }

    /* renamed from: a */
    private static CursorWindow[] m592a(C0293a aVar, int i) {
        int i2;
        int i3;
        int i4;
        CursorWindow cursorWindow;
        if (aVar.f679JU.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList b = (i < 0 || i >= aVar.f680Kd.size()) ? aVar.f680Kd : aVar.f680Kd.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(aVar.f679JU.length);
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i5 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i5);
                    cursorWindow2.setNumColumns(aVar.f679JU.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                    i2 = 0;
                } else {
                    i2 = i6;
                }
                Map map = (Map) b.get(i5);
                boolean z = true;
                for (int i7 = 0; i7 < aVar.f679JU.length && z; i7++) {
                    String str = aVar.f679JU[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow2.putNull(i2, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow2.putString((String) obj, i2, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow2.putLong(((Long) obj).longValue(), i2, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i2, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i2, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow2.putBlob((byte[]) obj, i2, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i2, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (!z) {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i5 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setNumColumns(aVar.f679JU.length);
                    arrayList.add(cursorWindow3);
                    i4 = i5 - 1;
                    cursorWindow = cursorWindow3;
                    i3 = 0;
                } else {
                    i3 = i2 + 1;
                    i4 = i5;
                    cursorWindow = cursorWindow2;
                }
                cursorWindow2 = cursorWindow;
                i5 = i4 + 1;
                i6 = i3;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    ((CursorWindow) arrayList.get(i8)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    /* renamed from: as */
    public static DataHolder m593as(int i) {
        return m591a(i, (Bundle) null);
    }

    /* renamed from: g */
    private void m594g(String str, int i) {
        if (this.f672JV == null || !this.f672JV.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f676JZ) {
            throw new CursorIndexOutOfBoundsException(i, this.f676JZ);
        }
    }

    /* renamed from: a */
    public long mo4301a(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].getLong(i, this.f672JV.getInt(str));
    }

    /* renamed from: a */
    public void mo4302a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m594g(str, i);
        this.f673JW[i2].copyStringToBuffer(i, this.f672JV.getInt(str), charArrayBuffer);
    }

    /* renamed from: aQ */
    public boolean mo4303aQ(String str) {
        return this.f672JV.containsKey(str);
    }

    /* renamed from: ar */
    public int mo4304ar(int i) {
        int i2 = 0;
        C0348n.m850I(i >= 0 && i < this.f676JZ);
        while (true) {
            if (i2 >= this.f675JY.length) {
                break;
            } else if (i < this.f675JY[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f675JY.length ? i2 - 1 : i2;
    }

    /* renamed from: b */
    public int mo4305b(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].getInt(i, this.f672JV.getInt(str));
    }

    /* renamed from: c */
    public String mo4306c(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].getString(i, this.f672JV.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.f673JW) {
                    close.close();
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo4308d(String str, int i, int i2) {
        m594g(str, i);
        return Long.valueOf(this.f673JW[i2].getLong(i, this.f672JV.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public float mo4310e(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].getFloat(i, this.f672JV.getInt(str));
    }

    /* renamed from: e */
    public void mo4311e(Object obj) {
        this.f677Ka = obj;
    }

    /* renamed from: f */
    public byte[] mo4312f(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].getBlob(i, this.f672JV.getInt(str));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f678Kb && this.f673JW.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.f677Ka == null ? "internal object: " + toString() : this.f677Ka.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: g */
    public Uri mo4314g(String str, int i, int i2) {
        String c = mo4306c(str, i, i2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }

    /* renamed from: gB */
    public void mo4315gB() {
        this.f672JV = new Bundle();
        for (int i = 0; i < this.f671JU.length; i++) {
            this.f672JV.putInt(this.f671JU[i], i);
        }
        this.f675JY = new int[this.f673JW.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f673JW.length; i3++) {
            this.f675JY[i3] = i2;
            i2 += this.f673JW[i3].getNumRows() - (i2 - this.f673JW[i3].getStartPosition());
        }
        this.f676JZ = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gC */
    public String[] mo4316gC() {
        return this.f671JU;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gD */
    public CursorWindow[] mo4317gD() {
        return this.f673JW;
    }

    public int getCount() {
        return this.f676JZ;
    }

    public int getStatusCode() {
        return this.f670HF;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f669BR;
    }

    /* renamed from: gz */
    public Bundle mo4321gz() {
        return this.f674JX;
    }

    /* renamed from: h */
    public boolean mo4322h(String str, int i, int i2) {
        m594g(str, i);
        return this.f673JW[i2].isNull(i, this.f672JV.getInt(str));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0299f.m627a(this, dest, flags);
    }
}
