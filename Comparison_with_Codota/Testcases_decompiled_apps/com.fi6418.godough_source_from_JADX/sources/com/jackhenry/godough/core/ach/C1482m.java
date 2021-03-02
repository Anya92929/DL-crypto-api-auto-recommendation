package com.jackhenry.godough.core.ach;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.p038e.C1579h;

/* renamed from: com.jackhenry.godough.core.ach.m */
class C1482m implements C1579h {

    /* renamed from: a */
    final /* synthetic */ String f5965a;

    /* renamed from: b */
    final /* synthetic */ C1481l f5966b;

    C1482m(C1481l lVar, String str) {
        this.f5966b = lVar;
        this.f5965a = str;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f5966b.f6919c.getLayoutInflater((Bundle) null).inflate(C1496ak.dialog_content_text, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.message_text)).setText(this.f5965a);
        return inflate;
    }
}
