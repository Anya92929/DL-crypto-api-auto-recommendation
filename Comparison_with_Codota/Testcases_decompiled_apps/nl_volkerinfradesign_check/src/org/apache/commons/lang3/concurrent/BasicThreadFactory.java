package org.apache.commons.lang3.concurrent;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class BasicThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final AtomicLong f7096a;

    /* renamed from: b */
    private final ThreadFactory f7097b;

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f7098c;

    /* renamed from: d */
    private final String f7099d;

    /* renamed from: e */
    private final Integer f7100e;

    /* renamed from: f */
    private final Boolean f7101f;

    private BasicThreadFactory(Builder builder) {
        if (builder.f7102a == null) {
            this.f7097b = Executors.defaultThreadFactory();
        } else {
            this.f7097b = builder.f7102a;
        }
        this.f7099d = builder.f7104c;
        this.f7100e = builder.f7105d;
        this.f7101f = builder.f7106e;
        this.f7098c = builder.f7103b;
        this.f7096a = new AtomicLong();
    }

    public final ThreadFactory getWrappedFactory() {
        return this.f7097b;
    }

    public final String getNamingPattern() {
        return this.f7099d;
    }

    public final Boolean getDaemonFlag() {
        return this.f7101f;
    }

    public final Integer getPriority() {
        return this.f7100e;
    }

    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.f7098c;
    }

    public long getThreadCount() {
        return this.f7096a.get();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = getWrappedFactory().newThread(runnable);
        m7396a(newThread);
        return newThread;
    }

    /* renamed from: a */
    private void m7396a(Thread thread) {
        if (getNamingPattern() != null) {
            Long valueOf = Long.valueOf(this.f7096a.incrementAndGet());
            thread.setName(String.format(getNamingPattern(), new Object[]{valueOf}));
        }
        if (getUncaughtExceptionHandler() != null) {
            thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
        }
        if (getPriority() != null) {
            thread.setPriority(getPriority().intValue());
        }
        if (getDaemonFlag() != null) {
            thread.setDaemon(getDaemonFlag().booleanValue());
        }
    }

    public static class Builder implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public ThreadFactory f7102a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Thread.UncaughtExceptionHandler f7103b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f7104c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Integer f7105d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Boolean f7106e;

        public Builder wrappedFactory(ThreadFactory threadFactory) {
            if (threadFactory == null) {
                throw new NullPointerException("Wrapped ThreadFactory must not be null!");
            }
            this.f7102a = threadFactory;
            return this;
        }

        public Builder namingPattern(String str) {
            if (str == null) {
                throw new NullPointerException("Naming pattern must not be null!");
            }
            this.f7104c = str;
            return this;
        }

        public Builder daemon(boolean z) {
            this.f7106e = Boolean.valueOf(z);
            return this;
        }

        public Builder priority(int i) {
            this.f7105d = Integer.valueOf(i);
            return this;
        }

        public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler == null) {
                throw new NullPointerException("Uncaught exception handler must not be null!");
            }
            this.f7103b = uncaughtExceptionHandler;
            return this;
        }

        public void reset() {
            this.f7102a = null;
            this.f7103b = null;
            this.f7104c = null;
            this.f7105d = null;
            this.f7106e = null;
        }

        public BasicThreadFactory build() {
            BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this);
            reset();
            return basicThreadFactory;
        }
    }
}
