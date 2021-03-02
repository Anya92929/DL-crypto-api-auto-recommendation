package com.tapcrowd.app.utils.images;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.URL;
import java.util.HashMap;
import java.util.Stack;

public class FastImageLoaderV2 {
    /* access modifiers changed from: private */
    public HashMap<String, Bitmap> cache = new HashMap<>();
    private File cacheDir = null;
    private PhotosLoader photoLoaderThread = new PhotosLoader(this, (PhotosLoader) null);
    /* access modifiers changed from: private */
    public PhotosQueue photosQueue = new PhotosQueue(this, (PhotosQueue) null);
    private Bitmap useThisBitmap = null;

    public FastImageLoaderV2() {
        this.photoLoaderThread.setPriority(9);
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.cacheDir = new File(Environment.getExternalStorageDirectory(), "TapCrowdUI/");
        } else {
            this.cacheDir = App.act.getCacheDir();
        }
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
        }
    }

    public void DisplayImage(String url, View imageView) {
        DisplayImage(url, imageView, 0, 0);
    }

    public void DisplayImage(String url, View imageView, int maxheight, int maxwidth) {
        try {
            ImageView iv = (ImageView) imageView;
            if (!url.startsWith("http")) {
                url = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + url;
            }
            iv.setTag(url);
            if (url.equals("")) {
                return;
            }
            if (this.cache.containsKey(String.valueOf(url) + maxheight + maxwidth)) {
                iv.setImageBitmap(this.cache.get(String.valueOf(url) + maxheight + maxwidth));
                return;
            }
            queuePhoto(url, App.act, iv, maxheight, maxwidth);
        } catch (Exception e) {
        }
    }

    private void queuePhoto(String url, Activity activity, ImageView imageView, int maxheight, int maxwidth) {
        this.photosQueue.Clean(imageView);
        PhotoToLoad p = new PhotoToLoad(url, imageView, maxheight, maxwidth);
        synchronized (this.photosQueue.photosToLoad) {
            this.photosQueue.photosToLoad.push(p);
            this.photosQueue.photosToLoad.notifyAll();
        }
        if (this.photoLoaderThread.getState() == Thread.State.NEW) {
            this.photoLoaderThread.start();
        }
    }

    public boolean downloadIfNotExists(String url) {
        if (url == null || url.equals("")) {
            return false;
        }
        String timestamp = "";
        try {
            timestamp = "?" + C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp");
        } catch (Exception e) {
        }
        try {
            File f = new File(this.cacheDir, String.valueOf((String.valueOf(url) + timestamp).hashCode()));
            if (f.exists()) {
                return true;
            }
            InputStream is = new URL(url).openStream();
            OutputStream os = new FileOutputStream(f);
            Utils.CopyStream(is, os);
            os.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public Bitmap getBitmap(String url) {
        return getBitmap(url, 0, 0);
    }

    public Bitmap getBitmap(String url, int maxheight, int maxwidth) {
        String timestamp = "";
        try {
            timestamp = "?" + C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp");
        } catch (Exception e) {
        }
        try {
            File f = new File(this.cacheDir, String.valueOf((String.valueOf(url) + timestamp).hashCode()));
            Bitmap b = decodeFile(f, maxheight, maxwidth);
            if (b != null) {
                return b;
            }
            Bitmap bitmap = null;
            try {
                if (!url.equals("")) {
                    InputStream is = new URL(url).openStream();
                    OutputStream os = new FileOutputStream(f);
                    Utils.CopyStream(is, os);
                    os.close();
                    bitmap = decodeFile(f, maxheight, maxwidth);
                }
                return bitmap;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Bitmap decodeFile(File f) {
        return decodeFile(f, 0, 0);
    }

    private Bitmap decodeFile(File f, int maxheight, int maxwidth) {
        try {
            this.useThisBitmap = null;
            BitmapFactory.Options o = new BitmapFactory.Options();
            if (!(maxheight == 0 && maxwidth == 0)) {
                o.inJustDecodeBounds = true;
                int inSampleSize = 1;
                BitmapFactory.decodeStream(new FileInputStream(f), (Rect) null, o);
                int imageheight = o.outHeight;
                int imagewidth = o.outWidth;
                if (imagewidth > maxwidth || imageheight > maxheight) {
                    if ((imagewidth <= imageheight || maxheight == 0) && maxwidth != 0) {
                        inSampleSize = Math.round(((float) imagewidth) / ((float) maxwidth));
                    } else {
                        inSampleSize = Math.round(((float) imageheight) / ((float) maxheight));
                    }
                }
                o = new BitmapFactory.Options();
                o.inSampleSize = inSampleSize;
                o.inJustDecodeBounds = false;
            }
            this.useThisBitmap = BitmapFactory.decodeStream(new FileInputStream(f), (Rect) null, o);
        } catch (FileNotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            System.gc();
        }
        return this.useThisBitmap;
    }

    private class PhotoToLoad {
        public ImageView imageView;
        public int maxheight;
        public int maxwidth;
        public String url;

        public PhotoToLoad(String u, ImageView i, int mh, int mw) {
            this.url = u;
            this.imageView = i;
            this.maxheight = mh;
            this.maxwidth = mw;
        }
    }

    private class PhotosQueue {
        /* access modifiers changed from: private */
        public Stack<PhotoToLoad> photosToLoad;

        private PhotosQueue() {
            this.photosToLoad = new Stack<>();
        }

        /* synthetic */ PhotosQueue(FastImageLoaderV2 fastImageLoaderV2, PhotosQueue photosQueue) {
            this();
        }

        /* access modifiers changed from: private */
        public void Clean(ImageView image) {
            int j = 0;
            while (j < this.photosToLoad.size()) {
                if (((PhotoToLoad) this.photosToLoad.get(j)).imageView == image) {
                    this.photosToLoad.remove(j);
                } else {
                    j++;
                }
            }
        }
    }

    private class PhotosLoader extends Thread {
        private PhotosLoader() {
        }

        /* synthetic */ PhotosLoader(FastImageLoaderV2 fastImageLoaderV2, PhotosLoader photosLoader) {
            this();
        }

        public void run() {
            PhotoToLoad photoToLoad;
            do {
                try {
                    if (FastImageLoaderV2.this.photosQueue.photosToLoad.size() == 0) {
                        synchronized (FastImageLoaderV2.this.photosQueue.photosToLoad) {
                            FastImageLoaderV2.this.photosQueue.photosToLoad.wait();
                        }
                    }
                    if (FastImageLoaderV2.this.photosQueue.photosToLoad.size() != 0) {
                        synchronized (FastImageLoaderV2.this.photosQueue.photosToLoad) {
                            photoToLoad = (PhotoToLoad) FastImageLoaderV2.this.photosQueue.photosToLoad.pop();
                        }
                        Bitmap bmp = FastImageLoaderV2.this.getBitmap(photoToLoad.url, photoToLoad.maxheight, photoToLoad.maxwidth);
                        FastImageLoaderV2.this.cache.put(String.valueOf(photoToLoad.url) + photoToLoad.maxheight + photoToLoad.maxwidth, bmp);
                        ((Activity) photoToLoad.imageView.getContext()).runOnUiThread(new BitmapDisplayer(FastImageLoaderV2.this, bmp, photoToLoad.imageView, photoToLoad.url, (BitmapDisplayer) null));
                    }
                } catch (InterruptedException e) {
                    return;
                }
            } while (!Thread.interrupted());
        }
    }

    private class BitmapDisplayer implements Runnable {
        private Bitmap bitmap;
        private ImageView imageView;
        private String url;

        private BitmapDisplayer(Bitmap b, ImageView i, String url2) {
            this.bitmap = b;
            this.imageView = i;
            this.url = url2;
        }

        /* synthetic */ BitmapDisplayer(FastImageLoaderV2 fastImageLoaderV2, Bitmap bitmap2, ImageView imageView2, String str, BitmapDisplayer bitmapDisplayer) {
            this(bitmap2, imageView2, str);
        }

        public void run() {
            if (this.bitmap != null && this.imageView.getTag().equals(this.url)) {
                this.imageView.setImageBitmap(this.bitmap);
            }
        }
    }

    public void stopThread() {
        this.photoLoaderThread.interrupt();
    }

    public void clearCache() {
        this.cache.clear();
        for (File f : this.cacheDir.listFiles()) {
            f.delete();
        }
    }

    public Drawable getDrawable(String url) {
        if (url == null || url.equals("")) {
            return null;
        }
        String timestamp = "";
        try {
            timestamp = "?" + C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp");
        } catch (Exception e) {
        }
        try {
            File f = new File(this.cacheDir, String.valueOf((String.valueOf(url) + timestamp).hashCode()));
            if (f.exists()) {
                return new BitmapDrawable(decodeFile(f));
            }
            Bitmap bitmap = null;
            try {
                if (!url.equals("")) {
                    InputStream is = new URL(url).openStream();
                    OutputStream os = new FileOutputStream(f);
                    Utils.CopyStream(is, os);
                    os.close();
                    bitmap = decodeFile(f);
                }
                return new BitmapDrawable(bitmap);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getPath(String imgurl) {
        String timestamp = "";
        try {
            timestamp = "?" + C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("timestamp");
        } catch (Exception e) {
        }
        return this.cacheDir + "/" + String.valueOf((String.valueOf(imgurl) + timestamp).hashCode());
    }
}
