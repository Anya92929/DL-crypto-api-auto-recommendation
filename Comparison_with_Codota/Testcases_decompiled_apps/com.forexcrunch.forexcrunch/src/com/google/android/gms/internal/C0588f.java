package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.f */
public final class C0588f extends Drawable implements Drawable.Callback {

    /* renamed from: aP */
    private boolean f1361aP;

    /* renamed from: aR */
    private int f1362aR;

    /* renamed from: aS */
    private long f1363aS;

    /* renamed from: aT */
    private int f1364aT;

    /* renamed from: aU */
    private int f1365aU;

    /* renamed from: aV */
    private int f1366aV;

    /* renamed from: aW */
    private int f1367aW;

    /* renamed from: aX */
    private int f1368aX;

    /* renamed from: aY */
    private boolean f1369aY;

    /* renamed from: aZ */
    private C0592b f1370aZ;

    /* renamed from: ba */
    private Drawable f1371ba;

    /* renamed from: bb */
    private Drawable f1372bb;

    /* renamed from: bc */
    private boolean f1373bc;

    /* renamed from: bd */
    private boolean f1374bd;

    /* renamed from: be */
    private boolean f1375be;

    /* renamed from: bf */
    private int f1376bf;

    /* renamed from: com.google.android.gms.internal.f$a */
    private static final class C0590a extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: bg */
        public static final C0590a f1377bg = new C0590a();

        /* renamed from: bh */
        private static final C0591a f1378bh = new C0591a();

        /* renamed from: com.google.android.gms.internal.f$a$a */
        private static final class C0591a extends Drawable.ConstantState {
            private C0591a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0590a.f1377bg;
            }
        }

        private C0590a() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return f1378bh;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.f$b */
    static final class C0592b extends Drawable.ConstantState {

        /* renamed from: bi */
        int f1379bi;

        /* renamed from: bj */
        int f1380bj;

        C0592b(C0592b bVar) {
            if (bVar != null) {
                this.f1379bi = bVar.f1379bi;
                this.f1380bj = bVar.f1380bj;
            }
        }

        public int getChangingConfigurations() {
            return this.f1379bi;
        }

        public Drawable newDrawable() {
            return new C0588f(this);
        }
    }

    public C0588f(Drawable drawable, Drawable drawable2) {
        this((C0592b) null);
        drawable = drawable == null ? C0590a.f1377bg : drawable;
        this.f1371ba = drawable;
        drawable.setCallback(this);
        this.f1370aZ.f1380bj |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? C0590a.f1377bg : drawable2;
        this.f1372bb = drawable2;
        drawable2.setCallback(this);
        this.f1370aZ.f1380bj |= drawable2.getChangingConfigurations();
    }

    C0588f(C0592b bVar) {
        this.f1362aR = 0;
        this.f1366aV = MotionEventCompat.ACTION_MASK;
        this.f1368aX = 0;
        this.f1361aP = true;
        this.f1370aZ = new C0592b(bVar);
    }

    public boolean canConstantState() {
        if (!this.f1373bc) {
            this.f1374bd = (this.f1371ba.getConstantState() == null || this.f1372bb.getConstantState() == null) ? false : true;
            this.f1373bc = true;
        }
        return this.f1374bd;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f1362aR) {
            case 1:
                this.f1363aS = SystemClock.uptimeMillis();
                this.f1362aR = 2;
                break;
            case 2:
                if (this.f1363aS >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f1363aS)) / ((float) this.f1367aW);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f1362aR = 0;
                    }
                    this.f1368aX = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f1365aU - this.f1364aT))) + ((float) this.f1364aT));
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f1368aX;
        boolean z3 = this.f1361aP;
        Drawable drawable = this.f1371ba;
        Drawable drawable2 = this.f1372bb;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f1366aV) {
                drawable2.setAlpha(this.f1366aV);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f1366aV - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f1366aV);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f1366aV);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1370aZ.f1379bi | this.f1370aZ.f1380bj;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f1370aZ.f1379bi = getChangingConfigurations();
        return this.f1370aZ;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f1371ba.getIntrinsicHeight(), this.f1372bb.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f1371ba.getIntrinsicWidth(), this.f1372bb.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f1375be) {
            this.f1376bf = Drawable.resolveOpacity(this.f1371ba.getOpacity(), this.f1372bb.getOpacity());
            this.f1375be = true;
        }
        return this.f1376bf;
    }

    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback;
        if (C0427as.m909an() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f1369aY && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f1371ba.mutate();
            this.f1372bb.mutate();
            this.f1369aY = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1371ba.setBounds(bounds);
        this.f1372bb.setBounds(bounds);
    }

    /* renamed from: r */
    public Drawable mo5408r() {
        return this.f1372bb;
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback;
        if (C0427as.m909an() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void setAlpha(int alpha) {
        if (this.f1368aX == this.f1366aV) {
            this.f1368aX = alpha;
        }
        this.f1366aV = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.f1371ba.setColorFilter(cf);
        this.f1372bb.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.f1364aT = 0;
        this.f1365aU = this.f1366aV;
        this.f1368aX = 0;
        this.f1367aW = durationMillis;
        this.f1362aR = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback;
        if (C0427as.m909an() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, what);
        }
    }
}
