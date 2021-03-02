package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> aal = new AtomicReference<>();

    public void flush() {
        EventIncrementCache eventIncrementCache = this.aal.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: kv */
    public abstract EventIncrementCache mo6740kv();

    /* renamed from: n */
    public void mo7319n(String str, int i) {
        EventIncrementCache eventIncrementCache = this.aal.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = mo6740kv();
            if (!this.aal.compareAndSet((Object) null, eventIncrementCache)) {
                eventIncrementCache = this.aal.get();
            }
        }
        eventIncrementCache.mo7316w(str, i);
    }
}
