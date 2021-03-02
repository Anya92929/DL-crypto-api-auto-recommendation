package com.qualcomm.VuforiaMedia;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class VideoPlayerHelper implements MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public static final float CURRENT_POSITION = -1.0f;
    private static Method _getTransformMatrixFunc;
    private static Method _releaseFunc;
    private static Constructor<?> _surfaceConstructor;
    private static Constructor<?> _surfaceTextureConstructor;
    private static Method _updateTexImageFunc;
    private final String CLASSNAME_SURFACE = "android.view.Surface";
    private final String CLASSNAME_SURFACETEXTURE = "android.graphics.SurfaceTexture";
    private int mCurrentBufferingPercentage = 0;
    private MEDIA_STATE mCurrentState = MEDIA_STATE.NOT_READY;
    private int mDestTextureID = -1;
    private int mFBO = -1;
    private MediaPlayer mMediaPlayer = null;
    private ReentrantLock mMediaPlayerLock = null;
    private int mMediaTextureID = -1;
    private String mMovieName = "";
    private Activity mParentActivity = null;
    private float mSeekPosition = -1.0f;
    private boolean mShouldPlayImmediately = false;
    private Object mSurfaceTexture = null;
    private ReentrantLock mSurfaceTextureLock = null;
    private int mTextureID = 0;
    private MEDIA_TYPE mVideoType = MEDIA_TYPE.UNKNOWN;

    public native void bindMediaTexture(int i);

    public native void copyTexture(int i, int i2, int i3, float[] fArr, int i4, int i5);

    public native int initFBO(int i, int i2, int i3);

    public native int initMediaTexture();

    public enum MEDIA_STATE {
        REACHED_END(0),
        PAUSED(1),
        STOPPED(2),
        PLAYING(3),
        READY(4),
        NOT_READY(5),
        ERROR(6);
        
        /* access modifiers changed from: private */
        public int type;

        private MEDIA_STATE(int i) {
            this.type = i;
        }

        public int getNumericType() {
            return this.type;
        }
    }

    public enum MEDIA_TYPE {
        ON_TEXTURE(0),
        FULLSCREEN(1),
        ON_TEXTURE_FULLSCREEN(2),
        UNKNOWN(3);
        
        private int type;

        private MEDIA_TYPE(int i) {
            this.type = i;
        }

        public int getNumericType() {
            return this.type;
        }
    }

    static {
        loadLibrary("VuforiaMedia");
    }

    public static boolean loadLibrary(String nLibName) {
        try {
            System.loadLibrary(nLibName);
            DebugLog.LOGI("Native library lib" + nLibName + ".so loaded");
            return true;
        } catch (UnsatisfiedLinkError e) {
            DebugLog.LOGE("The library lib" + nLibName + ".so could not be loaded");
            return false;
        } catch (SecurityException e2) {
            DebugLog.LOGE("The library lib" + nLibName + ".so was not allowed to be loaded");
            return false;
        }
    }

    public boolean init() {
        this.mMediaPlayerLock = new ReentrantLock();
        this.mSurfaceTextureLock = new ReentrantLock();
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> surfaceTextureClass = Class.forName("android.graphics.SurfaceTexture");
                Class<?> surfaceClass = Class.forName("android.view.Surface");
                _surfaceTextureConstructor = surfaceTextureClass.getConstructor(new Class[]{Integer.TYPE});
                if (_surfaceTextureConstructor == null) {
                    DebugLog.LOGE("Couldn't find SurfaceTexture(int) constructor");
                    return false;
                }
                _surfaceConstructor = surfaceClass.getConstructor(new Class[]{surfaceTextureClass});
                if (_surfaceConstructor == null) {
                    DebugLog.LOGE("Couldn't find Surface(SurfaceTexture) constructor");
                    return false;
                }
                _updateTexImageFunc = retrieveClassMethod(surfaceTextureClass, "updateTexImage", new Class[0]);
                if (_updateTexImageFunc == null) {
                    DebugLog.LOGE("Couldn't find SurfaceTexture.updateTexImage() method");
                    return false;
                }
                _getTransformMatrixFunc = retrieveClassMethod(surfaceTextureClass, "getTransformMatrix", float[].class);
                if (_getTransformMatrixFunc == null) {
                    DebugLog.LOGE("Couldn't find SurfaceTexture.getTransformMatrix(float[]) method");
                    return false;
                }
                _releaseFunc = retrieveClassMethod(surfaceTextureClass, "release", new Class[0]);
                if (_releaseFunc == null) {
                    DebugLog.LOGE("Couldn't find SurfaceTexture.release() method");
                    return false;
                }
            } catch (Exception e) {
                DebugLog.LOGE("Exception in init: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean deinit() {
        unload();
        this.mSurfaceTextureLock.lock();
        if (this.mSurfaceTexture != null) {
            try {
                _releaseFunc.invoke(this.mSurfaceTexture, new Object[0]);
            } catch (Exception e) {
                DebugLog.LOGE("Exception in deinit: " + e.getMessage());
            }
            this.mSurfaceTexture = null;
        }
        this.mSurfaceTextureLock.unlock();
        return true;
    }

    public boolean load(String filename, int type, boolean playOnTextureImmediately, float seekPosition) {
        AssetFileDescriptor afd;
        MEDIA_TYPE requestedType = MEDIA_TYPE.values()[type];
        boolean canBeOnTexture = false;
        boolean canBeFullscreen = false;
        boolean result = false;
        this.mMediaPlayerLock.lock();
        this.mSurfaceTextureLock.lock();
        if (this.mCurrentState == MEDIA_STATE.READY || this.mMediaPlayer != null) {
            DebugLog.LOGD("Already loaded");
        } else {
            if ((requestedType == MEDIA_TYPE.ON_TEXTURE || requestedType == MEDIA_TYPE.ON_TEXTURE_FULLSCREEN) && Build.VERSION.SDK_INT >= 14) {
                this.mMediaTextureID = initMediaTexture();
                if (!setupSurfaceTexture(this.mMediaTextureID)) {
                    DebugLog.LOGD("Can't load file to ON_TEXTURE because the Surface Texture is not ready");
                } else {
                    try {
                        afd = this.mParentActivity.getAssets().openFd(filename);
                    } catch (IOException e) {
                        afd = null;
                    }
                    try {
                        this.mMediaPlayer = new MediaPlayer();
                        if (afd != null) {
                            this.mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                            afd.close();
                        } else {
                            this.mMediaPlayer.setDataSource(filename);
                        }
                        Object[] argList = {this.mSurfaceTexture};
                        this.mMediaPlayer.prepareAsync();
                        this.mMediaPlayer.setOnPreparedListener(this);
                        this.mMediaPlayer.setOnBufferingUpdateListener(this);
                        this.mMediaPlayer.setOnCompletionListener(this);
                        this.mMediaPlayer.setOnErrorListener(this);
                        this.mMediaPlayer.setAudioStreamType(3);
                        this.mMediaPlayer.setSurface((Surface) _surfaceConstructor.newInstance(argList));
                        canBeOnTexture = true;
                        this.mShouldPlayImmediately = playOnTextureImmediately;
                    } catch (Exception e2) {
                        DebugLog.LOGD("Could not create a Media Player");
                        this.mCurrentState = MEDIA_STATE.ERROR;
                        this.mMediaPlayerLock.unlock();
                        this.mSurfaceTextureLock.unlock();
                        return false;
                    }
                }
            }
            if (requestedType == MEDIA_TYPE.FULLSCREEN || requestedType == MEDIA_TYPE.ON_TEXTURE_FULLSCREEN) {
                canBeFullscreen = true;
            }
            this.mMovieName = filename;
            this.mSeekPosition = seekPosition;
            if (canBeFullscreen && canBeOnTexture) {
                this.mVideoType = MEDIA_TYPE.ON_TEXTURE_FULLSCREEN;
            } else if (canBeFullscreen) {
                this.mVideoType = MEDIA_TYPE.FULLSCREEN;
                this.mCurrentState = MEDIA_STATE.READY;
            } else if (canBeOnTexture) {
                this.mVideoType = MEDIA_TYPE.ON_TEXTURE;
            } else {
                this.mVideoType = MEDIA_TYPE.UNKNOWN;
            }
            result = true;
        }
        this.mSurfaceTextureLock.unlock();
        this.mMediaPlayerLock.unlock();
        return result;
    }

    public boolean unload() {
        this.mMediaPlayerLock.lock();
        if (this.mMediaPlayer != null) {
            try {
                this.mMediaPlayer.stop();
            } catch (Exception e) {
                this.mMediaPlayerLock.unlock();
                DebugLog.LOGE("Could not start playback");
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mMediaPlayerLock.unlock();
        this.mCurrentState = MEDIA_STATE.NOT_READY;
        this.mVideoType = MEDIA_TYPE.UNKNOWN;
        return true;
    }

    public boolean isPlayableOnTexture() {
        if (Build.VERSION.SDK_INT < 14 || (this.mVideoType != MEDIA_TYPE.ON_TEXTURE && this.mVideoType != MEDIA_TYPE.ON_TEXTURE_FULLSCREEN)) {
            return false;
        }
        return true;
    }

    public boolean isPlayableFullscreen() {
        if (this.mVideoType == MEDIA_TYPE.FULLSCREEN || this.mVideoType == MEDIA_TYPE.ON_TEXTURE_FULLSCREEN) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getStatus() {
        return this.mCurrentState.type;
    }

    public int getVideoWidth() {
        int result = -1;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = -1;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                result = this.mMediaPlayer.getVideoWidth();
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public int getVideoHeight() {
        int result = -1;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = -1;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                result = this.mMediaPlayer.getVideoHeight();
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public float getLength() {
        if (!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR) {
            return -1.0f;
        }
        int result = -1;
        this.mMediaPlayerLock.lock();
        if (this.mMediaPlayer != null) {
            result = this.mMediaPlayer.getDuration() / 1000;
        }
        this.mMediaPlayerLock.unlock();
        return (float) result;
    }

    public boolean play(boolean fullScreen, float seekPosition) {
        if (fullScreen) {
            if (isPlayableFullscreen()) {
                return true;
            }
            DebugLog.LOGD("Cannot play this video fullscreen, it was not requested on load");
            return false;
        } else if (!isPlayableOnTexture()) {
            DebugLog.LOGD("Cannot play this video on texture, it was either not requested on load or is not supported on this plattform");
            return false;
        } else if (this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR) {
            DebugLog.LOGD("Cannot play this video if it is not ready");
            return false;
        } else {
            this.mMediaPlayerLock.lock();
            if (seekPosition != -1.0f) {
                try {
                    this.mMediaPlayer.seekTo(((int) seekPosition) * 1000);
                } catch (Exception e) {
                    this.mMediaPlayerLock.unlock();
                    DebugLog.LOGE("Could not seek to position");
                }
            } else if (this.mCurrentState == MEDIA_STATE.REACHED_END) {
                try {
                    this.mMediaPlayer.seekTo(0);
                } catch (Exception e2) {
                    this.mMediaPlayerLock.unlock();
                    DebugLog.LOGE("Could not seek to position");
                }
            }
            try {
                this.mMediaPlayer.start();
            } catch (Exception e3) {
                this.mMediaPlayerLock.unlock();
                DebugLog.LOGE("Could not start playback");
            }
            this.mCurrentState = MEDIA_STATE.PLAYING;
            this.mMediaPlayerLock.unlock();
            return true;
        }
    }

    public boolean pause() {
        boolean result = false;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = false;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                try {
                    this.mMediaPlayer.pause();
                } catch (Exception e) {
                    this.mMediaPlayerLock.unlock();
                    DebugLog.LOGE("Could not pause playback");
                }
                this.mCurrentState = MEDIA_STATE.PAUSED;
                result = true;
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public boolean stop() {
        boolean result = false;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = false;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                this.mCurrentState = MEDIA_STATE.STOPPED;
                try {
                    this.mMediaPlayer.stop();
                } catch (Exception e) {
                    this.mMediaPlayerLock.unlock();
                    DebugLog.LOGE("Could not stop playback");
                }
                result = true;
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateVideoData() {
        /*
            r10 = this;
            boolean r0 = r10.isPlayableOnTexture()
            if (r0 != 0) goto L_0x000d
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r0 = com.qualcomm.VuforiaMedia.VideoPlayerHelper.MEDIA_STATE.NOT_READY
            int r9 = r0.type
        L_0x000c:
            return r9
        L_0x000d:
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r0 = com.qualcomm.VuforiaMedia.VideoPlayerHelper.MEDIA_STATE.NOT_READY
            int r9 = r0.type
            java.util.concurrent.locks.ReentrantLock r0 = r10.mSurfaceTextureLock
            r0.lock()
            java.lang.Object r0 = r10.mSurfaceTexture
            if (r0 == 0) goto L_0x0059
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r0 = r10.mCurrentState
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r1 = com.qualcomm.VuforiaMedia.VideoPlayerHelper.MEDIA_STATE.PLAYING
            if (r0 != r1) goto L_0x0053
            java.lang.reflect.Method r0 = _updateTexImageFunc     // Catch:{ Exception -> 0x005f }
            java.lang.Object r1 = r10.mSurfaceTexture     // Catch:{ Exception -> 0x005f }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x005f }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x005f }
            r0 = 16
            float[] r4 = new float[r0]     // Catch:{ Exception -> 0x005f }
            r0 = 1
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005f }
            r0 = 0
            r7[r0] = r4     // Catch:{ Exception -> 0x005f }
            java.lang.reflect.Method r0 = _getTransformMatrixFunc     // Catch:{ Exception -> 0x005f }
            java.lang.Object r1 = r10.mSurfaceTexture     // Catch:{ Exception -> 0x005f }
            r0.invoke(r1, r7)     // Catch:{ Exception -> 0x005f }
            int r1 = r10.mMediaTextureID     // Catch:{ Exception -> 0x005f }
            int r2 = r10.mDestTextureID     // Catch:{ Exception -> 0x005f }
            int r3 = r10.mFBO     // Catch:{ Exception -> 0x005f }
            android.media.MediaPlayer r0 = r10.mMediaPlayer     // Catch:{ Exception -> 0x005f }
            int r5 = r0.getVideoWidth()     // Catch:{ Exception -> 0x005f }
            android.media.MediaPlayer r0 = r10.mMediaPlayer     // Catch:{ Exception -> 0x005f }
            int r6 = r0.getVideoHeight()     // Catch:{ Exception -> 0x005f }
            r0 = r10
            r0.copyTexture(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x005f }
        L_0x0053:
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r0 = r10.mCurrentState
            int r9 = r0.type
        L_0x0059:
            java.util.concurrent.locks.ReentrantLock r0 = r10.mSurfaceTextureLock
            r0.unlock()
            goto L_0x000c
        L_0x005f:
            r8 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error in updateVideoData: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r8.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.qualcomm.VuforiaMedia.DebugLog.LOGE(r0)
            com.qualcomm.VuforiaMedia.VideoPlayerHelper$MEDIA_STATE r0 = com.qualcomm.VuforiaMedia.VideoPlayerHelper.MEDIA_STATE.ERROR
            int r9 = r0.type
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qualcomm.VuforiaMedia.VideoPlayerHelper.updateVideoData():int");
    }

    public boolean seekTo(float position) {
        boolean result = false;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = false;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                try {
                    this.mMediaPlayer.seekTo(((int) position) * 1000);
                } catch (Exception e) {
                    this.mMediaPlayerLock.unlock();
                    DebugLog.LOGE("Could not seek to position");
                }
                result = true;
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public float getCurrentPosition() {
        float result = -1.0f;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = -1.0f;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                result = ((float) this.mMediaPlayer.getCurrentPosition()) / 1000.0f;
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public boolean setVolume(float value) {
        boolean result = false;
        if (!(!isPlayableOnTexture() || this.mCurrentState == MEDIA_STATE.NOT_READY || this.mCurrentState == MEDIA_STATE.ERROR)) {
            result = false;
            this.mMediaPlayerLock.lock();
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setVolume(value, value);
                result = true;
            }
            this.mMediaPlayerLock.unlock();
        }
        return result;
    }

    public int getCurrentBufferingPercentage() {
        return this.mCurrentBufferingPercentage;
    }

    public void onBufferingUpdate(MediaPlayer arg0, int arg1) {
        this.mMediaPlayerLock.lock();
        if (this.mMediaPlayer != null && arg0 == this.mMediaPlayer) {
            this.mCurrentBufferingPercentage = arg1;
        }
        this.mMediaPlayerLock.unlock();
    }

    public void setActivity(Activity newActivity) {
        this.mParentActivity = newActivity;
    }

    public void onCompletion(MediaPlayer arg0) {
        this.mCurrentState = MEDIA_STATE.REACHED_END;
    }

    public boolean setupSurfaceTexture(int nativeTextureID) {
        if (Build.VERSION.SDK_INT < 14) {
            return false;
        }
        try {
            this.mSurfaceTexture = _surfaceTextureConstructor.newInstance(new Object[]{new Integer(nativeTextureID)});
            this.mTextureID = nativeTextureID;
            return true;
        } catch (Exception e) {
            DebugLog.LOGE("Error in setupSurfaceTexture: " + e.getMessage());
            return false;
        }
    }

    public void onPrepared(MediaPlayer mediaplayer) {
        this.mCurrentState = MEDIA_STATE.READY;
        if (this.mShouldPlayImmediately) {
            play(false, this.mSeekPosition);
        }
        this.mSeekPosition = 0.0f;
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        DebugLog.LOGE("Error while opening the file. Unloading the media player");
        unload();
        this.mCurrentState = MEDIA_STATE.ERROR;
        return true;
    }

    public boolean setVideoTextureID(int textureID) {
        if (!isPlayableOnTexture() || this.mMediaPlayer == null) {
            DebugLog.LOGD("Cannot set the video texture ID if it is not playable on texture");
            return false;
        }
        this.mDestTextureID = textureID;
        int videoWidth = this.mMediaPlayer.getVideoWidth();
        int videoHeight = this.mMediaPlayer.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0) {
            return false;
        }
        this.mFBO = initFBO(this.mDestTextureID, videoWidth, videoHeight);
        return true;
    }

    public boolean isFileInAssetsFolder(String filename) {
        AssetFileDescriptor afd;
        try {
            afd = this.mParentActivity.getAssets().openFd(filename);
        } catch (IOException e) {
            afd = null;
        }
        if (afd != null) {
            return true;
        }
        return false;
    }

    public static Method retrieveClassMethod(Class<?> cls, String name, Class<?>... parameterTypes) {
        try {
            return cls.getMethod(name, parameterTypes);
        } catch (Exception e) {
            DebugLog.LOGE("Failed to retrieve method '" + name + "' at API level " + Build.VERSION.SDK_INT + ": " + e.toString());
            return null;
        }
    }
}
