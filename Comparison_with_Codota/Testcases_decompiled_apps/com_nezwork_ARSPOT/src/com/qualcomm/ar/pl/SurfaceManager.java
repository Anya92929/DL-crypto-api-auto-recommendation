package com.qualcomm.ar.pl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qualcomm.ar.pl.CameraPreview;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceManager {
    private static final String MODULENAME = "SurfaceManager";
    Lock addSurfaceLock = new ReentrantLock();
    View cameraSurfaceParentView = null;
    CameraPreview.CameraCacheInfo cciForSurface;
    GLSurfaceView glSurfaceView = null;
    int glSurfaceViewChildPosition = 0;
    boolean renderWhenDirtyEnabled = false;
    Lock viewLock = new ReentrantLock();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.opengl.GLSurfaceView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.opengl.GLSurfaceView searchForGLSurfaceView(android.view.View r9) {
        /*
            r8 = this;
            r5 = 0
            r7 = 0
            r8.glSurfaceViewChildPosition = r7
            r0 = r9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x002c }
            r6 = r0
            int r4 = r6.getChildCount()     // Catch:{ Exception -> 0x002c }
            r3 = 0
        L_0x000d:
            if (r3 >= r4) goto L_0x001d
            android.view.View r1 = r6.getChildAt(r3)     // Catch:{ Exception -> 0x002c }
            boolean r7 = r1 instanceof android.opengl.GLSurfaceView     // Catch:{ Exception -> 0x002c }
            if (r7 == 0) goto L_0x001f
            r0 = r1
            android.opengl.GLSurfaceView r0 = (android.opengl.GLSurfaceView) r0     // Catch:{ Exception -> 0x002c }
            r5 = r0
            r8.glSurfaceViewChildPosition = r3     // Catch:{ Exception -> 0x002c }
        L_0x001d:
            r7 = r5
        L_0x001e:
            return r7
        L_0x001f:
            boolean r7 = r1 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x002c }
            if (r7 == 0) goto L_0x0029
            android.opengl.GLSurfaceView r5 = r8.searchForGLSurfaceView(r1)     // Catch:{ Exception -> 0x002c }
            if (r5 != 0) goto L_0x001d
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x002c:
            r2 = move-exception
            r7 = 0
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualcomm.ar.pl.SurfaceManager.searchForGLSurfaceView(android.view.View):android.opengl.GLSurfaceView");
    }

    private boolean applyRenderWhenDirty() {
        int i = 0;
        if (this.glSurfaceView == null) {
            return false;
        }
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        if (!this.renderWhenDirtyEnabled) {
            i = 1;
        }
        gLSurfaceView.setRenderMode(i);
        return true;
    }

    /* access modifiers changed from: private */
    public void setupCameraSurface(CameraPreview.CameraCacheInfo cci) {
        if (cci.surface == null) {
            cci.surface = new CameraSurface(SystemTools.getActivityFromNative());
        } else if (cci.surface.getParent() != null && ViewGroup.class.isInstance(cci.surface.getParent())) {
            ((ViewGroup) cci.surface.getParent()).removeView(cci.surface);
        }
        cci.surface.setCamera(cci.camera);
    }

    public boolean retrieveGLSurfaceView() {
        boolean z;
        try {
            Activity activity = SystemTools.getActivityFromNative();
            if (activity == null) {
                return false;
            }
            View decorView = activity.getWindow().getDecorView();
            this.glSurfaceView = searchForGLSurfaceView(decorView);
            if (this.glSurfaceView == null) {
                this.cameraSurfaceParentView = decorView;
            } else {
                this.cameraSurfaceParentView = (View) this.glSurfaceView.getParent();
                applyRenderWhenDirty();
            }
            if (this.glSurfaceView != null) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setEnableRenderWhenDirty(boolean enabled) {
        this.renderWhenDirtyEnabled = enabled;
        return applyRenderWhenDirty();
    }

    public void requestRender() {
        Activity activity;
        if (this.glSurfaceView == null && (activity = SystemTools.getActivityFromNative()) != null) {
            this.glSurfaceView = searchForGLSurfaceView(activity.getWindow().getDecorView());
        }
        if (this.glSurfaceView != null) {
            this.glSurfaceView.requestRender();
        }
    }

    public boolean addCameraSurface(CameraPreview.CameraCacheInfo cci) {
        Activity activity = SystemTools.getActivityFromNative();
        if (activity == null) {
            return false;
        }
        this.cciForSurface = cci;
        boolean didExceptionHappen = false;
        this.viewLock.lock();
        try {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    SurfaceManager.this.addSurfaceLock.lock();
                    SurfaceManager.this.retrieveGLSurfaceView();
                    try {
                        SurfaceManager.this.setupCameraSurface(SurfaceManager.this.cciForSurface);
                        ((ViewGroup) SurfaceManager.this.cameraSurfaceParentView).addView(SurfaceManager.this.cciForSurface.surface, SurfaceManager.this.glSurfaceViewChildPosition + 1, new FrameLayout.LayoutParams(-1, -1));
                        SurfaceManager.this.cciForSurface.surface.setVisibility(0);
                    } catch (Exception e) {
                    } finally {
                        SurfaceManager.this.addSurfaceLock.unlock();
                    }
                }
            });
        } catch (Exception e) {
            didExceptionHappen = true;
        } finally {
            this.viewLock.unlock();
        }
        if (!didExceptionHappen) {
            return true;
        }
        return false;
    }
}
