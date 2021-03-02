package com.tapcrowd.app.utils.images;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryCache {
    private Map<String, Bitmap> cache = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
    private long limit = 1000000;
    private long size = 0;

    public MemoryCache() {
        setLimit(Runtime.getRuntime().maxMemory() / 4);
    }

    public void setLimit(long new_limit) {
        this.limit = new_limit;
    }

    public Bitmap get(String id) {
        try {
            if (!this.cache.containsKey(id)) {
                return null;
            }
            return this.cache.get(id);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void put(String id, Bitmap bitmap) {
        try {
            if (this.cache.containsKey(id)) {
                this.size -= getSizeInBytes(this.cache.get(id));
            }
            this.cache.put(id, bitmap);
            this.size += getSizeInBytes(bitmap);
            checkSize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void checkSize() {
        if (this.size > this.limit) {
            Iterator<Map.Entry<String, Bitmap>> iter = this.cache.entrySet().iterator();
            while (iter.hasNext()) {
                this.size -= getSizeInBytes(iter.next().getValue());
                iter.remove();
                if (this.size <= this.limit) {
                    return;
                }
            }
        }
    }

    public void clear() {
        try {
            this.cache.clear();
            this.size = 0;
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public long getSizeInBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return (long) (bitmap.getRowBytes() * bitmap.getHeight());
    }
}
