package com.google.android.imageloader;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;

class BitmapCache<K> extends LinkedHashMap<K, Bitmap> {
    private static final long BYTES_PER_PIXEL = 4;
    private static final int INITIAL_CAPACITY = 32;
    private static final float LOAD_FACTOR = 0.75f;
    private final long mMaxBytes;
    private boolean mRemove;

    public BitmapCache(long maxBytes) {
        super(32, LOAD_FACTOR, true);
        this.mMaxBytes = maxBytes;
    }

    static long sizeOf(Bitmap b) {
        return ((long) (b.getWidth() * b.getHeight())) * BYTES_PER_PIXEL;
    }

    private static long sizeOf(Iterable<Bitmap> bitmaps) {
        long total = 0;
        for (Bitmap bitmap : bitmaps) {
            total += sizeOf(bitmap);
        }
        return total;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, Bitmap> entry) {
        return this.mRemove;
    }

    /* JADX INFO: finally extract failed */
    private void trimEldest() {
        super.remove((Object) null);
        this.mRemove = true;
        try {
            super.put((Object) null, (Object) null);
            this.mRemove = false;
            super.remove((Object) null);
        } catch (Throwable th) {
            this.mRemove = false;
            throw th;
        }
    }

    private void trim() {
        while (sizeOf((Iterable<Bitmap>) values()) > this.mMaxBytes) {
            trimEldest();
        }
    }

    private NullPointerException nullKeyException() {
        return new NullPointerException("Key is null");
    }

    public Bitmap put(K key, Bitmap value) {
        if (key == null) {
            throw nullKeyException();
        }
        try {
            return (Bitmap) super.put(key, value);
        } finally {
            trim();
        }
    }

    public void putAll(Map<? extends K, ? extends Bitmap> map) {
        if (map.containsKey((Object) null)) {
            throw nullKeyException();
        }
        try {
            super.putAll(map);
        } finally {
            trim();
        }
    }

    public Bitmap get(Object key) {
        if (key != null) {
            return (Bitmap) super.get(key);
        }
        throw nullKeyException();
    }

    public boolean containsKey(Object key) {
        if (key != null) {
            return super.containsKey(key);
        }
        throw nullKeyException();
    }

    public Bitmap remove(Object key) {
        if (key != null) {
            return (Bitmap) super.remove(key);
        }
        throw nullKeyException();
    }
}
