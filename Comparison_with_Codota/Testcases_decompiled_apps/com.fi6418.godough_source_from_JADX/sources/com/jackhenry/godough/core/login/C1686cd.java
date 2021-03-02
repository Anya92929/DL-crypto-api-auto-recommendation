package com.jackhenry.godough.core.login;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.jackhenry.godough.core.login.cd */
class C1686cd implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MFARecollectQuestionsFragment f6429a;

    C1686cd(MFARecollectQuestionsFragment mFARecollectQuestionsFragment) {
        this.f6429a = mFARecollectQuestionsFragment;
    }

    public void afterTextChanged(Editable editable) {
        this.f6429a.mo9923n();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
