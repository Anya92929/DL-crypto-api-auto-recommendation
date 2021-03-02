package com.jackhenry.godough.core.rda.imagecapture;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.widgets.ActionButton;

public class CaptureImagePreviewFragment extends C1802r {
    public static final int CHECK_IMAGE_TYPE_BACK = 1;
    public static final int CHECK_IMAGE_TYPE_FRONT = 0;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Bitmap f6658a;

    /* renamed from: b */
    private int f6659b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1828g f6660c;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6731n() {
        new C1832k(this.f6660c.getImageData(), this.f6659b, new C1829h(this, this, new C1827f(this))).execute(new String[0]);
    }

    public static CaptureImagePreviewFragment newInstance(int i) {
        CaptureImagePreviewFragment captureImagePreviewFragment = new CaptureImagePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("CHECK_FACE", i);
        captureImagePreviewFragment.setArguments(bundle);
        return captureImagePreviewFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6659b = getArguments().getInt("CHECK_FACE", 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6660c = (C1828g) getActivity();
        this.f6658a = this.f6660c.getCheckImage();
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.camera_image_preview, new RelativeLayout(getContext()));
        ImageView imageView = (ImageView) relativeLayout.findViewById(C1494ai.ivCheckOverlayBoxTitle);
        if (this.f6659b == 0) {
            imageView.setImageResource(C1493ah.check_front);
        } else if (this.f6659b == 1) {
            imageView.setImageResource(C1493ah.check_back);
        }
        ((ActionButton) relativeLayout.findViewById(C1494ai.btnSavePicture)).setOnClickListener(new C1825d(this));
        ((ActionButton) relativeLayout.findViewById(C1494ai.btnRetryPicture)).setOnClickListener(new C1826e(this, relativeLayout));
        ((ImageView) relativeLayout.findViewById(C1494ai.cameraImageView)).setImageBitmap(this.f6658a);
        return relativeLayout;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6658a.recycle();
    }
}
