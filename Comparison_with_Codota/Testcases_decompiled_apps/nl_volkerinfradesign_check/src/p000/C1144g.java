package p000;

import android.support.p001v4.animation.AnimatorListenerCompat;
import android.support.p001v4.animation.AnimatorUpdateListenerCompat;
import android.support.p001v4.animation.ValueAnimatorCompat;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: g */
public class C1144g implements C1106f {
    /* renamed from: a */
    public ValueAnimatorCompat mo8099a() {
        return new C1145a();
    }

    /* renamed from: g$a */
    static class C1145a implements ValueAnimatorCompat {

        /* renamed from: a */
        List<AnimatorListenerCompat> f4121a = new ArrayList();

        /* renamed from: b */
        List<AnimatorUpdateListenerCompat> f4122b = new ArrayList();

        /* renamed from: c */
        View f4123c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long f4124d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public long f4125e = 200;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public float f4126f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        private boolean f4127g = false;

        /* renamed from: h */
        private boolean f4128h = false;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Runnable f4129i = new Runnable() {
            public void run() {
                float a = (((float) (C1145a.this.m5146b() - C1145a.this.f4124d)) * 1.0f) / ((float) C1145a.this.f4125e);
                if (a > 1.0f || C1145a.this.f4123c.getParent() == null) {
                    a = 1.0f;
                }
                float unused = C1145a.this.f4126f = a;
                C1145a.this.m5145a();
                if (C1145a.this.f4126f >= 1.0f) {
                    C1145a.this.m5150d();
                } else {
                    C1145a.this.f4123c.postDelayed(C1145a.this.f4129i, 16);
                }
            }
        };

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5145a() {
            for (int size = this.f4122b.size() - 1; size >= 0; size--) {
                this.f4122b.get(size).onAnimationUpdate(this);
            }
        }

        public void setTarget(View view) {
            this.f4123c = view;
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.f4121a.add(animatorListenerCompat);
        }

        public void setDuration(long j) {
            if (!this.f4127g) {
                this.f4125e = j;
            }
        }

        public void start() {
            if (!this.f4127g) {
                this.f4127g = true;
                m5149c();
                this.f4126f = BitmapDescriptorFactory.HUE_RED;
                this.f4124d = m5146b();
                this.f4123c.postDelayed(this.f4129i, 16);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m5146b() {
            return this.f4123c.getDrawingTime();
        }

        /* renamed from: c */
        private void m5149c() {
            for (int size = this.f4121a.size() - 1; size >= 0; size--) {
                this.f4121a.get(size).onAnimationStart(this);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m5150d() {
            for (int size = this.f4121a.size() - 1; size >= 0; size--) {
                this.f4121a.get(size).onAnimationEnd(this);
            }
        }

        /* renamed from: e */
        private void m5153e() {
            for (int size = this.f4121a.size() - 1; size >= 0; size--) {
                this.f4121a.get(size).onAnimationCancel(this);
            }
        }

        public void cancel() {
            if (!this.f4128h) {
                this.f4128h = true;
                if (this.f4127g) {
                    m5153e();
                }
                m5150d();
            }
        }

        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.f4122b.add(animatorUpdateListenerCompat);
        }

        public float getAnimatedFraction() {
            return this.f4126f;
        }
    }

    /* renamed from: a */
    public void mo8100a(View view) {
    }
}
