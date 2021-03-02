package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object aaf = new Object();
    private Handler aag;
    private boolean aah;
    private HashMap<String, AtomicInteger> aai;
    private int aaj;

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.aag = new Handler(looper);
        this.aai = new HashMap<>();
        this.aaj = flushIntervalMillis;
    }

    /* access modifiers changed from: private */
    /* renamed from: kN */
    public void m3523kN() {
        synchronized (this.aaf) {
            this.aah = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.aaf) {
            for (Map.Entry next : this.aai.entrySet()) {
                mo6752q((String) next.getKey(), ((AtomicInteger) next.getValue()).get());
            }
            this.aai.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public abstract void mo6752q(String str, int i);

    /* renamed from: w */
    public void mo7316w(String str, int i) {
        synchronized (this.aaf) {
            if (!this.aah) {
                this.aah = true;
                this.aag.postDelayed(new Runnable() {
                    public void run() {
                        EventIncrementCache.this.m3523kN();
                    }
                }, (long) this.aaj);
            }
            AtomicInteger atomicInteger = this.aai.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.aai.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
