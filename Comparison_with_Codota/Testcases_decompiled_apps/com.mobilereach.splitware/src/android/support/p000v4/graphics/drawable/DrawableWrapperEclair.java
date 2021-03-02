package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.p000v4.graphics.drawable.DrawableWrapperDonut;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperEclair */
class DrawableWrapperEclair extends DrawableWrapperDonut {
    DrawableWrapperEclair(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperEclair(DrawableWrapperDonut.DrawableWrapperState state, Resources resources) {
        super(state, resources);
    }

    /* access modifiers changed from: package-private */
    public DrawableWrapperDonut.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateEclair(this.mState, (Resources) null);
    }

    /* access modifiers changed from: protected */
    public Drawable newDrawableFromState(Drawable.ConstantState state, Resources res) {
        return state.newDrawable(res);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableWrapperEclair$DrawableWrapperStateEclair */
    private static class DrawableWrapperStateEclair extends DrawableWrapperDonut.DrawableWrapperState {
        DrawableWrapperStateEclair(@Nullable DrawableWrapperDonut.DrawableWrapperState orig, @Nullable Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(@Nullable Resources res) {
            return new DrawableWrapperEclair(this, res);
        }
    }
}
