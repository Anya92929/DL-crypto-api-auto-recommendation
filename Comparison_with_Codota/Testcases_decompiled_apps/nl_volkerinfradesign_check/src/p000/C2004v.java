package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.p001v4.app.BackStackRecord;
import android.support.p001v4.app.BackStackState;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentContainer;
import android.support.p001v4.app.FragmentHostCallback;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentManagerState;
import android.support.p001v4.app.FragmentState;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.util.DebugUtils;
import android.support.p001v4.util.LogWriter;
import android.support.p001v4.view.LayoutInflaterFactory;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: v */
public final class C2004v extends FragmentManager implements LayoutInflaterFactory {

    /* renamed from: A */
    static final Interpolator f7285A = new DecelerateInterpolator(2.5f);

    /* renamed from: B */
    static final Interpolator f7286B = new DecelerateInterpolator(1.5f);

    /* renamed from: C */
    static final Interpolator f7287C = new AccelerateInterpolator(2.5f);

    /* renamed from: D */
    static final Interpolator f7288D = new AccelerateInterpolator(1.5f);

    /* renamed from: a */
    public static boolean f7289a = false;

    /* renamed from: b */
    static final boolean f7290b;

    /* renamed from: r */
    static Field f7291r = null;

    /* renamed from: c */
    ArrayList<Runnable> f7292c;

    /* renamed from: d */
    Runnable[] f7293d;

    /* renamed from: e */
    boolean f7294e;

    /* renamed from: f */
    public ArrayList<Fragment> f7295f;

    /* renamed from: g */
    public ArrayList<Fragment> f7296g;

    /* renamed from: h */
    ArrayList<Integer> f7297h;

    /* renamed from: i */
    ArrayList<BackStackRecord> f7298i;

    /* renamed from: j */
    ArrayList<Fragment> f7299j;

    /* renamed from: k */
    ArrayList<BackStackRecord> f7300k;

    /* renamed from: l */
    ArrayList<Integer> f7301l;

    /* renamed from: m */
    ArrayList<FragmentManager.OnBackStackChangedListener> f7302m;

    /* renamed from: n */
    public int f7303n = 0;

    /* renamed from: o */
    public FragmentHostCallback f7304o;

    /* renamed from: p */
    public FragmentContainer f7305p;

    /* renamed from: q */
    Fragment f7306q;

    /* renamed from: s */
    boolean f7307s;

    /* renamed from: t */
    boolean f7308t;

    /* renamed from: u */
    boolean f7309u;

    /* renamed from: v */
    String f7310v;

    /* renamed from: w */
    boolean f7311w;

    /* renamed from: x */
    Bundle f7312x = null;

    /* renamed from: y */
    SparseArray<Parcelable> f7313y = null;

    /* renamed from: z */
    Runnable f7314z = new Runnable() {
        public void run() {
            C2004v.this.mo13813b();
        }
    };

    /* renamed from: v$b */
    static class C2013b {

