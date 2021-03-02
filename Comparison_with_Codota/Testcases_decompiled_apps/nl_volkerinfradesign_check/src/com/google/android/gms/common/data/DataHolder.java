package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: l */
    private static final zza f2835l = new zza(new String[0], (String) null) {
    };

    /* renamed from: a */
    Bundle f2836a;

    /* renamed from: b */
    int[] f2837b;

    /* renamed from: c */
    int f2838c;

    /* renamed from: d */
    boolean f2839d;

    /* renamed from: e */
    private final int f2840e;

    /* renamed from: f */
    private final String[] f2841f;

    /* renamed from: g */
    private final CursorWindow[] f2842g;

    /* renamed from: h */
    private final int f2843h;

    /* renamed from: i */
    private final Bundle f2844i;

    /* renamed from: j */
    private Object f2845j;

    /* renamed from: k */
    private boolean f2846k;

    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String[] f2847a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final ArrayList<HashMap<String, Object>> f2848b;

        /* renamed from: c */
        private final String f2849c;

        /* renamed from: d */
        private final HashMap<Object, Integer> f2850d;

        /* renamed from: e */
        private boolean f2851e;

        /* renamed from: f */
        private String f2852f;

        private zza(String[] strArr, String str) {
            this.f2847a = (String[]) zzx.zzz(strArr);
            this.f2848b = new ArrayList<>();
            this.f2849c = str;
            this.f2850d = new HashMap<>();
            this.f2851e = false;
            this.f2852f = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f2839d = false;
        this.f2846k = true;
        this.f2840e = i;
        this.f2841f = strArr;
        this.f2842g = cursorWindowArr;
        this.f2843h = i2;
        this.f2844i = bundle;
    }

    private DataHolder(zza zza2, int i, Bundle bundle) {
        this(zza2.f2847a, m3850a(zza2, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.f2839d = false;
        this.f2846k = true;
        this.f2840e = 1;
        this.f2841f = (String[]) zzx.zzz(strArr);
        this.f2842g = (CursorWindow[]) zzx.zzz(cursorWindowArr);
        this.f2843h = i;
        this.f2844i = bundle;
        zzqd();
    }

    /* renamed from: a */
    private void m3849a(String str, int i) {
        if (this.f2836a == null || !this.f2836a.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f2838c) {
            throw new CursorIndexOutOfBoundsException(i, this.f2838c);
        }
    }

    /* renamed from: a */
    private static CursorWindow[] m3850a(zza zza2, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zza2.f2847a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList b = (i < 0 || i >= zza2.f2848b.size()) ? zza2.f2848b : zza2.f2848b.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zza2.f2847a.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza2.f2847a.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) b.get(i3);
                boolean z3 = true;
                for (int i4 = 0; i4 < zza2.f2847a.length && z3; i4++) {
                    String str = zza2.f2847a[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z3 = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z3 = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z3 = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z3 = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z3 = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z3 = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z3 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else if (obj instanceof Float) {
                        z3 = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i3, i4);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z3) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else if (z2) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zza2.f2847a.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(f2835l, i, bundle);
    }

    public static DataHolder zzbI(int i) {
        return zza(i, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5272a() {
        return this.f2840e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String[] mo5273b() {
        return this.f2841f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public CursorWindow[] mo5274c() {
        return this.f2842g;
    }

    public void close() {
        synchronized (this) {
            if (!this.f2839d) {
                this.f2839d = true;
                for (CursorWindow close : this.f2842g) {
                    close.close();
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f2846k && this.f2842g.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.f2845j == null ? "internal object: " + toString() : this.f2845j.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.f2838c;
    }

    public int getStatusCode() {
        return this.f2843h;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f2839d;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m3857a(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m3849a(str, i);
        this.f2842g[i2].copyStringToBuffer(i, this.f2836a.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].getLong(i, this.f2836a.getInt(str));
    }

    public int zzbH(int i) {
        int i2 = 0;
        zzx.zzab(i >= 0 && i < this.f2838c);
        while (true) {
            if (i2 >= this.f2837b.length) {
                break;
            } else if (i < this.f2837b[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f2837b.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].getInt(i, this.f2836a.getInt(str));
    }

    public boolean zzcz(String str) {
        return this.f2836a.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].getString(i, this.f2836a.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        m3849a(str, i);
        return Long.valueOf(this.f2842g[i2].getLong(i, this.f2836a.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].getFloat(i, this.f2836a.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].getBlob(i, this.f2836a.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        m3849a(str, i);
        return this.f2842g[i2].isNull(i, this.f2836a.getInt(str));
    }

    public Bundle zzpZ() {
        return this.f2844i;
    }

    public void zzqd() {
        this.f2836a = new Bundle();
        for (int i = 0; i < this.f2841f.length; i++) {
            this.f2836a.putInt(this.f2841f[i], i);
        }
        this.f2837b = new int[this.f2842g.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2842g.length; i3++) {
            this.f2837b[i3] = i2;
            i2 += this.f2842g[i3].getNumRows() - (i2 - this.f2842g[i3].getStartPosition());
        }
        this.f2838c = i2;
    }

    public void zzu(Object obj) {
        this.f2845j = obj;
    }
}
