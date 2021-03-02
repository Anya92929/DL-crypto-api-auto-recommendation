package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

final class TargetAction extends Action<Target> {
    TargetAction(Picasso picasso, Target target, Request data, boolean skipCache, String key) {
        super(picasso, target, data, skipCache, false, 0, (Drawable) null, key);
    }

    /* access modifiers changed from: package-private */
    public void complete(Bitmap result, Picasso.LoadedFrom from) {
        if (result == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        Target target = (Target) getTarget();
        if (target != null) {
            target.onBitmapLoaded(result, from);
            if (result.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void error() {
        Target target = (Target) getTarget();
        if (target != null) {
            target.onBitmapFailed(this.errorDrawable);
        }
    }
}
