package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.utils.C0847L;

final class DisplayBitmapTask implements Runnable {
    private final Bitmap bitmap;
    private final BitmapDisplayer displayer;
    private final ImageLoaderEngine engine;
    private final String imageUri;
    private final ImageView imageView;
    private final ImageLoadingListener listener;
    private boolean loggingEnabled;
    private final String memoryCacheKey;

    public DisplayBitmapTask(Bitmap bitmap2, ImageLoadingInfo imageLoadingInfo, ImageLoaderEngine engine2) {
        this.bitmap = bitmap2;
        this.imageUri = imageLoadingInfo.uri;
        this.imageView = imageLoadingInfo.imageView;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.displayer = imageLoadingInfo.options.getDisplayer();
        this.listener = imageLoadingInfo.listener;
        this.engine = engine2;
    }

    public void run() {
        if (isViewWasReused()) {
            if (this.loggingEnabled) {
                C0847L.m2149i("ImageView is reused for another image. Task is cancelled. [%s]", this.memoryCacheKey);
            }
            this.listener.onLoadingCancelled(this.imageUri, this.imageView);
            return;
        }
        if (this.loggingEnabled) {
            C0847L.m2149i("Display image in ImageView [%s]", this.memoryCacheKey);
        }
        this.listener.onLoadingComplete(this.imageUri, this.imageView, this.displayer.display(this.bitmap, this.imageView));
        this.engine.cancelDisplayTaskFor(this.imageView);
    }

    private boolean isViewWasReused() {
        return !this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageView));
    }

    /* access modifiers changed from: package-private */
    public void setLoggingEnabled(boolean loggingEnabled2) {
        this.loggingEnabled = loggingEnabled2;
    }
}
