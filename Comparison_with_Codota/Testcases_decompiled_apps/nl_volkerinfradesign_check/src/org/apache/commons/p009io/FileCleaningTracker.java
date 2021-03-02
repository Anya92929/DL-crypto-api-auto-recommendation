package org.apache.commons.p009io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: org.apache.commons.io.FileCleaningTracker */
public class FileCleaningTracker {

    /* renamed from: a */
    ReferenceQueue<Object> f6826a = new ReferenceQueue<>();

    /* renamed from: b */
    final Collection<C1944b> f6827b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c */
    final List<String> f6828c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    volatile boolean f6829d = false;

    /* renamed from: e */
    Thread f6830e;

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (file == null) {
            throw new NullPointerException("The file must not be null");
        }
        m7256a(file.getPath(), obj, fileDeleteStrategy);
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (str == null) {
            throw new NullPointerException("The path must not be null");
        }
        m7256a(str, obj, fileDeleteStrategy);
    }

    /* renamed from: a */
    private synchronized void m7256a(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (this.f6829d) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (this.f6830e == null) {
            this.f6830e = new C1943a();
            this.f6830e.start();
        }
        this.f6827b.add(new C1944b(str, fileDeleteStrategy, obj, this.f6826a));
    }

    public int getTrackCount() {
        return this.f6827b.size();
    }

    public List<String> getDeleteFailures() {
        return this.f6828c;
    }

    public synchronized void exitWhenFinished() {
        this.f6829d = true;
        if (this.f6830e != null) {
            synchronized (this.f6830e) {
                this.f6830e.interrupt();
            }
        }
    }

    /* renamed from: org.apache.commons.io.FileCleaningTracker$a */
    final class C1943a extends Thread {
        C1943a() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        public void run() {
            while (true) {
                if (!FileCleaningTracker.this.f6829d || FileCleaningTracker.this.f6827b.size() > 0) {
                    try {
                        C1944b bVar = (C1944b) FileCleaningTracker.this.f6826a.remove();
                        FileCleaningTracker.this.f6827b.remove(bVar);
                        if (!bVar.mo12494b()) {
                            FileCleaningTracker.this.f6828c.add(bVar.mo12493a());
                        }
                        bVar.clear();
                    } catch (InterruptedException e) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: org.apache.commons.io.FileCleaningTracker$b */
    static final class C1944b extends PhantomReference<Object> {

        /* renamed from: a */
        private final String f6832a;

        /* renamed from: b */
        private final FileDeleteStrategy f6833b;

        C1944b(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue<? super Object> referenceQueue) {
            super(obj, referenceQueue);
            this.f6832a = str;
            this.f6833b = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        /* renamed from: a */
        public String mo12493a() {
            return this.f6832a;
        }

        /* renamed from: b */
        public boolean mo12494b() {
            return this.f6833b.deleteQuietly(new File(this.f6832a));
        }
    }
}
