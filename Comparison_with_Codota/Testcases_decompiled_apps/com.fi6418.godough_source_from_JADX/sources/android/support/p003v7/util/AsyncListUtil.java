package android.support.p003v7.util;

import android.support.p003v7.util.ThreadUtil;
import android.support.p003v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* renamed from: android.support.v7.util.AsyncListUtil */
public class AsyncListUtil<T> {

    /* renamed from: a */
    final Class<T> f2531a;

    /* renamed from: b */
    final int f2532b;

    /* renamed from: c */
    final DataCallback<T> f2533c;

    /* renamed from: d */
    final ViewCallback f2534d;

    /* renamed from: e */
    final TileList<T> f2535e;

    /* renamed from: f */
    final ThreadUtil.MainThreadCallback<T> f2536f;

    /* renamed from: g */
    final ThreadUtil.BackgroundCallback<T> f2537g;

    /* renamed from: h */
    final int[] f2538h = new int[2];

    /* renamed from: i */
    final int[] f2539i = new int[2];

    /* renamed from: j */
    final int[] f2540j = new int[2];

    /* renamed from: k */
    int f2541k = 0;

    /* renamed from: l */
    int f2542l = this.f2541k;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2543m;

    /* renamed from: n */
    private int f2544n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f2545o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final SparseIntArray f2546p = new SparseIntArray();

