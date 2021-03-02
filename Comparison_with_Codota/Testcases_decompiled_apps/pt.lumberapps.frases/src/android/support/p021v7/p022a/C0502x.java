package android.support.p021v7.p022a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.a.x */
class C0502x extends ArrayAdapter {

    /* renamed from: a */
    final /* synthetic */ ListView f868a;

    /* renamed from: b */
    final /* synthetic */ C0501w f869b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0502x(C0501w wVar, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        super(context, i, i2, charSequenceArr);
        this.f869b = wVar;
        this.f868a = listView;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f869b.f831C != null && this.f869b.f831C[i]) {
            this.f868a.setItemChecked(i, true);
        }
        return view2;
    }
}
