package com.tapcrowd.app.utils.images;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

public class ImageLoader {
    FileCache fileCache;
    /* access modifiers changed from: private */
    public Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
    MemoryCache memoryCache = new MemoryCache();
    PhotosLoader photoLoaderThread = new PhotosLoader();
    PhotosQueue photosQueue = new PhotosQueue();
    int stub_id = C0846R.drawable.icon;

    public ImageLoader() {
        this.photoLoaderThread.setPriority(4);
        this.fileCache = new FileCache(App.act);
    }

    public void DisplayImage(String url, ImageView imageView) {
        if (url != null) {
            if (!url.contains("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            this.imageViews.put(imageView, url);
            Bitmap bitmap = this.memoryCache.get(url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                queuePhoto(url, App.act, imageView);
            }
        }
    }

    public void DisplayImage(String url, ImageView imageView, int defaultResource) {
        this.stub_id = defaultResource;
        if (url != null) {
            if (!url.contains("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            this.imageViews.put(imageView, url);
            Bitmap bitmap = this.memoryCache.get(url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                queuePhoto(url, App.act, imageView);
            }
        }
    }

    private void queuePhoto(String url, Activity activity, ImageView imageView) {
        this.photosQueue.Clean(imageView);
        PhotoToLoad p = new PhotoToLoad(url, imageView);
        synchronized (this.photosQueue.photosToLoad) {
            this.photosQueue.photosToLoad.push(p);
            this.photosQueue.photosToLoad.notifyAll();
        }
        if (this.photoLoaderThread.getState() == Thread.State.NEW) {
            this.photoLoaderThread.start();
        }
    }

    public Bitmap getBitmap(String url) {
        File f = this.fileCache.getFile(url);
        Bitmap b = decodeFile(f);
        if (b != null) {
            return b;
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(f);
            Utils.CopyStream(is, os);
            os.close();
            return decodeFile(f);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Bitmap decodeFile(File f) {
        try {
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), (Rect) null, o);
            int width_tmp = o.outWidth;
            int height_tmp = o.outHeight;
            int scale = 1;
            while (width_tmp / 2 >= 70 && height_tmp / 2 >= 70) {
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 1;
            }
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), (Rect) null, o2);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private class PhotoToLoad {
        public ImageView imageView;
        public String url;

        public PhotoToLoad(String u, ImageView i) {
            this.url = u;
            this.imageView = i;
        }
    }

    public void stopThread() {
        this.photoLoaderThread.interrupt();
    }

    class PhotosQueue {
        /* access modifiers changed from: private */
        public Stack<PhotoToLoad> photosToLoad = new Stack<>();

        PhotosQueue() {
        }

        public void Clean(ImageView image) {
            int j = 0;
            while (j < this.photosToLoad.size()) {
                try {
                    if (((PhotoToLoad) this.photosToLoad.get(j)).imageView == image) {
                        this.photosToLoad.remove(j);
                    } else {
                        j++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    class PhotosLoader extends Thread {
        PhotosLoader() {
        }

        public void run() {
            PhotoToLoad photoToLoad;
            do {
                try {
                    if (ImageLoader.this.photosQueue.photosToLoad.size() == 0) {
                        synchronized (ImageLoader.this.photosQueue.photosToLoad) {
                            ImageLoader.this.photosQueue.photosToLoad.wait();
                        }
                    }
                    if (ImageLoader.this.photosQueue.photosToLoad.size() != 0) {
                        synchronized (ImageLoader.this.photosQueue.photosToLoad) {
                            photoToLoad = (PhotoToLoad) ImageLoader.this.photosQueue.photosToLoad.pop();
                        }
                        Bitmap bmp = ImageLoader.this.getBitmap(photoToLoad.url);
                        ImageLoader.this.memoryCache.put(photoToLoad.url, bmp);
                        String tag = (String) ImageLoader.this.imageViews.get(photoToLoad.imageView);
                        if (tag != null && tag.equals(photoToLoad.url)) {
                            ((Activity) photoToLoad.imageView.getContext()).runOnUiThread(new BitmapDisplayer(bmp, photoToLoad.imageView));
                        }
                    }
                } catch (InterruptedException e) {
                    return;
                }
            } while (!Thread.interrupted());
        }
    }

    class BitmapDisplayer implements Runnable {
        Bitmap bitmap;
        ImageView imageView;

        public BitmapDisplayer(Bitmap b, ImageView i) {
            this.bitmap = b;
            this.imageView = i;
        }

        public void run() {
            if (this.bitmap != null) {
                this.imageView.setImageBitmap(this.bitmap);
            }
        }
    }

    public void clearCache() {
        this.memoryCache.clear();
        this.fileCache.clear();
    }
}
