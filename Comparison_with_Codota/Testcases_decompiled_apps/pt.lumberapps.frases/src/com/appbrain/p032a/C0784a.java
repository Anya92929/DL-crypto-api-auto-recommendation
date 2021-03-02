package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.appbrain.C0984b;
import com.appbrain.p035d.C1026a;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.a */
final class C0784a extends BaseAdapter implements C0984b, C1026a {

    /* renamed from: a */
    private final ListAdapter f2062a;

    /* renamed from: b */
    private final C0807aw f2063b;

    C0784a(Context context, ListAdapter listAdapter, C0804at atVar) {
        this.f2062a = listAdapter;
        this.f2063b = new C0807aw(context, atVar, C1054at.IN_STREAM_AD_LISTVIEW);
        notifyDataSetChanged();
        listAdapter.registerDataSetObserver(new C0811b(this));
    }

    /* renamed from: a */
    public final int mo3620a(int i) {
        return this.f2063b.mo3656a(i);
    }

    public final int getCount() {
        return this.f2062a.getCount() + this.f2063b.mo3655a();
    }

    public final Object getItem(int i) {
        int a = this.f2063b.mo3656a(i);
        if (a == -1) {
            return null;
        }
        return this.f2062a.getItem(a);
    }

    public final long getItemId(int i) {
        int a = this.f2063b.mo3656a(i);
        if (a == -1) {
            return -1;
        }
        return this.f2062a.getItemId(a);
    }

    public final int getItemViewType(int i) {
        int a = this.f2063b.mo3656a(i);
        if (a == -1) {
            return -1;
        }
        return this.f2062a.getItemViewType(a);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int a = this.f2063b.mo3656a(i);
        return a == -1 ? this.f2063b.mo3657b(i) : this.f2062a.getView(a, view, viewGroup);
    }

    public final int getViewTypeCount() {
        return this.f2062a.getViewTypeCount();
    }

    public final ListAdapter getWrappedAdapter() {
        return this.f2062a;
    }

    public final boolean isEnabled(int i) {
        int a = this.f2063b.mo3656a(i);
        if (a == -1) {
            return true;
        }
        return this.f2062a.isEnabled(a);
    }

    public final void notifyDataSetChanged() {
        this.f2063b.mo3659c(this.f2062a.getCount());
        super.notifyDataSetChanged();
    }

    public final void notifyDataSetInvalidated() {
        this.f2063b.mo3658b();
        super.notifyDataSetInvalidated();
    }
}
