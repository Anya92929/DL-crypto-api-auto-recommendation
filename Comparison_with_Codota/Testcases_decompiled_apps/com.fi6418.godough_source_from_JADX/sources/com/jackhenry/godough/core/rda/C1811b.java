package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.p027b.C1389d;

/* renamed from: com.jackhenry.godough.core.rda.b */
class C1811b extends C1943y<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ CheckViewFragment f6650a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1811b(CheckViewFragment checkViewFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6650a = checkViewFragment;
    }

    /* renamed from: a */
    public void mo9588a(Bitmap bitmap) {
        this.f6650a.mo10989m();
        if (bitmap == null) {
            this.f6650a.f6609b.setVisibility(0);
            ((AbstractActivity) this.f6650a.getActivity()).showDialog(this.f6650a.getString(C1506am.dg_error_title), this.f6650a.getString(C1506am.empty_image));
        } else {
            this.f6650a.f6609b.setVisibility(8);
            if (this.f6650a.f6612e == Deposit.Side.FRONT) {
                Bitmap unused = this.f6650a.f6610c = bitmap;
            } else {
                Bitmap unused2 = this.f6650a.f6611d = bitmap;
            }
        }
        this.f6650a.f6608a.setImageBitmap(bitmap);
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6650a.mo10989m();
        if (super.mo9589a(dVar)) {
            return true;
        }
        this.f6650a.f6609b.setVisibility(0);
        ((AbstractActivity) this.f6650a.getActivity()).showDialog(this.f6650a.getString(C1506am.dg_error_title), dVar.getMessage());
        return true;
    }
}
