package org.commonwealthcu.mobile;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.app.Fragment;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: org.commonwealthcu.mobile.y */
final class C0646y extends Handler {

    /* renamed from: a */
    private /* synthetic */ MainActivity f872a;

    C0646y(MainActivity mainActivity) {
        this.f872a = mainActivity;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                Bitmap bitmap = (Bitmap) message.getData().getParcelable("bitmap");
                if (bitmap != null) {
                    try {
                        FileOutputStream openFileOutput = this.f872a.openFileOutput(message.obj.toString(), 0);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, openFileOutput);
                        openFileOutput.close();
                        Fragment findFragmentByTag = this.f872a.getSupportFragmentManager().findFragmentByTag("tab_ads");
                        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
                            ((C0578a) findFragmentByTag).mo5481a();
                            break;
                        }
                    } catch (FileNotFoundException | IOException e) {
                        break;
                    }
                }
                break;
            case 2:
                Bitmap bitmap2 = (Bitmap) message.getData().getParcelable("bitmap");
                if (bitmap2 != null) {
                    try {
                        FileOutputStream openFileOutput2 = this.f872a.openFileOutput(message.obj.toString(), 0);
                        bitmap2.compress(Bitmap.CompressFormat.PNG, 100, openFileOutput2);
                        openFileOutput2.close();
                        break;
                    } catch (FileNotFoundException | IOException e2) {
                        break;
                    }
                }
                break;
        }
        MainActivity.m1253a(this.f872a);
    }
}
