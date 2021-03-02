package android.support.p000v4.util;

/* renamed from: android.support.v4.util.Pools */
public final class Pools {

    /* renamed from: android.support.v4.util.Pools$Pool */
    public interface Pool {
        Object acquire();

        boolean release(Object obj);
    }

    /* renamed from: android.support.v4.util.Pools$SimplePool */
    public class SimplePool implements Pool {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i];
        }

        private boolean isInPool(Object obj) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == obj) {
                    return true;
                }
            }
            return false;
        }

        public Object acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i = this.mPoolSize - 1;
            Object obj = this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize--;
            return obj;
        }

        public boolean release(Object obj) {
            if (isInPool(obj)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.mPoolSize >= this.mPool.length) {
                return false;
            } else {
                this.mPool[this.mPoolSize] = obj;
                this.mPoolSize++;
                return true;
            }
        }
    }

    /* renamed from: android.support.v4.util.Pools$SynchronizedPool */
    public class SynchronizedPool extends SimplePool {
        private final Object mLock = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        public Object acquire() {
            Object acquire;
            synchronized (this.mLock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(Object obj) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(obj);
            }
            return release;
        }
    }

    private Pools() {
    }
}
