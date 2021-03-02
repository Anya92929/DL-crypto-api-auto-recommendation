package android.support.p003v7.widget.util;

import android.support.p003v7.util.SortedList;
import android.support.p003v7.widget.RecyclerView;

/* renamed from: android.support.v7.widget.util.SortedListAdapterCallback */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* renamed from: a */
    final RecyclerView.Adapter f3349a;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.f3349a = adapter;
    }

    public void onChanged(int i, int i2) {
        this.f3349a.notifyItemRangeChanged(i, i2);
    }

    public void onInserted(int i, int i2) {
        this.f3349a.notifyItemRangeInserted(i, i2);
    }

    public void onMoved(int i, int i2) {
        this.f3349a.notifyItemMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.f3349a.notifyItemRangeRemoved(i, i2);
    }
}
