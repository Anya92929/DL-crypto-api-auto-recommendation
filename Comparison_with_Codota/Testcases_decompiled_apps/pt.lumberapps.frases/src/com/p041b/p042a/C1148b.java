package com.p041b.p042a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.p041b.p042a.p045b.C1149a;
import com.p041b.p042a.p045b.C1151c;
import com.p041b.p042a.p045b.C1152d;

/* renamed from: com.b.a.b */
public abstract class C1148b extends BaseAdapter implements SectionIndexer, C1152d {

    /* renamed from: a */
    private final BaseAdapter f3207a;

    /* renamed from: b */
    private C1151c f3208b;

    protected C1148b(BaseAdapter baseAdapter) {
        this.f3207a = baseAdapter;
    }

    /* renamed from: a */
    public BaseAdapter mo4466a() {
        return this.f3207a;
    }

    /* renamed from: a */
    public void mo4467a(AbsListView absListView) {
        mo4459a((C1151c) new C1149a(absListView));
    }

    /* renamed from: a */
    public void mo4459a(C1151c cVar) {
        this.f3208b = cVar;
        if (this.f3207a instanceof C1152d) {
            ((C1152d) this.f3207a).mo4459a(cVar);
        }
    }

    public boolean areAllItemsEnabled() {
        return this.f3207a.areAllItemsEnabled();
    }

    /* renamed from: b */
    public C1151c mo4469b() {
        return this.f3208b;
    }

    public int getCount() {
        return this.f3207a.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.f3207a.getDropDownView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.f3207a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f3207a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f3207a.getItemViewType(i);
    }

    public int getPositionForSection(int i) {
        if (this.f3207a instanceof SectionIndexer) {
            return ((SectionIndexer) this.f3207a).getPositionForSection(i);
        }
        return 0;
    }

    public int getSectionForPosition(int i) {
        if (this.f3207a instanceof SectionIndexer) {
            return ((SectionIndexer) this.f3207a).getSectionForPosition(i);
        }
        return 0;
    }

    public Object[] getSections() {
        return this.f3207a instanceof SectionIndexer ? ((SectionIndexer) this.f3207a).getSections() : new Object[0];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f3207a.getView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.f3207a.getViewTypeCount();
    }

    public boolean hasStableIds() {
        return this.f3207a.hasStableIds();
    }

    public boolean isEmpty() {
        return this.f3207a.isEmpty();
    }

    public boolean isEnabled(int i) {
        return this.f3207a.isEnabled(i);
    }

    public void notifyDataSetChanged() {
        if (!(this.f3207a instanceof C1139a)) {
            this.f3207a.notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        this.f3207a.notifyDataSetInvalidated();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f3207a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f3207a.unregisterDataSetObserver(dataSetObserver);
    }
}
