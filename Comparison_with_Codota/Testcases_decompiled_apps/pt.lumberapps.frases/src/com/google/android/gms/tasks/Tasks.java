package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzab;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    /* renamed from: a */
    private static Object m8035a(Task task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    private static void m8036a(Task task, C1954e eVar) {
        task.addOnSuccessListener(TaskExecutors.f7429a, (OnSuccessListener) eVar);
        task.addOnFailureListener(TaskExecutors.f7429a, (OnFailureListener) eVar);
    }

    public static Object await(Task task) {
        zzab.zzate();
        zzab.zzb((Object) task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return m8035a(task);
        }
        C1953d dVar = new C1953d((C1952c) null);
        m8036a(task, dVar);
        dVar.mo9818a();
        return m8035a(task);
    }

    public static Object await(Task task, long j, TimeUnit timeUnit) {
        zzab.zzate();
        zzab.zzb((Object) task, (Object) "Task must not be null");
        zzab.zzb((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return m8035a(task);
        }
        C1953d dVar = new C1953d((C1952c) null);
        m8036a(task, dVar);
        if (dVar.mo9819a(j, timeUnit)) {
            return m8035a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task call(Callable callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static Task call(Executor executor, Callable callable) {
        zzab.zzb((Object) executor, (Object) "Executor must not be null");
        zzab.zzb((Object) callable, (Object) "Callback must not be null");
        C1968s sVar = new C1968s();
        executor.execute(new C1952c(sVar, callable));
        return sVar;
    }

    public static Task forException(Exception exc) {
        C1968s sVar = new C1968s();
        sVar.mo9829a(exc);
        return sVar;
    }

    public static Task forResult(Object obj) {
        C1968s sVar = new C1968s();
        sVar.mo9830a(obj);
        return sVar;
    }

    public static Task whenAll(Collection collection) {
        if (collection.isEmpty()) {
            return forResult((Object) null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((Task) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        C1968s sVar = new C1968s();
        C1955f fVar = new C1955f(collection.size(), sVar);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            m8036a((Task) it2.next(), fVar);
        }
        return sVar;
    }

    public static Task whenAll(Task... taskArr) {
        return taskArr.length == 0 ? forResult((Object) null) : whenAll((Collection) Arrays.asList(taskArr));
    }
}
