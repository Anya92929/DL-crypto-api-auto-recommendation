package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class LimitedDiscCache extends BaseDiscCache {
    private int cacheSize;
    private final Map<File, Long> lastUsageDates;
    private int sizeLimit;

    /* access modifiers changed from: protected */
    public abstract int getSize(File file);

    public LimitedDiscCache(File cacheDir, int sizeLimit2) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator(), sizeLimit2);
    }

    public LimitedDiscCache(File cacheDir, FileNameGenerator fileNameGenerator, int sizeLimit2) {
        super(cacheDir, fileNameGenerator);
        this.cacheSize = 0;
        this.lastUsageDates = Collections.synchronizedMap(new HashMap());
        this.sizeLimit = sizeLimit2;
        calculateCacheSizeAndFillUsageMap();
    }

    private void calculateCacheSizeAndFillUsageMap() {
        int size = 0;
        for (File cachedFile : this.cacheDir.listFiles()) {
            size += getSize(cachedFile);
            this.lastUsageDates.put(cachedFile, Long.valueOf(cachedFile.lastModified()));
        }
        this.cacheSize = size;
    }

    public void put(String key, File file) {
        int freedSize;
        int valueSize = getSize(file);
        while (this.cacheSize + valueSize > this.sizeLimit && (freedSize = removeNext()) != 0) {
            this.cacheSize -= freedSize;
        }
        this.cacheSize += valueSize;
        Long currentTime = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(currentTime.longValue());
        this.lastUsageDates.put(file, currentTime);
    }

    public File get(String key) {
        File file = super.get(key);
        Long currentTime = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(currentTime.longValue());
        this.lastUsageDates.put(file, currentTime);
        return file;
    }

    public void clear() {
        this.lastUsageDates.clear();
        this.cacheSize = 0;
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Long} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int removeNext() {
        /*
            r14 = this;
            java.util.Map<java.io.File, java.lang.Long> r8 = r14.lastUsageDates
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x000a
            r3 = 0
        L_0x0009:
            return r3
        L_0x000a:
            r7 = 0
            r6 = 0
            java.util.Map<java.io.File, java.lang.Long> r8 = r14.lastUsageDates
            java.util.Set r1 = r8.entrySet()
            java.util.Map<java.io.File, java.lang.Long> r9 = r14.lastUsageDates
            monitor-enter(r9)
            java.util.Iterator r4 = r1.iterator()     // Catch:{ all -> 0x0065 }
        L_0x0019:
            boolean r8 = r4.hasNext()     // Catch:{ all -> 0x0065 }
            if (r8 == 0) goto L_0x0054
            java.lang.Object r2 = r4.next()     // Catch:{ all -> 0x0065 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0065 }
            if (r6 != 0) goto L_0x0038
            java.lang.Object r8 = r2.getKey()     // Catch:{ all -> 0x0065 }
            r0 = r8
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0065 }
            r6 = r0
            java.lang.Object r8 = r2.getValue()     // Catch:{ all -> 0x0065 }
            r0 = r8
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0065 }
            r7 = r0
            goto L_0x0019
        L_0x0038:
            java.lang.Object r5 = r2.getValue()     // Catch:{ all -> 0x0065 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0065 }
            long r10 = r5.longValue()     // Catch:{ all -> 0x0065 }
            long r12 = r7.longValue()     // Catch:{ all -> 0x0065 }
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x0019
            r7 = r5
            java.lang.Object r8 = r2.getKey()     // Catch:{ all -> 0x0065 }
            r0 = r8
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0065 }
            r6 = r0
            goto L_0x0019
        L_0x0054:
            monitor-exit(r9)     // Catch:{ all -> 0x0065 }
            int r3 = r14.getSize(r6)
            boolean r8 = r6.delete()
            if (r8 == 0) goto L_0x0009
            java.util.Map<java.io.File, java.lang.Long> r8 = r14.lastUsageDates
            r8.remove(r6)
            goto L_0x0009
        L_0x0065:
            r8 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0065 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.LimitedDiscCache.removeNext():int");
    }
}
