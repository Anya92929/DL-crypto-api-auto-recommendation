package com.jackhenry.android.p022a.p023a;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.jackhenry.android.a.a.d */
public abstract class C1352d extends Filter {

    /* renamed from: b */
    final /* synthetic */ C1350b f5565b;

    public C1352d(C1350b bVar) {
        this.f5565b = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Filter.FilterResults mo9275a(List<T> list);

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Filter.FilterResults a;
        new Filter.FilterResults();
        if (this.f5565b.f5556d == null) {
            synchronized (this.f5565b.f5553a) {
                List unused = this.f5565b.f5556d = new ArrayList(this.f5565b.f5555c);
            }
        }
        synchronized (this.f5565b.f5553a) {
            a = mo9275a(Collections.unmodifiableList(this.f5565b.f5556d));
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        List unused = this.f5565b.f5555c = (List) filterResults.values;
        if (filterResults.count > 0) {
            this.f5565b.notifyDataSetChanged();
        } else {
            this.f5565b.notifyDataSetInvalidated();
        }
    }
}
