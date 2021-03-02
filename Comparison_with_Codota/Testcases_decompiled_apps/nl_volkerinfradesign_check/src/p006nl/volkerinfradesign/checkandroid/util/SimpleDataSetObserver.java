package p006nl.volkerinfradesign.checkandroid.util;

import android.database.DataSetObserver;

/* renamed from: nl.volkerinfradesign.checkandroid.util.SimpleDataSetObserver */
public final class SimpleDataSetObserver extends DataSetObserver {

    /* renamed from: a */
    private final ObserverCallback f5679a;

    /* renamed from: nl.volkerinfradesign.checkandroid.util.SimpleDataSetObserver$ObserverCallback */
    public interface ObserverCallback {
        void onChanged();

        void onInvalidated();
    }

    public SimpleDataSetObserver(ObserverCallback observerCallback) {
        this.f5679a = observerCallback;
    }

    public void onChanged() {
        super.onChanged();
        this.f5679a.onChanged();
    }

    public void onInvalidated() {
        super.onInvalidated();
        this.f5679a.onInvalidated();
    }
}
