package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.CloneTransformer;
import org.apache.commons.collections4.functors.ClosureTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.ExceptionTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;
import org.apache.commons.collections4.functors.InstantiateTransformer;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.apache.commons.collections4.functors.MapTransformer;
import org.apache.commons.collections4.functors.NOPTransformer;
import org.apache.commons.collections4.functors.PredicateTransformer;
import org.apache.commons.collections4.functors.StringValueTransformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

public class TransformerUtils {
    private TransformerUtils() {
    }

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return ExceptionTransformer.exceptionTransformer();
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        return ConstantTransformer.nullTransformer();
    }

    public static <T> Transformer<T, T> nopTransformer() {
        return NOPTransformer.nopTransformer();
    }

    public static <T> Transformer<T, T> cloneTransformer() {
        return CloneTransformer.cloneTransformer();
    }

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        return ConstantTransformer.constantTransformer(o);
    }

    public static <T> Transformer<T, T> asTransformer(Closure<? super T> closure) {
        return ClosureTransformer.closureTransformer(closure);
    }

    public static <T> Transformer<T, Boolean> asTransformer(Predicate<? super T> predicate) {
        return PredicateTransformer.predicateTransformer(predicate);
    }

    public static <I, O> Transformer<I, O> asTransformer(Factory<? extends O> factory) {
        return FactoryTransformer.factoryTransformer(factory);
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        return ChainedTransformer.chainedTransformer(transformerArr);
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<T, T>> collection) {
        return ChainedTransformer.chainedTransformer(collection);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> transformer, Transformer<? super I, ? extends O> transformer2) {
        return SwitchTransformer.switchTransformer(new Predicate[]{predicate}, new Transformer[]{transformer}, transformer2);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr) {
        return SwitchTransformer.switchTransformer(predicateArr, transformerArr, (Transformer) null);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        return SwitchTransformer.switchTransformer(predicateArr, transformerArr, transformer);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<Predicate<I>, Transformer<I, O>> map) {
        return SwitchTransformer.switchTransformer(map);
    }

    public static <I, O> Transformer<I, O> switchMapTransformer(Map<I, Transformer<I, O>> map) {
        if (map == null) {
            throw new IllegalArgumentException("The object and transformer map must not be null");
        }
        Transformer remove = map.remove((Object) null);
        int size = map.size();
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            predicateArr[i] = EqualPredicate.equalPredicate(next.getKey());
            transformerArr[i] = (Transformer) next.getValue();
            i++;
        }
        return switchTransformer((Predicate<? super I>[]) predicateArr, (Transformer<? super I, ? extends O>[]) transformerArr, remove);
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
        return InstantiateTransformer.instantiateTransformer();
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] clsArr, Object[] objArr) {
        return InstantiateTransformer.instantiateTransformer(clsArr, objArr);
    }

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        return MapTransformer.mapTransformer(map);
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str) {
        return InvokerTransformer.invokerTransformer(str, (Class<?>[]) null, (Object[]) null);
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        return InvokerTransformer.invokerTransformer(str, clsArr, objArr);
    }

    public static <T> Transformer<T, String> stringValueTransformer() {
        return StringValueTransformer.stringValueTransformer();
    }
}
