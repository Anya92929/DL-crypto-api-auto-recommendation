package p000;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: jp */
public final class C1329jp implements Serializable, Iterable<Character> {
    private static final long serialVersionUID = 8270183163158333422L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final char f4591a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final char f4592b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f4593c;

    /* renamed from: d */
    private transient String f4594d;

    private C1329jp(char c, char c2, boolean z) {
        if (c <= c2) {
            char c3 = c2;
            c2 = c;
            c = c3;
        }
        this.f4591a = c2;
        this.f4592b = c;
        this.f4593c = z;
    }

    /* renamed from: a */
    public static C1329jp m5725a(char c) {
        return new C1329jp(c, c, false);
    }

    /* renamed from: b */
    public static C1329jp m5729b(char c) {
        return new C1329jp(c, c, true);
    }

    /* renamed from: a */
    public static C1329jp m5726a(char c, char c2) {
        return new C1329jp(c, c2, false);
    }

    /* renamed from: b */
    public static C1329jp m5730b(char c, char c2) {
        return new C1329jp(c, c2, true);
    }

    /* renamed from: a */
    public boolean mo8850a() {
        return this.f4593c;
    }

    /* renamed from: c */
    public boolean mo8851c(char c) {
        return (c >= this.f4591a && c <= this.f4592b) != this.f4593c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1329jp)) {
            return false;
        }
        C1329jp jpVar = (C1329jp) obj;
        if (this.f4591a == jpVar.f4591a && this.f4592b == jpVar.f4592b && this.f4593c == jpVar.f4593c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f4593c ? 1 : 0) + (this.f4592b * 7) + this.f4591a + 'S';
    }

    public String toString() {
        if (this.f4594d == null) {
            StringBuilder sb = new StringBuilder(4);
            if (mo8850a()) {
                sb.append('^');
            }
            sb.append(this.f4591a);
            if (this.f4591a != this.f4592b) {
                sb.append('-');
                sb.append(this.f4592b);
            }
            this.f4594d = sb.toString();
        }
        return this.f4594d;
    }

    public Iterator<Character> iterator() {
        return new C1331a();
    }

    /* renamed from: jp$a */
    static class C1331a implements Iterator<Character> {

        /* renamed from: a */
        private char f4595a;

        /* renamed from: b */
        private final C1329jp f4596b;

        /* renamed from: c */
        private boolean f4597c;

        private C1331a(C1329jp jpVar) {
            this.f4596b = jpVar;
            this.f4597c = true;
            if (!this.f4596b.f4593c) {
                this.f4595a = this.f4596b.f4591a;
            } else if (this.f4596b.f4591a != 0) {
                this.f4595a = 0;
            } else if (this.f4596b.f4592b == 65535) {
                this.f4597c = false;
            } else {
                this.f4595a = (char) (this.f4596b.f4592b + 1);
            }
        }

        /* renamed from: b */
        private void m5734b() {
            if (this.f4596b.f4593c) {
                if (this.f4595a == 65535) {
                    this.f4597c = false;
                } else if (this.f4595a + 1 != this.f4596b.f4591a) {
                    this.f4595a = (char) (this.f4595a + 1);
                } else if (this.f4596b.f4592b == 65535) {
                    this.f4597c = false;
                } else {
                    this.f4595a = (char) (this.f4596b.f4592b + 1);
                }
            } else if (this.f4595a < this.f4596b.f4592b) {
                this.f4595a = (char) (this.f4595a + 1);
            } else {
                this.f4597c = false;
            }
        }

        public boolean hasNext() {
            return this.f4597c;
        }

        /* renamed from: a */
        public Character next() {
            if (!this.f4597c) {
                throw new NoSuchElementException();
            }
            char c = this.f4595a;
            m5734b();
            return Character.valueOf(c);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
