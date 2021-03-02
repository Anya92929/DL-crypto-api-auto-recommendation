package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0621s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.common.data.d */
public final class C0344d implements SafeParcelable {
    public static final C0347e CREATOR = new C0347e();

    /* renamed from: Z */
    private static final HashMap<CursorWindow, Throwable> f800Z = null;

    /* renamed from: aa */
    private static final Object f801aa = new Object();

    /* renamed from: ai */
    private static final C0346a f802ai = new C0346a(new String[0], (String) null) {
    };

    /* renamed from: ab */
    private final int f803ab;

    /* renamed from: ac */
    private final String[] f804ac;

    /* renamed from: ad */
    Bundle f805ad;

    /* renamed from: ae */
    private final CursorWindow[] f806ae;

    /* renamed from: af */
    private final Bundle f807af;

    /* renamed from: ag */
    int[] f808ag;

    /* renamed from: ah */
    int f809ah;
    boolean mClosed;

    /* renamed from: p */
    private final int f810p;

    /* renamed from: com.google.android.gms.common.data.d$a */
    public static class C0346a {
        /* access modifiers changed from: private */

        /* renamed from: ac */
        public final String[] f811ac;
        /* access modifiers changed from: private */

        /* renamed from: aj */
        public final ArrayList<HashMap<String, Object>> f812aj;

        /* renamed from: ak */
        private final String f813ak;

        /* renamed from: al */
        private final HashMap<Object, Integer> f814al;

        /* renamed from: am */
        private boolean f815am;

        /* renamed from: an */
        private String f816an;

        private C0346a(String[] strArr, String str) {
            this.f811ac = (String[]) C0621s.m1890d(strArr);
            this.f812aj = new ArrayList<>();
            this.f813ak = str;
            this.f814al = new HashMap<>();
            this.f815am = false;
            this.f816an = null;
        }
    }

    C0344d(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.f803ab = i;
        this.f804ac = strArr;
        this.f806ae = cursorWindowArr;
        this.f810p = i2;
        this.f807af = bundle;
    }

    private C0344d(C0346a aVar, int i, Bundle bundle) {
        this(aVar.f811ac, m567a(aVar), i, bundle);
    }

    public C0344d(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.f803ab = 1;
        this.f804ac = (String[]) C0621s.m1890d(strArr);
        this.f806ae = (CursorWindow[]) C0621s.m1890d(cursorWindowArr);
        this.f810p = i;
        this.f807af = bundle;
        mo4060h();
    }

    /* renamed from: a */
    public static C0344d m564a(int i, Bundle bundle) {
        return new C0344d(f802ai, i, bundle);
    }

    /* renamed from: a */
    private static void m565a(CursorWindow cursorWindow) {
    }

    /* renamed from: a */
    private void m566a(String str, int i) {
        if (this.f805ad == null || !this.f805ad.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f809ah) {
            throw new CursorIndexOutOfBoundsException(i, this.f809ah);
        }
    }

    /* renamed from: a */
    private static CursorWindow[] m567a(C0346a aVar) {
        if (aVar.f811ac.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList c = aVar.f812aj;
        int size = c.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        CursorWindow[] cursorWindowArr = {cursorWindow};
        cursorWindow.setNumColumns(aVar.f811ac.length);
        int i = 0;
        while (i < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    throw new RuntimeException("Cursor window out of memory");
                }
                Map map = (Map) c.get(i);
                for (int i2 = 0; i2 < aVar.f811ac.length; i2++) {
                    String str = aVar.f811ac[i2];
                    Object obj = map.get(str);
                    if (obj == null) {
                        cursorWindow.putNull(i, i2);
                    } else if (obj instanceof String) {
                        cursorWindow.putString((String) obj, i, i2);
                    } else if (obj instanceof Long) {
                        cursorWindow.putLong(((Long) obj).longValue(), i, i2);
                    } else if (obj instanceof Integer) {
                        cursorWindow.putLong((long) ((Integer) obj).intValue(), i, i2);
                    } else if (obj instanceof Boolean) {
                        cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i, i2);
                    } else if (obj instanceof byte[]) {
                        cursorWindow.putBlob((byte[]) obj, i, i2);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                i++;
            } catch (RuntimeException e) {
                cursorWindow.close();
                throw e;
            }
        }
        return cursorWindowArr;
    }

    /* renamed from: f */
    public static C0344d m568f(int i) {
        return m564a(i, (Bundle) null);
    }

    /* renamed from: a */
    public long mo4047a(String str, int i, int i2) {
        m566a(str, i);
        return this.f806ae[i2].getLong(i - this.f808ag[i2], this.f805ad.getInt(str));
    }

    /* renamed from: a */
    public void mo4048a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m566a(str, i);
        this.f806ae[i2].copyStringToBuffer(i - this.f808ag[i2], this.f805ad.getInt(str), charArrayBuffer);
    }

    /* renamed from: b */
    public int mo4049b(String str, int i, int i2) {
        m566a(str, i);
        return this.f806ae[i2].getInt(i - this.f808ag[i2], this.f805ad.getInt(str));
    }

    /* renamed from: c */
    public String mo4050c(String str, int i, int i2) {
        m566a(str, i);
        return this.f806ae[i2].getString(i - this.f808ag[i2], this.f805ad.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (int i = 0; i < this.f806ae.length; i++) {
                    this.f806ae[i].close();
                    m565a(this.f806ae[i]);
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo4052d(String str, int i, int i2) {
        m566a(str, i);
        return Long.valueOf(this.f806ae[i2].getLong(i - this.f808ag[i2], this.f805ad.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int mo4054e(int i) {
        int i2 = 0;
        C0621s.m1884a(i >= 0 && i < this.f809ah);
        while (true) {
            if (i2 >= this.f808ag.length) {
                break;
            } else if (i < this.f808ag[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f808ag.length ? i2 - 1 : i2;
    }

    /* renamed from: e */
    public byte[] mo4055e(String str, int i, int i2) {
        m566a(str, i);
        return this.f806ae[i2].getBlob(i - this.f808ag[i2], this.f805ad.getInt(str));
    }

    /* renamed from: f */
    public Uri mo4056f(String str, int i, int i2) {
        String c = mo4050c(str, i, i2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }

    /* renamed from: g */
    public boolean mo4057g(String str, int i, int i2) {
        m566a(str, i);
        return this.f806ae[i2].isNull(i - this.f808ag[i2], this.f805ad.getInt(str));
    }

    public int getCount() {
        return this.f809ah;
    }

    public int getStatusCode() {
        return this.f810p;
    }

    /* renamed from: h */
    public void mo4060h() {
        this.f805ad = new Bundle();
        for (int i = 0; i < this.f804ac.length; i++) {
            this.f805ad.putInt(this.f804ac[i], i);
        }
        this.f808ag = new int[this.f806ae.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f806ae.length; i3++) {
            this.f808ag[i3] = i2;
            i2 += this.f806ae[i3].getNumRows();
        }
        this.f809ah = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo4061i() {
        return this.f803ab;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String[] mo4063j() {
        return this.f804ac;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public CursorWindow[] mo4064k() {
        return this.f806ae;
    }

    /* renamed from: l */
    public Bundle mo4065l() {
        return this.f807af;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0347e.m585a(this, dest, flags);
    }
}
