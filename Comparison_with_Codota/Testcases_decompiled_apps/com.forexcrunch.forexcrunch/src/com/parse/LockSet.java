package com.parse;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

class LockSet {
    private static long nextStableId = 0;
    private static WeakHashMap<Lock, Long> stableIds = new WeakHashMap<>();
    private final Set<Lock> locks = new TreeSet(new Comparator<Lock>() {
        public int compare(Lock lhs, Lock rhs) {
            return LockSet.getStableId(lhs).compareTo(LockSet.getStableId(rhs));
        }
    });

    public LockSet(Collection<Lock> locks2) {
        this.locks.addAll(locks2);
    }

    /* access modifiers changed from: private */
    public static Long getStableId(Lock lock) {
        Long valueOf;
        synchronized (stableIds) {
            if (stableIds.containsKey(lock)) {
                valueOf = stableIds.get(lock);
            } else {
                long id = nextStableId;
                nextStableId = 1 + id;
                stableIds.put(lock, Long.valueOf(id));
                valueOf = Long.valueOf(id);
            }
        }
        return valueOf;
    }

    public void lock() {
        for (Lock l : this.locks) {
            l.lock();
        }
    }

    public void unlock() {
        for (Lock l : this.locks) {
            l.unlock();
        }
    }
}
