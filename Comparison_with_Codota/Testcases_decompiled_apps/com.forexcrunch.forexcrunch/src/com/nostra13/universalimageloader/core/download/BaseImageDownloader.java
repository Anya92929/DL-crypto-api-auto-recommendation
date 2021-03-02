package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public class BaseImageDownloader implements ImageDownloader {
    protected static final int BUFFER_SIZE = 8192;
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme [%s] by default. You should implement this support byself";
    protected static final String SCHEME_ASSETS_PREFIX = "assets://";
    protected static final String SCHEME_DRAWABLE_PREFIX = "drawable://";
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context2) {
        this.context = context2.getApplicationContext();
        this.connectTimeout = DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.readTimeout = DEFAULT_HTTP_READ_TIMEOUT;
    }

    public BaseImageDownloader(Context context2, int connectTimeout2, int readTimeout2) {
        this.context = context2.getApplicationContext();
        this.connectTimeout = connectTimeout2;
        this.readTimeout = readTimeout2;
    }

    public InputStream getStream(URI imageUri, Object extra) throws IOException {
        String scheme = imageUri.getScheme();
        if (ImageDownloader.SCHEME_HTTP.equals(scheme) || ImageDownloader.SCHEME_HTTPS.equals(scheme)) {
            return getStreamFromNetwork(imageUri, extra);
        }
        if (ImageDownloader.SCHEME_FILE.equals(scheme)) {
            return getStreamFromFile(imageUri, extra);
        }
        if (ImageDownloader.SCHEME_CONTENT.equals(scheme)) {
            return getStreamFromContent(imageUri, extra);
        }
        if (ImageDownloader.SCHEME_ASSETS.equals(scheme)) {
            return getStreamFromAssets(imageUri, extra);
        }
        if (ImageDownloader.SCHEME_DRAWABLE.equals(scheme)) {
            return getStreamFromDrawable(imageUri, extra);
        }
        return getStreamFromOtherSource(imageUri, extra);
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromNetwork(URI imageUri, Object extra) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) imageUri.toURL().openConnection();
        conn.setConnectTimeout(this.connectTimeout);
        conn.setReadTimeout(this.readTimeout);
        return new FlushedInputStream(conn.getInputStream(), 8192);
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromFile(URI imageUri, Object extra) throws IOException {
        return new BufferedInputStream(imageUri.toURL().openStream(), 8192);
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromContent(URI imageUri, Object extra) throws FileNotFoundException {
        return this.context.getContentResolver().openInputStream(Uri.parse(imageUri.toString()));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromAssets(URI imageUri, Object extra) throws IOException {
        return this.context.getAssets().open(imageUri.toString().substring(SCHEME_ASSETS_PREFIX.length()));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromDrawable(URI imageUri, Object extra) {
        Bitmap bitmap = ((BitmapDrawable) this.context.getResources().getDrawable(Integer.parseInt(imageUri.toString().substring(SCHEME_DRAWABLE_PREFIX.length())))).getBitmap();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromOtherSource(URI imageUri, Object extra) throws IOException {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, new Object[]{imageUri.getScheme()}));
    }
}
