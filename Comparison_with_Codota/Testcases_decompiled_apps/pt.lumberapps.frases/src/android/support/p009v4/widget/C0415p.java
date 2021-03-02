package android.support.p009v4.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.widget.p */
class C0415p extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ C0412m f568a;

    private C0415p(C0412m mVar) {
        this.f568a = mVar;
    }

    public void onChanged() {
        this.f568a.f558a = true;
        this.f568a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f568a.f558a = false;
        this.f568a.notifyDataSetInvalidated();
    }
}
