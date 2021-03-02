package android.support.p001v4.app;

import android.os.Build;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentTransitionCompat21;
import android.support.p001v4.util.ArrayMap;
import android.support.p001v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.BackStackRecord */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {

    /* renamed from: a */
    static final boolean f55a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b */
    final C2004v f56b;

    /* renamed from: c */
    C0046a f57c;

    /* renamed from: d */
    C0046a f58d;

    /* renamed from: e */
    int f59e;

    /* renamed from: f */
    int f60f;

    /* renamed from: g */
    int f61g;

    /* renamed from: h */
    int f62h;

    /* renamed from: i */
    int f63i;

    /* renamed from: j */
    int f64j;

    /* renamed from: k */
    int f65k;

    /* renamed from: l */
    boolean f66l;

    /* renamed from: m */
    boolean f67m = true;

    /* renamed from: n */
    String f68n;

    /* renamed from: o */
    boolean f69o;

    /* renamed from: p */
    public int f70p = -1;

    /* renamed from: q */
    int f71q;

    /* renamed from: r */
    CharSequence f72r;

    /* renamed from: s */
    int f73s;

    /* renamed from: t */
    CharSequence f74t;

    /* renamed from: u */
    ArrayList<String> f75u;

    /* renamed from: v */
    ArrayList<String> f76v;

    /* renamed from: android.support.v4.app.BackStackRecord$a */
    static final class C0046a {

        /* renamed from: a */
        C0046a f93a;

        /* renamed from: b */
        C0046a f94b;

        /* renamed from: c */
        int f95c;

        /* renamed from: d */
        Fragment f96d;

        /* renamed from: e */
        int f97e;

        /* renamed from: f */
        int f98f;

        /* renamed from: g */
        int f99g;

        /* renamed from: h */
        int f100h;

        /* renamed from: i */
        ArrayList<Fragment> f101i;

        C0046a() {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f70p >= 0) {
            sb.append(" #");
            sb.append(this.f70p);
        }
        if (this.f68n != null) {
            sb.append(" ");
            sb.append(this.f68n);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo124a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        mo125a(str, printWriter, true);
    }

    /* renamed from: a */
    public void mo125a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f68n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f70p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f69o);
            if (this.f64j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f64j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f65k));
            }
            if (!(this.f60f == 0 && this.f61g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f60f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f61g));
            }
            if (!(this.f62h == 0 && this.f63i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f62h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f63i));
            }
            if (!(this.f71q == 0 && this.f72r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f71q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f72r);
            }
            if (!(this.f73s == 0 && this.f74t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f73s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f74t);
            }
        }
        if (this.f57c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            C0046a aVar = this.f57c;
            while (aVar != null) {
                switch (aVar.f95c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f95c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f96d);
                if (z) {
                    if (!(aVar.f97e == 0 && aVar.f98f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f97e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f98f));
                    }
                    if (!(aVar.f99g == 0 && aVar.f100h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f99g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f100h));
                    }
                }
                if (aVar.f101i != null && aVar.f101i.size() > 0) {
                    for (int i2 = 0; i2 < aVar.f101i.size(); i2++) {
                        printWriter.print(str3);
                        if (aVar.f101i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.f101i.get(i2));
                    }
                }
                aVar = aVar.f93a;
                i++;
            }
        }
    }

    public BackStackRecord(C2004v vVar) {
        this.f56b = vVar;
    }

    public int getId() {
        return this.f70p;
    }

    public int getBreadCrumbTitleRes() {
        return this.f71q;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.f73s;
    }

    public CharSequence getBreadCrumbTitle() {
        if (this.f71q != 0) {
            return this.f56b.f7304o.mo407c().getText(this.f71q);
        }
        return this.f72r;
    }

    public CharSequence getBreadCrumbShortTitle() {
        if (this.f73s != 0) {
            return this.f56b.f7304o.mo407c().getText(this.f73s);
        }
        return this.f74t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122a(C0046a aVar) {
        if (this.f57c == null) {
            this.f58d = aVar;
            this.f57c = aVar;
        } else {
            aVar.f94b = this.f58d;
            this.f58d.f93a = aVar;
            this.f58d = aVar;
        }
        aVar.f97e = this.f60f;
        aVar.f98f = this.f61g;
        aVar.f99g = this.f62h;
        aVar.f100h = this.f63i;
        this.f59e++;
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        m119a(0, fragment, str, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        m119a(i, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        m119a(i, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m119a(int i, Fragment fragment, String str, int i2) {
        fragment.f126C = this.f56b;
        if (str != null) {
            if (fragment.f132I == null || str.equals(fragment.f132I)) {
                fragment.f132I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f132I + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f130G == 0 || fragment.f130G == i) {
                fragment.f130G = i;
                fragment.f131H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f130G + " now " + i);
            }
        }
        C0046a aVar = new C0046a();
        aVar.f95c = i2;
        aVar.f96d = fragment;
        mo122a(aVar);
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m119a(i, fragment, str, 2);
        return this;
    }

    public FragmentTransaction remove(Fragment fragment) {
        C0046a aVar = new C0046a();
        aVar.f95c = 3;
        aVar.f96d = fragment;
        mo122a(aVar);
        return this;
    }

    public FragmentTransaction hide(Fragment fragment) {
        C0046a aVar = new C0046a();
        aVar.f95c = 4;
        aVar.f96d = fragment;
        mo122a(aVar);
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        C0046a aVar = new C0046a();
        aVar.f95c = 5;
        aVar.f96d = fragment;
        mo122a(aVar);
        return this;
    }

    public FragmentTransaction detach(Fragment fragment) {
        C0046a aVar = new C0046a();
        aVar.f95c = 6;
        aVar.f96d = fragment;
        mo122a(aVar);
        return this;
    }

    public FragmentTransaction attach(Fragment fragment) {
        C0046a aVar = new C0046a();
        aVar.f95c = 7;
        aVar.f96d = fragment;
        mo122a(aVar);
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.f60f = i;
        this.f61g = i2;
        this.f62h = i3;
        this.f63i = i4;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        this.f64j = i;
        return this;
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        if (f55a) {
            String a = FragmentTransitionCompat21.m221a(view);
            if (a == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.f75u == null) {
                this.f75u = new ArrayList<>();
                this.f76v = new ArrayList<>();
            }
            this.f75u.add(a);
            this.f76v.add(str);
        }
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i) {
        this.f65k = i;
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        if (!this.f67m) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f66l = true;
        this.f68n = str;
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.f67m;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.f66l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f67m = false;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.f71q = i;
        this.f72r = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.f71q = 0;
        this.f72r = charSequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.f73s = i;
        this.f74t = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.f73s = 0;
        this.f74t = charSequence;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121a(int i) {
        if (this.f66l) {
            if (C2004v.f7289a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0046a aVar = this.f57c; aVar != null; aVar = aVar.f93a) {
                if (aVar.f96d != null) {
                    aVar.f96d.f125B += i;
                    if (C2004v.f7289a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f96d + " to " + aVar.f96d.f125B);
                    }
                }
                if (aVar.f101i != null) {
                    for (int size = aVar.f101i.size() - 1; size >= 0; size--) {
                        Fragment fragment = aVar.f101i.get(size);
                        fragment.f125B += i;
                        if (C2004v.f7289a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f125B);
                        }
                    }
                }
            }
        }
    }

    public int commit() {
        return mo119a(false);
    }

    public int commitAllowingStateLoss() {
        return mo119a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo119a(boolean z) {
        if (this.f69o) {
            throw new IllegalStateException("commit already called");
        }
        if (C2004v.f7289a) {
            Log.v("FragmentManager", "Commit: " + this);
            mo124a("  ", (FileDescriptor) null, new PrintWriter(new LogWriter("FragmentManager")), (String[]) null);
        }
        this.f69o = true;
        if (this.f66l) {
            this.f70p = this.f56b.mo13790a(this);
        } else {
            this.f70p = -1;
        }
        this.f56b.mo13804a((Runnable) this, z);
        return this.f70p;
    }

    public void run() {
        TransitionState transitionState;
        Fragment fragment;
        if (C2004v.f7289a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f66l || this.f70p >= 0) {
            mo121a(1);
            if (f55a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m137b((SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2);
                transitionState = m111a((SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2, false);
            } else {
                transitionState = null;
            }
            int i = transitionState != null ? 0 : this.f65k;
            int i2 = transitionState != null ? 0 : this.f64j;
            for (C0046a aVar = this.f57c; aVar != null; aVar = aVar.f93a) {
                int i3 = transitionState != null ? 0 : aVar.f97e;
                int i4 = transitionState != null ? 0 : aVar.f98f;
                switch (aVar.f95c) {
                    case 1:
                        Fragment fragment2 = aVar.f96d;
                        fragment2.f140Q = i3;
                        this.f56b.mo13802a(fragment2, false);
                        break;
                    case 2:
                        Fragment fragment3 = aVar.f96d;
                        int i5 = fragment3.f131H;
                        if (this.f56b.f7296g != null) {
                            int i6 = 0;
                            fragment = fragment3;
                            while (true) {
                                int i7 = i6;
                                if (i7 < this.f56b.f7296g.size()) {
                                    Fragment fragment4 = this.f56b.f7296g.get(i7);
                                    if (C2004v.f7289a) {
                                        Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                                    }
                                    if (fragment4.f131H == i5) {
                                        if (fragment4 == fragment) {
                                            fragment = null;
                                            aVar.f96d = null;
                                        } else {
                                            if (aVar.f101i == null) {
                                                aVar.f101i = new ArrayList<>();
                                            }
                                            aVar.f101i.add(fragment4);
                                            fragment4.f140Q = i4;
                                            if (this.f66l) {
                                                fragment4.f125B++;
                                                if (C2004v.f7289a) {
                                                    Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.f125B);
                                                }
                                            }
                                            this.f56b.mo13800a(fragment4, i2, i);
                                        }
                                    }
                                    i6 = i7 + 1;
                                }
                            }
                        } else {
                            fragment = fragment3;
                        }
                        if (fragment == null) {
                            break;
                        } else {
                            fragment.f140Q = i3;
                            this.f56b.mo13802a(fragment, false);
                            break;
                        }
                    case 3:
                        Fragment fragment5 = aVar.f96d;
                        fragment5.f140Q = i4;
                        this.f56b.mo13800a(fragment5, i2, i);
                        break;
                    case 4:
                        Fragment fragment6 = aVar.f96d;
                        fragment6.f140Q = i4;
                        this.f56b.mo13811b(fragment6, i2, i);
                        break;
                    case 5:
                        Fragment fragment7 = aVar.f96d;
                        fragment7.f140Q = i3;
                        this.f56b.mo13817c(fragment7, i2, i);
                        break;
                    case 6:
                        Fragment fragment8 = aVar.f96d;
                        fragment8.f140Q = i4;
                        this.f56b.mo13820d(fragment8, i2, i);
                        break;
                    case 7:
                        Fragment fragment9 = aVar.f96d;
                        fragment9.f140Q = i3;
                        this.f56b.mo13823e(fragment9, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f95c);
                }
            }
            this.f56b.mo13794a(this.f56b.f7303n, i2, i, true);
            if (this.f66l) {
                this.f56b.mo13809b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    /* renamed from: a */
    private static void m130a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.f131H) != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
    }

    /* renamed from: b */
    private void m136b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.f131H) != 0) {
            sparseArray.put(i, fragment);
        }
    }

    /* renamed from: b */
    private void m137b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Fragment fragment;
        if (this.f56b.f7305p.onHasView()) {
            for (C0046a aVar = this.f57c; aVar != null; aVar = aVar.f93a) {
                switch (aVar.f95c) {
                    case 1:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.f96d;
                        if (this.f56b.f7296g != null) {
                            int i = 0;
                            fragment = fragment2;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.f56b.f7296g.size()) {
                                    Fragment fragment3 = this.f56b.f7296g.get(i2);
                                    if (fragment == null || fragment3.f131H == fragment.f131H) {
                                        if (fragment3 == fragment) {
                                            fragment = null;
                                        } else {
                                            m130a(sparseArray, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        m136b(sparseArray2, fragment);
                        break;
                    case 3:
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 4:
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 5:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                    case 6:
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 7:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo123a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f56b.f7305p.onHasView()) {
            for (C0046a aVar = this.f57c; aVar != null; aVar = aVar.f93a) {
                switch (aVar.f95c) {
                    case 1:
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 2:
                        if (aVar.f101i != null) {
                            for (int size = aVar.f101i.size() - 1; size >= 0; size--) {
                                m136b(sparseArray2, aVar.f101i.get(size));
                            }
                        }
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 3:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                    case 4:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                    case 5:
                        m130a(sparseArray, aVar.f96d);
                        break;
                    case 6:
                        m136b(sparseArray2, aVar.f96d);
                        break;
                    case 7:
                        m130a(sparseArray, aVar.f96d);
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    public TransitionState mo120a(boolean z, TransitionState transitionState, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C2004v.f7289a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            mo124a("  ", (FileDescriptor) null, new PrintWriter(new LogWriter("FragmentManager")), (String[]) null);
        }
        if (f55a) {
            if (transitionState == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    transitionState = m111a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                m124a(transitionState, this.f76v, this.f75u);
            }
        }
        mo121a(-1);
        int i = transitionState != null ? 0 : this.f65k;
        int i2 = transitionState != null ? 0 : this.f64j;
        for (C0046a aVar = this.f58d; aVar != null; aVar = aVar.f94b) {
            int i3 = transitionState != null ? 0 : aVar.f99g;
            int i4 = transitionState != null ? 0 : aVar.f100h;
            switch (aVar.f95c) {
                case 1:
                    Fragment fragment = aVar.f96d;
                    fragment.f140Q = i4;
                    this.f56b.mo13800a(fragment, C2004v.m7590b(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = aVar.f96d;
                    if (fragment2 != null) {
                        fragment2.f140Q = i4;
                        this.f56b.mo13800a(fragment2, C2004v.m7590b(i2), i);
                    }
                    if (aVar.f101i == null) {
                        break;
                    } else {
                        for (int i5 = 0; i5 < aVar.f101i.size(); i5++) {
                            Fragment fragment3 = aVar.f101i.get(i5);
                            fragment3.f140Q = i3;
                            this.f56b.mo13802a(fragment3, false);
                        }
                        break;
                    }
                case 3:
                    Fragment fragment4 = aVar.f96d;
                    fragment4.f140Q = i3;
                    this.f56b.mo13802a(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = aVar.f96d;
                    fragment5.f140Q = i3;
                    this.f56b.mo13817c(fragment5, C2004v.m7590b(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = aVar.f96d;
                    fragment6.f140Q = i4;
                    this.f56b.mo13811b(fragment6, C2004v.m7590b(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = aVar.f96d;
                    fragment7.f140Q = i3;
                    this.f56b.mo13823e(fragment7, C2004v.m7590b(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = aVar.f96d;
                    fragment8.f140Q = i3;
                    this.f56b.mo13820d(fragment8, C2004v.m7590b(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f95c);
            }
        }
        if (z) {
            this.f56b.mo13794a(this.f56b.f7303n, C2004v.m7590b(i2), i, true);
            transitionState = null;
        }
        if (this.f70p >= 0) {
            this.f56b.mo13793a(this.f70p);
            this.f70p = -1;
        }
        return transitionState;
    }

    public String getName() {
        return this.f68n;
    }

    public boolean isEmpty() {
        return this.f59e == 0;
    }

    /* renamed from: a */
    private TransitionState m111a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        boolean z2;
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(this.f56b.f7304o.mo407c());
        int i = 0;
        boolean z3 = false;
        while (i < sparseArray.size()) {
            if (m132a(sparseArray.keyAt(i), transitionState, z, sparseArray, sparseArray2)) {
                z2 = true;
            } else {
                z2 = z3;
            }
            i++;
            z3 = z2;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && m132a(keyAt, transitionState, z, sparseArray, sparseArray2)) {
                z3 = true;
            }
        }
        if (!z3) {
            return null;
        }
        return transitionState;
    }

    /* renamed from: a */
    private static Object m117a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.m218a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    /* renamed from: b */
    private static Object m134b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.m218a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    /* renamed from: a */
    private static Object m116a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.m237b(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    /* renamed from: a */
    private static Object m118a(Object obj, Fragment fragment, ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, View view) {
        if (obj != null) {
            return FragmentTransitionCompat21.m219a(obj, fragment.getView(), arrayList, arrayMap, view);
        }
        return obj;
    }

    /* renamed from: a */
    private ArrayMap<String, View> m112a(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        if (this.f75u != null) {
            FragmentTransitionCompat21.m232a((Map<String, View>) arrayMap, fragment.getView());
            if (z) {
                arrayMap.retainAll(this.f76v);
            } else {
                arrayMap = m115a(this.f75u, this.f76v, arrayMap);
            }
        }
        if (z) {
            if (fragment.f157ah != null) {
                fragment.f157ah.onMapSharedElements(this.f76v, arrayMap);
            }
            m122a(transitionState, arrayMap, false);
        } else {
            if (fragment.f158ai != null) {
                fragment.f158ai.onMapSharedElements(this.f76v, arrayMap);
            }
            m135b(transitionState, arrayMap, false);
        }
        return arrayMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013b A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0143 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m132a(int r34, android.support.p001v4.app.BackStackRecord.TransitionState r35, boolean r36, android.util.SparseArray<android.support.p001v4.app.Fragment> r37, android.util.SparseArray<android.support.p001v4.app.Fragment> r38) {
        /*
            r33 = this;
            r0 = r33
            v r4 = r0.f56b
            android.support.v4.app.FragmentContainer r4 = r4.f7305p
            r0 = r34
            android.view.View r6 = r4.onFindViewById(r0)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            if (r6 != 0) goto L_0x0012
            r4 = 0
        L_0x0011:
            return r4
        L_0x0012:
            r0 = r38
            r1 = r34
            java.lang.Object r8 = r0.get(r1)
            android.support.v4.app.Fragment r8 = (android.support.p001v4.app.Fragment) r8
            r0 = r37
            r1 = r34
            java.lang.Object r9 = r0.get(r1)
            android.support.v4.app.Fragment r9 = (android.support.p001v4.app.Fragment) r9
            r0 = r36
            java.lang.Object r12 = m117a((android.support.p001v4.app.Fragment) r8, (boolean) r0)
            r0 = r36
            java.lang.Object r7 = m116a((android.support.p001v4.app.Fragment) r8, (android.support.p001v4.app.Fragment) r9, (boolean) r0)
            r0 = r36
            java.lang.Object r14 = m134b((android.support.p001v4.app.Fragment) r9, (boolean) r0)
            r20 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            if (r7 == 0) goto L_0x0082
            r0 = r33
            r1 = r35
            r2 = r36
            android.support.v4.util.ArrayMap r20 = r0.m112a((android.support.p001v4.app.BackStackRecord.TransitionState) r1, (android.support.p001v4.app.Fragment) r9, (boolean) r2)
            boolean r4 = r20.isEmpty()
            if (r4 == 0) goto L_0x005d
            r7 = 0
            r20 = 0
            r13 = r7
        L_0x0055:
            if (r12 != 0) goto L_0x0087
            if (r13 != 0) goto L_0x0087
            if (r14 != 0) goto L_0x0087
            r4 = 0
            goto L_0x0011
        L_0x005d:
            if (r36 == 0) goto L_0x0084
            android.support.v4.app.SharedElementCallback r4 = r9.f157ah
        L_0x0061:
            if (r4 == 0) goto L_0x0079
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.Set r10 = r20.keySet()
            r5.<init>(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            java.util.Collection r13 = r20.values()
            r10.<init>(r13)
            r13 = 0
            r4.onSharedElementStart(r5, r10, r13)
        L_0x0079:
            r4 = r33
            r5 = r35
            r10 = r36
            r4.m123a(r5, r6, r7, r8, r9, r10, r11)
        L_0x0082:
            r13 = r7
            goto L_0x0055
        L_0x0084:
            android.support.v4.app.SharedElementCallback r4 = r8.f157ah
            goto L_0x0061
        L_0x0087:
            java.util.ArrayList r27 = new java.util.ArrayList
            r27.<init>()
            r0 = r35
            android.view.View r4 = r0.nonExistentView
            r0 = r27
            r1 = r20
            java.lang.Object r26 = m118a((java.lang.Object) r14, (android.support.p001v4.app.Fragment) r9, (java.util.ArrayList<android.view.View>) r0, (android.support.p001v4.util.ArrayMap<java.lang.String, android.view.View>) r1, (android.view.View) r4)
            r0 = r33
            java.util.ArrayList<java.lang.String> r4 = r0.f76v
            if (r4 == 0) goto L_0x00bf
            if (r20 == 0) goto L_0x00bf
            r0 = r33
            java.util.ArrayList<java.lang.String> r4 = r0.f76v
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            r0 = r20
            java.lang.Object r4 = r0.get(r4)
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x00bf
            if (r26 == 0) goto L_0x00ba
            r0 = r26
            android.support.p001v4.app.FragmentTransitionCompat21.m225a((java.lang.Object) r0, (android.view.View) r4)
        L_0x00ba:
            if (r13 == 0) goto L_0x00bf
            android.support.p001v4.app.FragmentTransitionCompat21.m225a((java.lang.Object) r13, (android.view.View) r4)
        L_0x00bf:
            android.support.v4.app.BackStackRecord$1 r15 = new android.support.v4.app.BackStackRecord$1
            r0 = r33
            r15.<init>(r8)
            java.util.ArrayList r19 = new java.util.ArrayList
            r19.<init>()
            android.support.v4.util.ArrayMap r21 = new android.support.v4.util.ArrayMap
            r21.<init>()
            r4 = 1
            if (r8 == 0) goto L_0x00d9
            if (r36 == 0) goto L_0x013e
            boolean r4 = r8.getAllowReturnTransitionOverlap()
        L_0x00d9:
            r0 = r26
            java.lang.Object r30 = android.support.p001v4.app.FragmentTransitionCompat21.m220a((java.lang.Object) r12, (java.lang.Object) r0, (java.lang.Object) r13, (boolean) r4)
            if (r30 == 0) goto L_0x0139
            r0 = r35
            android.view.View r0 = r0.nonExistentView
            r16 = r0
            r0 = r35
            android.support.v4.app.FragmentTransitionCompat21$EpicenterView r0 = r0.enteringEpicenterView
            r17 = r0
            r0 = r35
            android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> r0 = r0.nameOverrides
            r18 = r0
            r14 = r6
            r22 = r11
            android.support.p001v4.app.FragmentTransitionCompat21.m228a((java.lang.Object) r12, (java.lang.Object) r13, (android.view.View) r14, (android.support.p001v4.app.FragmentTransitionCompat21.ViewRetriever) r15, (android.view.View) r16, (android.support.p001v4.app.FragmentTransitionCompat21.EpicenterView) r17, (java.util.Map<java.lang.String, java.lang.String>) r18, (java.util.ArrayList<android.view.View>) r19, (java.util.Map<java.lang.String, android.view.View>) r20, (java.util.Map<java.lang.String, android.view.View>) r21, (java.util.ArrayList<android.view.View>) r22)
            r0 = r33
            r1 = r35
            r2 = r34
            r3 = r30
            r0.m131a((android.view.View) r6, (android.support.p001v4.app.BackStackRecord.TransitionState) r1, (int) r2, (java.lang.Object) r3)
            r0 = r35
            android.view.View r4 = r0.nonExistentView
            r5 = 1
            r0 = r30
            android.support.p001v4.app.FragmentTransitionCompat21.m227a((java.lang.Object) r0, (android.view.View) r4, (boolean) r5)
            r0 = r33
            r1 = r35
            r2 = r34
            r3 = r30
            r0.m120a((android.support.p001v4.app.BackStackRecord.TransitionState) r1, (int) r2, (java.lang.Object) r3)
            r0 = r30
            android.support.p001v4.app.FragmentTransitionCompat21.m224a((android.view.ViewGroup) r6, (java.lang.Object) r0)
            r0 = r35
            android.view.View r0 = r0.nonExistentView
            r23 = r0
            r0 = r35
            java.util.ArrayList<android.view.View> r0 = r0.hiddenFragmentViews
            r31 = r0
            r22 = r6
            r24 = r12
            r25 = r19
            r28 = r13
            r29 = r11
            r32 = r21
            android.support.p001v4.app.FragmentTransitionCompat21.m223a((android.view.View) r22, (android.view.View) r23, (java.lang.Object) r24, (java.util.ArrayList<android.view.View>) r25, (java.lang.Object) r26, (java.util.ArrayList<android.view.View>) r27, (java.lang.Object) r28, (java.util.ArrayList<android.view.View>) r29, (java.lang.Object) r30, (java.util.ArrayList<android.view.View>) r31, (java.util.Map<java.lang.String, android.view.View>) r32)
        L_0x0139:
            if (r30 == 0) goto L_0x0143
            r4 = 1
            goto L_0x0011
        L_0x013e:
            boolean r4 = r8.getAllowEnterTransitionOverlap()
            goto L_0x00d9
        L_0x0143:
            r4 = 0
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.app.BackStackRecord.m132a(int, android.support.v4.app.BackStackRecord$TransitionState, boolean, android.util.SparseArray, android.util.SparseArray):boolean");
    }

    /* renamed from: a */
    private void m123a(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList<View> arrayList2 = arrayList;
        final TransitionState transitionState2 = transitionState;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 == null) {
                    return true;
                }
                FragmentTransitionCompat21.m229a(obj2, (ArrayList<View>) arrayList2);
                arrayList2.clear();
                ArrayMap a = BackStackRecord.this.m113a(transitionState2, z2, fragment3);
                FragmentTransitionCompat21.m226a(obj2, transitionState2.nonExistentView, (Map<String, View>) a, (ArrayList<View>) arrayList2);
                BackStackRecord.this.m128a((ArrayMap<String, View>) a, transitionState2);
                BackStackRecord.this.m121a(transitionState2, fragment3, fragment4, z2, (ArrayMap<String, View>) a);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m121a(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        SharedElementCallback sharedElementCallback = z ? fragment2.f157ah : fragment.f157ah;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(arrayMap.keySet()), new ArrayList(arrayMap.values()), (List<View>) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m128a(ArrayMap<String, View> arrayMap, TransitionState transitionState) {
        View view;
        if (this.f76v != null && !arrayMap.isEmpty() && (view = arrayMap.get(this.f76v.get(0))) != null) {
            transitionState.enteringEpicenterView.epicenter = view;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayMap<String, View> m113a(TransitionState transitionState, boolean z, Fragment fragment) {
        ArrayMap<String, View> b = m133b(transitionState, fragment, z);
        if (z) {
            if (fragment.f158ai != null) {
                fragment.f158ai.onMapSharedElements(this.f76v, b);
            }
            m122a(transitionState, b, true);
        } else {
            if (fragment.f157ah != null) {
                fragment.f157ah.onMapSharedElements(this.f76v, b);
            }
            m135b(transitionState, b, true);
        }
        return b;
    }

    /* renamed from: a */
    private static ArrayMap<String, View> m115a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayMap.get(arrayList.get(i));
            if (view != null) {
                arrayMap2.put(arrayList2.get(i), view);
            }
        }
        return arrayMap2;
    }

    /* renamed from: b */
    private ArrayMap<String, View> m133b(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        View view = fragment.getView();
        if (view == null || this.f75u == null) {
            return arrayMap;
        }
        FragmentTransitionCompat21.m232a((Map<String, View>) arrayMap, view);
        if (z) {
            return m115a(this.f75u, this.f76v, arrayMap);
        }
        arrayMap.retainAll(this.f76v);
        return arrayMap;
    }

    /* renamed from: a */
    private void m131a(View view, TransitionState transitionState, int i, Object obj) {
        final View view2 = view;
        final TransitionState transitionState2 = transitionState;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.m120a(transitionState2, i2, obj2);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m120a(TransitionState transitionState, int i, Object obj) {
        if (this.f56b.f7296g != null) {
            for (int i2 = 0; i2 < this.f56b.f7296g.size(); i2++) {
                Fragment fragment = this.f56b.f7296g.get(i2);
                if (!(fragment.f142S == null || fragment.f141R == null || fragment.f131H != i)) {
                    if (!fragment.f133J) {
                        FragmentTransitionCompat21.m227a(obj, fragment.f142S, false);
                        transitionState.hiddenFragmentViews.remove(fragment.f142S);
                    } else if (!transitionState.hiddenFragmentViews.contains(fragment.f142S)) {
                        FragmentTransitionCompat21.m227a(obj, fragment.f142S, true);
                        transitionState.hiddenFragmentViews.add(fragment.f142S);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m129a(ArrayMap<String, String> arrayMap, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < arrayMap.size(); i++) {
                if (str.equals(arrayMap.valueAt(i))) {
                    arrayMap.setValueAt(i, str2);
                    return;
                }
            }
            arrayMap.put(str, str2);
        }
    }

    /* renamed from: a */
    private static void m124a(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m129a(transitionState.nameOverrides, arrayList.get(i2), arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m122a(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = this.f76v == null ? 0 : this.f76v.size();
        for (int i = 0; i < size; i++) {
            String str = this.f75u.get(i);
            View view = arrayMap.get(this.f76v.get(i));
            if (view != null) {
                String a = FragmentTransitionCompat21.m221a(view);
                if (z) {
                    m129a(transitionState.nameOverrides, str, a);
                } else {
                    m129a(transitionState.nameOverrides, a, str);
                }
            }
        }
    }

    /* renamed from: b */
    private void m135b(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            String keyAt = arrayMap.keyAt(i);
            String a = FragmentTransitionCompat21.m221a(arrayMap.valueAt(i));
            if (z) {
                m129a(transitionState.nameOverrides, keyAt, a);
            } else {
                m129a(transitionState.nameOverrides, a, keyAt);
            }
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord$TransitionState */
    public class TransitionState {
        public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
        public ArrayList<View> hiddenFragmentViews = new ArrayList<>();
        public ArrayMap<String, String> nameOverrides = new ArrayMap<>();
        public View nonExistentView;

        public TransitionState() {
        }
    }
}
