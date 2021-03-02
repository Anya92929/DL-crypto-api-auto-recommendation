package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

class FetchAction extends Action<Void> {
    FetchAction(Picasso picasso, Request data, boolean skipCache, String key) {
        super(picasso, null, data, skipCache, false, 0, (Drawable) null, key);
    }

    /* access modifiers changed from: package-private */
    public void complete(Bitmap result, Picasso.LoadedFrom from) {
    }

    public void error() {
    }
}
