package com.p041b.p042a.p043a.p044a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p041b.p042a.p043a.C1140a;
import com.p046c.p047a.C1153a;
import com.p046c.p047a.C1187q;

/* renamed from: com.b.a.a.a.b */
public class C1142b extends C1140a {

    /* renamed from: b */
    private final float f3197b;

    public C1142b(BaseAdapter baseAdapter) {
        this(baseAdapter, 0.8f);
    }

    public C1142b(BaseAdapter baseAdapter, float f) {
        super(baseAdapter);
        this.f3197b = f;
    }

    /* renamed from: a */
    public C1153a[] mo4460a(ViewGroup viewGroup, View view) {
        return new C1187q[]{C1187q.m5415a(view, "scaleX", this.f3197b, 1.0f), C1187q.m5415a(view, "scaleY", this.f3197b, 1.0f)};
    }
}
