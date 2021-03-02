package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0359b {
    /* renamed from: A */
    private static int m661A(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: B */
    private static void m662B(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: C */
    public static void m663C(Parcel parcel, int i) {
        m662B(parcel, i);
    }

    /* renamed from: a */
    public static void m664a(Parcel parcel, int i, byte b) {
        m680b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m665a(Parcel parcel, int i, double d) {
        m680b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m666a(Parcel parcel, int i, float f) {
        m680b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m667a(Parcel parcel, int i, long j) {
        m680b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m668a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int A = m661A(parcel, i);
            parcel.writeBundle(bundle);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m669a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int A = m661A(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m670a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int A = m661A(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m671a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int A = m661A(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m672a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int A = m661A(parcel, i);
            parcel.writeString(str);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m673a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int A = m661A(parcel, i);
            parcel.writeStringList(list);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m674a(Parcel parcel, int i, short s) {
        m680b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m675a(Parcel parcel, int i, boolean z) {
        m680b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m676a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int A = m661A(parcel, i);
            parcel.writeByteArray(bArr);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m677a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int A = m661A(parcel, i);
            parcel.writeInt(r3);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m679a(parcel, t, i2);
                }
            }
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m678a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int A = m661A(parcel, i);
            parcel.writeStringArray(strArr);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m679a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: b */
    private static void m680b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static <T extends Parcelable> void m681b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int A = m661A(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m679a(parcel, parcelable, 0);
                }
            }
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    public static void m682c(Parcel parcel, int i, int i2) {
        m680b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static void m683c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int A = m661A(parcel, i);
            parcel.writeList(list);
            m662B(parcel, A);
        } else if (z) {
            m680b(parcel, i, 0);
        }
    }

    /* renamed from: d */
    public static int m684d(Parcel parcel) {
        return m661A(parcel, 20293);
    }
}
