package android.support.p000v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.p000v4.view.KeyEventCompat;
import android.support.p003v7.appcompat.C0137R;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.media.TransportMediator */
public class TransportMediator extends TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final AudioManager mAudioManager;
    final TransportPerformer mCallbacks;
    final Context mContext;
    final TransportMediatorJellybeanMR2 mController;
    final Object mDispatcherState;
    final KeyEvent.Callback mKeyEventCallback;
    final ArrayList mListeners;
    final TransportMediatorCallback mTransportKeyCallback;
    final View mView;

    public TransportMediator(Activity activity, TransportPerformer transportPerformer) {
        this(activity, (View) null, transportPerformer);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer transportPerformer) {
        this.mListeners = new ArrayList();
        this.mTransportKeyCallback = new TransportMediatorCallback() {
            public long getPlaybackPosition() {
                return TransportMediator.this.mCallbacks.onGetCurrentPosition();
            }

            public void handleAudioFocusChange(int i) {
                TransportMediator.this.mCallbacks.onAudioFocusChange(i);
            }

            public void handleKey(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.mKeyEventCallback);
            }

            public void playbackPositionUpdate(long j) {
                TransportMediator.this.mCallbacks.onSeekTo(j);
            }
        };
        this.mKeyEventCallback = new KeyEvent.Callback() {
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.isMediaKey(i)) {
                    return TransportMediator.this.mCallbacks.onMediaButtonDown(i, keyEvent);
                }
                return false;
            }

            public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
                return false;
            }

            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }

            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (TransportMediator.isMediaKey(i)) {
                    return TransportMediator.this.mCallbacks.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.mCallbacks = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.mDispatcherState = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mController = new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);
        } else {
            this.mController = null;
        }
    }

    public TransportMediator(View view, TransportPerformer transportPerformer) {
        this((Activity) null, view, transportPerformer);
    }

    private TransportStateListener[] getListeners() {
        if (this.mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.mListeners.size()];
        this.mListeners.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    static boolean isMediaKey(int i) {
        switch (i) {
            case C0137R.styleable.Theme_panelMenuListTheme /*79*/:
            case C0137R.styleable.Theme_colorControlActivated /*85*/:
            case C0137R.styleable.Theme_colorControlHighlight /*86*/:
            case C0137R.styleable.Theme_colorButtonNormal /*87*/:
            case C0137R.styleable.Theme_colorSwitchThumbNormal /*88*/:
            case C0137R.styleable.Theme_alertDialogStyle /*89*/:
            case C0137R.styleable.Theme_alertDialogButtonGroupStyle /*90*/:
            case C0137R.styleable.Theme_alertDialogCenterButtons /*91*/:
            case KEYCODE_MEDIA_PLAY /*126*/:
            case KEYCODE_MEDIA_PAUSE /*127*/:
            case KEYCODE_MEDIA_RECORD /*130*/:
                return true;
            default:
                return false;
        }
    }

    private void pushControllerState() {
        if (this.mController != null) {
            this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
        }
    }

    private void reportPlayingChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener onPlayingChanged : listeners) {
                onPlayingChanged.onPlayingChanged(this);
            }
        }
    }

    private void reportTransportControlsChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener onTransportControlsChanged : listeners) {
                onTransportControlsChanged.onTransportControlsChanged(this);
            }
        }
    }

    public void destroy() {
        this.mController.destroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.mKeyEventCallback, this.mDispatcherState, this);
    }

    public int getBufferPercentage() {
        return this.mCallbacks.onGetBufferPercentage();
    }

    public long getCurrentPosition() {
        return this.mCallbacks.onGetCurrentPosition();
    }

    public long getDuration() {
        return this.mCallbacks.onGetDuration();
    }

    public Object getRemoteControlClient() {
        if (this.mController != null) {
            return this.mController.getRemoteControlClient();
        }
        return null;
    }

    public int getTransportControlFlags() {
        return this.mCallbacks.onGetTransportControlFlags();
    }

    public boolean isPlaying() {
        return this.mCallbacks.onIsPlaying();
    }

    public void pausePlaying() {
        if (this.mController != null) {
            this.mController.pausePlaying();
        }
        this.mCallbacks.onPause();
        pushControllerState();
        reportPlayingChanged();
    }

    public void refreshState() {
        pushControllerState();
        reportPlayingChanged();
        reportTransportControlsChanged();
    }

    public void registerStateListener(TransportStateListener transportStateListener) {
        this.mListeners.add(transportStateListener);
    }

    public void seekTo(long j) {
        this.mCallbacks.onSeekTo(j);
    }

    public void startPlaying() {
        if (this.mController != null) {
            this.mController.startPlaying();
        }
        this.mCallbacks.onStart();
        pushControllerState();
        reportPlayingChanged();
    }

    public void stopPlaying() {
        if (this.mController != null) {
            this.mController.stopPlaying();
        }
        this.mCallbacks.onStop();
        pushControllerState();
        reportPlayingChanged();
    }

    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.mListeners.remove(transportStateListener);
    }
}
