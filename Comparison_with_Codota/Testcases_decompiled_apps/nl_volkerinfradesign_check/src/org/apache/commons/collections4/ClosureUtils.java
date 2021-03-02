package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionClosure;
import org.apache.commons.collections4.functors.ForClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.NOPClosure;
import org.apache.commons.collections4.functors.SwitchClosure;
import org.apache.commons.collections4.functors.TransformerClosure;
import org.apache.commons.collections4.functors.WhileClosure;

public class ClosureUtils {
    private ClosureUtils() {
    }

    public static <E> Closure<E> exceptionClosure() {
        return ExceptionClosure.exceptionClosure();
    }

    public static <E> Closure<E> nopClosure() {
        return NOPClosure.nopClosure();
    }

    public static <E> Closure<E> asClosure(Transformer<? super E, ?> transformer) {
        return TransformerClosure.transformerClosure(transformer);
    }

    public static <E> Closure<E> forClosure(int i, Closure<? super E> closure) {
        return ForClosure.forClosure(i, closure);
    }

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return WhileClosure.whileClosure(predicate, closure, false);
    }

    public static <E> Closure<E> doWhileClosure(Closure<? super E> closure, Predicate<? super E> predicate) {
        return WhileClosure.whileClosure(predicate, closure, true);
    }

    public static <E> Closure<E> invokerClosure(String str) {
        return asClosure(InvokerTransformer.invokerTransformer(str));
    }

    public static <E> Closure<E> invokerClosure(String str, Class<?>[] clsArr, Object[] objArr) {
        return asClosure(InvokerTransformer.invokerTransformer(str, clsArr, objArr));
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        return ChainedClosure.chainedClosure(closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<Closure<E>> collection) {
        return ChainedClosure.chainedClosure(collection);
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return IfClosure.ifClosure(predicate, closure);
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        return IfClosure.ifClosure(predicate, closure, closure2);
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr) {
        return SwitchClosure.switchClosure(predicateArr, closureArr, (Closure) null);
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        return SwitchClosure.switchClosure(predicateArr, closureArr, closure);
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        return SwitchClosure.switchClosure(map);
    }

    public static <E> Closure<E> switchMapClosure(Map<? extends E, Closure<E>> map) {
        if (map == null) {
            throw new IllegalArgumentException("The object and closure map must not be null");
        }
        Closure remove = map.remove((Object) null);
        int size = map.size();
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        Iterator<Map.Entry<? extends E, Closure<E>>> it = map.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return switchClosure(predicateArr, closureArr, remove);
            }
            Map.Entry next = it.next();
            predicateArr[i2] = EqualPredicate.equalPredicate(next.getKey());
            closureArr[i2] = (Closure) next.getValue();
            i = i2 + 1;
        }
    }
}
