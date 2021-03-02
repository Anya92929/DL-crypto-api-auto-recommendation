package android.support.p021v7.widget;

import android.support.p021v7.p022a.C0482d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* renamed from: android.support.v7.widget.cy */
class C0654cy extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ C0652cw f1601a;

    private C0654cy(C0652cw cwVar) {
        this.f1601a = cwVar;
    }

    /* synthetic */ C0654cy(C0652cw cwVar, C0653cx cxVar) {
        this(cwVar);
    }

    public int getCount() {
        return this.f1601a.f1594e.getChildCount();
    }

    public Object getItem(int i) {
        return ((C0657da) this.f1601a.f1594e.getChildAt(i)).mo3294b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f1601a.m2963a((C0482d) getItem(i), true);
        }
        ((C0657da) view).mo3293a((C0482d) getItem(i));
        return view;
    }
}
