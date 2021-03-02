package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.appbrain.C0984b;
import com.appbrain.p037f.C1054at;
import java.util.List;

/* renamed from: com.appbrain.a.cj */
final class C0848cj extends BaseAdapter implements C0984b {

    /* renamed from: a */
    private final Context f2249a;

    /* renamed from: b */
    private final C0804at f2250b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List f2251c;

    C0848cj(Context context, C0804at atVar) {
        this.f2249a = context;
        this.f2250b = atVar;
        C0956gj.m4057a().mo3887b(context, C1054at.ADLIST_LISTVIEW, "listview", new C0849ck(this), true);
    }

    /* renamed from: a */
    public final int mo3620a(int i) {
        return -1;
    }

    public final int getCount() {
        if (this.f2251c == null) {
            return 0;
        }
        return this.f2251c.size();
    }

    public final Object getItem(int i) {
        return this.f2251c.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.f2250b.mo3652a(this.f2249a, (C0962i) this.f2251c.get(i));
    }

    public final ListAdapter getWrappedAdapter() {
        return null;
    }
}
