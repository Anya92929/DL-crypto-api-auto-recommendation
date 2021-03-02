package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1497al;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.widgets.TouchImageView;

public class ImageViewActivity extends AbstractActivity implements C1883z {
    public static final int CHECK_IMAGE_TYPE_BACK = 1;
    public static final int CHECK_IMAGE_TYPE_FRONT = 0;
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_TYPE = "type";

    /* renamed from: m */
    private TouchImageView f6639m;

    /* renamed from: n */
    private Bitmap f6640n = null;

    /* renamed from: o */
    private int f6641o;

    /* renamed from: a */
    private void m6699a(int i) {
        this.f6640n = C1809ae.m6713a(this.f6640n, i);
        this.f6639m.setImageBitmap(this.f6640n);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.dummy);
    }

    public void imageLoaded(Bitmap bitmap, int i) {
        this.f6639m.setImageBitmap((Bitmap) null);
        this.f6640n = bitmap;
        m6699a(0);
    }

    public void onBackPressed() {
        setResult(this.f6641o);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        setContentView(C1496ak.image_view);
        String string2 = getIntent().getExtras().getString(PARAM_TITLE);
        this.f6641o = getIntent().getExtras().getInt(PARAM_TYPE);
        this.f6639m = (TouchImageView) findViewById(C1494ai.imageView);
        switch (this.f6641o) {
            case 0:
                string = getString(C1506am.check_front);
                break;
            case 1:
                string = getString(C1506am.check_back);
                break;
            default:
                string = string2;
                break;
        }
        if (!C1364k.m5589a(string)) {
            setTitle(string);
            C1879v.m6837a(this, this.f6641o, 1);
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1497al.image_viewer, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f6639m.setOnTouchListener((View.OnTouchListener) null);
        this.f6639m.setImageBitmap((Bitmap) null);
        this.f6640n.recycle();
        System.gc();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C1494ai.menu_rotate_left) {
            onRotateClicked(-90);
            return true;
        } else if (menuItem.getItemId() != C1494ai.menu_rotate_right) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onRotateClicked(90);
            return true;
        }
    }

    public void onRotateClicked(int i) {
        m6699a(i);
    }
}
