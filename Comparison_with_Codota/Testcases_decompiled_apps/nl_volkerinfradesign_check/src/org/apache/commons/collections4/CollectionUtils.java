package org.apache.commons.collections4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils {
    public static final Collection EMPTY_COLLECTION = UnmodifiableCollection.unmodifiableCollection(new ArrayList());

    /* renamed from: org.apache.commons.collections4.CollectionUtils$a */
    static class C1832a<O> {

        /* renamed from: a */
        final Map<O, Integer> f6309a;

        /* renamed from: b */
        final Map<O, Integer> f6310b;

        public C1832a(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            this.f6309a = CollectionUtils.getCardinalityMap(iterable);
            this.f6310b = CollectionUtils.getCardinalityMap(iterable2);
        }

        /* renamed from: a */
        public final int mo11249a(Object obj) {
            return Math.max(mo11251c(obj), mo11252d(obj));
        }

        /* renamed from: b */
        public final int mo11250b(Object obj) {
            return Math.min(mo11251c(obj), mo11252d(obj));
        }

        /* renamed from: c */
        public int mo11251c(Object obj) {
            return m6911a(obj, this.f6309a);
        }

        /* renamed from: d */
        public int mo11252d(Object obj) {
            return m6911a(obj, this.f6310b);
        }

        /* renamed from: a */
        private final int m6911a(Object obj, Map<?, Integer> map) {
            Integer num = map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    /* renamed from: org.apache.commons.collections4.CollectionUtils$c */
    static class C1834c<O> extends C1832a<O> implements Iterable<O> {

        /* renamed from: c */
        private final Set<O> f6313c = new HashSet();

        /* renamed from: d */
        private final List<O> f6314d;

        public C1834c(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            super(iterable, iterable2);
            CollectionUtils.addAll(this.f6313c, iterable);
            CollectionUtils.addAll(this.f6313c, iterable2);
            this.f6314d = new ArrayList(this.f6313c.size());
        }

        public Iterator<O> iterator() {
            return this.f6313c.iterator();
        }

        /* renamed from: a */
        public void mo11257a(O o, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f6314d.add(o);
            }
        }

        /* renamed from: a */
        public Collection<O> mo11256a() {
            return this.f6314d;
        }
    }

    private CollectionUtils() {
    }

    public static <T> Collection<T> emptyCollection() {
        return EMPTY_COLLECTION;
    }

    public static <T> Collection<T> emptyIfNull(Collection<T> collection) {
        return collection == null ? EMPTY_COLLECTION : collection;
    }

    public static <O> Collection<O> union(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        C1834c cVar = new C1834c(iterable, iterable2);
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            cVar.mo11257a(next, cVar.mo11249a(next));
        }
        return cVar.mo11256a();
    }

    public static <O> Collection<O> intersection(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        C1834c cVar = new C1834c(iterable, iterable2);
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            cVar.mo11257a(next, cVar.mo11250b(next));
        }
        return cVar.mo11256a();
    }

    public static <O> Collection<O> disjunction(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        C1834c cVar = new C1834c(iterable, iterable2);
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            cVar.mo11257a(next, cVar.mo11249a(next) - cVar.mo11250b(next));
        }
        return cVar.mo11256a();
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return subtract(iterable, iterable2, TruePredicate.truePredicate());
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Predicate<O> predicate) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag();
        for (Object next : iterable2) {
            if (predicate.evaluate(next)) {
                hashBag.add(next);
            }
        }
        for (Object next2 : iterable) {
            if (!hashBag.remove(next2, 1)) {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r2 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean containsAll(java.util.Collection<?> r7, java.util.Collection<?> r8) {
        /*
            r1 = 0
            r0 = 1
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L_0x0009
        L_0x0008:
            return r0
        L_0x0009:
            java.util.Iterator r3 = r7.iterator()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Iterator r5 = r8.iterator()
        L_0x0016:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0008
            java.lang.Object r2 = r5.next()
            boolean r6 = r4.contains(r2)
            if (r6 != 0) goto L_0x0016
        L_0x0026:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0043
            java.lang.Object r6 = r3.next()
            r4.add(r6)
            if (r2 != 0) goto L_0x003c
            if (r6 != 0) goto L_0x0026
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r2 != 0) goto L_0x0016
            r0 = r1
            goto L_0x0008
        L_0x003c:
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0026
            goto L_0x0037
        L_0x0043:
            r2 = r1
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.CollectionUtils.containsAll(java.util.Collection, java.util.Collection):boolean");
    }

    public static boolean containsAny(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() < collection2.size()) {
            for (Object contains : collection) {
                if (collection2.contains(contains)) {
                    return true;
                }
            }
        } else {
            for (Object contains2 : collection2) {
                if (collection.contains(contains2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <O> Map<O, Integer> getCardinalityMap(Iterable<? extends O> iterable) {
        HashMap hashMap = new HashMap();
        for (Object next : iterable) {
            Integer num = (Integer) hashMap.get(next);
            if (num == null) {
                hashMap.put(next, 1);
            } else {
                hashMap.put(next, Integer.valueOf(num.intValue() + 1));
            }
        }
        return hashMap;
    }

    public static boolean isSubCollection(Collection<?> collection, Collection<?> collection2) {
        C1832a aVar = new C1832a(collection, collection2);
        for (Object next : collection) {
            if (aVar.mo11251c(next) > aVar.mo11252d(next)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isProperSubCollection(Collection<?> collection, Collection<?> collection2) {
        return collection.size() < collection2.size() && isSubCollection(collection, collection2);
    }

    public static boolean isEqualCollection(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() != collection2.size()) {
            return false;
        }
        C1832a aVar = new C1832a(collection, collection2);
        if (aVar.f6309a.size() != aVar.f6310b.size()) {
            return false;
        }
        for (O next : aVar.f6309a.keySet()) {
            if (aVar.mo11251c(next) != aVar.mo11252d(next)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualCollection(Collection<?> collection, Collection<?> collection2, final Equator<?> equator) {
        if (equator == null) {
            throw new IllegalArgumentException("equator may not be null");
        } else if (collection.size() != collection2.size()) {
            return false;
        } else {
            C18311 r0 = new Transformer() {
                /* renamed from: a */
                public C1833b<?> transform(Object obj) {
                    return new C1833b<>(equator, obj);
                }
            };
            return isEqualCollection(collect(collection, r0), collect(collection2, r0));
        }
    }

    /* renamed from: org.apache.commons.collections4.CollectionUtils$b */
    static class C1833b<O> {

        /* renamed from: a */
        private final Equator<O> f6311a;

        /* renamed from: b */
        private final O f6312b;

        public C1833b(Equator<O> equator, O o) {
            this.f6311a = equator;
            this.f6312b = o;
        }

        /* renamed from: a */
        public O mo11253a() {
            return this.f6312b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1833b)) {
                return false;
            }
            return this.f6311a.equate(this.f6312b, ((C1833b) obj).mo11253a());
        }

        public int hashCode() {
            return this.f6311a.hash(this.f6312b);
        }
    }

    public static <O> int cardinality(O o, Iterable<? super O> iterable) {
        int i = 0;
        if (iterable instanceof Set) {
            if (((Set) iterable).contains(o)) {
                return 1;
            }
            return 0;
        } else if (iterable instanceof Bag) {
            return ((Bag) iterable).getCount(o);
        } else {
            if (o == null) {
                for (Object obj : iterable) {
                    if (obj == null) {
                        i++;
                    }
                }
                return i;
            }
            for (Object equals : iterable) {
                if (o.equals(equals)) {
                    i++;
                }
            }
            return i;
        }
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (!(iterable == null || predicate == null)) {
            for (T next : iterable) {
                if (predicate.evaluate(next)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static <T, C extends Closure<? super T>> C forAllDo(Iterable<T> iterable, C c) {
        if (!(iterable == null || c == null)) {
            for (T execute : iterable) {
                c.execute(execute);
            }
        }
        return c;
    }

    public static <T, C extends Closure<? super T>> C forAllDo(Iterator<T> it, C c) {
        if (!(it == null || c == null)) {
            while (it.hasNext()) {
                c.execute(it.next());
            }
        }
        return c;
    }

    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterable<T> iterable, C c) {
        if (iterable == null || c == null) {
            return null;
        }
        return forAllButLastDo(iterable.iterator(), c);
    }

    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterator<T> it, C c) {
        if (!(it == null || c == null)) {
            while (it.hasNext()) {
                T next = it.next();
                if (!it.hasNext()) {
                    return next;
                }
                c.execute(next);
            }
        }
        return null;
    }

    public static <T> boolean filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        boolean z = false;
        if (!(iterable == null || predicate == null)) {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                if (!predicate.evaluate(it.next())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    public static <T> boolean filterInverse(Iterable<T> iterable, Predicate<? super T> predicate) {
        return filter(iterable, predicate == null ? null : PredicateUtils.notPredicate(predicate));
    }

    public static <C> void transform(Collection<C> collection, Transformer<? super C, ? extends C> transformer) {
        if (collection != null && transformer != null) {
            if (collection instanceof List) {
                ListIterator listIterator = ((List) collection).listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set(transformer.transform(listIterator.next()));
                }
                return;
            }
            Collection<? extends C> collect = collect(collection, transformer);
            collection.clear();
            collection.addAll(collect);
        }
    }

    public static <C> int countMatches(Iterable<C> iterable, Predicate<? super C> predicate) {
        int i = 0;
        if (!(iterable == null || predicate == null)) {
            for (C evaluate : iterable) {
                if (predicate.evaluate(evaluate)) {
                    i++;
                }
            }
        }
        return i;
    }

    public static <C> boolean exists(Iterable<C> iterable, Predicate<? super C> predicate) {
        if (!(iterable == null || predicate == null)) {
            for (C evaluate : iterable) {
                if (predicate.evaluate(evaluate)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <C> boolean matchesAll(Iterable<C> iterable, Predicate<? super C> predicate) {
        if (predicate == null) {
            return false;
        }
        if (iterable != null) {
            for (C evaluate : iterable) {
                if (!predicate.evaluate(evaluate)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <O> Collection<O> select(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return select(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r) {
        if (!(iterable == null || predicate == null)) {
            for (Object next : iterable) {
                if (predicate.evaluate(next)) {
                    r.add(next);
                }
            }
        }
        return r;
    }

    public static <O> Collection<O> selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return selectRejected(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <O, R extends Collection<? super O>> R selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r) {
        if (!(iterable == null || predicate == null)) {
            for (Object next : iterable) {
                if (!predicate.evaluate(next)) {
                    r.add(next);
                }
            }
        }
        return r;
    }

    public static <I, O> Collection<O> collect(Iterable<I> iterable, Transformer<? super I, ? extends O> transformer) {
        return collect(iterable, transformer, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <I, O> Collection<O> collect(Iterator<I> it, Transformer<? super I, ? extends O> transformer) {
        return collect(it, transformer, new ArrayList());
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterable<? extends I> iterable, Transformer<? super I, ? extends O> transformer, R r) {
        if (iterable != null) {
            return collect(iterable.iterator(), transformer, r);
        }
        return r;
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer, R r) {
        if (!(it == null || transformer == null)) {
            while (it.hasNext()) {
                r.add(transformer.transform(it.next()));
            }
        }
        return r;
    }

    public static <T> boolean addIgnoreNull(Collection<T> collection, T t) {
        if (collection != null) {
            return t != null && collection.add(t);
        }
        throw new NullPointerException("The collection must not be null");
    }

    public static <C> boolean addAll(Collection<C> collection, Iterable<? extends C> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return addAll(collection, iterable.iterator());
    }

    public static <C> boolean addAll(Collection<C> collection, Iterator<? extends C> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <C> boolean addAll(Collection<C> collection, Enumeration<? extends C> enumeration) {
        boolean z = false;
        while (enumeration.hasMoreElements()) {
            z |= collection.add(enumeration.nextElement());
        }
        return z;
    }

    public static <C> boolean addAll(Collection<C> collection, C[] cArr) {
        boolean z = false;
        for (C add : cArr) {
            z |= collection.add(add);
        }
        return z;
    }

    public static <T> T get(Iterator<T> it, int i) {
        m6909a(i);
        while (it.hasNext()) {
            i--;
            if (i == -1) {
                return it.next();
            }
            it.next();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + i);
    }

    /* renamed from: a */
    private static void m6909a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
        }
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        m6909a(i);
        if (iterable instanceof List) {
            return ((List) iterable).get(i);
        }
        return get(iterable.iterator(), i);
    }

    public static Object get(Object obj, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
        } else if (obj instanceof Map) {
            return get(((Map) obj).entrySet().iterator(), i);
        } else {
            if (obj instanceof Object[]) {
                return ((Object[]) obj)[i];
            }
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    i--;
                    if (i == -1) {
                        return it.next();
                    }
                    it.next();
                }
                throw new IndexOutOfBoundsException("Entry does not exist: " + i);
            } else if (obj instanceof Collection) {
                return get(((Collection) obj).iterator(), i);
            } else {
                if (obj instanceof Enumeration) {
                    Enumeration enumeration = (Enumeration) obj;
                    while (enumeration.hasMoreElements()) {
                        i--;
                        if (i == -1) {
                            return enumeration.nextElement();
                        }
                        enumeration.nextElement();
                    }
                    throw new IndexOutOfBoundsException("Entry does not exist: " + i);
                } else if (obj == null) {
                    throw new IllegalArgumentException("Unsupported object type: null");
                } else {
                    try {
                        return Array.get(obj, i);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
                    }
                }
            }
        }
    }

    public static <K, V> Map.Entry<K, V> get(Map<K, V> map, int i) {
        m6909a(i);
        return (Map.Entry) get(map.entrySet(), i);
    }

    public static int size(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                i++;
                it.next();
            }
            return i;
        } else if (obj instanceof Enumeration) {
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i++;
                enumeration.nextElement();
            }
            return i;
        } else {
            try {
                return Array.getLength(obj);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
            }
        }
    }

    public static boolean sizeIsEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            if (((Object[]) obj).length != 0) {
                return false;
            }
            return true;
        } else if (obj instanceof Iterator) {
            if (((Iterator) obj).hasNext()) {
                return false;
            }
            return true;
        } else if (!(obj instanceof Enumeration)) {
            try {
                if (Array.getLength(obj) != 0) {
                    return false;
                }
                return true;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
            }
        } else if (((Enumeration) obj).hasMoreElements()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static void reverseArray(Object[] objArr) {
        int length = objArr.length - 1;
        for (int i = 0; length > i; i++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i];
            objArr[i] = obj;
            length--;
        }
    }

    public static boolean isFull(Collection<? extends Object> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        } else if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).isFull();
        } else {
            try {
                return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).isFull();
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }

    public static int maxSize(Collection<? extends Object> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        } else if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).maxSize();
        } else {
            try {
                return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).maxSize();
            } catch (IllegalArgumentException e) {
                return -1;
            }
        }
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), true);
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, boolean z) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), z);
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator) {
        return collate(iterable, iterable2, comparator, true);
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator, boolean z) {
        int i;
        if (iterable == null || iterable2 == null) {
            throw new IllegalArgumentException("The collections must not be null");
        } else if (comparator == null) {
            throw new IllegalArgumentException("The comparator must not be null");
        } else {
            if (!(iterable instanceof Collection) || !(iterable2 instanceof Collection)) {
                i = 10;
            } else {
                i = Math.max(1, ((Collection) iterable2).size() + ((Collection) iterable).size());
            }
            CollatingIterator collatingIterator = new CollatingIterator(comparator, iterable.iterator(), iterable2.iterator());
            if (z) {
                return IteratorUtils.toList(collatingIterator, i);
            }
            ArrayList arrayList = new ArrayList(i);
            Object obj = null;
            while (collatingIterator.hasNext()) {
                Object next = collatingIterator.next();
                if (obj == null || !obj.equals(next)) {
                    arrayList.add(next);
                }
                obj = next;
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        PermutationIterator permutationIterator = new PermutationIterator(collection);
        LinkedList linkedList = new LinkedList();
        while (permutationIterator.hasNext()) {
            linkedList.add(permutationIterator.next());
        }
        return linkedList;
    }

    public static <C> Collection<C> retainAll(Collection<C> collection, Collection<?> collection2) {
        return ListUtils.retainAll(collection, collection2);
    }

    public static <E> Collection<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        return ListUtils.removeAll(collection, collection2);
    }

    public static <C> Collection<C> synchronizedCollection(Collection<C> collection) {
        return SynchronizedCollection.synchronizedCollection(collection);
    }

    public static <C> Collection<C> unmodifiableCollection(Collection<? extends C> collection) {
        return UnmodifiableCollection.unmodifiableCollection(collection);
    }

    public static <C> Collection<C> predicatedCollection(Collection<C> collection, Predicate<? super C> predicate) {
        return PredicatedCollection.predicatedCollection(collection, predicate);
    }

    public static <E> Collection<E> transformingCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        return TransformedCollection.transformingCollection(collection, transformer);
    }

    public static <E> E extractSingleton(Collection<E> collection) {
        if (collection != null && collection.size() == 1) {
            return collection.iterator().next();
        }
        throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
    }
}
