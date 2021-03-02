package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.tasks.c */
final class C1952c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1968s f7431a;

    /* renamed from: b */
    final /* synthetic */ Callable f7432b;

    C1952c(C1968s sVar, Callable callable) {
        this.f7431a = sVar;
        this.f7432b = callable;
    }

    public void run() {
        try {
            this.f7431a.mo9830a(this.f7432b.call());
        } catch (Exception e) {
            this.f7431a.mo9829a(e);
        }
    }
}
