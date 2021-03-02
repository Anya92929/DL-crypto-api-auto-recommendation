package com.google.android.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

public class BitmapContentHandler extends ContentHandler {
    public Bitmap getContent(URLConnection connection) throws IOException {
        InputStream input = connection.getInputStream();
        try {
            InputStream input2 = new BlockingFilterInputStream(input);
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(input2);
                if (bitmap == null) {
                    throw new IOException("Image could not be decoded");
                }
                input2.close();
                return bitmap;
            } catch (Throwable th) {
                th = th;
                input = input2;
                input.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            input.close();
            throw th;
        }
    }
}
