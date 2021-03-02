package android.support.p000v4.app;

import android.os.Bundle;
import android.support.p000v4.app.LoaderManager;
import android.support.p000v4.content.Loader;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.app.LoaderManagerImpl */
class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a */
    static boolean f550a = false;

    /* renamed from: b */
    final SparseArrayCompat<LoaderInfo> f551b = new SparseArrayCompat<>();

    /* renamed from: c */
    final SparseArrayCompat<LoaderInfo> f552c = new SparseArrayCompat<>();

    /* renamed from: d */
    final String f553d;

    /* renamed from: e */
    boolean f554e;

    /* renamed from: f */
    boolean f555f;

    /* renamed from: g */
    boolean f556g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FragmentHostCallback f557h;

    /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderInfo */
    final class LoaderInfo implements Loader.OnLoadCanceledListener<Object>, Loader.OnLoadCompleteListener<Object> {

        /* renamed from: a */
        final int f558a;

        /* renamed from: b */
        final Bundle f559b;

        /* renamed from: c */
        LoaderManager.LoaderCallbacks<Object> f560c;

        /* renamed from: d */
        Loader<Object> f561d;

        /* renamed from: e */
        boolean f562e;

        /* renamed from: f */
        boolean f563f;

        /* renamed from: g */
        Object f564g;

        /* renamed from: h */
        boolean f565h;

        /* renamed from: i */
        boolean f566i;

        /* renamed from: j */
        boolean f567j;

        /* renamed from: k */
        boolean f568k;

        /* renamed from: l */
        boolean f569l;

        /* renamed from: m */
        boolean f570m;

        /* renamed from: n */
        LoaderInfo f571n;

        public LoaderInfo(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
            this.f558a = i;
            this.f559b = bundle;
            this.f560c = loaderCallbacks;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo863a() {
            if (this.f566i && this.f567j) {
                this.f565h = true;
            } else if (!this.f565h) {
                this.f565h = true;
                if (LoaderManagerImpl.f550a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f561d == null && this.f560c != null) {
                    this.f561d = this.f560c.onCreateLoader(this.f558a, this.f559b);
                }
                if (this.f561d == null) {
                    return;
                }
                if (!this.f561d.getClass().isMemberClass() || Modifier.isStatic(this.f561d.getClass().getModifiers())) {
                    if (!this.f570m) {
                        this.f561d.registerListener(this.f558a, this);
                        this.f561d.registerOnLoadCanceledListener(this);
                        this.f570m = true;
                    }
                    this.f561d.startLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f561d);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo864a(Loader<Object> loader, Object obj) {
            String str;
            if (this.f560c != null) {
                if (LoaderManagerImpl.this.f557h != null) {
                    String str2 = LoaderManagerImpl.this.f557h.f430d.f460u;
                    LoaderManagerImpl.this.f557h.f430d.f460u = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (LoaderManagerImpl.f550a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.dataToString(obj));
                    }
                    this.f560c.onLoadFinished(loader, obj);
                    this.f563f = true;
                } finally {
                    if (LoaderManagerImpl.this.f557h != null) {
                        LoaderManagerImpl.this.f557h.f430d.f460u = str;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo865b() {
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f566i = true;
            this.f567j = this.f565h;
            this.f565h = false;
            this.f560c = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo866c() {
            if (this.f566i) {
                if (LoaderManagerImpl.f550a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f566i = false;
                if (this.f565h != this.f567j && !this.f565h) {
                    mo869e();
                }
            }
            if (this.f565h && this.f562e && !this.f568k) {
                mo864a(this.f561d, this.f564g);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo867d() {
            if (this.f565h && this.f568k) {
                this.f568k = false;
                if (this.f562e) {
                    mo864a(this.f561d, this.f564g);
                }
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f558a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f559b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f560c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f561d);
            if (this.f561d != null) {
                this.f561d.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f562e || this.f563f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f562e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f563f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f564g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f565h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f568k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f569l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f566i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f567j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f570m);
            if (this.f571n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f571n);
                printWriter.println(":");
                this.f571n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo869e() {
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f565h = false;
            if (!this.f566i && this.f561d != null && this.f570m) {
                this.f570m = false;
                this.f561d.unregisterListener(this);
                this.f561d.unregisterOnLoadCanceledListener(this);
                this.f561d.stopLoading();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo870f() {
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Canceling: " + this);
            }
            if (this.f565h && this.f561d != null && this.f570m && !this.f561d.cancelLoad()) {
                onLoadCanceled(this.f561d);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo871g() {
            String str;
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f569l = true;
            boolean z = this.f563f;
            this.f563f = false;
            if (this.f560c != null && this.f561d != null && this.f562e && z) {
                if (LoaderManagerImpl.f550a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (LoaderManagerImpl.this.f557h != null) {
                    String str2 = LoaderManagerImpl.this.f557h.f430d.f460u;
                    LoaderManagerImpl.this.f557h.f430d.f460u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f560c.onLoaderReset(this.f561d);
                } finally {
                    if (LoaderManagerImpl.this.f557h != null) {
                        LoaderManagerImpl.this.f557h.f430d.f460u = str;
                    }
                }
            }
            this.f560c = null;
            this.f564g = null;
            this.f562e = false;
            if (this.f561d != null) {
                if (this.f570m) {
                    this.f570m = false;
                    this.f561d.unregisterListener(this);
                    this.f561d.unregisterOnLoadCanceledListener(this);
                }
                this.f561d.reset();
            }
            if (this.f571n != null) {
                this.f571n.mo871g();
            }
        }

        public void onLoadCanceled(Loader<Object> loader) {
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.f569l) {
                if (LoaderManagerImpl.f550a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (LoaderManagerImpl.this.f551b.get(this.f558a) == this) {
                LoaderInfo loaderInfo = this.f571n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f550a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo);
                    }
                    this.f571n = null;
                    LoaderManagerImpl.this.f551b.put(this.f558a, null);
                    mo871g();
                    LoaderManagerImpl.this.mo855a(loaderInfo);
                }
            } else if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void onLoadComplete(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.f569l) {
                if (LoaderManagerImpl.f550a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (LoaderManagerImpl.this.f551b.get(this.f558a) == this) {
                LoaderInfo loaderInfo = this.f571n;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.f550a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + loaderInfo);
                    }
                    this.f571n = null;
                    LoaderManagerImpl.this.f551b.put(this.f558a, null);
                    mo871g();
                    LoaderManagerImpl.this.mo855a(loaderInfo);
                    return;
                }
                if (this.f564g != obj || !this.f562e) {
                    this.f564g = obj;
                    this.f562e = true;
                    if (this.f565h) {
                        mo864a(loader, obj);
                    }
                }
                LoaderInfo loaderInfo2 = LoaderManagerImpl.this.f552c.get(this.f558a);
                if (!(loaderInfo2 == null || loaderInfo2 == this)) {
                    loaderInfo2.f563f = false;
                    loaderInfo2.mo871g();
                    LoaderManagerImpl.this.f552c.remove(this.f558a);
                }
                if (LoaderManagerImpl.this.f557h != null && !LoaderManagerImpl.this.hasRunningLoaders()) {
                    LoaderManagerImpl.this.f557h.f430d.mo728a();
                }
            } else if (LoaderManagerImpl.f550a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f558a);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.f561d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.f553d = str;
        this.f557h = fragmentHostCallback;
        this.f554e = z;
    }

    /* renamed from: a */
    private LoaderInfo m529a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo = new LoaderInfo(i, bundle, loaderCallbacks);
        loaderInfo.f561d = loaderCallbacks.onCreateLoader(i, bundle);
        return loaderInfo;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private LoaderInfo m530b(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.f556g = true;
            LoaderInfo a = m529a(i, bundle, loaderCallbacks);
            mo855a(a);
            this.f556g = false;
            return a;
        } catch (Throwable th) {
            this.f556g = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo853a() {
        if (f550a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f554e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f554e = true;
        for (int size = this.f551b.size() - 1; size >= 0; size--) {
            this.f551b.valueAt(size).mo863a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo854a(FragmentHostCallback fragmentHostCallback) {
        this.f557h = fragmentHostCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo855a(LoaderInfo loaderInfo) {
        this.f551b.put(loaderInfo.f558a, loaderInfo);
        if (this.f554e) {
            loaderInfo.mo863a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo856b() {
        if (f550a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f554e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int size = this.f551b.size() - 1; size >= 0; size--) {
            this.f551b.valueAt(size).mo869e();
        }
        this.f554e = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo857c() {
        if (f550a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f554e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f555f = true;
        this.f554e = false;
        for (int size = this.f551b.size() - 1; size >= 0; size--) {
            this.f551b.valueAt(size).mo865b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo858d() {
        if (this.f555f) {
            if (f550a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f555f = false;
            for (int size = this.f551b.size() - 1; size >= 0; size--) {
                this.f551b.valueAt(size).mo866c();
            }
        }
    }

    public void destroyLoader(int i) {
        if (this.f556g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (f550a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        int indexOfKey = this.f551b.indexOfKey(i);
        if (indexOfKey >= 0) {
            this.f551b.removeAt(indexOfKey);
            this.f551b.valueAt(indexOfKey).mo871g();
        }
        int indexOfKey2 = this.f552c.indexOfKey(i);
        if (indexOfKey2 >= 0) {
            this.f552c.removeAt(indexOfKey2);
            this.f552c.valueAt(indexOfKey2).mo871g();
        }
        if (this.f557h != null && !hasRunningLoaders()) {
            this.f557h.f430d.mo728a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f551b.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f551b.size(); i++) {
                LoaderInfo valueAt = this.f551b.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f551b.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f552c.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f552c.size(); i2++) {
                LoaderInfo valueAt2 = this.f552c.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f552c.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo859e() {
        for (int size = this.f551b.size() - 1; size >= 0; size--) {
            this.f551b.valueAt(size).f568k = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo860f() {
        for (int size = this.f551b.size() - 1; size >= 0; size--) {
            this.f551b.valueAt(size).mo867d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo861g() {
        if (!this.f555f) {
            if (f550a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.f551b.size() - 1; size >= 0; size--) {
                this.f551b.valueAt(size).mo871g();
            }
            this.f551b.clear();
        }
        if (f550a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.f552c.size() - 1; size2 >= 0; size2--) {
            this.f552c.valueAt(size2).mo871g();
        }
        this.f552c.clear();
    }

    public <D> Loader<D> getLoader(int i) {
        if (this.f556g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = this.f551b.get(i);
        if (loaderInfo != null) {
            return loaderInfo.f571n != null ? loaderInfo.f571n.f561d : loaderInfo.f561d;
        }
        return null;
    }

    public boolean hasRunningLoaders() {
        int size = this.f551b.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            LoaderInfo valueAt = this.f551b.valueAt(i);
            z |= valueAt.f565h && !valueAt.f563f;
        }
        return z;
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f556g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = this.f551b.get(i);
        if (f550a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo == null) {
            loaderInfo = m530b(i, bundle, loaderCallbacks);
            if (f550a) {
                Log.v("LoaderManager", "  Created new loader " + loaderInfo);
            }
        } else {
            if (f550a) {
                Log.v("LoaderManager", "  Re-using existing loader " + loaderInfo);
            }
            loaderInfo.f560c = loaderCallbacks;
        }
        if (loaderInfo.f562e && this.f554e) {
            loaderInfo.mo864a(loaderInfo.f561d, loaderInfo.f564g);
        }
        return loaderInfo.f561d;
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f556g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = this.f551b.get(i);
        if (f550a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (loaderInfo != null) {
            LoaderInfo loaderInfo2 = this.f552c.get(i);
            if (loaderInfo2 == null) {
                if (f550a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + loaderInfo);
                }
                loaderInfo.f561d.abandon();
                this.f552c.put(i, loaderInfo);
            } else if (loaderInfo.f562e) {
                if (f550a) {
                    Log.v("LoaderManager", "  Removing last inactive loader: " + loaderInfo);
                }
                loaderInfo2.f563f = false;
                loaderInfo2.mo871g();
                loaderInfo.f561d.abandon();
                this.f552c.put(i, loaderInfo);
            } else if (!loaderInfo.f565h) {
                if (f550a) {
                    Log.v("LoaderManager", "  Current loader is stopped; replacing");
                }
                this.f551b.put(i, null);
                loaderInfo.mo871g();
            } else {
                if (f550a) {
                    Log.v("LoaderManager", "  Current loader is running; attempting to cancel");
                }
                loaderInfo.mo870f();
                if (loaderInfo.f571n != null) {
                    if (f550a) {
                        Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.f571n);
                    }
                    loaderInfo.f571n.mo871g();
                    loaderInfo.f571n = null;
                }
                if (f550a) {
                    Log.v("LoaderManager", "  Enqueuing as new pending loader");
                }
                loaderInfo.f571n = m529a(i, bundle, loaderCallbacks);
                return loaderInfo.f571n.f561d;
            }
        }
        return m530b(i, bundle, loaderCallbacks).f561d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f557h, sb);
        sb.append("}}");
        return sb.toString();
    }
}
