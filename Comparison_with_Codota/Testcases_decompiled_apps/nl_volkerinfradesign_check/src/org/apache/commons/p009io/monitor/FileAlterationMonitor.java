package org.apache.commons.p009io.monitor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/* renamed from: org.apache.commons.io.monitor.FileAlterationMonitor */
public final class FileAlterationMonitor implements Runnable {

    /* renamed from: a */
    private final long f6961a;

    /* renamed from: b */
    private final List<FileAlterationObserver> f6962b;

    /* renamed from: c */
    private Thread f6963c;

    /* renamed from: d */
    private ThreadFactory f6964d;

    /* renamed from: e */
    private volatile boolean f6965e;

    public FileAlterationMonitor() {
        this(10000);
    }

    public FileAlterationMonitor(long j) {
        this.f6962b = new CopyOnWriteArrayList();
        this.f6963c = null;
        this.f6965e = false;
        this.f6961a = j;
    }

    public FileAlterationMonitor(long j, FileAlterationObserver... fileAlterationObserverArr) {
        this(j);
        if (fileAlterationObserverArr != null) {
            for (FileAlterationObserver addObserver : fileAlterationObserverArr) {
                addObserver(addObserver);
            }
        }
    }

    public long getInterval() {
        return this.f6961a;
    }

    public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.f6964d = threadFactory;
    }

    public void addObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            this.f6962b.add(fileAlterationObserver);
        }
    }

    public void removeObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            do {
            } while (this.f6962b.remove(fileAlterationObserver));
        }
    }

    public Iterable<FileAlterationObserver> getObservers() {
        return this.f6962b;
    }

    public synchronized void start() throws Exception {
        if (this.f6965e) {
            throw new IllegalStateException("Monitor is already running");
        }
        for (FileAlterationObserver initialize : this.f6962b) {
            initialize.initialize();
        }
        this.f6965e = true;
        if (this.f6964d != null) {
            this.f6963c = this.f6964d.newThread(this);
        } else {
            this.f6963c = new Thread(this);
        }
        this.f6963c.start();
    }

    public synchronized void stop() throws Exception {
        stop(this.f6961a);
    }

    public synchronized void stop(long j) throws Exception {
        if (!this.f6965e) {
            throw new IllegalStateException("Monitor is not running");
        }
        this.f6965e = false;
        try {
            this.f6963c.join(j);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for (FileAlterationObserver destroy : this.f6962b) {
            destroy.destroy();
        }
    }

    public void run() {
        while (this.f6965e) {
            for (FileAlterationObserver checkAndNotify : this.f6962b) {
                checkAndNotify.checkAndNotify();
            }
            if (this.f6965e) {
                try {
                    Thread.sleep(this.f6961a);
                } catch (InterruptedException e) {
                }
            } else {
                return;
            }
        }
    }
}
