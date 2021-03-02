package android.support.p009v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.be */
public abstract class C0389be extends C0412m {

    /* renamed from: j */
    private int f514j;

    /* renamed from: k */
    private int f515k;

    /* renamed from: l */
    private LayoutInflater f516l;

    public C0389be(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f515k = i;
        this.f514j = i;
        this.f516l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public View mo1805a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f516l.inflate(this.f514j, viewGroup, false);
    }

    /* renamed from: b */
    public View mo1806b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f516l.inflate(this.f515k, viewGroup, false);
    }
}
