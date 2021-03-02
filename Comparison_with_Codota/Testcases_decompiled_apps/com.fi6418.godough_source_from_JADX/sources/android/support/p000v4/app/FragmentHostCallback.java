package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.FragmentHostCallback */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: a */
    private final Activity f427a;

    /* renamed from: b */
    final Context f428b;

    /* renamed from: c */
    final int f429c;

    /* renamed from: d */
    final FragmentManagerImpl f430d;

    /* renamed from: e */
    private final Handler f431e;

    /* renamed from: f */
    private SimpleArrayMap<String, LoaderManager> f432f;

    /* renamed from: g */
    private LoaderManagerImpl f433g;

    /* renamed from: h */
    private boolean f434h;

    /* renamed from: i */
    private boolean f435i;

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f430d = new FragmentManagerImpl();
        this.f427a = activity;
        this.f428b = context;
        this.f431e = handler;
        this.f429c = i;
    }

    public FragmentHostCallback(Context context, Handler handler, int i) {
        this((Activity) null, context, handler, i);
    }

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.f412a, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Activity mo690a() {
        return this.f427a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LoaderManagerImpl mo691a(String str, boolean z, boolean z2) {
        if (this.f432f == null) {
            this.f432f = new SimpleArrayMap<>();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f432f.get(str);
        if (loaderManagerImpl != null) {
            loaderManagerImpl.mo854a(this);
            return loaderManagerImpl;
        } else if (!z2) {
            return loaderManagerImpl;
        } else {
            LoaderManagerImpl loaderManagerImpl2 = new LoaderManagerImpl(str, this, z);
            this.f432f.put(str, loaderManagerImpl2);
            return loaderManagerImpl2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo692a(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f432f = simpleArrayMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo693a(String str) {
        LoaderManagerImpl loaderManagerImpl;
        if (this.f432f != null && (loaderManagerImpl = (LoaderManagerImpl) this.f432f.get(str)) != null && !loaderManagerImpl.f555f) {
            loaderManagerImpl.mo861g();
            this.f432f.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo694a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f435i);
        if (this.f433g != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f433g)));
            printWriter.println(":");
            this.f433g.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo695a(boolean z) {
        if (this.f433g != null && this.f435i) {
            this.f435i = false;
            if (z) {
                this.f433g.mo857c();
            } else {
                this.f433g.mo856b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Context mo696b() {
        return this.f428b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Handler mo697c() {
        return this.f431e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public FragmentManagerImpl mo698d() {
        return this.f430d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public LoaderManagerImpl mo699e() {
        if (this.f433g != null) {
            return this.f433g;
        }
        this.f434h = true;
        this.f433g = mo691a("(root)", this.f435i, true);
        return this.f433g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo700f() {
        if (!this.f435i) {
            this.f435i = true;
            if (this.f433g != null) {
                this.f433g.mo853a();
            } else if (!this.f434h) {
                this.f433g = mo691a("(root)", this.f435i, false);
                if (this.f433g != null && !this.f433g.f554e) {
                    this.f433g.mo853a();
                }
            }
            this.f434h = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo701g() {
        if (this.f433g != null) {
            this.f433g.mo857c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo702h() {
        if (this.f433g != null) {
            this.f433g.mo861g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo703i() {
        if (this.f432f != null) {
            int size = this.f432f.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.f432f.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                loaderManagerImpl.mo858d();
                loaderManagerImpl.mo860f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public SimpleArrayMap<String, LoaderManager> mo704j() {
        boolean z;
        if (this.f432f != null) {
            int size = this.f432f.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.f432f.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                if (loaderManagerImpl.f555f) {
                    z = true;
                } else {
                    loaderManagerImpl.mo861g();
                    this.f432f.remove(loaderManagerImpl.f553d);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.f432f;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void onAttachFragment(Fragment fragment) {
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public View onFindViewById(int i) {
        return null;
    }

    public abstract E onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.f428b.getSystemService("layout_inflater");
    }

    public int onGetWindowAnimations() {
        return this.f429c;
    }

    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String str) {
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f428b.startActivity(intent);
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
