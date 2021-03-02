package com.p041b.p042a;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.b.a.a */
public abstract class C1139a extends BaseAdapter {

    /* renamed from: a */
    private final List f3191a;

    protected C1139a() {
        this((List) null);
    }

    protected C1139a(List list) {
        if (list != null) {
            this.f3191a = list;
        } else {
            this.f3191a = new ArrayList();
        }
    }
}
