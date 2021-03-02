package com.jackhenry.godough.core.rda.imagecapture;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;

public class CheckCaptureCameraActivity extends AbstractActivity implements C1578g, C1828g, C1831j {
    public static final String CHECK_FACE = "CHECK_FACE";

    /* renamed from: m */
    Fragment f6661m;

    /* renamed from: n */
    protected int f6662n;

    /* renamed from: o */
    private byte[] f6663o;

    /* renamed from: p */
    private Bitmap f6664p;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo11022b(String str) {
        Fragment newInstance = str.equals(CaptureImagePreviewFragment.class.getSimpleName()) ? CaptureImagePreviewFragment.newInstance(this.f6662n) : CheckCaptureCameraFragment.newInstance(this.f6662n);
        this.f6661m = newInstance;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C1494ai.masterCameraViewLayout, newInstance, str);
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6661m;
    }

    public Bitmap getCheckImage() {
        return this.f6664p;
    }

    public byte[] getImageData() {
        return this.f6663o;
    }

    public void imageSaved(boolean z) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
            getWindow().setNavigationBarColor(getColor(17170445));
        }
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setTitle(getString(C1506am.lbl_deposit_a_check));
        setContentView(C1496ak.camera_check_preview);
        getSupportActionBar().hide();
        this.f6662n = getIntent().getIntExtra("CHECK_FACE", 0);
        CheckCaptureCameraFragment newInstance = CheckCaptureCameraFragment.newInstance(this.f6662n);
        this.f6661m = newInstance;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(C1494ai.masterCameraViewLayout, newInstance, CheckCaptureCameraFragment.class.getSimpleName());
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f6664p != null) {
            this.f6664p.recycle();
        }
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        finish();
    }

    public void previewImage(byte[] bArr, Bitmap bitmap) {
        this.f6663o = bArr;
        if (this.f6664p != null) {
            this.f6664p.recycle();
        }
        this.f6664p = bitmap;
        mo11022b(CaptureImagePreviewFragment.class.getSimpleName());
    }

    public void recaptureImage() {
        mo11022b(CheckCaptureCameraFragment.class.getSimpleName());
    }
}
