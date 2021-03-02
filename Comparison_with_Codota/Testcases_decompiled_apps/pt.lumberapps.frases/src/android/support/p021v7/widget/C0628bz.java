package android.support.p021v7.widget;

import android.os.SystemClock;
import android.support.p009v4.view.C0223ba;
import android.support.p021v7.view.menu.C0544ak;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.widget.bz */
public abstract class C0628bz implements View.OnTouchListener {

    /* renamed from: a */
    private final float f1492a;

    /* renamed from: b */
    private final int f1493b;

    /* renamed from: c */
    private final int f1494c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f1495d;

    /* renamed from: e */
    private Runnable f1496e;

    /* renamed from: f */
    private Runnable f1497f;

    /* renamed from: g */
    private boolean f1498g;

    /* renamed from: h */
    private int f1499h;

    /* renamed from: i */
    private final int[] f1500i = new int[2];

    public C0628bz(View view) {
        this.f1495d = view;
        this.f1492a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1493b = ViewConfiguration.getTapTimeout();
        this.f1494c = (this.f1493b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: a */
    private boolean m2864a(MotionEvent motionEvent) {
        View view = this.f1495d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (C0223ba.m828a(motionEvent)) {
            case 0:
                this.f1499h = motionEvent.getPointerId(0);
                if (this.f1496e == null) {
                    this.f1496e = new C0631cb(this);
                }
                view.postDelayed(this.f1496e, (long) this.f1493b);
                if (this.f1497f == null) {
                    this.f1497f = new C0632cc(this);
                }
                view.postDelayed(this.f1497f, (long) this.f1494c);
                return false;
            case 1:
            case 3:
                mo3193d();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1499h);
                if (findPointerIndex < 0 || m2865a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1492a)) {
                    return false;
                }
                mo3193d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private static boolean m2865a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: a */
    private boolean m2866a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1500i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    /* renamed from: b */
    private boolean m2868b(MotionEvent motionEvent) {
        C0625bw bwVar;
        View view = this.f1495d;
        C0544ak a = mo2397a();
        if (a == null || !a.mo2364d() || (bwVar = (C0625bw) a.mo2365e()) == null || !bwVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m2869b(view, obtainNoHistory);
        m2866a(bwVar, obtainNoHistory);
        boolean a2 = bwVar.mo3115a(obtainNoHistory, this.f1499h);
        obtainNoHistory.recycle();
        int a3 = C0223ba.m828a(motionEvent);
        return a2 && (a3 != 1 && a3 != 3);
    }

    /* renamed from: b */
    private boolean m2869b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1500i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    /* renamed from: d */
    private void mo3193d() {
        if (this.f1497f != null) {
            this.f1495d.removeCallbacks(this.f1497f);
        }
        if (this.f1496e != null) {
            this.f1495d.removeCallbacks(this.f1496e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2871e() {
        mo3193d();
        View view = this.f1495d;
        if (view.isEnabled() && !view.isLongClickable() && mo2398b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1498g = true;
        }
    }

    /* renamed from: a */
    public abstract C0544ak mo2397a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo2398b() {
        C0544ak a = mo2397a();
        if (a == null || a.mo2364d()) {
            return true;
        }
        a.mo2362a();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3121c() {
        C0544ak a = mo2397a();
        if (a == null || !a.mo2364d()) {
            return true;
        }
        a.mo2363c();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1498g;
        if (z2) {
            z = m2868b(motionEvent) || !mo3121c();
        } else {
            boolean z3 = m2864a(motionEvent) && mo2398b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1495d.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.f1498g = z;
        return z || z2;
    }
}
