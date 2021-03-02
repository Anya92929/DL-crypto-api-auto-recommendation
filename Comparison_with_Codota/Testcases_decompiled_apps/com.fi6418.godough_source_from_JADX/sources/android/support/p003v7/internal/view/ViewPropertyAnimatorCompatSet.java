package android.support.p003v7.internal.view;

import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.internal.view.ViewPropertyAnimatorCompatSet */
public class ViewPropertyAnimatorCompatSet {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ArrayList<ViewPropertyAnimatorCompat> f2024a = new ArrayList<>();

    /* renamed from: b */
    private long f2025b = -1;

    /* renamed from: c */
    private Interpolator f2026c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewPropertyAnimatorListener f2027d;

    /* renamed from: e */
    private boolean f2028e;

    /* renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f2029f = new ViewPropertyAnimatorListenerAdapter() {

        /* renamed from: b */
        private boolean f2031b = false;

        /* renamed from: c */
        private int f2032c = 0;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3969a() {
            this.f2032c = 0;
            this.f2031b = false;
            ViewPropertyAnimatorCompatSet.this.m1388a();
        }

        public void onAnimationEnd(View view) {
            int i = this.f2032c + 1;
            this.f2032c = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f2024a.size()) {
                if (ViewPropertyAnimatorCompatSet.this.f2027d != null) {
                    ViewPropertyAnimatorCompatSet.this.f2027d.onAnimationEnd((View) null);
                }
                mo3969a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.f2031b) {
                this.f2031b = true;
                if (ViewPropertyAnimatorCompatSet.this.f2027d != null) {
                    ViewPropertyAnimatorCompatSet.this.f2027d.onAnimationStart((View) null);
                }
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1388a() {
        this.f2028e = false;
    }

    public void cancel() {
        if (this.f2028e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f2024a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f2028e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f2028e) {
            this.f2024a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f2024a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f2024a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.f2028e) {
            this.f2025b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f2028e) {
            this.f2026c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f2028e) {
            this.f2027d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (!this.f2028e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f2024a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                if (this.f2025b >= 0) {
                    next.setDuration(this.f2025b);
                }
                if (this.f2026c != null) {
                    next.setInterpolator(this.f2026c);
                }
                if (this.f2027d != null) {
                    next.setListener(this.f2029f);
                }
                next.start();
            }
            this.f2028e = true;
        }
    }
}
