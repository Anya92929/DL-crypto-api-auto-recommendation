package android.support.p000v4.app;

import android.os.Bundle;
import android.support.p000v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.LoaderManager */
public abstract class LoaderManager {

    /* renamed from: android.support.v4.app.LoaderManager$LoaderCallbacks */
    public interface LoaderCallbacks {
        Loader onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(Loader loader, Object obj);

        void onLoaderReset(Loader loader);
    }

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Loader getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract Loader initLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);

    public abstract Loader restartLoader(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);
}
