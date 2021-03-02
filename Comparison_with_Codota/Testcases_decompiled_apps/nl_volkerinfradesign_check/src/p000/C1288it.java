package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager.Path;

/* renamed from: it */
public class C1288it<T> extends ArrayList<T> implements Path<T> {
    private static final long serialVersionUID = 2514828337470993774L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1294iu<T> f4500a;

    /* renamed from: b */
    private boolean f4501b = true;

    public C1288it(C1294iu<T> iuVar) {
        this.f4500a = iuVar;
    }

    public void add(int i, T t) {
        try {
            super.add(i, t);
        } finally {
            if (mo8650a()) {
                this.f4500a.notifyDataSetChanged();
            }
        }
    }

    public boolean add(T t) {
        boolean add = super.add(t);
        if (add && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = super.addAll(collection);
        if (addAll && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return addAll;
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean addAll = super.addAll(i, collection);
        if (addAll && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return addAll;
    }

    public void append(final int i, final T t) {
        if (i < 0 || i > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mo8648a((Callable<Boolean>) new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (i + 1 < C1288it.this.size()) {
                    C1288it.this.removeRange(i + 1, C1288it.this.size());
                }
                C1288it.this.add(t);
                return true;
            }
        });
    }

    public final void append(T t, T t2) {
        append(indexOf(t), t2);
    }

    public void clear() {
        super.clear();
        if (mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public boolean mo8650a() {
        return this.f4501b;
    }

    public Iterator<T> iterator() {
        return new C1292a(super.iterator());
    }

    public ListIterator<T> listIterator() {
        return new C1293b(super.listIterator());
    }

    public ListIterator<T> listIterator(int i) {
        return new C1293b(super.listIterator(i));
    }

    public T remove(int i) {
        try {
            return super.remove(i);
        } finally {
            if (mo8650a()) {
                this.f4500a.notifyDataSetChanged();
            }
        }
    }

    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        if (remove && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = super.removeAll(collection);
        if (removeAll && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = super.retainAll(collection);
        if (retainAll && mo8650a()) {
            this.f4500a.notifyDataSetChanged();
        }
        return retainAll;
    }

    public T set(int i, T t) {
        try {
            return super.set(i, t);
        } finally {
            if (mo8650a()) {
                this.f4500a.notifyDataSetChanged();
            }
        }
    }

    public void setContent(final Collection<T> collection) {
        mo8648a((Callable<Boolean>) new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                C1288it.this.clear();
                C1288it.this.addAll(collection);
                return true;
            }
        });
    }

    /* renamed from: a */
    public void mo8649a(boolean z) {
        this.f4501b = z;
    }

    public void setRoot(final T t) {
        mo8648a((Callable<Boolean>) new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                C1288it.this.clear();
                C1288it.this.add(t);
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8648a(Callable<Boolean> callable) {
        boolean z;
        boolean a = mo8650a();
        mo8649a(false);
        try {
            z = callable.call().booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        mo8649a(a);
        if (z && a) {
            this.f4500a.notifyDataSetChanged();
        }
    }

    /* renamed from: it$a */
    class C1292a implements Iterator<T> {

        /* renamed from: b */
        private final Iterator<T> f4510b;

        public C1292a(Iterator<T> it) {
            this.f4510b = it;
        }

        public boolean hasNext() {
            return this.f4510b.hasNext();
        }

        public T next() {
            return this.f4510b.next();
        }

        public void remove() {
            this.f4510b.remove();
            if (C1288it.this.mo8650a()) {
                C1288it.this.f4500a.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: it$b */
    class C1293b implements ListIterator<T> {

        /* renamed from: b */
        private final ListIterator<T> f4512b;

        public C1293b(ListIterator<T> listIterator) {
            this.f4512b = listIterator;
        }

        public void add(T t) {
            this.f4512b.add(t);
            if (C1288it.this.mo8650a()) {
                C1288it.this.f4500a.notifyDataSetChanged();
            }
        }

        public boolean hasNext() {
            return this.f4512b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f4512b.hasPrevious();
        }

        public T next() {
            return this.f4512b.next();
        }

        public int nextIndex() {
            return this.f4512b.nextIndex();
        }

        public T previous() {
            return this.f4512b.previous();
        }

        public int previousIndex() {
            return this.f4512b.previousIndex();
        }

        public void remove() {
            this.f4512b.remove();
            if (C1288it.this.mo8650a()) {
                C1288it.this.f4500a.notifyDataSetChanged();
            }
        }

        public void set(T t) {
            this.f4512b.set(t);
            if (C1288it.this.mo8650a()) {
                C1288it.this.f4500a.notifyDataSetChanged();
            }
        }
    }
}
