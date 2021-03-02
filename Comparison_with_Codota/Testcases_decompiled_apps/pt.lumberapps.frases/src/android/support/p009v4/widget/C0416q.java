package android.support.p009v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: android.support.v4.widget.q */
class C0416q extends Filter {

    /* renamed from: a */
    C0417r f569a;

    C0416q(C0417r rVar) {
        this.f569a = rVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f569a.mo1883c((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f569a.mo1877a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor a = this.f569a.mo1876a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f569a.mo1879a((Cursor) filterResults.values);
        }
    }
}
