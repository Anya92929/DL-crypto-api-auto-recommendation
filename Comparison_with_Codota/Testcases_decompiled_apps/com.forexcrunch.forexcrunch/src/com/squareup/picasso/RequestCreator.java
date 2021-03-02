package com.squareup.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import java.io.IOException;

public class RequestCreator {
    private final Request.Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private boolean noFade;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean skipMemoryCache;

    RequestCreator(Picasso picasso2, Uri uri, int resourceId) {
        if (picasso2.shutdown) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.picasso = picasso2;
        this.data = new Request.Builder(uri, resourceId);
    }

    RequestCreator() {
        this.picasso = null;
        this.data = new Request.Builder((Uri) null, 0);
    }

    public RequestCreator placeholder(int placeholderResId2) {
        if (placeholderResId2 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.placeholderDrawable != null) {
            throw new IllegalStateException("Placeholder image already set.");
        } else {
            this.placeholderResId = placeholderResId2;
            return this;
        }
    }

    public RequestCreator placeholder(Drawable placeholderDrawable2) {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.placeholderDrawable = placeholderDrawable2;
        return this;
    }

    public RequestCreator error(int errorResId2) {
        if (errorResId2 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.errorDrawable != null) {
            throw new IllegalStateException("Error image already set.");
        } else {
            this.errorResId = errorResId2;
            return this;
        }
    }

    public RequestCreator error(Drawable errorDrawable2) {
        if (errorDrawable2 == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.errorResId != 0) {
            throw new IllegalStateException("Error image already set.");
        } else {
            this.errorDrawable = errorDrawable2;
            return this;
        }
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RequestCreator unfit() {
        this.deferred = false;
        return this;
    }

    public RequestCreator resizeDimen(int targetWidthResId, int targetHeightResId) {
        Resources resources = this.picasso.context.getResources();
        return resize(resources.getDimensionPixelSize(targetWidthResId), resources.getDimensionPixelSize(targetHeightResId));
    }

    public RequestCreator resize(int targetWidth, int targetHeight) {
        this.data.resize(targetWidth, targetHeight);
        return this;
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop();
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    public RequestCreator rotate(float degrees) {
        this.data.rotate(degrees);
        return this;
    }

    public RequestCreator rotate(float degrees, float pivotX, float pivotY) {
        this.data.rotate(degrees, pivotX, pivotY);
        return this;
    }

    public RequestCreator transform(Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    public RequestCreator skipMemoryCache() {
        this.skipMemoryCache = true;
        return this;
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public Bitmap get() throws IOException {
        Utils.checkNotMain();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.data.hasImage()) {
            return null;
        } else {
            Request finalData = this.picasso.transformRequest(this.data.build());
            return BitmapHunter.forRequest(this.picasso.context, this.picasso, this.picasso.dispatcher, this.picasso.cache, this.picasso.stats, new GetAction(this.picasso, finalData, this.skipMemoryCache, Utils.createKey(finalData)), this.picasso.dispatcher.downloader).hunt();
        }
    }

    public void fetch() {
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.data.hasImage()) {
            Request finalData = this.picasso.transformRequest(this.data.build());
            this.picasso.enqueueAndSubmit(new FetchAction(this.picasso, finalData, this.skipMemoryCache, Utils.createKey(finalData)));
        }
    }

    public void into(Target target) {
        Bitmap bitmap;
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else {
            Drawable drawable = this.placeholderResId != 0 ? this.picasso.context.getResources().getDrawable(this.placeholderResId) : this.placeholderDrawable;
            if (!this.data.hasImage()) {
                this.picasso.cancelRequest(target);
                target.onPrepareLoad(drawable);
                return;
            }
            Request finalData = this.picasso.transformRequest(this.data.build());
            String requestKey = Utils.createKey(finalData);
            if (this.skipMemoryCache || (bitmap = this.picasso.quickMemoryCacheCheck(requestKey)) == null) {
                target.onPrepareLoad(drawable);
                this.picasso.enqueueAndSubmit(new TargetAction(this.picasso, target, finalData, this.skipMemoryCache, requestKey));
                return;
            }
            this.picasso.cancelRequest(target);
            target.onBitmapLoaded(bitmap, Picasso.LoadedFrom.MEMORY);
        }
    }

    public void into(ImageView target) {
        into(target, (Callback) null);
    }

    public void into(ImageView target, Callback callback) {
        Bitmap bitmap;
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.data.hasImage()) {
            this.picasso.cancelRequest(target);
            PicassoDrawable.setPlaceholder(target, this.placeholderResId, this.placeholderDrawable);
        } else {
            if (this.deferred) {
                if (this.data.hasSize()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int measuredWidth = target.getMeasuredWidth();
                int measuredHeight = target.getMeasuredHeight();
                if (measuredWidth == 0 && measuredHeight == 0) {
                    PicassoDrawable.setPlaceholder(target, this.placeholderResId, this.placeholderDrawable);
                    this.picasso.defer(target, new DeferredRequestCreator(this, target, callback));
                    return;
                }
                this.data.resize(measuredWidth, measuredHeight);
            }
            Request finalData = this.picasso.transformRequest(this.data.build());
            String requestKey = Utils.createKey(finalData);
            if (this.skipMemoryCache || (bitmap = this.picasso.quickMemoryCacheCheck(requestKey)) == null) {
                PicassoDrawable.setPlaceholder(target, this.placeholderResId, this.placeholderDrawable);
                this.picasso.enqueueAndSubmit(new ImageViewAction(this.picasso, target, finalData, this.skipMemoryCache, this.noFade, this.errorResId, this.errorDrawable, requestKey, callback));
                return;
            }
            this.picasso.cancelRequest(target);
            PicassoDrawable.setBitmap(target, this.picasso.context, bitmap, Picasso.LoadedFrom.MEMORY, this.noFade, this.picasso.debugging);
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }
}
