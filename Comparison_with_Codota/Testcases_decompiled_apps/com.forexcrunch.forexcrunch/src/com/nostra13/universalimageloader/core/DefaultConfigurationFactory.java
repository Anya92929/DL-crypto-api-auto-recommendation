package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class DefaultConfigurationFactory {
    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static DiscCacheAware createDiscCache(Context context, FileNameGenerator discCacheFileNameGenerator, int discCacheSize, int discCacheFileCount) {
        if (discCacheSize > 0) {
            return new TotalSizeLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(context), discCacheFileNameGenerator, discCacheSize);
        }
        if (discCacheFileCount > 0) {
            return new FileCountLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(context), discCacheFileNameGenerator, discCacheFileCount);
        }
        return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(context), discCacheFileNameGenerator);
    }

    public static MemoryCacheAware<String, Bitmap> createMemoryCache(int memoryCacheSize, boolean denyCacheImageMultipleSizesInMemory) {
        MemoryCacheAware<String, Bitmap> memoryCache = new UsingFreqLimitedMemoryCache(memoryCacheSize);
        if (denyCacheImageMultipleSizesInMemory) {
            return new FuzzyKeyMemoryCache<>(memoryCache, MemoryCacheUtil.createFuzzyKeyComparator());
        }
        return memoryCache;
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }
}
