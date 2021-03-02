package android.support.p021v7.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* renamed from: android.support.v7.widget.bj */
class C0612bj implements ListAdapter, SpinnerAdapter {

    /* renamed from: a */
    private SpinnerAdapter f1461a;

    /* renamed from: b */
    private ListAdapter f1462b;

    public C0612bj(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        this.f1461a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f1462b = (ListAdapter) spinnerAdapter;
        }
        if (theme == null) {
            return;
        }
        if (C0610bh.f1447a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        } else if (spinnerAdapter instanceof C0666dj) {
            C0666dj djVar = (C0666dj) spinnerAdapter;
            if (djVar.mo3312a() == null) {
                djVar.mo3313a(theme);
            }
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f1462b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int getCount() {
        if (this.f1461a == null) {
            return 0;
        }
        return this.f1461a.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f1461a == null) {
            return null;
        }
        return this.f1461a.getDropDownView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        if (this.f1461a == null) {
            return null;
        }
        return this.f1461a.getItem(i);
    }

    public long getItemId(int i) {
        if (this.f1461a == null) {
            return -1;
        }
        return this.f1461a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.f1461a != null && this.f1461a.hasStableIds();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f1462b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i);
        }
        return true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1461a != null) {
            this.f1461a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f1461a != null) {
            this.f1461a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
