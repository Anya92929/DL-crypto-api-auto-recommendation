package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.C0847L;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

class ImageDecoder {
    private final DisplayImageOptions displayOptions;
    private final ImageDownloader imageDownloader;
    private final URI imageUri;
    private boolean loggingEnabled;

    ImageDecoder(URI imageUri2, ImageDownloader imageDownloader2, DisplayImageOptions options) {
        this.imageUri = imageUri2;
        this.imageDownloader = imageDownloader2;
        this.displayOptions = options;
    }

    public Bitmap decode(ImageSize targetSize, ImageScaleType scaleType, ViewScaleType viewScaleType) throws IOException {
        BitmapFactory.Options decodeOptions = getBitmapOptionsForImageDecoding(targetSize, scaleType, viewScaleType);
        InputStream imageStream = this.imageDownloader.getStream(this.imageUri, this.displayOptions.getExtraForDownloader());
        try {
            Bitmap subsampledBitmap = BitmapFactory.decodeStream(imageStream, (Rect) null, decodeOptions);
            if (subsampledBitmap == null) {
                log("Image can't be decoded [%s]", this.imageUri);
                return null;
            }
            if (scaleType == ImageScaleType.EXACTLY || scaleType == ImageScaleType.EXACTLY_STRETCHED) {
                subsampledBitmap = scaleImageExactly(subsampledBitmap, targetSize, scaleType, viewScaleType);
            }
            return subsampledBitmap;
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    private BitmapFactory.Options getBitmapOptionsForImageDecoding(ImageSize targetSize, ImageScaleType scaleType, ViewScaleType viewScaleType) throws IOException {
        BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
        decodeOptions.inSampleSize = scaleType == ImageScaleType.NONE ? 1 : computeImageScale(targetSize, scaleType, viewScaleType);
        decodeOptions.inPreferredConfig = this.displayOptions.getBitmapConfig();
        return decodeOptions;
    }

    /* JADX INFO: finally extract failed */
    private int computeImageScale(ImageSize targetSize, ImageScaleType scaleType, ViewScaleType viewScaleType) throws IOException {
        int targetWidth = targetSize.getWidth();
        int targetHeight = targetSize.getHeight();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream imageStream = this.imageDownloader.getStream(this.imageUri, this.displayOptions.getExtraForDownloader());
        try {
            BitmapFactory.decodeStream(imageStream, (Rect) null, options);
            IoUtils.closeSilently(imageStream);
            int scale = 1;
            int imageWidth = options.outWidth;
            int imageHeight = options.outHeight;
            int widthScale = imageWidth / targetWidth;
            int heightScale = imageHeight / targetHeight;
            if (viewScaleType == ViewScaleType.FIT_INSIDE) {
                if (scaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
                    while (true) {
                        if (imageWidth / 2 < targetWidth && imageHeight / 2 < targetHeight) {
                            break;
                        }
                        imageWidth /= 2;
                        imageHeight /= 2;
                        scale *= 2;
                    }
                } else {
                    scale = Math.max(widthScale, heightScale);
                }
            } else if (scaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
                while (imageWidth / 2 >= targetWidth && imageHeight / 2 >= targetHeight) {
                    imageWidth /= 2;
                    imageHeight /= 2;
                    scale *= 2;
                }
            } else {
                scale = Math.min(widthScale, heightScale);
            }
            if (scale < 1) {
                scale = 1;
            }
            log("Original image (%1$dx%2$d) is going to be subsampled to %3$dx%4$d view. Computed scale size - %5$d", Integer.valueOf(imageWidth), Integer.valueOf(imageHeight), Integer.valueOf(targetWidth), Integer.valueOf(targetHeight), Integer.valueOf(scale));
            return scale;
        } catch (Throwable th) {
            IoUtils.closeSilently(imageStream);
            throw th;
        }
    }

    private Bitmap scaleImageExactly(Bitmap subsampledBitmap, ImageSize targetSize, ImageScaleType scaleType, ViewScaleType viewScaleType) {
        int destWidth;
        int destHeight;
        float srcWidth = (float) subsampledBitmap.getWidth();
        float srcHeight = (float) subsampledBitmap.getHeight();
        float widthScale = srcWidth / ((float) targetSize.getWidth());
        float heightScale = srcHeight / ((float) targetSize.getHeight());
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || widthScale < heightScale) && (viewScaleType != ViewScaleType.CROP || widthScale >= heightScale)) {
            destWidth = (int) (srcWidth / heightScale);
            destHeight = targetSize.getHeight();
        } else {
            destWidth = targetSize.getWidth();
            destHeight = (int) (srcHeight / widthScale);
        }
        if ((scaleType != ImageScaleType.EXACTLY || ((float) destWidth) >= srcWidth || ((float) destHeight) >= srcHeight) && (scaleType != ImageScaleType.EXACTLY_STRETCHED || ((float) destWidth) == srcWidth || ((float) destHeight) == srcHeight)) {
            return subsampledBitmap;
        }
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(subsampledBitmap, destWidth, destHeight, true);
        if (scaledBitmap != subsampledBitmap) {
            subsampledBitmap.recycle();
        }
        log("Subsampled image (%1$dx%2$d) was scaled to %3$dx%4$d", Integer.valueOf((int) srcWidth), Integer.valueOf((int) srcHeight), Integer.valueOf(destWidth), Integer.valueOf(destHeight));
        return scaledBitmap;
    }

    /* access modifiers changed from: package-private */
    public void setLoggingEnabled(boolean loggingEnabled2) {
        this.loggingEnabled = loggingEnabled2;
    }

    private void log(String message, Object... args) {
        if (this.loggingEnabled) {
            C0847L.m2149i(message, args);
        }
    }
}
