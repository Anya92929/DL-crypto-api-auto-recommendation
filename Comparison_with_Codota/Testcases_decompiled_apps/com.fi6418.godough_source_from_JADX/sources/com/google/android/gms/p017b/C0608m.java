package com.google.android.gms.p017b;

import android.os.IBinder;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.b.m */
public final class C0608m<T> extends C0606k {

    /* renamed from: a */
    private final T f3972a;

    private C0608m(T t) {
        this.f3972a = t;
    }

    /* renamed from: a */
    public static <T> C0605j m3536a(T t) {
        return new C0608m(t);
    }

    /* renamed from: a */
    public static <T> T m3537a(C0605j jVar) {
        if (jVar instanceof C0608m) {
            return ((C0608m) jVar).f3972a;
        }
        IBinder asBinder = jVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e) {
                    throw new IllegalArgumentException("Binder object is null.", e);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }
}
