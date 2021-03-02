package com.google.android.imageloader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.ContentHandler;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

public final class ImageLoader {
    public static final long DEFAULT_CACHE_SIZE = Math.min(Runtime.getRuntime().maxMemory() / 4, 16777216);
    public static final int DEFAULT_TASK_LIMIT = 3;
    public static final String IMAGE_LOADER_SERVICE = "com.google.android.imageloader";
    private static final String TAG = "ImageLoader";
    private int mActiveTaskCount;
    /* access modifiers changed from: private */
    public final ContentHandler mBitmapContentHandler;
    private final Map<String, Bitmap> mBitmaps;
    private final Map<String, ImageError> mErrors;
    /* access modifiers changed from: private */
    public final Map<ImageView, String> mImageViewBinding;
    private final int mMaxTaskCount;
    /* access modifiers changed from: private */
    public final ContentHandler mPrefetchContentHandler;
    private final LinkedList<ImageRequest> mRequests;
    private final HashMap<String, URLStreamHandler> mStreamHandlers;
    private final URLStreamHandlerFactory mURLStreamHandlerFactory;

    public enum BindResult {
        OK,
        LOADING,
        ERROR
    }

    public interface Callback {
        void onImageError(ImageView imageView, String str, Throwable th);

        void onImageLoaded(ImageView imageView, String str);
    }

    private interface ImageCallback {
        void send(String str, Bitmap bitmap, ImageError imageError);

        boolean unwanted();
    }

