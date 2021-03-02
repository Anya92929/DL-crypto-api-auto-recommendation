package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

class ContentStreamBitmapHunter extends BitmapHunter {
    final Context context;

    ContentStreamBitmapHunter(Context context2, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        super(picasso, dispatcher, cache, stats, action);
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        return decodeContentStream(data);
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return Picasso.LoadedFrom.DISK;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public Bitmap decodeContentStream(Request data) throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        BitmapFactory.Options options = null;
        if (data.hasSize()) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream is = null;
            try {
                is = contentResolver.openInputStream(data.uri);
                BitmapFactory.decodeStream(is, (Rect) null, options);
                Utils.closeQuietly(is);
                calculateInSampleSize(data.targetWidth, data.targetHeight, options);
            } catch (Throwable th) {
                Utils.closeQuietly(is);
                throw th;
            }
        }
        InputStream is2 = contentResolver.openInputStream(data.uri);
        try {
            return BitmapFactory.decodeStream(is2, (Rect) null, options);
        } finally {
            Utils.closeQuietly(is2);
        }
    }
}
