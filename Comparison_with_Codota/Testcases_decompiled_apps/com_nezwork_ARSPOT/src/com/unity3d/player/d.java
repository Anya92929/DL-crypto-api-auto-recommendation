package com.unity3d.player;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.qualcomm.ar.pl.SystemTools;
import java.lang.reflect.Method;

class d implements Runnable {
    private final Method a;
    private /* synthetic */ c b;

    d(c cVar) {
        this.b = cVar;
        Method method = null;
        try {
            method = View.class.getMethod("dispatchGenericMotionEvent", new Class[]{MotionEvent.class});
        } catch (NoSuchMethodException e) {
        }
        this.a = method;
    }

    private void a(View view, MotionEvent motionEvent) {
        if (this.a != null) {
            try {
                this.a.invoke(view, new Object[]{motionEvent});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void run() {
        while (true) {
            MotionEvent motionEvent = (MotionEvent) this.b.c.poll();
            if (motionEvent != null) {
                View decorView = ((Activity) this.b.a).getWindow().getDecorView();
                int source = motionEvent.getSource();
                if ((source & 2) != 0) {
                    switch (motionEvent.getAction() & 255) {
                        case SystemTools.AR_ERROR_NONE:
                        case 1:
                        case 2:
                        case SystemTools.AR_ERROR_INVALID_ENUM:
                        case SystemTools.AR_ERROR_INVALID_HANDLE:
                        case SystemTools.AR_ERROR_INVALID_OPERATION:
                        case SystemTools.AR_ERROR_OPERATION_FAILED:
                            decorView.dispatchTouchEvent(motionEvent);
                            break;
                        default:
                            a(decorView, motionEvent);
                            break;
                    }
                } else if ((source & 4) != 0) {
                    decorView.dispatchTrackballEvent(motionEvent);
                } else {
                    a(decorView, motionEvent);
                }
            } else {
                return;
            }
        }
    }
}
