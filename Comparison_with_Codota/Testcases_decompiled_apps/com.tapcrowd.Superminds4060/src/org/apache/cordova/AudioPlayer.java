package org.apache.cordova;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    private static final String LOG_TAG = "AudioPlayer";
    private static int MEDIA_DURATION = 2;
    private static int MEDIA_ERROR = 9;
    private static int MEDIA_ERR_ABORTED = 1;
    private static int MEDIA_ERR_DECODE = 3;
    private static int MEDIA_ERR_NETWORK = 2;
    private static int MEDIA_ERR_NONE_ACTIVE = 0;
    private static int MEDIA_ERR_NONE_SUPPORTED = 4;
    private static int MEDIA_POSITION = 3;
    private static int MEDIA_STATE = 1;
    private String audioFile = null;
    private float duration = -1.0f;
    private AudioHandler handler;

    /* renamed from: id */
    private String f2149id;
    private MODE mode = MODE.NONE;
    private MediaPlayer player = null;
    private boolean prepareOnly = true;
    private MediaRecorder recorder = null;
    private int seekOnPrepared = 0;
    private STATE state = STATE.MEDIA_NONE;
    private String tempFile = null;

    public enum MODE {
        NONE,
        PLAY,
        RECORD
    }

    public enum STATE {
        MEDIA_NONE,
        MEDIA_STARTING,
        MEDIA_RUNNING,
        MEDIA_PAUSED,
        MEDIA_STOPPED,
        MEDIA_LOADING
    }

    public AudioPlayer(AudioHandler handler2, String id, String file) {
        this.handler = handler2;
        this.f2149id = id;
        this.audioFile = file;
        this.recorder = new MediaRecorder();
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.tempFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmprecording.3gp";
        } else {
            this.tempFile = "/data/data/" + handler2.cordova.getActivity().getPackageName() + "/cache/tmprecording.3gp";
        }
    }

    public void destroy() {
        if (this.player != null) {
            if (this.state == STATE.MEDIA_RUNNING || this.state == STATE.MEDIA_PAUSED) {
                this.player.stop();
                setState(STATE.MEDIA_STOPPED);
            }
            this.player.release();
            this.player = null;
        }
        if (this.recorder != null) {
            stopRecording();
            this.recorder.release();
            this.recorder = null;
        }
    }

    public void startRecording(String file) {
        switch (this.mode) {
            case PLAY:
                Log.d(LOG_TAG, "AudioPlayer Error: Can't record in play mode.");
                this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                return;
            case NONE:
                this.audioFile = file;
                this.recorder.setAudioSource(1);
                this.recorder.setOutputFormat(0);
                this.recorder.setAudioEncoder(0);
                this.recorder.setOutputFile(this.tempFile);
                try {
                    this.recorder.prepare();
                    this.recorder.start();
                    setState(STATE.MEDIA_RUNNING);
                    return;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    break;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    break;
                }
            case RECORD:
                Log.d(LOG_TAG, "AudioPlayer Error: Already recording.");
                this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                return;
            default:
                return;
        }
        this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
    }

    public void moveFile(String file) {
        File f = new File(this.tempFile);
        if (Environment.getExternalStorageState().equals("mounted")) {
            f.renameTo(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + file));
        } else {
            f.renameTo(new File("/data/data/" + this.handler.cordova.getActivity().getPackageName() + "/cache/" + file));
        }
    }

    public void stopRecording() {
        if (this.recorder != null) {
            try {
                if (this.state == STATE.MEDIA_RUNNING) {
                    this.recorder.stop();
                    setState(STATE.MEDIA_STOPPED);
                }
                this.recorder.reset();
                moveFile(this.audioFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startPlaying(String file) {
        if (!readyPlayer(file) || this.player == null) {
            this.prepareOnly = false;
            return;
        }
        this.player.start();
        setState(STATE.MEDIA_RUNNING);
        this.seekOnPrepared = 0;
    }

    public void seekToPlaying(int milliseconds) {
        if (readyPlayer(this.audioFile)) {
            this.player.seekTo(milliseconds);
            Log.d(LOG_TAG, "Send a onStatus update for the new seek");
            this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_POSITION + ", " + (((float) milliseconds) / 1000.0f) + ");");
            return;
        }
        this.seekOnPrepared = milliseconds;
    }

    public void pausePlaying() {
        if (this.state != STATE.MEDIA_RUNNING || this.player == null) {
            Log.d(LOG_TAG, "AudioPlayer Error: pausePlaying() called during invalid state: " + this.state.ordinal());
            this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_NONE_ACTIVE + "});");
            return;
        }
        this.player.pause();
        setState(STATE.MEDIA_PAUSED);
    }

    public void stopPlaying() {
        if (this.state == STATE.MEDIA_RUNNING || this.state == STATE.MEDIA_PAUSED) {
            this.player.pause();
            this.player.seekTo(0);
            Log.d(LOG_TAG, "stopPlaying is calling stopped");
            setState(STATE.MEDIA_STOPPED);
            return;
        }
        Log.d(LOG_TAG, "AudioPlayer Error: stopPlaying() called during invalid state: " + this.state.ordinal());
        this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_NONE_ACTIVE + "});");
    }

    public void onCompletion(MediaPlayer player2) {
        Log.d(LOG_TAG, "on completion is calling stopped");
        setState(STATE.MEDIA_STOPPED);
    }

    public long getCurrentPosition() {
        if (this.state != STATE.MEDIA_RUNNING && this.state != STATE.MEDIA_PAUSED) {
            return -1;
        }
        int curPos = this.player.getCurrentPosition();
        this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_POSITION + ", " + (((float) curPos) / 1000.0f) + ");");
        return (long) curPos;
    }

    public boolean isStreaming(String file) {
        if (file.contains("http://") || file.contains("https://")) {
            return true;
        }
        return false;
    }

    public float getDuration(String file) {
        if (this.recorder != null) {
            return -2.0f;
        }
        if (this.player != null) {
            return this.duration;
        }
        this.prepareOnly = true;
        startPlaying(file);
        return this.duration;
    }

    public void onPrepared(MediaPlayer player2) {
        this.player.setOnCompletionListener(this);
        seekToPlaying(this.seekOnPrepared);
        if (!this.prepareOnly) {
            this.player.start();
            setState(STATE.MEDIA_RUNNING);
            this.seekOnPrepared = 0;
        } else {
            setState(STATE.MEDIA_STARTING);
        }
        this.duration = getDurationInSeconds();
        this.prepareOnly = true;
        this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_DURATION + "," + this.duration + ");");
    }

    private float getDurationInSeconds() {
        return ((float) this.player.getDuration()) / 1000.0f;
    }

    public boolean onError(MediaPlayer player2, int arg1, int arg2) {
        Log.d(LOG_TAG, "AudioPlayer.onError(" + arg1 + ", " + arg2 + ")");
        this.player.stop();
        this.player.release();
        this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', { \"code\":" + arg1 + "});");
        return false;
    }

    private void setState(STATE state2) {
        if (this.state != state2) {
            this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_STATE + ", " + state2.ordinal() + ");");
        }
        this.state = state2;
    }

    private void setMode(MODE mode2) {
        if (this.mode != mode2) {
        }
        this.mode = mode2;
    }

    public int getState() {
        return this.state.ordinal();
    }

    public void setVolume(float volume) {
        this.player.setVolume(volume, volume);
    }

    private boolean playMode() {
        switch (this.mode) {
            case NONE:
                setMode(MODE.PLAY);
                break;
            case RECORD:
                Log.d(LOG_TAG, "AudioPlayer Error: Can't play in record mode.");
                this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                return false;
        }
        return true;
    }

    private boolean readyPlayer(String file) {
        if (!playMode()) {
            return false;
        }
        switch (this.state) {
            case MEDIA_NONE:
                if (this.player == null) {
                    this.player = new MediaPlayer();
                }
                try {
                    loadAudioFile(file);
                    return false;
                } catch (Exception e) {
                    this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                    return false;
                }
            case MEDIA_LOADING:
                Log.d(LOG_TAG, "AudioPlayer Loading: startPlaying() called during media preparation: " + STATE.MEDIA_STARTING.ordinal());
                this.prepareOnly = false;
                return false;
            case MEDIA_STARTING:
            case MEDIA_RUNNING:
            case MEDIA_PAUSED:
                return true;
            case MEDIA_STOPPED:
                if (this.audioFile.compareTo(file) == 0) {
                    this.player.seekTo(0);
                    this.player.pause();
                    return true;
                }
                this.player.reset();
                try {
                    loadAudioFile(file);
                    return false;
                } catch (Exception e2) {
                    this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                    return false;
                }
            default:
                Log.d(LOG_TAG, "AudioPlayer Error: startPlaying() called during invalid state: " + this.state);
                this.handler.webView.sendJavascript("cordova.require('cordova/plugin/Media').onStatus('" + this.f2149id + "', " + MEDIA_ERROR + ", { \"code\":" + MEDIA_ERR_ABORTED + "});");
                return false;
        }
    }

    private void loadAudioFile(String file) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (isStreaming(file)) {
            this.player.setDataSource(file);
            this.player.setAudioStreamType(3);
            setMode(MODE.PLAY);
            setState(STATE.MEDIA_STARTING);
            this.player.setOnPreparedListener(this);
            this.player.prepareAsync();
            return;
        }
        if (file.startsWith("/android_asset/")) {
            AssetFileDescriptor fd = this.handler.cordova.getActivity().getAssets().openFd(file.substring(15));
            this.player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
        } else if (new File(file).exists()) {
            this.player.setDataSource(new FileInputStream(file).getFD());
        } else {
            this.player.setDataSource("/sdcard/" + file);
        }
        setState(STATE.MEDIA_STARTING);
        this.player.setOnPreparedListener(this);
        this.player.prepare();
        this.duration = getDurationInSeconds();
    }
}
