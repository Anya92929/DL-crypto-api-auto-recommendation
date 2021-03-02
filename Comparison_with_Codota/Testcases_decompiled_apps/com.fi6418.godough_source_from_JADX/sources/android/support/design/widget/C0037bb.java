package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.bb */
class C0037bb extends C0033ay {

    /* renamed from: a */
    private static final Handler f164a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private long f165b;

    /* renamed from: c */
    private boolean f166c;

    /* renamed from: d */
    private final int[] f167d = new int[2];

    /* renamed from: e */
    private final float[] f168e = new float[2];

    /* renamed from: f */
    private int f169f = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;

    /* renamed from: g */
    private Interpolator f170g;

    /* renamed from: h */
    private C0034az f171h;

    /* renamed from: i */
    private C0036ba f172i;

    /* renamed from: j */
    private float f173j;

    /* renamed from: k */
    private final Runnable f174k = new C0038bc(this);

    C0037bb() {
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m259f() {
        if (this.f166c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f165b)) / ((float) this.f169f);
            if (this.f170g != null) {
                uptimeMillis = this.f170g.getInterpolation(uptimeMillis);
            }
            this.f173j = uptimeMillis;
            if (this.f172i != null) {
                this.f172i.mo233a();
            }
            if (SystemClock.uptimeMillis() >= this.f165b + ((long) this.f169f)) {
                this.f166c = false;
                if (this.f171h != null) {
                    this.f171h.mo235b();
                }
            }
        }
        if (this.f166c) {
            f164a.postDelayed(this.f174k, 10);
        }
    }

    /* renamed from: a */
    public void mo239a() {
        if (!this.f166c) {
            if (this.f170g == null) {
                this.f170g = new AccelerateDecelerateInterpolator();
            }
            this.f165b = SystemClock.uptimeMillis();
            this.f166c = true;
            if (this.f171h != null) {
                this.f171h.mo234a();
            }
            f164a.postDelayed(this.f174k, 10);
        }
    }

    /* renamed from: a */
    public void mo240a(float f, float f2) {
        this.f168e[0] = f;
        this.f168e[1] = f2;
    }

    /* renamed from: a */
    public void mo241a(int i) {
        this.f169f = i;
    }

    /* renamed from: a */
    public void mo242a(int i, int i2) {
        this.f167d[0] = i;
        this.f167d[1] = i2;
    }

    /* renamed from: a */
    public void mo243a(C0034az azVar) {
        this.f171h = azVar;
    }

    /* renamed from: a */
    public void mo244a(C0036ba baVar) {
        this.f172i = baVar;
    }

    /* renamed from: a */
    public void mo245a(Interpolator interpolator) {
        this.f170g = interpolator;
    }

    /* renamed from: b */
    public boolean mo246b() {
        return this.f166c;
    }

    /* renamed from: c */
    public int mo247c() {
        return C0008a.m170a(this.f167d[0], this.f167d[1], mo249e());
    }

    /* renamed from: d */
    public void mo248d() {
        this.f166c = false;
        f164a.removeCallbacks(this.f174k);
        if (this.f171h != null) {
            this.f171h.mo236c();
        }
    }

    /* renamed from: e */
    public float mo249e() {
        return this.f173j;
    }
}
