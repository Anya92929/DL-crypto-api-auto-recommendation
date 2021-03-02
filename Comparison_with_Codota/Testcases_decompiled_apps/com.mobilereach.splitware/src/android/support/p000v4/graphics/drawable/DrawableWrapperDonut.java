package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperDonut */
class DrawableWrapperDonut extends Drawable implements Drawable.Callback, DrawableWrapper {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    DrawableWrapperState mState;

    DrawableWrapperDonut(@NonNull DrawableWrapperState state, @Nullable Resources res) {
        this.mState = state;
        updateLocalState(res);
    }

    DrawableWrapperDonut(@Nullable Drawable dr) {
        if (!(dr == null || dr.getConstantState() == null)) {
            this.mState = mutateConstantState();
        }
        setWrappedDrawable(dr);
    }

    private void updateLocalState(@Nullable Resources res) {
        if (this.mState != null && this.mState.mDrawableState != null) {
            setWrappedDrawable(newDrawableFromState(this.mState.mDrawableState, res));
        }
    }

    /* access modifiers changed from: protected */
    public Drawable newDrawableFromState(@NonNull Drawable.ConstantState state, @Nullable Resources res) {
        return state.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(bounds);
        }
    }

    public void setChangingConfigurations(int configs) {
        this.mDrawable.setChangingConfigurations(configs);
    }

    public int getChangingConfigurations() {
        return (this.mState != null ? this.mState.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean dither) {
        this.mDrawable.setDither(dither);
    }

    public void setFilterBitmap(boolean filter) {
        this.mDrawable.setFilterBitmap(filter);
    }

    public void setAlpha(int alpha) {
        this.mDrawable.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.mDrawable.setColorFilter(cf);
    }

    public boolean isStateful() {
        ColorStateList tintList = isCompatTintEnabled() ? this.mState.mTint : null;
        return (tintList != null && tintList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] stateSet) {
        return updateTint(stateSet) || this.mDrawable.setState(stateSet);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || this.mDrawable.setVisible(visible, restart);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect padding) {
        return this.mDrawable.getPadding(padding);
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        if (this.mState == null || !this.mState.canConstantState()) {
            return null;
        }
        this.mState.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState = mutateConstantState();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.mState != null) {
                this.mState.mDrawableState = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateDonut(this.mState, (Resources) null);
    }

    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        return this.mDrawable.setLevel(level);
    }

    public void setCompatTint(int tint) {
        setCompatTintList(ColorStateList.valueOf(tint));
    }

    public void setCompatTintList(ColorStateList tint) {
        this.mState.mTint = tint;
        updateTint(getState());
    }

    public void setCompatTintMode(PorterDuff.Mode tintMode) {
        this.mState.mTintMode = tintMode;
        updateTint(getState());
    }

    private boolean updateTint(int[] state) {
        if (!isCompatTintEnabled()) {
            return false;
        }
        ColorStateList tintList = this.mState.mTint;
        PorterDuff.Mode tintMode = this.mState.mTintMode;
        if (tintList == null || tintMode == null) {
            this.mColorFilterSet = false;
            clearColorFilter();
            return false;
        }
        int color = tintList.getColorForState(state, tintList.getDefaultColor());
        if (this.mColorFilterSet && color == this.mCurrentColor && tintMode == this.mCurrentMode) {
            return false;
        }
        setColorFilter(color, tintMode);
        this.mCurrentColor = color;
        this.mCurrentMode = tintMode;
        this.mColorFilterSet = true;
        return true;
    }

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public final void setWrappedDrawable(Drawable dr) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback((Drawable.Callback) null);
        }
        this.mDrawable = dr;
        if (dr != null) {
            dr.setCallback(this);
            dr.setVisible(isVisible(), true);
            dr.setState(getState());
            dr.setLevel(getLevel());
            dr.setBounds(getBounds());
            if (this.mState != null) {
                this.mState.mDrawableState = dr.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean isCompatTintEnabled() {
        return true;
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperState */
    protected static abstract class DrawableWrapperState extends Drawable.ConstantState {
        int mChangingConfigurations;
        Drawable.ConstantState mDrawableState;
        ColorStateList mTint = null;
        PorterDuff.Mode mTintMode = DrawableWrapperDonut.DEFAULT_TINT_MODE;

        public abstract Drawable newDrawable(@Nullable Resources resources);

        DrawableWrapperState(@Nullable DrawableWrapperState orig, @Nullable Resources res) {
            if (orig != null) {
                this.mChangingConfigurations = orig.mChangingConfigurations;
                this.mDrawableState = orig.mDrawableState;
                this.mTint = orig.mTint;
                this.mTintMode = orig.mTintMode;
            }
        }

        public Drawable newDrawable() {
            return newDrawable((Resources) null);
        }

        public int getChangingConfigurations() {
            return (this.mDrawableState != null ? this.mDrawableState.getChangingConfigurations() : 0) | this.mChangingConfigurations;
        }

        /* access modifiers changed from: package-private */
        public boolean canConstantState() {
            return this.mDrawableState != null;
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperStateDonut */
    private static class DrawableWrapperStateDonut extends DrawableWrapperState {
        DrawableWrapperStateDonut(@Nullable DrawableWrapperState orig, @Nullable Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(@Nullable Resources res) {
            return new DrawableWrapperDonut(this, res);
        }
    }
}
