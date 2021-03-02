package com.p041b.p042a.p043a.p044a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p041b.p042a.p043a.C1146b;
import com.p046c.p047a.C1153a;
import com.p046c.p047a.C1187q;

/* renamed from: com.b.a.a.a.c */
public class C1143c extends C1146b {
    public C1143c(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1153a mo4462b(ViewGroup viewGroup, View view) {
        return C1187q.m5415a(view, "translationY", (float) (viewGroup.getMeasuredHeight() >> 1), 0.0f);
    }
}
