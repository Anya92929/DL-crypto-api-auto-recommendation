package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzs;

public final class zzra extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private int f6946a;

    /* renamed from: b */
    private long f6947b;

    /* renamed from: c */
    private int f6948c;

    /* renamed from: d */
    private int f6949d;

    /* renamed from: e */
    private int f6950e;

    /* renamed from: f */
    private int f6951f;

    /* renamed from: g */
    private int f6952g;

    /* renamed from: h */
    private boolean f6953h;

    /* renamed from: i */
    private boolean f6954i;

    /* renamed from: j */
    private C1845qe f6955j;

    /* renamed from: k */
    private Drawable f6956k;

    /* renamed from: l */
    private Drawable f6957l;

    /* renamed from: m */
    private boolean f6958m;

    /* renamed from: n */
    private boolean f6959n;

    /* renamed from: o */
    private boolean f6960o;

    /* renamed from: p */
    private int f6961p;

    public zzra(Drawable drawable, Drawable drawable2) {
        this((C1845qe) null);
        drawable = drawable == null ? C1843qc.f5513a : drawable;
        this.f6956k = drawable;
        drawable.setCallback(this);
        this.f6955j.f5516b |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? C1843qc.f5513a : drawable2;
        this.f6957l = drawable2;
        drawable2.setCallback(this);
        this.f6955j.f5516b |= drawable2.getChangingConfigurations();
    }

    zzra(C1845qe qeVar) {
        this.f6946a = 0;
        this.f6950e = 255;
        this.f6952g = 0;
        this.f6953h = true;
        this.f6955j = new C1845qe(qeVar);
    }

    public boolean canConstantState() {
        if (!this.f6958m) {
            this.f6959n = (this.f6956k.getConstantState() == null || this.f6957l.getConstantState() == null) ? false : true;
            this.f6958m = true;
        }
        return this.f6959n;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f6946a) {
            case 1:
                this.f6947b = SystemClock.uptimeMillis();
                this.f6946a = 2;
                break;
            case 2:
                if (this.f6947b >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f6947b)) / ((float) this.f6951f);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f6946a = 0;
                    }
                    this.f6952g = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f6949d + 0))) + 0.0f);
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f6952g;
        boolean z3 = this.f6953h;
        Drawable drawable = this.f6956k;
        Drawable drawable2 = this.f6957l;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f6950e) {
                drawable2.setAlpha(this.f6950e);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f6950e - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f6950e);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f6950e);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f6955j.f5515a | this.f6955j.f5516b;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f6955j.f5515a = getChangingConfigurations();
        return this.f6955j;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f6956k.getIntrinsicHeight(), this.f6957l.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f6956k.getIntrinsicWidth(), this.f6957l.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f6960o) {
            this.f6961p = Drawable.resolveOpacity(this.f6956k.getOpacity(), this.f6957l.getOpacity());
            this.f6960o = true;
        }
        return this.f6961p;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (zzs.zzavn() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f6954i && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f6956k.mutate();
            this.f6957l.mutate();
            this.f6954i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f6956k.setBounds(rect);
        this.f6957l.setBounds(rect);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (zzs.zzavn() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.f6952g == this.f6950e) {
            this.f6952g = i;
        }
        this.f6950e = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6956k.setColorFilter(colorFilter);
        this.f6957l.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.f6948c = 0;
        this.f6949d = this.f6950e;
        this.f6952g = 0;
        this.f6951f = i;
        this.f6946a = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (zzs.zzavn() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Drawable zzarq() {
        return this.f6957l;
    }
}
