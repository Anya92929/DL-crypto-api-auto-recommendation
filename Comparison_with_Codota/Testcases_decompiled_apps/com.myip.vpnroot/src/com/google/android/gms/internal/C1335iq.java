package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.iq */
public class C1335iq extends C1316ii {

    /* renamed from: Hb */
    private static final long f4029Hb = TimeUnit.HOURS.toMillis(24);

    /* renamed from: Hc */
    private static final long f4030Hc = TimeUnit.HOURS.toMillis(24);

    /* renamed from: Hd */
    private static final long f4031Hd = TimeUnit.HOURS.toMillis(24);

    /* renamed from: He */
    private static final long f4032He = TimeUnit.SECONDS.toMillis(1);
    private static final String NAMESPACE = C1326ik.m4986aG("com.google.cast.media");

    /* renamed from: Hf */
    private long f4033Hf;

    /* renamed from: Hg */
    private MediaStatus f4034Hg;

    /* renamed from: Hh */
    private final C1340it f4035Hh;

    /* renamed from: Hi */
    private final C1340it f4036Hi;

    /* renamed from: Hj */
    private final C1340it f4037Hj;

    /* renamed from: Hk */
    private final C1340it f4038Hk;

    /* renamed from: Hl */
    private final C1340it f4039Hl;

    /* renamed from: Hm */
    private final C1340it f4040Hm;

    /* renamed from: Hn */
    private final C1340it f4041Hn;

    /* renamed from: Ho */
    private final C1340it f4042Ho;

    /* renamed from: Hp */
    private final C1340it f4043Hp;

    /* renamed from: Hq */
    private final C1340it f4044Hq;
    /* access modifiers changed from: private */

    /* renamed from: Hr */
    public final List<C1340it> f4045Hr;

    /* renamed from: Hs */
    private final Runnable f4046Hs;
    /* access modifiers changed from: private */

    /* renamed from: Ht */
    public boolean f4047Ht;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.iq$a */
    private class C1337a implements Runnable {
        private C1337a() {
        }

        public void run() {
            boolean z = false;
            boolean unused = C1335iq.this.f4047Ht = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (C1340it e : C1335iq.this.f4045Hr) {
                e.mo8935e(elapsedRealtime, RemoteMediaPlayer.STATUS_TIMED_OUT);
            }
            synchronized (C1340it.f4050Hz) {
                for (C1340it fW : C1335iq.this.f4045Hr) {
                    z = fW.mo8936fW() ? true : z;
                }
            }
            C1335iq.this.m5044H(z);
        }
    }

    public C1335iq() {
        this((String) null);
    }

