package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0411dm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.common.data.d */
public final class C0140d implements SafeParcelable {
    public static final C0143e CREATOR = new C0143e();

    /* renamed from: ju */
    private static final C0142a f374ju = new C0142a(new String[0], (String) null) {
    };

    /* renamed from: iC */
    private final int f375iC;

    /* renamed from: iM */
    private final int f376iM;

    /* renamed from: jm */
    private final String[] f377jm;

    /* renamed from: jn */
    Bundle f378jn;

    /* renamed from: jo */
    private final CursorWindow[] f379jo;

    /* renamed from: jp */
    private final Bundle f380jp;

    /* renamed from: jq */
    int[] f381jq;

    /* renamed from: jr */
    int f382jr;

    /* renamed from: js */
    private Object f383js;

    /* renamed from: jt */
    private boolean f384jt;
    boolean mClosed;

    /* renamed from: com.google.android.gms.common.data.d$a */
    public static class C0142a {
        /* access modifiers changed from: private */

        /* renamed from: jm */
        public final String[] f385jm;
        /* access modifiers changed from: private */

        /* renamed from: jv */
        public final ArrayList<HashMap<String, Object>> f386jv;

        /* renamed from: jw */
        private final String f387jw;

        /* renamed from: jx */
        private final HashMap<Object, Integer> f388jx;

        /* renamed from: jy */
        private boolean f389jy;

        /* renamed from: jz */
        private String f390jz;

        private C0142a(String[] strArr, String str) {
            this.f385jm = (String[]) C0411dm.m944e(strArr);
            this.f386jv = new ArrayList<>();
            this.f387jw = str;
            this.f388jx = new HashMap<>();
            this.f389jy = false;
            this.f390jz = null;
        }
    }

    C0140d(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.f384jt = true;
        this.f376iM = i;
        this.f377jm = strArr;
        this.f379jo = cursorWindowArr;
        this.f375iC = i2;
        this.f380jp = bundle;
    }

    private C0140d(C0142a aVar, int i, Bundle bundle) {
        this(aVar.f385jm, m243a(aVar), i, bundle);
    }

    public C0140d(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.f384jt = true;
        this.f376iM = 1;
        this.f377jm = (String[]) C0411dm.m944e(strArr);
        this.f379jo = (CursorWindow[]) C0411dm.m944e(cursorWindowArr);
        this.f375iC = i;
        this.f380jp = bundle;
        mo3596aJ();
    }

    /* renamed from: a */
    public static C0140d m242a(int i, Bundle bundle) {
        return new C0140d(f374ju, i, bundle);
    }

    /* renamed from: a */
    private static CursorWindow[] m243a(C0142a aVar) {
        int i;
        int i2;
        int i3;
        CursorWindow cursorWindow;
        if (aVar.f385jm.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList c = aVar.f386jv;
        int size = c.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(aVar.f385jm.length);
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i4 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setNumColumns(aVar.f385jm.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                    i = 0;
                } else {
                    i = i5;
                }
                Map map = (Map) c.get(i4);
                boolean z = true;
                for (int i6 = 0; i6 < aVar.f385jm.length && z; i6++) {
                    String str = aVar.f385jm[i6];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow2.putNull(i, i6);
                    } else if (obj instanceof String) {
                        z = cursorWindow2.putString((String) obj, i, i6);
                    } else if (obj instanceof Long) {
                        z = cursorWindow2.putLong(((Long) obj).longValue(), i, i6);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i, i6);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i, i6);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow2.putBlob((byte[]) obj, i, i6);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (!z) {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i4 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setNumColumns(aVar.f385jm.length);
                    arrayList.add(cursorWindow3);
                    i3 = i4 - 1;
                    cursorWindow = cursorWindow3;
                    i2 = 0;
                } else {
                    i2 = i + 1;
                    i3 = i4;
                    cursorWindow = cursorWindow2;
                }
                cursorWindow2 = cursorWindow;
                i4 = i3 + 1;
                i5 = i2;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    ((CursorWindow) arrayList.get(i7)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    /* renamed from: b */
    private void m244b(String str, int i) {
        if (this.f378jn == null || !this.f378jn.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f382jr) {
            throw new CursorIndexOutOfBoundsException(i, this.f382jr);
        }
    }

    /* renamed from: r */
    public static C0140d m245r(int i) {
        return m242a(i, (Bundle) null);
    }

    /* renamed from: a */
    public long mo3594a(String str, int i, int i2) {
        m244b(str, i);
        return this.f379jo[i2].getLong(i - this.f381jq[i2], this.f378jn.getInt(str));
    }

    /* renamed from: a */
    public void mo3595a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m244b(str, i);
        this.f379jo[i2].copyStringToBuffer(i - this.f381jq[i2], this.f378jn.getInt(str), charArrayBuffer);
    }

    /* renamed from: aJ */
    public void mo3596aJ() {
        this.f378jn = new Bundle();
        for (int i = 0; i < this.f377jm.length; i++) {
            this.f378jn.putInt(this.f377jm[i], i);
        }
        this.f381jq = new int[this.f379jo.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f379jo.length; i3++) {
            this.f381jq[i3] = i2;
            i2 += this.f379jo[i3].getNumRows();
        }
        this.f382jr = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aK */
    public String[] mo3597aK() {
        return this.f377jm;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aL */
    public CursorWindow[] mo3598aL() {
        return this.f379jo;
    }

    /* renamed from: aM */
    public Bundle mo3599aM() {
        return this.f380jp;
    }

    /* renamed from: b */
    public int mo3600b(String str, int i, int i2) {
        m244b(str, i);
        return this.f379jo[i2].getInt(i - this.f381jq[i2], this.f378jn.getInt(str));
    }

    /* renamed from: b */
    public void mo3601b(Object obj) {
        this.f383js = obj;
    }

    /* renamed from: c */
    public String mo3602c(String str, int i, int i2) {
        m244b(str, i);
        return this.f379jo[i2].getString(i - this.f381jq[i2], this.f378jn.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.f379jo) {
                    close.close();
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo3604d(String str, int i, int i2) {
        m244b(str, i);
        return Long.valueOf(this.f379jo[i2].getLong(i - this.f381jq[i2], this.f378jn.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public byte[] mo3606e(String str, int i, int i2) {
        m244b(str, i);
        return this.f379jo[i2].getBlob(i - this.f381jq[i2], this.f378jn.getInt(str));
    }

    /* renamed from: f */
    public Uri mo3607f(String str, int i, int i2) {
        String c = mo3602c(str, i, i2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f384jt && this.f379jo.length > 0 && !isClosed()) {
                Log.e("DataHolder", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.f383js == null ? "internal object: " + toString() : this.f383js.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: g */
    public boolean mo3609g(String str, int i, int i2) {
        m244b(str, i);
        return this.f379jo[i2].isNull(i - this.f381jq[i2], this.f378jn.getInt(str));
    }

    public int getCount() {
        return this.f382jr;
    }

    public int getStatusCode() {
        return this.f375iC;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f376iM;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    /* renamed from: q */
    public int mo3614q(int i) {
        int i2 = 0;
        C0411dm.m945k(i >= 0 && i < this.f382jr);
        while (true) {
            if (i2 >= this.f381jq.length) {
                break;
            } else if (i < this.f381jq[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f381jq.length ? i2 - 1 : i2;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0143e.m262a(this, dest, flags);
    }
}
