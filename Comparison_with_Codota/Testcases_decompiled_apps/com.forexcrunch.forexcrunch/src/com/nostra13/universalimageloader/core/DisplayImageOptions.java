package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public final class DisplayImageOptions {
    /* access modifiers changed from: private */
    public final Bitmap.Config bitmapConfig;
    /* access modifiers changed from: private */
    public final boolean cacheInMemory;
    /* access modifiers changed from: private */
    public final boolean cacheOnDisc;
    /* access modifiers changed from: private */
    public final int delayBeforeLoading;
    /* access modifiers changed from: private */
    public final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    /* access modifiers changed from: private */
    public final int imageForEmptyUri;
    private final int imageOnFail;
    /* access modifiers changed from: private */
    public final ImageScaleType imageScaleType;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    /* access modifiers changed from: private */
    public final boolean resetViewBeforeLoading;
    /* access modifiers changed from: private */
    public final int stubImage;

    private DisplayImageOptions(Builder builder) {
        this.stubImage = builder.stubImage;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisc = builder.cacheOnDisc;
        this.imageScaleType = builder.imageScaleType;
        this.bitmapConfig = builder.bitmapConfig;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowStubImage() {
        return this.stubImage != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowImageForEmptyUri() {
        return this.imageForEmptyUri != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowImageOnFail() {
        return this.imageOnFail != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    /* access modifiers changed from: package-private */
    public int getStubImage() {
        return this.stubImage;
    }

    /* access modifiers changed from: package-private */
    public int getImageForEmptyUri() {
        return this.imageForEmptyUri;
    }

    /* access modifiers changed from: package-private */
    public int getImageOnFail() {
        return this.imageOnFail;
    }

    /* access modifiers changed from: package-private */
    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    /* access modifiers changed from: package-private */
    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    /* access modifiers changed from: package-private */
    public boolean isCacheOnDisc() {
        return this.cacheOnDisc;
    }

    /* access modifiers changed from: package-private */
    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    /* access modifiers changed from: package-private */
    public Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    /* access modifiers changed from: package-private */
    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    /* access modifiers changed from: package-private */
    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    /* access modifiers changed from: package-private */
    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    /* access modifiers changed from: package-private */
    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    /* access modifiers changed from: package-private */
    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Bitmap.Config bitmapConfig = Bitmap.Config.ARGB_8888;
        /* access modifiers changed from: private */
        public boolean cacheInMemory = false;
        /* access modifiers changed from: private */
        public boolean cacheOnDisc = false;
        /* access modifiers changed from: private */
        public int delayBeforeLoading = 0;
        /* access modifiers changed from: private */
        public BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        /* access modifiers changed from: private */
        public Object extraForDownloader = null;
        /* access modifiers changed from: private */
        public int imageForEmptyUri = 0;
        /* access modifiers changed from: private */
        public int imageOnFail = 0;
        /* access modifiers changed from: private */
        public ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        /* access modifiers changed from: private */
        public BitmapProcessor postProcessor = null;
        /* access modifiers changed from: private */
        public BitmapProcessor preProcessor = null;
        /* access modifiers changed from: private */
        public boolean resetViewBeforeLoading = false;
        /* access modifiers changed from: private */
        public int stubImage = 0;

        public Builder showStubImage(int stubImageRes) {
            this.stubImage = stubImageRes;
            return this;
        }

        public Builder showImageForEmptyUri(int imageRes) {
            this.imageForEmptyUri = imageRes;
            return this;
        }

        public Builder showImageOnFail(int imageRes) {
            this.imageOnFail = imageRes;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        public Builder cacheOnDisc() {
            this.cacheOnDisc = true;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType2) {
            this.imageScaleType = imageScaleType2;
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config bitmapConfig2) {
            this.bitmapConfig = bitmapConfig2;
            return this;
        }

        public Builder delayBeforeLoading(int delayInMillis) {
            this.delayBeforeLoading = delayInMillis;
            return this;
        }

        public Builder extraForDownloader(Object extra) {
            this.extraForDownloader = extra;
            return this;
        }

        public Builder preProcessor(BitmapProcessor preProcessor2) {
            this.preProcessor = preProcessor2;
            return this;
        }

        public Builder postProcessor(BitmapProcessor postProcessor2) {
            this.postProcessor = postProcessor2;
            return this;
        }

        public Builder displayer(BitmapDisplayer displayer2) {
            this.displayer = displayer2;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions options) {
            this.stubImage = options.stubImage;
            this.imageForEmptyUri = options.imageForEmptyUri;
            this.resetViewBeforeLoading = options.resetViewBeforeLoading;
            this.cacheInMemory = options.cacheInMemory;
            this.cacheOnDisc = options.cacheOnDisc;
            this.imageScaleType = options.imageScaleType;
            this.bitmapConfig = options.bitmapConfig;
            this.delayBeforeLoading = options.delayBeforeLoading;
            this.displayer = options.displayer;
            return this;
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }
}
