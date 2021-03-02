package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

class Dispatcher {
    static final int AIRPLANE_MODE_CHANGE = 10;
    private static final int AIRPLANE_MODE_OFF = 0;
    private static final int AIRPLANE_MODE_ON = 1;
    private static final int BATCH_DELAY = 200;
    private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
    static final int HUNTER_BATCH_COMPLETE = 8;
    static final int HUNTER_COMPLETE = 4;
    static final int HUNTER_DECODE_FAILED = 6;
    static final int HUNTER_DELAY_NEXT_BATCH = 7;
    static final int HUNTER_RETRY = 5;
    static final int NETWORK_STATE_CHANGE = 9;
    static final int REQUEST_CANCEL = 2;
    static final int REQUEST_GCED = 3;
    static final int REQUEST_SUBMIT = 1;
    private static final int RETRY_DELAY = 500;
    boolean airplaneMode;
    final List<BitmapHunter> batch;
    final Cache cache;
    final Context context;
    final DispatcherThread dispatcherThread = new DispatcherThread();
    final Downloader downloader;
    final Handler handler;
    final Map<String, BitmapHunter> hunterMap;
    final Handler mainThreadHandler;
    NetworkInfo networkInfo;
    final NetworkBroadcastReceiver receiver;
    final ExecutorService service;
    final Stats stats;

    Dispatcher(Context context2, ExecutorService service2, Handler mainThreadHandler2, Downloader downloader2, Cache cache2, Stats stats2) {
        this.dispatcherThread.start();
        this.context = context2;
        this.service = service2;
        this.hunterMap = new LinkedHashMap();
        this.handler = new DispatcherHandler(this.dispatcherThread.getLooper());
        this.downloader = downloader2;
        this.mainThreadHandler = mainThreadHandler2;
        this.cache = cache2;
        this.stats = stats2;
        this.batch = new ArrayList(4);
        this.airplaneMode = Utils.isAirplaneModeOn(this.context);
        this.receiver = new NetworkBroadcastReceiver(this.context);
        this.receiver.register();
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.service.shutdown();
        this.dispatcherThread.quit();
        this.receiver.unregister();
    }

    /* access modifiers changed from: package-private */
    public void dispatchSubmit(Action action) {
        this.handler.sendMessage(this.handler.obtainMessage(1, action));
    }

    /* access modifiers changed from: package-private */
    public void dispatchCancel(Action action) {
        this.handler.sendMessage(this.handler.obtainMessage(2, action));
    }

    /* access modifiers changed from: package-private */
    public void dispatchComplete(BitmapHunter hunter) {
        this.handler.sendMessage(this.handler.obtainMessage(4, hunter));
    }

