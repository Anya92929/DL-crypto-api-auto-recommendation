package com.google.android.imageloader;

import android.content.ContentResolver;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

class ContentURLStreamHandler extends URLStreamHandler {
    private final ContentResolver mResolver;

    public ContentURLStreamHandler(ContentResolver resolver) {
        if (resolver == null) {
            throw new NullPointerException();
        }
        this.mResolver = resolver;
    }

    /* access modifiers changed from: protected */
    public URLConnection openConnection(URL url) {
        return new ContentURLConnection(this.mResolver, url);
    }
}
