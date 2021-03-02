package org.commonwealthcu.mobile;

import android.content.DialogInterface;

/* renamed from: org.commonwealthcu.mobile.x */
final class C0645x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private /* synthetic */ MainActivity f871a;

    C0645x(MainActivity mainActivity) {
        this.f871a = mainActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f871a.finish();
    }
}
