package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.ContactsContract;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

abstract class BitmapHunter implements Runnable {
    private static final String ANDROID_ASSET = "android_asset";
    protected static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    private static final Object DECODE_LOCK = new Object();
    final List<Action> actions = new ArrayList(4);
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifRotation;
    Future<?> future;
    final String key;
    Picasso.LoadedFrom loadedFrom;
    final Picasso picasso;
    Bitmap result;
    final boolean skipMemoryCache;
    final Stats stats;

    /* access modifiers changed from: package-private */
    public abstract Bitmap decode(Request request) throws IOException;

    BitmapHunter(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action) {
        this.picasso = picasso2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.stats = stats2;
        this.key = action.getKey();
        this.data = action.getData();
        this.skipMemoryCache = action.skipCache;
        attach(action);
    }

    /* access modifiers changed from: protected */
    public void setExifRotation(int exifRotation2) {
        this.exifRotation = exifRotation2;
    }

    public void run() {
        String str;
        try {
            Thread.currentThread().setName("Picasso-" + this.data.getName());
            this.result = hunt();
            if (this.result == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (IOException e) {
            this.exception = e;
            this.dispatcher.dispatchRetry(this);
        } finally {
            str = "Picasso-Idle";
            Thread.currentThread().setName(str);
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap hunt() throws IOException {
        Bitmap bitmap;
        if (this.skipMemoryCache || (bitmap = this.cache.get(this.key)) == null) {
            Bitmap bitmap2 = decode(this.data);
            if (bitmap2 != null) {
                this.stats.dispatchBitmapDecoded(bitmap2);
                if (this.data.needsTransformation()) {
                    synchronized (DECODE_LOCK) {
                        if (this.data.needsMatrixTransform() || this.exifRotation != 0) {
                            bitmap2 = transformResult(this.data, bitmap2, this.exifRotation);
                        }
                        if (this.data.hasCustomTransformations()) {
                            bitmap2 = applyCustomTransformations(this.data.transformations, bitmap2);
                        }
                    }
                    this.stats.dispatchBitmapTransformed(bitmap2);
                }
            }
            return bitmap2;
        }
        this.stats.dispatchCacheHit();
        this.loadedFrom = Picasso.LoadedFrom.MEMORY;
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public void attach(Action action) {
        this.actions.add(action);
    }

    /* access modifiers changed from: package-private */
    public void detach(Action action) {
        this.actions.remove(action);
    }

    /* access modifiers changed from: package-private */
    public boolean cancel() {
        return this.actions.isEmpty() && this.future != null && this.future.cancel(false);
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this.future != null && this.future.isCancelled();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldSkipMemoryCache() {
        return this.skipMemoryCache;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getResult() {
        return this.result;
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public Request getData() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public List<Action> getActions() {
        return this.actions;
    }

    /* access modifiers changed from: package-private */
    public Exception getException() {
        return this.exception;
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    static BitmapHunter forRequest(Context context, Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action, Downloader downloader) {
        if (action.getData().resourceId != 0) {
            return new ResourceBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
        }
        Uri uri = action.getData().uri;
        String scheme = uri.getScheme();
        if (ImageDownloader.SCHEME_CONTENT.equals(scheme)) {
            if (!ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) || uri.getPathSegments().contains("photo")) {
                return new ContentProviderBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
            }
            return new ContactsPhotoBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
        } else if (ImageDownloader.SCHEME_FILE.equals(scheme)) {
            if (ANDROID_ASSET.equals(uri.getPathSegments().get(0))) {
                return new AssetBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
            }
            return new FileBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
        } else if ("android.resource".equals(scheme)) {
            return new ResourceBitmapHunter(context, picasso2, dispatcher2, cache2, stats2, action);
        } else {
            return new NetworkBitmapHunter(picasso2, dispatcher2, cache2, stats2, action, downloader);
        }
    }

    static void calculateInSampleSize(int reqWidth, int reqHeight, BitmapFactory.Options options) {
        int height = options.outHeight;
        int width = options.outWidth;
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int heightRatio = Math.round(((float) height) / ((float) reqHeight));
            int widthRatio = Math.round(((float) width) / ((float) reqWidth));
            if (heightRatio < widthRatio) {
                sampleSize = heightRatio;
            } else {
                sampleSize = widthRatio;
            }
        }
        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
    }

    static Bitmap applyCustomTransformations(List<Transformation> transformations, Bitmap result2) {
        int i = 0;
        int count = transformations.size();
        while (i < count) {
            Transformation transformation = transformations.get(i);
            Bitmap newResult = transformation.transform(result2);
            if (newResult == null) {
                StringBuilder builder = new StringBuilder().append("Transformation ").append(transformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                for (Transformation t : transformations) {
                    builder.append(t.key()).append(10);
                }
                throw new NullPointerException(builder.toString());
            } else if (newResult == result2 && result2.isRecycled()) {
                throw new IllegalStateException("Transformation " + transformation.key() + " returned input Bitmap but recycled it.");
            } else if (newResult == result2 || result2.isRecycled()) {
                result2 = newResult;
                i++;
            } else {
                throw new IllegalStateException("Transformation " + transformation.key() + " mutated input Bitmap but failed to recycle the original.");
            }
        }
        return result2;
    }

    static Bitmap transformResult(Request data2, Bitmap result2, int exifRotation2) {
        float scale;
        float scale2;
        int inWidth = result2.getWidth();
        int inHeight = result2.getHeight();
        int drawX = 0;
        int drawY = 0;
        int drawWidth = inWidth;
        int drawHeight = inHeight;
        Matrix matrix = new Matrix();
        if (data2.needsMatrixTransform()) {
            int targetWidth = data2.targetWidth;
            int targetHeight = data2.targetHeight;
            float targetRotation = data2.rotationDegrees;
            if (targetRotation != BitmapDescriptorFactory.HUE_RED) {
                if (data2.hasRotationPivot) {
                    matrix.setRotate(targetRotation, data2.rotationPivotX, data2.rotationPivotY);
                } else {
                    matrix.setRotate(targetRotation);
                }
            }
            if (data2.centerCrop) {
                float widthRatio = ((float) targetWidth) / ((float) inWidth);
                float heightRatio = ((float) targetHeight) / ((float) inHeight);
                if (widthRatio > heightRatio) {
                    scale2 = widthRatio;
                    int newSize = (int) Math.ceil((double) (((float) inHeight) * (heightRatio / widthRatio)));
                    drawY = (inHeight - newSize) / 2;
                    drawHeight = newSize;
                } else {
                    scale2 = heightRatio;
                    int newSize2 = (int) Math.ceil((double) (((float) inWidth) * (widthRatio / heightRatio)));
                    drawX = (inWidth - newSize2) / 2;
                    drawWidth = newSize2;
                }
                matrix.preScale(scale2, scale2);
            } else if (data2.centerInside) {
                float widthRatio2 = ((float) targetWidth) / ((float) inWidth);
                float heightRatio2 = ((float) targetHeight) / ((float) inHeight);
                if (widthRatio2 < heightRatio2) {
                    scale = widthRatio2;
                } else {
                    scale = heightRatio2;
                }
                matrix.preScale(scale, scale);
            } else if (!(targetWidth == 0 || targetHeight == 0 || (targetWidth == inWidth && targetHeight == inHeight))) {
                matrix.preScale(((float) targetWidth) / ((float) inWidth), ((float) targetHeight) / ((float) inHeight));
            }
        }
        if (exifRotation2 != 0) {
            matrix.preRotate((float) exifRotation2);
        }
        Bitmap newResult = Bitmap.createBitmap(result2, drawX, drawY, drawWidth, drawHeight, matrix, true);
        if (newResult == result2) {
            return result2;
        }
        result2.recycle();
        return newResult;
    }
}
