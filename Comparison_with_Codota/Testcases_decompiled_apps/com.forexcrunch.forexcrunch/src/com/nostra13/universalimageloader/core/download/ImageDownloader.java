package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public interface ImageDownloader {
    public static final String SCHEME_ASSETS = "assets";
    public static final String SCHEME_CONTENT = "content";
    public static final String SCHEME_DRAWABLE = "drawable";
    public static final String SCHEME_FILE = "file";
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";

    InputStream getStream(URI uri, Object obj) throws IOException;
}
