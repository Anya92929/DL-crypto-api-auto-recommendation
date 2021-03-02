package com.jackhenry.android.p022a.p023a;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.android.a.a.c */
class C1351c extends C1350b<T>.C1352d {

    /* renamed from: a */
    final /* synthetic */ C1350b f5564a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1351c(C1350b bVar) {
        super(bVar);
        this.f5564a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Filter.FilterResults mo9274a(List<T> list) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = new ArrayList(list);
        filterResults.count = list.size();
        return filterResults;
    }
}
