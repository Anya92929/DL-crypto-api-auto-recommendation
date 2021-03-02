package com.jackhenry.godough.core.accounts;

import com.jackhenry.godough.core.widgets.TouchImageView;

/* renamed from: com.jackhenry.godough.core.accounts.q */
class C1437q implements TouchImageView.FlingCallBack {

    /* renamed from: a */
    final /* synthetic */ CheckImageFragment f5873a;

    private C1437q(CheckImageFragment checkImageFragment) {
        this.f5873a = checkImageFragment;
    }

    /* synthetic */ C1437q(CheckImageFragment checkImageFragment, C1433m mVar) {
        this(checkImageFragment);
    }

    public void execute(boolean z) {
        int e = z ? this.f5873a.f5843i + 1 : this.f5873a.f5843i - 1;
        if (e < this.f5873a.f5839e.getImages().size() && e >= 0) {
            this.f5873a.f5841g.mo148a(e).mo210e();
        }
    }
}