    /* renamed from: q */
    private final ThreadUtil.MainThreadCallback<T> f2547q = new ThreadUtil.MainThreadCallback<T>() {
        /* renamed from: a */
        private void m1654a() {
            for (int i = 0; i < AsyncListUtil.this.f2535e.size(); i++) {
                AsyncListUtil.this.f2537g.recycleTile(AsyncListUtil.this.f2535e.getAtIndex(i));
            }
            AsyncListUtil.this.f2535e.clear();
        }

        /* renamed from: a */
        private boolean m1655a(int i) {
            return i == AsyncListUtil.this.f2542l;
        }

        public void addTile(int i, TileList.Tile<T> tile) {
            if (!m1655a(i)) {
                AsyncListUtil.this.f2537g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.f2535e.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.f2537g.recycleTile(addOrReplace);
            }
            int i2 = tile.mItemCount + tile.mStartPosition;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.f2546p.size()) {
                int keyAt = AsyncListUtil.this.f2546p.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    AsyncListUtil.this.f2546p.removeAt(i3);
                    AsyncListUtil.this.f2534d.onItemLoaded(keyAt);
                }
            }
        }

        public void removeTile(int i, int i2) {
            if (m1655a(i)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.f2535e.removeAtPos(i2);
                if (removeAtPos == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                } else {
                    AsyncListUtil.this.f2537g.recycleTile(removeAtPos);
                }
            }
        }

        public void updateItemCount(int i, int i2) {
            if (m1655a(i)) {
                int unused = AsyncListUtil.this.f2545o = i2;
                AsyncListUtil.this.f2534d.onDataRefresh();
                AsyncListUtil.this.f2541k = AsyncListUtil.this.f2542l;
                m1654a();
                boolean unused2 = AsyncListUtil.this.f2543m = false;
                AsyncListUtil.this.m1653b();
            }
        }
    };

    /* renamed from: r */
    private final ThreadUtil.BackgroundCallback<T> f2548r = new ThreadUtil.BackgroundCallback<T>() {

        /* renamed from: a */
        final SparseBooleanArray f2550a = new SparseBooleanArray();

        /* renamed from: c */
        private TileList.Tile<T> f2552c;

        /* renamed from: d */
        private int f2553d;

        /* renamed from: e */
        private int f2554e;

        /* renamed from: f */
        private int f2555f;

        /* renamed from: g */
        private int f2556g;

        /* renamed from: a */
        private int m1656a(int i) {
            return i - (i % AsyncListUtil.this.f2532b);
        }

        /* renamed from: a */
        private TileList.Tile<T> m1657a() {
            if (this.f2552c == null) {
                return new TileList.Tile<>(AsyncListUtil.this.f2531a, AsyncListUtil.this.f2532b);
            }
            TileList.Tile<T> tile = this.f2552c;
            this.f2552c = this.f2552c.f2589a;
            return tile;
        }

        /* renamed from: a */
        private void m1658a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.f2537g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.f2532b;
            }
        }

        /* renamed from: a */
        private void m1659a(TileList.Tile<T> tile) {
            this.f2550a.put(tile.mStartPosition, true);
            AsyncListUtil.this.f2536f.addTile(this.f2553d, tile);
        }

        /* renamed from: b */
        private boolean m1660b(int i) {
            return this.f2550a.get(i);
        }

        /* renamed from: c */
        private void m1661c(int i) {
            this.f2550a.delete(i);
            AsyncListUtil.this.f2536f.removeTile(this.f2553d, i);
        }

        /* renamed from: d */
        private void m1662d(int i) {
            int maxCachedTiles = AsyncListUtil.this.f2533c.getMaxCachedTiles();
            while (this.f2550a.size() >= maxCachedTiles) {
                int keyAt = this.f2550a.keyAt(0);
                int keyAt2 = this.f2550a.keyAt(this.f2550a.size() - 1);
                int i2 = this.f2555f - keyAt;
                int i3 = keyAt2 - this.f2556g;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    m1661c(keyAt);
                } else if (i3 <= 0) {
                    return;
                } else {
                    if (i2 < i3 || i == 1) {
                        m1661c(keyAt2);
                    } else {
                        return;
                    }
                }
            }
        }

        public void loadTile(int i, int i2) {
            if (!m1660b(i)) {
                TileList.Tile a = m1657a();
                a.mStartPosition = i;
                a.mItemCount = Math.min(AsyncListUtil.this.f2532b, this.f2554e - a.mStartPosition);
                AsyncListUtil.this.f2533c.fillData(a.mItems, a.mStartPosition, a.mItemCount);
                m1662d(i2);
                m1659a(a);
            }
        }

        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f2533c.recycleData(tile.mItems, tile.mItemCount);
            tile.f2589a = this.f2552c;
            this.f2552c = tile;
        }

        public void refresh(int i) {
            this.f2553d = i;
            this.f2550a.clear();
            this.f2554e = AsyncListUtil.this.f2533c.refreshData();
            AsyncListUtil.this.f2536f.updateItemCount(this.f2553d, this.f2554e);
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                int a = m1656a(i);
                int a2 = m1656a(i2);
                this.f2555f = m1656a(i3);
                this.f2556g = m1656a(i4);
                if (i5 == 1) {
                    m1658a(this.f2555f, a2, i5, true);
                    m1658a(AsyncListUtil.this.f2532b + a2, this.f2556g, i5, false);
                    return;
                }
                m1658a(a, this.f2556g, i5, false);
                m1658a(this.f2555f, a - AsyncListUtil.this.f2532b, i5, true);
            }
        }
    };

    /* renamed from: android.support.v7.util.AsyncListUtil$DataCallback */
    public abstract class DataCallback<T> {
        public abstract void fillData(T[] tArr, int i, int i2);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(T[] tArr, int i) {
        }

        public abstract int refreshData();
    }

    /* renamed from: android.support.v7.util.AsyncListUtil$ViewCallback */
    public abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        public abstract void getItemRangeInto(int[] iArr);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.f2531a = cls;
        this.f2532b = i;
        this.f2533c = dataCallback;
        this.f2534d = viewCallback;
        this.f2535e = new TileList<>(this.f2532b);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f2536f = messageThreadUtil.getMainThreadProxy(this.f2547q);
        this.f2537g = messageThreadUtil.getBackgroundProxy(this.f2548r);
        refresh();
    }

    /* renamed from: a */
    private boolean m1650a() {
        return this.f2542l != this.f2541k;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1653b() {
        this.f2534d.getItemRangeInto(this.f2538h);
        if (this.f2538h[0] <= this.f2538h[1] && this.f2538h[0] >= 0 && this.f2538h[1] < this.f2545o) {
            if (!this.f2543m) {
                this.f2544n = 0;
            } else if (this.f2538h[0] > this.f2539i[1] || this.f2539i[0] > this.f2538h[1]) {
                this.f2544n = 0;
            } else if (this.f2538h[0] < this.f2539i[0]) {
                this.f2544n = 1;
            } else if (this.f2538h[0] > this.f2539i[0]) {
                this.f2544n = 2;
            }
            this.f2539i[0] = this.f2538h[0];
            this.f2539i[1] = this.f2538h[1];
            this.f2534d.extendRangeInto(this.f2538h, this.f2540j, this.f2544n);
            this.f2540j[0] = Math.min(this.f2538h[0], Math.max(this.f2540j[0], 0));
            this.f2540j[1] = Math.max(this.f2538h[1], Math.min(this.f2540j[1], this.f2545o - 1));
            this.f2537g.updateRange(this.f2538h[0], this.f2538h[1], this.f2540j[0], this.f2540j[1], this.f2544n);
        }
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.f2545o) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.f2545o);
        }
        T itemAt = this.f2535e.getItemAt(i);
        if (itemAt == null && !m1650a()) {
            this.f2546p.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.f2545o;
    }

    public void onRangeChanged() {
        if (!m1650a()) {
            m1653b();
            this.f2543m = true;
        }
    }

    public void refresh() {
        this.f2546p.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f2537g;
        int i = this.f2542l + 1;
        this.f2542l = i;
        backgroundCallback.refresh(i);
    }
}
