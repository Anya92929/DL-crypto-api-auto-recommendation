package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class Action<T> {
    boolean cancelled;
    final Request data;
    final Drawable errorDrawable;
    final int errorResId;
    final String key;
    final boolean noFade;
    final Picasso picasso;
    final boolean skipCache;
    final WeakReference<T> target;

    /* access modifiers changed from: package-private */
    public abstract void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    /* access modifiers changed from: package-private */
    public abstract void error();

    static class RequestWeakReference<T> extends WeakReference<T> {
        final Action action;

        public RequestWeakReference(Action action2, T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
            this.action = action2;
        }
    }

    Action(Picasso picasso2, T target2, Request data2, boolean skipCache2, boolean noFade2, int errorResId2, Drawable errorDrawable2, String key2) {
        this.picasso = picasso2;
        this.data = data2;
        this.target = new RequestWeakReference(this, target2, picasso2.referenceQueue);
        this.skipCache = skipCache2;
        this.noFade = noFade2;
        this.errorResId = errorResId2;
        this.errorDrawable = errorDrawable2;
        this.key = key2;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.cancelled = true;
    }

    /* access modifiers changed from: package-private */
    public Request getData() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public T getTarget() {
        return this.target.get();
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this.cancelled;
    }

    /* access modifiers changed from: package-private */
    public Picasso getPicasso() {
        return this.picasso;
    }
}
