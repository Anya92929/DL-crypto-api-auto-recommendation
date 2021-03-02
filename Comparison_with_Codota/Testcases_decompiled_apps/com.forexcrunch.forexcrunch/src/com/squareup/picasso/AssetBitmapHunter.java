package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

class AssetBitmapHunter extends BitmapHunter {
    private AssetManager assetManager;

    public AssetBitmapHunter(Context context, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        super(picasso, dispatcher, cache, stats, action);
        this.assetManager = context.getAssets();
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        return decodeAsset(data.uri.toString().substring(ASSET_PREFIX_LENGTH));
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return Picasso.LoadedFrom.DISK;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public Bitmap decodeAsset(String filePath) throws IOException {
        BitmapFactory.Options options = null;
        if (this.data.hasSize()) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream is = null;
            try {
                is = this.assetManager.open(filePath);
                BitmapFactory.decodeStream(is, (Rect) null, options);
                Utils.closeQuietly(is);
                calculateInSampleSize(this.data.targetWidth, this.data.targetHeight, options);
            } catch (Throwable th) {
                Utils.closeQuietly(is);
                throw th;
            }
        }
        InputStream is2 = this.assetManager.open(filePath);
        try {
            return BitmapFactory.decodeStream(is2, (Rect) null, options);
        } finally {
            Utils.closeQuietly(is2);
        }
    }
}
