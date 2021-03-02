package android.support.p021v7.widget;

import java.lang.reflect.Array;

/* renamed from: android.support.v7.widget.cd */
class C0633cd {

    /* renamed from: a */
    static final /* synthetic */ boolean f1504a = (!C0633cd.class.desiredAssertionStatus());

    private C0633cd() {
    }

    /* renamed from: a */
    public static int m2875a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* renamed from: a */
    public static int[] m2876a(int[] iArr, int i, int i2) {
        if (f1504a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[m2875a(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static Object[] m2877a(Object[] objArr, int i, Object obj) {
        Object[] objArr2;
        if (f1504a || i <= objArr.length) {
            if (i + 1 > objArr.length) {
                objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), m2875a(i));
                System.arraycopy(objArr, 0, objArr2, 0, i);
            } else {
                objArr2 = objArr;
            }
            objArr2[i] = obj;
            return objArr2;
        }
        throw new AssertionError();
    }
}
