package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.tasks.f */
final class C1955f implements C1954e {

    /* renamed from: a */
    private final Object f7434a = new Object();

    /* renamed from: b */
    private final int f7435b;

    /* renamed from: c */
    private final C1968s f7436c;

    /* renamed from: d */
    private int f7437d;

    /* renamed from: e */
    private int f7438e;

    /* renamed from: f */
    private Exception f7439f;

    public C1955f(int i, C1968s sVar) {
        this.f7435b = i;
        this.f7436c = sVar;
    }

    /* renamed from: a */
    private void m8039a() {
        if (this.f7437d + this.f7438e != this.f7435b) {
            return;
        }
        if (this.f7439f == null) {
            this.f7436c.mo9830a((Object) null);
            return;
        }
        C1968s sVar = this.f7436c;
        int i = this.f7438e;
        sVar.mo9829a((Exception) new ExecutionException(new StringBuilder(54).append(i).append(" out of ").append(this.f7435b).append(" underlying tasks failed").toString(), this.f7439f));
    }

    public void onFailure(Exception exc) {
        synchronized (this.f7434a) {
            this.f7438e++;
            this.f7439f = exc;
            m8039a();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.f7434a) {
            this.f7437d++;
            m8039a();
        }
    }
}
