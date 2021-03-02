package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.internal.C1326ik;
import com.google.android.gms.internal.C1390jz;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;

    /* renamed from: Dj */
    private long f467Dj;

    /* renamed from: FD */
    private int f468FD;

    /* renamed from: FE */
    private int f469FE;

    /* renamed from: Fc */
    private String f470Fc;

    /* renamed from: Fe */
    private String f471Fe;

    /* renamed from: Fg */
    private String f472Fg;

    /* renamed from: Fl */
    private JSONObject f473Fl;
    private String mName;

    public static class Builder {

        /* renamed from: FF */
        private final MediaTrack f474FF;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.f474FF = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.f474FF;
        }

        public Builder setContentId(String contentId) {
            this.f474FF.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.f474FF.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.f474FF.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.f474FF.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.f474FF.setLanguage(C1326ik.m4988b(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.f474FF.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.f474FF.mo4034aa(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.f467Dj = id;
        if (type <= 0 || type > 3) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.f468FD = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        m408c(json);
    }

    /* renamed from: c */
    private void m408c(JSONObject jSONObject) throws JSONException {
        clear();
        this.f467Dj = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.f468FD = 1;
        } else if ("AUDIO".equals(string)) {
            this.f468FD = 2;
        } else if ("VIDEO".equals(string)) {
            this.f468FD = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.f471Fe = jSONObject.optString("trackContentId", (String) null);
        this.f472Fg = jSONObject.optString("trackContentType", (String) null);
        this.mName = jSONObject.optString("name", (String) null);
        this.f470Fc = jSONObject.optString("language", (String) null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.f469FE = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.f469FE = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.f469FE = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.f469FE = 4;
            } else if ("METADATA".equals(string2)) {
                this.f469FE = 5;
            } else {
                throw new JSONException("invalid subtype: " + string2);
            }
        } else {
            this.f469FE = 0;
        }
        this.f473Fl = jSONObject.optJSONObject("customData");
    }

    private void clear() {
        this.f467Dj = 0;
        this.f468FD = 0;
        this.f471Fe = null;
        this.mName = null;
        this.f470Fc = null;
        this.f469FE = -1;
        this.f473Fl = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aa */
    public void mo4034aa(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.f468FD == 1) {
            this.f469FE = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }

    /* renamed from: bL */
    public JSONObject mo4035bL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.f467Dj);
            switch (this.f468FD) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.f471Fe != null) {
                jSONObject.put("trackContentId", this.f471Fe);
            }
            if (this.f472Fg != null) {
                jSONObject.put("trackContentType", this.f472Fg);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.f470Fc)) {
                jSONObject.put("language", this.f470Fc);
            }
            switch (this.f469FE) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.f473Fl != null) {
                jSONObject.put("customData", this.f473Fl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.f473Fl == null) != (mediaTrack.f473Fl == null)) {
            return false;
        }
        if (this.f473Fl != null && mediaTrack.f473Fl != null && !C1390jz.m5226d(this.f473Fl, mediaTrack.f473Fl)) {
            return false;
        }
        if (this.f467Dj != mediaTrack.f467Dj || this.f468FD != mediaTrack.f468FD || !C1326ik.m4984a(this.f471Fe, mediaTrack.f471Fe) || !C1326ik.m4984a(this.f472Fg, mediaTrack.f472Fg) || !C1326ik.m4984a(this.mName, mediaTrack.mName) || !C1326ik.m4984a(this.f470Fc, mediaTrack.f470Fc) || this.f469FE != mediaTrack.f469FE) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.f471Fe;
    }

    public String getContentType() {
        return this.f472Fg;
    }

    public JSONObject getCustomData() {
        return this.f473Fl;
    }

    public long getId() {
        return this.f467Dj;
    }

    public String getLanguage() {
        return this.f470Fc;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.f469FE;
    }

    public int getType() {
        return this.f468FD;
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f467Dj), Integer.valueOf(this.f468FD), this.f471Fe, this.f472Fg, this.mName, this.f470Fc, Integer.valueOf(this.f469FE), this.f473Fl);
    }

    public void setContentId(String contentId) {
        this.f471Fe = contentId;
    }

    public void setContentType(String contentType) {
        this.f472Fg = contentType;
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(JSONObject customData) {
        this.f473Fl = customData;
    }

    /* access modifiers changed from: package-private */
    public void setLanguage(String language) {
        this.f470Fc = language;
    }

    /* access modifiers changed from: package-private */
    public void setName(String name) {
        this.mName = name;
    }
}
