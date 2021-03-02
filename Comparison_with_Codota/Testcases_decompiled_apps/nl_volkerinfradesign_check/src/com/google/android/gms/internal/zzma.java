package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zzma extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private int f3188a;

    /* renamed from: b */
    private long f3189b;

    /* renamed from: c */
    private int f3190c;

    /* renamed from: d */
    private int f3191d;

    /* renamed from: e */
    private int f3192e;

    /* renamed from: f */
    private int f3193f;

    /* renamed from: g */
    private int f3194g;

    /* renamed from: h */
    private boolean f3195h;

    /* renamed from: i */
    private boolean f3196i;

    /* renamed from: j */
    private C0785b f3197j;

    /* renamed from: k */
    private Drawable f3198k;

    /* renamed from: l */
    private Drawable f3199l;

    /* renamed from: m */
    private boolean f3200m;

    /* renamed from: n */
    private boolean f3201n;

    /* renamed from: o */
    private boolean f3202o;

    /* renamed from: p */
    private int f3203p;

    /* renamed from: com.google.android.gms.internal.zzma$a */
    static final class C0783a extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C0783a f3204a = new C0783a();

        /* renamed from: b */
        private static final C0784a f3205b = new C0784a();

        /* renamed from: com.google.android.gms.internal.zzma$a$a */
        static final class C0784a extends Drawable.ConstantState {
            private C0784a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0783a.f3204a;
            }
        }

        private C0783a() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return f3205b;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzma$b */
    static final class C0785b extends Drawable.ConstantState {

        /* renamed from: a */
        int f3206a;

        /* renamed from: b */
        int f3207b;

        C0785b(C0785b bVar) {
            if (bVar != null) {
                this.f3206a = bVar.f3206a;
                this.f3207b = bVar.f3207b;
            }
        }

        public int getChangingConfigurations() {
            return this.f3206a;
        }

        public Drawable newDrawable() {
            return new zzma(this);
        }
    }

    public zzma(Drawable drawable, Drawable drawable2) {
        this((C0785b) null);
        drawable = drawable == null ? C0783a.f3204a : drawable;
        this.f3198k = drawable;
        drawable.setCallback(this);
        this.f3197j.f3207b |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? C0783a.f3204a : drawable2;
        this.f3199l = drawable2;
        drawable2.setCallback(this);
        this.f3197j.f3207b |= drawable2.getChangingConfigurations();
    }

    zzma(C0785b bVar) {
        this.f3188a = 0;
        this.f3192e = 255;
        this.f3194g = 0;
        this.f3195h = true;
        this.f3197j = new C0785b(bVar);
    }

    public boolean canConstantState() {
        if (!this.f3200m) {
            this.f3201n = (this.f3198k.getConstantState() == null || this.f3199l.getConstantState() == null) ? false : true;
            this.f3200m = true;
        }
        return this.f3201n;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f3188a) {
            case 1:
                this.f3189b = SystemClock.uptimeMillis();
                this.f3188a = 2;
                break;
            case 2:
                if (this.f3189b >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3189b)) / ((float) this.f3193f);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f3188a = 0;
                    }
                    this.f3194g = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f3191d - this.f3190c))) + ((float) this.f3190c));
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f3194g;
        boolean z3 = this.f3195h;
        Drawable drawable = this.f3198k;
        Drawable drawable2 = this.f3199l;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f3192e) {
                drawable2.setAlpha(this.f3192e);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f3192e - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f3192e);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f3192e);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3197j.f3206a | this.f3197j.f3207b;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f3197j.f3206a = getChangingConfigurations();
        return this.f3197j;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f3198k.getIntrinsicHeight(), this.f3199l.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f3198k.getIntrinsicWidth(), this.f3199l.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f3202o) {
            this.f3203p = Drawable.resolveOpacity(this.f3198k.getOpacity(), this.f3199l.getOpacity());
            this.f3202o = true;
        }
        return this.f3203p;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f3196i && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f3198k.mutate();
            this.f3199l.mutate();
            this.f3196i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f3198k.setBounds(rect);
        this.f3199l.setBounds(rect);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.f3194g == this.f3192e) {
            this.f3194g = i;
        }
        this.f3192e = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3198k.setColorFilter(colorFilter);
        this.f3199l.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.f3190c = 0;
        this.f3191d = this.f3192e;
        this.f3194g = 0;
        this.f3193f = i;
        this.f3188a = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Drawable zzqn() {
        return this.f3199l;
    }
}
