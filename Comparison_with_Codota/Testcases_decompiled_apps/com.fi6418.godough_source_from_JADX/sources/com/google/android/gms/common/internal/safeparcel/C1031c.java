package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.c */
public class C1031c {
    /* renamed from: a */
    public static int m4605a(Parcel parcel) {
        return m4623b(parcel, 20293);
    }

    /* renamed from: a */
    public static void m4606a(Parcel parcel, int i) {
        m4626c(parcel, i);
    }

    /* renamed from: a */
    public static void m4607a(Parcel parcel, int i, byte b) {
        m4624b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m4608a(Parcel parcel, int i, double d) {
        m4624b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m4609a(Parcel parcel, int i, float f) {
        m4624b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m4610a(Parcel parcel, int i, int i2) {
        m4624b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: a */
    public static void m4611a(Parcel parcel, int i, long j) {
        m4624b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m4612a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = m4623b(parcel, i);
            parcel.writeBundle(bundle);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4613a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = m4623b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4614a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = m4623b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4615a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m4624b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4616a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = m4623b(parcel, i);
            parcel.writeString(str);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4617a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int b = m4623b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m4618a(Parcel parcel, int i, short s) {
        m4624b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m4619a(Parcel parcel, int i, boolean z) {
        m4624b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m4620a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = m4623b(parcel, i);
            parcel.writeByteArray(bArr);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m4621a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = m4623b(parcel, i);
            parcel.writeInt(r3);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m4622a(parcel, t, i2);
                }
            }
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m4622a(Parcel parcel, T t, int i) {
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
    private static int m4623b(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: b */
    private static void m4624b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static void m4625b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = m4623b(parcel, i);
            parcel.writeStringList(list);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    private static void m4626c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: c */
    public static <T extends Parcelable> void m4627c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = m4623b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m4622a(parcel, parcelable, 0);
                }
            }
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }

    /* renamed from: d */
    public static void m4628d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int b = m4623b(parcel, i);
            parcel.writeList(list);
            m4626c(parcel, b);
        } else if (z) {
            m4624b(parcel, i, 0);
        }
    }
}