    public C1335iq(String str) {
        super(NAMESPACE, "MediaControlChannel", str);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.f4046Hs = new C1337a();
        this.f4045Hr = new ArrayList();
        this.f4035Hh = new C1340it(f4030Hc);
        this.f4045Hr.add(this.f4035Hh);
        this.f4036Hi = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4036Hi);
        this.f4037Hj = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4037Hj);
        this.f4038Hk = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4038Hk);
        this.f4039Hl = new C1340it(f4031Hd);
        this.f4045Hr.add(this.f4039Hl);
        this.f4040Hm = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4040Hm);
        this.f4041Hn = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4041Hn);
        this.f4042Ho = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4042Ho);
        this.f4043Hp = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4043Hp);
        this.f4044Hq = new C1340it(f4029Hb);
        this.f4045Hr.add(this.f4044Hq);
        m5049fU();
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m5044H(boolean z) {
        if (this.f4047Ht != z) {
            this.f4047Ht = z;
            if (z) {
                this.mHandler.postDelayed(this.f4046Hs, f4032He);
            } else {
                this.mHandler.removeCallbacks(this.f4046Hs);
            }
        }
    }

    /* renamed from: a */
    private void m5046a(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean z = true;
        boolean p = this.f4035Hh.mo8937p(j);
        boolean z2 = this.f4039Hl.mo8936fW() && !this.f4039Hl.mo8937p(j);
        if ((!this.f4040Hm.mo8936fW() || this.f4040Hm.mo8937p(j)) && (!this.f4041Hn.mo8936fW() || this.f4041Hn.mo8937p(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (p || this.f4034Hg == null) {
            this.f4034Hg = new MediaStatus(jSONObject);
            this.f4033Hf = SystemClock.elapsedRealtime();
            i = 7;
        } else {
            i = this.f4034Hg.mo4022a(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.f4033Hf = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.f4033Hf = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        for (C1340it d : this.f4045Hr) {
            d.mo8934d(j, 0);
        }
    }

    /* renamed from: fU */
    private void m5049fU() {
        m5044H(false);
        this.f4033Hf = 0;
        this.f4034Hg = null;
        this.f4035Hh.clear();
        this.f4039Hl.clear();
        this.f4040Hm.clear();
    }

    /* renamed from: a */
    public long mo8915a(C1339is isVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fA = mo8838fA();
        this.f4042Ho.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject.put("requestId", fA);
            jSONObject.put("type", "GET_STATUS");
            if (this.f4034Hg != null) {
                jSONObject.put("mediaSessionId", this.f4034Hg.mo4023fx());
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8916a(C1339is isVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4040Hm.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", mo8925fx());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8917a(C1339is isVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4039Hl.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", mo8925fx());
            jSONObject2.put("currentTime", C1326ik.m4989o(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8918a(C1339is isVar, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4035Hh.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.mo3971bL());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", C1326ik.m4989o(j));
            if (jArr != null && jArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8919a(C1339is isVar, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fA = mo8838fA();
        this.f4044Hq.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject.put("requestId", fA);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.mo4110bL());
            }
            jSONObject.put("mediaSessionId", mo8925fx());
        } catch (JSONException e) {
        }
        mo8835a(jSONObject.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8920a(C1339is isVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4036Hi.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", mo8925fx());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8921a(C1339is isVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4041Hn.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", mo8925fx());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: a */
    public long mo8922a(C1339is isVar, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fA = mo8838fA();
        this.f4043Hp.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject.put("requestId", fA);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", mo8925fx());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        mo8835a(jSONObject.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: aD */
    public final void mo8836aD(String str) {
        this.f3973Go.mo8910b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m5046a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.f4034Hg = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.f4042Ho.mo8934d(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.f3973Go.mo8912d("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                for (C1340it b : this.f4045Hr) {
                    b.mo8932b(optLong, RemoteMediaPlayer.STATUS_FAILED, optJSONObject);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.f4035Hh.mo8932b(optLong, RemoteMediaPlayer.STATUS_FAILED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.f4035Hh.mo8932b(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.f3973Go.mo8912d("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                for (C1340it b2 : this.f4045Hr) {
                    b2.mo8932b(optLong, RemoteMediaPlayer.STATUS_FAILED, optJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.f3973Go.mo8912d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* renamed from: b */
    public long mo8923b(C1339is isVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4038Hk.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", mo8925fx());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: b */
    public void mo8837b(long j, int i) {
        for (C1340it d : this.f4045Hr) {
            d.mo8934d(j, i);
        }
    }

    /* renamed from: c */
    public long mo8924c(C1339is isVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fA = mo8838fA();
        this.f4037Hj.mo8931a(fA, isVar);
        m5044H(true);
        try {
            jSONObject2.put("requestId", fA);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", mo8925fx());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo8835a(jSONObject2.toString(), fA, (String) null);
        return fA;
    }

    /* renamed from: fB */
    public void mo8839fB() {
        m5049fU();
    }

    /* renamed from: fx */
    public long mo8925fx() throws IllegalStateException {
        if (this.f4034Hg != null) {
            return this.f4034Hg.mo4023fx();
        }
        throw new IllegalStateException("No current media session");
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.f4033Hf == 0) {
            return 0;
        }
        double playbackRate = this.f4034Hg.getPlaybackRate();
        long streamPosition = this.f4034Hg.getStreamPosition();
        int playerState = this.f4034Hg.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f4033Hf;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j2 = streamPosition + ((long) (((double) j) * playbackRate));
        if (streamDuration <= 0 || j2 <= streamDuration) {
            streamDuration = j2 < 0 ? 0 : j2;
        }
        return streamDuration;
    }

    public MediaInfo getMediaInfo() {
        if (this.f4034Hg == null) {
            return null;
        }
        return this.f4034Hg.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.f4034Hg;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMetadataUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onStatusUpdated() {
    }
}
