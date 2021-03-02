package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class Stats {
    private static final int BITMAP_DECODE_FINISHED = 3;
    private static final int BITMAP_TRANSFORMED_FINISHED = 4;
    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 2;
    private static final int REQUESTED_COMPLETED = 0;
    private static final String STATS_THREAD_NAME = "Picasso-Stats";
    long averageOriginalBitmapSize;
    long averageTransformedBitmapSize;
    final Cache cache;
    long cacheHits;
    long cacheMisses;
    final Handler handler;
    int originalBitmapCount;
    final HandlerThread statsThread = new HandlerThread(STATS_THREAD_NAME, 10);
    long totalOriginalBitmapSize;
    long totalTransformedBitmapSize;
    int transformedBitmapCount;

    Stats(Cache cache2) {
        this.cache = cache2;
        this.statsThread.start();
        this.handler = new StatsHandler(this.statsThread.getLooper());
    }

    /* access modifiers changed from: package-private */
    public void dispatchBitmapDecoded(Bitmap bitmap) {
        processBitmap(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void dispatchBitmapTransformed(Bitmap bitmap) {
        processBitmap(bitmap, 4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchCacheHit() {
        this.handler.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchCacheMiss() {
        this.handler.sendEmptyMessage(2);
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.statsThread.quit();
    }

    /* access modifiers changed from: package-private */
    public void performCacheHit() {
        this.cacheHits++;
    }

    /* access modifiers changed from: package-private */
    public void performCacheMiss() {
        this.cacheMisses++;
    }

    /* access modifiers changed from: package-private */
    public void performBitmapDecoded(long size) {
        this.originalBitmapCount++;
        this.totalOriginalBitmapSize += size;
        this.averageOriginalBitmapSize = getAverage(this.originalBitmapCount, this.totalOriginalBitmapSize);
    }

    /* access modifiers changed from: package-private */
    public void performBitmapTransformed(long size) {
        this.transformedBitmapCount++;
        this.totalTransformedBitmapSize += size;
        this.averageTransformedBitmapSize = getAverage(this.originalBitmapCount, this.totalTransformedBitmapSize);
    }

    /* access modifiers changed from: package-private */
    public synchronized StatsSnapshot createSnapshot() {
        return new StatsSnapshot(this.cache.maxSize(), this.cache.size(), this.cacheHits, this.cacheMisses, this.totalOriginalBitmapSize, this.totalTransformedBitmapSize, this.averageOriginalBitmapSize, this.averageTransformedBitmapSize, this.originalBitmapCount, this.transformedBitmapCount, System.currentTimeMillis());
    }

    private void processBitmap(Bitmap bitmap, int what) {
        this.handler.sendMessage(this.handler.obtainMessage(what, Utils.getBitmapBytes(bitmap), 0));
    }

    private static long getAverage(int count, long totalSize) {
        return totalSize / ((long) count);
    }

    private class StatsHandler extends Handler {
        public StatsHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(final Message msg) {
            synchronized (Stats.this) {
                switch (msg.what) {
                    case 0:
                        break;
                    case 1:
                        Stats.this.performCacheHit();
                        break;
                    case 2:
                        Stats.this.performCacheMiss();
                        break;
                    case 3:
                        Stats.this.performBitmapDecoded((long) msg.arg1);
                        break;
                    case 4:
                        Stats.this.performBitmapTransformed((long) msg.arg1);
                        break;
                    default:
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                throw new AssertionError("Unhandled stats message." + msg.what);
                            }
                        });
                        break;
                }
            }
        }
    }
}
