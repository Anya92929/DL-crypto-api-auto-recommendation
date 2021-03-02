package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

class ReflectionHelper {
    ReflectionHelper() {
    }

    private static float a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            try {
                if (cls.asSubclass(cls2) != null) {
                    return 0.5f;
                }
            } catch (ClassCastException e) {
            }
            try {
                if (cls2.asSubclass(cls) != null) {
                    return 0.1f;
                }
            } catch (ClassCastException e2) {
            }
        }
        return 0.0f;
    }

    private static float a(Class cls, Class[] clsArr, Class[] clsArr2) {
        int i = 0;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            while (i < length) {
                f *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
        }
        return f * a(cls, clsArr2[clsArr2.length - 1]);
    }

    private static Class a(String str, int[] iArr) {
        while (true) {
            if (iArr[0] >= str.length()) {
                break;
            }
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf != -1) {
                        String substring = str.substring(iArr[0], indexOf);
                        iArr[0] = indexOf + 1;
                        try {
                            return Class.forName(substring.replace('/', '.'));
                        } catch (ClassNotFoundException e) {
                        }
                    }
                } else if (charAt == 'Z') {
                    return Boolean.TYPE;
                } else {
                    if (charAt == 'I') {
                        return Integer.TYPE;
                    }
                    if (charAt == 'F') {
                        return Float.TYPE;
                    }
                    if (charAt == 'V') {
                        return Void.TYPE;
                    }
                    if (charAt == 'B') {
                        return Byte.TYPE;
                    }
                    if (charAt == 'S') {
                        return Short.TYPE;
                    }
                    if (charAt == 'J') {
                        return Long.TYPE;
                    }
                    if (charAt == 'D') {
                        return Double.TYPE;
                    }
                    if (charAt == '[') {
                        return Array.newInstance(a(str, iArr), 0).getClass();
                    }
                    l.Log(5, "parseType; " + charAt + " is not known!");
                }
            }
        }
        return null;
    }

    private static Class[] a(String str) {
        Class a;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (a = a(str, iArr)) != null) {
            arrayList.add(a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor constructor;
        Constructor constructor2;
        Class[] a = a(str);
        Constructor constructor3 = null;
        float f = 0.0f;
        Constructor[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                constructor = constructor3;
                break;
            }
            constructor = constructors[i];
            float a2 = a(Void.TYPE, constructor.getParameterTypes(), a);
            if (a2 > f) {
                if (a2 == 1.0f) {
                    break;
                }
                constructor2 = constructor;
            } else {
                a2 = f;
                constructor2 = constructor3;
            }
            i++;
            constructor3 = constructor2;
            f = a2;
        }
        if (constructor == null) {
            l.Log(6, "getConstructorID(\"" + cls.getName() + "\", \"" + str + "\") FAILED!");
        }
        return constructor;
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        float f;
        Field field;
        Class[] a = a(str2);
        float f2 = 0.0f;
        Field field2 = null;
        while (cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            Field field3 = field2;
            while (true) {
                if (i >= length) {
                    field2 = field3;
                    break;
                }
                Field field4 = declaredFields[i];
                if (z == Modifier.isStatic(field4.getModifiers()) && field4.getName().compareTo(str) == 0) {
                    f = a(field4.getType(), (Class[]) null, a);
                    if (f > f2) {
                        if (f == 1.0f) {
                            f2 = f;
                            field2 = field4;
                            break;
                        }
                        field = field4;
                        i++;
                        field3 = field;
                        f2 = f;
                    }
                }
                f = f2;
                field = field3;
                i++;
                field3 = field;
                f2 = f;
            }
            if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                break;
            }
            cls = cls.getSuperclass();
        }
        if (field2 == null) {
            l.Log(6, "getFieldID(\"" + str + "\", \"" + str2 + "\") FAILED!");
        }
        return field2;
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        float f;
        Method method;
        Class[] a = a(str2);
        Method method2 = null;
        float f2 = 0.0f;
        while (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            Method method3 = method2;
            while (true) {
                if (i >= length) {
                    method2 = method3;
                    break;
                }
                Method method4 = declaredMethods[i];
                if (z == Modifier.isStatic(method4.getModifiers()) && method4.getName().compareTo(str) == 0) {
                    f = a(method4.getReturnType(), method4.getParameterTypes(), a);
                    if (f > f2) {
                        if (f == 1.0f) {
                            f2 = f;
                            method2 = method4;
                            break;
                        }
                        method = method4;
                        i++;
                        method3 = method;
                        f2 = f;
                    }
                }
                f = f2;
                method = method3;
                i++;
                method3 = method;
                f2 = f;
            }
            if (f2 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                break;
            }
            cls = cls.getSuperclass();
        }
        if (method2 == null) {
            l.Log(6, "getMethodID(\"" + str + "\", \"" + str2 + "\") FAILED!");
        }
        return method2;
    }
}
