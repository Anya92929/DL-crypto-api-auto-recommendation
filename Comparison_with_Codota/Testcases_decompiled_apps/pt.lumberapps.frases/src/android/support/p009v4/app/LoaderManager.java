package android.support.p009v4.app;

import android.os.Bundle;
import android.support.p009v4.p010a.C0050p;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.LoaderManager */
public abstract class LoaderManager {

    /* renamed from: android.support.v4.app.LoaderManager$LoaderCallbacks */
    public interface LoaderCallbacks {
        C0050p onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C0050p pVar, Object obj);

        void onLoaderReset(C0050p pVar);
    }

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract C0050p getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract C0050p initLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);

    public abstract C0050p restartLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);
}
