package p000;

import android.os.Bundle;
import android.support.p001v4.app.FragmentHostCallback;
import android.support.p001v4.app.LoaderManager;
import android.support.p001v4.content.Loader;
import android.support.p001v4.util.DebugUtils;
import android.support.p001v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: w */
public class C2014w extends LoaderManager {

    /* renamed from: a */
    public static boolean f7331a = false;

    /* renamed from: b */
    final SparseArrayCompat<C2015a> f7332b = new SparseArrayCompat<>();

    /* renamed from: c */
    final SparseArrayCompat<C2015a> f7333c = new SparseArrayCompat<>();

    /* renamed from: d */
    public final String f7334d;

    /* renamed from: e */
    public boolean f7335e;

    /* renamed from: f */
    public boolean f7336f;

    /* renamed from: g */
    boolean f7337g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FragmentHostCallback f7338h;

    /* renamed from: w$a */
    final class C2015a implements Loader.OnLoadCanceledListener<Object>, Loader.OnLoadCompleteListener<Object> {

        /* renamed from: a */
        final int f7339a;

        /* renamed from: b */
        final Bundle f7340b;

        /* renamed from: c */
        LoaderManager.LoaderCallbacks<Object> f7341c;

        /* renamed from: d */
        Loader<Object> f7342d;

        /* renamed from: e */
        boolean f7343e;

        /* renamed from: f */
        boolean f7344f;

        /* renamed from: g */
        Object f7345g;

        /* renamed from: h */
        boolean f7346h;

        /* renamed from: i */
        boolean f7347i;

        /* renamed from: j */
        boolean f7348j;

        /* renamed from: k */
        boolean f7349k;

        /* renamed from: l */
        boolean f7350l;

        /* renamed from: m */
        boolean f7351m;

        /* renamed from: n */
        C2015a f7352n;

