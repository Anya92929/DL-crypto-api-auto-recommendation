package android.support.p003v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.p003v7.util.ThreadUtil;
import android.support.p003v7.util.TileList;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: android.support.v7.util.MessageThreadUtil */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: android.support.v7.util.MessageThreadUtil$MessageQueue */
    class MessageQueue {

        /* renamed from: a */
        private SyncQueueItem f2569a;

        MessageQueue() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized SyncQueueItem mo4976a() {
            SyncQueueItem syncQueueItem;
            if (this.f2569a == null) {
                syncQueueItem = null;
            } else {
                syncQueueItem = this.f2569a;
                this.f2569a = this.f2569a.f2572c;
            }
            return syncQueueItem;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized void mo4977a(int i) {
            while (this.f2569a != null && this.f2569a.what == i) {
                SyncQueueItem syncQueueItem = this.f2569a;
                this.f2569a = this.f2569a.f2572c;
                syncQueueItem.mo4980a();
            }
            if (this.f2569a != null) {
                SyncQueueItem syncQueueItem2 = this.f2569a;
                SyncQueueItem a = syncQueueItem2.f2572c;
                while (a != null) {
                    SyncQueueItem a2 = a.f2572c;
                    if (a.what == i) {
                        SyncQueueItem unused = syncQueueItem2.f2572c = a2;
                        a.mo4980a();
                    } else {
                        syncQueueItem2 = a;
                    }
                    a = a2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized void mo4978a(SyncQueueItem syncQueueItem) {
            SyncQueueItem unused = syncQueueItem.f2572c = this.f2569a;
            this.f2569a = syncQueueItem;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public synchronized void mo4979b(SyncQueueItem syncQueueItem) {
            if (this.f2569a == null) {
                this.f2569a = syncQueueItem;
            } else {
                SyncQueueItem syncQueueItem2 = this.f2569a;
                while (syncQueueItem2.f2572c != null) {
                    syncQueueItem2 = syncQueueItem2.f2572c;
                }
                SyncQueueItem unused = syncQueueItem2.f2572c = syncQueueItem;
            }
        }
    }

    /* renamed from: android.support.v7.util.MessageThreadUtil$SyncQueueItem */
    class SyncQueueItem {

        /* renamed from: a */
        private static SyncQueueItem f2570a;

        /* renamed from: b */
        private static final Object f2571b = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public SyncQueueItem f2572c;
        public Object data;
        public int what;

        SyncQueueItem() {
        }

        /* renamed from: a */
        static SyncQueueItem m1672a(int i, int i2, int i3) {
            return m1673a(i, i2, i3, 0, 0, 0, (Object) null);
        }

        /* renamed from: a */
        static SyncQueueItem m1673a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f2571b) {
                if (f2570a == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = f2570a;
                    f2570a = f2570a.f2572c;
                    syncQueueItem.f2572c = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        /* renamed from: a */
        static SyncQueueItem m1674a(int i, int i2, Object obj) {
            return m1673a(i, i2, 0, 0, 0, 0, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4980a() {
            this.f2572c = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (f2571b) {
                if (f2570a != null) {
                    this.f2572c = f2570a;
                }
                f2570a = this;
            }
        }
    }

    MessageThreadUtil() {
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>() {
            /* access modifiers changed from: private */

            /* renamed from: c */
            public final MessageQueue f2565c = new MessageQueue();

            /* renamed from: d */
            private final Executor f2566d = Executors.newSingleThreadExecutor();

            /* renamed from: e */
            private Runnable f2567e = new Runnable() {
                public void run() {
                    SyncQueueItem a = C02792.this.f2565c.mo4976a();
                    if (a != null) {
                        switch (a.what) {
                            case 1:
                                C02792.this.f2565c.mo4977a(1);
                                backgroundCallback.refresh(a.arg1);
                                return;
                            case 2:
                                C02792.this.f2565c.mo4977a(2);
                                C02792.this.f2565c.mo4977a(3);
                                backgroundCallback.updateRange(a.arg1, a.arg2, a.arg3, a.arg4, a.arg5);
                                return;
                            case 3:
                                backgroundCallback.loadTile(a.arg1, a.arg2);
                                return;
                            case 4:
                                backgroundCallback.recycleTile((TileList.Tile) a.data);
                                return;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + a.what);
                                return;
                        }
                    }
                }
            };

            /* renamed from: a */
            private void m1666a(SyncQueueItem syncQueueItem) {
                this.f2565c.mo4979b(syncQueueItem);
                this.f2566d.execute(this.f2567e);
            }

            /* renamed from: b */
            private void m1667b(SyncQueueItem syncQueueItem) {
                this.f2565c.mo4978a(syncQueueItem);
                this.f2566d.execute(this.f2567e);
            }

            public void loadTile(int i, int i2) {
                m1666a(SyncQueueItem.m1672a(3, i, i2));
            }

            public void recycleTile(TileList.Tile<T> tile) {
                m1666a(SyncQueueItem.m1674a(4, 0, (Object) tile));
            }

            public void refresh(int i) {
                m1667b(SyncQueueItem.m1674a(1, i, (Object) null));
            }

            public void updateRange(int i, int i2, int i3, int i4, int i5) {
                m1667b(SyncQueueItem.m1673a(2, i, i2, i3, i4, i5, (Object) null));
            }
        };
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>() {
            /* access modifiers changed from: private */

            /* renamed from: c */
            public final MessageQueue f2559c = new MessageQueue();

            /* renamed from: d */
            private final Handler f2560d = new Handler(Looper.getMainLooper());

            /* renamed from: e */
            private Runnable f2561e = new Runnable() {
                public void run() {
                    SyncQueueItem a = C02771.this.f2559c.mo4976a();
                    while (a != null) {
                        switch (a.what) {
                            case 1:
                                mainThreadCallback.updateItemCount(a.arg1, a.arg2);
                                break;
                            case 2:
                                mainThreadCallback.addTile(a.arg1, (TileList.Tile) a.data);
                                break;
                            case 3:
                                mainThreadCallback.removeTile(a.arg1, a.arg2);
                                break;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + a.what);
                                break;
                        }
                        a = C02771.this.f2559c.mo4976a();
                    }
                }
            };

            /* renamed from: a */
            private void m1664a(SyncQueueItem syncQueueItem) {
                this.f2559c.mo4979b(syncQueueItem);
                this.f2560d.post(this.f2561e);
            }

            public void addTile(int i, TileList.Tile<T> tile) {
                m1664a(SyncQueueItem.m1674a(2, i, (Object) tile));
            }

            public void removeTile(int i, int i2) {
                m1664a(SyncQueueItem.m1672a(3, i, i2));
            }

            public void updateItemCount(int i, int i2) {
                m1664a(SyncQueueItem.m1672a(1, i, i2));
            }
        };
    }
}
