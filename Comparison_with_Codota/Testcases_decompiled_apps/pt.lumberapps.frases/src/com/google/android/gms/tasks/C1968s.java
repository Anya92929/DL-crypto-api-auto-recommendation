package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.s */
final class C1968s extends Task {

    /* renamed from: a */
    private final Object f7468a = new Object();

    /* renamed from: b */
    private final C1967r f7469b = new C1967r();

    /* renamed from: c */
    private boolean f7470c;

    /* renamed from: d */
    private Object f7471d;

    /* renamed from: e */
    private Exception f7472e;

    C1968s() {
    }

    /* renamed from: a */
    private void m8064a() {
        zzab.zza(this.f7470c, (Object) "Task is not yet complete");
    }

    /* renamed from: b */
    private void m8065b() {
        zzab.zza(!this.f7470c, (Object) "Task is already complete");
    }

    /* renamed from: c */
    private void m8066c() {
        synchronized (this.f7468a) {
            if (this.f7470c) {
                this.f7469b.mo9827a((Task) this);
            }
        }
    }

    /* renamed from: a */
    public void mo9829a(Exception exc) {
        zzab.zzb((Object) exc, (Object) "Exception must not be null");
        synchronized (this.f7468a) {
            m8065b();
            this.f7470c = true;
            this.f7472e = exc;
        }
        this.f7469b.mo9827a((Task) this);
    }

    /* renamed from: a */
    public void mo9830a(Object obj) {
        synchronized (this.f7468a) {
            m8065b();
            this.f7470c = true;
            this.f7471d = obj;
        }
        this.f7469b.mo9827a((Task) this);
    }

    public Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        C1960k kVar = new C1960k(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.f7469b.mo9828a((C1966q) kVar);
        C1969t.m8069b(activity).mo9831a(kVar);
        m8066c();
        return this;
    }

    public Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    public Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.f7469b.mo9828a((C1966q) new C1960k(executor, onCompleteListener));
        m8066c();
        return this;
    }

    public Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        C1962m mVar = new C1962m(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.f7469b.mo9828a((C1966q) mVar);
        C1969t.m8069b(activity).mo9831a(mVar);
        m8066c();
        return this;
    }

    public Task addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    public Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f7469b.mo9828a((C1966q) new C1962m(executor, onFailureListener));
        m8066c();
        return this;
    }

    public Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        C1964o oVar = new C1964o(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.f7469b.mo9828a((C1966q) oVar);
        C1969t.m8069b(activity).mo9831a(oVar);
        m8066c();
        return this;
    }

    public Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    public Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.f7469b.mo9828a((C1966q) new C1964o(executor, onSuccessListener));
        m8066c();
        return this;
    }

    public Task continueWith(Continuation continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public Task continueWith(Executor executor, Continuation continuation) {
        C1968s sVar = new C1968s();
        this.f7469b.mo9828a((C1966q) new C1956g(executor, continuation, sVar));
        m8066c();
        return sVar;
    }

    public Task continueWithTask(Continuation continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public Task continueWithTask(Executor executor, Continuation continuation) {
        C1968s sVar = new C1968s();
        this.f7469b.mo9828a((C1966q) new C1958i(executor, continuation, sVar));
        m8066c();
        return sVar;
    }

    public Exception getException() {
        Exception exc;
        synchronized (this.f7468a) {
            exc = this.f7472e;
        }
        return exc;
    }

    public Object getResult() {
        Object obj;
        synchronized (this.f7468a) {
            m8064a();
            if (this.f7472e != null) {
                throw new RuntimeExecutionException(this.f7472e);
            }
            obj = this.f7471d;
        }
        return obj;
    }

    public Object getResult(Class cls) {
        Object obj;
        synchronized (this.f7468a) {
            m8064a();
            if (cls.isInstance(this.f7472e)) {
                throw ((Throwable) cls.cast(this.f7472e));
            } else if (this.f7472e != null) {
                throw new RuntimeExecutionException(this.f7472e);
            } else {
                obj = this.f7471d;
            }
        }
        return obj;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f7468a) {
            z = this.f7470c;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.f7468a) {
            z = this.f7470c && this.f7472e == null;
        }
        return z;
    }
}
