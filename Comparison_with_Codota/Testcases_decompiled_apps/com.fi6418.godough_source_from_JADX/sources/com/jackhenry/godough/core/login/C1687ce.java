package com.jackhenry.godough.core.login;

import android.content.DialogInterface;
import com.jackhenry.godough.core.model.MFAQuestion;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.login.ce */
class C1687ce implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ List f6430a;

    /* renamed from: b */
    final /* synthetic */ int f6431b;

    /* renamed from: c */
    final /* synthetic */ MFARecollectQuestionsFragment f6432c;

    C1687ce(MFARecollectQuestionsFragment mFARecollectQuestionsFragment, List list, int i) {
        this.f6432c = mFARecollectQuestionsFragment;
        this.f6430a = list;
        this.f6431b = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < this.f6430a.size()) {
            this.f6432c.f6341d[this.f6431b] = (MFAQuestion) this.f6430a.get(i);
            this.f6432c.f6339b[this.f6431b].setText(this.f6432c.f6341d[this.f6431b].getQuestion());
            this.f6432c.m6346a(this.f6431b);
        }
        dialogInterface.dismiss();
    }
}
