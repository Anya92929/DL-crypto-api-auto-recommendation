package com.forexcrunch.forexcrunch.gui.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import java.lang.Thread;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageThreadLoader {
    private static final String TAG = "ImageThreadLoader";
    /* access modifiers changed from: private */
    public final HashMap<String, SoftReference<Bitmap>> Cache = new HashMap<>();
    /* access modifiers changed from: private */
    public final ArrayList<QueueItem> Queue = new ArrayList<>();
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    private QueueRunner runner = new QueueRunner(this, (QueueRunner) null);
    private Thread thread = new Thread(this.runner);

    public interface ImageLoadedListener {
        void imageLoaded(Bitmap bitmap);
    }

    private final class QueueItem {
        public ImageLoadedListener listener;
        public URL url;

        private QueueItem() {
        }

        /* synthetic */ QueueItem(ImageThreadLoader imageThreadLoader, QueueItem queueItem) {
            this();
        }
    }

    private class QueueRunner implements Runnable {
        private QueueRunner() {
        }

        /* synthetic */ QueueRunner(ImageThreadLoader imageThreadLoader, QueueRunner queueRunner) {
            this();
        }

        public void run() {
            synchronized (this) {
                while (ImageThreadLoader.this.Queue.size() > 0) {
                    final QueueItem item = (QueueItem) ImageThreadLoader.this.Queue.remove(0);
                    if (!ImageThreadLoader.this.Cache.containsKey(item.url.toString()) || ImageThreadLoader.this.Cache.get(item.url.toString()) == null) {
                        final Bitmap bmp = ImageThreadLoader.readBitmapFromNetwork(item.url);
                        if (bmp != null) {
                            ImageThreadLoader.this.Cache.put(item.url.toString(), new SoftReference(bmp));
                            ImageThreadLoader.this.handler.post(new Runnable() {
                                public void run() {
                                    if (item.listener != null) {
                                        item.listener.imageLoaded(bmp);
                                    }
                                }
                            });
                        }
                    } else {
                        ImageThreadLoader.this.handler.post(new Runnable() {
                            public void run() {
                                SoftReference<Bitmap> ref;
                                if (item.listener != null && (ref = (SoftReference) ImageThreadLoader.this.Cache.get(item.url.toString())) != null) {
                                    item.listener.imageLoaded(ref.get());
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public Bitmap loadImage(String uri, ImageLoadedListener listener) throws MalformedURLException {
        SoftReference<Bitmap> ref;
        if (this.Cache.containsKey(uri) && (ref = this.Cache.get(uri)) != null) {
            return ref.get();
        }
        QueueItem item = new QueueItem(this, (QueueItem) null);
        item.url = new URL(uri);
        item.listener = listener;
        this.Queue.add(item);
        if (this.thread.getState() == Thread.State.NEW) {
            this.thread.start();
            return null;
        } else if (this.thread.getState() != Thread.State.TERMINATED) {
            return null;
        } else {
            this.thread = new Thread(this.runner);
            this.thread.start();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC, Splitter:B:28:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004e A[Catch:{ IOException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005e A[SYNTHETIC, Splitter:B:36:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0063 A[Catch:{ IOException -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap readBitmapFromNetwork(java.net.URL r9) {
        /*
            r5 = 0
            r0 = 0
            r2 = 0
            java.net.URLConnection r3 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x0023, IOException -> 0x003f }
            r3.connect()     // Catch:{ MalformedURLException -> 0x0023, IOException -> 0x003f }
            java.io.InputStream r5 = r3.getInputStream()     // Catch:{ MalformedURLException -> 0x0023, IOException -> 0x003f }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x0023, IOException -> 0x003f }
            r1.<init>(r5)     // Catch:{ MalformedURLException -> 0x0023, IOException -> 0x003f }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ MalformedURLException -> 0x0080, IOException -> 0x007d, all -> 0x007a }
            if (r5 == 0) goto L_0x001c
            r5.close()     // Catch:{ IOException -> 0x0070 }
        L_0x001c:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ IOException -> 0x0070 }
            r0 = r1
        L_0x0022:
            return r2
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            java.lang.String r6 = "ImageThreadLoader"
            java.lang.String r7 = "Bad ad URL"
            android.util.Log.e(r6, r7, r4)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0030
            r5.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0030:
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x0022
        L_0x0036:
            r4 = move-exception
            java.lang.String r6 = "ImageThreadLoader"
            java.lang.String r7 = "Error closing stream."
            android.util.Log.w(r6, r7)
            goto L_0x0022
        L_0x003f:
            r4 = move-exception
        L_0x0040:
            java.lang.String r6 = "ImageThreadLoader"
            java.lang.String r7 = "Could not get remote ad image"
            android.util.Log.e(r6, r7, r4)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x004c
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x004c:
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0022
        L_0x0052:
            r4 = move-exception
            java.lang.String r6 = "ImageThreadLoader"
            java.lang.String r7 = "Error closing stream."
            android.util.Log.w(r6, r7)
            goto L_0x0022
        L_0x005b:
            r6 = move-exception
        L_0x005c:
            if (r5 == 0) goto L_0x0061
            r5.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0061:
            if (r0 == 0) goto L_0x0066
            r0.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0066:
            throw r6
        L_0x0067:
            r4 = move-exception
            java.lang.String r7 = "ImageThreadLoader"
            java.lang.String r8 = "Error closing stream."
            android.util.Log.w(r7, r8)
            goto L_0x0066
        L_0x0070:
            r4 = move-exception
            java.lang.String r6 = "ImageThreadLoader"
            java.lang.String r7 = "Error closing stream."
            android.util.Log.w(r6, r7)
        L_0x0078:
            r0 = r1
            goto L_0x0022
        L_0x007a:
            r6 = move-exception
            r0 = r1
            goto L_0x005c
        L_0x007d:
            r4 = move-exception
            r0 = r1
            goto L_0x0040
        L_0x0080:
            r4 = move-exception
            r0 = r1
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.forexcrunch.forexcrunch.gui.utils.ImageThreadLoader.readBitmapFromNetwork(java.net.URL):android.graphics.Bitmap");
    }
}
