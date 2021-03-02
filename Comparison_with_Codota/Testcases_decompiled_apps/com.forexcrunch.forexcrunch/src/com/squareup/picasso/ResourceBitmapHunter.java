package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Picasso;
import java.io.IOException;

class ResourceBitmapHunter extends BitmapHunter {
    private final Context context;

    ResourceBitmapHunter(Context context2, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        super(picasso, dispatcher, cache, stats, action);
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        return decodeResource(this.context.getResources(), data);
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return Picasso.LoadedFrom.DISK;
    }

    private Bitmap decodeResource(Resources resources, Request data) {
        int resourceId = data.resourceId;
        BitmapFactory.Options bitmapOptions = null;
        if (data.hasSize()) {
            bitmapOptions = new BitmapFactory.Options();
            bitmapOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, resourceId, bitmapOptions);
            calculateInSampleSize(data.targetWidth, data.targetHeight, bitmapOptions);
        }
        return BitmapFactory.decodeResource(resources, resourceId, bitmapOptions);
    }
}
