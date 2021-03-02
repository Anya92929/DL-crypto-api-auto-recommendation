package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.NetworkDeniedImageDownloader;
import com.nostra13.universalimageloader.utils.C0847L;
import java.util.concurrent.ThreadFactory;

public final class ImageLoaderConfiguration {
    final Context context;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiscCacheAware discCache;
    final ThreadFactory displayImageThreadFactory;
    final ImageDownloader downloader;
    final boolean handleOutOfMemory;
    final Bitmap.CompressFormat imageCompressFormatForDiscCache;
    final int imageQualityForDiscCache;
    final boolean loggingEnabled;
    final int maxImageHeightForDiscCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiscCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCacheAware<String, Bitmap> memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;

    private ImageLoaderConfiguration(final Builder builder) {
        this.context = builder.context;
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiscCache = builder.maxImageWidthForDiscCache;
        this.maxImageHeightForDiscCache = builder.maxImageHeightForDiscCache;
        this.imageCompressFormatForDiscCache = builder.imageCompressFormatForDiscCache;
        this.imageQualityForDiscCache = builder.imageQualityForDiscCache;
        this.threadPoolSize = builder.threadPoolSize;
        this.handleOutOfMemory = builder.handleOutOfMemory;
        this.discCache = builder.discCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.loggingEnabled = builder.loggingEnabled;
        this.downloader = builder.downloader;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.displayImageThreadFactory = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setPriority(builder.threadPriority);
                return t;
            }
        };
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(this.downloader);
    }

    public static ImageLoaderConfiguration createDefault(Context context2) {
        return new Builder(context2).build();
    }

    public static class Builder {
        public static final int DEFAULT_MEMORY_CACHE_SIZE = 2097152;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 4;
        private static final String WARNING_DISC_CACHE_ALREADY_SET = "You already have set disc cache. This method call will make no effect.";
        private static final String WARNING_MEMORY_CACHE_ALREADY_SET = "You already have set memory cache. This method call will make no effect.";
        private static final String WARNING_OVERLAP_DISC_CACHE_FILE_COUNT = "This method's call overlaps discCacheFileCount() method call";
        private static final String WARNING_OVERLAP_DISC_CACHE_FILE_NAME_GENERATOR = "This method's call overlaps discCacheFileNameGenerator() method call";
        private static final String WARNING_OVERLAP_DISC_CACHE_SIZE = "This method's call overlaps discCacheSize() method call";
        private static final String WARNING_OVERLAP_MEMORY_CACHE_SIZE = "This method's call overlaps memoryCacheSize() method call";
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        /* access modifiers changed from: private */
        public DiscCacheAware discCache = null;
        private int discCacheFileCount = 0;
        private FileNameGenerator discCacheFileNameGenerator = null;
        private int discCacheSize = 0;
        /* access modifiers changed from: private */
        public ImageDownloader downloader = null;
        /* access modifiers changed from: private */
        public boolean handleOutOfMemory = true;
        /* access modifiers changed from: private */
        public Bitmap.CompressFormat imageCompressFormatForDiscCache = null;
        /* access modifiers changed from: private */
        public int imageQualityForDiscCache = 0;
        /* access modifiers changed from: private */
        public boolean loggingEnabled = false;
        /* access modifiers changed from: private */
        public int maxImageHeightForDiscCache = 0;
        /* access modifiers changed from: private */
        public int maxImageHeightForMemoryCache = 0;
        /* access modifiers changed from: private */
        public int maxImageWidthForDiscCache = 0;
        /* access modifiers changed from: private */
        public int maxImageWidthForMemoryCache = 0;
        /* access modifiers changed from: private */
        public MemoryCacheAware<String, Bitmap> memoryCache = null;
        private int memoryCacheSize = 2097152;
        /* access modifiers changed from: private */
        public QueueProcessingType tasksProcessingType = QueueProcessingType.FIFO;
        /* access modifiers changed from: private */
        public int threadPoolSize = 3;
        /* access modifiers changed from: private */
        public int threadPriority = 4;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Builder memoryCacheExtraOptions(int maxImageWidthForMemoryCache2, int maxImageHeightForMemoryCache2) {
            this.maxImageWidthForMemoryCache = maxImageWidthForMemoryCache2;
            this.maxImageHeightForMemoryCache = maxImageHeightForMemoryCache2;
            return this;
        }

        public Builder discCacheExtraOptions(int maxImageWidthForDiscCache2, int maxImageHeightForDiscCache2, Bitmap.CompressFormat compressFormat, int compressQuality) {
            this.maxImageWidthForDiscCache = maxImageWidthForDiscCache2;
            this.maxImageHeightForDiscCache = maxImageHeightForDiscCache2;
            this.imageCompressFormatForDiscCache = compressFormat;
            this.imageQualityForDiscCache = compressQuality;
            return this;
        }

        public Builder threadPoolSize(int threadPoolSize2) {
            this.threadPoolSize = threadPoolSize2;
            return this;
        }

        public Builder threadPriority(int threadPriority2) {
            if (threadPriority2 < 1) {
                this.threadPriority = 1;
            } else if (threadPriority2 <= 10) {
                this.threadPriority = threadPriority2;
            }
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        public Builder offOutOfMemoryHandling() {
            this.handleOutOfMemory = false;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType tasksProcessingType2) {
            this.tasksProcessingType = tasksProcessingType2;
            return this;
        }

        public Builder memoryCacheSize(int memoryCacheSize2) {
            if (memoryCacheSize2 <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.memoryCache != null) {
                C0847L.m2150w(WARNING_MEMORY_CACHE_ALREADY_SET, new Object[0]);
            }
            this.memoryCacheSize = memoryCacheSize2;
            return this;
        }

        public Builder memoryCache(MemoryCacheAware<String, Bitmap> memoryCache2) {
            if (this.memoryCacheSize != 2097152) {
                C0847L.m2150w(WARNING_OVERLAP_MEMORY_CACHE_SIZE, new Object[0]);
            }
            this.memoryCache = memoryCache2;
            return this;
        }

        public Builder discCacheSize(int maxCacheSize) {
            if (maxCacheSize <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.discCache != null) {
                C0847L.m2150w(WARNING_DISC_CACHE_ALREADY_SET, new Object[0]);
            }
            if (this.discCacheFileCount > 0) {
                C0847L.m2150w(WARNING_OVERLAP_DISC_CACHE_FILE_COUNT, new Object[0]);
            }
            this.discCacheSize = maxCacheSize;
            return this;
        }

        public Builder discCacheFileCount(int maxFileCount) {
            if (maxFileCount <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.discCache != null) {
                C0847L.m2150w(WARNING_DISC_CACHE_ALREADY_SET, new Object[0]);
            }
            if (this.discCacheSize > 0) {
                C0847L.m2150w(WARNING_OVERLAP_DISC_CACHE_SIZE, new Object[0]);
            }
            this.discCacheSize = 0;
            this.discCacheFileCount = maxFileCount;
            return this;
        }

        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.discCache != null) {
                C0847L.m2150w(WARNING_DISC_CACHE_ALREADY_SET, new Object[0]);
            }
            this.discCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder discCache(DiscCacheAware discCache2) {
            if (this.discCacheSize > 0) {
                C0847L.m2150w(WARNING_OVERLAP_DISC_CACHE_SIZE, new Object[0]);
            }
            if (this.discCacheFileCount > 0) {
                C0847L.m2150w(WARNING_OVERLAP_DISC_CACHE_FILE_COUNT, new Object[0]);
            }
            if (this.discCacheFileNameGenerator != null) {
                C0847L.m2150w(WARNING_OVERLAP_DISC_CACHE_FILE_NAME_GENERATOR, new Object[0]);
            }
            this.discCache = discCache2;
            return this;
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions defaultDisplayImageOptions2) {
            this.defaultDisplayImageOptions = defaultDisplayImageOptions2;
            return this;
        }

        public Builder enableLogging() {
            this.loggingEnabled = true;
            return this;
        }

        public ImageLoaderConfiguration build() {
            initEmptyFiledsWithDefaultValues();
            return new ImageLoaderConfiguration(this);
        }

        private void initEmptyFiledsWithDefaultValues() {
            if (this.discCache == null) {
                if (this.discCacheFileNameGenerator == null) {
                    this.discCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.discCache = DefaultConfigurationFactory.createDiscCache(this.context, this.discCacheFileNameGenerator, this.discCacheSize, this.discCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.memoryCacheSize, this.denyCacheImageMultipleSizesInMemory);
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }
    }
}
