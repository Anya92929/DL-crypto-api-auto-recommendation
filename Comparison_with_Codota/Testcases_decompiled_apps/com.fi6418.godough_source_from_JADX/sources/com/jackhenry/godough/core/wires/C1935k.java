package com.jackhenry.godough.core.wires;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.p038e.C1579h;

/* renamed from: com.jackhenry.godough.core.wires.k */
class C1935k implements C1579h {

    /* renamed from: a */
    final /* synthetic */ String f6910a;

    /* renamed from: b */
    final /* synthetic */ C1934j f6911b;

    C1935k(C1934j jVar, String str) {
        this.f6911b = jVar;
        this.f6910a = str;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6911b.f6919c.getLayoutInflater((Bundle) null).inflate(C1496ak.dialog_content_text, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.message_text)).setText(this.f6910a);
        return inflate;
    }
}
