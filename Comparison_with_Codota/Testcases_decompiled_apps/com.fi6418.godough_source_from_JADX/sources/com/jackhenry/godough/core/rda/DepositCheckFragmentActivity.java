package com.jackhenry.godough.core.rda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.GodoughTransactionActivity;

public class DepositCheckFragmentActivity extends GodoughTransactionActivity implements C1840q, C1883z {
    public static final int IMAGE_CAPTURE = 0;
    public static final int IMAGE_ROTATE = 1;

    /* renamed from: m */
    private DepositCheckFragment f6634m;

    public void actionButtonClickHandler() {
        resetFields();
        finish();
    }

    public void cancelButtonOnClickHandler() {
        resetScreen();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6634m;
    }

    public void imageLoaded(Bitmap bitmap, int i) {
        this.f6634m.setImageView(bitmap, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 || i == 1) {
            setResetFields(false);
            this.f6634m.reloadThumbnails();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.deposit_check_activity);
        getSupportActionBar().setTitle((CharSequence) getString(C1506am.lbl_deposit_a_check));
        this.f6634m = (DepositCheckFragment) getSupportFragmentManager().findFragmentById(C1494ai.deposit_check);
        setTransactionFragment(this.f6634m);
    }

    public void onFragmentNavigate(C1839p pVar) {
        if (pVar == C1839p.DEPOSIT_STATUS) {
            startActivity(new Intent(GoDoughApp.getApp(), DepositStatusFragmentActivity.class));
        } else if (pVar == C1839p.VIEW_FRONT || pVar == C1839p.VIEW_BACK) {
            Intent intent = new Intent(GoDoughApp.getApp(), ImageViewActivity.class);
            String string = pVar == C1839p.VIEW_FRONT ? getString(C1506am.lbl_check_front) : getString(C1506am.lbl_check_back);
            intent.putExtra(ImageViewActivity.PARAM_TYPE, pVar == C1839p.VIEW_BACK ? 1 : 0);
            intent.putExtra(ImageViewActivity.PARAM_TITLE, string);
            startActivityForResult(intent, 0);
        } else if (pVar == C1839p.FINISH) {
            finish();
        }
    }

    public void onNoData(Object obj) {
        showDialog(getString(C1506am.dg_error_title), getString(C1506am.empty_deposit_accounts));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void resetFields() {
        this.f6634m.depositAnother();
    }

    public void updateCheckImage(int i) {
        this.f6634m.reloadThumbnails();
    }
}
