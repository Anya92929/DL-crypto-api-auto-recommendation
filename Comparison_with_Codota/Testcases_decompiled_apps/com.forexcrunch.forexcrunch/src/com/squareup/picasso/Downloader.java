package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface Downloader {
    Response load(Uri uri, boolean z) throws IOException;

    public static class Response {
        final Bitmap bitmap;
        final boolean cached;
        final InputStream stream;

        public Response(Bitmap bitmap2, boolean loadedFromCache) {
            if (bitmap2 == null) {
                throw new IllegalArgumentException("Bitmap may not be null.");
            }
            this.stream = null;
            this.bitmap = bitmap2;
            this.cached = loadedFromCache;
        }

        public Response(InputStream stream2, boolean loadedFromCache) {
            if (stream2 == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.stream = stream2;
            this.bitmap = null;
            this.cached = loadedFromCache;
        }

        public InputStream getInputStream() {
            return this.stream;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }
    }
}
