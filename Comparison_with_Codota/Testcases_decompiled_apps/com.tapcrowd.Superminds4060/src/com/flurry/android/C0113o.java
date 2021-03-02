package com.flurry.android;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.flurry.android.o */
final class C0113o extends RelativeLayout {

    /* renamed from: a */
    private C0120v f210a;

    /* renamed from: b */
    private Context f211b;

    /* renamed from: c */
    private String f212c;

    /* renamed from: d */
    private int f213d;

    /* renamed from: e */
    private boolean f214e;

    /* renamed from: f */
    private boolean f215f;

    C0113o(C0120v vVar, Context context, String str, int i) {
        super(context);
        this.f210a = vVar;
        this.f211b = context;
        this.f212c = str;
        this.f213d = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3323a() {
        if (!this.f214e) {
            C0124z c = m116c();
            if (c != null) {
                removeAllViews();
                addView(c, m115b());
                c.mo3374a().mo3325a(new C0104f((byte) 3, this.f210a.mo3362j()));
                this.f214e = true;
            } else if (!this.f215f) {
                TextView textView = new TextView(this.f211b);
                textView.setText(C0120v.f234b);
                textView.setTextSize(1, 20.0f);
                addView(textView, m115b());
            }
            this.f215f = true;
        }
    }

    /* renamed from: b */
    private static RelativeLayout.LayoutParams m115b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* renamed from: c */
    private synchronized C0124z m116c() {
        C0124z zVar;
        List a = this.f210a.mo3336a(this.f211b, Arrays.asList(new String[]{this.f212c}), (Long) null, this.f213d, false);
        if (!a.isEmpty()) {
            zVar = (C0124z) a.get(0);
            zVar.setOnClickListener(this.f210a);
        } else {
            zVar = null;
        }
        return zVar;
    }
}
