package android.support.p003v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* renamed from: android.support.v7.util.TileList */
class TileList<T> {

    /* renamed from: a */
    final int f2586a;

    /* renamed from: b */
    Tile<T> f2587b;

    /* renamed from: c */
    private final SparseArray<Tile<T>> f2588c = new SparseArray<>(10);

    /* renamed from: android.support.v7.util.TileList$Tile */
    public class Tile<T> {

        /* renamed from: a */
        Tile<T> f2589a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (Object[]) Array.newInstance(cls, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5009a(int i) {
            return this.mStartPosition <= i && i < this.mStartPosition + this.mItemCount;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public T mo5010b(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }

    public TileList(int i) {
        this.f2586a = i;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.f2588c.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f2588c.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.f2588c.valueAt(indexOfKey);
        this.f2588c.setValueAt(indexOfKey, tile);
        if (this.f2587b != valueAt) {
            return valueAt;
        }
        this.f2587b = tile;
        return valueAt;
    }

    public void clear() {
        this.f2588c.clear();
    }

    public Tile<T> getAtIndex(int i) {
        return this.f2588c.valueAt(i);
    }

    public T getItemAt(int i) {
        if (this.f2587b == null || !this.f2587b.mo5009a(i)) {
            int indexOfKey = this.f2588c.indexOfKey(i - (i % this.f2586a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f2587b = this.f2588c.valueAt(indexOfKey);
        }
        return this.f2587b.mo5010b(i);
    }

    public Tile<T> removeAtPos(int i) {
        Tile<T> tile = this.f2588c.get(i);
        if (this.f2587b == tile) {
            this.f2587b = null;
        }
        this.f2588c.delete(i);
        return tile;
    }

    public int size() {
        return this.f2588c.size();
    }
}
