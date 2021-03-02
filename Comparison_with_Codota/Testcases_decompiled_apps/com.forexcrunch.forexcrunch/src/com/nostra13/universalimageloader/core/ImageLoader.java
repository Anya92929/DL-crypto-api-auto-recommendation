package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FakeBitmapDisplayer;
import com.nostra13.universalimageloader.utils.C0847L;
import java.lang.reflect.Field;

public class ImageLoader {
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference are required)";
    static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
    static final String LOG_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    static final String LOG_DISPLAY_IMAGE_IN_IMAGEVIEW = "Display image in ImageView [%s]";
    static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    static final String LOG_IMAGE_SCALED = "Subsampled image (%1$dx%2$d) was scaled to %3$dx%4$d";
    static final String LOG_IMAGE_SUBSAMPLING = "Original image (%1$dx%2$d) is going to be subsampled to %3$dx%4$d view. Computed scale size - %5$d";
    static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
    static final String LOG_LOAD_IMAGE_FROM_INTERNET = "Load image from Internet [%s]";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
    static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    public static final String TAG = ImageLoader.class.getSimpleName();
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;
    private final BitmapDisplayer fakeBitmapDisplayer = new FakeBitmapDisplayer();

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    protected ImageLoader() {
    }

    public synchronized void init(ImageLoaderConfiguration configuration2) {
        if (configuration2 == null) {
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        } else if (this.configuration == null) {
            this.engine = new ImageLoaderEngine(configuration2);
            this.configuration = configuration2;
        }
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void displayImage(String uri, ImageView imageView) {
        displayImage(uri, imageView, (DisplayImageOptions) null, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options) {
        displayImage(uri, imageView, options, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageView imageView, ImageLoadingListener listener) {
        displayImage(uri, imageView, (DisplayImageOptions) null, listener);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener listener) {
        checkConfiguration();
        if (imageView == null) {
            throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
        }
        if (listener == null) {
            listener = this.emptyListener;
        }
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        if (uri == null || uri.length() == 0) {
            this.engine.cancelDisplayTaskFor(imageView);
            listener.onLoadingStarted(uri, imageView);
            if (options.shouldShowImageForEmptyUri()) {
                imageView.setImageResource(options.getImageForEmptyUri());
            } else {
                imageView.setImageBitmap((Bitmap) null);
            }
            listener.onLoadingComplete(uri, imageView, (Bitmap) null);
            return;
        }
        ImageSize targetSize = getImageSizeScaleTo(imageView);
        String memoryCacheKey = MemoryCacheUtil.generateKey(uri, targetSize);
        this.engine.prepareDisplayTaskFor(imageView, memoryCacheKey);
        listener.onLoadingStarted(uri, imageView);
        Bitmap bmp = this.configuration.memoryCache.get(memoryCacheKey);
        if (bmp == null || bmp.isRecycled()) {
            if (options.shouldShowStubImage()) {
                imageView.setImageResource(options.getStubImage());
            } else if (options.isResetViewBeforeLoading()) {
                imageView.setImageBitmap((Bitmap) null);
            }
            this.engine.submit(new LoadAndDisplayImageTask(this.engine, new ImageLoadingInfo(uri, imageView, targetSize, options, listener, this.engine.getLockForUri(uri)), new Handler()));
            return;
        }
        if (this.configuration.loggingEnabled) {
            C0847L.m2149i(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, memoryCacheKey);
        }
        if (options.shouldPostProcess()) {
            this.engine.submit(new ProcessAndDisplayImageTask(this.engine, bmp, new ImageLoadingInfo(uri, imageView, targetSize, options, listener, this.engine.getLockForUri(uri)), new Handler()));
            return;
        }
        options.getDisplayer().display(bmp, imageView);
        listener.onLoadingComplete(uri, imageView, bmp);
    }

    public void loadImage(String uri, ImageLoadingListener listener) {
        loadImage(uri, (ImageSize) null, (DisplayImageOptions) null, listener);
    }

    public void loadImage(String uri, ImageSize minImageSize, ImageLoadingListener listener) {
        loadImage(uri, minImageSize, (DisplayImageOptions) null, listener);
    }

    public void loadImage(String uri, DisplayImageOptions options, ImageLoadingListener listener) {
        loadImage(uri, (ImageSize) null, options, listener);
    }

    public void loadImage(String uri, ImageSize targetImageSize, DisplayImageOptions options, ImageLoadingListener listener) {
        DisplayImageOptions optionsWithFakeDisplayer;
        checkConfiguration();
        if (targetImageSize == null) {
            targetImageSize = new ImageSize(this.configuration.maxImageWidthForMemoryCache, this.configuration.maxImageHeightForMemoryCache);
        }
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        if (options.getDisplayer() instanceof FakeBitmapDisplayer) {
            optionsWithFakeDisplayer = options;
        } else {
            optionsWithFakeDisplayer = new DisplayImageOptions.Builder().cloneFrom(options).displayer(this.fakeBitmapDisplayer).build();
        }
        ImageView fakeImage = new ImageView(this.configuration.context);
        fakeImage.setLayoutParams(new ViewGroup.LayoutParams(targetImageSize.getWidth(), targetImageSize.getHeight()));
        fakeImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        displayImage(uri, fakeImage, optionsWithFakeDisplayer, listener);
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public MemoryCacheAware<String, Bitmap> getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    public DiscCacheAware getDiscCache() {
        checkConfiguration();
        return this.configuration.discCache;
    }

    public void clearDiscCache() {
        checkConfiguration();
        this.configuration.discCache.clear();
    }

    public String getLoadingUriForView(ImageView imageView) {
        return this.engine.getLoadingUriForView(imageView);
    }

    public void cancelDisplayTask(ImageView imageView) {
        this.engine.cancelDisplayTaskFor(imageView);
    }

    public void denyNetworkDownloads() {
        this.engine.denyNetworkDownloads();
    }

    public void allowNetworkDownloads() {
        this.engine.allowNetworkDownloads();
    }

    public void pause() {
        this.engine.pause();
    }

    public void resume() {
        this.engine.resume();
    }

    public void stop() {
        this.engine.stop();
    }

    private ImageSize getImageSizeScaleTo(ImageView imageView) {
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        int width = params.width;
        if (width <= 0) {
            width = getFieldValue(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = this.configuration.maxImageWidthForMemoryCache;
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = params.height;
        if (height <= 0) {
            height = getFieldValue(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = this.configuration.maxImageHeightForMemoryCache;
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        return new ImageSize(width, height);
    }

    private int getFieldValue(Object object, String fieldName) {
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = ((Integer) field.get(object)).intValue();
            if (fieldValue <= 0 || fieldValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return fieldValue;
        } catch (Exception e) {
            C0847L.m2147e(e);
            return 0;
        }
    }
}
