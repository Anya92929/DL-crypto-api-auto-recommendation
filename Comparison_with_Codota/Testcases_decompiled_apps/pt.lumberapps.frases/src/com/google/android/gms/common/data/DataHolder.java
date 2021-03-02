package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator CREATOR = new zze();

    /* renamed from: k */
    private static final zza f4372k = new C1346a(new String[0], (String) null);

    /* renamed from: a */
    Bundle f4373a;

    /* renamed from: b */
    int[] f4374b;

    /* renamed from: c */
    int f4375c;

    /* renamed from: d */
    boolean f4376d;

    /* renamed from: e */
    private final int f4377e;

    /* renamed from: f */
    private final String[] f4378f;

    /* renamed from: g */
    private final CursorWindow[] f4379g;

    /* renamed from: h */
    private final int f4380h;

    /* renamed from: i */
    private final Bundle f4381i;

    /* renamed from: j */
    private boolean f4382j;

    public class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String[] f4383a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final ArrayList f4384b;

        /* renamed from: c */
        private final String f4385c;

        /* renamed from: d */
        private final HashMap f4386d;

        /* renamed from: e */
        private boolean f4387e;

        /* renamed from: f */
        private String f4388f;

        private zza(String[] strArr, String str) {
            this.f4383a = (String[]) zzab.zzy(strArr);
            this.f4384b = new ArrayList();
            this.f4385c = str;
            this.f4386d = new HashMap();
            this.f4387e = false;
            this.f4388f = null;
        }

        /* synthetic */ zza(String[] strArr, String str, C1346a aVar) {
            this(strArr, str);
        }

        /* renamed from: a */
        private int m5996a(HashMap hashMap) {
            if (this.f4385c == null) {
                return -1;
            }
            Object obj = hashMap.get(this.f4385c);
            if (obj == null) {
                return -1;
            }
            Integer num = (Integer) this.f4386d.get(obj);
            if (num != null) {
                return num.intValue();
            }
            this.f4386d.put(obj, Integer.valueOf(this.f4384b.size()));
            return -1;
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzb.zzu(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zza(hashMap);
        }

        public zza zza(HashMap hashMap) {
            com.google.android.gms.common.internal.zzb.zzu(hashMap);
            int a = m5996a(hashMap);
            if (a == -1) {
                this.f4384b.add(hashMap);
            } else {
                this.f4384b.remove(a);
                this.f4384b.add(a, hashMap);
            }
            this.f4387e = false;
            return this;
        }

        public DataHolder zzfu(int i) {
            return new DataHolder(this, i, (Bundle) null, (C1346a) null);
        }
    }

    public class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f4376d = false;
        this.f4382j = true;
        this.f4377e = i;
        this.f4378f = strArr;
        this.f4379g = cursorWindowArr;
        this.f4380h = i2;
        this.f4381i = bundle;
    }

    private DataHolder(zza zza2, int i, Bundle bundle) {
        this(zza2.f4383a, m5992a(zza2, -1), i, bundle);
    }

    /* synthetic */ DataHolder(zza zza2, int i, Bundle bundle, C1346a aVar) {
        this(zza2, i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.f4376d = false;
        this.f4382j = true;
        this.f4377e = 1;
        this.f4378f = (String[]) zzab.zzy(strArr);
        this.f4379g = (CursorWindow[]) zzab.zzy(cursorWindowArr);
        this.f4380h = i;
        this.f4381i = bundle;
        zzarh();
    }

    /* renamed from: a */
    private void m5991a(String str, int i) {
        if (this.f4373a == null || !this.f4373a.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f4375c) {
            throw new CursorIndexOutOfBoundsException(i, this.f4375c);
        }
    }

    /* renamed from: a */
    private static CursorWindow[] m5992a(zza zza2, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zza2.f4383a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList b = (i < 0 || i >= zza2.f4384b.size()) ? zza2.f4384b : zza2.f4384b.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zza2.f4383a.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i3).append(")").toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza2.f4383a.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) b.get(i3);
                boolean z3 = true;
                for (int i4 = 0; i4 < zza2.f4383a.length && z3; i4++) {
                    String str = zza2.f4383a[i4];
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
                        String valueOf = String.valueOf(obj);
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                    }
                }
                if (z3) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else if (z2) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", new StringBuilder(74).append("Couldn't populate window data for row ").append(i3).append(" - allocating new window.").toString());
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zza2.f4383a.length);
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
        return new DataHolder(f4372k, i, bundle);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr, (String) null, (C1346a) null);
    }

    public static DataHolder zzft(int i) {
        return zza(i, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6427a() {
        return this.f4377e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String[] mo6428b() {
        return this.f4378f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public CursorWindow[] mo6429c() {
        return this.f4379g;
    }

    public void close() {
        synchronized (this) {
            if (!this.f4376d) {
                this.f4376d = true;
                for (CursorWindow close : this.f4379g) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.f4382j && this.f4379g.length > 0 && !isClosed()) {
                close();
                String valueOf = String.valueOf(toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(valueOf).append(")").toString());
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.f4375c;
    }

    public int getStatusCode() {
        return this.f4380h;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f4376d;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m6001a(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m5991a(str, i);
        this.f4379g[i2].copyStringToBuffer(i, this.f4373a.getInt(str), charArrayBuffer);
    }

    public Bundle zzarc() {
        return this.f4381i;
    }

    public void zzarh() {
        this.f4373a = new Bundle();
        for (int i = 0; i < this.f4378f.length; i++) {
            this.f4373a.putInt(this.f4378f[i], i);
        }
        this.f4374b = new int[this.f4379g.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4379g.length; i3++) {
            this.f4374b[i3] = i2;
            i2 += this.f4379g[i3].getNumRows() - (i2 - this.f4379g[i3].getStartPosition());
        }
        this.f4375c = i2;
    }

    public long zzb(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].getLong(i, this.f4373a.getInt(str));
    }

    public int zzc(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].getInt(i, this.f4373a.getInt(str));
    }

    public String zzd(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].getString(i, this.f4373a.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        m5991a(str, i);
        return Long.valueOf(this.f4379g[i2].getLong(i, this.f4373a.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].getFloat(i, this.f4373a.getInt(str));
    }

    public int zzfs(int i) {
        int i2 = 0;
        zzab.zzbn(i >= 0 && i < this.f4375c);
        while (true) {
            if (i2 >= this.f4374b.length) {
                break;
            } else if (i < this.f4374b[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f4374b.length ? i2 - 1 : i2;
    }

    public byte[] zzg(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].getBlob(i, this.f4373a.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzhe(String str) {
        return this.f4373a.containsKey(str);
    }

    public boolean zzi(String str, int i, int i2) {
        m5991a(str, i);
        return this.f4379g[i2].isNull(i, this.f4373a.getInt(str));
    }
}
