package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.iw */
public final class C1348iw extends Drawable implements Drawable.Callback {

    /* renamed from: KE */
    private boolean f4063KE;

    /* renamed from: KK */
    private int f4064KK;

    /* renamed from: KL */
    private long f4065KL;

    /* renamed from: KM */
    private int f4066KM;

    /* renamed from: KN */
    private int f4067KN;

    /* renamed from: KO */
    private int f4068KO;

    /* renamed from: KP */
    private int f4069KP;

    /* renamed from: KQ */
    private boolean f4070KQ;

    /* renamed from: KR */
    private C1352b f4071KR;

    /* renamed from: KS */
    private Drawable f4072KS;

    /* renamed from: KT */
    private Drawable f4073KT;

    /* renamed from: KU */
    private boolean f4074KU;

    /* renamed from: KV */
    private boolean f4075KV;

    /* renamed from: KW */
    private boolean f4076KW;

    /* renamed from: KX */
    private int f4077KX;
    private int mFrom;

    /* renamed from: com.google.android.gms.internal.iw$a */
    private static final class C1350a extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: KY */
        public static final C1350a f4078KY = new C1350a();

        /* renamed from: KZ */
        private static final C1351a f4079KZ = new C1351a();

        /* renamed from: com.google.android.gms.internal.iw$a$a */
        private static final class C1351a extends Drawable.ConstantState {
            private C1351a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C1350a.f4078KY;
            }
        }

        private C1350a() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return f4079KZ;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.iw$b */
    static final class C1352b extends Drawable.ConstantState {

        /* renamed from: La */
        int f4080La;

        /* renamed from: Lb */
        int f4081Lb;

        C1352b(C1352b bVar) {
            if (bVar != null) {
                this.f4080La = bVar.f4080La;
                this.f4081Lb = bVar.f4081Lb;
            }
        }

        public int getChangingConfigurations() {
            return this.f4080La;
        }

        public Drawable newDrawable() {
            return new C1348iw(this);
        }
    }

    public C1348iw(Drawable drawable, Drawable drawable2) {
        this((C1352b) null);
        drawable = drawable == null ? C1350a.f4078KY : drawable;
        this.f4072KS = drawable;
        drawable.setCallback(this);
        this.f4071KR.f4081Lb |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? C1350a.f4078KY : drawable2;
        this.f4073KT = drawable2;
        drawable2.setCallback(this);
        this.f4071KR.f4081Lb |= drawable2.getChangingConfigurations();
    }

    C1348iw(C1352b bVar) {
        this.f4064KK = 0;
        this.f4067KN = MotionEventCompat.ACTION_MASK;
        this.f4069KP = 0;
        this.f4063KE = true;
        this.f4071KR = new C1352b(bVar);
    }

    public boolean canConstantState() {
        if (!this.f4074KU) {
            this.f4075KV = (this.f4072KS.getConstantState() == null || this.f4073KT.getConstantState() == null) ? false : true;
            this.f4074KU = true;
        }
        return this.f4075KV;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f4064KK) {
            case 1:
                this.f4065KL = SystemClock.uptimeMillis();
                this.f4064KK = 2;
                break;
            case 2:
                if (this.f4065KL >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f4065KL)) / ((float) this.f4068KO);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f4064KK = 0;
                    }
                    this.f4069KP = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f4066KM - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f4069KP;
        boolean z3 = this.f4063KE;
        Drawable drawable = this.f4072KS;
        Drawable drawable2 = this.f4073KT;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f4067KN) {
                drawable2.setAlpha(this.f4067KN);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f4067KN - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f4067KN);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f4067KN);
        }
        invalidateSelf();
    }

    /* renamed from: gL */
    public Drawable mo8941gL() {
        return this.f4073KT;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f4071KR.f4080La | this.f4071KR.f4081Lb;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f4071KR.f4080La = getChangingConfigurations();
        return this.f4071KR;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f4072KS.getIntrinsicHeight(), this.f4073KT.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f4072KS.getIntrinsicWidth(), this.f4073KT.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f4076KW) {
            this.f4077KX = Drawable.resolveOpacity(this.f4072KS.getOpacity(), this.f4073KT.getOpacity());
            this.f4076KW = true;
        }
        return this.f4077KX;
    }

    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback;
        if (C1394kc.m5238hB() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f4070KQ && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f4072KS.mutate();
            this.f4073KT.mutate();
            this.f4070KQ = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f4072KS.setBounds(bounds);
        this.f4073KT.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback;
        if (C1394kc.m5238hB() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void setAlpha(int alpha) {
        if (this.f4069KP == this.f4067KN) {
            this.f4069KP = alpha;
        }
        this.f4067KN = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.f4072KS.setColorFilter(cf);
        this.f4073KT.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.f4066KM = this.f4067KN;
        this.f4069KP = 0;
        this.f4068KO = durationMillis;
        this.f4064KK = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback;
        if (C1394kc.m5238hB() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, what);
        }
    }
}
