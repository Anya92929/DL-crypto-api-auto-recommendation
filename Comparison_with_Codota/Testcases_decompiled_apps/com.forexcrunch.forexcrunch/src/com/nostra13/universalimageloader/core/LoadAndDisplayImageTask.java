package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.C0847L;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask implements Runnable {
    private static final int ATTEMPT_COUNT_TO_DECODE_BITMAP = 3;
    private static final int BUFFER_SIZE = 8192;
    private final ImageLoaderConfiguration configuration;
    private final ImageDownloader downloader = this.configuration.downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageView imageView;
    final ImageLoadingListener listener;
    private final boolean loggingEnabled = this.configuration.loggingEnabled;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader = this.configuration.networkDeniedDownloader;
    final DisplayImageOptions options;
    private final ImageSize targetSize;
    final String uri;

    public LoadAndDisplayImageTask(ImageLoaderEngine engine2, ImageLoadingInfo imageLoadingInfo2, Handler handler2) {
        this.engine = engine2;
        this.imageLoadingInfo = imageLoadingInfo2;
        this.handler = handler2;
        this.configuration = engine2.configuration;
        this.uri = imageLoadingInfo2.uri;
        this.memoryCacheKey = imageLoadingInfo2.memoryCacheKey;
        this.imageView = imageLoadingInfo2.imageView;
        this.targetSize = imageLoadingInfo2.targetSize;
        this.options = imageLoadingInfo2.options;
        this.listener = imageLoadingInfo2.listener;
    }

    public void run() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (pause) {
                log("ImageLoader is paused. Waiting...  [%s]", this.memoryCacheKey);
                try {
                    pause.wait();
                    log(".. Resume loading [%s]", this.memoryCacheKey);
                } catch (InterruptedException e) {
                    C0847L.m2146e("Task was interrupted [%s]", this.memoryCacheKey);
                    return;
                }
            }
        }
        if (!checkTaskIsNotActual()) {
            if (this.options.shouldDelayBeforeLoading()) {
                log("Delay %d ms before loading...  [%s]", Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
                try {
                    Thread.sleep((long) this.options.getDelayBeforeLoading());
                    if (checkTaskIsNotActual()) {
                        return;
                    }
                } catch (InterruptedException e2) {
                    C0847L.m2146e("Task was interrupted [%s]", this.memoryCacheKey);
                    return;
                }
            }
            ReentrantLock loadFromUriLock = this.imageLoadingInfo.loadFromUriLock;
            log("Start display image task [%s]", this.memoryCacheKey);
            if (loadFromUriLock.isLocked()) {
                log("Image already is loading. Waiting... [%s]", this.memoryCacheKey);
            }
            loadFromUriLock.lock();
            try {
                if (!checkTaskIsNotActual()) {
                    Bitmap bmp = this.configuration.memoryCache.get(this.memoryCacheKey);
                    if (bmp == null) {
                        bmp = tryLoadBitmap();
                        if (bmp == null) {
                            loadFromUriLock.unlock();
                            return;
                        } else if (checkTaskIsNotActual() || checkTaskIsInterrupted()) {
                            loadFromUriLock.unlock();
                            return;
                        } else {
                            if (this.options.shouldPreProcess()) {
                                log("PreProcess image before caching in memory [%s]", this.memoryCacheKey);
                                bmp = this.options.getPreProcessor().process(bmp);
                            }
                            if (this.options.isCacheInMemory()) {
                                log("Cache image in memory [%s]", this.memoryCacheKey);
                                this.configuration.memoryCache.put(this.memoryCacheKey, bmp);
                            }
                        }
                    } else {
                        log("...Get cached bitmap from memory after waiting. [%s]", this.memoryCacheKey);
                    }
                    if (this.options.shouldPostProcess()) {
                        log("PostProcess image before displaying [%s]", this.memoryCacheKey);
                        bmp = this.options.getPostProcessor().process(bmp);
                    }
                    loadFromUriLock.unlock();
                    if (!checkTaskIsNotActual() && !checkTaskIsInterrupted()) {
                        DisplayBitmapTask displayBitmapTask = new DisplayBitmapTask(bmp, this.imageLoadingInfo, this.engine);
                        displayBitmapTask.setLoggingEnabled(this.loggingEnabled);
                        this.handler.post(displayBitmapTask);
                    }
                }
            } finally {
                loadFromUriLock.unlock();
            }
        }
    }

    private boolean checkTaskIsNotActual() {
        boolean imageViewWasReused;
        if (!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageView))) {
            imageViewWasReused = true;
        } else {
            imageViewWasReused = false;
        }
        if (imageViewWasReused) {
            this.handler.post(new Runnable() {
                public void run() {
                    LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView);
                }
            });
        }
        if (imageViewWasReused) {
            log("ImageView is reused for another image. Task is cancelled. [%s]", this.memoryCacheKey);
        }
        return imageViewWasReused;
    }

    private boolean checkTaskIsInterrupted() {
        boolean interrupted = Thread.interrupted();
        if (interrupted) {
            log("Task was interrupted [%s]", this.memoryCacheKey);
        }
        return interrupted;
    }

    private Bitmap tryLoadBitmap() {
        URI imageUriForDecoding;
        DiscCacheAware discCache = this.configuration.discCache;
        File imageFile = discCache.get(this.uri);
        Bitmap bitmap = null;
        try {
            if (imageFile.exists()) {
                log("Load image from disc cache [%s]", this.memoryCacheKey);
                Bitmap b = decodeImage(imageFile.toURI());
                if (b != null) {
                    return b;
                }
            }
            log("Load image from Internet [%s]", this.memoryCacheKey);
            if (this.options.isCacheOnDisc()) {
                log("Cache image on disc [%s]", this.memoryCacheKey);
                saveImageOnDisc(imageFile);
                discCache.put(this.uri, imageFile);
                imageUriForDecoding = imageFile.toURI();
            } else {
                imageUriForDecoding = new URI(this.uri);
            }
            bitmap = decodeImage(imageUriForDecoding);
            if (bitmap == null) {
                fireImageLoadingFailedEvent(FailReason.IO_ERROR);
            }
        } catch (IllegalStateException e) {
            fireImageLoadingFailedEvent(FailReason.NETWORK_DENIED);
        } catch (UnsupportedOperationException e2) {
            C0847L.m2147e(e2);
            fireImageLoadingFailedEvent(FailReason.UNSUPPORTED_URI_SCHEME);
        } catch (IOException e3) {
            C0847L.m2147e(e3);
            fireImageLoadingFailedEvent(FailReason.IO_ERROR);
            if (imageFile.exists()) {
                imageFile.delete();
            }
        } catch (OutOfMemoryError e4) {
            C0847L.m2147e(e4);
            fireImageLoadingFailedEvent(FailReason.OUT_OF_MEMORY);
        } catch (Throwable e5) {
            C0847L.m2147e(e5);
            fireImageLoadingFailedEvent(FailReason.UNKNOWN);
        }
        return bitmap;
    }

    private Bitmap decodeImage(URI imageUri) throws IOException {
        if (this.configuration.handleOutOfMemory) {
            return decodeWithOOMHandling(imageUri);
        }
        ImageDecoder decoder = new ImageDecoder(imageUri, getDownloader(), this.options);
        decoder.setLoggingEnabled(this.loggingEnabled);
        return decoder.decode(this.targetSize, this.options.getImageScaleType(), ViewScaleType.fromImageView(this.imageView));
    }

    private Bitmap decodeWithOOMHandling(URI imageUri) throws IOException {
        Bitmap result = null;
        ImageDecoder decoder = new ImageDecoder(imageUri, getDownloader(), this.options);
        decoder.setLoggingEnabled(this.loggingEnabled);
        int attempt = 1;
        while (attempt <= 3) {
            try {
                result = decoder.decode(this.targetSize, this.options.getImageScaleType(), ViewScaleType.fromImageView(this.imageView));
                return result;
            } catch (OutOfMemoryError e) {
                C0847L.m2147e(e);
                switch (attempt) {
                    case 1:
                        System.gc();
                        break;
                    case 2:
                        this.configuration.memoryCache.clear();
                        System.gc();
                        break;
                    case 3:
                        throw e;
                }
                SystemClock.sleep((long) (attempt * 1000));
                attempt++;
            }
        }
        return result;
    }

    private void saveImageOnDisc(File targetFile) throws IOException, URISyntaxException {
        File cacheDir = targetFile.getParentFile();
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        int width = this.configuration.maxImageWidthForDiscCache;
        int height = this.configuration.maxImageHeightForDiscCache;
        if (width > 0 || height > 0) {
            ImageSize targetImageSize = new ImageSize(width, height);
            ImageDecoder decoder = new ImageDecoder(new URI(this.uri), getDownloader(), this.options);
            decoder.setLoggingEnabled(this.loggingEnabled);
            Bitmap bmp = decoder.decode(targetImageSize, ImageScaleType.IN_SAMPLE_INT, ViewScaleType.FIT_INSIDE);
            if (bmp != null) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(targetFile), 8192);
                try {
                    if (bmp.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, os)) {
                        bmp.recycle();
                        return;
                    }
                } finally {
                    IoUtils.closeSilently(os);
                }
            }
        }
        OutputStream os2 = getDownloader().getStream(new URI(this.uri), this.options.getExtraForDownloader());
        try {
            os2 = new BufferedOutputStream(new FileOutputStream(targetFile), 8192);
            IoUtils.copyStream(os2, os2);
        } catch (Throwable th) {
            throw th;
        } finally {
            IoUtils.closeSilently(os2);
        }
    }

    private void fireImageLoadingFailedEvent(final FailReason failReason) {
        if (!Thread.interrupted()) {
            this.handler.post(new Runnable() {
                public void run() {
                    if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                        LoadAndDisplayImageTask.this.imageView.setImageResource(LoadAndDisplayImageTask.this.options.getImageOnFail());
                    }
                    LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView, failReason);
                }
            });
        }
    }

    private ImageDownloader getDownloader() {
        return this.engine.isNetworkDenied() ? this.networkDeniedDownloader : this.downloader;
    }

    /* access modifiers changed from: package-private */
    public String getLoadingUri() {
        return this.uri;
    }

    private void log(String message, Object... args) {
        if (this.loggingEnabled) {
            C0847L.m2149i(message, args);
        }
    }
}
