package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

class NetworkBitmapHunter extends BitmapHunter {
    static final int DEFAULT_RETRY_COUNT = 2;
    private static final int MARKER = 65536;
    private final Downloader downloader;
    int retryCount = 2;

    public NetworkBitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, Downloader downloader2) {
        super(picasso, dispatcher, cache, stats, action);
        this.downloader = downloader2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        Downloader.Response response = this.downloader.load(data.uri, this.retryCount == 0);
        if (response == null) {
            return null;
        }
        this.loadedFrom = response.cached ? Picasso.LoadedFrom.DISK : Picasso.LoadedFrom.NETWORK;
        Bitmap result = response.getBitmap();
        if (result != null) {
            return result;
        }
        InputStream is = response.getInputStream();
        try {
            return decodeStream(is, data);
        } finally {
            Utils.closeQuietly(is);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
        boolean hasRetries;
        if (this.retryCount > 0) {
            hasRetries = true;
        } else {
            hasRetries = false;
        }
        if (!hasRetries) {
            return false;
        }
        this.retryCount--;
        if (info == null || info.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    private Bitmap decodeStream(InputStream stream, Request data) throws IOException {
        if (stream == null) {
            return null;
        }
        BitmapFactory.Options options = null;
        if (data.hasSize()) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            MarkableInputStream markStream = new MarkableInputStream(stream);
            stream = markStream;
            long mark = markStream.savePosition(65536);
            BitmapFactory.decodeStream(stream, (Rect) null, options);
            calculateInSampleSize(data.targetWidth, data.targetHeight, options);
            markStream.reset(mark);
        }
        return BitmapFactory.decodeStream(stream, (Rect) null, options);
    }
}
