package com.nostra13.universalimageloader.core;

import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ImageLoaderEngine {
    private final Map<Integer, String> cacheKeysForImageViews = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public ExecutorService cachedImageLoadingExecutor;
    final ImageLoaderConfiguration configuration;
    /* access modifiers changed from: private */
    public ExecutorService imageLoadingExecutor;
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private ExecutorService taskDistributor;
    private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();

    ImageLoaderEngine(ImageLoaderConfiguration configuration2) {
        this.configuration = configuration2;
    }

    /* access modifiers changed from: package-private */
    public void submit(final LoadAndDisplayImageTask task) {
        initExecutorsIfNeed();
        this.taskDistributor.submit(new Runnable() {
            public void run() {
                if (ImageLoaderEngine.this.configuration.discCache.get(task.getLoadingUri()).exists()) {
                    ImageLoaderEngine.this.cachedImageLoadingExecutor.submit(task);
                } else {
                    ImageLoaderEngine.this.imageLoadingExecutor.submit(task);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void submit(ProcessAndDisplayImageTask task) {
        initExecutorsIfNeed();
        this.cachedImageLoadingExecutor.submit(task);
    }

    private void initExecutorsIfNeed() {
        if (this.imageLoadingExecutor == null || this.imageLoadingExecutor.isShutdown()) {
            this.imageLoadingExecutor = createTaskExecutor();
        }
        if (this.cachedImageLoadingExecutor == null || this.cachedImageLoadingExecutor.isShutdown()) {
            this.cachedImageLoadingExecutor = createTaskExecutor();
        }
        if (this.taskDistributor == null || this.taskDistributor.isShutdown()) {
            this.taskDistributor = Executors.newCachedThreadPool();
        }
    }

    private ExecutorService createTaskExecutor() {
        return new ThreadPoolExecutor(this.configuration.threadPoolSize, this.configuration.threadPoolSize, 0, TimeUnit.MILLISECONDS, this.configuration.tasksProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque<>() : new LinkedBlockingQueue<>(), this.configuration.displayImageThreadFactory);
    }

    /* access modifiers changed from: package-private */
    public String getLoadingUriForView(ImageView imageView) {
        return this.cacheKeysForImageViews.get(Integer.valueOf(imageView.hashCode()));
    }

    /* access modifiers changed from: package-private */
    public void prepareDisplayTaskFor(ImageView imageView, String memoryCacheKey) {
        this.cacheKeysForImageViews.put(Integer.valueOf(imageView.hashCode()), memoryCacheKey);
    }

    /* access modifiers changed from: package-private */
    public void cancelDisplayTaskFor(ImageView imageView) {
        this.cacheKeysForImageViews.remove(Integer.valueOf(imageView.hashCode()));
    }

    /* access modifiers changed from: package-private */
    public void denyNetworkDownloads() {
        this.networkDenied.set(true);
    }

    /* access modifiers changed from: package-private */
    public void allowNetworkDownloads() {
        this.networkDenied.set(false);
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        this.paused.set(true);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        synchronized (this.paused) {
            this.paused.set(false);
            this.paused.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        if (this.imageLoadingExecutor != null) {
            this.imageLoadingExecutor.shutdownNow();
        }
        if (this.cachedImageLoadingExecutor != null) {
            this.cachedImageLoadingExecutor.shutdownNow();
        }
        if (this.taskDistributor != null) {
            this.taskDistributor.shutdownNow();
        }
    }

    /* access modifiers changed from: package-private */
    public ReentrantLock getLockForUri(String uri) {
        ReentrantLock lock = this.uriLocks.get(uri);
        if (lock != null) {
            return lock;
        }
        ReentrantLock lock2 = new ReentrantLock();
        this.uriLocks.put(uri, lock2);
        return lock2;
    }

    /* access modifiers changed from: package-private */
    public AtomicBoolean getPause() {
        return this.paused;
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkDenied() {
        return this.networkDenied.get();
    }
}
