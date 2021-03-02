package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0354b {
    /* renamed from: D */
    public static int m912D(Parcel parcel) {
        return m913F(parcel, 20293);
    }

    /* renamed from: F */
    private static int m913F(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: G */
    private static void m914G(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: H */
    public static void m915H(Parcel parcel, int i) {
        m914G(parcel, i);
    }

    /* renamed from: a */
    public static void m916a(Parcel parcel, int i, byte b) {
        m937b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m917a(Parcel parcel, int i, double d) {
        m937b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m918a(Parcel parcel, int i, float f) {
        m937b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m919a(Parcel parcel, int i, long j) {
        m937b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m920a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int F = m913F(parcel, i);
            parcel.writeBundle(bundle);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m921a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int F = m913F(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m922a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int F = m913F(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m923a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int F = m913F(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m924a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            m937b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m925a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m937b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m926a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m937b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m927a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int F = m913F(parcel, i);
            parcel.writeString(str);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m928a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int F = m913F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m929a(Parcel parcel, int i, short s) {
        m937b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m930a(Parcel parcel, int i, boolean z) {
        m937b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m931a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int F = m913F(parcel, i);
            parcel.writeByteArray(bArr);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m932a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int F = m913F(parcel, i);
            parcel.writeIntArray(iArr);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m933a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int F = m913F(parcel, i);
            parcel.writeInt(r3);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m936a(parcel, t, i2);
                }
            }
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m934a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int F = m913F(parcel, i);
            parcel.writeStringArray(strArr);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m935a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr != null) {
            int F = m913F(parcel, i);
            parcel.writeInt(r2);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m936a(Parcel parcel, T t, int i) {
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
    private static void m937b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static void m938b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int F = m913F(parcel, i);
            parcel.writeStringList(list);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    public static void m939c(Parcel parcel, int i, int i2) {
        m937b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static <T extends Parcelable> void m940c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int F = m913F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m936a(parcel, parcelable, 0);
                }
            }
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }

    /* renamed from: d */
    public static void m941d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int F = m913F(parcel, i);
            parcel.writeList(list);
            m914G(parcel, F);
        } else if (z) {
            m937b(parcel, i, 0);
        }
    }
}