    static /* synthetic */ int access$1108(ImageLoader x0) {
        int i = x0.mActiveTaskCount;
        x0.mActiveTaskCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$1110(ImageLoader x0) {
        int i = x0.mActiveTaskCount;
        x0.mActiveTaskCount = i - 1;
        return i;
    }

    public static ImageLoader get(Context context) {
        ImageLoader loader = (ImageLoader) context.getSystemService(IMAGE_LOADER_SERVICE);
        if (loader == null) {
            loader = (ImageLoader) context.getApplicationContext().getSystemService(IMAGE_LOADER_SERVICE);
        }
        if (loader != null) {
            return loader;
        }
        throw new IllegalStateException("ImageLoader not available");
    }

    /* access modifiers changed from: private */
    public static String getProtocol(String url) {
        return Uri.parse(url).getScheme();
    }

    public ImageLoader(int taskLimit, URLStreamHandlerFactory streamFactory, ContentHandler bitmapHandler, ContentHandler prefetchHandler, long cacheSize, Handler handler) {
        if (taskLimit < 1) {
            throw new IllegalArgumentException("Task limit must be positive");
        } else if (cacheSize < 1) {
            throw new IllegalArgumentException("Cache size must be positive");
        } else {
            this.mMaxTaskCount = taskLimit;
            this.mURLStreamHandlerFactory = streamFactory;
            this.mStreamHandlers = streamFactory != null ? new HashMap<>() : null;
            this.mBitmapContentHandler = bitmapHandler == null ? new BitmapContentHandler() : bitmapHandler;
            this.mPrefetchContentHandler = prefetchHandler;
            this.mImageViewBinding = new WeakHashMap();
            this.mRequests = new LinkedList<>();
            this.mBitmaps = Collections.synchronizedMap(new BitmapCache(cacheSize));
            this.mErrors = Collections.synchronizedMap(new LruCache());
        }
    }

    public ImageLoader() {
        this(3, (URLStreamHandlerFactory) null, (ContentHandler) null, (ContentHandler) null, DEFAULT_CACHE_SIZE, (Handler) null);
    }

    public ImageLoader(int taskLimit) {
        this(taskLimit, (URLStreamHandlerFactory) null, (ContentHandler) null, (ContentHandler) null, DEFAULT_CACHE_SIZE, (Handler) null);
    }

    public ImageLoader(long cacheSize) {
        this(3, (URLStreamHandlerFactory) null, (ContentHandler) null, (ContentHandler) null, cacheSize, (Handler) null);
    }

    public ImageLoader(ContentHandler bitmapHandler, ContentHandler prefetchHandler) {
        this(3, (URLStreamHandlerFactory) null, bitmapHandler, prefetchHandler, DEFAULT_CACHE_SIZE, (Handler) null);
    }

    public ImageLoader(ContentResolver resolver) {
        this(3, new ContentURLStreamHandlerFactory(resolver), (ContentHandler) null, (ContentHandler) null, DEFAULT_CACHE_SIZE, (Handler) null);
    }

    public ImageLoader(URLStreamHandlerFactory factory) {
        this(3, factory, (ContentHandler) null, (ContentHandler) null, DEFAULT_CACHE_SIZE, (Handler) null);
    }

    /* access modifiers changed from: private */
    public URLStreamHandler getURLStreamHandler(String protocol) {
        URLStreamHandler handler;
        URLStreamHandlerFactory factory = this.mURLStreamHandlerFactory;
        if (factory == null) {
            return null;
        }
        HashMap<String, URLStreamHandler> handlers = this.mStreamHandlers;
        synchronized (handlers) {
            handler = handlers.get(protocol);
            if (handler == null && (handler = factory.createURLStreamHandler(protocol)) != null) {
                handlers.put(protocol, handler);
            }
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public void flushRequests() {
        while (this.mActiveTaskCount < this.mMaxTaskCount && !this.mRequests.isEmpty()) {
            new ImageTask().executeOnThreadPool(this.mRequests.poll());
        }
    }

    private void enqueueRequest(ImageRequest request) {
        this.mRequests.add(request);
        flushRequests();
    }

    private void insertRequestAtFrontOfQueue(ImageRequest request) {
        this.mRequests.add(0, request);
        flushRequests();
    }

    public BindResult bind(BaseAdapter adapter, ImageView view, String url) {
        if (adapter == null) {
            throw new NullPointerException("Adapter is null");
        } else if (view == null) {
            throw new NullPointerException("ImageView is null");
        } else if (url == null) {
            throw new NullPointerException("URL is null");
        } else {
            Bitmap bitmap = getBitmap(url);
            ImageError error = getError(url);
            if (bitmap != null) {
                view.setImageBitmap(bitmap);
                return BindResult.OK;
            }
            view.setImageDrawable((Drawable) null);
            if (error != null) {
                return BindResult.ERROR;
            }
            insertRequestAtFrontOfQueue(new ImageRequest(this, adapter, url));
            return BindResult.LOADING;
        }
    }

    public BindResult bind(BaseExpandableListAdapter adapter, ImageView view, String url) {
        if (adapter == null) {
            throw new NullPointerException("Adapter is null");
        } else if (view == null) {
            throw new NullPointerException("ImageView is null");
        } else if (url == null) {
            throw new NullPointerException("URL is null");
        } else {
            Bitmap bitmap = getBitmap(url);
            ImageError error = getError(url);
            if (bitmap != null) {
                view.setImageBitmap(bitmap);
                return BindResult.OK;
            }
            view.setImageDrawable((Drawable) null);
            if (error != null) {
                return BindResult.ERROR;
            }
            insertRequestAtFrontOfQueue(new ImageRequest(this, adapter, url));
            return BindResult.LOADING;
        }
    }

    public BindResult bind(ImageView view, String url, Callback callback) {
        if (view == null) {
            throw new NullPointerException("ImageView is null");
        } else if (url == null) {
            throw new NullPointerException("URL is null");
        } else {
            this.mImageViewBinding.put(view, url);
            Bitmap bitmap = getBitmap(url);
            ImageError error = getError(url);
            if (bitmap != null) {
                view.setImageBitmap(bitmap);
                if (callback != null) {
                    callback.onImageLoaded(view, url);
                }
                return BindResult.OK;
            }
            view.setImageDrawable((Drawable) null);
            if (error != null) {
                if (callback != null) {
                    callback.onImageError(view, url, error.getCause());
                }
                return BindResult.ERROR;
            }
            enqueueRequest(new ImageRequest(this, view, url, callback));
            return BindResult.LOADING;
        }
    }

    public void unbind(ImageView view) {
        this.mImageViewBinding.remove(view);
        view.setImageDrawable((Drawable) null);
    }

    public void clearErrors() {
        this.mErrors.clear();
    }

    public void preload(String url) {
        if (url == null) {
            throw new NullPointerException();
        } else if (getBitmap(url) == null && getError(url) == null) {
            enqueueRequest(new ImageRequest(this, url, true));
        }
    }

    public void preload(Cursor cursor, int columnIndex, int start, int end) {
        for (int position = start; position < end; position++) {
            if (cursor.moveToPosition(position)) {
                String url = cursor.getString(columnIndex);
                if (!TextUtils.isEmpty(url)) {
                    preload(url);
                }
            }
        }
    }

    public void prefetch(String url) {
        if (url == null) {
            throw new NullPointerException();
        } else if (getBitmap(url) == null && getError(url) == null) {
            enqueueRequest(new ImageRequest(this, url, false));
        }
    }

    public void prefetch(Cursor cursor, int columnIndex) {
        for (int position = 0; cursor.moveToPosition(position); position++) {
            String url = cursor.getString(columnIndex);
            if (!TextUtils.isEmpty(url)) {
                prefetch(url);
            }
        }
    }

    /* access modifiers changed from: private */
    public void putBitmap(String url, Bitmap bitmap) {
        this.mBitmaps.put(url, bitmap);
    }

    /* access modifiers changed from: private */
    public void putError(String url, ImageError error) {
        this.mErrors.put(url, error);
    }

    /* access modifiers changed from: private */
    public Bitmap getBitmap(String url) {
        return this.mBitmaps.get(url);
    }

    /* access modifiers changed from: private */
    public ImageError getError(String url) {
        ImageError error = this.mErrors.get(url);
        if (error == null || error.isExpired()) {
            return null;
        }
        return error;
    }

    /* access modifiers changed from: private */
    public boolean hasError(String url) {
        return getError(url) != null;
    }

    private class ImageRequest {
        private Bitmap mBitmap;
        private final ImageCallback mCallback;
        private ImageError mError;
        private final boolean mLoadBitmap;
        private final String mUrl;

        private ImageRequest(String url, ImageCallback callback, boolean loadBitmap) {
            this.mUrl = url;
            this.mCallback = callback;
            this.mLoadBitmap = loadBitmap;
        }

        public ImageRequest(ImageLoader imageLoader, BaseAdapter adapter, String url) {
            this(url, (ImageCallback) new BaseAdapterCallback(adapter), true);
        }

        public ImageRequest(ImageLoader imageLoader, BaseExpandableListAdapter adapter, String url) {
            this(url, (ImageCallback) new BaseExpandableListAdapterCallback(adapter), true);
        }

        public ImageRequest(ImageLoader imageLoader, ImageView view, String url, Callback callback) {
            this(url, (ImageCallback) new ImageViewCallback(view, callback), true);
        }

        public ImageRequest(ImageLoader imageLoader, String url, boolean loadBitmap) {
            this(url, (ImageCallback) null, loadBitmap);
        }

        private Bitmap loadImage(URL url) throws IOException {
            return (Bitmap) ImageLoader.this.mBitmapContentHandler.getContent(url.openConnection());
        }

        public boolean execute() {
            try {
                if (this.mCallback != null && this.mCallback.unwanted()) {
                    return false;
                }
                this.mError = ImageLoader.this.getError(this.mUrl);
                if (this.mError != null) {
                    return true;
                }
                this.mBitmap = ImageLoader.this.getBitmap(this.mUrl);
                if (this.mBitmap != null) {
                    return true;
                }
                URL url = new URL((URL) null, this.mUrl, ImageLoader.this.getURLStreamHandler(ImageLoader.getProtocol(this.mUrl)));
                if (this.mLoadBitmap) {
                    try {
                        this.mBitmap = loadImage(url);
                    } catch (OutOfMemoryError e) {
                        System.gc();
                        this.mBitmap = loadImage(url);
                    }
                    if (this.mBitmap != null) {
                        return true;
                    }
                    throw new NullPointerException("ContentHandler returned null");
                }
                if (ImageLoader.this.mPrefetchContentHandler != null) {
                    ImageLoader.this.mPrefetchContentHandler.getContent(url.openConnection());
                }
                this.mBitmap = null;
                return false;
            } catch (IOException e2) {
                this.mError = new ImageError(e2);
                return true;
            } catch (RuntimeException e3) {
                this.mError = new ImageError(e3);
                return true;
            } catch (Error e4) {
                this.mError = new ImageError(e4);
                return true;
            }
        }

        public void publishResult() {
            if (this.mBitmap != null) {
                ImageLoader.this.putBitmap(this.mUrl, this.mBitmap);
            } else if (this.mError != null && !ImageLoader.this.hasError(this.mUrl)) {
                Log.e(ImageLoader.TAG, "Failed to load " + this.mUrl, this.mError.getCause());
                ImageLoader.this.putError(this.mUrl, this.mError);
            }
            if (this.mCallback != null) {
                this.mCallback.send(this.mUrl, this.mBitmap, this.mError);
            }
        }
    }

    private final class ImageViewCallback implements ImageCallback {
        private final Callback mCallback;
        private final ImageView mImageView;

        public ImageViewCallback(ImageView imageView, Callback callback) {
            this.mImageView = imageView;
            this.mCallback = callback;
        }

        public boolean unwanted() {
            return false;
        }

        public void send(String url, Bitmap bitmap, ImageError error) {
            if (TextUtils.equals((String) ImageLoader.this.mImageViewBinding.get(this.mImageView), url)) {
                if (bitmap != null) {
                    this.mImageView.setImageBitmap(bitmap);
                    if (this.mCallback != null) {
                        this.mCallback.onImageLoaded(this.mImageView, url);
                    }
                } else if (error != null && this.mCallback != null) {
                    this.mCallback.onImageError(this.mImageView, url, error.getCause());
                }
            }
        }
    }

    private static final class BaseAdapterCallback implements ImageCallback {
        private final WeakReference<BaseAdapter> mAdapter;

        public BaseAdapterCallback(BaseAdapter adapter) {
            this.mAdapter = new WeakReference<>(adapter);
        }

        public boolean unwanted() {
            return this.mAdapter.get() == null;
        }

        public void send(String url, Bitmap bitmap, ImageError error) {
            BaseAdapter adapter = (BaseAdapter) this.mAdapter.get();
            if (adapter != null && !adapter.isEmpty()) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private static final class BaseExpandableListAdapterCallback implements ImageCallback {
        private final WeakReference<BaseExpandableListAdapter> mAdapter;

        public BaseExpandableListAdapterCallback(BaseExpandableListAdapter adapter) {
            this.mAdapter = new WeakReference<>(adapter);
        }

        public boolean unwanted() {
            return this.mAdapter.get() == null;
        }

        public void send(String url, Bitmap bitmap, ImageError error) {
            BaseExpandableListAdapter adapter = (BaseExpandableListAdapter) this.mAdapter.get();
            if (adapter != null && !adapter.isEmpty()) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private class ImageTask extends AsyncTask<ImageRequest, ImageRequest, Void> {
        private ImageTask() {
        }

        /* Debug info: failed to restart local var, previous not found, register: 9 */
        public final AsyncTask<ImageRequest, ImageRequest, Void> executeOnThreadPool(ImageRequest... params) {
            if (Build.VERSION.SDK_INT < 4) {
                return execute(params);
            }
            if (Build.VERSION.SDK_INT < 11) {
                return execute(params);
            }
            try {
                AsyncTask.class.getMethod("executeOnExecutor", new Class[]{Executor.class, Object[].class}).invoke(this, new Object[]{AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get((Object) null), params});
                return this;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Unexpected NoSuchMethodException", e);
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException("Unexpected NoSuchFieldException", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unexpected IllegalAccessException", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Unexpected InvocationTargetException", e4);
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ImageLoader.access$1108(ImageLoader.this);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(ImageRequest... requests) {
            for (ImageRequest request : requests) {
                if (request.execute()) {
                    publishProgress(new ImageRequest[]{request});
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(ImageRequest... values) {
            for (ImageRequest request : values) {
                request.publishResult();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            ImageLoader.access$1110(ImageLoader.this);
            ImageLoader.this.flushRequests();
        }
    }

    private static class ImageError {
        private static final int TIMEOUT = 120000;
        private final Throwable mCause;
        private final long mTimestamp;

        public ImageError(Throwable cause) {
            if (cause == null) {
                throw new NullPointerException();
            }
            this.mCause = cause;
            this.mTimestamp = now();
        }

        public boolean isExpired() {
            return now() - this.mTimestamp > 120000;
        }

        public Throwable getCause() {
            return this.mCause;
        }

        private static long now() {
            return SystemClock.elapsedRealtime();
        }
    }
}
