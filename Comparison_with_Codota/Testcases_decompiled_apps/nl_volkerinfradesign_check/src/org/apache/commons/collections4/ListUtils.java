package org.apache.commons.collections4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.LazyList;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.sequence.CommandVisitor;
import org.apache.commons.collections4.sequence.EditScript;
import org.apache.commons.collections4.sequence.SequencesComparator;

public class ListUtils {
    private ListUtils() {
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <T> List<T> defaultIfNull(List<T> list, List<T> list2) {
        return list == null ? list2 : list;
    }

    public static <E> List<E> intersection(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        if (list.size() <= list2.size()) {
            List<? extends E> list3 = list2;
            list2 = list;
            list = list3;
        }
        HashSet hashSet = new HashSet(list2);
        for (Object next : list) {
            if (hashSet.contains(next)) {
                arrayList.add(next);
                hashSet.remove(next);
            }
        }
        return arrayList;
    }

    public static <E> List<E> subtract(List<E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag(list2);
        for (E next : list) {
            if (!hashBag.remove(next, 1)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <E> List<E> sum(List<? extends E> list, List<? extends E> list2) {
        return subtract(union(list, list2), intersection(list, list2));
    }

    public static <E> List<E> union(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static <E> List<E> select(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.select(collection, predicate, new ArrayList(collection.size()));
    }

    public static <E> List<E> selectRejected(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.selectRejected(collection, predicate, new ArrayList(collection.size()));
    }

    public static boolean isEqualList(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        Iterator<?> it2 = collection2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            Object next2 = it2.next();
            if (next == null) {
                if (next2 != null) {
                }
            } else if (!next.equals(next2)) {
            }
            return false;
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static int hashCodeForList(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        int i = 1;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            i = (next == null ? 0 : next.hashCode()) + (i * 31);
        }
        return i;
    }

    public static <E> List<E> retainAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList(Math.min(collection.size(), collection2.size()));
        for (E next : collection) {
            if (collection2.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <E> List<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList();
        for (E next : collection) {
            if (!collection2.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <E> List<E> synchronizedList(List<E> list) {
        return Collections.synchronizedList(list);
    }

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        return UnmodifiableList.unmodifiableList(list);
    }

    public static <E> List<E> predicatedList(List<E> list, Predicate<E> predicate) {
        return PredicatedList.predicatedList(list, predicate);
    }

    public static <E> List<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return TransformedList.transformingList(list, transformer);
    }

    public static <E> List<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return LazyList.lazyList(list, factory);
    }

    public static <E> List<E> fixedSizeList(List<E> list) {
        return FixedSizeList.fixedSizeList(list);
    }

    public static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        if (!(list == null || predicate == null)) {
            for (int i = 0; i < list.size(); i++) {
                if (predicate.evaluate(list.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2) {
        return longestCommonSubsequence(list, list2, DefaultEquator.defaultEquator());
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2, Equator<? super E> equator) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (equator == null) {
            throw new IllegalArgumentException("Equator must not be null");
        } else {
            EditScript script = new SequencesComparator(list, list2, equator).getScript();
            C1837b bVar = new C1837b();
            script.visit(bVar);
            return bVar.mo11275a();
        }
    }

    public static String longestCommonSubsequence(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("CharSequence must not be null");
        }
        List<Character> longestCommonSubsequence = longestCommonSubsequence(new C1836a(charSequence), new C1836a(charSequence2));
        StringBuilder sb = new StringBuilder();
        for (Character append : longestCommonSubsequence) {
            sb.append(append);
        }
        return sb.toString();
    }

    /* renamed from: org.apache.commons.collections4.ListUtils$b */
    static final class C1837b<E> implements CommandVisitor<E> {

        /* renamed from: a */
        private ArrayList<E> f6316a = new ArrayList<>();

        public void visitInsertCommand(E e) {
        }

        public void visitDeleteCommand(E e) {
        }

        public void visitKeepCommand(E e) {
            this.f6316a.add(e);
        }

        /* renamed from: a */
        public List<E> mo11275a() {
            return this.f6316a;
        }
    }

    /* renamed from: org.apache.commons.collections4.ListUtils$a */
    static final class C1836a extends AbstractList<Character> {

        /* renamed from: a */
        private final CharSequence f6315a;

        public C1836a(CharSequence charSequence) {
            this.f6315a = charSequence;
        }

        /* renamed from: a */
        public Character get(int i) {
            return Character.valueOf(this.f6315a.charAt(i));
        }

        public int size() {
            return this.f6315a.length();
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int i) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (i > 0) {
            return new C1838c(list, i);
        } else {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
    }

    /* renamed from: org.apache.commons.collections4.ListUtils$c */
    static class C1838c<T> extends AbstractList<List<T>> {

        /* renamed from: a */
        private final List<T> f6317a;

        /* renamed from: b */
        private final int f6318b;

        private C1838c(List<T> list, int i) {
            this.f6317a = list;
            this.f6318b = i;
        }

        /* renamed from: a */
        public List<T> get(int i) {
            int size = size();
            if (size < 0) {
                throw new IllegalArgumentException("negative size: " + size);
            } else if (i < 0) {
                throw new IndexOutOfBoundsException("Index " + i + " must not be negative");
            } else if (i >= size) {
                throw new IndexOutOfBoundsException("Index " + i + " must be less than size " + size);
            } else {
                int i2 = this.f6318b * i;
                return this.f6317a.subList(i2, Math.min(this.f6318b + i2, this.f6317a.size()));
            }
        }

        public int size() {
            return ((this.f6317a.size() + this.f6318b) - 1) / this.f6318b;
        }

        public boolean isEmpty() {
            return this.f6317a.isEmpty();
        }
    }
}
