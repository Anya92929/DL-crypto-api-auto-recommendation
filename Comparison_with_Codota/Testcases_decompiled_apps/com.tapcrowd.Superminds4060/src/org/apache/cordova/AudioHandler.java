package org.apache.cordova;

import android.media.AudioManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.AudioPlayer;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class AudioHandler extends CordovaPlugin {
    public static String TAG = "AudioHandler";
    ArrayList<AudioPlayer> pausedForPhone = new ArrayList<>();
    HashMap<String, AudioPlayer> players = new HashMap<>();

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
        if (action.equals("startRecordingAudio")) {
            startRecordingAudio(args.getString(0), FileUtils.stripFileProtocol(args.getString(1)));
        } else if (action.equals("stopRecordingAudio")) {
            stopRecordingAudio(args.getString(0));
        } else if (action.equals("startPlayingAudio")) {
            startPlayingAudio(args.getString(0), FileUtils.stripFileProtocol(args.getString(1)));
        } else if (action.equals("seekToAudio")) {
            seekToAudio(args.getString(0), args.getInt(1));
        } else if (action.equals("pausePlayingAudio")) {
            pausePlayingAudio(args.getString(0));
        } else if (action.equals("stopPlayingAudio")) {
            stopPlayingAudio(args.getString(0));
        } else if (action.equals("setVolume")) {
            try {
                setVolume(args.getString(0), Float.parseFloat(args.getString(1)));
            } catch (NumberFormatException e) {
            }
        } else if (action.equals("getCurrentPositionAudio")) {
            callbackContext.sendPluginResult(new PluginResult(status, getCurrentPositionAudio(args.getString(0))));
            return true;
        } else if (action.equals("getDurationAudio")) {
            callbackContext.sendPluginResult(new PluginResult(status, getDurationAudio(args.getString(0), args.getString(1))));
            return true;
        } else if (action.equals("create")) {
            String id = args.getString(0);
            this.players.put(id, new AudioPlayer(this, id, FileUtils.stripFileProtocol(args.getString(1))));
        } else if (!action.equals("release")) {
            return false;
        } else {
            callbackContext.sendPluginResult(new PluginResult(status, release(args.getString(0))));
            return true;
        }
        callbackContext.sendPluginResult(new PluginResult(status, ""));
        return true;
    }

    public void onDestroy() {
        for (AudioPlayer audio : this.players.values()) {
            audio.destroy();
        }
        this.players.clear();
    }

    public void onReset() {
        onDestroy();
    }

    public Object onMessage(String id, Object data) {
        if (id.equals("telephone")) {
            if ("ringing".equals(data) || "offhook".equals(data)) {
                for (AudioPlayer audio : this.players.values()) {
                    if (audio.getState() == AudioPlayer.STATE.MEDIA_RUNNING.ordinal()) {
                        this.pausedForPhone.add(audio);
                        audio.pausePlaying();
                    }
                }
            } else if ("idle".equals(data)) {
                Iterator i$ = this.pausedForPhone.iterator();
                while (i$.hasNext()) {
                    i$.next().startPlaying((String) null);
                }
                this.pausedForPhone.clear();
            }
        }
        return null;
    }

    private boolean release(String id) {
        if (!this.players.containsKey(id)) {
            return false;
        }
        this.players.remove(id);
        this.players.get(id).destroy();
        return true;
    }

    public void startRecordingAudio(String id, String file) {
        AudioPlayer audio = this.players.get(id);
        if (audio == null) {
            audio = new AudioPlayer(this, id, file);
            this.players.put(id, audio);
        }
        audio.startRecording(file);
    }

    public void stopRecordingAudio(String id) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            audio.stopRecording();
        }
    }

    public void startPlayingAudio(String id, String file) {
        AudioPlayer audio = this.players.get(id);
        if (audio == null) {
            audio = new AudioPlayer(this, id, file);
            this.players.put(id, audio);
        }
        audio.startPlaying(file);
    }

    public void seekToAudio(String id, int milliseconds) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            audio.seekToPlaying(milliseconds);
        }
    }

    public void pausePlayingAudio(String id) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            audio.pausePlaying();
        }
    }

    public void stopPlayingAudio(String id) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            audio.stopPlaying();
        }
    }

    public float getCurrentPositionAudio(String id) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            return ((float) audio.getCurrentPosition()) / 1000.0f;
        }
        return -1.0f;
    }

    public float getDurationAudio(String id, String file) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            return audio.getDuration(file);
        }
        AudioPlayer audio2 = new AudioPlayer(this, id, file);
        this.players.put(id, audio2);
        return audio2.getDuration(file);
    }

    public void setAudioOutputDevice(int output) {
        AudioManager audiMgr = (AudioManager) this.cordova.getActivity().getSystemService("audio");
        if (output == 2) {
            audiMgr.setRouting(0, 2, -1);
        } else if (output == 1) {
            audiMgr.setRouting(0, 1, -1);
        } else {
            System.out.println("AudioHandler.setAudioOutputDevice() Error: Unknown output device.");
        }
    }

    public int getAudioOutputDevice() {
        AudioManager audiMgr = (AudioManager) this.cordova.getActivity().getSystemService("audio");
        if (audiMgr.getRouting(0) == 1) {
            return 1;
        }
        if (audiMgr.getRouting(0) == 2) {
            return 2;
        }
        return -1;
    }

    public void setVolume(String id, float volume) {
        AudioPlayer audio = this.players.get(id);
        if (audio != null) {
            audio.setVolume(volume);
        } else {
            System.out.println("AudioHandler.setVolume() Error: Unknown Audio Player " + id);
        }
    }
}
