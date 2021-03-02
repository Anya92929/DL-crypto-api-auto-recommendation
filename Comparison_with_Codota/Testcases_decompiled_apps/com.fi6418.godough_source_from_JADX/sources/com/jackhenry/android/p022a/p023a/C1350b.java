package com.jackhenry.android.p022a.p023a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.jackhenry.android.p022a.C1359f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.android.a.a.b */
public class C1350b<T> extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f5553a;

    /* renamed from: b */
    private boolean f5554b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<T> f5555c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<T> f5556d;

    /* renamed from: e */
    private LayoutInflater f5557e;

    /* renamed from: f */
    private C1353e<T> f5558f;

    /* renamed from: g */
    private int f5559g;

    /* renamed from: h */
    private int f5560h;

    /* renamed from: i */
    private int f5561i;

    /* renamed from: j */
    private int f5562j;

    /* renamed from: k */
    private Filter f5563k;

    public C1350b(Context context, C1353e<T> eVar) {
        this(context, eVar, C1359f.list_item_top, C1359f.list_item_middle, C1359f.list_item_bottom, C1359f.list_item_single);
    }

    public C1350b(Context context, C1353e<T> eVar, int i, int i2, int i3, int i4) {
        this.f5553a = new Object();
        this.f5555c = new ArrayList();
        this.f5557e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5558f = eVar;
        this.f5559g = i;
        this.f5560h = i2;
        this.f5561i = i3;
        this.f5562j = i4;
    }

    /* renamed from: a */
    public T mo9263a(int i) {
        return this.f5555c.get(i);
    }

    /* renamed from: a */
    public void mo9264a() {
        synchronized (this.f5553a) {
            this.f5556d = null;
            this.f5555c.clear();
        }
    }

    /* renamed from: a */
    public void mo9265a(List<T> list) {
        synchronized (this.f5553a) {
            if (this.f5556d != null) {
                this.f5556d.addAll(list);
            } else {
                this.f5555c.addAll(list);
            }
        }
    }

    /* renamed from: a */
    public void mo9266a(boolean z) {
        this.f5554b = z;
    }

    /* renamed from: b */
    public void mo9267b(int i) {
        synchronized (this.f5553a) {
            if (this.f5556d != null) {
                this.f5556d.remove(i);
            } else {
                this.f5555c.remove(i);
            }
        }
    }

    /* renamed from: b */
    public void mo9268b(List<T> list) {
        this.f5555c = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        if (this.f5555c == null) {
            return 0;
        }
        return this.f5555c.size();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.jackhenry.android.a.a.c, android.widget.Filter] */
    public Filter getFilter() {
        if (this.f5563k == null) {
            this.f5563k = new C1351c(this);
        }
        return this.f5563k;
    }

    public Object getItem(int i) {
        return this.f5555c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f5557e.inflate(C1359f.list_item, (ViewGroup) null, false) : view;
        ((ViewGroup) inflate).removeAllViews();
        View inflate2 = this.f5557e.inflate((this.f5554b || this.f5555c.size() != 1) ? (this.f5554b || i != this.f5555c.size() + -1) ? i == 0 ? this.f5559g : this.f5560h : this.f5561i : this.f5562j, (ViewGroup) null, false);
        this.f5558f.mo9279a(this.f5557e, (ViewGroup) inflate2, this.f5555c.get(i));
        inflate.setTag(this.f5555c.get(i));
        ((ViewGroup) inflate).addView(inflate2);
        return inflate;
    }
}
