package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Task<TResult> {
    /* access modifiers changed from: private */
    public static final ExecutorService defaultExecutor = Executors.newCachedThreadPool();
    private static final Executor immediateExecutor = new Executor() {
        private static final int MAX_DEPTH = 15;
        private ThreadLocal<Integer> executionDepth = new ThreadLocal<>();

        private int incrementDepth() {
            Integer oldDepth = this.executionDepth.get();
            if (oldDepth == null) {
                oldDepth = 0;
            }
            int newDepth = oldDepth.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(newDepth));
            return newDepth;
        }

        private int decrementDepth() {
            Integer oldDepth = this.executionDepth.get();
            if (oldDepth == null) {
                oldDepth = 0;
            }
            int newDepth = oldDepth.intValue() - 1;
            if (newDepth == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(newDepth));
            }
            return newDepth;
        }

        public void execute(Runnable command) {
            if (incrementDepth() <= 15) {
                try {
                    command.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                Task.defaultExecutor.execute(command);
            }
            decrementDepth();
        }
    };
    /* access modifiers changed from: private */
    public boolean cancelled;
    /* access modifiers changed from: private */
    public boolean complete;
    private List<Continuation<TResult, Void>> continuations = new ArrayList();
    /* access modifiers changed from: private */
    public Exception error;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public TResult result;

    private Task() {
    }

    public static <TResult> Task<TResult>.TaskCompletionSource create() {
        Task<TResult> task = new Task<>();
        task.getClass();
        return new TaskCompletionSource(task, (TaskCompletionSource) null);
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.complete;
        }
        return z;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.cancelled;
        }
        return z;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.lock) {
            z = this.error != null;
        }
        return z;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.lock) {
            tresult = this.result;
        }
        return tresult;
    }

    public Exception getError() {
        Exception exc;
        synchronized (this.lock) {
            exc = this.error;
        }
        return exc;
    }

    public void waitForCompletion() throws InterruptedException {
        synchronized (this.lock) {
            if (!isCompleted()) {
                this.lock.wait();
            }
        }
    }

    public static <TResult> Task<TResult> forResult(TResult value) {
        Task<TResult>.TaskCompletionSource tcs = create();
        tcs.setResult(value);
        return tcs.getTask();
    }

    public static <TResult> Task<TResult> forError(Exception error2) {
        Task<TResult>.TaskCompletionSource tcs = create();
        tcs.setError(error2);
        return tcs.getTask();
    }

    public static <TResult> Task<TResult> cancelled() {
        Task<TResult>.TaskCompletionSource tcs = create();
        tcs.setCancelled();
        return tcs.getTask();
    }

    public <TOut> Task<TOut> cast() {
        return this;
    }

    public Task<Void> makeVoid() {
        return continueWithTask(new Continuation<TResult, Task<Void>>() {
            public Task<Void> then(Task<TResult> task) throws Exception {
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                return Task.forResult(null);
            }
        });
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return call(callable, defaultExecutor);
    }

    public static <TResult> Task<TResult> call(final Callable<TResult> callable, Executor executor) {
        final Task<TResult>.TaskCompletionSource tcs = create();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    TaskCompletionSource.this.setResult(callable.call());
                } catch (Exception e) {
                    TaskCompletionSource.this.setError(e);
                }
            }
        });
        return tcs.getTask();
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(callable, immediateExecutor);
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> tasks) {
        final Task<TResult>.TaskCompletionSource create = create();
        if (tasks.size() == 0) {
            create.setResult(null);
        } else {
            final AtomicInteger count = new AtomicInteger(tasks.size());
            for (Task<?> task : tasks) {
                task.continueWith(new Continuation<Object, Void>() {
                    public Void then(Task<Object> task) {
                        if (count.decrementAndGet() == 0) {
                            create.setResult(null);
                        }
                        return null;
                    }
                });
            }
        }
        return create.getTask();
    }

    public Task<Void> continueWhile(Callable<Boolean> predicate, Continuation<Void, Task<Void>> continuation) {
        return continueWhile(predicate, continuation, immediateExecutor);
    }

    public Task<Void> continueWhile(Callable<Boolean> predicate, Continuation<Void, Task<Void>> continuation, Executor executor) {
        final Capture<Continuation<Void, Task<Void>>> predicateContinuation = new Capture<>();
        final Callable<Boolean> callable = predicate;
        final Continuation<Void, Task<Void>> continuation2 = continuation;
        final Executor executor2 = executor;
        predicateContinuation.set(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) throws Exception {
                if (((Boolean) callable.call()).booleanValue()) {
                    return Task.forResult(null).onSuccessTask(continuation2, executor2).onSuccessTask((Continuation) predicateContinuation.get(), executor2);
                }
                return Task.forResult(null);
            }
        });
        return makeVoid().continueWithTask(predicateContinuation.get(), executor);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation, final Executor executor) {
        boolean completed;
        final Task<TResult>.TaskCompletionSource create = create();
        synchronized (this.lock) {
            completed = isCompleted();
            if (!completed) {
                this.continuations.add(new Continuation<TResult, Void>() {
                    public Void then(Task<TResult> task) {
                        Task.completeImmediately(create, continuation, task, executor);
                        return null;
                    }
                });
            }
        }
        if (completed) {
            completeImmediately(create, continuation, this, executor);
        }
        return create.getTask();
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(continuation, immediateExecutor);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation, final Executor executor) {
        boolean completed;
        final Task<TResult>.TaskCompletionSource create = create();
        synchronized (this.lock) {
            completed = isCompleted();
            if (!completed) {
                this.continuations.add(new Continuation<TResult, Void>() {
                    public Void then(Task<TResult> task) {
                        Task.completeAfterTask(create, continuation, task, executor);
                        return null;
                    }
                });
            }
        }
        if (completed) {
            completeAfterTask(create, continuation, this, executor);
        }
        return create.getTask();
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(continuation, immediateExecutor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(final Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        return continueWithTask(new Continuation<TResult, Task<TContinuationResult>>() {
            public Task<TContinuationResult> then(Task<TResult> task) {
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                return task.continueWith(continuation);
            }
        }, executor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation) {
        return onSuccess(continuation, immediateExecutor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(final Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return continueWithTask(new Continuation<TResult, Task<TContinuationResult>>() {
            public Task<TContinuationResult> then(Task<TResult> task) {
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                return task.continueWithTask(continuation);
            }
        }, executor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return onSuccessTask(continuation, immediateExecutor);
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void completeImmediately(final Task<TContinuationResult>.TaskCompletionSource tcs, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, Executor executor) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    tcs.setResult(Continuation.this.then(task));
                } catch (Exception e) {
                    tcs.setError(e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void completeAfterTask(final Task<TContinuationResult>.TaskCompletionSource tcs, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, Executor executor) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    Task<TContinuationResult> result = (Task) Continuation.this.then(task);
                    if (result == null) {
                        tcs.setResult(null);
                        return;
                    }
                    final TaskCompletionSource taskCompletionSource = tcs;
                    result.continueWith(new Continuation<TContinuationResult, Void>() {
                        public Void then(Task<TContinuationResult> task) {
                            if (task.isCancelled()) {
                                taskCompletionSource.setCancelled();
                                return null;
                            } else if (task.isFaulted()) {
                                taskCompletionSource.setError(task.getError());
                                return null;
                            } else {
                                taskCompletionSource.setResult(task.getResult());
                                return null;
                            }
                        }
                    });
                } catch (Exception e) {
                    tcs.setError(e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void runContinuations() {
        synchronized (this.lock) {
            for (Continuation<TResult, ?> continuation : this.continuations) {
                try {
                    continuation.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.continuations = null;
        }
    }

    public class TaskCompletionSource {
        private TaskCompletionSource() {
        }

        /* synthetic */ TaskCompletionSource(Task task, TaskCompletionSource taskCompletionSource) {
            this();
        }

        public Task<TResult> getTask() {
            return Task.this;
        }

        public boolean trySetCancelled() {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.cancelled = true;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }

        public boolean trySetResult(TResult result) {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.result = result;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }

        public boolean trySetError(Exception error) {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.error = error;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }

        public void setCancelled() {
            if (!trySetCancelled()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }

        public void setResult(TResult result) {
            if (!trySetResult(result)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }

        public void setError(Exception error) {
            if (!trySetError(error)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }
    }
}