        /* renamed from: a */
        public static final int[] f7330a = {16842755, 16842960, 16842961};
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 11) {
            z = true;
        }
        f7290b = z;
    }

    /* renamed from: v$a */
    static class C2010a implements Animation.AnimationListener {

        /* renamed from: a */
        private Animation.AnimationListener f7325a = null;

        /* renamed from: b */
        private boolean f7326b = false;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public View f7327c = null;

        public C2010a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f7327c = view;
            }
        }

        public C2010a(View view, Animation animation, Animation.AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f7325a = animationListener;
                this.f7327c = view;
            }
        }

        @CallSuper
        public void onAnimationStart(Animation animation) {
            if (this.f7327c != null) {
                this.f7326b = C2004v.m7588a(this.f7327c, animation);
                if (this.f7326b) {
                    this.f7327c.post(new Runnable() {
                        public void run() {
                            ViewCompat.setLayerType(C2010a.this.f7327c, 2, (Paint) null);
                        }
                    });
                }
            }
            if (this.f7325a != null) {
                this.f7325a.onAnimationStart(animation);
            }
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.f7327c != null && this.f7326b) {
                this.f7327c.post(new Runnable() {
                    public void run() {
                        ViewCompat.setLayerType(C2010a.this.f7327c, 0, (Paint) null);
                    }
                });
            }
            if (this.f7325a != null) {
                this.f7325a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f7325a != null) {
                this.f7325a.onAnimationRepeat(animation);
            }
        }
    }

    /* renamed from: a */
    static boolean m7589a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m7588a(View view, Animation animation) {
        return Build.VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(view) == 0 && ViewCompat.hasOverlappingRendering(view) && m7589a(animation);
    }

    /* renamed from: a */
    private void m7587a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f7304o != null) {
            try {
                this.f7304o.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean executePendingTransactions() {
        return mo13813b();
    }

    public void popBackStack() {
        mo13804a((Runnable) new Runnable() {
            public void run() {
                C2004v.this.mo13805a(C2004v.this.f7304o.mo408d(), (String) null, -1, 0);
            }
        }, false);
    }

    public boolean popBackStackImmediate() {
        m7593r();
        executePendingTransactions();
        return mo13805a(this.f7304o.mo408d(), (String) null, -1, 0);
    }

    public void popBackStack(final String str, final int i) {
        mo13804a((Runnable) new Runnable() {
            public void run() {
                C2004v.this.mo13805a(C2004v.this.f7304o.mo408d(), str, -1, i);
            }
        }, false);
    }

    public boolean popBackStackImmediate(String str, int i) {
        m7593r();
        executePendingTransactions();
        return mo13805a(this.f7304o.mo408d(), str, -1, i);
    }

    public void popBackStack(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        mo13804a((Runnable) new Runnable() {
            public void run() {
                C2004v.this.mo13805a(C2004v.this.f7304o.mo408d(), (String) null, i, i2);
            }
        }, false);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        m7593r();
        executePendingTransactions();
        if (i >= 0) {
            return mo13805a(this.f7304o.mo408d(), (String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public int getBackStackEntryCount() {
        if (this.f7298i != null) {
            return this.f7298i.size();
        }
        return 0;
    }

    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.f7298i.get(i);
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f7302m == null) {
            this.f7302m = new ArrayList<>();
        }
        this.f7302m.add(onBackStackChangedListener);
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f7302m != null) {
            this.f7302m.remove(onBackStackChangedListener);
        }
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f164p < 0) {
            m7587a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f164p);
    }

    public Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f7295f.size()) {
            m7587a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f7295f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m7587a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public List<Fragment> getFragments() {
        return this.f7295f;
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle f;
        if (fragment.f164p < 0) {
            m7587a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f159k <= 0 || (f = mo13824f(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(f);
    }

    public boolean isDestroyed() {
        return this.f7309u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f7306q != null) {
            DebugUtils.buildShortClassTag(this.f7306q, sb);
        } else {
            DebugUtils.buildShortClassTag(this.f7304o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f7295f != null && (size6 = this.f7295f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f7295f.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.f7296g != null && (size5 = this.f7296g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f7296g.get(i2).toString());
            }
        }
        if (this.f7299j != null && (size4 = this.f7299j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f7299j.get(i3).toString());
            }
        }
        if (this.f7298i != null && (size3 = this.f7298i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.f7298i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.mo124a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f7300k != null && (size2 = this.f7300k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(this.f7300k.get(i5));
                }
            }
            if (this.f7301l != null && this.f7301l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f7301l.toArray()));
            }
        }
        if (this.f7292c != null && (size = this.f7292c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(this.f7292c.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f7304o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f7305p);
        if (this.f7306q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f7306q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f7303n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f7308t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f7309u);
        if (this.f7307s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f7307s);
        }
        if (this.f7310v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f7310v);
        }
        if (this.f7297h != null && this.f7297h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f7297h.toArray()));
        }
    }

    /* renamed from: a */
    static Animation m7586a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f7285A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f7286B);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    /* renamed from: a */
    static Animation m7585a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f7286B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Animation mo13791a(Fragment fragment, int i, boolean z, int i2) {
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.f140Q);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.f140Q != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.f7304o.mo407c(), fragment.f140Q)) != null) {
            return loadAnimation;
        }
        if (i == 0) {
            return null;
        }
        int b = m7591b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return m7586a(this.f7304o.mo407c(), 1.125f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 2:
                return m7586a(this.f7304o.mo407c(), 1.0f, 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 3:
                return m7586a(this.f7304o.mo407c(), 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 4:
                return m7586a(this.f7304o.mo407c(), 1.0f, 1.075f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 5:
                return m7585a(this.f7304o.mo407c(), (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 6:
                return m7585a(this.f7304o.mo407c(), 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            default:
                if (i2 == 0 && this.f7304o.onHasWindowAnimations()) {
                    i2 = this.f7304o.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    /* renamed from: a */
    public void mo13799a(Fragment fragment) {
        if (!fragment.f144U) {
            return;
        }
        if (this.f7294e) {
            this.f7311w = true;
            return;
        }
        fragment.f144U = false;
        mo13801a(fragment, this.f7303n, 0, 0, false);
    }

    /* renamed from: b */
    private void m7592b(View view, Animation animation) {
        Animation.AnimationListener animationListener;
        if (view != null && animation != null && m7588a(view, animation)) {
            try {
                if (f7291r == null) {
                    f7291r = Animation.class.getDeclaredField("mListener");
                    f7291r.setAccessible(true);
                }
                animationListener = (Animation.AnimationListener) f7291r.get(animation);
            } catch (NoSuchFieldException e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (IllegalAccessException e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new C2010a(view, animation, animationListener));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0213, code lost:
        if (f7289a == false) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0215, code lost:
        android.util.Log.v("FragmentManager", "moveto STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022d, code lost:
        r11.mo208d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0230, code lost:
        if (r12 <= 4) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0234, code lost:
        if (f7289a == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0236, code lost:
        android.util.Log.v("FragmentManager", "moveto RESUMED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x024e, code lost:
        r11.f172x = true;
        r11.mo211e();
        r11.f162n = null;
        r11.f163o = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0267, code lost:
        r11.f142S = p000.C2017y.m7667a(r11.f142S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0271, code lost:
        r11.f143T = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x027f, code lost:
        if (r12 >= 1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0283, code lost:
        if (r10.f7309u == false) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0287, code lost:
        if (r11.f160l == null) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0289, code lost:
        r0 = r11.f160l;
        r11.f160l = null;
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0292, code lost:
        if (r11.f160l == null) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0294, code lost:
        r11.f161m = r12;
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02bd, code lost:
        if (r12 >= 4) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02c1, code lost:
        if (f7289a == false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02c3, code lost:
        android.util.Log.v("FragmentManager", "movefrom STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02db, code lost:
        r11.mo242h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02de, code lost:
        if (r12 >= 3) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e2, code lost:
        if (f7289a == false) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e4, code lost:
        android.util.Log.v("FragmentManager", "movefrom STOPPED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02fc, code lost:
        r11.mo245i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0300, code lost:
        if (r12 >= 2) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0304, code lost:
        if (f7289a == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0306, code lost:
        android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0320, code lost:
        if (r11.f142S == null) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0328, code lost:
        if (r10.f7304o.onShouldSaveFragmentState(r11) == false) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032c, code lost:
        if (r11.f163o != null) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x032e, code lost:
        mo13822e(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0331, code lost:
        r11.mo254j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0336, code lost:
        if (r11.f142S == null) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x033a, code lost:
        if (r11.f141R == null) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x033e, code lost:
        if (r10.f7303n <= 0) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0342, code lost:
        if (r10.f7309u != false) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0344, code lost:
        r0 = mo13791a(r11, r13, false, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0348, code lost:
        if (r0 == null) goto L_0x035f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x034a, code lost:
        r11.f160l = r11.f142S;
        r11.f161m = r12;
        r0.setAnimationListener(new p000.C2004v.C20095(r10, r11.f142S, r0));
        r11.f142S.startAnimation(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x035f, code lost:
        r11.f141R.removeView(r11.f142S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0366, code lost:
        r11.f141R = null;
        r11.f142S = null;
        r11.f143T = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0370, code lost:
        if (f7289a == false) goto L_0x038a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0372, code lost:
        android.util.Log.v("FragmentManager", "movefrom CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x038c, code lost:
        if (r11.f136M != false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x038e, code lost:
        r11.mo255k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0391, code lost:
        r11.f139P = false;
        r11.onDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0398, code lost:
        if (r11.f139P != false) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b8, code lost:
        throw new p000.C0008ah("Fragment " + r11 + " did not call through to super.onDetach()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b9, code lost:
        if (r15 != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03bd, code lost:
        if (r11.f136M != false) goto L_0x03c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03bf, code lost:
        mo13819d(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03c4, code lost:
        r11.f127D = null;
        r11.f129F = null;
        r11.f126C = null;
        r11.f128E = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03ce, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03d1, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x013e, code lost:
        if (r12 <= 1) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0142, code lost:
        if (f7289a == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0144, code lost:
        android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015e, code lost:
        if (r11.f173y != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0162, code lost:
        if (r11.f131H == 0) goto L_0x03d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0164, code lost:
        r0 = (android.view.ViewGroup) r10.f7305p.onFindViewById(r11.f131H);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016e, code lost:
        if (r0 != null) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0172, code lost:
        if (r11.f124A != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0174, code lost:
        m7587a((java.lang.RuntimeException) new java.lang.IllegalArgumentException("No view found for id 0x" + java.lang.Integer.toHexString(r11.f131H) + " (" + r11.getResources().getResourceName(r11.f131H) + ") for fragment " + r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b3, code lost:
        r11.f141R = r0;
        r11.f142S = r11.mo194a(r11.getLayoutInflater(r11.f162n), r0, r11.f162n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c5, code lost:
        if (r11.f142S == null) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c7, code lost:
        r11.f143T = r11.f142S;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01cf, code lost:
        if (android.os.Build.VERSION.SDK_INT < 11) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d1, code lost:
        android.support.p001v4.view.ViewCompat.setSaveFromParentEnabled(r11.f142S, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d6, code lost:
        if (r0 == null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d8, code lost:
        r1 = mo13791a(r11, r13, true, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01dc, code lost:
        if (r1 == null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01de, code lost:
        m7592b(r11.f142S, r1);
        r11.f142S.startAnimation(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e8, code lost:
        r0.addView(r11.f142S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ef, code lost:
        if (r11.f133J == false) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01f1, code lost:
        r11.f142S.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f8, code lost:
        r11.onViewCreated(r11.f142S, r11.f162n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ff, code lost:
        r11.mo207c(r11.f162n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0206, code lost:
        if (r11.f142S == null) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0208, code lost:
        r11.mo197a(r11.f162n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
        r11.f162n = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x020f, code lost:
        if (r12 <= 3) goto L_0x0230;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo13801a(final android.support.p001v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            r9 = 4
            r6 = 3
            r5 = 1
            r3 = 0
            r7 = 0
            boolean r0 = r11.f170v
            if (r0 == 0) goto L_0x000d
            boolean r0 = r11.f134K
            if (r0 == 0) goto L_0x0010
        L_0x000d:
            if (r12 <= r5) goto L_0x0010
            r12 = r5
        L_0x0010:
            boolean r0 = r11.f171w
            if (r0 == 0) goto L_0x001a
            int r0 = r11.f159k
            if (r12 <= r0) goto L_0x001a
            int r12 = r11.f159k
        L_0x001a:
            boolean r0 = r11.f144U
            if (r0 == 0) goto L_0x0025
            int r0 = r11.f159k
            if (r0 >= r9) goto L_0x0025
            if (r12 <= r6) goto L_0x0025
            r12 = r6
        L_0x0025:
            int r0 = r11.f159k
            if (r0 >= r12) goto L_0x0274
            boolean r0 = r11.f173y
            if (r0 == 0) goto L_0x0032
            boolean r0 = r11.f174z
            if (r0 != 0) goto L_0x0032
        L_0x0031:
            return
        L_0x0032:
            android.view.View r0 = r11.f160l
            if (r0 == 0) goto L_0x0040
            r11.f160l = r7
            int r2 = r11.f161m
            r0 = r10
            r1 = r11
            r4 = r3
            r0.mo13801a((android.support.p001v4.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x0040:
            int r0 = r11.f159k
            switch(r0) {
                case 0: goto L_0x0048;
                case 1: goto L_0x013e;
                case 2: goto L_0x020f;
                case 3: goto L_0x020f;
                case 4: goto L_0x0230;
                default: goto L_0x0045;
            }
        L_0x0045:
            r11.f159k = r12
            goto L_0x0031
        L_0x0048:
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0064:
            android.os.Bundle r0 = r11.f162n
            if (r0 == 0) goto L_0x00ac
            android.os.Bundle r0 = r11.f162n
            android.support.v4.app.FragmentHostCallback r1 = r10.f7304o
            android.content.Context r1 = r1.mo407c()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r11.f162n
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r11.f163o = r0
            android.os.Bundle r0 = r11.f162n
            java.lang.String r1 = "android:target_state"
            android.support.v4.app.Fragment r0 = r10.getFragment(r0, r1)
            r11.f167s = r0
            android.support.v4.app.Fragment r0 = r11.f167s
            if (r0 == 0) goto L_0x0099
            android.os.Bundle r0 = r11.f162n
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r3)
            r11.f169u = r0
        L_0x0099:
            android.os.Bundle r0 = r11.f162n
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r5)
            r11.f145V = r0
            boolean r0 = r11.f145V
            if (r0 != 0) goto L_0x00ac
            r11.f144U = r5
            if (r12 <= r6) goto L_0x00ac
            r12 = r6
        L_0x00ac:
            android.support.v4.app.FragmentHostCallback r0 = r10.f7304o
            r11.f127D = r0
            android.support.v4.app.Fragment r0 = r10.f7306q
            r11.f129F = r0
            android.support.v4.app.Fragment r0 = r10.f7306q
            if (r0 == 0) goto L_0x00ec
            android.support.v4.app.Fragment r0 = r10.f7306q
            v r0 = r0.f128E
        L_0x00bc:
            r11.f126C = r0
            r11.f139P = r3
            android.support.v4.app.FragmentHostCallback r0 = r10.f7304o
            android.content.Context r0 = r0.mo407c()
            r11.onAttach((android.content.Context) r0)
            boolean r0 = r11.f139P
            if (r0 != 0) goto L_0x00f3
            ah r0 = new ah
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onAttach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ec:
            android.support.v4.app.FragmentHostCallback r0 = r10.f7304o
            v r0 = r0.mo409e()
            goto L_0x00bc
        L_0x00f3:
            android.support.v4.app.Fragment r0 = r11.f129F
            if (r0 != 0) goto L_0x00fc
            android.support.v4.app.FragmentHostCallback r0 = r10.f7304o
            r0.mo355a((android.support.p001v4.app.Fragment) r11)
        L_0x00fc:
            boolean r0 = r11.f136M
            if (r0 != 0) goto L_0x0105
            android.os.Bundle r0 = r11.f162n
            r11.mo203b((android.os.Bundle) r0)
        L_0x0105:
            r11.f136M = r3
            boolean r0 = r11.f173y
            if (r0 == 0) goto L_0x013e
            android.os.Bundle r0 = r11.f162n
            android.view.LayoutInflater r0 = r11.getLayoutInflater(r0)
            android.os.Bundle r1 = r11.f162n
            android.view.View r0 = r11.mo194a(r0, r7, r1)
            r11.f142S = r0
            android.view.View r0 = r11.f142S
            if (r0 == 0) goto L_0x0263
            android.view.View r0 = r11.f142S
            r11.f143T = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x0259
            android.view.View r0 = r11.f142S
            android.support.p001v4.view.ViewCompat.setSaveFromParentEnabled(r0, r3)
        L_0x012c:
            boolean r0 = r11.f133J
            if (r0 == 0) goto L_0x0137
            android.view.View r0 = r11.f142S
            r1 = 8
            r0.setVisibility(r1)
        L_0x0137:
            android.view.View r0 = r11.f142S
            android.os.Bundle r1 = r11.f162n
            r11.onViewCreated(r0, r1)
        L_0x013e:
            if (r12 <= r5) goto L_0x020f
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x015c
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x015c:
            boolean r0 = r11.f173y
            if (r0 != 0) goto L_0x01ff
            int r0 = r11.f131H
            if (r0 == 0) goto L_0x03d1
            android.support.v4.app.FragmentContainer r0 = r10.f7305p
            int r1 = r11.f131H
            android.view.View r0 = r0.onFindViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x01b3
            boolean r1 = r11.f124A
            if (r1 != 0) goto L_0x01b3
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "No view found for id 0x"
            java.lang.StringBuilder r2 = r2.append(r4)
            int r4 = r11.f131H
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " ("
            java.lang.StringBuilder r2 = r2.append(r4)
            android.content.res.Resources r4 = r11.getResources()
            int r8 = r11.f131H
            java.lang.String r4 = r4.getResourceName(r8)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ") for fragment "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r10.m7587a((java.lang.RuntimeException) r1)
        L_0x01b3:
            r11.f141R = r0
            android.os.Bundle r1 = r11.f162n
            android.view.LayoutInflater r1 = r11.getLayoutInflater(r1)
            android.os.Bundle r2 = r11.f162n
            android.view.View r1 = r11.mo194a(r1, r0, r2)
            r11.f142S = r1
            android.view.View r1 = r11.f142S
            if (r1 == 0) goto L_0x0271
            android.view.View r1 = r11.f142S
            r11.f143T = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r1 < r2) goto L_0x0267
            android.view.View r1 = r11.f142S
            android.support.p001v4.view.ViewCompat.setSaveFromParentEnabled(r1, r3)
        L_0x01d6:
            if (r0 == 0) goto L_0x01ed
            android.view.animation.Animation r1 = r10.mo13791a((android.support.p001v4.app.Fragment) r11, (int) r13, (boolean) r5, (int) r14)
            if (r1 == 0) goto L_0x01e8
            android.view.View r2 = r11.f142S
            r10.m7592b((android.view.View) r2, (android.view.animation.Animation) r1)
            android.view.View r2 = r11.f142S
            r2.startAnimation(r1)
        L_0x01e8:
            android.view.View r1 = r11.f142S
            r0.addView(r1)
        L_0x01ed:
            boolean r0 = r11.f133J
            if (r0 == 0) goto L_0x01f8
            android.view.View r0 = r11.f142S
            r1 = 8
            r0.setVisibility(r1)
        L_0x01f8:
            android.view.View r0 = r11.f142S
            android.os.Bundle r1 = r11.f162n
            r11.onViewCreated(r0, r1)
        L_0x01ff:
            android.os.Bundle r0 = r11.f162n
            r11.mo207c(r0)
            android.view.View r0 = r11.f142S
            if (r0 == 0) goto L_0x020d
            android.os.Bundle r0 = r11.f162n
            r11.mo197a((android.os.Bundle) r0)
        L_0x020d:
            r11.f162n = r7
        L_0x020f:
            if (r12 <= r6) goto L_0x0230
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x022d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x022d:
            r11.mo208d()
        L_0x0230:
            if (r12 <= r9) goto L_0x0045
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x024e
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x024e:
            r11.f172x = r5
            r11.mo211e()
            r11.f162n = r7
            r11.f163o = r7
            goto L_0x0045
        L_0x0259:
            android.view.View r0 = r11.f142S
            android.view.ViewGroup r0 = p000.C2017y.m7667a(r0)
            r11.f142S = r0
            goto L_0x012c
        L_0x0263:
            r11.f143T = r7
            goto L_0x013e
        L_0x0267:
            android.view.View r1 = r11.f142S
            android.view.ViewGroup r1 = p000.C2017y.m7667a(r1)
            r11.f142S = r1
            goto L_0x01d6
        L_0x0271:
            r11.f143T = r7
            goto L_0x01ff
        L_0x0274:
            int r0 = r11.f159k
            if (r0 <= r12) goto L_0x0045
            int r0 = r11.f159k
            switch(r0) {
                case 1: goto L_0x027f;
                case 2: goto L_0x02ff;
                case 3: goto L_0x02de;
                case 4: goto L_0x02bd;
                case 5: goto L_0x0299;
                default: goto L_0x027d;
            }
        L_0x027d:
            goto L_0x0045
        L_0x027f:
            if (r12 >= r5) goto L_0x0045
            boolean r0 = r10.f7309u
            if (r0 == 0) goto L_0x0290
            android.view.View r0 = r11.f160l
            if (r0 == 0) goto L_0x0290
            android.view.View r0 = r11.f160l
            r11.f160l = r7
            r0.clearAnimation()
        L_0x0290:
            android.view.View r0 = r11.f160l
            if (r0 == 0) goto L_0x036e
            r11.f161m = r12
            r12 = r5
            goto L_0x0045
        L_0x0299:
            r0 = 5
            if (r12 >= r0) goto L_0x02bd
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x02b8
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02b8:
            r11.mo214g()
            r11.f172x = r3
        L_0x02bd:
            if (r12 >= r9) goto L_0x02de
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x02db
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02db:
            r11.mo242h()
        L_0x02de:
            if (r12 >= r6) goto L_0x02ff
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x02fc
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STOPPED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02fc:
            r11.mo245i()
        L_0x02ff:
            r0 = 2
            if (r12 >= r0) goto L_0x027f
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x031e
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x031e:
            android.view.View r0 = r11.f142S
            if (r0 == 0) goto L_0x0331
            android.support.v4.app.FragmentHostCallback r0 = r10.f7304o
            boolean r0 = r0.onShouldSaveFragmentState(r11)
            if (r0 == 0) goto L_0x0331
            android.util.SparseArray<android.os.Parcelable> r0 = r11.f163o
            if (r0 != 0) goto L_0x0331
            r10.mo13822e(r11)
        L_0x0331:
            r11.mo254j()
            android.view.View r0 = r11.f142S
            if (r0 == 0) goto L_0x0366
            android.view.ViewGroup r0 = r11.f141R
            if (r0 == 0) goto L_0x0366
            int r0 = r10.f7303n
            if (r0 <= 0) goto L_0x03ce
            boolean r0 = r10.f7309u
            if (r0 != 0) goto L_0x03ce
            android.view.animation.Animation r0 = r10.mo13791a((android.support.p001v4.app.Fragment) r11, (int) r13, (boolean) r3, (int) r14)
        L_0x0348:
            if (r0 == 0) goto L_0x035f
            android.view.View r1 = r11.f142S
            r11.f160l = r1
            r11.f161m = r12
            android.view.View r1 = r11.f142S
            v$5 r2 = new v$5
            r2.<init>(r1, r0, r11)
            r0.setAnimationListener(r2)
            android.view.View r1 = r11.f142S
            r1.startAnimation(r0)
        L_0x035f:
            android.view.ViewGroup r0 = r11.f141R
            android.view.View r1 = r11.f142S
            r0.removeView(r1)
        L_0x0366:
            r11.f141R = r7
            r11.f142S = r7
            r11.f143T = r7
            goto L_0x027f
        L_0x036e:
            boolean r0 = f7289a
            if (r0 == 0) goto L_0x038a
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x038a:
            boolean r0 = r11.f136M
            if (r0 != 0) goto L_0x0391
            r11.mo255k()
        L_0x0391:
            r11.f139P = r3
            r11.onDetach()
            boolean r0 = r11.f139P
            if (r0 != 0) goto L_0x03b9
            ah r0 = new ah
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onDetach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03b9:
            if (r15 != 0) goto L_0x0045
            boolean r0 = r11.f136M
            if (r0 != 0) goto L_0x03c4
            r10.mo13819d(r11)
            goto L_0x0045
        L_0x03c4:
            r11.f127D = r7
            r11.f129F = r7
            r11.f126C = r7
            r11.f128E = r7
            goto L_0x0045
        L_0x03ce:
            r0 = r7
            goto L_0x0348
        L_0x03d1:
            r0 = r7
            goto L_0x01b3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2004v.mo13801a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo13810b(Fragment fragment) {
        mo13801a(fragment, this.f7303n, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13796a(int i, boolean z) {
        mo13794a(i, 0, 0, z);
    }

    /* renamed from: a */
    public void mo13794a(int i, int i2, int i3, boolean z) {
        if (this.f7304o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f7303n != i) {
            this.f7303n = i;
            if (this.f7295f != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.f7295f.size()) {
                    Fragment fragment = this.f7295f.get(i4);
                    if (fragment != null) {
                        mo13801a(fragment, i, i2, i3, false);
                        if (fragment.f146W != null) {
                            z2 |= fragment.f146W.hasRunningLoaders();
                        }
                    }
                    i4++;
                    z2 = z2;
                }
                if (!z2) {
                    mo13792a();
                }
                if (this.f7307s && this.f7304o != null && this.f7303n == 5) {
                    this.f7304o.onSupportInvalidateOptionsMenu();
                    this.f7307s = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo13792a() {
        if (this.f7295f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7295f.size()) {
                    Fragment fragment = this.f7295f.get(i2);
                    if (fragment != null) {
                        mo13799a(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo13816c(Fragment fragment) {
        if (fragment.f164p < 0) {
            if (this.f7297h == null || this.f7297h.size() <= 0) {
                if (this.f7295f == null) {
                    this.f7295f = new ArrayList<>();
                }
                fragment.mo195a(this.f7295f.size(), this.f7306q);
                this.f7295f.add(fragment);
            } else {
                fragment.mo195a(this.f7297h.remove(this.f7297h.size() - 1).intValue(), this.f7306q);
                this.f7295f.set(fragment.f164p, fragment);
            }
            if (f7289a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo13819d(Fragment fragment) {
        if (fragment.f164p >= 0) {
            if (f7289a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f7295f.set(fragment.f164p, (Object) null);
            if (this.f7297h == null) {
                this.f7297h = new ArrayList<>();
            }
            this.f7297h.add(Integer.valueOf(fragment.f164p));
            this.f7304o.mo403a(fragment.f165q);
            fragment.mo202b();
        }
    }

    /* renamed from: a */
    public void mo13802a(Fragment fragment, boolean z) {
        if (this.f7296g == null) {
            this.f7296g = new ArrayList<>();
        }
        if (f7289a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        mo13816c(fragment);
        if (fragment.f134K) {
            return;
        }
        if (this.f7296g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        this.f7296g.add(fragment);
        fragment.f170v = true;
        fragment.f171w = false;
        if (fragment.f137N && fragment.f138O) {
            this.f7307s = true;
        }
        if (z) {
            mo13810b(fragment);
        }
    }

    /* renamed from: a */
    public void mo13800a(Fragment fragment, int i, int i2) {
        int i3;
        if (f7289a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f125B);
        }
        boolean z = !fragment.mo198a();
        if (!fragment.f134K || z) {
            if (this.f7296g != null) {
                this.f7296g.remove(fragment);
            }
            if (fragment.f137N && fragment.f138O) {
                this.f7307s = true;
            }
            fragment.f170v = false;
            fragment.f171w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            mo13801a(fragment, i3, i, i2, false);
        }
    }

    /* renamed from: b */
    public void mo13811b(Fragment fragment, int i, int i2) {
        if (f7289a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f133J) {
            fragment.f133J = true;
            if (fragment.f142S != null) {
                Animation a = mo13791a(fragment, i, false, i2);
                if (a != null) {
                    m7592b(fragment.f142S, a);
                    fragment.f142S.startAnimation(a);
                }
                fragment.f142S.setVisibility(8);
            }
            if (fragment.f170v && fragment.f137N && fragment.f138O) {
                this.f7307s = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    /* renamed from: c */
    public void mo13817c(Fragment fragment, int i, int i2) {
        if (f7289a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f133J) {
            fragment.f133J = false;
            if (fragment.f142S != null) {
                Animation a = mo13791a(fragment, i, true, i2);
                if (a != null) {
                    m7592b(fragment.f142S, a);
                    fragment.f142S.startAnimation(a);
                }
                fragment.f142S.setVisibility(0);
            }
            if (fragment.f170v && fragment.f137N && fragment.f138O) {
                this.f7307s = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    /* renamed from: d */
    public void mo13820d(Fragment fragment, int i, int i2) {
        if (f7289a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f134K) {
            fragment.f134K = true;
            if (fragment.f170v) {
                if (this.f7296g != null) {
                    if (f7289a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f7296g.remove(fragment);
                }
                if (fragment.f137N && fragment.f138O) {
                    this.f7307s = true;
                }
                fragment.f170v = false;
                mo13801a(fragment, 1, i, i2, false);
            }
        }
    }

    /* renamed from: e */
    public void mo13823e(Fragment fragment, int i, int i2) {
        if (f7289a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f134K) {
            fragment.f134K = false;
            if (!fragment.f170v) {
                if (this.f7296g == null) {
                    this.f7296g = new ArrayList<>();
                }
                if (this.f7296g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f7289a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f7296g.add(fragment);
                fragment.f170v = true;
                if (fragment.f137N && fragment.f138O) {
                    this.f7307s = true;
                }
                mo13801a(fragment, this.f7303n, i, i2, false);
            }
        }
    }

    public Fragment findFragmentById(int i) {
        if (this.f7296g != null) {
            for (int size = this.f7296g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f7296g.get(size);
                if (fragment != null && fragment.f130G == i) {
                    return fragment;
                }
            }
        }
        if (this.f7295f != null) {
            for (int size2 = this.f7295f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f7295f.get(size2);
                if (fragment2 != null && fragment2.f130G == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        if (!(this.f7296g == null || str == null)) {
            for (int size = this.f7296g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f7296g.get(size);
                if (fragment != null && str.equals(fragment.f132I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f7295f == null || str == null)) {
            for (int size2 = this.f7295f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f7295f.get(size2);
                if (fragment2 != null && str.equals(fragment2.f132I)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* renamed from: r */
    private void m7593r() {
        if (this.f7308t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f7310v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f7310v);
        }
    }

    /* renamed from: a */
    public void mo13804a(Runnable runnable, boolean z) {
        if (!z) {
            m7593r();
        }
        synchronized (this) {
            if (this.f7309u || this.f7304o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f7292c == null) {
                this.f7292c = new ArrayList<>();
            }
            this.f7292c.add(runnable);
            if (this.f7292c.size() == 1) {
                this.f7304o.mo408d().removeCallbacks(this.f7314z);
                this.f7304o.mo408d().post(this.f7314z);
            }
        }
    }

    /* renamed from: a */
    public int mo13790a(BackStackRecord backStackRecord) {
        int i;
        synchronized (this) {
            if (this.f7301l == null || this.f7301l.size() <= 0) {
                if (this.f7300k == null) {
                    this.f7300k = new ArrayList<>();
                }
                i = this.f7300k.size();
                if (f7289a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f7300k.add(backStackRecord);
            } else {
                i = this.f7301l.remove(this.f7301l.size() - 1).intValue();
                if (f7289a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f7300k.set(i, backStackRecord);
            }
        }
        return i;
    }

    /* renamed from: a */
    public void mo13795a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f7300k == null) {
                this.f7300k = new ArrayList<>();
            }
            int size = this.f7300k.size();
            if (i < size) {
                if (f7289a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f7300k.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f7300k.add((Object) null);
                    if (this.f7301l == null) {
                        this.f7301l = new ArrayList<>();
                    }
                    if (f7289a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f7301l.add(Integer.valueOf(size));
                    size++;
                }
                if (f7289a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f7300k.add(backStackRecord);
            }
        }
    }

    /* renamed from: a */
    public void mo13793a(int i) {
        synchronized (this) {
            this.f7300k.set(i, (Object) null);
            if (this.f7301l == null) {
                this.f7301l = new ArrayList<>();
            }
            if (f7289a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f7301l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        r6.f7294e = true;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r1 >= r3) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r6.f7293d[r1].run();
        r6.f7293d[r1] = null;
        r1 = r1 + 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo13813b() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.f7294e
            if (r1 == 0) goto L_0x000e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.FragmentHostCallback r3 = r6.f7304o
            android.os.Handler r3 = r3.mo408d()
            android.os.Looper r3 = r3.getLooper()
            if (r1 == r3) goto L_0x0026
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of process"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            r1 = r2
        L_0x0027:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f7292c     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x0034
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f7292c     // Catch:{ all -> 0x009b }
            int r3 = r3.size()     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x005c
        L_0x0034:
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            boolean r0 = r6.f7311w
            if (r0 == 0) goto L_0x00a9
            r3 = r2
            r4 = r2
        L_0x003b:
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f7295f
            int r0 = r0.size()
            if (r3 >= r0) goto L_0x00a2
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f7295f
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.p001v4.app.Fragment) r0
            if (r0 == 0) goto L_0x0058
            w r5 = r0.f146W
            if (r5 == 0) goto L_0x0058
            w r0 = r0.f146W
            boolean r0 = r0.hasRunningLoaders()
            r4 = r4 | r0
        L_0x0058:
            int r0 = r3 + 1
            r3 = r0
            goto L_0x003b
        L_0x005c:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f7292c     // Catch:{ all -> 0x009b }
            int r3 = r1.size()     // Catch:{ all -> 0x009b }
            java.lang.Runnable[] r1 = r6.f7293d     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x006b
            java.lang.Runnable[] r1 = r6.f7293d     // Catch:{ all -> 0x009b }
            int r1 = r1.length     // Catch:{ all -> 0x009b }
            if (r1 >= r3) goto L_0x006f
        L_0x006b:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch:{ all -> 0x009b }
            r6.f7293d = r1     // Catch:{ all -> 0x009b }
        L_0x006f:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f7292c     // Catch:{ all -> 0x009b }
            java.lang.Runnable[] r4 = r6.f7293d     // Catch:{ all -> 0x009b }
            r1.toArray(r4)     // Catch:{ all -> 0x009b }
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f7292c     // Catch:{ all -> 0x009b }
            r1.clear()     // Catch:{ all -> 0x009b }
            android.support.v4.app.FragmentHostCallback r1 = r6.f7304o     // Catch:{ all -> 0x009b }
            android.os.Handler r1 = r1.mo408d()     // Catch:{ all -> 0x009b }
            java.lang.Runnable r4 = r6.f7314z     // Catch:{ all -> 0x009b }
            r1.removeCallbacks(r4)     // Catch:{ all -> 0x009b }
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            r6.f7294e = r0
            r1 = r2
        L_0x008a:
            if (r1 >= r3) goto L_0x009e
            java.lang.Runnable[] r4 = r6.f7293d
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.f7293d
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L_0x008a
        L_0x009b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            throw r0
        L_0x009e:
            r6.f7294e = r2
            r1 = r0
            goto L_0x0027
        L_0x00a2:
            if (r4 != 0) goto L_0x00a9
            r6.f7311w = r2
            r6.mo13792a()
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2004v.mo13813b():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo13815c() {
        if (this.f7302m != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7302m.size()) {
                    this.f7302m.get(i2).onBackStackChanged();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public void mo13809b(BackStackRecord backStackRecord) {
        if (this.f7298i == null) {
            this.f7298i = new ArrayList<>();
        }
        this.f7298i.add(backStackRecord);
        mo13815c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo13805a(Handler handler, String str, int i, int i2) {
        boolean z;
        int i3;
        if (this.f7298i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f7298i.size() - 1;
            if (size < 0) {
                return false;
            }
            BackStackRecord remove = this.f7298i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            remove.mo123a((SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2);
            remove.mo120a(true, (BackStackRecord.TransitionState) null, (SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2);
            mo13815c();
        } else {
            int i4 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f7298i.size() - 1;
                while (i3 >= 0) {
                    BackStackRecord backStackRecord = this.f7298i.get(i3);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.f70p)) {
                        break;
                    }
                    size2 = i3 - 1;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    i3--;
                    while (i3 >= 0) {
                        BackStackRecord backStackRecord2 = this.f7298i.get(i3);
                        if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.f70p)) {
                            break;
                        }
                        i3--;
                    }
                }
                i4 = i3;
            }
            if (i4 == this.f7298i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.f7298i.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f7298i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (int i5 = 0; i5 <= size4; i5++) {
                ((BackStackRecord) arrayList.get(i5)).mo123a((SparseArray<Fragment>) sparseArray3, (SparseArray<Fragment>) sparseArray4);
            }
            BackStackRecord.TransitionState transitionState = null;
            int i6 = 0;
            while (i6 <= size4) {
                if (f7289a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i6));
                }
                BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i6);
                if (i6 == size4) {
                    z = true;
                } else {
                    z = false;
                }
                i6++;
                transitionState = backStackRecord3.mo120a(z, transitionState, (SparseArray<Fragment>) sparseArray3, (SparseArray<Fragment>) sparseArray4);
            }
            mo13815c();
        }
        return true;
    }

    /* renamed from: d */
    public ArrayList<Fragment> mo13818d() {
        ArrayList<Fragment> arrayList = null;
        if (this.f7295f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f7295f.size()) {
                    break;
                }
                Fragment fragment = this.f7295f.get(i2);
                if (fragment != null && fragment.f135L) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.f136M = true;
                    fragment.f168t = fragment.f167s != null ? fragment.f167s.f164p : -1;
                    if (f7289a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo13822e(Fragment fragment) {
        if (fragment.f143T != null) {
            if (this.f7313y == null) {
                this.f7313y = new SparseArray<>();
            } else {
                this.f7313y.clear();
            }
            fragment.f143T.saveHierarchyState(this.f7313y);
            if (this.f7313y.size() > 0) {
                fragment.f163o = this.f7313y;
                this.f7313y = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Bundle mo13824f(Fragment fragment) {
        Bundle bundle;
        if (this.f7312x == null) {
            this.f7312x = new Bundle();
        }
        fragment.mo209d(this.f7312x);
        if (!this.f7312x.isEmpty()) {
            bundle = this.f7312x;
            this.f7312x = null;
        } else {
            bundle = null;
        }
        if (fragment.f142S != null) {
            mo13822e(fragment);
        }
        if (fragment.f163o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f163o);
        }
        if (!fragment.f145V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f145V);
        }
        return bundle;
    }

    /* renamed from: e */
    public Parcelable mo13821e() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        mo13813b();
        if (f7290b) {
            this.f7308t = true;
        }
        if (this.f7295f == null || this.f7295f.size() <= 0) {
            return null;
        }
        int size3 = this.f7295f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = this.f7295f.get(i);
            if (fragment != null) {
                if (fragment.f164p < 0) {
                    m7587a((RuntimeException) new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f164p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f159k <= 0 || fragmentState.f218j != null) {
                    fragmentState.f218j = fragment.f162n;
                } else {
                    fragmentState.f218j = mo13824f(fragment);
                    if (fragment.f167s != null) {
                        if (fragment.f167s.f164p < 0) {
                            m7587a((RuntimeException) new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f167s));
                        }
                        if (fragmentState.f218j == null) {
                            fragmentState.f218j = new Bundle();
                        }
                        putFragment(fragmentState.f218j, "android:target_state", fragment.f167s);
                        if (fragment.f169u != 0) {
                            fragmentState.f218j.putInt("android:target_req_state", fragment.f169u);
                        }
                    }
                }
                if (f7289a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f218j);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (z2) {
            if (this.f7296g == null || (size2 = this.f7296g.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    iArr[i2] = this.f7296g.get(i2).f164p;
                    if (iArr[i2] < 0) {
                        m7587a((RuntimeException) new IllegalStateException("Failure saving state: active " + this.f7296g.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (f7289a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f7296g.get(i2));
                    }
                }
            }
            if (this.f7298i != null && (size = this.f7298i.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i3 = 0; i3 < size; i3++) {
                    backStackStateArr[i3] = new BackStackState(this.f7298i.get(i3));
                    if (f7289a) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f7298i.get(i3));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f203a = fragmentStateArr;
            fragmentManagerState.f204b = iArr;
            fragmentManagerState.f205c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f7289a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    /* renamed from: a */
    public void mo13798a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f203a != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Fragment fragment = list.get(i);
                        if (f7289a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f203a[fragment.f164p];
                        fragmentState.f219k = fragment;
                        fragment.f163o = null;
                        fragment.f125B = 0;
                        fragment.f174z = false;
                        fragment.f170v = false;
                        fragment.f167s = null;
                        if (fragmentState.f218j != null) {
                            fragmentState.f218j.setClassLoader(this.f7304o.mo407c().getClassLoader());
                            fragment.f163o = fragmentState.f218j.getSparseParcelableArray("android:view_state");
                            fragment.f162n = fragmentState.f218j;
                        }
                    }
                }
                this.f7295f = new ArrayList<>(fragmentManagerState.f203a.length);
                if (this.f7297h != null) {
                    this.f7297h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.f203a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f203a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.mo447a(this.f7304o, this.f7306q);
                        if (f7289a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f7295f.add(a);
                        fragmentState2.f219k = null;
                    } else {
                        this.f7295f.add((Object) null);
                        if (this.f7297h == null) {
                            this.f7297h = new ArrayList<>();
                        }
                        if (f7289a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f7297h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        Fragment fragment2 = list.get(i3);
                        if (fragment2.f168t >= 0) {
                            if (fragment2.f168t < this.f7295f.size()) {
                                fragment2.f167s = this.f7295f.get(fragment2.f168t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.f168t);
                                fragment2.f167s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f204b != null) {
                    this.f7296g = new ArrayList<>(fragmentManagerState.f204b.length);
                    for (int i4 = 0; i4 < fragmentManagerState.f204b.length; i4++) {
                        Fragment fragment3 = this.f7295f.get(fragmentManagerState.f204b[i4]);
                        if (fragment3 == null) {
                            m7587a((RuntimeException) new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f204b[i4]));
                        }
                        fragment3.f170v = true;
                        if (f7289a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.f7296g.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f7296g.add(fragment3);
                    }
                } else {
                    this.f7296g = null;
                }
                if (fragmentManagerState.f205c != null) {
                    this.f7298i = new ArrayList<>(fragmentManagerState.f205c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.f205c.length; i5++) {
                        BackStackRecord a2 = fragmentManagerState.f205c[i5].mo162a(this);
                        if (f7289a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a2.f70p + "): " + a2);
                            a2.mo125a("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                        }
                        this.f7298i.add(a2);
                        if (a2.f70p >= 0) {
                            mo13795a(a2.f70p, a2);
                        }
                    }
                    return;
                }
                this.f7298i = null;
            }
        }
    }

    /* renamed from: a */
    public void mo13803a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f7304o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f7304o = fragmentHostCallback;
        this.f7305p = fragmentContainer;
        this.f7306q = fragment;
    }

    /* renamed from: f */
    public void mo13825f() {
        this.f7308t = false;
    }

    /* renamed from: g */
    public void mo13826g() {
        this.f7308t = false;
        mo13796a(1, false);
    }

    /* renamed from: h */
    public void mo13827h() {
        this.f7308t = false;
        mo13796a(2, false);
    }

    /* renamed from: i */
    public void mo13828i() {
        this.f7308t = false;
        mo13796a(4, false);
    }

    /* renamed from: j */
    public void mo13829j() {
        this.f7308t = false;
        mo13796a(5, false);
    }

    /* renamed from: k */
    public void mo13830k() {
        mo13796a(4, false);
    }

    /* renamed from: l */
    public void mo13831l() {
        this.f7308t = true;
        mo13796a(3, false);
    }

    /* renamed from: m */
    public void mo13832m() {
        mo13796a(2, false);
    }

    /* renamed from: n */
    public void mo13833n() {
        mo13796a(1, false);
    }

    /* renamed from: o */
    public void mo13834o() {
        this.f7309u = true;
        mo13813b();
        mo13796a(0, false);
        this.f7304o = null;
        this.f7305p = null;
        this.f7306q = null;
    }

    /* renamed from: a */
    public void mo13797a(Configuration configuration) {
        if (this.f7296g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7296g.size()) {
                    Fragment fragment = this.f7296g.get(i2);
                    if (fragment != null) {
                        fragment.mo196a(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: p */
    public void mo13835p() {
        if (this.f7296g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7296g.size()) {
                    Fragment fragment = this.f7296g.get(i2);
                    if (fragment != null) {
                        fragment.mo213f();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo13807a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<Fragment> arrayList = null;
        if (this.f7296g != null) {
            int i = 0;
            z = false;
            while (i < this.f7296g.size()) {
                Fragment fragment = this.f7296g.get(i);
                if (fragment != null && fragment.mo200a(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f7299j != null) {
            for (int i2 = 0; i2 < this.f7299j.size(); i2++) {
                Fragment fragment2 = this.f7299j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f7299j = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean mo13806a(Menu menu) {
        if (this.f7296g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f7296g.size(); i++) {
            Fragment fragment = this.f7296g.get(i);
            if (fragment != null && fragment.mo199a(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo13808a(MenuItem menuItem) {
        if (this.f7296g == null) {
            return false;
        }
        for (int i = 0; i < this.f7296g.size(); i++) {
            Fragment fragment = this.f7296g.get(i);
            if (fragment != null && fragment.mo201a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo13814b(MenuItem menuItem) {
        if (this.f7296g == null) {
            return false;
        }
        for (int i = 0; i < this.f7296g.size(); i++) {
            Fragment fragment = this.f7296g.get(i);
            if (fragment != null && fragment.mo205b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo13812b(Menu menu) {
        if (this.f7296g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7296g.size()) {
                    Fragment fragment = this.f7296g.get(i2);
                    if (fragment != null) {
                        fragment.mo204b(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public static int m7590b(int i) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                return 8194;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            case 8194:
                return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m7591b(int i, boolean z) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                return z ? 1 : 2;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        String str2;
        int i;
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2013b.f7330a);
        if (attributeValue == null) {
            str2 = obtainStyledAttributes.getString(0);
        } else {
            str2 = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m149a(this.f7304o.mo407c(), str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        } else {
            i = 0;
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && i != -1) {
            findFragmentById = findFragmentById(i);
        }
        if (f7289a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = Fragment.instantiate(context, str2);
            instantiate.f173y = true;
            instantiate.f130G = resourceId != 0 ? resourceId : i;
            instantiate.f131H = i;
            instantiate.f132I = string;
            instantiate.f174z = true;
            instantiate.f126C = this;
            instantiate.f127D = this.f7304o;
            instantiate.onInflate(this.f7304o.mo407c(), attributeSet, instantiate.f162n);
            mo13802a(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.f174z) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str2);
        } else {
            findFragmentById.f174z = true;
            if (!findFragmentById.f136M) {
                findFragmentById.onInflate(this.f7304o.mo407c(), attributeSet, findFragmentById.f162n);
            }
            fragment = findFragmentById;
        }
        if (this.f7303n >= 1 || !fragment.f173y) {
            mo13810b(fragment);
        } else {
            mo13801a(fragment, 1, 0, 0, false);
        }
        if (fragment.f142S == null) {
            throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f142S.setId(resourceId);
        }
        if (fragment.f142S.getTag() == null) {
            fragment.f142S.setTag(string);
        }
        return fragment.f142S;
    }

    /* renamed from: q */
    public LayoutInflaterFactory mo13836q() {
        return this;
    }
}