    /* access modifiers changed from: package-private */
    public void dispatchRetry(BitmapHunter hunter) {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(5, hunter), 500);
    }

    /* access modifiers changed from: package-private */
    public void dispatchFailed(BitmapHunter hunter) {
        this.handler.sendMessage(this.handler.obtainMessage(6, hunter));
    }

    /* access modifiers changed from: package-private */
    public void dispatchNetworkStateChange(NetworkInfo info) {
        this.handler.sendMessage(this.handler.obtainMessage(9, info));
    }

    /* access modifiers changed from: package-private */
    public void dispatchAirplaneModeChange(boolean airplaneMode2) {
        int i;
        Handler handler2 = this.handler;
        Handler handler3 = this.handler;
        if (airplaneMode2) {
            i = 1;
        } else {
            i = 0;
        }
        handler2.sendMessage(handler3.obtainMessage(10, i, 0));
    }

    /* access modifiers changed from: package-private */
    public void performSubmit(Action action) {
        BitmapHunter hunter = this.hunterMap.get(action.getKey());
        if (hunter != null) {
            hunter.attach(action);
        } else if (!this.service.isShutdown()) {
            BitmapHunter hunter2 = BitmapHunter.forRequest(this.context, action.getPicasso(), this, this.cache, this.stats, action, this.downloader);
            hunter2.future = this.service.submit(hunter2);
            this.hunterMap.put(action.getKey(), hunter2);
        }
    }

    /* access modifiers changed from: package-private */
    public void performCancel(Action action) {
        String key = action.getKey();
        BitmapHunter hunter = this.hunterMap.get(key);
        if (hunter != null) {
            hunter.detach(action);
            if (hunter.cancel()) {
                this.hunterMap.remove(key);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void performRetry(BitmapHunter hunter) {
        if (!hunter.isCancelled()) {
            if (this.service.isShutdown()) {
                performError(hunter);
            } else if (hunter.shouldRetry(this.airplaneMode, this.networkInfo)) {
                hunter.future = this.service.submit(hunter);
            } else {
                performError(hunter);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void performComplete(BitmapHunter hunter) {
        if (!hunter.shouldSkipMemoryCache()) {
            this.cache.set(hunter.getKey(), hunter.getResult());
        }
        this.hunterMap.remove(hunter.getKey());
        batch(hunter);
    }

    /* access modifiers changed from: package-private */
    public void performBatchComplete() {
        List<BitmapHunter> copy = new ArrayList<>(this.batch);
        this.batch.clear();
        this.mainThreadHandler.sendMessage(this.mainThreadHandler.obtainMessage(8, copy));
    }

    /* access modifiers changed from: package-private */
    public void performError(BitmapHunter hunter) {
        this.hunterMap.remove(hunter.getKey());
        batch(hunter);
    }

    /* access modifiers changed from: package-private */
    public void performAirplaneModeChange(boolean airplaneMode2) {
        this.airplaneMode = airplaneMode2;
    }

    /* access modifiers changed from: package-private */
    public void performNetworkStateChange(NetworkInfo info) {
        this.networkInfo = info;
        if (this.service instanceof PicassoExecutorService) {
            ((PicassoExecutorService) this.service).adjustThreadCount(info);
        }
    }

    private void batch(BitmapHunter hunter) {
        if (!hunter.isCancelled()) {
            this.batch.add(hunter);
            if (!this.handler.hasMessages(7)) {
                this.handler.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private class DispatcherHandler extends Handler {
        public DispatcherHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            switch (msg.what) {
                case 1:
                    Dispatcher.this.performSubmit((Action) msg.obj);
                    return;
                case 2:
                    Dispatcher.this.performCancel((Action) msg.obj);
                    return;
                case 4:
                    Dispatcher.this.performComplete((BitmapHunter) msg.obj);
                    return;
                case 5:
                    Dispatcher.this.performRetry((BitmapHunter) msg.obj);
                    return;
                case 6:
                    Dispatcher.this.performError((BitmapHunter) msg.obj);
                    return;
                case 7:
                    Dispatcher.this.performBatchComplete();
                    return;
                case 9:
                    Dispatcher.this.performNetworkStateChange((NetworkInfo) msg.obj);
                    return;
                case 10:
                    Dispatcher dispatcher = Dispatcher.this;
                    if (msg.arg1 != 1) {
                        z = false;
                    }
                    dispatcher.performAirplaneModeChange(z);
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + msg.what);
            }
        }
    }

    static class DispatcherThread extends HandlerThread {
        DispatcherThread() {
            super("Picasso-Dispatcher", 10);
        }
    }

    private class NetworkBroadcastReceiver extends BroadcastReceiver {
        private static final String EXTRA_AIRPLANE_STATE = "state";
        private final ConnectivityManager connectivityManager;

        NetworkBroadcastReceiver(Context context) {
            this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        /* access modifiers changed from: package-private */
        public void register() {
            boolean shouldScanState = (Dispatcher.this.service instanceof PicassoExecutorService) && Utils.hasPermission(Dispatcher.this.context, "android.permission.ACCESS_NETWORK_STATE");
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.AIRPLANE_MODE");
            if (shouldScanState) {
                filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            Dispatcher.this.context.registerReceiver(this, filter);
        }

        /* access modifiers changed from: package-private */
        public void unregister() {
            Dispatcher.this.context.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                Dispatcher.this.dispatchAirplaneModeChange(extras.getBoolean(EXTRA_AIRPLANE_STATE, false));
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                Dispatcher.this.dispatchNetworkStateChange(this.connectivityManager.getActiveNetworkInfo());
            }
        }
    }
}
