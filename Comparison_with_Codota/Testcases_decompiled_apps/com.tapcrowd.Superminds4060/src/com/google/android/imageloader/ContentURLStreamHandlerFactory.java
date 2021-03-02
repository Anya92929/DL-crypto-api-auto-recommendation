package com.google.android.imageloader;

import android.content.ContentResolver;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class ContentURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ContentResolver mResolver;

    public ContentURLStreamHandlerFactory(ContentResolver resolver) {
        if (resolver == null) {
            throw new NullPointerException();
        }
        this.mResolver = resolver;
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        if ("content".equals(protocol) || "file".equals(protocol) || "android.resource".equals(protocol)) {
            return new ContentURLStreamHandler(this.mResolver);
        }
        return null;
    }
}
