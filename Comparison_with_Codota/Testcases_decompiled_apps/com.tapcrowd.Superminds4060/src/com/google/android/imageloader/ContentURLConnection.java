package com.google.android.imageloader;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

class ContentURLConnection extends URLConnection {
    private boolean mConnected;
    private InputStream mInputStream;
    /* access modifiers changed from: private */
    public boolean mInputStreamClosed;
    private OutputStream mOutputStream;
    /* access modifiers changed from: private */
    public boolean mOutputStreamClosed;
    private final ContentResolver mResolver;
    private final Uri mUri;

    public ContentURLConnection(ContentResolver resolver, URL url) {
        super(url);
        this.mResolver = resolver;
        this.mUri = Uri.parse(url.toString());
    }

    public void connect() throws IOException {
        if (getDoInput()) {
            this.mInputStream = new ContentURLConnectionInputStream(this.mResolver.openInputStream(this.mUri));
        }
        if (getDoOutput()) {
            this.mOutputStream = new ContentURLConnectionOutputStream(this.mResolver.openOutputStream(this.mUri, "rwt"));
        }
        this.mConnected = true;
    }

    public InputStream getInputStream() throws IOException {
        if (this.mInputStreamClosed) {
            throw new IllegalStateException("Closed");
        }
        if (!this.mConnected) {
            connect();
        }
        return this.mInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        if (this.mOutputStreamClosed) {
            throw new IllegalStateException("Closed");
        }
        if (!this.mConnected) {
            connect();
        }
        return this.mOutputStream;
    }

    public Object getContent() throws IOException {
        if (!this.mConnected) {
            connect();
        }
        return super.getContent();
    }

    public String getContentType() {
        return this.mResolver.getType(this.mUri);
    }

    public int getContentLength() {
        try {
            long length = this.mResolver.openAssetFileDescriptor(this.mUri, "r").getLength();
            if (length <= 0 && length <= 2147483647L) {
                return (int) length;
            }
        } catch (IOException e) {
        }
        return -1;
    }

    private class ContentURLConnectionInputStream extends FilterInputStream {
        public ContentURLConnectionInputStream(InputStream in) {
            super(in);
        }

        public void close() throws IOException {
            super.close();
            boolean unused = ContentURLConnection.this.mInputStreamClosed = true;
        }
    }

    private class ContentURLConnectionOutputStream extends FilterOutputStream {
        public ContentURLConnectionOutputStream(OutputStream out) {
            super(out);
        }

        public void close() throws IOException {
            super.close();
            boolean unused = ContentURLConnection.this.mOutputStreamClosed = true;
        }
    }
}
