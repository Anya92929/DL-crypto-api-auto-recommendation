package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p000v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: android.support.v4.app.Fragment */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {

    /* renamed from: a */
    private static final SimpleArrayMap<String, Class<?>> f357a = new SimpleArrayMap<>();

    /* renamed from: j */
    static final Object f358j = new Object();

    /* renamed from: A */
    boolean f359A;

    /* renamed from: B */
    int f360B;

    /* renamed from: C */
    FragmentManagerImpl f361C;

    /* renamed from: D */
    FragmentHostCallback f362D;

    /* renamed from: E */
    FragmentManagerImpl f363E;

    /* renamed from: F */
    Fragment f364F;

    /* renamed from: G */
    int f365G;

    /* renamed from: H */
    int f366H;

    /* renamed from: I */
    String f367I;

    /* renamed from: J */
    boolean f368J;

    /* renamed from: K */
    boolean f369K;

    /* renamed from: L */
    boolean f370L;

    /* renamed from: M */
    boolean f371M;

    /* renamed from: N */
    boolean f372N;

    /* renamed from: O */
    boolean f373O = true;

    /* renamed from: P */
    boolean f374P;

    /* renamed from: Q */
    int f375Q;

    /* renamed from: R */
    ViewGroup f376R;

    /* renamed from: S */
    View f377S;

    /* renamed from: T */
    View f378T;

    /* renamed from: U */
    boolean f379U;

    /* renamed from: V */
    boolean f380V = true;

    /* renamed from: W */
    LoaderManagerImpl f381W;

    /* renamed from: X */
    boolean f382X;

    /* renamed from: Y */
    boolean f383Y;

    /* renamed from: Z */
    Object f384Z = null;

    /* renamed from: aa */
    Object f385aa = f358j;

    /* renamed from: ab */
    Object f386ab = null;

    /* renamed from: ac */
    Object f387ac = f358j;

    /* renamed from: ad */
    Object f388ad = null;

    /* renamed from: ae */
    Object f389ae = f358j;

    /* renamed from: af */
    Boolean f390af;

    /* renamed from: ag */
    Boolean f391ag;

    /* renamed from: ah */
    SharedElementCallback f392ah = null;

    /* renamed from: ai */
    SharedElementCallback f393ai = null;

    /* renamed from: k */
    int f394k = 0;

    /* renamed from: l */
    View f395l;

    /* renamed from: m */
    int f396m;

    /* renamed from: n */
    Bundle f397n;

    /* renamed from: o */
    SparseArray<Parcelable> f398o;

    /* renamed from: p */
    int f399p = -1;

    /* renamed from: q */
    String f400q;

    /* renamed from: r */
    Bundle f401r;

    /* renamed from: s */
    Fragment f402s;

    /* renamed from: t */
    int f403t = -1;

    /* renamed from: u */
    int f404u;

    /* renamed from: v */
    boolean f405v;

    /* renamed from: w */
    boolean f406w;

    /* renamed from: x */
    boolean f407x;

    /* renamed from: y */
    boolean f408y;

    /* renamed from: z */
    boolean f409z;

    /* renamed from: android.support.v4.app.Fragment$InstantiationException */
    public class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$SavedState */
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        final Bundle f411a;

        SavedState(Bundle bundle) {
            this.f411a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f411a = parcel.readBundle();
            if (classLoader != null && this.f411a != null) {
                this.f411a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f411a);
        }
    }

    /* renamed from: a */
    static boolean m433a(Context context, String str) {
        try {
            Class<?> cls = f357a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f357a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, (Bundle) null);
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = f357a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f357a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f401r = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Fragment mo491a(String str) {
        if (str.equals(this.f400q)) {
            return this;
        }
        if (this.f363E != null) {
            return this.f363E.findFragmentByWho(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f363E != null) {
            this.f363E.noteStateNotSaved();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo493a(int i, Fragment fragment) {
        this.f399p = i;
        if (fragment != null) {
            this.f400q = fragment.f400q + ":" + this.f399p;
        } else {
            this.f400q = "android:fragment:" + this.f399p;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo494a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f363E != null) {
            this.f363E.dispatchConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo495a(Bundle bundle) {
        if (this.f398o != null) {
            this.f378T.restoreHierarchyState(this.f398o);
            this.f398o = null;
        }
        this.f374P = false;
        onViewStateRestored(bundle);
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo496a() {
        return this.f360B > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo497a(Menu menu) {
        boolean z = false;
        if (this.f368J) {
            return false;
        }
        if (this.f372N && this.f373O) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return this.f363E != null ? z | this.f363E.dispatchPrepareOptionsMenu(menu) : z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo498a(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f368J) {
            return false;
        }
        if (this.f372N && this.f373O) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return this.f363E != null ? z | this.f363E.dispatchCreateOptionsMenu(menu, menuInflater) : z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo499a(MenuItem menuItem) {
        if (!this.f368J) {
            if (!this.f372N || !this.f373O || !onOptionsItemSelected(menuItem)) {
                return this.f363E != null && this.f363E.dispatchOptionsItemSelected(menuItem);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo500b() {
        this.f399p = -1;
        this.f400q = null;
        this.f405v = false;
        this.f406w = false;
        this.f407x = false;
        this.f408y = false;
        this.f409z = false;
        this.f359A = false;
        this.f360B = 0;
        this.f361C = null;
        this.f363E = null;
        this.f362D = null;
        this.f365G = 0;
        this.f366H = 0;
        this.f367I = null;
        this.f368J = false;
        this.f369K = false;
        this.f371M = false;
        this.f381W = null;
        this.f382X = false;
        this.f383Y = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo501b(Bundle bundle) {
        Parcelable parcelable;
        if (this.f363E != null) {
            this.f363E.noteStateNotSaved();
        }
        this.f374P = false;
        onCreate(bundle);
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.f363E == null) {
                mo504c();
            }
            this.f363E.mo731a(parcelable, (List<Fragment>) null);
            this.f363E.dispatchCreate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo502b(Menu menu) {
        if (!this.f368J) {
            if (this.f372N && this.f373O) {
                onOptionsMenuClosed(menu);
            }
            if (this.f363E != null) {
                this.f363E.dispatchOptionsMenuClosed(menu);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo503b(MenuItem menuItem) {
        if (!this.f368J) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            return this.f363E != null && this.f363E.dispatchContextItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo504c() {
        this.f363E = new FragmentManagerImpl();
        this.f363E.attachController(this.f362D, new FragmentContainer() {
            public View onFindViewById(int i) {
                if (Fragment.this.f377S != null) {
                    return Fragment.this.f377S.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean onHasView() {
                return Fragment.this.f377S != null;
            }
        }, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo505c(Bundle bundle) {
        if (this.f363E != null) {
            this.f363E.noteStateNotSaved();
        }
        this.f374P = false;
        onActivityCreated(bundle);
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f363E != null) {
            this.f363E.dispatchActivityCreated();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo506d() {
        if (this.f363E != null) {
            this.f363E.noteStateNotSaved();
            this.f363E.execPendingActions();
        }
        this.f374P = false;
        onStart();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.f363E != null) {
            this.f363E.dispatchStart();
        }
        if (this.f381W != null) {
            this.f381W.mo860f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo507d(Bundle bundle) {
        Parcelable d;
        onSaveInstanceState(bundle);
        if (this.f363E != null && (d = this.f363E.mo744d()) != null) {
            bundle.putParcelable("android:support:fragments", d);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f365G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f366H));
        printWriter.print(" mTag=");
        printWriter.println(this.f367I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f394k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f399p);
        printWriter.print(" mWho=");
        printWriter.print(this.f400q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f360B);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f405v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f406w);
        printWriter.print(" mResumed=");
        printWriter.print(this.f407x);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f408y);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f409z);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f368J);
        printWriter.print(" mDetached=");
        printWriter.print(this.f369K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f373O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f372N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f370L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f371M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f380V);
        if (this.f361C != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f361C);
        }
        if (this.f362D != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f362D);
        }
        if (this.f364F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f364F);
        }
        if (this.f401r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f401r);
        }
        if (this.f397n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f397n);
        }
        if (this.f398o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f398o);
        }
        if (this.f402s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f402s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f404u);
        }
        if (this.f375Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f375Q);
        }
        if (this.f376R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f376R);
        }
        if (this.f377S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f377S);
        }
        if (this.f378T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f377S);
        }
        if (this.f395l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f395l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f396m);
        }
        if (this.f381W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f381W.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f363E != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f363E + ":");
            this.f363E.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo509e() {
        if (this.f363E != null) {
            this.f363E.noteStateNotSaved();
            this.f363E.execPendingActions();
        }
        this.f374P = false;
        onResume();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f363E != null) {
            this.f363E.dispatchResume();
            this.f363E.execPendingActions();
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo511f() {
        onLowMemory();
        if (this.f363E != null) {
            this.f363E.dispatchLowMemory();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo512g() {
        if (this.f363E != null) {
            this.f363E.dispatchPause();
        }
        this.f374P = false;
        onPause();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public final FragmentActivity getActivity() {
        if (this.f362D == null) {
            return null;
        }
        return (FragmentActivity) this.f362D.mo690a();
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.f391ag == null) {
            return true;
        }
        return this.f391ag.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.f390af == null) {
            return true;
        }
        return this.f390af.booleanValue();
    }

    public final Bundle getArguments() {
        return this.f401r;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.f363E == null) {
            mo504c();
            if (this.f394k >= 5) {
                this.f363E.dispatchResume();
            } else if (this.f394k >= 4) {
                this.f363E.dispatchStart();
            } else if (this.f394k >= 2) {
                this.f363E.dispatchActivityCreated();
            } else if (this.f394k >= 1) {
                this.f363E.dispatchCreate();
            }
        }
        return this.f363E;
    }

    public Context getContext() {
        if (this.f362D == null) {
            return null;
        }
        return this.f362D.mo696b();
    }

    public Object getEnterTransition() {
        return this.f384Z;
    }

    public Object getExitTransition() {
        return this.f386ab;
    }

    public final FragmentManager getFragmentManager() {
        return this.f361C;
    }

    public final Object getHost() {
        if (this.f362D == null) {
            return null;
        }
        return this.f362D.onGetHost();
    }

    public final int getId() {
        return this.f365G;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = this.f362D.onGetLayoutInflater();
        getChildFragmentManager();
        LayoutInflaterCompat.setFactory(onGetLayoutInflater, this.f363E.mo764e());
        return onGetLayoutInflater;
    }

    public LoaderManager getLoaderManager() {
        if (this.f381W != null) {
            return this.f381W;
        }
        if (this.f362D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f383Y = true;
        this.f381W = this.f362D.mo691a(this.f400q, this.f382X, true);
        return this.f381W;
    }

    public final Fragment getParentFragment() {
        return this.f364F;
    }

    public Object getReenterTransition() {
        return this.f387ac == f358j ? getExitTransition() : this.f387ac;
    }

    public final Resources getResources() {
        if (this.f362D != null) {
            return this.f362D.mo696b().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean getRetainInstance() {
        return this.f370L;
    }

    public Object getReturnTransition() {
        return this.f385aa == f358j ? getEnterTransition() : this.f385aa;
    }

    public Object getSharedElementEnterTransition() {
        return this.f388ad;
    }

    public Object getSharedElementReturnTransition() {
        return this.f389ae == f358j ? getSharedElementEnterTransition() : this.f389ae;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final String getTag() {
        return this.f367I;
    }

    public final Fragment getTargetFragment() {
        return this.f402s;
    }

    public final int getTargetRequestCode() {
        return this.f404u;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint() {
        return this.f380V;
    }

    public View getView() {
        return this.f377S;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo540h() {
        if (this.f363E != null) {
            this.f363E.dispatchStop();
        }
        this.f374P = false;
        onStop();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final boolean hasOptionsMenu() {
        return this.f372N;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo543i() {
        if (this.f363E != null) {
            this.f363E.dispatchReallyStop();
        }
        if (this.f382X) {
            this.f382X = false;
            if (!this.f383Y) {
                this.f383Y = true;
                this.f381W = this.f362D.mo691a(this.f400q, this.f382X, false);
            }
            if (this.f381W == null) {
                return;
            }
            if (!this.f371M) {
                this.f381W.mo856b();
            } else {
                this.f381W.mo857c();
            }
        }
    }

    public final boolean isAdded() {
        return this.f362D != null && this.f405v;
    }

    public final boolean isDetached() {
        return this.f369K;
    }

    public final boolean isHidden() {
        return this.f368J;
    }

    public final boolean isInLayout() {
        return this.f409z;
    }

    public final boolean isMenuVisible() {
        return this.f373O;
    }

    public final boolean isRemoving() {
        return this.f406w;
    }

    public final boolean isResumed() {
        return this.f407x;
    }

    public final boolean isVisible() {
        return isAdded() && !isHidden() && this.f377S != null && this.f377S.getWindowToken() != null && this.f377S.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo552j() {
        if (this.f363E != null) {
            this.f363E.dispatchDestroyView();
        }
        this.f374P = false;
        onDestroyView();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f381W != null) {
            this.f381W.mo859e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo553k() {
        if (this.f363E != null) {
            this.f363E.dispatchDestroy();
        }
        this.f374P = false;
        onDestroy();
        if (!this.f374P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void onActivityCreated(Bundle bundle) {
        this.f374P = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.f374P = true;
    }

    public void onAttach(Context context) {
        this.f374P = true;
        Activity a = this.f362D == null ? null : this.f362D.mo690a();
        if (a != null) {
            this.f374P = false;
            onAttach(a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f374P = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.f374P = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.f374P = true;
        if (!this.f383Y) {
            this.f383Y = true;
            this.f381W = this.f362D.mo691a(this.f400q, this.f382X, false);
        }
        if (this.f381W != null) {
            this.f381W.mo861g();
        }
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.f374P = true;
    }

    public void onDetach() {
        this.f374P = true;
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f374P = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f374P = true;
        Activity a = this.f362D == null ? null : this.f362D.mo690a();
        if (a != null) {
            this.f374P = false;
            onInflate(a, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.f374P = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.f374P = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.f374P = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.f374P = true;
        if (!this.f382X) {
            this.f382X = true;
            if (!this.f383Y) {
                this.f383Y = true;
                this.f381W = this.f362D.mo691a(this.f400q, this.f382X, false);
            }
            if (this.f381W != null) {
                this.f381W.mo853a();
            }
        }
    }

    public void onStop() {
        this.f374P = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.f374P = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        if (this.f362D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f362D.onRequestPermissionsFromFragment(this, strArr, i);
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.f391ag = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.f390af = Boolean.valueOf(z);
    }

    public void setArguments(Bundle bundle) {
        if (this.f399p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f401r = bundle;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.f392ah = sharedElementCallback;
    }

    public void setEnterTransition(Object obj) {
        this.f384Z = obj;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.f393ai = sharedElementCallback;
    }

    public void setExitTransition(Object obj) {
        this.f386ab = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.f372N != z) {
            this.f372N = z;
            if (isAdded() && !isHidden()) {
                this.f362D.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.f399p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f397n = (savedState == null || savedState.f411a == null) ? null : savedState.f411a;
    }

    public void setMenuVisibility(boolean z) {
        if (this.f373O != z) {
            this.f373O = z;
            if (this.f372N && isAdded() && !isHidden()) {
                this.f362D.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(Object obj) {
        this.f387ac = obj;
    }

    public void setRetainInstance(boolean z) {
        if (!z || this.f364F == null) {
            this.f370L = z;
            return;
        }
        throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    }

    public void setReturnTransition(Object obj) {
        this.f385aa = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        this.f388ad = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        this.f389ae = obj;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        this.f402s = fragment;
        this.f404u = i;
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.f380V && z && this.f394k < 4) {
            this.f361C.performPendingDeferredStart(this);
        }
        this.f380V = z;
        this.f379U = !z;
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        if (this.f362D != null) {
            return this.f362D.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        if (this.f362D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f362D.onStartActivityFromFragment(this, intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f362D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f362D.onStartActivityFromFragment(this, intent, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (this.f399p >= 0) {
            sb.append(" #");
            sb.append(this.f399p);
        }
        if (this.f365G != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f365G));
        }
        if (this.f367I != null) {
            sb.append(" ");
            sb.append(this.f367I);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }
}
