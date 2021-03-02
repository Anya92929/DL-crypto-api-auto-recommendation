package com.qualcomm.ar.pl;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RenderManager {
    private static final int AR_RENDERING_MODE_CONTINUOUS = 1;
    private static final int AR_RENDERING_MODE_DISABLED = 0;
    private static final int AR_RENDERING_MODE_WHENDIRTY = 2;
    private static final String MODULENAME = "RenderManager";
    long delayMS = 0;
    ScheduledFuture<?> fixedFrameRateRunnerTask;
    long maxMS = 0;
    long minMS = 0;
    int renderMode;
    AtomicBoolean renderRequestServiced;
    ScheduledFuture<?> renderRequestWatcherTask;
    AtomicBoolean renderRequested;
    SurfaceManager surfaceManager;
    boolean synchronousMode;
    ScheduledThreadPoolExecutor timer;

    private final class RenderRequestWatcher implements Runnable {
        private RenderRequestWatcher() {
        }

        public void run() {
            if (RenderManager.this.renderRequested.compareAndSet(true, false) && RenderManager.this.surfaceManager != null) {
                RenderManager.this.surfaceManager.requestRender();
                RenderManager.this.renderRequestServiced.set(true);
                if (RenderManager.this.fixedFrameRateRunnerTask == null) {
                    RenderManager.this.fixedFrameRateRunnerTask = RenderManager.this.timer.scheduleAtFixedRate(new FixedFrameRateRunner(), 0, RenderManager.this.delayMS, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    private final class FixedFrameRateRunner implements Runnable {
        private FixedFrameRateRunner() {
        }

        public void run() {
            if (!RenderManager.this.renderRequestServiced.getAndSet(false) && RenderManager.this.surfaceManager != null) {
                RenderManager.this.surfaceManager.requestRender();
                if (!RenderManager.this.synchronousMode && !RenderManager.this.renderRequestWatcherTask.isCancelled()) {
                    RenderManager.this.renderRequestWatcherTask.cancel(false);
                }
            }
        }
    }

    public RenderManager(SurfaceManager sm) {
        this.surfaceManager = sm;
        this.renderMode = 1;
        this.timer = new ScheduledThreadPoolExecutor(1);
        this.synchronousMode = false;
        this.renderRequestServiced = new AtomicBoolean(false);
        this.renderRequested = new AtomicBoolean(false);
    }

    /* access modifiers changed from: package-private */
    public void startTimer() {
        if (this.timer.isShutdown()) {
            this.timer = new ScheduledThreadPoolExecutor(1);
        }
        if (this.fixedFrameRateRunnerTask != null && !this.fixedFrameRateRunnerTask.isCancelled()) {
            this.fixedFrameRateRunnerTask.cancel(true);
        }
        if (this.renderRequestWatcherTask != null && !this.renderRequestWatcherTask.isCancelled()) {
            this.renderRequestWatcherTask.cancel(true);
        }
        this.fixedFrameRateRunnerTask = null;
        this.renderRequestWatcherTask = null;
        this.renderRequestWatcherTask = this.timer.scheduleWithFixedDelay(new RenderRequestWatcher(), 0, this.delayMS / 4, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public void shutdownTimer() {
        if (!this.timer.isShutdown()) {
            this.timer.shutdown();
        }
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public boolean setRenderMode(int mode) {
        boolean result;
        if (this.surfaceManager == null) {
            SystemTools.setSystemErrorCode(6);
            return false;
        }
        this.surfaceManager.retrieveGLSurfaceView();
        switch (mode) {
            case 0:
            case 2:
                result = this.surfaceManager.setEnableRenderWhenDirty(true);
                if (result) {
                    if (mode != 0) {
                        if (mode != this.renderMode || this.timer.isShutdown()) {
                            long delayMSTemp = this.synchronousMode ? this.minMS : this.maxMS;
                            if (delayMSTemp != 0) {
                                this.delayMS = delayMSTemp;
                                startTimer();
                                break;
                            }
                        }
                    } else {
                        shutdownTimer();
                        break;
                    }
                }
                break;
            case 1:
                result = this.surfaceManager.setEnableRenderWhenDirty(false);
                if (result) {
                    shutdownTimer();
                    break;
                }
                break;
            default:
                SystemTools.setSystemErrorCode(2);
                return false;
        }
        if (!result) {
            SystemTools.setSystemErrorCode(6);
        } else {
            this.renderMode = mode;
        }
        return result;
    }

    public boolean setRenderFpsLimits(boolean synchronous, int minFps, int maxFps) {
        this.synchronousMode = synchronous;
        if (minFps == 0 || maxFps == 0) {
            SystemTools.setSystemErrorCode(2);
            return false;
        }
        this.minMS = 1000 / ((long) minFps);
        this.maxMS = 1000 / ((long) maxFps);
        if (this.renderMode == 2) {
            long delayMSTemp = this.synchronousMode ? this.minMS : this.maxMS;
            if (delayMSTemp != this.delayMS) {
                this.delayMS = delayMSTemp;
                startTimer();
            }
        }
        return true;
    }

    public boolean requestRender() {
        this.renderRequested.set(true);
        return true;
    }
}
