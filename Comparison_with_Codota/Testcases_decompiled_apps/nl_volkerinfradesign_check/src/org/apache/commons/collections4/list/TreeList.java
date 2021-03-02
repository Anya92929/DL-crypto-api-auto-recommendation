package org.apache.commons.collections4.list;

import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ArrayStack;
import org.apache.commons.collections4.OrderedIterator;

public class TreeList<E> extends AbstractList<E> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1870a<E> f6592a;

    /* renamed from: b */
    private int f6593b;

    public TreeList() {
    }

    public TreeList(Collection<? extends E> collection) {
        if (!collection.isEmpty()) {
            this.f6592a = new C1870a<>(collection);
            this.f6593b = collection.size();
        }
    }

    public E get(int i) {
        m7076a(i, 0, size() - 1);
        return this.f6592a.mo11886a(i).mo11885a();
    }

    public int size() {
        return this.f6593b;
    }

    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        m7076a(i, 0, size());
        return new C1871b(this, i);
    }

    public int indexOf(Object obj) {
        if (this.f6592a == null) {
            return -1;
        }
        return this.f6592a.mo11884a(obj, this.f6592a.f6599f);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        if (this.f6592a != null) {
            this.f6592a.mo11889a(objArr, this.f6592a.f6599f);
        }
        return objArr;
    }

    public void add(int i, E e) {
        this.modCount++;
        m7076a(i, 0, size());
        if (this.f6592a == null) {
            this.f6592a = new C1870a<>(i, e, (C1870a) null, (C1870a) null);
        } else {
            this.f6592a = this.f6592a.mo11887a(i, e);
        }
        this.f6593b++;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        this.modCount += collection.size();
        C1870a<E> aVar = new C1870a<>(collection);
        if (this.f6592a != null) {
            aVar = this.f6592a.m7085b(aVar, this.f6593b);
        }
        this.f6592a = aVar;
        this.f6593b += collection.size();
        return true;
    }

    public E set(int i, E e) {
        m7076a(i, 0, size() - 1);
        C1870a<E> a = this.f6592a.mo11886a(i);
        E b = a.f6600g;
        a.mo11888a(e);
        return b;
    }

    public E remove(int i) {
        this.modCount++;
        m7076a(i, 0, size() - 1);
        E e = get(i);
        this.f6592a = this.f6592a.mo11891b(i);
        this.f6593b--;
        return e;
    }

    public void clear() {
        this.modCount++;
        this.f6592a = null;
        this.f6593b = 0;
    }

    /* renamed from: a */
    private void m7076a(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IndexOutOfBoundsException("Invalid index:" + i + ", size=" + size());
        }
    }

    /* renamed from: org.apache.commons.collections4.list.TreeList$a */
    static class C1870a<E> {

        /* renamed from: a */
        private C1870a<E> f6594a;

        /* renamed from: b */
        private boolean f6595b;

        /* renamed from: c */
        private C1870a<E> f6596c;

        /* renamed from: d */
        private boolean f6597d;

        /* renamed from: e */
        private int f6598e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f6599f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public E f6600g;

        private C1870a(int i, E e, C1870a<E> aVar, C1870a<E> aVar2) {
            this.f6599f = i;
            this.f6600g = e;
            this.f6597d = true;
            this.f6595b = true;
            this.f6596c = aVar;
            this.f6594a = aVar2;
        }

        private C1870a(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, (C1870a) null, (C1870a) null);
        }

        private C1870a(Iterator<? extends E> it, int i, int i2, int i3, C1870a<E> aVar, C1870a<E> aVar2) {
            int i4 = i + ((i2 - i) / 2);
            if (i < i4) {
                this.f6594a = new C1870a<>(it, i, i4 - 1, i4, aVar, this);
            } else {
                this.f6595b = true;
                this.f6594a = aVar;
            }
            this.f6600g = it.next();
            this.f6599f = i4 - i3;
            if (i4 < i2) {
                this.f6596c = new C1870a<>(it, i4 + 1, i2, i4, this, aVar2);
            } else {
                this.f6597d = true;
                this.f6596c = aVar2;
            }
            m7098l();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public E mo11885a() {
            return this.f6600g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11888a(E e) {
            this.f6600g = e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1870a<E> mo11886a(int i) {
            int i2 = i - this.f6599f;
            if (i2 == 0) {
                return this;
            }
            C1870a d = i2 < 0 ? m7090d() : m7091e();
            if (d == null) {
                return null;
            }
            return d.mo11886a(i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo11884a(Object obj, int i) {
            int a;
            if (m7090d() != null && (a = this.f6594a.mo11884a(obj, this.f6594a.f6599f + i)) != -1) {
                return a;
            }
            if (this.f6600g == null) {
                if (this.f6600g == obj) {
                    return i;
                }
            } else if (this.f6600g.equals(obj)) {
                return i;
            }
            if (m7091e() != null) {
                return this.f6596c.mo11884a(obj, this.f6596c.f6599f + i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo11889a(Object[] objArr, int i) {
            objArr[i] = this.f6600g;
            if (m7090d() != null) {
                this.f6594a.mo11889a(objArr, this.f6594a.f6599f + i);
            }
            if (m7091e() != null) {
                this.f6596c.mo11889a(objArr, this.f6596c.f6599f + i);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1870a<E> mo11890b() {
            if (this.f6597d || this.f6596c == null) {
                return this.f6596c;
            }
            return this.f6596c.m7093g();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C1870a<E> mo11892c() {
            if (this.f6595b || this.f6594a == null) {
                return this.f6594a;
            }
            return this.f6594a.m7092f();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1870a<E> mo11887a(int i, E e) {
            int i2 = i - this.f6599f;
            if (i2 <= 0) {
                return m7084b(i2, e);
            }
            return m7088c(i2, e);
        }

        /* renamed from: b */
        private C1870a<E> m7084b(int i, E e) {
            if (m7090d() == null) {
                m7082a(new C1870a(-1, e, this, this.f6594a), (C1870a) null);
            } else {
                m7082a(this.f6594a.mo11887a(i, e), (C1870a<E>) null);
            }
            if (this.f6599f >= 0) {
                this.f6599f++;
            }
            C1870a<E> k = m7097k();
            m7098l();
            return k;
        }

        /* renamed from: c */
        private C1870a<E> m7088c(int i, E e) {
            if (m7091e() == null) {
                m7086b(new C1870a(1, e, this.f6596c, this), (C1870a) null);
            } else {
                m7086b(this.f6596c.mo11887a(i, e), (C1870a<E>) null);
            }
            if (this.f6599f < 0) {
                this.f6599f--;
            }
            C1870a<E> k = m7097k();
            m7098l();
            return k;
        }

        /* renamed from: d */
        private C1870a<E> m7090d() {
            if (this.f6595b) {
                return null;
            }
            return this.f6594a;
        }

        /* renamed from: e */
        private C1870a<E> m7091e() {
            if (this.f6597d) {
                return null;
            }
            return this.f6596c;
        }

        /* renamed from: f */
        private C1870a<E> m7092f() {
            return m7091e() == null ? this : this.f6596c.m7092f();
        }

        /* renamed from: g */
        private C1870a<E> m7093g() {
            return m7090d() == null ? this : this.f6594a.m7093g();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1870a<E> mo11891b(int i) {
            int i2 = i - this.f6599f;
            if (i2 == 0) {
                return m7096j();
            }
            if (i2 > 0) {
                m7086b(this.f6596c.mo11891b(i2), this.f6596c.f6596c);
                if (this.f6599f < 0) {
                    this.f6599f++;
                }
            } else {
                m7082a(this.f6594a.mo11891b(i2), this.f6594a.f6594a);
                if (this.f6599f > 0) {
                    this.f6599f--;
                }
            }
            m7098l();
            return m7097k();
        }

        /* renamed from: h */
        private C1870a<E> m7094h() {
            if (m7091e() == null) {
                return m7096j();
            }
            m7086b(this.f6596c.m7094h(), this.f6596c.f6596c);
            if (this.f6599f < 0) {
                this.f6599f++;
            }
            m7098l();
            return m7097k();
        }

        /* renamed from: i */
        private C1870a<E> m7095i() {
            if (m7090d() == null) {
                return m7096j();
            }
            m7082a(this.f6594a.m7095i(), this.f6594a.f6594a);
            if (this.f6599f > 0) {
                this.f6599f--;
            }
            m7098l();
            return m7097k();
        }

        /* renamed from: j */
        private C1870a<E> m7096j() {
            int i = 0;
            if (m7091e() == null && m7090d() == null) {
                return null;
            }
            if (m7091e() == null) {
                if (this.f6599f > 0) {
                    C1870a<E> aVar = this.f6594a;
                    int i2 = aVar.f6599f;
                    int i3 = this.f6599f;
                    if (this.f6599f <= 0) {
                        i = 1;
                    }
                    aVar.f6599f = i + i3 + i2;
                }
                this.f6594a.m7092f().m7086b((C1870a) null, (C1870a) this.f6596c);
                return this.f6594a;
            } else if (m7090d() == null) {
                C1870a<E> aVar2 = this.f6596c;
                int i4 = aVar2.f6599f;
                int i5 = this.f6599f;
                if (this.f6599f >= 0) {
                    i = 1;
                }
                aVar2.f6599f = (i5 - i) + i4;
                this.f6596c.m7093g().m7082a((C1870a) null, (C1870a) this.f6594a);
                return this.f6596c;
            } else {
                if (m7099m() > 0) {
                    C1870a<E> g = this.f6596c.m7093g();
                    this.f6600g = g.f6600g;
                    if (this.f6595b) {
                        this.f6594a = g.f6594a;
                    }
                    this.f6596c = this.f6596c.m7095i();
                    if (this.f6599f < 0) {
                        this.f6599f++;
                    }
                } else {
                    C1870a<E> f = this.f6594a.m7092f();
                    this.f6600g = f.f6600g;
                    if (this.f6597d) {
                        this.f6596c = f.f6596c;
                    }
                    C1870a<E> aVar3 = this.f6594a.f6594a;
                    this.f6594a = this.f6594a.m7094h();
                    if (this.f6594a == null) {
                        this.f6594a = aVar3;
                        this.f6595b = true;
                    }
                    if (this.f6599f > 0) {
                        this.f6599f--;
                    }
                }
                m7098l();
                return this;
            }
        }

        /* renamed from: k */
        private C1870a<E> m7097k() {
            switch (m7099m()) {
                case -2:
                    if (this.f6594a.m7099m() > 0) {
                        m7082a(this.f6594a.m7100n(), (C1870a<E>) null);
                    }
                    return m7101o();
                case -1:
                case 0:
                case 1:
                    return this;
                case 2:
                    if (this.f6596c.m7099m() < 0) {
                        m7086b(this.f6596c.m7101o(), (C1870a<E>) null);
                    }
                    return m7100n();
                default:
                    throw new RuntimeException("tree inconsistent!");
            }
        }

        /* renamed from: c */
        private int m7087c(C1870a<E> aVar) {
            if (aVar == null) {
                return 0;
            }
            return aVar.f6599f;
        }

        /* renamed from: a */
        private int m7080a(C1870a<E> aVar, int i) {
            if (aVar == null) {
                return 0;
            }
            int c = m7087c(aVar);
            aVar.f6599f = i;
            return c;
        }

        /* renamed from: l */
        private void m7098l() {
            int i = -1;
            int i2 = m7090d() == null ? -1 : m7090d().f6598e;
            if (m7091e() != null) {
                i = m7091e().f6598e;
            }
            this.f6598e = Math.max(i2, i) + 1;
        }

        /* renamed from: d */
        private int m7089d(C1870a<E> aVar) {
            if (aVar == null) {
                return -1;
            }
            return aVar.f6598e;
        }

        /* renamed from: m */
        private int m7099m() {
            return m7089d(m7091e()) - m7089d(m7090d());
        }

        /* renamed from: n */
        private C1870a<E> m7100n() {
            C1870a<E> aVar = this.f6596c;
            C1870a d = m7091e().m7090d();
            int c = this.f6599f + m7087c(aVar);
            m7086b(d, (C1870a) aVar);
            aVar.m7082a((C1870a<E>) this, (C1870a<E>) null);
            m7080a(aVar, c);
            m7080a(this, -aVar.f6599f);
            m7080a(d, m7087c(aVar) + m7087c(d));
            return aVar;
        }

        /* renamed from: o */
        private C1870a<E> m7101o() {
            C1870a<E> aVar = this.f6594a;
            C1870a e = m7090d().m7091e();
            int c = this.f6599f + m7087c(aVar);
            m7082a(e, (C1870a) aVar);
            aVar.m7086b((C1870a<E>) this, (C1870a<E>) null);
            m7080a(aVar, c);
            m7080a(this, -aVar.f6599f);
            m7080a(e, m7087c(aVar) + m7087c(e));
            return aVar;
        }

        /* renamed from: a */
        private void m7082a(C1870a<E> aVar, C1870a<E> aVar2) {
            this.f6595b = aVar == null;
            if (!this.f6595b) {
                aVar2 = aVar;
            }
            this.f6594a = aVar2;
            m7098l();
        }

        /* renamed from: b */
        private void m7086b(C1870a<E> aVar, C1870a<E> aVar2) {
            this.f6597d = aVar == null;
            if (!this.f6597d) {
                aVar2 = aVar;
            }
            this.f6596c = aVar2;
            m7098l();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public C1870a<E> m7085b(C1870a<E> aVar, int i) {
            int i2;
            int i3 = 0;
            C1870a<E> f = m7092f();
            C1870a<E> g = aVar.m7093g();
            if (aVar.f6598e > this.f6598e) {
                C1870a h = m7094h();
                ArrayStack arrayStack = new ArrayStack();
                int i4 = aVar.f6599f + i;
                C1870a<E> aVar2 = aVar;
                while (aVar2 != null && aVar2.f6598e > m7089d(h)) {
                    arrayStack.push(aVar2);
                    aVar2 = aVar2.f6594a;
                    if (aVar2 != null) {
                        int i5 = i4;
                        i4 = aVar2.f6599f + i4;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                }
                f.m7082a((C1870a<E>) h, (C1870a<E>) null);
                f.m7086b(aVar2, g);
                if (h != null) {
                    h.m7092f().m7086b((C1870a) null, (C1870a) f);
                    h.f6599f -= i - 1;
                }
                if (aVar2 != null) {
                    aVar2.m7093g().m7082a((C1870a) null, (C1870a) f);
                    aVar2.f6599f = (i4 - i) + 1;
                }
                f.f6599f = (i - 1) - i3;
                aVar.f6599f += i;
                while (true) {
                    g = f;
                    if (arrayStack.isEmpty()) {
                        break;
                    }
                    C1870a aVar3 = (C1870a) arrayStack.pop();
                    aVar3.m7082a(g, (C1870a<E>) null);
                    f = aVar3.m7097k();
                }
            } else {
                C1870a<E> i6 = aVar.m7095i();
                ArrayStack arrayStack2 = new ArrayStack();
                int i7 = this.f6599f;
                C1870a aVar4 = this;
                while (aVar4 != null && aVar4.f6598e > m7089d(i6)) {
                    arrayStack2.push(aVar4);
                    aVar4 = aVar4.f6596c;
                    if (aVar4 != null) {
                        int i8 = i7;
                        i7 = aVar4.f6599f + i7;
                        i2 = i8;
                    } else {
                        i2 = i7;
                    }
                }
                g.m7086b(i6, (C1870a<E>) null);
                g.m7082a((C1870a<E>) aVar4, f);
                if (i6 != null) {
                    i6.m7093g().m7082a((C1870a) null, (C1870a) g);
                    i6.f6599f++;
                }
                if (aVar4 != null) {
                    aVar4.m7092f().m7086b((C1870a) null, (C1870a) g);
                    aVar4.f6599f = i7 - i;
                }
                g.f6599f = i - i3;
                while (!arrayStack2.isEmpty()) {
                    C1870a aVar5 = (C1870a) arrayStack2.pop();
                    aVar5.m7086b(g, (C1870a<E>) null);
                    g = aVar5.m7097k();
                }
            }
            return g;
        }

        public String toString() {
            boolean z = true;
            StringBuilder append = new StringBuilder().append("AVLNode(").append(this.f6599f).append(',').append(this.f6594a != null).append(',').append(this.f6600g).append(',');
            if (m7091e() == null) {
                z = false;
            }
            return append.append(z).append(", faedelung ").append(this.f6597d).append(" )").toString();
        }
    }

    /* renamed from: org.apache.commons.collections4.list.TreeList$b */
    static class C1871b<E> implements ListIterator<E>, OrderedIterator<E> {

        /* renamed from: a */
        private final TreeList<E> f6601a;

        /* renamed from: b */
        private C1870a<E> f6602b;

        /* renamed from: c */
        private int f6603c;

        /* renamed from: d */
        private C1870a<E> f6604d;

        /* renamed from: e */
        private int f6605e;

        /* renamed from: f */
        private int f6606f;

        protected C1871b(TreeList<E> treeList, int i) throws IndexOutOfBoundsException {
            this.f6601a = treeList;
            this.f6606f = treeList.modCount;
            this.f6602b = treeList.f6592a == null ? null : treeList.f6592a.mo11886a(i);
            this.f6603c = i;
            this.f6605e = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo11894a() {
            if (this.f6601a.modCount != this.f6606f) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            return this.f6603c < this.f6601a.size();
        }

        public E next() {
            mo11894a();
            if (!hasNext()) {
                throw new NoSuchElementException("No element at index " + this.f6603c + ".");
            }
            if (this.f6602b == null) {
                this.f6602b = this.f6601a.f6592a.mo11886a(this.f6603c);
            }
            E a = this.f6602b.mo11885a();
            this.f6604d = this.f6602b;
            int i = this.f6603c;
            this.f6603c = i + 1;
            this.f6605e = i;
            this.f6602b = this.f6602b.mo11890b();
            return a;
        }

        public boolean hasPrevious() {
            return this.f6603c > 0;
        }

        public E previous() {
            mo11894a();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            if (this.f6602b == null) {
                this.f6602b = this.f6601a.f6592a.mo11886a(this.f6603c - 1);
            } else {
                this.f6602b = this.f6602b.mo11892c();
            }
            E a = this.f6602b.mo11885a();
            this.f6604d = this.f6602b;
            int i = this.f6603c - 1;
            this.f6603c = i;
            this.f6605e = i;
            return a;
        }

        public int nextIndex() {
            return this.f6603c;
        }

        public int previousIndex() {
            return nextIndex() - 1;
        }

        public void remove() {
            mo11894a();
            if (this.f6605e == -1) {
                throw new IllegalStateException();
            }
            this.f6601a.remove(this.f6605e);
            if (this.f6603c != this.f6605e) {
                this.f6603c--;
            }
            this.f6602b = null;
            this.f6604d = null;
            this.f6605e = -1;
            this.f6606f++;
        }

        public void set(E e) {
            mo11894a();
            if (this.f6604d == null) {
                throw new IllegalStateException();
            }
            this.f6604d.mo11888a(e);
        }

        public void add(E e) {
            mo11894a();
            this.f6601a.add(this.f6603c, e);
            this.f6604d = null;
            this.f6605e = -1;
            this.f6603c++;
            this.f6606f++;
        }
    }
}
