package android.support.p001v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p001v4.util.DebugUtils;
import android.support.p001v4.util.SimpleArrayMap;
import android.support.p001v4.view.LayoutInflaterCompat;
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
    private static final SimpleArrayMap<String, Class<?>> f122a = new SimpleArrayMap<>();

    /* renamed from: j */
    static final Object f123j = new Object();

    /* renamed from: A */
    public boolean f124A;

    /* renamed from: B */
    public int f125B;

    /* renamed from: C */
    public C2004v f126C;

    /* renamed from: D */
    public FragmentHostCallback f127D;

    /* renamed from: E */
    public C2004v f128E;

    /* renamed from: F */
    public Fragment f129F;

    /* renamed from: G */
    public int f130G;

    /* renamed from: H */
    public int f131H;

    /* renamed from: I */
    public String f132I;

    /* renamed from: J */
    public boolean f133J;

    /* renamed from: K */
    public boolean f134K;

    /* renamed from: L */
    public boolean f135L;

    /* renamed from: M */
    public boolean f136M;

    /* renamed from: N */
    public boolean f137N;

    /* renamed from: O */
    public boolean f138O = true;

    /* renamed from: P */
    public boolean f139P;

    /* renamed from: Q */
    public int f140Q;

    /* renamed from: R */
    public ViewGroup f141R;

    /* renamed from: S */
    public View f142S;

    /* renamed from: T */
    public View f143T;

    /* renamed from: U */
    public boolean f144U;

    /* renamed from: V */
    public boolean f145V = true;

    /* renamed from: W */
    public C2014w f146W;

    /* renamed from: X */
    boolean f147X;

    /* renamed from: Y */
    boolean f148Y;

    /* renamed from: Z */
    Object f149Z = null;

    /* renamed from: aa */
    Object f150aa = f123j;

    /* renamed from: ab */
    Object f151ab = null;

    /* renamed from: ac */
    Object f152ac = f123j;

    /* renamed from: ad */
    Object f153ad = null;

    /* renamed from: ae */
    Object f154ae = f123j;

    /* renamed from: af */
    Boolean f155af;

    /* renamed from: ag */
    Boolean f156ag;

    /* renamed from: ah */
    SharedElementCallback f157ah = null;

    /* renamed from: ai */
    SharedElementCallback f158ai = null;

    /* renamed from: k */
    public int f159k = 0;

    /* renamed from: l */
    public View f160l;

    /* renamed from: m */
    public int f161m;

    /* renamed from: n */
    public Bundle f162n;

    /* renamed from: o */
    public SparseArray<Parcelable> f163o;

    /* renamed from: p */
    public int f164p = -1;

    /* renamed from: q */
    public String f165q;

    /* renamed from: r */
    Bundle f166r;

    /* renamed from: s */
    public Fragment f167s;

    /* renamed from: t */
    public int f168t = -1;

    /* renamed from: u */
    public int f169u;

    /* renamed from: v */
    public boolean f170v;

    /* renamed from: w */
    public boolean f171w;

    /* renamed from: x */
    public boolean f172x;

    /* renamed from: y */
    public boolean f173y;

    /* renamed from: z */
    public boolean f174z;

    /* renamed from: android.support.v4.app.Fragment$SavedState */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        final Bundle f176a;

        public SavedState(Bundle bundle) {
            this.f176a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f176a = parcel.readBundle();
            if (classLoader != null && this.f176a != null) {
                this.f176a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f176a);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$InstantiationException */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, (Bundle) null);
    }

    public static Fragment instantiate(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = f122a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f122a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f166r = bundle;
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

    /* renamed from: a */
    public static boolean m149a(Context context, String str) {
        try {
            Class<?> cls = f122a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f122a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo197a(Bundle bundle) {
        if (this.f163o != null) {
            this.f143T.restoreHierarchyState(this.f163o);
            this.f163o = null;
        }
        this.f139P = false;
        onViewStateRestored(bundle);
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* renamed from: a */
    public final void mo195a(int i, Fragment fragment) {
        this.f164p = i;
        if (fragment != null) {
            this.f165q = fragment.f165q + ":" + this.f164p;
        } else {
            this.f165q = "android:fragment:" + this.f164p;
        }
    }

    /* renamed from: a */
    public final boolean mo198a() {
        return this.f125B > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (this.f164p >= 0) {
            sb.append(" #");
            sb.append(this.f164p);
        }
        if (this.f130G != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f130G));
        }
        if (this.f132I != null) {
            sb.append(" ");
            sb.append(this.f132I);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.f130G;
    }

    public final String getTag() {
        return this.f132I;
    }

    public void setArguments(Bundle bundle) {
        if (this.f164p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f166r = bundle;
    }

    public final Bundle getArguments() {
        return this.f166r;
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.f164p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f162n = (savedState == null || savedState.f176a == null) ? null : savedState.f176a;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        this.f167s = fragment;
        this.f169u = i;
    }

    public final Fragment getTargetFragment() {
        return this.f167s;
    }

    public final int getTargetRequestCode() {
        return this.f169u;
    }

    public Context getContext() {
        if (this.f127D == null) {
            return null;
        }
        return this.f127D.mo407c();
    }

    public final FragmentActivity getActivity() {
        if (this.f127D == null) {
            return null;
        }
        return (FragmentActivity) this.f127D.mo406b();
    }

    public final Object getHost() {
        if (this.f127D == null) {
            return null;
        }
        return this.f127D.onGetHost();
    }

    public final Resources getResources() {
        if (this.f127D != null) {
            return this.f127D.mo407c().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final CharSequence getText(@StringRes int i) {
        return getResources().getText(i);
    }

    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    public final String getString(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final FragmentManager getFragmentManager() {
        return this.f126C;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.f128E == null) {
            mo206c();
            if (this.f159k >= 5) {
                this.f128E.mo13829j();
            } else if (this.f159k >= 4) {
                this.f128E.mo13828i();
            } else if (this.f159k >= 2) {
                this.f128E.mo13827h();
            } else if (this.f159k >= 1) {
                this.f128E.mo13826g();
            }
        }
        return this.f128E;
    }

    public final Fragment getParentFragment() {
        return this.f129F;
    }

    public final boolean isAdded() {
        return this.f127D != null && this.f170v;
    }

    public final boolean isDetached() {
        return this.f134K;
    }

    public final boolean isRemoving() {
        return this.f171w;
    }

    public final boolean isInLayout() {
        return this.f174z;
    }

    public final boolean isResumed() {
        return this.f172x;
    }

    public final boolean isVisible() {
        return isAdded() && !isHidden() && this.f142S != null && this.f142S.getWindowToken() != null && this.f142S.getVisibility() == 0;
    }

    public final boolean isHidden() {
        return this.f133J;
    }

    public final boolean hasOptionsMenu() {
        return this.f137N;
    }

    public final boolean isMenuVisible() {
        return this.f138O;
    }

    public void onHiddenChanged(boolean z) {
    }

    public void setRetainInstance(boolean z) {
        if (!z || this.f129F == null) {
            this.f135L = z;
            return;
        }
        throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    }

    public final boolean getRetainInstance() {
        return this.f135L;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.f137N != z) {
            this.f137N = z;
            if (isAdded() && !isHidden()) {
                this.f127D.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.f138O != z) {
            this.f138O = z;
            if (this.f137N && isAdded() && !isHidden()) {
                this.f127D.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.f145V && z && this.f159k < 4) {
            this.f126C.mo13799a(this);
        }
        this.f145V = z;
        this.f144U = !z;
    }

    public boolean getUserVisibleHint() {
        return this.f145V;
    }

    public LoaderManager getLoaderManager() {
        if (this.f146W != null) {
            return this.f146W;
        }
        if (this.f127D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f148Y = true;
        this.f146W = this.f127D.mo401a(this.f165q, this.f147X, true);
        return this.f146W;
    }

    public void startActivity(Intent intent) {
        if (this.f127D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f127D.onStartActivityFromFragment(this, intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f127D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f127D.onStartActivityFromFragment(this, intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        if (this.f127D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f127D.onRequestPermissionsFromFragment(this, strArr, i);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        if (this.f127D != null) {
            return this.f127D.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = this.f127D.onGetLayoutInflater();
        getChildFragmentManager();
        LayoutInflaterCompat.setFactory(onGetLayoutInflater, this.f128E.mo13836q());
        return onGetLayoutInflater;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f139P = true;
        Activity b = this.f127D == null ? null : this.f127D.mo406b();
        if (b != null) {
            this.f139P = false;
            onInflate(b, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f139P = true;
    }

    public void onAttach(Context context) {
        this.f139P = true;
        Activity b = this.f127D == null ? null : this.f127D.mo406b();
        if (b != null) {
            this.f139P = false;
            onAttach(b);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.f139P = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        this.f139P = true;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
    }

    @Nullable
    public View getView() {
        return this.f142S;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        this.f139P = true;
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.f139P = true;
    }

    public void onStart() {
        this.f139P = true;
        if (!this.f147X) {
            this.f147X = true;
            if (!this.f148Y) {
                this.f148Y = true;
                this.f146W = this.f127D.mo401a(this.f165q, this.f147X, false);
            }
            if (this.f146W != null) {
                this.f146W.mo13847a();
            }
        }
    }

    public void onResume() {
        this.f139P = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f139P = true;
    }

    public void onPause() {
        this.f139P = true;
    }

    public void onStop() {
        this.f139P = true;
    }

    public void onLowMemory() {
        this.f139P = true;
    }

    public void onDestroyView() {
        this.f139P = true;
    }

    public void onDestroy() {
        this.f139P = true;
        if (!this.f148Y) {
            this.f148Y = true;
            this.f146W = this.f127D.mo401a(this.f165q, this.f147X, false);
        }
        if (this.f146W != null) {
            this.f146W.mo13855g();
        }
    }

    /* renamed from: b */
    public void mo202b() {
        this.f164p = -1;
        this.f165q = null;
        this.f170v = false;
        this.f171w = false;
        this.f172x = false;
        this.f173y = false;
        this.f174z = false;
        this.f124A = false;
        this.f125B = 0;
        this.f126C = null;
        this.f128E = null;
        this.f127D = null;
        this.f130G = 0;
        this.f131H = 0;
        this.f132I = null;
        this.f133J = false;
        this.f134K = false;
        this.f136M = false;
        this.f146W = null;
        this.f147X = false;
        this.f148Y = false;
    }

    public void onDetach() {
        this.f139P = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.f157ah = sharedElementCallback;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.f158ai = sharedElementCallback;
    }

    public void setEnterTransition(Object obj) {
        this.f149Z = obj;
    }

    public Object getEnterTransition() {
        return this.f149Z;
    }

    public void setReturnTransition(Object obj) {
        this.f150aa = obj;
    }

    public Object getReturnTransition() {
        return this.f150aa == f123j ? getEnterTransition() : this.f150aa;
    }

    public void setExitTransition(Object obj) {
        this.f151ab = obj;
    }

    public Object getExitTransition() {
        return this.f151ab;
    }

    public void setReenterTransition(Object obj) {
        this.f152ac = obj;
    }

    public Object getReenterTransition() {
        return this.f152ac == f123j ? getExitTransition() : this.f152ac;
    }

    public void setSharedElementEnterTransition(Object obj) {
        this.f153ad = obj;
    }

    public Object getSharedElementEnterTransition() {
        return this.f153ad;
    }

    public void setSharedElementReturnTransition(Object obj) {
        this.f154ae = obj;
    }

    public Object getSharedElementReturnTransition() {
        return this.f154ae == f123j ? getSharedElementEnterTransition() : this.f154ae;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.f156ag = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.f156ag == null) {
            return true;
        }
        return this.f156ag.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.f155af = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.f155af == null) {
            return true;
        }
        return this.f155af.booleanValue();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f130G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f131H));
        printWriter.print(" mTag=");
        printWriter.println(this.f132I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f159k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f164p);
        printWriter.print(" mWho=");
        printWriter.print(this.f165q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f125B);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f170v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f171w);
        printWriter.print(" mResumed=");
        printWriter.print(this.f172x);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f173y);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f174z);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f133J);
        printWriter.print(" mDetached=");
        printWriter.print(this.f134K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f138O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f137N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f135L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f136M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f145V);
        if (this.f126C != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f126C);
        }
        if (this.f127D != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f127D);
        }
        if (this.f129F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f129F);
        }
        if (this.f166r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f166r);
        }
        if (this.f162n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f162n);
        }
        if (this.f163o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f163o);
        }
        if (this.f167s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f167s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f169u);
        }
        if (this.f140Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f140Q);
        }
        if (this.f141R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f141R);
        }
        if (this.f142S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f142S);
        }
        if (this.f143T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f142S);
        }
        if (this.f160l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f160l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f161m);
        }
        if (this.f146W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f146W.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f128E != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f128E + ":");
            this.f128E.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo206c() {
        this.f128E = new C2004v();
        this.f128E.mo13803a(this.f127D, (FragmentContainer) new FragmentContainer() {
            @Nullable
            public View onFindViewById(int i) {
                if (Fragment.this.f142S != null) {
                    return Fragment.this.f142S.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean onHasView() {
                return Fragment.this.f142S != null;
            }
        }, this);
    }

    /* renamed from: b */
    public void mo203b(Bundle bundle) {
        Parcelable parcelable;
        if (this.f128E != null) {
            this.f128E.mo13825f();
        }
        this.f139P = false;
        onCreate(bundle);
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.f128E == null) {
                mo206c();
            }
            this.f128E.mo13798a(parcelable, (List<Fragment>) null);
            this.f128E.mo13826g();
        }
    }

    /* renamed from: a */
    public View mo194a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f128E != null) {
            this.f128E.mo13825f();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* renamed from: c */
    public void mo207c(Bundle bundle) {
        if (this.f128E != null) {
            this.f128E.mo13825f();
        }
        this.f139P = false;
        onActivityCreated(bundle);
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f128E != null) {
            this.f128E.mo13827h();
        }
    }

    /* renamed from: d */
    public void mo208d() {
        if (this.f128E != null) {
            this.f128E.mo13825f();
            this.f128E.mo13813b();
        }
        this.f139P = false;
        onStart();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.f128E != null) {
            this.f128E.mo13828i();
        }
        if (this.f146W != null) {
            this.f146W.mo13854f();
        }
    }

    /* renamed from: e */
    public void mo211e() {
        if (this.f128E != null) {
            this.f128E.mo13825f();
            this.f128E.mo13813b();
        }
        this.f139P = false;
        onResume();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f128E != null) {
            this.f128E.mo13829j();
            this.f128E.mo13813b();
        }
    }

    /* renamed from: a */
    public void mo196a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f128E != null) {
            this.f128E.mo13797a(configuration);
        }
    }

    /* renamed from: f */
    public void mo213f() {
        onLowMemory();
        if (this.f128E != null) {
            this.f128E.mo13835p();
        }
    }

    /* renamed from: a */
    public boolean mo200a(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f133J) {
            return false;
        }
        if (this.f137N && this.f138O) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        if (this.f128E != null) {
            return z | this.f128E.mo13807a(menu, menuInflater);
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo199a(Menu menu) {
        boolean z = false;
        if (this.f133J) {
            return false;
        }
        if (this.f137N && this.f138O) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        if (this.f128E != null) {
            return z | this.f128E.mo13806a(menu);
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo201a(MenuItem menuItem) {
        if (!this.f133J) {
            if (this.f137N && this.f138O && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.f128E == null || !this.f128E.mo13808a(menuItem)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo205b(MenuItem menuItem) {
        if (!this.f133J) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (this.f128E == null || !this.f128E.mo13814b(menuItem)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void mo204b(Menu menu) {
        if (!this.f133J) {
            if (this.f137N && this.f138O) {
                onOptionsMenuClosed(menu);
            }
            if (this.f128E != null) {
                this.f128E.mo13812b(menu);
            }
        }
    }

    /* renamed from: d */
    public void mo209d(Bundle bundle) {
        Parcelable e;
        onSaveInstanceState(bundle);
        if (this.f128E != null && (e = this.f128E.mo13821e()) != null) {
            bundle.putParcelable("android:support:fragments", e);
        }
    }

    /* renamed from: g */
    public void mo214g() {
        if (this.f128E != null) {
            this.f128E.mo13830k();
        }
        this.f139P = false;
        onPause();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* renamed from: h */
    public void mo242h() {
        if (this.f128E != null) {
            this.f128E.mo13831l();
        }
        this.f139P = false;
        onStop();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* renamed from: i */
    public void mo245i() {
        if (this.f128E != null) {
            this.f128E.mo13832m();
        }
        if (this.f147X) {
            this.f147X = false;
            if (!this.f148Y) {
                this.f148Y = true;
                this.f146W = this.f127D.mo401a(this.f165q, this.f147X, false);
            }
            if (this.f146W == null) {
                return;
            }
            if (this.f127D.mo411g()) {
                this.f146W.mo13851c();
            } else {
                this.f146W.mo13850b();
            }
        }
    }

    /* renamed from: j */
    public void mo254j() {
        if (this.f128E != null) {
            this.f128E.mo13833n();
        }
        this.f139P = false;
        onDestroyView();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f146W != null) {
            this.f146W.mo13853e();
        }
    }

    /* renamed from: k */
    public void mo255k() {
        if (this.f128E != null) {
            this.f128E.mo13834o();
        }
        this.f139P = false;
        onDestroy();
        if (!this.f139P) {
            throw new C0008ah("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
