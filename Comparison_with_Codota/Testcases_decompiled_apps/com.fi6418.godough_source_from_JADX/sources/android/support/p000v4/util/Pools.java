package android.support.p000v4.util;

/* renamed from: android.support.v4.util.Pools */
public final class Pools {

    /* renamed from: android.support.v4.util.Pools$Pool */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* renamed from: android.support.v4.util.Pools$SimplePool */
    public class SimplePool<T> implements Pool<T> {

        /* renamed from: a */
        private final Object[] f1127a;

        /* renamed from: b */
        private int f1128b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1127a = new Object[i];
        }

        /* renamed from: a */
        private boolean m836a(T t) {
            for (int i = 0; i < this.f1128b; i++) {
                if (this.f1127a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            if (this.f1128b <= 0) {
                return null;
            }
            int i = this.f1128b - 1;
            T t = this.f1127a[i];
            this.f1127a[i] = null;
            this.f1128b--;
            return t;
        }

        public boolean release(T t) {
            if (m836a(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f1128b >= this.f1127a.length) {
                return false;
            } else {
                this.f1127a[this.f1128b] = t;
                this.f1128b++;
                return true;
            }
        }
    }

    /* renamed from: android.support.v4.util.Pools$SynchronizedPool */
    public class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: a */
        private final Object f1129a = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        public T acquire() {
            T acquire;
            synchronized (this.f1129a) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t) {
            boolean release;
            synchronized (this.f1129a) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
