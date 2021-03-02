package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.actionbarsherlock.view.Menu;
import com.squareup.picasso.Action;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
    static final Handler HANDLER = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 3:
                    Action action = (Action) msg.obj;
                    action.picasso.cancelExistingRequest(action.getTarget());
                    return;
                case 8:
                    for (BitmapHunter hunter : (List) msg.obj) {
                        hunter.picasso.complete(hunter);
                    }
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + msg.what);
            }
        }
    };
    static Picasso singleton = null;
    final Cache cache;
    private final CleanupThread cleanupThread;
    final Context context;
    boolean debugging;
    final Dispatcher dispatcher;
    private final Listener listener;
    final ReferenceQueue<Object> referenceQueue;
    private final RequestTransformer requestTransformer;
    boolean shutdown;
    final Stats stats;
    final Map<Object, Action> targetToAction = new WeakHashMap();
    final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator = new WeakHashMap();

    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc);
    }

    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new RequestTransformer() {
            public Request transformRequest(Request request) {
                return request;
            }
        };

        Request transformRequest(Request request);
    }

    Picasso(Context context2, Dispatcher dispatcher2, Cache cache2, Listener listener2, RequestTransformer requestTransformer2, Stats stats2, boolean debugging2) {
        this.context = context2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.listener = listener2;
        this.requestTransformer = requestTransformer2;
        this.stats = stats2;
        this.debugging = debugging2;
        this.referenceQueue = new ReferenceQueue<>();
        this.cleanupThread = new CleanupThread(this.referenceQueue, HANDLER);
        this.cleanupThread.start();
    }

    public void cancelRequest(ImageView view) {
        cancelExistingRequest(view);
    }

    public void cancelRequest(Target target) {
        cancelExistingRequest(target);
    }

    public RequestCreator load(Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public RequestCreator load(String path) {
        if (path == null) {
            return new RequestCreator(this, (Uri) null, 0);
        }
        if (path.trim().length() != 0) {
            return load(Uri.parse(path));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public RequestCreator load(File file) {
        if (file == null) {
            return new RequestCreator(this, (Uri) null, 0);
        }
        return load(Uri.fromFile(file));
    }

    public RequestCreator load(int resourceId) {
        if (resourceId != 0) {
            return new RequestCreator(this, (Uri) null, resourceId);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public boolean isDebugging() {
        return this.debugging;
    }

    public void setDebugging(boolean debugging2) {
        this.debugging = debugging2;
    }

    public StatsSnapshot getSnapshot() {
        return this.stats.createSnapshot();
    }

    public void shutdown() {
        if (this == singleton) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        } else if (!this.shutdown) {
            this.cache.clear();
            this.cleanupThread.shutdown();
            this.stats.shutdown();
            this.dispatcher.shutdown();
            for (DeferredRequestCreator deferredRequestCreator : this.targetToDeferredRequestCreator.values()) {
                deferredRequestCreator.cancel();
            }
            this.targetToDeferredRequestCreator.clear();
            this.shutdown = true;
        }
    }

    /* access modifiers changed from: package-private */
    public Request transformRequest(Request request) {
        Request transformed = this.requestTransformer.transformRequest(request);
        if (transformed != null) {
            return transformed;
        }
        throw new IllegalStateException("Request transformer " + this.requestTransformer.getClass().getCanonicalName() + " returned null for " + request);
    }

    /* access modifiers changed from: package-private */
    public void defer(ImageView view, DeferredRequestCreator request) {
        this.targetToDeferredRequestCreator.put(view, request);
    }

    /* access modifiers changed from: package-private */
    public void enqueueAndSubmit(Action action) {
        Object target = action.getTarget();
        if (target != null) {
            cancelExistingRequest(target);
            this.targetToAction.put(target, action);
        }
        submit(action);
    }

    /* access modifiers changed from: package-private */
    public void submit(Action action) {
        this.dispatcher.dispatchSubmit(action);
    }

    /* access modifiers changed from: package-private */
    public Bitmap quickMemoryCacheCheck(String key) {
        Bitmap cached = this.cache.get(key);
        if (cached != null) {
            this.stats.dispatchCacheHit();
        } else {
            this.stats.dispatchCacheMiss();
        }
        return cached;
    }

    /* access modifiers changed from: package-private */
    public void complete(BitmapHunter hunter) {
        List<Action> joined = hunter.getActions();
        if (!joined.isEmpty()) {
            Uri uri = hunter.getData().uri;
            Exception exception = hunter.getException();
            Bitmap result = hunter.getResult();
            LoadedFrom from = hunter.getLoadedFrom();
            for (Action join : joined) {
                if (!join.isCancelled()) {
                    this.targetToAction.remove(join.getTarget());
                    if (result == null) {
                        join.error();
                    } else if (from == null) {
                        throw new AssertionError("LoadedFrom cannot be null.");
                    } else {
                        join.complete(result, from);
                    }
                }
            }
            if (this.listener != null && exception != null) {
                this.listener.onImageLoadFailed(this, uri, exception);
            }
        }
    }

    /* access modifiers changed from: private */
    public void cancelExistingRequest(Object target) {
        DeferredRequestCreator deferredRequestCreator;
        Action action = this.targetToAction.remove(target);
        if (action != null) {
            action.cancel();
            this.dispatcher.dispatchCancel(action);
        }
        if ((target instanceof ImageView) && (deferredRequestCreator = this.targetToDeferredRequestCreator.remove((ImageView) target)) != null) {
            deferredRequestCreator.cancel();
        }
    }

    private static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<?> referenceQueue;

        CleanupThread(ReferenceQueue<?> referenceQueue2, Handler handler2) {
            this.referenceQueue = referenceQueue2;
            this.handler = handler2;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    this.handler.sendMessage(this.handler.obtainMessage(3, ((Action.RequestWeakReference) this.referenceQueue.remove()).action));
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e2) {
                    this.handler.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void shutdown() {
            interrupt();
        }
    }

    public static Picasso with(Context context2) {
        if (singleton == null) {
            singleton = new Builder(context2).build();
        }
        return singleton;
    }

    public static class Builder {
        private Cache cache;
        private final Context context;
        private boolean debugging;
        private Downloader downloader;
        private Listener listener;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder(Context context2) {
            if (context2 == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context2.getApplicationContext();
        }

        public Builder downloader(Downloader downloader2) {
            if (downloader2 == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else if (this.downloader != null) {
                throw new IllegalStateException("Downloader already set.");
            } else {
                this.downloader = downloader2;
                return this;
            }
        }

        public Builder executor(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.service != null) {
                throw new IllegalStateException("Executor service already set.");
            } else {
                this.service = executorService;
                return this;
            }
        }

        public Builder memoryCache(Cache memoryCache) {
            if (memoryCache == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.cache != null) {
                throw new IllegalStateException("Memory cache already set.");
            } else {
                this.cache = memoryCache;
                return this;
            }
        }

        public Builder listener(Listener listener2) {
            if (listener2 == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            } else if (this.listener != null) {
                throw new IllegalStateException("Listener already set.");
            } else {
                this.listener = listener2;
                return this;
            }
        }

        public Builder requestTransformer(RequestTransformer transformer2) {
            if (transformer2 == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            } else if (this.transformer != null) {
                throw new IllegalStateException("Transformer already set.");
            } else {
                this.transformer = transformer2;
                return this;
            }
        }

        public Builder debugging(boolean debugging2) {
            this.debugging = debugging2;
            return this;
        }

        public Picasso build() {
            Context context2 = this.context;
            if (this.downloader == null) {
                this.downloader = Utils.createDefaultDownloader(context2);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context2);
            }
            if (this.service == null) {
                this.service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            return new Picasso(context2, new Dispatcher(context2, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, stats, this.debugging);
        }
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-256),
        NETWORK(Menu.CATEGORY_MASK);
        
        final int debugColor;

        private LoadedFrom(int debugColor2) {
            this.debugColor = debugColor2;
        }
    }
}
