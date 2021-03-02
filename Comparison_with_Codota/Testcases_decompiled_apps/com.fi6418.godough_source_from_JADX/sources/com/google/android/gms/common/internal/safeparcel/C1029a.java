package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C1029a {
    /* renamed from: a */
    public static int m4580a(int i) {
        return 65535 & i;
    }

    /* renamed from: a */
    public static int m4581a(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: a */
    public static int m4582a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m4583a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return t;
    }

    /* renamed from: a */
    private static void m4584a(Parcel parcel, int i, int i2) {
        int a = m4582a(parcel, i);
        if (a != i2) {
            throw new C1030b("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    /* renamed from: a */
    private static void m4585a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C1030b("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    /* renamed from: a */
    public static void m4586a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    /* renamed from: b */
    public static int m4587b(Parcel parcel) {
        int a = m4581a(parcel);
        int a2 = m4582a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (m4580a(a) != 20293) {
            throw new C1030b("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        int i = dataPosition + a2;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new C1030b("Size read is invalid start=" + dataPosition + " end=" + i, parcel);
    }

    /* renamed from: b */
    public static void m4588b(Parcel parcel, int i) {
        parcel.setDataPosition(m4582a(parcel, i) + parcel.dataPosition());
    }

    /* renamed from: b */
    public static <T> T[] m4589b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m4590c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    /* renamed from: c */
    public static boolean m4591c(Parcel parcel, int i) {
        m4584a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: d */
    public static byte m4592d(Parcel parcel, int i) {
        m4584a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* renamed from: e */
    public static short m4593e(Parcel parcel, int i) {
        m4584a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: f */
    public static int m4594f(Parcel parcel, int i) {
        m4584a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: g */
    public static Integer m4595g(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        if (a == 0) {
            return null;
        }
        m4585a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: h */
    public static long m4596h(Parcel parcel, int i) {
        m4584a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: i */
    public static float m4597i(Parcel parcel, int i) {
        m4584a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: j */
    public static double m4598j(Parcel parcel, int i) {
        m4584a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: k */
    public static String m4599k(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    /* renamed from: l */
    public static IBinder m4600l(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    /* renamed from: m */
    public static Bundle m4601m(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    /* renamed from: n */
    public static byte[] m4602n(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    /* renamed from: o */
    public static ArrayList<Integer> m4603o(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    /* renamed from: p */
    public static ArrayList<String> m4604p(Parcel parcel, int i) {
        int a = m4582a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }
}
