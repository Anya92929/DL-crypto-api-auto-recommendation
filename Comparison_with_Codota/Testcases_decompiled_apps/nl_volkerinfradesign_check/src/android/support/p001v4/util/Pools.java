package android.support.p001v4.util;

/* renamed from: android.support.v4.util.Pools */
public final class Pools {

    /* renamed from: android.support.v4.util.Pools$Pool */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    private Pools() {
    }

    /* renamed from: android.support.v4.util.Pools$SimplePool */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a */
        private final Object[] f872a;

        /* renamed from: b */
        private int f873b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f872a = new Object[i];
        }

        public T acquire() {
            if (this.f873b <= 0) {
                return null;
            }
            int i = this.f873b - 1;
            T t = this.f872a[i];
            this.f872a[i] = null;
            this.f873b--;
            return t;
        }

        public boolean release(T t) {
            if (m989a(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f873b >= this.f872a.length) {
                return false;
            } else {
                this.f872a[this.f873b] = t;
                this.f873b++;
                return true;
            }
        }

        /* renamed from: a */
        private boolean m989a(T t) {
            for (int i = 0; i < this.f873b; i++) {
                if (this.f872a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.util.Pools$SynchronizedPool */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: a */
        private final Object f874a = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        public T acquire() {
            T acquire;
            synchronized (this.f874a) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t) {
            boolean release;
            synchronized (this.f874a) {
                release = super.release(t);
            }
            return release;
        }
    }
}
