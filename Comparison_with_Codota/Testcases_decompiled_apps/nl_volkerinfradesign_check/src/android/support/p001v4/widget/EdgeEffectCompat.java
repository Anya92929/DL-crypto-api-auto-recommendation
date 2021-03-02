package android.support.p001v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

/* renamed from: android.support.v4.widget.EdgeEffectCompat */
public class EdgeEffectCompat {

    /* renamed from: b */
    private static final C0411c f1193b;

    /* renamed from: a */
    private Object f1194a;

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$c */
    interface C0411c {
        /* renamed from: a */
        Object mo2751a(Context context);

        /* renamed from: a */
        void mo2752a(Object obj, int i, int i2);

        /* renamed from: a */
        boolean mo2753a(Object obj);

        /* renamed from: a */
        boolean mo2754a(Object obj, float f);

        /* renamed from: a */
        boolean mo2755a(Object obj, float f, float f2);

        /* renamed from: a */
        boolean mo2756a(Object obj, int i);

        /* renamed from: a */
        boolean mo2757a(Object obj, Canvas canvas);

        /* renamed from: b */
        void mo2758b(Object obj);

        /* renamed from: c */
        boolean mo2759c(Object obj);
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1193b = new C0412d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1193b = new C0410b();
        } else {
            f1193b = new C0409a();
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$a */
    static class C0409a implements C0411c {
        C0409a() {
        }

        /* renamed from: a */
        public Object mo2751a(Context context) {
            return null;
        }

        /* renamed from: a */
        public void mo2752a(Object obj, int i, int i2) {
        }

        /* renamed from: a */
        public boolean mo2753a(Object obj) {
            return true;
        }

        /* renamed from: b */
        public void mo2758b(Object obj) {
        }

        /* renamed from: a */
        public boolean mo2754a(Object obj, float f) {
            return false;
        }

        /* renamed from: c */
        public boolean mo2759c(Object obj) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2756a(Object obj, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2757a(Object obj, Canvas canvas) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2755a(Object obj, float f, float f2) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$b */
    static class C0410b implements C0411c {
        C0410b() {
        }

        /* renamed from: a */
        public Object mo2751a(Context context) {
            return C1118fi.m5056a(context);
        }

        /* renamed from: a */
        public void mo2752a(Object obj, int i, int i2) {
            C1118fi.m5057a(obj, i, i2);
        }

        /* renamed from: a */
        public boolean mo2753a(Object obj) {
            return C1118fi.m5058a(obj);
        }

        /* renamed from: b */
        public void mo2758b(Object obj) {
            C1118fi.m5062b(obj);
        }

        /* renamed from: a */
        public boolean mo2754a(Object obj, float f) {
            return C1118fi.m5059a(obj, f);
        }

        /* renamed from: c */
        public boolean mo2759c(Object obj) {
            return C1118fi.m5063c(obj);
        }

        /* renamed from: a */
        public boolean mo2756a(Object obj, int i) {
            return C1118fi.m5060a(obj, i);
        }

        /* renamed from: a */
        public boolean mo2757a(Object obj, Canvas canvas) {
            return C1118fi.m5061a(obj, canvas);
        }

        /* renamed from: a */
        public boolean mo2755a(Object obj, float f, float f2) {
            return C1118fi.m5059a(obj, f);
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$d */
    static class C0412d extends C0410b {
        C0412d() {
        }

        /* renamed from: a */
        public boolean mo2755a(Object obj, float f, float f2) {
            return C1119fj.m5064a(obj, f, f2);
        }
    }

    public EdgeEffectCompat(Context context) {
        this.f1194a = f1193b.mo2751a(context);
    }

    public void setSize(int i, int i2) {
        f1193b.mo2752a(this.f1194a, i, i2);
    }

    public boolean isFinished() {
        return f1193b.mo2753a(this.f1194a);
    }

    public void finish() {
        f1193b.mo2758b(this.f1194a);
    }

    public boolean onPull(float f) {
        return f1193b.mo2754a(this.f1194a, f);
    }

    public boolean onPull(float f, float f2) {
        return f1193b.mo2755a(this.f1194a, f, f2);
    }

    public boolean onRelease() {
        return f1193b.mo2759c(this.f1194a);
    }

    public boolean onAbsorb(int i) {
        return f1193b.mo2756a(this.f1194a, i);
    }

    public boolean draw(Canvas canvas) {
        return f1193b.mo2757a(this.f1194a, canvas);
    }
}
