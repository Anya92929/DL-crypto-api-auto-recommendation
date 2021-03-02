package com.p004a.p005a.p006a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* renamed from: com.a.a.a.a */
public class C0342a extends BaseAdapter {

    /* renamed from: a */
    private ListAdapter f3350a = null;

    public C0342a(ListAdapter listAdapter) {
        this.f3350a = listAdapter;
        listAdapter.registerDataSetObserver(new C0343b(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ListAdapter mo6260a() {
        return this.f3350a;
    }

    public boolean areAllItemsEnabled() {
        return this.f3350a.areAllItemsEnabled();
    }

    public int getCount() {
        return this.f3350a.getCount();
    }

    public Object getItem(int i) {
        return this.f3350a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f3350a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f3350a.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f3350a.getView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.f3350a.getViewTypeCount();
    }

    public boolean isEnabled(int i) {
        return this.f3350a.isEnabled(i);
    }
}
