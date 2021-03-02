package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.utils.C0847L;

class ProcessAndDisplayImageTask implements Runnable {
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine engine2, Bitmap bitmap2, ImageLoadingInfo imageLoadingInfo2, Handler handler2) {
        this.engine = engine2;
        this.bitmap = bitmap2;
        this.imageLoadingInfo = imageLoadingInfo2;
        this.handler = handler2;
    }

    public void run() {
        if (this.engine.configuration.loggingEnabled) {
            C0847L.m2149i("PostProcess image before displaying [%s]", this.imageLoadingInfo.memoryCacheKey);
        }
        Bitmap processedBitmap = this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap);
        if (processedBitmap != this.bitmap) {
            this.bitmap.recycle();
        }
        this.handler.post(new DisplayBitmapTask(processedBitmap, this.imageLoadingInfo, this.engine));
    }
}
