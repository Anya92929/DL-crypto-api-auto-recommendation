package org.apache.commons.p009io;

import java.io.File;

@Deprecated
/* renamed from: org.apache.commons.io.FileCleaner */
public class FileCleaner {

    /* renamed from: a */
    static final FileCleaningTracker f6825a = new FileCleaningTracker();

    @Deprecated
    public static void track(File file, Object obj) {
        f6825a.track(file, obj);
    }

    @Deprecated
    public static void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        f6825a.track(file, obj, fileDeleteStrategy);
    }

    @Deprecated
    public static void track(String str, Object obj) {
        f6825a.track(str, obj);
    }

    @Deprecated
    public static void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        f6825a.track(str, obj, fileDeleteStrategy);
    }

    @Deprecated
    public static int getTrackCount() {
        return f6825a.getTrackCount();
    }

    @Deprecated
    public static synchronized void exitWhenFinished() {
        synchronized (FileCleaner.class) {
            f6825a.exitWhenFinished();
        }
    }

    public static FileCleaningTracker getInstance() {
        return f6825a;
    }
}
