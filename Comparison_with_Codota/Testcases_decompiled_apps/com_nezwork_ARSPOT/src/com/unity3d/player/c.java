package com.unity3d.player;

import android.app.Activity;
import android.content.ContextWrapper;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class c implements h {
    protected final ContextWrapper a;
    private Activity b;
    /* access modifiers changed from: private */
    public Queue c = new ConcurrentLinkedQueue();
    private Runnable d = new d(this);

    public c(ContextWrapper contextWrapper) {
        this.a = contextWrapper;
        this.b = contextWrapper instanceof Activity ? (Activity) contextWrapper : null;
    }

    private static int a(MotionEvent.PointerCoords[] pointerCoordsArr, float[] fArr, int i) {
        for (int i2 = 0; i2 < pointerCoordsArr.length; i2++) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoordsArr[i2] = pointerCoords;
            int i3 = i + 1;
            pointerCoords.orientation = fArr[i];
            int i4 = i3 + 1;
            pointerCoords.pressure = fArr[i3];
            int i5 = i4 + 1;
            pointerCoords.size = fArr[i4];
            int i6 = i5 + 1;
            pointerCoords.toolMajor = fArr[i5];
            int i7 = i6 + 1;
            pointerCoords.toolMinor = fArr[i6];
            int i8 = i7 + 1;
            pointerCoords.touchMajor = fArr[i7];
            int i9 = i8 + 1;
            pointerCoords.touchMinor = fArr[i8];
            int i10 = i9 + 1;
            pointerCoords.x = fArr[i9];
            i = i10 + 1;
            pointerCoords.y = fArr[i10];
        }
        return i;
    }

    public final int a() {
        return Camera.getNumberOfCameras();
    }

    public final int a(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    public final void a(long j, long j2, int i, int i2, int[] iArr, float[] fArr, int i3, float f, float f2, int i4, int i5, int i6, int i7, int i8, long[] jArr, float[] fArr2) {
        if (this.b != null) {
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i2];
            a(pointerCoordsArr, fArr, 0);
            MotionEvent obtain = MotionEvent.obtain(j, j2, i, i2, iArr, pointerCoordsArr, i3, f, f2, i4, i5, i6, i7);
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                MotionEvent.PointerCoords[] pointerCoordsArr2 = new MotionEvent.PointerCoords[i2];
                i9 = a(pointerCoordsArr2, fArr2, i9);
                obtain.addBatch(jArr[i10], pointerCoordsArr2, i3);
            }
            this.c.add(obtain);
            this.b.runOnUiThread(this.d);
        }
    }

    public final boolean a(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        return cameraInfo.facing == 1;
    }

    public final RectF b() {
        int[] deviceIds = InputDevice.getDeviceIds();
        for (int device : deviceIds) {
            InputDevice device2 = InputDevice.getDevice(device);
            if (device2 != null && (device2.getSources() & 1048584) == 1048584) {
                InputDevice.MotionRange motionRange = device2.getMotionRange(0);
                InputDevice.MotionRange motionRange2 = device2.getMotionRange(1);
                if (!(motionRange == null || motionRange2 == null)) {
                    return new RectF(0.0f, 0.0f, motionRange.getRange(), motionRange2.getRange());
                }
            }
        }
        return null;
    }
}