        public C2015a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
            this.f7339a = i;
            this.f7340b = bundle;
            this.f7341c = loaderCallbacks;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13857a() {
            if (this.f7347i && this.f7348j) {
                this.f7346h = true;
            } else if (!this.f7346h) {
                this.f7346h = true;
                if (C2014w.f7331a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f7342d == null && this.f7341c != null) {
                    this.f7342d = this.f7341c.onCreateLoader(this.f7339a, this.f7340b);
                }
                if (this.f7342d == null) {
                    return;
                }
                if (!this.f7342d.getClass().isMemberClass() || Modifier.isStatic(this.f7342d.getClass().getModifiers())) {
                    if (!this.f7351m) {
                        this.f7342d.registerListener(this.f7339a, this);
                        this.f7342d.registerOnLoadCanceledListener(this);
                        this.f7351m = true;
                    }
                    this.f7342d.startLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f7342d);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo13860b() {
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f7347i = true;
            this.f7348j = this.f7346h;
            this.f7346h = false;
            this.f7341c = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo13861c() {
            if (this.f7347i) {
                if (C2014w.f7331a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f7347i = false;
                if (this.f7346h != this.f7348j && !this.f7346h) {
                    mo13863e();
                }
            }
            if (this.f7346h && this.f7343e && !this.f7349k) {
                mo13858a(this.f7342d, this.f7345g);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo13862d() {
            if (this.f7346h && this.f7349k) {
                this.f7349k = false;
                if (this.f7343e) {
                    mo13858a(this.f7342d, this.f7345g);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo13863e() {
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f7346h = false;
            if (!this.f7347i && this.f7342d != null && this.f7351m) {
                this.f7351m = false;
                this.f7342d.unregisterListener(this);
                this.f7342d.unregisterOnLoadCanceledListener(this);
                this.f7342d.stopLoading();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo13864f() {
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Canceling: " + this);
            }
            if (this.f7346h && this.f7342d != null && this.f7351m && !this.f7342d.cancelLoad()) {
                onLoadCanceled(this.f7342d);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo13865g() {
            String str;
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f7350l = true;
            boolean z = this.f7344f;
            this.f7344f = false;
            if (this.f7341c != null && this.f7342d != null && this.f7343e && z) {
                if (C2014w.f7331a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (C2014w.this.f7338h != null) {
                    String str2 = C2014w.this.f7338h.f196d.f7310v;
                    C2014w.this.f7338h.f196d.f7310v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f7341c.onLoaderReset(this.f7342d);
                } finally {
                    if (C2014w.this.f7338h != null) {
                        C2014w.this.f7338h.f196d.f7310v = str;
                    }
                }
            }
            this.f7341c = null;
            this.f7345g = null;
            this.f7343e = false;
            if (this.f7342d != null) {
                if (this.f7351m) {
                    this.f7351m = false;
                    this.f7342d.unregisterListener(this);
                    this.f7342d.unregisterOnLoadCanceledListener(this);
                }
                this.f7342d.reset();
            }
            if (this.f7352n != null) {
                this.f7352n.mo13865g();
            }
        }

        public void onLoadCanceled(Loader<Object> loader) {
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "onLoadCanceled: " + this);
            }
            if (this.f7350l) {
                if (C2014w.f7331a) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (C2014w.this.f7332b.get(this.f7339a) == this) {
                C2015a aVar = this.f7352n;
                if (aVar != null) {
                    if (C2014w.f7331a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                    }
                    this.f7352n = null;
                    C2014w.this.f7332b.put(this.f7339a, null);
                    mo13865g();
                    C2014w.this.mo13849a(aVar);
                }
            } else if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public void onLoadComplete(Loader<Object> loader, Object obj) {
            if (C2014w.f7331a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.f7350l) {
                if (C2014w.f7331a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (C2014w.this.f7332b.get(this.f7339a) == this) {
                C2015a aVar = this.f7352n;
                if (aVar != null) {
                    if (C2014w.f7331a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + aVar);
                    }
                    this.f7352n = null;
                    C2014w.this.f7332b.put(this.f7339a, null);
                    mo13865g();
                    C2014w.this.mo13849a(aVar);
                    return;
                }
                if (this.f7345g != obj || !this.f7343e) {
                    this.f7345g = obj;
                    this.f7343e = true;
                    if (this.f7346h) {
                        mo13858a(loader, obj);
                    }
                }
                C2015a aVar2 = C2014w.this.f7333c.get(this.f7339a);
                if (!(aVar2 == null || aVar2 == this)) {
                    aVar2.f7344f = false;
                    aVar2.mo13865g();
                    C2014w.this.f7333c.remove(this.f7339a);
                }
                if (C2014w.this.f7338h != null && !C2014w.this.hasRunningLoaders()) {
                    C2014w.this.f7338h.f196d.mo13792a();
                }
            } else if (C2014w.f7331a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13858a(Loader<Object> loader, Object obj) {
            String str;
            if (this.f7341c != null) {
                if (C2014w.this.f7338h != null) {
                    String str2 = C2014w.this.f7338h.f196d.f7310v;
                    C2014w.this.f7338h.f196d.f7310v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C2014w.f7331a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.dataToString(obj));
                    }
                    this.f7341c.onLoadFinished(loader, obj);
                    this.f7344f = true;
                } finally {
                    if (C2014w.this.f7338h != null) {
                        C2014w.this.f7338h.f196d.f7310v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f7339a);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.f7342d, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public void mo13859a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f7339a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f7340b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f7341c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f7342d);
            if (this.f7342d != null) {
                this.f7342d.dump(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f7343e || this.f7344f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f7343e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f7344f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f7345g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f7346h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f7349k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f7350l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f7347i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f7348j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f7351m);
            if (this.f7352n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f7352n);
                printWriter.println(":");
                this.f7352n.mo13859a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    public C2014w(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.f7334d = str;
        this.f7338h = fragmentHostCallback;
        this.f7335e = z;
    }

    /* renamed from: a */
    public void mo13848a(FragmentHostCallback fragmentHostCallback) {
        this.f7338h = fragmentHostCallback;
    }

    /* renamed from: a */
    private C2015a m7643a(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        C2015a aVar = new C2015a(i, bundle, loaderCallbacks);
        aVar.f7342d = loaderCallbacks.onCreateLoader(i, bundle);
        return aVar;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private C2015a m7644b(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.f7337g = true;
            C2015a a = m7643a(i, bundle, loaderCallbacks);
            mo13849a(a);
            this.f7337g = false;
            return a;
        } catch (Throwable th) {
            this.f7337g = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13849a(C2015a aVar) {
        this.f7332b.put(aVar.f7339a, aVar);
        if (this.f7335e) {
            aVar.mo13857a();
        }
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f7337g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C2015a aVar = this.f7332b.get(i);
        if (f7331a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVar == null) {
            aVar = m7644b(i, bundle, loaderCallbacks);
            if (f7331a) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
        } else {
            if (f7331a) {
                Log.v("LoaderManager", "  Re-using existing loader " + aVar);
            }
            aVar.f7341c = loaderCallbacks;
        }
        if (aVar.f7343e && this.f7335e) {
            aVar.mo13858a(aVar.f7342d, aVar.f7345g);
        }
        return aVar.f7342d;
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f7337g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C2015a aVar = this.f7332b.get(i);
        if (f7331a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (aVar != null) {
            C2015a aVar2 = this.f7333c.get(i);
            if (aVar2 == null) {
                if (f7331a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + aVar);
                }
                aVar.f7342d.abandon();
                this.f7333c.put(i, aVar);
            } else if (aVar.f7343e) {
                if (f7331a) {
                    Log.v("LoaderManager", "  Removing last inactive loader: " + aVar);
                }
                aVar2.f7344f = false;
                aVar2.mo13865g();
                aVar.f7342d.abandon();
                this.f7333c.put(i, aVar);
            } else if (!aVar.f7346h) {
                if (f7331a) {
                    Log.v("LoaderManager", "  Current loader is stopped; replacing");
                }
                this.f7332b.put(i, null);
                aVar.mo13865g();
            } else {
                if (f7331a) {
                    Log.v("LoaderManager", "  Current loader is running; attempting to cancel");
                }
                aVar.mo13864f();
                if (aVar.f7352n != null) {
                    if (f7331a) {
                        Log.v("LoaderManager", "  Removing pending loader: " + aVar.f7352n);
                    }
                    aVar.f7352n.mo13865g();
                    aVar.f7352n = null;
                }
                if (f7331a) {
                    Log.v("LoaderManager", "  Enqueuing as new pending loader");
                }
                aVar.f7352n = m7643a(i, bundle, loaderCallbacks);
                return aVar.f7352n.f7342d;
            }
        }
        return m7644b(i, bundle, loaderCallbacks).f7342d;
    }

    public void destroyLoader(int i) {
        if (this.f7337g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (f7331a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        int indexOfKey = this.f7332b.indexOfKey(i);
        if (indexOfKey >= 0) {
            this.f7332b.removeAt(indexOfKey);
            this.f7332b.valueAt(indexOfKey).mo13865g();
        }
        int indexOfKey2 = this.f7333c.indexOfKey(i);
        if (indexOfKey2 >= 0) {
            this.f7333c.removeAt(indexOfKey2);
            this.f7333c.valueAt(indexOfKey2).mo13865g();
        }
        if (this.f7338h != null && !hasRunningLoaders()) {
            this.f7338h.f196d.mo13792a();
        }
    }

    public <D> Loader<D> getLoader(int i) {
        if (this.f7337g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C2015a aVar = this.f7332b.get(i);
        if (aVar == null) {
            return null;
        }
        if (aVar.f7352n != null) {
            return aVar.f7352n.f7342d;
        }
        return aVar.f7342d;
    }

    /* renamed from: a */
    public void mo13847a() {
        if (f7331a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f7335e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f7335e = true;
        for (int size = this.f7332b.size() - 1; size >= 0; size--) {
            this.f7332b.valueAt(size).mo13857a();
        }
    }

    /* renamed from: b */
    public void mo13850b() {
        if (f7331a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f7335e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int size = this.f7332b.size() - 1; size >= 0; size--) {
            this.f7332b.valueAt(size).mo13863e();
        }
        this.f7335e = false;
    }

    /* renamed from: c */
    public void mo13851c() {
        if (f7331a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f7335e) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f7336f = true;
        this.f7335e = false;
        for (int size = this.f7332b.size() - 1; size >= 0; size--) {
            this.f7332b.valueAt(size).mo13860b();
        }
    }

    /* renamed from: d */
    public void mo13852d() {
        if (this.f7336f) {
            if (f7331a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f7336f = false;
            for (int size = this.f7332b.size() - 1; size >= 0; size--) {
                this.f7332b.valueAt(size).mo13861c();
            }
        }
    }

    /* renamed from: e */
    public void mo13853e() {
        for (int size = this.f7332b.size() - 1; size >= 0; size--) {
            this.f7332b.valueAt(size).f7349k = true;
        }
    }

    /* renamed from: f */
    public void mo13854f() {
        for (int size = this.f7332b.size() - 1; size >= 0; size--) {
            this.f7332b.valueAt(size).mo13862d();
        }
    }

    /* renamed from: g */
    public void mo13855g() {
        if (!this.f7336f) {
            if (f7331a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int size = this.f7332b.size() - 1; size >= 0; size--) {
                this.f7332b.valueAt(size).mo13865g();
            }
            this.f7332b.clear();
        }
        if (f7331a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int size2 = this.f7333c.size() - 1; size2 >= 0; size2--) {
            this.f7333c.valueAt(size2).mo13865g();
        }
        this.f7333c.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f7338h, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f7332b.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f7332b.size(); i++) {
                C2015a valueAt = this.f7332b.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f7332b.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.mo13859a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f7333c.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f7333c.size(); i2++) {
                C2015a valueAt2 = this.f7333c.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f7333c.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.mo13859a(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public boolean hasRunningLoaders() {
        boolean z;
        int size = this.f7332b.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            C2015a valueAt = this.f7332b.valueAt(i);
            if (!valueAt.f7346h || valueAt.f7344f) {
                z = false;
            } else {
                z = true;
            }
            z2 |= z;
        }
        return z2;
    }
}
