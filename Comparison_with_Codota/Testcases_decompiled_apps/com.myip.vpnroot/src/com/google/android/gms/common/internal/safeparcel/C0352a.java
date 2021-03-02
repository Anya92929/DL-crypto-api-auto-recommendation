package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0352a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a$a */
    public static class C0353a extends RuntimeException {
        public C0353a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    /* renamed from: A */
    public static String[] m872A(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    /* renamed from: B */
    public static int m873B(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: B */
    public static ArrayList<Integer> m874B(Parcel parcel, int i) {
        int a = m879a(parcel, i);
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

    /* renamed from: C */
    public static int m875C(Parcel parcel) {
        int B = m873B(parcel);
        int a = m879a(parcel, B);
        int dataPosition = parcel.dataPosition();
        if (m884aD(B) != 20293) {
            throw new C0353a("Expected object header. Got 0x" + Integer.toHexString(B), parcel);
        }
        int i = dataPosition + a;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new C0353a("Size read is invalid start=" + dataPosition + " end=" + i, parcel);
    }

    /* renamed from: C */
    public static ArrayList<String> m876C(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    /* renamed from: D */
    public static Parcel m877D(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    /* renamed from: E */
    public static Parcel[] m878E(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    /* renamed from: a */
    public static int m879a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m880a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return t;
    }

    /* renamed from: a */
    private static void m881a(Parcel parcel, int i, int i2) {
        int a = m879a(parcel, i);
        if (a != i2) {
            throw new C0353a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    /* renamed from: a */
    private static void m882a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0353a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    /* renamed from: a */
    public static void m883a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    /* renamed from: aD */
    public static int m884aD(int i) {
        return 65535 & i;
    }

    /* renamed from: b */
    public static void m885b(Parcel parcel, int i) {
        parcel.setDataPosition(m879a(parcel, i) + parcel.dataPosition());
    }

    /* renamed from: b */
    public static <T> T[] m886b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m887c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    /* renamed from: c */
    public static boolean m888c(Parcel parcel, int i) {
        m881a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: d */
    public static Boolean m889d(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        if (a == 0) {
            return null;
        }
        m882a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    /* renamed from: e */
    public static byte m890e(Parcel parcel, int i) {
        m881a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* renamed from: f */
    public static short m891f(Parcel parcel, int i) {
        m881a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: g */
    public static int m892g(Parcel parcel, int i) {
        m881a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: h */
    public static Integer m893h(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        if (a == 0) {
            return null;
        }
        m882a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: i */
    public static long m894i(Parcel parcel, int i) {
        m881a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: j */
    public static Long m895j(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        if (a == 0) {
            return null;
        }
        m882a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: k */
    public static BigInteger m896k(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    /* renamed from: l */
    public static float m897l(Parcel parcel, int i) {
        m881a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: m */
    public static double m898m(Parcel parcel, int i) {
        m881a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: n */
    public static BigDecimal m899n(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    /* renamed from: o */
    public static String m900o(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    /* renamed from: p */
    public static IBinder m901p(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    /* renamed from: q */
    public static Bundle m902q(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    /* renamed from: r */
    public static byte[] m903r(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    /* renamed from: s */
    public static byte[][] m904s(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    /* renamed from: t */
    public static boolean[] m905t(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    /* renamed from: u */
    public static int[] m906u(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    /* renamed from: v */
    public static long[] m907v(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    /* renamed from: w */
    public static BigInteger[] m908w(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    /* renamed from: x */
    public static float[] m909x(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    /* renamed from: y */
    public static double[] m910y(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    /* renamed from: z */
    public static BigDecimal[] m911z(Parcel parcel, int i) {
        int a = m879a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }
}
