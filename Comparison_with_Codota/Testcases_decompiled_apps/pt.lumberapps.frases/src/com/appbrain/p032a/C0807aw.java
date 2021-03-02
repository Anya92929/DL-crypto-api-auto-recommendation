package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cmn.C0708ac;
import com.appbrain.p037f.C1054at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.appbrain.a.aw */
public final class C0807aw {

    /* renamed from: a */
    private final int f2122a;

    /* renamed from: b */
    private final int f2123b;

    /* renamed from: c */
    private final long f2124c;

    /* renamed from: d */
    private final double f2125d;

    /* renamed from: e */
    private final Context f2126e;

    /* renamed from: f */
    private final List f2127f = new ArrayList();

    /* renamed from: g */
    private final C0804at f2128g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final LinkedHashMap f2129h = new C0808ax(this);

    /* renamed from: i */
    private int f2130i;

    /* renamed from: j */
    private long f2131j;

    C0807aw(Context context, C0804at atVar, C1054at atVar2) {
        this.f2126e = context;
        this.f2128g = atVar;
        C0932fm a = C0932fm.m3968a();
        this.f2122a = a.mo3840a("lstadsmn", 10);
        this.f2123b = a.mo3840a("lstadsmx", 40);
        this.f2124c = ((long) a.mo3840a("lstadstm", 120)) * 1000;
        this.f2125d = a.mo3839a("lstadsrn", 0.75d);
        C0956gj.m4057a().mo3886a(context, atVar2, (String) null, (C0708ac) null, true);
    }

    /* renamed from: a */
    public final int mo3655a() {
        return this.f2127f.size();
    }

    /* renamed from: a */
    public final int mo3656a(int i) {
        int binarySearch = Collections.binarySearch(this.f2127f, Integer.valueOf(i));
        if (binarySearch >= 0) {
            return -1;
        }
        return i - ((-binarySearch) - 1);
    }

    /* renamed from: b */
    public final View mo3657b(int i) {
        Integer valueOf = Integer.valueOf(i);
        View view = (View) this.f2129h.get(valueOf);
        if (view != null) {
            return view;
        }
        C0804at atVar = this.f2128g;
        Context context = this.f2126e;
        C0952gf gfVar = new C0952gf(context, new C0805au(atVar));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(gfVar);
        this.f2129h.put(valueOf, frameLayout);
        return frameLayout;
    }

    /* renamed from: b */
    public final void mo3658b() {
        this.f2127f.clear();
        this.f2129h.clear();
    }

    /* renamed from: c */
    public final void mo3659c(int i) {
        if (i < this.f2130i) {
            while (this.f2127f.size() > 0) {
                int size = this.f2127f.size();
                int intValue = ((Integer) this.f2127f.get(size - 1)).intValue();
                if (intValue - size < i) {
                    break;
                }
                this.f2127f.remove(size - 1);
                this.f2129h.remove(Integer.valueOf(intValue));
            }
        } else if (i > this.f2130i) {
            for (int i2 = this.f2130i; i2 < i; i2++) {
                if (this.f2125d <= Math.random()) {
                    int size2 = this.f2127f.size();
                    int i3 = i2 + size2;
                    int intValue2 = i3 - (size2 == 0 ? -1 : ((Integer) this.f2127f.get(size2 - 1)).intValue());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (intValue2 > this.f2123b || (intValue2 > this.f2122a && currentTimeMillis > this.f2131j + this.f2124c)) {
                        this.f2131j = currentTimeMillis;
                        this.f2128g.mo3653a();
                        this.f2127f.add(Integer.valueOf(i3));
                    }
                }
            }
        }
        this.f2130i = i;
    }
}
