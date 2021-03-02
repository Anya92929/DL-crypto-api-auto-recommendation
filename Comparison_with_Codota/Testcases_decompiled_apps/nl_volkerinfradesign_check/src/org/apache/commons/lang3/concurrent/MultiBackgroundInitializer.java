package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {

    /* renamed from: a */
    private final Map<String, BackgroundInitializer<?>> f7111a = new HashMap();

    public MultiBackgroundInitializer() {
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        if (str == null) {
            throw new IllegalArgumentException("Name of child initializer must not be null!");
        } else if (backgroundInitializer == null) {
            throw new IllegalArgumentException("Child initializer must not be null!");
        } else {
            synchronized (this) {
                if (isStarted()) {
                    throw new IllegalStateException("addInitializer() must not be called after start()!");
                }
                this.f7111a.put(str, backgroundInitializer);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getTaskCount() {
        int i = 1;
        Iterator<BackgroundInitializer<?>> it = this.f7111a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getTaskCount() + i2;
        }
    }

    /* access modifiers changed from: protected */
    public MultiBackgroundInitializerResults initialize() throws Exception {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.f7111a);
        }
        ExecutorService activeExecutor = getActiveExecutor();
        for (BackgroundInitializer backgroundInitializer : hashMap.values()) {
            if (backgroundInitializer.getExternalExecutor() == null) {
                backgroundInitializer.setExternalExecutor(activeExecutor);
            }
            backgroundInitializer.start();
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).get());
            } catch (ConcurrentException e) {
                hashMap3.put(entry.getKey(), e);
            }
        }
        return new MultiBackgroundInitializerResults(hashMap, hashMap2, hashMap3);
    }

    public static class MultiBackgroundInitializerResults {

        /* renamed from: a */
        private final Map<String, BackgroundInitializer<?>> f7112a;

        /* renamed from: b */
        private final Map<String, Object> f7113b;

        /* renamed from: c */
        private final Map<String, ConcurrentException> f7114c;

        private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.f7112a = map;
            this.f7113b = map2;
            this.f7114c = map3;
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return m7405a(str);
        }

        public Object getResultObject(String str) {
            m7405a(str);
            return this.f7113b.get(str);
        }

        public boolean isException(String str) {
            m7405a(str);
            return this.f7114c.containsKey(str);
        }

        public ConcurrentException getException(String str) {
            m7405a(str);
            return this.f7114c.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.f7112a.keySet());
        }

        public boolean isSuccessful() {
            return this.f7114c.isEmpty();
        }

        /* renamed from: a */
        private BackgroundInitializer<?> m7405a(String str) {
            BackgroundInitializer<?> backgroundInitializer = this.f7112a.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException("No child initializer with name " + str);
        }
    }
}
