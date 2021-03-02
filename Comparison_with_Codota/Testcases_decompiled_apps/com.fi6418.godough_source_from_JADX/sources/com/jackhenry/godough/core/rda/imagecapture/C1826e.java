package com.jackhenry.godough.core.rda.imagecapture;

import android.view.View;
import android.widget.RelativeLayout;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.e */
class C1826e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f6684a;

    /* renamed from: b */
    final /* synthetic */ CaptureImagePreviewFragment f6685b;

    C1826e(CaptureImagePreviewFragment captureImagePreviewFragment, RelativeLayout relativeLayout) {
        this.f6685b = captureImagePreviewFragment;
        this.f6684a = relativeLayout;
    }

    public void onClick(View view) {
        this.f6684a.setVisibility(8);
        this.f6685b.f6658a.recycle();
        this.f6685b.f6660c.recaptureImage();
    }
}
