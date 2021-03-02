package com.google.android.gms.cast;

import com.google.android.gms.internal.C1326ik;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;

    /* renamed from: FA */
    private double f456FA;

    /* renamed from: FB */
    private boolean f457FB;

    /* renamed from: FC */
    private long[] f458FC;

    /* renamed from: Fl */
    private JSONObject f459Fl;

    /* renamed from: Fm */
    private MediaInfo f460Fm;

    /* renamed from: Fu */
    private long f461Fu;

    /* renamed from: Fv */
    private double f462Fv;

    /* renamed from: Fw */
    private int f463Fw;

    /* renamed from: Fx */
    private int f464Fx;

    /* renamed from: Fy */
    private long f465Fy;

    /* renamed from: Fz */
    private long f466Fz;

    public MediaStatus(JSONObject json) throws JSONException {
        mo4022a(json, 0);
    }

    /* renamed from: a */
    public int mo4022a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        int i3 = 2;
        boolean z = false;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.f461Fu) {
            this.f461Fu = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.f463Fw) {
                this.f463Fw = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (!string2.equals("CANCELLED")) {
                    i3 = string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                }
                if (i3 != this.f464Fx) {
                    this.f464Fx = i3;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.f462Fv != d) {
                this.f462Fv = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long b = C1326ik.m4987b(jSONObject.getDouble("currentTime"));
            if (b != this.f465Fy) {
                this.f465Fy = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.f466Fz) {
                this.f466Fz = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.f456FA) {
                this.f456FA = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.f457FB) {
                this.f457FB = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                jArr2[i5] = jSONArray.getLong(i5);
            }
            if (this.f458FC != null && this.f458FC.length == length) {
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        if (this.f458FC[i6] != jArr2[i6]) {
                            break;
                        }
                        i6++;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.f458FC = jArr2;
            }
            z = z2;
            jArr = jArr2;
        } else if (this.f458FC != null) {
            z = true;
            jArr = null;
        } else {
            jArr = null;
        }
        if (z) {
            this.f458FC = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.f459Fl = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("media");
        this.f460Fm = new MediaInfo(jSONObject3);
        int i7 = i2 | 2;
        return jSONObject3.has("metadata") ? i7 | 4 : i7;
    }

    /* renamed from: fx */
    public long mo4023fx() {
        return this.f461Fu;
    }

    public long[] getActiveTrackIds() {
        return this.f458FC;
    }

    public JSONObject getCustomData() {
        return this.f459Fl;
    }

    public int getIdleReason() {
        return this.f464Fx;
    }

    public MediaInfo getMediaInfo() {
        return this.f460Fm;
    }

    public double getPlaybackRate() {
        return this.f462Fv;
    }

    public int getPlayerState() {
        return this.f463Fw;
    }

    public long getStreamPosition() {
        return this.f465Fy;
    }

    public double getStreamVolume() {
        return this.f456FA;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.f466Fz & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.f457FB;
    }
}
