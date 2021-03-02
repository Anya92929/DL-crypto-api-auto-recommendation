package android.support.p001v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.FragmentHostCallback */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: a */
    private final Activity f193a;

    /* renamed from: b */
    final Context f194b;

    /* renamed from: c */
    final int f195c;

    /* renamed from: d */
    public final C2004v f196d;

    /* renamed from: e */
    private final Handler f197e;

    /* renamed from: f */
    private SimpleArrayMap<String, LoaderManager> f198f;

    /* renamed from: g */
    private boolean f199g;

    /* renamed from: h */
    private C2014w f200h;

    /* renamed from: i */
    private boolean f201i;

    /* renamed from: j */
    private boolean f202j;

    @Nullable
    public abstract E onGetHost();

    public FragmentHostCallback(Context context, Handler handler, int i) {
        this((Activity) null, context, handler, i);
    }

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.f177a, 0);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f196d = new C2004v();
        this.f193a = activity;
        this.f194b = context;
        this.f197e = handler;
        this.f195c = i;
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.f194b.getSystemService("layout_inflater");
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f194b.startActivity(intent);
    }

    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.f195c;
    }

    @Nullable
    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Activity mo406b() {
        return this.f193a;
    }

    /* renamed from: c */
    public Context mo407c() {
        return this.f194b;
    }

    /* renamed from: d */
    public Handler mo408d() {
        return this.f197e;
    }

    /* renamed from: e */
    public C2004v mo409e() {
        return this.f196d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C2014w mo410f() {
        if (this.f200h != null) {
            return this.f200h;
        }
        this.f201i = true;
        this.f200h = mo401a("(root)", this.f202j, true);
        return this.f200h;
    }

    /* renamed from: a */
    public void mo403a(String str) {
        C2014w wVar;
        if (this.f198f != null && (wVar = (C2014w) this.f198f.get(str)) != null && !wVar.f7336f) {
            wVar.mo13855g();
            this.f198f.remove(str);
        }
    }

    /* renamed from: a */
    public void mo355a(Fragment fragment) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo411g() {
        return this.f199g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo412h() {
        if (!this.f202j) {
            this.f202j = true;
            if (this.f200h != null) {
                this.f200h.mo13847a();
            } else if (!this.f201i) {
                this.f200h = mo401a("(root)", this.f202j, false);
                if (this.f200h != null && !this.f200h.f7335e) {
                    this.f200h.mo13847a();
                }
            }
            this.f201i = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo405a(boolean z) {
        this.f199g = z;
        if (this.f200h != null && this.f202j) {
            this.f202j = false;
            if (z) {
                this.f200h.mo13851c();
            } else {
                this.f200h.mo13850b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo413i() {
        if (this.f200h != null) {
            this.f200h.mo13851c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo414j() {
        if (this.f200h != null) {
            this.f200h.mo13855g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo415k() {
        if (this.f198f != null) {
            int size = this.f198f.size();
            C2014w[] wVarArr = new C2014w[size];
            for (int i = size - 1; i >= 0; i--) {
                wVarArr[i] = (C2014w) this.f198f.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C2014w wVar = wVarArr[i2];
                wVar.mo13852d();
                wVar.mo13854f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2014w mo401a(String str, boolean z, boolean z2) {
        if (this.f198f == null) {
            this.f198f = new SimpleArrayMap<>();
        }
        C2014w wVar = (C2014w) this.f198f.get(str);
        if (wVar != null) {
            wVar.mo13848a(this);
            return wVar;
        } else if (!z2) {
            return wVar;
        } else {
            C2014w wVar2 = new C2014w(str, this, z);
            this.f198f.put(str, wVar2);
            return wVar2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public SimpleArrayMap<String, LoaderManager> mo416l() {
        boolean z;
        if (this.f198f != null) {
            int size = this.f198f.size();
            C2014w[] wVarArr = new C2014w[size];
            for (int i = size - 1; i >= 0; i--) {
                wVarArr[i] = (C2014w) this.f198f.valueAt(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                C2014w wVar = wVarArr[i2];
                if (wVar.f7336f) {
                    z = true;
                } else {
                    wVar.mo13855g();
                    this.f198f.remove(wVar.f7334d);
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return this.f198f;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo402a(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f198f = simpleArrayMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo404a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f202j);
        if (this.f200h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f200h)));
            printWriter.println(":");
            this.f200h.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
