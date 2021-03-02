package com.jackhenry.godough.core.rda.imagecapture.p041a.p042a;

import android.view.SurfaceHolder;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;
import java.io.IOException;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.a.a.c */
class C1822c implements SurfaceHolder.Callback {

    /* renamed from: a */
    final /* synthetic */ C1820a f6682a;

    public C1822c(C1820a aVar) {
        this.f6682a = aVar;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        try {
            this.f6682a.m6743f();
            this.f6682a.f6672b.setPreviewDisplay(surfaceHolder);
            this.f6682a.f6672b.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
            this.f6682a.mo11029a().showDialog(this.f6682a.mo11029a().getString(C1506am.rdaCameraErrorTitle, new Object[]{GoDoughApp.getUserSettings().getUserMenu().getRda().getText()}), this.f6682a.mo11029a().getString(C1506am.rdaCameraAccessError));
        } catch (C1389d e2) {
            e2.printStackTrace();
            this.f6682a.mo11029a().showDialog(this.f6682a.mo11029a().getString(C1506am.rdaCameraErrorTitle, new Object[]{GoDoughApp.getUserSettings().getUserMenu().getRda().getText()}), this.f6682a.mo11029a().getString(C1506am.rdaCameraParameterError));
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
