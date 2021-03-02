package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Parcelable.Creator<LogicalFilter> CREATOR = new C0524i();

    /* renamed from: BR */
    final int f1147BR;

    /* renamed from: QC */
    final Operator f1148QC;

    /* renamed from: QP */
    final List<FilterHolder> f1149QP;

    /* renamed from: Qx */
    private List<Filter> f1150Qx;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.f1147BR = versionCode;
        this.f1148QC = operator;
        this.f1149QP = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.f1147BR = 1;
        this.f1148QC = operator;
        this.f1149QP = new ArrayList(additionalFilters.length + 1);
        this.f1149QP.add(new FilterHolder(filter));
        this.f1150Qx = new ArrayList(additionalFilters.length + 1);
        this.f1150Qx.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.f1149QP.add(new FilterHolder(filter2));
            this.f1150Qx.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.f1147BR = 1;
        this.f1148QC = operator;
        this.f1150Qx = new ArrayList();
        this.f1149QP = new ArrayList();
        for (Filter next : filters) {
            this.f1150Qx.add(next);
            this.f1149QP.add(new FilterHolder(next));
        }
    }

    /* renamed from: a */
    public <T> T mo5177a(C0521f<T> fVar) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.f1149QP) {
            arrayList.add(filter.getFilter().mo5177a(fVar));
        }
        return fVar.mo5208b(this.f1148QC, (List<T>) arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0524i.m1512a(this, out, flags);
    }
}
