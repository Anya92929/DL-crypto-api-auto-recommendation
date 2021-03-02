package p000;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: jr */
public abstract class C1333jr {

    /* renamed from: a */
    private static final Class<?>[] f4600a = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    /* renamed from: a */
    public static void m5739a(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (Modifier.isPublic(member.getModifiers()) && m5740a(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                } catch (SecurityException e) {
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m5740a(int i) {
        return (i & 7) == 0;
    }

    /* renamed from: a */
    public static boolean m5741a(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    /* renamed from: a */
    public static int m5738a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a = m5737a(clsArr3, clsArr);
        float a2 = m5737a(clsArr3, clsArr2);
        if (a < a2) {
            return -1;
        }
        return a2 < a ? 1 : 0;
    }

    /* renamed from: a */
    private static float m5737a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < clsArr.length; i++) {
            f += m5736a(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    /* renamed from: a */
    private static float m5736a(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return m5742b(cls, cls2);
        }
        float f = BitmapDescriptorFactory.HUE_RED;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 != null && !cls2.equals(cls3)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls3, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls3 = cls3.getSuperclass();
            } else {
                break;
            }
        }
        if (cls3 == null) {
            return f + 1.5f;
        }
        return f;
    }

    /* renamed from: b */
    private static float m5742b(Class<?> cls, Class<?> cls2) {
        float f = BitmapDescriptorFactory.HUE_RED;
        if (!cls.isPrimitive()) {
            f = BitmapDescriptorFactory.HUE_RED + 0.1f;
            cls = ClassUtils.wrapperToPrimitive(cls);
        }
        int i = 0;
        float f2 = f;
        Class<?> cls3 = cls;
        while (cls3 != cls2 && i < f4600a.length) {
            if (cls3 == f4600a[i]) {
                f2 += 0.1f;
                if (i < f4600a.length - 1) {
                    cls3 = f4600a[i + 1];
                }
            }
            i++;
        }
        return f2;
    }
}
