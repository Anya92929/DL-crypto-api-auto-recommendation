package com.jackhenry.godough.core.rda.imagecapture;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.h */
class C1829h extends C1943y<Boolean> {

    /* renamed from: a */
    final /* synthetic */ CaptureImagePreviewFragment f6687a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1829h(CaptureImagePreviewFragment captureImagePreviewFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6687a = captureImagePreviewFragment;
    }

    /* renamed from: a */
    public void mo9588a(Boolean bool) {
        this.f6687a.mo10989m();
        ((C1828g) this.f6687a.getActivity()).imageSaved(bool.booleanValue());
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6687a.mo10989m();
        AbstractActivity abstractActivity = (AbstractActivity) this.f6687a.getActivity();
        if (abstractActivity == null || super.mo9589a(dVar)) {
            return true;
        }
        abstractActivity.showDialog(this.f6687a.getString(C1506am.dg_error_title), dVar.getMessage());
        return true;
    }
}
