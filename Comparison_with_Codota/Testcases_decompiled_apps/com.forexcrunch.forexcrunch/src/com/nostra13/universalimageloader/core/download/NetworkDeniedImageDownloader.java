package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class NetworkDeniedImageDownloader implements ImageDownloader {
    private final ImageDownloader wrappedDownloader;

    public NetworkDeniedImageDownloader(ImageDownloader wrappedDownloader2) {
        this.wrappedDownloader = wrappedDownloader2;
    }

    public InputStream getStream(URI imageUri, Object extra) throws IOException {
        String scheme = imageUri.getScheme();
        if (!ImageDownloader.SCHEME_HTTP.equals(scheme) && !ImageDownloader.SCHEME_HTTPS.equals(scheme)) {
            return this.wrappedDownloader.getStream(imageUri, extra);
        }
        throw new IllegalStateException();
    }
}
