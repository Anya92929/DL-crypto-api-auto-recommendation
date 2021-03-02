package com.jackhenry.godough.core.p2p;

import android.content.DialogInterface;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.p2p.h */
class C1779h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f6579a;

    /* renamed from: b */
    final /* synthetic */ P2PAddPersonFragment f6580b;

    C1779h(P2PAddPersonFragment p2PAddPersonFragment, ArrayList arrayList) {
        this.f6580b = p2PAddPersonFragment;
        this.f6579a = arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6579a.size()) {
            this.f6580b.f6521c.setText((CharSequence) this.f6579a.get(i));
            this.f6580b.f6522d.setText((CharSequence) this.f6579a.get(i));
        }
        dialogInterface.dismiss();
    }
}
