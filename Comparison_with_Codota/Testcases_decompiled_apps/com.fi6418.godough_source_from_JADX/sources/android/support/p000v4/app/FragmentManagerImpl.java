package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p000v4.app.BackStackRecord;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.LogWriter;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p000v4.view.ViewCompat;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerImpl */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {

    /* renamed from: A */
    static final Interpolator f436A = new DecelerateInterpolator(1.5f);
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;

    /* renamed from: B */
    static final Interpolator f437B = new AccelerateInterpolator(2.5f);

    /* renamed from: C */
    static final Interpolator f438C = new AccelerateInterpolator(1.5f);

    /* renamed from: a */
    static boolean f439a = false;

    /* renamed from: b */
    static final boolean f440b;

    /* renamed from: z */
    static final Interpolator f441z = new DecelerateInterpolator(2.5f);

    /* renamed from: c */
    ArrayList<Runnable> f442c;

    /* renamed from: d */
    Runnable[] f443d;

    /* renamed from: e */
    boolean f444e;

    /* renamed from: f */
    ArrayList<Fragment> f445f;

    /* renamed from: g */
    ArrayList<Fragment> f446g;

    /* renamed from: h */
    ArrayList<Integer> f447h;

    /* renamed from: i */
    ArrayList<BackStackRecord> f448i;

    /* renamed from: j */
    ArrayList<Fragment> f449j;

    /* renamed from: k */
    ArrayList<BackStackRecord> f450k;

    /* renamed from: l */
    ArrayList<Integer> f451l;

    /* renamed from: m */
    ArrayList<FragmentManager.OnBackStackChangedListener> f452m;

    /* renamed from: n */
    int f453n = 0;

    /* renamed from: o */
    FragmentHostCallback f454o;

    /* renamed from: p */
    FragmentContainer f455p;

    /* renamed from: q */
    Fragment f456q;

    /* renamed from: r */
    boolean f457r;

    /* renamed from: s */
    boolean f458s;

    /* renamed from: t */
    boolean f459t;

    /* renamed from: u */
    String f460u;

    /* renamed from: v */
    boolean f461v;

    /* renamed from: w */
    Bundle f462w = null;

    /* renamed from: x */
    SparseArray<Parcelable> f463x = null;

    /* renamed from: y */
    Runnable f464y = new Runnable() {
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };

    /* renamed from: android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener */
    class AnimateOnHWLayerIfNeededListener implements Animation.AnimationListener {

        /* renamed from: a */
        private boolean f475a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public View f476b;

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f476b = view;
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f475a) {
                this.f476b.post(new Runnable() {
                    public void run() {
                        ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.this.f476b, 0, (Paint) null);
                    }
                });
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f475a = FragmentManagerImpl.m485a(this.f476b, animation);
            if (this.f475a) {
                this.f476b.post(new Runnable() {
                    public void run() {
                        ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.this.f476b, 2, (Paint) null);
                    }
                });
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$FragmentTag */
    class FragmentTag {
        public static final int[] Fragment = {16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 11) {
            z = true;
        }
        f440b = z;
    }

    FragmentManagerImpl() {
    }

    /* renamed from: a */
    static Animation m482a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f436A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    /* renamed from: a */
    static Animation m483a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f441z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f436A);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    /* renamed from: a */
    private void m484a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f454o != null) {
            try {
                this.f454o.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
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

    /* renamed from: a */
    static boolean m485a(View view, Animation animation) {
        return ViewCompat.getLayerType(view) == 0 && ViewCompat.hasOverlappingRendering(view) && m486a(animation);
    }

    /* renamed from: a */
    static boolean m486a(Animation animation) {
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

    /* renamed from: b */
    private void m487b(View view, Animation animation) {
        if (view != null && animation != null && m485a(view, animation)) {
            animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animation));
        }
    }

    /* renamed from: f */
    private void m488f() {
        if (this.f458s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f460u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f460u);
        }
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                return 8194;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            case 8194:
                return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
            default:
                return 0;
        }
    }

    public static int transitToStyleIndex(int i, boolean z) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                return z ? 1 : 2;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Animation mo727a(Fragment fragment, int i, boolean z, int i2) {
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.f375Q);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.f375Q != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.f454o.mo696b(), fragment.f375Q)) != null) {
            return loadAnimation;
        }
        if (i == 0) {
            return null;
        }
        int transitToStyleIndex = transitToStyleIndex(i, z);
        if (transitToStyleIndex < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return m483a(this.f454o.mo696b(), 1.125f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 2:
                return m483a(this.f454o.mo696b(), 1.0f, 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 3:
                return m483a(this.f454o.mo696b(), 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 4:
                return m483a(this.f454o.mo696b(), 1.0f, 1.075f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 5:
                return m482a(this.f454o.mo696b(), BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 6:
                return m482a(this.f454o.mo696b(), 1.0f, BitmapDescriptorFactory.HUE_RED);
            default:
                if (i2 == 0 && this.f454o.onHasWindowAnimations()) {
                    i2 = this.f454o.onGetWindowAnimations();
                }
                return i2 == 0 ? null : null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo728a() {
        if (this.f445f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f445f.size()) {
                    Fragment fragment = this.f445f.get(i2);
                    if (fragment != null) {
                        performPendingDeferredStart(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo729a(int i, int i2, int i3, boolean z) {
        if (this.f454o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f453n != i) {
            this.f453n = i;
            if (this.f445f != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.f445f.size()) {
                    Fragment fragment = this.f445f.get(i4);
                    if (fragment != null) {
                        mo734a(fragment, i, i2, i3, false);
                        if (fragment.f381W != null) {
                            z2 |= fragment.f381W.hasRunningLoaders();
                        }
                    }
                    i4++;
                    z2 = z2;
                }
                if (!z2) {
                    mo728a();
                }
                if (this.f457r && this.f454o != null && this.f453n == 5) {
                    this.f454o.onSupportInvalidateOptionsMenu();
                    this.f457r = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo730a(int i, boolean z) {
        mo729a(i, 0, 0, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo731a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f479a != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Fragment fragment = list.get(i);
                        if (f439a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f479a[fragment.f399p];
                        fragmentState.f495k = fragment;
                        fragment.f398o = null;
                        fragment.f360B = 0;
                        fragment.f409z = false;
                        fragment.f405v = false;
                        fragment.f402s = null;
                        if (fragmentState.f494j != null) {
                            fragmentState.f494j.setClassLoader(this.f454o.mo696b().getClassLoader());
                            fragment.f398o = fragmentState.f494j.getSparseParcelableArray("android:view_state");
                            fragment.f397n = fragmentState.f494j;
                        }
                    }
                }
                this.f445f = new ArrayList<>(fragmentManagerState.f479a.length);
                if (this.f447h != null) {
                    this.f447h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.f479a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f479a[i2];
                    if (fragmentState2 != null) {
                        Fragment instantiate = fragmentState2.instantiate(this.f454o, this.f456q);
                        if (f439a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + instantiate);
                        }
                        this.f445f.add(instantiate);
                        fragmentState2.f495k = null;
                    } else {
                        this.f445f.add((Object) null);
                        if (this.f447h == null) {
                            this.f447h = new ArrayList<>();
                        }
                        if (f439a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f447h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        Fragment fragment2 = list.get(i3);
                        if (fragment2.f403t >= 0) {
                            if (fragment2.f403t < this.f445f.size()) {
                                fragment2.f402s = this.f445f.get(fragment2.f403t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.f403t);
                                fragment2.f402s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f480b != null) {
                    this.f446g = new ArrayList<>(fragmentManagerState.f480b.length);
                    for (int i4 = 0; i4 < fragmentManagerState.f480b.length; i4++) {
                        Fragment fragment3 = this.f445f.get(fragmentManagerState.f480b[i4]);
                        if (fragment3 == null) {
                            m484a((RuntimeException) new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f480b[i4]));
                        }
                        fragment3.f405v = true;
                        if (f439a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.f446g.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f446g.add(fragment3);
                    }
                } else {
                    this.f446g = null;
                }
                if (fragmentManagerState.f481c != null) {
                    this.f448i = new ArrayList<>(fragmentManagerState.f481c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.f481c.length; i5++) {
                        BackStackRecord instantiate2 = fragmentManagerState.f481c[i5].instantiate(this);
                        if (f439a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + instantiate2.f301p + "): " + instantiate2);
                            instantiate2.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                        }
                        this.f448i.add(instantiate2);
                        if (instantiate2.f301p >= 0) {
                            setBackStackIndex(instantiate2.f301p, instantiate2);
                        }
                    }
                    return;
                }
                this.f448i = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo732a(BackStackRecord backStackRecord) {
        if (this.f448i == null) {
            this.f448i = new ArrayList<>();
        }
        this.f448i.add(backStackRecord);
        mo740b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo733a(Fragment fragment) {
        mo734a(fragment, this.f453n, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0213, code lost:
        if (f439a == false) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0215, code lost:
        android.util.Log.v("FragmentManager", "moveto STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x022d, code lost:
        r11.mo506d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0230, code lost:
        if (r12 <= 4) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0234, code lost:
        if (f439a == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0236, code lost:
        android.util.Log.v("FragmentManager", "moveto RESUMED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x024e, code lost:
        r11.f407x = true;
        r11.mo509e();
        r11.f397n = null;
        r11.f398o = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0267, code lost:
        r11.f377S = android.support.p000v4.app.NoSaveStateFrameLayout.m549a(r11.f377S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0271, code lost:
        r11.f378T = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x027f, code lost:
        if (r12 >= 1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0283, code lost:
        if (r10.f459t == false) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0287, code lost:
        if (r11.f395l == null) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0289, code lost:
        r0 = r11.f395l;
        r11.f395l = null;
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0292, code lost:
        if (r11.f395l == null) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0294, code lost:
        r11.f396m = r12;
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02bd, code lost:
        if (r12 >= 4) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02c1, code lost:
        if (f439a == false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02c3, code lost:
        android.util.Log.v("FragmentManager", "movefrom STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02db, code lost:
        r11.mo540h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02de, code lost:
        if (r12 >= 3) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02e2, code lost:
        if (f439a == false) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02e4, code lost:
        android.util.Log.v("FragmentManager", "movefrom STOPPED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02fc, code lost:
        r11.mo543i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0300, code lost:
        if (r12 >= 2) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0304, code lost:
        if (f439a == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0306, code lost:
        android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0320, code lost:
        if (r11.f377S == null) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0328, code lost:
        if (r10.f454o.onShouldSaveFragmentState(r11) == false) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032c, code lost:
        if (r11.f398o != null) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x032e, code lost:
        mo745d(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0331, code lost:
        r11.mo552j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0336, code lost:
        if (r11.f377S == null) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x033a, code lost:
        if (r11.f376R == null) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x033e, code lost:
        if (r10.f453n <= 0) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0342, code lost:
        if (r10.f459t != false) goto L_0x03ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0344, code lost:
        r0 = mo727a(r11, r13, false, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0348, code lost:
        if (r0 == null) goto L_0x035f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x034a, code lost:
        r11.f395l = r11.f377S;
        r11.f396m = r12;
        r0.setAnimationListener(new android.support.p000v4.app.FragmentManagerImpl.C01025(r10, r11.f377S, r0));
        r11.f377S.startAnimation(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x035f, code lost:
        r11.f376R.removeView(r11.f377S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0366, code lost:
        r11.f376R = null;
        r11.f377S = null;
        r11.f378T = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0370, code lost:
        if (f439a == false) goto L_0x038a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0372, code lost:
        android.util.Log.v("FragmentManager", "movefrom CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x038c, code lost:
        if (r11.f371M != false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x038e, code lost:
        r11.mo553k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0391, code lost:
        r11.f374P = false;
        r11.onDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0398, code lost:
        if (r11.f374P != false) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b8, code lost:
        throw new android.support.p000v4.app.SuperNotCalledException("Fragment " + r11 + " did not call through to super.onDetach()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b9, code lost:
        if (r15 != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03bd, code lost:
        if (r11.f371M != false) goto L_0x03c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03bf, code lost:
        mo743c(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03c4, code lost:
        r11.f362D = null;
        r11.f364F = null;
        r11.f361C = null;
        r11.f363E = null;
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
        if (f439a == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0144, code lost:
        android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015e, code lost:
        if (r11.f408y != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0162, code lost:
        if (r11.f366H == 0) goto L_0x03d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0164, code lost:
        r0 = (android.view.ViewGroup) r10.f455p.onFindViewById(r11.f366H);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x016e, code lost:
        if (r0 != null) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0172, code lost:
        if (r11.f359A != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0174, code lost:
        m484a((java.lang.RuntimeException) new java.lang.IllegalArgumentException("No view found for id 0x" + java.lang.Integer.toHexString(r11.f366H) + " (" + r11.getResources().getResourceName(r11.f366H) + ") for fragment " + r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b3, code lost:
        r11.f376R = r0;
        r11.f377S = r11.mo492a(r11.getLayoutInflater(r11.f397n), r0, r11.f397n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c5, code lost:
        if (r11.f377S == null) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c7, code lost:
        r11.f378T = r11.f377S;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01cf, code lost:
        if (android.os.Build.VERSION.SDK_INT < 11) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d1, code lost:
        android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r11.f377S, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d6, code lost:
        if (r0 == null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d8, code lost:
        r1 = mo727a(r11, r13, true, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01dc, code lost:
        if (r1 == null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01de, code lost:
        m487b(r11.f377S, r1);
        r11.f377S.startAnimation(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e8, code lost:
        r0.addView(r11.f377S);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ef, code lost:
        if (r11.f368J == false) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01f1, code lost:
        r11.f377S.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f8, code lost:
        r11.onViewCreated(r11.f377S, r11.f397n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ff, code lost:
        r11.mo505c(r11.f397n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0206, code lost:
        if (r11.f377S == null) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0208, code lost:
        r11.mo495a(r11.f397n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
        r11.f397n = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x020f, code lost:
        if (r12 <= 3) goto L_0x0230;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo734a(final android.support.p000v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            r9 = 4
            r6 = 3
            r5 = 1
            r3 = 0
            r7 = 0
            boolean r0 = r11.f405v
            if (r0 == 0) goto L_0x000d
            boolean r0 = r11.f369K
            if (r0 == 0) goto L_0x0010
        L_0x000d:
            if (r12 <= r5) goto L_0x0010
            r12 = r5
        L_0x0010:
            boolean r0 = r11.f406w
            if (r0 == 0) goto L_0x001a
            int r0 = r11.f394k
            if (r12 <= r0) goto L_0x001a
            int r12 = r11.f394k
        L_0x001a:
            boolean r0 = r11.f379U
            if (r0 == 0) goto L_0x0025
            int r0 = r11.f394k
            if (r0 >= r9) goto L_0x0025
            if (r12 <= r6) goto L_0x0025
            r12 = r6
        L_0x0025:
            int r0 = r11.f394k
            if (r0 >= r12) goto L_0x0274
            boolean r0 = r11.f408y
            if (r0 == 0) goto L_0x0032
            boolean r0 = r11.f409z
            if (r0 != 0) goto L_0x0032
        L_0x0031:
            return
        L_0x0032:
            android.view.View r0 = r11.f395l
            if (r0 == 0) goto L_0x0040
            r11.f395l = r7
            int r2 = r11.f396m
            r0 = r10
            r1 = r11
            r4 = r3
            r0.mo734a((android.support.p000v4.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x0040:
            int r0 = r11.f394k
            switch(r0) {
                case 0: goto L_0x0048;
                case 1: goto L_0x013e;
                case 2: goto L_0x020f;
                case 3: goto L_0x020f;
                case 4: goto L_0x0230;
                default: goto L_0x0045;
            }
        L_0x0045:
            r11.f394k = r12
            goto L_0x0031
        L_0x0048:
            boolean r0 = f439a
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
            android.os.Bundle r0 = r11.f397n
            if (r0 == 0) goto L_0x00ac
            android.os.Bundle r0 = r11.f397n
            android.support.v4.app.FragmentHostCallback r1 = r10.f454o
            android.content.Context r1 = r1.mo696b()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r11.f397n
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r11.f398o = r0
            android.os.Bundle r0 = r11.f397n
            java.lang.String r1 = "android:target_state"
            android.support.v4.app.Fragment r0 = r10.getFragment(r0, r1)
            r11.f402s = r0
            android.support.v4.app.Fragment r0 = r11.f402s
            if (r0 == 0) goto L_0x0099
            android.os.Bundle r0 = r11.f397n
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r3)
            r11.f404u = r0
        L_0x0099:
            android.os.Bundle r0 = r11.f397n
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r5)
            r11.f380V = r0
            boolean r0 = r11.f380V
            if (r0 != 0) goto L_0x00ac
            r11.f379U = r5
            if (r12 <= r6) goto L_0x00ac
            r12 = r6
        L_0x00ac:
            android.support.v4.app.FragmentHostCallback r0 = r10.f454o
            r11.f362D = r0
            android.support.v4.app.Fragment r0 = r10.f456q
            r11.f364F = r0
            android.support.v4.app.Fragment r0 = r10.f456q
            if (r0 == 0) goto L_0x00ec
            android.support.v4.app.Fragment r0 = r10.f456q
            android.support.v4.app.FragmentManagerImpl r0 = r0.f363E
        L_0x00bc:
            r11.f361C = r0
            r11.f374P = r3
            android.support.v4.app.FragmentHostCallback r0 = r10.f454o
            android.content.Context r0 = r0.mo696b()
            r11.onAttach((android.content.Context) r0)
            boolean r0 = r11.f374P
            if (r0 != 0) goto L_0x00f3
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
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
            android.support.v4.app.FragmentHostCallback r0 = r10.f454o
            android.support.v4.app.FragmentManagerImpl r0 = r0.mo698d()
            goto L_0x00bc
        L_0x00f3:
            android.support.v4.app.Fragment r0 = r11.f364F
            if (r0 != 0) goto L_0x00fc
            android.support.v4.app.FragmentHostCallback r0 = r10.f454o
            r0.onAttachFragment(r11)
        L_0x00fc:
            boolean r0 = r11.f371M
            if (r0 != 0) goto L_0x0105
            android.os.Bundle r0 = r11.f397n
            r11.mo501b((android.os.Bundle) r0)
        L_0x0105:
            r11.f371M = r3
            boolean r0 = r11.f408y
            if (r0 == 0) goto L_0x013e
            android.os.Bundle r0 = r11.f397n
            android.view.LayoutInflater r0 = r11.getLayoutInflater(r0)
            android.os.Bundle r1 = r11.f397n
            android.view.View r0 = r11.mo492a(r0, r7, r1)
            r11.f377S = r0
            android.view.View r0 = r11.f377S
            if (r0 == 0) goto L_0x0263
            android.view.View r0 = r11.f377S
            r11.f378T = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x0259
            android.view.View r0 = r11.f377S
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r0, r3)
        L_0x012c:
            boolean r0 = r11.f368J
            if (r0 == 0) goto L_0x0137
            android.view.View r0 = r11.f377S
            r1 = 8
            r0.setVisibility(r1)
        L_0x0137:
            android.view.View r0 = r11.f377S
            android.os.Bundle r1 = r11.f397n
            r11.onViewCreated(r0, r1)
        L_0x013e:
            if (r12 <= r5) goto L_0x020f
            boolean r0 = f439a
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
            boolean r0 = r11.f408y
            if (r0 != 0) goto L_0x01ff
            int r0 = r11.f366H
            if (r0 == 0) goto L_0x03d1
            android.support.v4.app.FragmentContainer r0 = r10.f455p
            int r1 = r11.f366H
            android.view.View r0 = r0.onFindViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x01b3
            boolean r1 = r11.f359A
            if (r1 != 0) goto L_0x01b3
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "No view found for id 0x"
            java.lang.StringBuilder r2 = r2.append(r4)
            int r4 = r11.f366H
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " ("
            java.lang.StringBuilder r2 = r2.append(r4)
            android.content.res.Resources r4 = r11.getResources()
            int r8 = r11.f366H
            java.lang.String r4 = r4.getResourceName(r8)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ") for fragment "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r10.m484a((java.lang.RuntimeException) r1)
        L_0x01b3:
            r11.f376R = r0
            android.os.Bundle r1 = r11.f397n
            android.view.LayoutInflater r1 = r11.getLayoutInflater(r1)
            android.os.Bundle r2 = r11.f397n
            android.view.View r1 = r11.mo492a(r1, r0, r2)
            r11.f377S = r1
            android.view.View r1 = r11.f377S
            if (r1 == 0) goto L_0x0271
            android.view.View r1 = r11.f377S
            r11.f378T = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r1 < r2) goto L_0x0267
            android.view.View r1 = r11.f377S
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r1, r3)
        L_0x01d6:
            if (r0 == 0) goto L_0x01ed
            android.view.animation.Animation r1 = r10.mo727a((android.support.p000v4.app.Fragment) r11, (int) r13, (boolean) r5, (int) r14)
            if (r1 == 0) goto L_0x01e8
            android.view.View r2 = r11.f377S
            r10.m487b(r2, r1)
            android.view.View r2 = r11.f377S
            r2.startAnimation(r1)
        L_0x01e8:
            android.view.View r1 = r11.f377S
            r0.addView(r1)
        L_0x01ed:
            boolean r0 = r11.f368J
            if (r0 == 0) goto L_0x01f8
            android.view.View r0 = r11.f377S
            r1 = 8
            r0.setVisibility(r1)
        L_0x01f8:
            android.view.View r0 = r11.f377S
            android.os.Bundle r1 = r11.f397n
            r11.onViewCreated(r0, r1)
        L_0x01ff:
            android.os.Bundle r0 = r11.f397n
            r11.mo505c(r0)
            android.view.View r0 = r11.f377S
            if (r0 == 0) goto L_0x020d
            android.os.Bundle r0 = r11.f397n
            r11.mo495a((android.os.Bundle) r0)
        L_0x020d:
            r11.f397n = r7
        L_0x020f:
            if (r12 <= r6) goto L_0x0230
            boolean r0 = f439a
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
            r11.mo506d()
        L_0x0230:
            if (r12 <= r9) goto L_0x0045
            boolean r0 = f439a
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
            r11.f407x = r5
            r11.mo509e()
            r11.f397n = r7
            r11.f398o = r7
            goto L_0x0045
        L_0x0259:
            android.view.View r0 = r11.f377S
            android.view.ViewGroup r0 = android.support.p000v4.app.NoSaveStateFrameLayout.m549a(r0)
            r11.f377S = r0
            goto L_0x012c
        L_0x0263:
            r11.f378T = r7
            goto L_0x013e
        L_0x0267:
            android.view.View r1 = r11.f377S
            android.view.ViewGroup r1 = android.support.p000v4.app.NoSaveStateFrameLayout.m549a(r1)
            r11.f377S = r1
            goto L_0x01d6
        L_0x0271:
            r11.f378T = r7
            goto L_0x01ff
        L_0x0274:
            int r0 = r11.f394k
            if (r0 <= r12) goto L_0x0045
            int r0 = r11.f394k
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
            boolean r0 = r10.f459t
            if (r0 == 0) goto L_0x0290
            android.view.View r0 = r11.f395l
            if (r0 == 0) goto L_0x0290
            android.view.View r0 = r11.f395l
            r11.f395l = r7
            r0.clearAnimation()
        L_0x0290:
            android.view.View r0 = r11.f395l
            if (r0 == 0) goto L_0x036e
            r11.f396m = r12
            r12 = r5
            goto L_0x0045
        L_0x0299:
            r0 = 5
            if (r12 >= r0) goto L_0x02bd
            boolean r0 = f439a
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
            r11.mo512g()
            r11.f407x = r3
        L_0x02bd:
            if (r12 >= r9) goto L_0x02de
            boolean r0 = f439a
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
            r11.mo540h()
        L_0x02de:
            if (r12 >= r6) goto L_0x02ff
            boolean r0 = f439a
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
            r11.mo543i()
        L_0x02ff:
            r0 = 2
            if (r12 >= r0) goto L_0x027f
            boolean r0 = f439a
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
            android.view.View r0 = r11.f377S
            if (r0 == 0) goto L_0x0331
            android.support.v4.app.FragmentHostCallback r0 = r10.f454o
            boolean r0 = r0.onShouldSaveFragmentState(r11)
            if (r0 == 0) goto L_0x0331
            android.util.SparseArray<android.os.Parcelable> r0 = r11.f398o
            if (r0 != 0) goto L_0x0331
            r10.mo745d(r11)
        L_0x0331:
            r11.mo552j()
            android.view.View r0 = r11.f377S
            if (r0 == 0) goto L_0x0366
            android.view.ViewGroup r0 = r11.f376R
            if (r0 == 0) goto L_0x0366
            int r0 = r10.f453n
            if (r0 <= 0) goto L_0x03ce
            boolean r0 = r10.f459t
            if (r0 != 0) goto L_0x03ce
            android.view.animation.Animation r0 = r10.mo727a((android.support.p000v4.app.Fragment) r11, (int) r13, (boolean) r3, (int) r14)
        L_0x0348:
            if (r0 == 0) goto L_0x035f
            android.view.View r1 = r11.f377S
            r11.f395l = r1
            r11.f396m = r12
            android.view.View r1 = r11.f377S
            android.support.v4.app.FragmentManagerImpl$5 r2 = new android.support.v4.app.FragmentManagerImpl$5
            r2.<init>(r1, r0, r11)
            r0.setAnimationListener(r2)
            android.view.View r1 = r11.f377S
            r1.startAnimation(r0)
        L_0x035f:
            android.view.ViewGroup r0 = r11.f376R
            android.view.View r1 = r11.f377S
            r0.removeView(r1)
        L_0x0366:
            r11.f376R = r7
            r11.f377S = r7
            r11.f378T = r7
            goto L_0x027f
        L_0x036e:
            boolean r0 = f439a
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
            boolean r0 = r11.f371M
            if (r0 != 0) goto L_0x0391
            r11.mo553k()
        L_0x0391:
            r11.f374P = r3
            r11.onDetach()
            boolean r0 = r11.f374P
            if (r0 != 0) goto L_0x03b9
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
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
            boolean r0 = r11.f371M
            if (r0 != 0) goto L_0x03c4
            r10.mo743c(r11)
            goto L_0x0045
        L_0x03c4:
            r11.f362D = r7
            r11.f364F = r7
            r11.f361C = r7
            r11.f363E = r7
            goto L_0x0045
        L_0x03ce:
            r0 = r7
            goto L_0x0348
        L_0x03d1:
            r0 = r7
            goto L_0x01b3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.mo734a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo735a(Handler handler, String str, int i, int i2) {
        int i3;
        if (this.f448i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f448i.size() - 1;
            if (size < 0) {
                return false;
            }
            BackStackRecord remove = this.f448i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            remove.calculateBackFragments(sparseArray, sparseArray2);
            remove.popFromBackStack(true, (BackStackRecord.TransitionState) null, sparseArray, sparseArray2);
            mo740b();
        } else {
            int i4 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f448i.size() - 1;
                while (i3 >= 0) {
                    BackStackRecord backStackRecord = this.f448i.get(i3);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.f301p)) {
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
                        BackStackRecord backStackRecord2 = this.f448i.get(i3);
                        if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.f301p)) {
                            break;
                        }
                        i3--;
                    }
                }
                i4 = i3;
            }
            if (i4 == this.f448i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.f448i.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f448i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (int i5 = 0; i5 <= size4; i5++) {
                ((BackStackRecord) arrayList.get(i5)).calculateBackFragments(sparseArray3, sparseArray4);
            }
            BackStackRecord.TransitionState transitionState = null;
            int i6 = 0;
            while (i6 <= size4) {
                if (f439a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i6));
                }
                i6++;
                transitionState = ((BackStackRecord) arrayList.get(i6)).popFromBackStack(i6 == size4, transitionState, sparseArray3, sparseArray4);
            }
            mo740b();
        }
        return true;
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (this.f446g == null) {
            this.f446g = new ArrayList<>();
        }
        if (f439a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        mo741b(fragment);
        if (fragment.f369K) {
            return;
        }
        if (this.f446g.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        this.f446g.add(fragment);
        fragment.f405v = true;
        fragment.f406w = false;
        if (fragment.f372N && fragment.f373O) {
            this.f457r = true;
        }
        if (z) {
            mo733a(fragment);
        }
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f452m == null) {
            this.f452m = new ArrayList<>();
        }
        this.f452m.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        int i;
        synchronized (this) {
            if (this.f451l == null || this.f451l.size() <= 0) {
                if (this.f450k == null) {
                    this.f450k = new ArrayList<>();
                }
                i = this.f450k.size();
                if (f439a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f450k.add(backStackRecord);
            } else {
                i = this.f451l.remove(this.f451l.size() - 1).intValue();
                if (f439a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f450k.set(i, backStackRecord);
            }
        }
        return i;
    }

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f454o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f454o = fragmentHostCallback;
        this.f455p = fragmentContainer;
        this.f456q = fragment;
    }

    public void attachFragment(Fragment fragment, int i, int i2) {
        if (f439a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f369K) {
            fragment.f369K = false;
            if (!fragment.f405v) {
                if (this.f446g == null) {
                    this.f446g = new ArrayList<>();
                }
                if (this.f446g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f439a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f446g.add(fragment);
                fragment.f405v = true;
                if (fragment.f372N && fragment.f373O) {
                    this.f457r = true;
                }
                mo734a(fragment, this.f453n, i, i2, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo740b() {
        if (this.f452m != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f452m.size()) {
                    this.f452m.get(i2).onBackStackChanged();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo741b(Fragment fragment) {
        if (fragment.f399p < 0) {
            if (this.f447h == null || this.f447h.size() <= 0) {
                if (this.f445f == null) {
                    this.f445f = new ArrayList<>();
                }
                fragment.mo493a(this.f445f.size(), this.f456q);
                this.f445f.add(fragment);
            } else {
                fragment.mo493a(this.f447h.remove(this.f447h.size() - 1).intValue(), this.f456q);
                this.f445f.set(fragment.f399p, fragment);
            }
            if (f439a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ArrayList<Fragment> mo742c() {
        ArrayList<Fragment> arrayList = null;
        if (this.f445f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f445f.size()) {
                    break;
                }
                Fragment fragment = this.f445f.get(i2);
                if (fragment != null && fragment.f370L) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.f371M = true;
                    fragment.f403t = fragment.f402s != null ? fragment.f402s.f399p : -1;
                    if (f439a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo743c(Fragment fragment) {
        if (fragment.f399p >= 0) {
            if (f439a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f445f.set(fragment.f399p, (Object) null);
            if (this.f447h == null) {
                this.f447h = new ArrayList<>();
            }
            this.f447h.add(Integer.valueOf(fragment.f399p));
            this.f454o.mo693a(fragment.f400q);
            fragment.mo500b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Parcelable mo744d() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (f440b) {
            this.f458s = true;
        }
        if (this.f445f == null || this.f445f.size() <= 0) {
            return null;
        }
        int size3 = this.f445f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = this.f445f.get(i);
            if (fragment != null) {
                if (fragment.f399p < 0) {
                    m484a((RuntimeException) new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f399p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f394k <= 0 || fragmentState.f494j != null) {
                    fragmentState.f494j = fragment.f397n;
                } else {
                    fragmentState.f494j = mo763e(fragment);
                    if (fragment.f402s != null) {
                        if (fragment.f402s.f399p < 0) {
                            m484a((RuntimeException) new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f402s));
                        }
                        if (fragmentState.f494j == null) {
                            fragmentState.f494j = new Bundle();
                        }
                        putFragment(fragmentState.f494j, "android:target_state", fragment.f402s);
                        if (fragment.f404u != 0) {
                            fragmentState.f494j.putInt("android:target_req_state", fragment.f404u);
                        }
                    }
                }
                if (f439a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f494j);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (z2) {
            if (this.f446g == null || (size2 = this.f446g.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    iArr[i2] = this.f446g.get(i2).f399p;
                    if (iArr[i2] < 0) {
                        m484a((RuntimeException) new IllegalStateException("Failure saving state: active " + this.f446g.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (f439a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f446g.get(i2));
                    }
                }
            }
            if (this.f448i != null && (size = this.f448i.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i3 = 0; i3 < size; i3++) {
                    backStackStateArr[i3] = new BackStackState(this.f448i.get(i3));
                    if (f439a) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f448i.get(i3));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f479a = fragmentStateArr;
            fragmentManagerState.f480b = iArr;
            fragmentManagerState.f481c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f439a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo745d(Fragment fragment) {
        if (fragment.f378T != null) {
            if (this.f463x == null) {
                this.f463x = new SparseArray<>();
            } else {
                this.f463x.clear();
            }
            fragment.f378T.saveHierarchyState(this.f463x);
            if (this.f463x.size() > 0) {
                fragment.f398o = this.f463x;
                this.f463x = null;
            }
        }
    }

    public void detachFragment(Fragment fragment, int i, int i2) {
        if (f439a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f369K) {
            fragment.f369K = true;
            if (fragment.f405v) {
                if (this.f446g != null) {
                    if (f439a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f446g.remove(fragment);
                }
                if (fragment.f372N && fragment.f373O) {
                    this.f457r = true;
                }
                fragment.f405v = false;
                mo734a(fragment, 1, i, i2, false);
            }
        }
    }

    public void dispatchActivityCreated() {
        this.f458s = false;
        mo730a(2, false);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.f446g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f446g.size()) {
                    Fragment fragment = this.f446g.get(i2);
                    if (fragment != null) {
                        fragment.mo494a(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.f446g == null) {
            return false;
        }
        for (int i = 0; i < this.f446g.size(); i++) {
            Fragment fragment = this.f446g.get(i);
            if (fragment != null && fragment.mo503b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.f458s = false;
        mo730a(1, false);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<Fragment> arrayList = null;
        if (this.f446g != null) {
            int i = 0;
            z = false;
            while (i < this.f446g.size()) {
                Fragment fragment = this.f446g.get(i);
                if (fragment != null && fragment.mo498a(menu, menuInflater)) {
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
        if (this.f449j != null) {
            for (int i2 = 0; i2 < this.f449j.size(); i2++) {
                Fragment fragment2 = this.f449j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f449j = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.f459t = true;
        execPendingActions();
        mo730a(0, false);
        this.f454o = null;
        this.f455p = null;
        this.f456q = null;
    }

    public void dispatchDestroyView() {
        mo730a(1, false);
    }

    public void dispatchLowMemory() {
        if (this.f446g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f446g.size()) {
                    Fragment fragment = this.f446g.get(i2);
                    if (fragment != null) {
                        fragment.mo511f();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.f446g == null) {
            return false;
        }
        for (int i = 0; i < this.f446g.size(); i++) {
            Fragment fragment = this.f446g.get(i);
            if (fragment != null && fragment.mo499a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.f446g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f446g.size()) {
                    Fragment fragment = this.f446g.get(i2);
                    if (fragment != null) {
                        fragment.mo502b(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dispatchPause() {
        mo730a(4, false);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.f446g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f446g.size(); i++) {
            Fragment fragment = this.f446g.get(i);
            if (fragment != null && fragment.mo497a(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchReallyStop() {
        mo730a(2, false);
    }

    public void dispatchResume() {
        this.f458s = false;
        mo730a(5, false);
    }

    public void dispatchStart() {
        this.f458s = false;
        mo730a(4, false);
    }

    public void dispatchStop() {
        this.f458s = true;
        mo730a(3, false);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f445f != null && (size6 = this.f445f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f445f.get(i);
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
        if (this.f446g != null && (size5 = this.f446g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f446g.get(i2).toString());
            }
        }
        if (this.f449j != null && (size4 = this.f449j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f449j.get(i3).toString());
            }
        }
        if (this.f448i != null && (size3 = this.f448i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.f448i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f450k != null && (size2 = this.f450k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(this.f450k.get(i5));
                }
            }
            if (this.f451l != null && this.f451l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f451l.toArray()));
            }
        }
        if (this.f442c != null && (size = this.f442c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(this.f442c.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f454o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f455p);
        if (this.f456q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f456q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f453n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f458s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f459t);
        if (this.f457r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f457r);
        }
        if (this.f460u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f460u);
        }
        if (this.f447h != null && this.f447h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f447h.toArray()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Bundle mo763e(Fragment fragment) {
        Bundle bundle;
        if (this.f462w == null) {
            this.f462w = new Bundle();
        }
        fragment.mo507d(this.f462w);
        if (!this.f462w.isEmpty()) {
            bundle = this.f462w;
            this.f462w = null;
        } else {
            bundle = null;
        }
        if (fragment.f377S != null) {
            mo745d(fragment);
        }
        if (fragment.f398o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f398o);
        }
        if (!fragment.f380V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f380V);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public LayoutInflaterFactory mo764e() {
        return this;
    }

    public void enqueueAction(Runnable runnable, boolean z) {
        if (!z) {
            m488f();
        }
        synchronized (this) {
            if (this.f459t || this.f454o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f442c == null) {
                this.f442c = new ArrayList<>();
            }
            this.f442c.add(runnable);
            if (this.f442c.size() == 1) {
                this.f454o.mo697c().removeCallbacks(this.f464y);
                this.f454o.mo697c().post(this.f464y);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        r6.f444e = true;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r1 >= r3) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r6.f443d[r1].run();
        r6.f443d[r1] = null;
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean execPendingActions() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.f444e
            if (r1 == 0) goto L_0x000e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.FragmentHostCallback r3 = r6.f454o
            android.os.Handler r3 = r3.mo697c()
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
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f442c     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x0034
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f442c     // Catch:{ all -> 0x009b }
            int r3 = r3.size()     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x005c
        L_0x0034:
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            boolean r0 = r6.f461v
            if (r0 == 0) goto L_0x00a9
            r3 = r2
            r4 = r2
        L_0x003b:
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f445f
            int r0 = r0.size()
            if (r3 >= r0) goto L_0x00a2
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f445f
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.p000v4.app.Fragment) r0
            if (r0 == 0) goto L_0x0058
            android.support.v4.app.LoaderManagerImpl r5 = r0.f381W
            if (r5 == 0) goto L_0x0058
            android.support.v4.app.LoaderManagerImpl r0 = r0.f381W
            boolean r0 = r0.hasRunningLoaders()
            r4 = r4 | r0
        L_0x0058:
            int r0 = r3 + 1
            r3 = r0
            goto L_0x003b
        L_0x005c:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f442c     // Catch:{ all -> 0x009b }
            int r3 = r1.size()     // Catch:{ all -> 0x009b }
            java.lang.Runnable[] r1 = r6.f443d     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x006b
            java.lang.Runnable[] r1 = r6.f443d     // Catch:{ all -> 0x009b }
            int r1 = r1.length     // Catch:{ all -> 0x009b }
            if (r1 >= r3) goto L_0x006f
        L_0x006b:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch:{ all -> 0x009b }
            r6.f443d = r1     // Catch:{ all -> 0x009b }
        L_0x006f:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f442c     // Catch:{ all -> 0x009b }
            java.lang.Runnable[] r4 = r6.f443d     // Catch:{ all -> 0x009b }
            r1.toArray(r4)     // Catch:{ all -> 0x009b }
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f442c     // Catch:{ all -> 0x009b }
            r1.clear()     // Catch:{ all -> 0x009b }
            android.support.v4.app.FragmentHostCallback r1 = r6.f454o     // Catch:{ all -> 0x009b }
            android.os.Handler r1 = r1.mo697c()     // Catch:{ all -> 0x009b }
            java.lang.Runnable r4 = r6.f464y     // Catch:{ all -> 0x009b }
            r1.removeCallbacks(r4)     // Catch:{ all -> 0x009b }
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            r6.f444e = r0
            r1 = r2
        L_0x008a:
            if (r1 >= r3) goto L_0x009e
            java.lang.Runnable[] r4 = r6.f443d
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.f443d
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L_0x008a
        L_0x009b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x009b }
            throw r0
        L_0x009e:
            r6.f444e = r2
            r1 = r0
            goto L_0x0027
        L_0x00a2:
            if (r4 != 0) goto L_0x00a9
            r6.f461v = r2
            r6.mo728a()
        L_0x00a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    public Fragment findFragmentById(int i) {
        if (this.f446g != null) {
            for (int size = this.f446g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f446g.get(size);
                if (fragment != null && fragment.f365G == i) {
                    return fragment;
                }
            }
        }
        if (this.f445f != null) {
            for (int size2 = this.f445f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f445f.get(size2);
                if (fragment2 != null && fragment2.f365G == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        if (!(this.f446g == null || str == null)) {
            for (int size = this.f446g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f446g.get(size);
                if (fragment != null && str.equals(fragment.f367I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f445f == null || str == null)) {
            for (int size2 = this.f445f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f445f.get(size2);
                if (fragment2 != null && str.equals(fragment2.f367I)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        Fragment a;
        if (!(this.f445f == null || str == null)) {
            for (int size = this.f445f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f445f.get(size);
                if (fragment != null && (a = fragment.mo491a(str)) != null) {
                    return a;
                }
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.f450k.set(i, (Object) null);
            if (this.f451l == null) {
                this.f451l = new ArrayList<>();
            }
            if (f439a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f451l.add(Integer.valueOf(i));
        }
    }

    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.f448i.get(i);
    }

    public int getBackStackEntryCount() {
        if (this.f448i != null) {
            return this.f448i.size();
        }
        return 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f445f.size()) {
            m484a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f445f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m484a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public List<Fragment> getFragments() {
        return this.f445f;
    }

    public void hideFragment(Fragment fragment, int i, int i2) {
        if (f439a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f368J) {
            fragment.f368J = true;
            if (fragment.f377S != null) {
                Animation a = mo727a(fragment, i, false, i2);
                if (a != null) {
                    m487b(fragment.f377S, a);
                    fragment.f377S.startAnimation(a);
                }
                fragment.f377S.setVisibility(8);
            }
            if (fragment.f405v && fragment.f372N && fragment.f373O) {
                this.f457r = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public boolean isDestroyed() {
        return this.f459t;
    }

    public void noteStateNotSaved() {
        this.f458s = false;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.Fragment);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m433a(this.f454o.mo696b(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string2 != null) {
            findFragmentById = findFragmentByTag(string2);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (f439a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.f408y = true;
            instantiate.f365G = resourceId != 0 ? resourceId : id;
            instantiate.f366H = id;
            instantiate.f367I = string2;
            instantiate.f409z = true;
            instantiate.f361C = this;
            instantiate.f362D = this.f454o;
            instantiate.onInflate(this.f454o.mo696b(), attributeSet, instantiate.f397n);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.f409z) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            findFragmentById.f409z = true;
            if (!findFragmentById.f371M) {
                findFragmentById.onInflate(this.f454o.mo696b(), attributeSet, findFragmentById.f397n);
            }
            fragment = findFragmentById;
        }
        if (this.f453n >= 1 || !fragment.f408y) {
            mo733a(fragment);
        } else {
            mo734a(fragment, 1, 0, 0, false);
        }
        if (fragment.f377S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f377S.setId(resourceId);
        }
        if (fragment.f377S.getTag() == null) {
            fragment.f377S.setTag(string2);
        }
        return fragment.f377S;
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.f379U) {
            return;
        }
        if (this.f444e) {
            this.f461v = true;
            return;
        }
        fragment.f379U = false;
        mo734a(fragment, this.f453n, 0, 0, false);
    }

    public void popBackStack() {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.mo735a(FragmentManagerImpl.this.f454o.mo697c(), (String) null, -1, 0);
            }
        }, false);
    }

    public void popBackStack(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.mo735a(FragmentManagerImpl.this.f454o.mo697c(), (String) null, i, i2);
            }
        }, false);
    }

    public void popBackStack(final String str, final int i) {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.mo735a(FragmentManagerImpl.this.f454o.mo697c(), str, -1, i);
            }
        }, false);
    }

    public boolean popBackStackImmediate() {
        m488f();
        executePendingTransactions();
        return mo735a(this.f454o.mo697c(), (String) null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        m488f();
        executePendingTransactions();
        if (i >= 0) {
            return mo735a(this.f454o.mo697c(), (String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(String str, int i) {
        m488f();
        executePendingTransactions();
        return mo735a(this.f454o.mo697c(), str, -1, i);
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f399p < 0) {
            m484a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f399p);
    }

    public void removeFragment(Fragment fragment, int i, int i2) {
        if (f439a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f360B);
        }
        boolean z = !fragment.mo496a();
        if (!fragment.f369K || z) {
            if (this.f446g != null) {
                this.f446g.remove(fragment);
            }
            if (fragment.f372N && fragment.f373O) {
                this.f457r = true;
            }
            fragment.f405v = false;
            fragment.f406w = true;
            mo734a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f452m != null) {
            this.f452m.remove(onBackStackChangedListener);
        }
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle e;
        if (fragment.f399p < 0) {
            m484a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f394k <= 0 || (e = mo763e(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(e);
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f450k == null) {
                this.f450k = new ArrayList<>();
            }
            int size = this.f450k.size();
            if (i < size) {
                if (f439a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f450k.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f450k.add((Object) null);
                    if (this.f451l == null) {
                        this.f451l = new ArrayList<>();
                    }
                    if (f439a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f451l.add(Integer.valueOf(size));
                    size++;
                }
                if (f439a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f450k.add(backStackRecord);
            }
        }
    }

    public void showFragment(Fragment fragment, int i, int i2) {
        if (f439a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f368J) {
            fragment.f368J = false;
            if (fragment.f377S != null) {
                Animation a = mo727a(fragment, i, true, i2);
                if (a != null) {
                    m487b(fragment.f377S, a);
                    fragment.f377S.startAnimation(a);
                }
                fragment.f377S.setVisibility(0);
            }
            if (fragment.f405v && fragment.f372N && fragment.f373O) {
                this.f457r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f456q != null) {
            DebugUtils.buildShortClassTag(this.f456q, sb);
        } else {
            DebugUtils.buildShortClassTag(this.f454o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
