package com.jackhenry.godough.core.rda.imagecapture;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;

public class CheckCaptureCameraFragment extends C1802r implements C1823b {
    public static final String CHECK_FACE = "CHECK_FACE";
    public static final int CHECK_IMAGE_TYPE_BACK = 1;
    public static final int CHECK_IMAGE_TYPE_FRONT = 0;

    /* renamed from: a */
    private PercentRelativeLayout f6665a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1819a f6666b;

    /* renamed from: c */
    private int f6667c;

    /* renamed from: d */
    private RelativeLayout f6668d;

    public static CheckCaptureCameraFragment newInstance(int i) {
        CheckCaptureCameraFragment checkCaptureCameraFragment = new CheckCaptureCameraFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("CHECK_FACE", i);
        checkCaptureCameraFragment.setArguments(bundle);
        return checkCaptureCameraFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6667c = getArguments().getInt("CHECK_FACE", 0);
        this.f6666b = C1824c.m6749a((AbstractActivity) getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6665a = (PercentRelativeLayout) layoutInflater.inflate(C1496ak.camera_image_view, new LinearLayout(getContext()), false);
        ImageView imageView = (ImageView) this.f6665a.findViewById(C1494ai.ivCheckOverlayBoxTitle);
        if (this.f6667c == 0) {
            imageView.setImageResource(C1493ah.check_front);
        } else if (this.f6667c == 1) {
            imageView.setImageResource(C1493ah.check_back);
        }
        this.f6668d = (RelativeLayout) this.f6665a.findViewById(C1494ai.cameraSurfaceViewHolder);
        ((ImageButton) this.f6665a.findViewById(C1494ai.btnTakePicture)).setOnClickListener(new C1830i(this));
        return this.f6665a;
    }

    public void onPause() {
        super.onPause();
        this.f6666b.mo11034d();
    }

    public void onResume() {
        super.onResume();
        this.f6666b.mo11030a((ViewGroup) this.f6668d);
    }

    public void showImagePreview(byte[] bArr, Bitmap bitmap) {
        ((C1831j) getActivity()).previewImage(bArr, bitmap);
    }
}
