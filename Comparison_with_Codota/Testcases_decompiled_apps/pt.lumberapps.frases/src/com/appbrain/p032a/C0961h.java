package com.appbrain.p032a;

import android.view.View;
import android.widget.TextView;
import com.appbrain.p040i.C1116a;

/* renamed from: com.appbrain.a.h */
final class C0961h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextView f2547a;

    /* renamed from: b */
    final /* synthetic */ C1116a f2548b;

    C0961h(TextView textView, C1116a aVar) {
        this.f2547a = textView;
        this.f2548b = aVar;
    }

    public final void onClick(View view) {
        if (this.f2547a.getVisibility() == 8) {
            this.f2548b.mo4428a(this.f2547a);
        } else {
            this.f2548b.mo4430b(this.f2547a);
        }
    }
}
