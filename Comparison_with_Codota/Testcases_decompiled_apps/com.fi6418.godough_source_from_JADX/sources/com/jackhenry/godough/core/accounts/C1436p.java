package com.jackhenry.godough.core.accounts;

import android.graphics.Bitmap;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.accounts.p */
class C1436p extends C1943y<Bitmap> {

    /* renamed from: a */
    int f5870a;

    /* renamed from: b */
    int f5871b;

    /* renamed from: e */
    final /* synthetic */ CheckImageFragment f5872e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1436p(CheckImageFragment checkImageFragment, Fragment fragment, int i, int i2, C1593j jVar) {
        super(fragment, jVar);
        this.f5872e = checkImageFragment;
        this.f5870a = i2;
        this.f5871b = i;
    }

    /* renamed from: a */
    public void mo9588a(Bitmap bitmap) {
        this.f5872e.mo10989m();
        if (bitmap == null) {
            AbstractActivity abstractActivity = (AbstractActivity) this.f5872e.getActivity();
            if (abstractActivity != null) {
                abstractActivity.showDialog(this.f5872e.getString(C1506am.dg_error_title), this.f5872e.getString(C1506am.empty_image));
                return;
            }
            return;
        }
        this.f5872e.setCheckImage(bitmap);
        this.f5872e.f5842h[this.f5871b][this.f5870a] = bitmap;
        int unused = this.f5872e.f5843i = this.f5871b;
        int unused2 = this.f5872e.f5834aj = this.f5870a;
        this.f5872e.m5787a(this.f5872e.f5843i);
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        AbstractActivity abstractActivity;
        this.f5872e.mo10989m();
        if (super.mo9589a(dVar) || (abstractActivity = (AbstractActivity) this.f5872e.getActivity()) == null) {
            return true;
        }
        abstractActivity.showDialog(this.f5872e.getString(C1506am.dg_error_title), dVar.getMessage());
        return true;
    }
}
