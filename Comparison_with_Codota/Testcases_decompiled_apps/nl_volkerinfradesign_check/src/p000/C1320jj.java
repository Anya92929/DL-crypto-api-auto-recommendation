package p000;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* renamed from: jj */
public class C1320jj {
    /* renamed from: a */
    public static <T> Predicate<T>[] m5715a(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    /* renamed from: a */
    public static <T> Predicate<T> m5712a(Predicate<? super T> predicate) {
        return predicate;
    }

    /* renamed from: b */
    public static void m5718b(Predicate<?>... predicateArr) {
        if (predicateArr == null) {
            throw new IllegalArgumentException("The predicate array must not be null");
        }
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new IllegalArgumentException("The predicate array must not contain a null predicate, index " + i + " was null");
            }
        }
    }

    /* renamed from: a */
    public static <T> Predicate<T>[] m5714a(Collection<? extends Predicate<T>> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("The predicate collection must not be null");
        }
        Predicate<T>[] predicateArr = new Predicate[collection.size()];
        int i = 0;
        Iterator<? extends Predicate<T>> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return predicateArr;
            }
            predicateArr[i2] = (Predicate) it.next();
            if (predicateArr[i2] == null) {
                throw new IllegalArgumentException("The predicate collection must not contain a null predicate, index " + i2 + " was null");
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public static <E> Closure<E>[] m5713a(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    /* renamed from: b */
    public static void m5717b(Closure<?>... closureArr) {
        if (closureArr == null) {
            throw new IllegalArgumentException("The closure array must not be null");
        }
        for (int i = 0; i < closureArr.length; i++) {
            if (closureArr[i] == null) {
                throw new IllegalArgumentException("The closure array must not contain a null closure, index " + i + " was null");
            }
        }
    }

    /* renamed from: a */
    public static <I, O> Transformer<I, O>[] m5716a(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    /* renamed from: b */
    public static void m5719b(Transformer<?, ?>... transformerArr) {
        if (transformerArr == null) {
            throw new IllegalArgumentException("The transformer array must not be null");
        }
        for (int i = 0; i < transformerArr.length; i++) {
            if (transformerArr[i] == null) {
                throw new IllegalArgumentException("The transformer array must not contain a null transformer, index " + i + " was null");
            }
        }
    }
}
