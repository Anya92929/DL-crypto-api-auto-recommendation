package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0594d;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C0597e<T> extends C0594d.C0595a {

    /* renamed from: Sc */
    private final T f1268Sc;

    private C0597e(T t) {
        this.f1268Sc = t;
    }

    /* renamed from: f */
    public static <T> T m1742f(C0594d dVar) {
        if (dVar instanceof C0597e) {
            return ((C0597e) dVar).f1268Sc;
        }
        IBinder asBinder = dVar.asBinder();
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

    /* renamed from: k */
    public static <T> C0594d m1743k(T t) {
        return new C0597e(t);
    }
}
