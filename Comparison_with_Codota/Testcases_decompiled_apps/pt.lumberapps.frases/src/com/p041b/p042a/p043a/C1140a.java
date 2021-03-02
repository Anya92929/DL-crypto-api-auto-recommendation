package com.p041b.p042a.p043a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.p041b.p042a.C1148b;
import com.p041b.p042a.p045b.C1150b;
import com.p041b.p042a.p045b.C1151c;
import com.p046c.p047a.C1153a;
import com.p046c.p047a.C1187q;

/* renamed from: com.b.a.a.a */
public abstract class C1140a extends C1148b {

    /* renamed from: a */
    static final /* synthetic */ boolean f3192a = (!C1140a.class.desiredAssertionStatus());

    /* renamed from: b */
    private C1147c f3193b;

    /* renamed from: c */
    private boolean f3194c = true;

    /* renamed from: d */
    private boolean f3195d = true;

    /* renamed from: e */
    private int f3196e = -1;

    protected C1140a(BaseAdapter baseAdapter) {
        super(baseAdapter);
        if (baseAdapter instanceof C1140a) {
            ((C1140a) baseAdapter).m5224c();
        }
    }

    /* renamed from: a */
    private void m5223a(int i, View view, ViewGroup viewGroup) {
        if (f3192a || this.f3193b != null) {
            this.f3195d = this.f3195d && (this.f3196e == -1 || this.f3196e == i);
            if (this.f3195d) {
                this.f3196e = i;
                this.f3193b.mo4463a(-1);
            }
            this.f3193b.mo4464a(i, view, C1150b.m5247a(mo4466a() instanceof C1140a ? ((C1140a) mo4466a()).mo4460a(viewGroup, view) : new C1153a[0], mo4460a(viewGroup, view), C1187q.m5415a(view, "alpha", 0.0f, 1.0f)));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private void m5224c() {
        this.f3194c = false;
    }

    /* renamed from: a */
    public void mo4459a(C1151c cVar) {
        super.mo4459a(cVar);
        this.f3193b = new C1147c(cVar);
    }

    /* renamed from: a */
    public abstract C1153a[] mo4460a(ViewGroup viewGroup, View view);

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f3194c) {
            if (mo4469b() == null) {
                throw new IllegalStateException("Call setAbsListView() on this AnimationAdapter first!");
            } else if (!f3192a && this.f3193b == null) {
                throw new AssertionError();
            } else if (view != null) {
                this.f3193b.mo4465a(view);
            }
        }
        View view2 = super.getView(i, view, viewGroup);
        if (this.f3194c) {
            m5223a(i, view2, viewGroup);
        }
        return view2;
    }
}
