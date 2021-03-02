package android.support.p004v7.view;

import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.support.p001v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.ViewPropertyAnimatorCompatSet */
public class ViewPropertyAnimatorCompatSet {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ArrayList<ViewPropertyAnimatorCompat> f1683a = new ArrayList<>();

    /* renamed from: b */
    private long f1684b = -1;

    /* renamed from: c */
    private Interpolator f1685c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewPropertyAnimatorListener f1686d;

    /* renamed from: e */
    private boolean f1687e;

    /* renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f1688f = new ViewPropertyAnimatorListenerAdapter() {

        /* renamed from: b */
        private boolean f1690b = false;

        /* renamed from: c */
        private int f1691c = 0;

        public void onAnimationStart(View view) {
            if (!this.f1690b) {
                this.f1690b = true;
                if (ViewPropertyAnimatorCompatSet.this.f1686d != null) {
                    ViewPropertyAnimatorCompatSet.this.f1686d.onAnimationStart((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3535a() {
            this.f1691c = 0;
            this.f1690b = false;
            ViewPropertyAnimatorCompatSet.this.m3016a();
        }

        public void onAnimationEnd(View view) {
            int i = this.f1691c + 1;
            this.f1691c = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f1683a.size()) {
                if (ViewPropertyAnimatorCompatSet.this.f1686d != null) {
                    ViewPropertyAnimatorCompatSet.this.f1686d.onAnimationEnd((View) null);
                }
                mo3535a();
            }
        }
    };

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f1687e) {
            this.f1683a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1683a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f1683a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public void start() {
        if (!this.f1687e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f1683a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                if (this.f1684b >= 0) {
                    next.setDuration(this.f1684b);
                }
                if (this.f1685c != null) {
                    next.setInterpolator(this.f1685c);
                }
                if (this.f1686d != null) {
                    next.setListener(this.f1688f);
                }
                next.start();
            }
            this.f1687e = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3016a() {
        this.f1687e = false;
    }

    public void cancel() {
        if (this.f1687e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f1683a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f1687e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.f1687e) {
            this.f1684b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f1687e) {
            this.f1685c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f1687e) {
            this.f1686d = viewPropertyAnimatorListener;
        }
        return this;
    }
}
