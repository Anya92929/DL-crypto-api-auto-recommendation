package android.support.p021v7.p022a;

import android.content.Context;
import android.widget.ArrayAdapter;

/* renamed from: android.support.v7.a.ad */
class C0430ad extends ArrayAdapter {
    public C0430ad(Context context, int i, int i2, CharSequence[] charSequenceArr) {
        super(context, i, i2, charSequenceArr);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }
}
