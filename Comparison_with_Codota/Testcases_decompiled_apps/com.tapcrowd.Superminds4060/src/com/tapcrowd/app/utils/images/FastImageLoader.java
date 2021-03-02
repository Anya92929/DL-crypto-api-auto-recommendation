package com.tapcrowd.app.utils.images;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Environment;
import android.widget.ImageView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FastImageLoader {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    FileCache fileCache = new FileCache(App.act);
    private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
    MemoryCache memoryCache = new MemoryCache();

    public interface LoadBitmapListener {
        void bitmapLoaded(Bitmap bitmap);
    }

    public void DisplayImage(String url, ImageView imageView) {
        DisplayImage(url, imageView, 0, 0);
    }

    public void DisplayImage(String url, ImageView imageView, int maxheight, int maxwidth) {
        if (url != null) {
            if (!url.startsWith("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            this.imageViews.put(imageView, url);
            Bitmap bitmap = this.memoryCache.get(url);
            if (bitmap != null) {
                imageView.setImageBitmap(rotateBitmap(bitmap, url));
            } else {
                queuePhoto(url, imageView, maxheight, maxwidth);
            }
        }
    }

    private void queuePhoto(String url, ImageView imageView, int maxheight, int maxwidth) {
        this.executorService.submit(new PhotosLoader(new PhotoToLoad(url, imageView, maxheight, maxwidth)));
    }

    public Bitmap getBitmap(String url) {
        return getBitmap(url, 0, 0);
    }

    public void getBitmap(final String url, final LoadBitmapListener listener) {
        new Thread(new Runnable() {
            public void run() {
                final Bitmap bitmap = FastImageLoader.this.getBitmap(url);
                Activity activity = App.act;
                final LoadBitmapListener loadBitmapListener = listener;
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (loadBitmapListener != null) {
                            loadBitmapListener.bitmapLoaded(bitmap);
                        }
                    }
                });
            }
        }).start();
    }

    public void getBitmap(String url, LoadBitmapListener listener, int maxheight, int maxwidth) {
        final String str = url;
        final int i = maxheight;
        final int i2 = maxwidth;
        final LoadBitmapListener loadBitmapListener = listener;
        new Thread(new Runnable() {
            public void run() {
                final Bitmap bitmap = FastImageLoader.this.getBitmap(str, i, i2);
                Activity activity = App.act;
                final LoadBitmapListener loadBitmapListener = loadBitmapListener;
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (loadBitmapListener != null) {
                            loadBitmapListener.bitmapLoaded(bitmap);
                        }
                    }
                });
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public Bitmap getBitmap(String url, int maxheight, int maxwidth) {
        File f;
        if (url == null || url.length() == 0) {
            return null;
        }
        if (url.contains(Environment.getExternalStorageDirectory().toString())) {
            f = new File(url);
        } else {
            if (!url.startsWith("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            f = this.fileCache.getFile(url);
        }
        Bitmap b = decodeFile(f, maxheight, maxwidth);
        if (b != null) {
            return b;
        }
        try {
            String url2 = url.split("\\?themeid")[0];
            int slashIndex = url2.lastIndexOf(47);
            String filename = url2.substring(slashIndex + 1);
            if (url2.contains(App.act.getString(C0846R.string.baseimgurl))) {
                filename = URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
            }
            HttpURLConnection conn = (HttpURLConnection) new URL(url2.subSequence(0, slashIndex + 1) + filename).openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(f);
            Utils.CopyStream(is, os);
            os.close();
            return decodeFile(f, maxheight, maxwidth);
        } catch (Throwable ex) {
            ex.printStackTrace();
            if (ex instanceof OutOfMemoryError) {
                this.memoryCache.clear();
            }
            return null;
        }
    }

    private Bitmap decodeFile(File f) {
        return decodeFile(f, 0, 0);
    }

    private Bitmap decodeFile(File f, int maxheight, int maxwidth) {
        try {
            BitmapFactory.Options o = new BitmapFactory.Options();
            if (!(maxheight == 0 && maxwidth == 0)) {
                o.inJustDecodeBounds = true;
                int inSampleSize = 1;
                BitmapFactory.decodeStream(new FileInputStream(f), (Rect) null, o);
                int imageheight = o.outHeight;
                int imagewidth = o.outWidth;
                if (imagewidth > maxwidth || imageheight > maxheight) {
                    if ((imagewidth <= imageheight || maxheight <= 0) && maxwidth > 0) {
                        inSampleSize = Math.round(((float) imagewidth) / ((float) maxwidth));
                    } else {
                        inSampleSize = Math.round(((float) imageheight) / ((float) maxheight));
                    }
                }
                o = new BitmapFactory.Options();
                if (inSampleSize != 0) {
                    o.inSampleSize = inSampleSize;
                }
                o.inJustDecodeBounds = false;
            }
            FileInputStream stream2 = new FileInputStream(f);
            Bitmap bitmap = BitmapFactory.decodeStream(stream2, (Rect) null, o);
            stream2.close();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private class PhotoToLoad {
        public ImageView imageView;
        int maxheight;
        int maxwidth;
        public String url;

        public PhotoToLoad(String u, ImageView i, int mh, int mw) {
            this.url = u;
            this.imageView = i;
            this.maxheight = mh;
            this.maxwidth = mw;
        }
    }

    class PhotosLoader implements Runnable {
        PhotoToLoad photoToLoad;

        PhotosLoader(PhotoToLoad photoToLoad2) {
            this.photoToLoad = photoToLoad2;
        }

        public void run() {
            try {
                if (!FastImageLoader.this.imageViewReused(this.photoToLoad)) {
                    Bitmap bmp = FastImageLoader.this.getBitmap(this.photoToLoad.url, this.photoToLoad.maxheight, this.photoToLoad.maxwidth);
                    FastImageLoader.this.memoryCache.put(this.photoToLoad.url, bmp);
                    if (!FastImageLoader.this.imageViewReused(this.photoToLoad)) {
                        ((Activity) this.photoToLoad.imageView.getContext()).runOnUiThread(new BitmapDisplayer(bmp, this.photoToLoad));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean imageViewReused(PhotoToLoad photoToLoad) {
        String tag = this.imageViews.get(photoToLoad.imageView);
        if (tag == null || !tag.equals(photoToLoad.url)) {
            return true;
        }
        return false;
    }

    class BitmapDisplayer implements Runnable {
        Bitmap bitmap;
        PhotoToLoad photoToLoad;

        public BitmapDisplayer(Bitmap b, PhotoToLoad p) {
            this.bitmap = b;
            this.photoToLoad = p;
        }

        public void run() {
            if (!FastImageLoader.this.imageViewReused(this.photoToLoad) && this.bitmap != null) {
                this.photoToLoad.imageView.setImageBitmap(FastImageLoader.this.rotateBitmap(this.bitmap, this.photoToLoad.url));
            }
        }
    }

    public void clearCache() {
        this.memoryCache.clear();
        this.fileCache.clear();
    }

    public void downloadIfNotExists(String url) {
        if (url != null && url.length() != 0) {
            if (!url.startsWith("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            final String finalurl = url;
            final File file = this.fileCache.getFile(url);
            if (file.exists()) {
                Bitmap bmp = getBitmap(finalurl, 1, 1);
                if (bmp == null) {
                    file.delete();
                } else {
                    bmp.recycle();
                }
            }
            if (!file.exists()) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            HttpURLConnection conn = (HttpURLConnection) new URL(finalurl).openConnection();
                            conn.setConnectTimeout(30000);
                            conn.setReadTimeout(30000);
                            conn.setInstanceFollowRedirects(true);
                            InputStream is = conn.getInputStream();
                            OutputStream os = new FileOutputStream(file);
                            Utils.CopyStream(is, os);
                            os.close();
                        } catch (Exception e) {
                        }
                    }
                }).start();
            }
        }
    }

    public Drawable getDrawable(String url) {
        if (url == null) {
            return null;
        }
        return new BitmapDrawable(getBitmap(url));
    }

    public String getPath(String url) {
        return this.fileCache.getFile(url).getPath();
    }

    /* access modifiers changed from: private */
    public Bitmap rotateBitmap(Bitmap input, String url) {
        try {
            int orientation = new ExifInterface(getPath(url)).getAttributeInt("Orientation", 1);
            Matrix m = new Matrix();
            if (orientation == 3) {
                m.postRotate(180.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            } else if (orientation == 6) {
                m.postRotate(90.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            } else if (orientation != 8) {
                return input;
            } else {
                m.postRotate(270.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }
}
