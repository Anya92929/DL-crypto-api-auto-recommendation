package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.internal.C1326ik;
import com.google.android.gms.internal.C1390jz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;

    /* renamed from: Fe */
    private final String f439Fe;

    /* renamed from: Ff */
    private int f440Ff;

    /* renamed from: Fg */
    private String f441Fg;

    /* renamed from: Fh */
    private MediaMetadata f442Fh;

    /* renamed from: Fi */
    private long f443Fi;

    /* renamed from: Fj */
    private List<MediaTrack> f444Fj;

    /* renamed from: Fk */
    private TextTrackStyle f445Fk;

    /* renamed from: Fl */
    private JSONObject f446Fl;

    public static class Builder {

        /* renamed from: Fm */
        private final MediaInfo f447Fm;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.f447Fm = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.f447Fm.mo3974fw();
            return this.f447Fm;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.f447Fm.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.f447Fm.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.f447Fm.mo3972c(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.f447Fm.mo3970a(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.f447Fm.mo3984m(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.f447Fm.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.f447Fm.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.f439Fe = contentId;
        this.f440Ff = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        this.f439Fe = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.f440Ff = 0;
        } else if ("BUFFERED".equals(string)) {
            this.f440Ff = 1;
        } else if ("LIVE".equals(string)) {
            this.f440Ff = 2;
        } else {
            this.f440Ff = -1;
        }
        this.f441Fg = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.f442Fh = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.f442Fh.mo3999c(jSONObject);
        }
        this.f443Fi = C1326ik.m4987b(json.optDouble("duration", 0.0d));
        if (json.has("tracks")) {
            this.f444Fj = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f444Fj.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.f444Fj = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.mo4111c(jSONObject2);
            this.f445Fk = textTrackStyle;
        } else {
            this.f445Fk = null;
        }
        this.f446Fl = json.optJSONObject("customData");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3970a(MediaMetadata mediaMetadata) {
        this.f442Fh = mediaMetadata;
    }

    /* renamed from: bL */
    public JSONObject mo3971bL() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f439Fe);
            switch (this.f440Ff) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.f441Fg != null) {
                jSONObject.put("contentType", this.f441Fg);
            }
            if (this.f442Fh != null) {
                jSONObject.put("metadata", this.f442Fh.mo3998bL());
            }
            jSONObject.put("duration", C1326ik.m4989o(this.f443Fi));
            if (this.f444Fj != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack bL : this.f444Fj) {
                    jSONArray.put(bL.mo4035bL());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.f445Fk != null) {
                jSONObject.put("textTrackStyle", this.f445Fk.mo4110bL());
            }
            if (this.f446Fl != null) {
                jSONObject.put("customData", this.f446Fl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3972c(List<MediaTrack> list) {
        this.f444Fj = list;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.f446Fl == null) != (mediaInfo.f446Fl == null)) {
            return false;
        }
        if (this.f446Fl != null && mediaInfo.f446Fl != null && !C1390jz.m5226d(this.f446Fl, mediaInfo.f446Fl)) {
            return false;
        }
        if (!C1326ik.m4984a(this.f439Fe, mediaInfo.f439Fe) || this.f440Ff != mediaInfo.f440Ff || !C1326ik.m4984a(this.f441Fg, mediaInfo.f441Fg) || !C1326ik.m4984a(this.f442Fh, mediaInfo.f442Fh) || this.f443Fi != mediaInfo.f443Fi) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: fw */
    public void mo3974fw() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.f439Fe)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.f441Fg)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.f440Ff == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public String getContentId() {
        return this.f439Fe;
    }

    public String getContentType() {
        return this.f441Fg;
    }

    public JSONObject getCustomData() {
        return this.f446Fl;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.f444Fj;
    }

    public MediaMetadata getMetadata() {
        return this.f442Fh;
    }

    public long getStreamDuration() {
        return this.f443Fi;
    }

    public int getStreamType() {
        return this.f440Ff;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.f445Fk;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f439Fe, Integer.valueOf(this.f440Ff), this.f441Fg, this.f442Fh, Long.valueOf(this.f443Fi), String.valueOf(this.f446Fl));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo3984m(long j) throws IllegalArgumentException {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.f443Fi = j;
    }

    /* access modifiers changed from: package-private */
    public void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.f441Fg = contentType;
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(JSONObject customData) {
        this.f446Fl = customData;
    }

    /* access modifiers changed from: package-private */
    public void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.f440Ff = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.f445Fk = textTrackStyle;
    }
}
