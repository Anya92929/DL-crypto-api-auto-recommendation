package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.cz */
public final class C0377cz extends Drawable implements Drawable.Callback {

    /* renamed from: kb */
    private boolean f1066kb;

    /* renamed from: kd */
    private int f1067kd;

    /* renamed from: ke */
    private long f1068ke;

    /* renamed from: kf */
    private int f1069kf;

    /* renamed from: kg */
    private int f1070kg;

    /* renamed from: kh */
    private int f1071kh;

    /* renamed from: ki */
    private int f1072ki;

    /* renamed from: kj */
    private int f1073kj;

    /* renamed from: kk */
    private boolean f1074kk;

    /* renamed from: kl */
    private C0381b f1075kl;

    /* renamed from: km */
    private Drawable f1076km;

    /* renamed from: kn */
    private Drawable f1077kn;

    /* renamed from: ko */
    private boolean f1078ko;

    /* renamed from: kp */
    private boolean f1079kp;

    /* renamed from: kq */
    private boolean f1080kq;

    /* renamed from: kr */
    private int f1081kr;

    /* renamed from: com.google.android.gms.internal.cz$a */
    private static final class C0379a extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: ks */
        public static final C0379a f1082ks = new C0379a();

        /* renamed from: kt */
        private static final C0380a f1083kt = new C0380a();

        /* renamed from: com.google.android.gms.internal.cz$a$a */
        private static final class C0380a extends Drawable.ConstantState {
            private C0380a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0379a.f1082ks;
            }
        }

        private C0379a() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return f1083kt;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.cz$b */
    static final class C0381b extends Drawable.ConstantState {

        /* renamed from: ku */
        int f1084ku;

        /* renamed from: kv */
        int f1085kv;

        C0381b(C0381b bVar) {
            if (bVar != null) {
                this.f1084ku = bVar.f1084ku;
                this.f1085kv = bVar.f1085kv;
            }
        }

        public int getChangingConfigurations() {
            return this.f1084ku;
        }

        public Drawable newDrawable() {
            return new C0377cz(this);
        }
    }

    public C0377cz(Drawable drawable, Drawable drawable2) {
        this((C0381b) null);
        drawable = drawable == null ? C0379a.f1082ks : drawable;
        this.f1076km = drawable;
        drawable.setCallback(this);
        this.f1075kl.f1085kv |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? C0379a.f1082ks : drawable2;
        this.f1077kn = drawable2;
        drawable2.setCallback(this);
        this.f1075kl.f1085kv |= drawable2.getChangingConfigurations();
    }

    C0377cz(C0381b bVar) {
        this.f1067kd = 0;
        this.f1071kh = MotionEventCompat.ACTION_MASK;
        this.f1073kj = 0;
        this.f1066kb = true;
        this.f1075kl = new C0381b(bVar);
    }

    /* renamed from: aS */
    public Drawable mo4290aS() {
        return this.f1077kn;
    }

    public boolean canConstantState() {
        if (!this.f1078ko) {
            this.f1079kp = (this.f1076km.getConstantState() == null || this.f1077kn.getConstantState() == null) ? false : true;
            this.f1078ko = true;
        }
        return this.f1079kp;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f1067kd) {
            case 1:
                this.f1068ke = SystemClock.uptimeMillis();
                this.f1067kd = 2;
                break;
            case 2:
                if (this.f1068ke >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f1068ke)) / ((float) this.f1072ki);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f1067kd = 0;
                    }
                    this.f1073kj = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f1070kg - this.f1069kf))) + ((float) this.f1069kf));
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f1073kj;
        boolean z3 = this.f1066kb;
        Drawable drawable = this.f1076km;
        Drawable drawable2 = this.f1077kn;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f1071kh) {
                drawable2.setAlpha(this.f1071kh);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f1071kh - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f1071kh);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f1071kh);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1075kl.f1084ku | this.f1075kl.f1085kv;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f1075kl.f1084ku = getChangingConfigurations();
        return this.f1075kl;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f1076km.getIntrinsicHeight(), this.f1077kn.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f1076km.getIntrinsicWidth(), this.f1077kn.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f1080kq) {
            this.f1081kr = Drawable.resolveOpacity(this.f1076km.getOpacity(), this.f1077kn.getOpacity());
            this.f1080kq = true;
        }
        return this.f1081kr;
    }

    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback;
        if (C0441ek.m1086bJ() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f1074kk && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f1076km.mutate();
            this.f1077kn.mutate();
            this.f1074kk = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1076km.setBounds(bounds);
        this.f1077kn.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback;
        if (C0441ek.m1086bJ() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void setAlpha(int alpha) {
        if (this.f1073kj == this.f1071kh) {
            this.f1073kj = alpha;
        }
        this.f1071kh = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.f1076km.setColorFilter(cf);
        this.f1077kn.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.f1069kf = 0;
        this.f1070kg = this.f1071kh;
        this.f1073kj = 0;
        this.f1072ki = durationMillis;
        this.f1067kd = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback;
        if (C0441ek.m1086bJ() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, what);
        }
    }
}
