package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.C1341iu;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {

    /* renamed from: Fn */
    private static final String[] f448Fn = {null, "String", "int", "double", "ISO-8601 date String"};

    /* renamed from: Fo */
    private static final C0244a f449Fo = new C0244a().mo4018a(KEY_CREATION_DATE, "creationDateTime", 4).mo4018a(KEY_RELEASE_DATE, "releaseDate", 4).mo4018a(KEY_BROADCAST_DATE, "originalAirdate", 4).mo4018a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).mo4018a(KEY_SUBTITLE, "subtitle", 1).mo4018a(KEY_ARTIST, "artist", 1).mo4018a(KEY_ALBUM_ARTIST, "albumArtist", 1).mo4018a(KEY_ALBUM_TITLE, "albumName", 1).mo4018a(KEY_COMPOSER, "composer", 1).mo4018a(KEY_DISC_NUMBER, "discNumber", 2).mo4018a(KEY_TRACK_NUMBER, "trackNumber", 2).mo4018a(KEY_SEASON_NUMBER, "season", 2).mo4018a(KEY_EPISODE_NUMBER, "episode", 2).mo4018a(KEY_SERIES_TITLE, "seriesTitle", 1).mo4018a(KEY_STUDIO, "studio", 1).mo4018a(KEY_WIDTH, "width", 2).mo4018a(KEY_HEIGHT, "height", 2).mo4018a(KEY_LOCATION_NAME, "location", 1).mo4018a(KEY_LOCATION_LATITUDE, "latitude", 3).mo4018a(KEY_LOCATION_LONGITUDE, "longitude", 3);
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;

    /* renamed from: EA */
    private final List<WebImage> f450EA;

    /* renamed from: Fp */
    private final Bundle f451Fp;

    /* renamed from: Fq */
    private int f452Fq;

    /* renamed from: com.google.android.gms.cast.MediaMetadata$a */
    private static class C0244a {

        /* renamed from: Fr */
        private final Map<String, String> f453Fr = new HashMap();

        /* renamed from: Fs */
        private final Map<String, String> f454Fs = new HashMap();

        /* renamed from: Ft */
        private final Map<String, Integer> f455Ft = new HashMap();

        /* renamed from: a */
        public C0244a mo4018a(String str, String str2, int i) {
            this.f453Fr.put(str, str2);
            this.f454Fs.put(str2, str);
            this.f455Ft.put(str, Integer.valueOf(i));
            return this;
        }

        /* renamed from: aA */
        public String mo4019aA(String str) {
            return this.f454Fs.get(str);
        }

        /* renamed from: aB */
        public int mo4020aB(String str) {
            Integer num = this.f455Ft.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        /* renamed from: az */
        public String mo4021az(String str) {
            return this.f453Fr.get(str);
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.f450EA = new ArrayList();
        this.f451Fp = new Bundle();
        this.f452Fq = mediaType;
    }

    /* renamed from: a */
    private void m396a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.f451Fp.containsKey(str)) {
                    switch (f449Fo.mo4020aB(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(f449Fo.mo4021az(str), this.f451Fp.getString(str));
                            break;
                        case 2:
                            jSONObject.put(f449Fo.mo4021az(str), this.f451Fp.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(f449Fo.mo4021az(str), this.f451Fp.getDouble(str));
                            break;
                    }
                }
            }
            for (String str2 : this.f451Fp.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.f451Fp.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    private boolean m397a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m397a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m398b(JSONObject jSONObject, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"metadataType".equals(next)) {
                    String aA = f449Fo.mo4019aA(next);
                    if (aA == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.f451Fp.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.f451Fp.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.f451Fp.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(aA)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                switch (f449Fo.mo4020aB(aA)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        } else {
                                            this.f451Fp.putString(aA, (String) obj2);
                                            break;
                                        }
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        } else {
                                            this.f451Fp.putInt(aA, ((Integer) obj2).intValue());
                                            break;
                                        }
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        } else {
                                            this.f451Fp.putDouble(aA, ((Double) obj2).doubleValue());
                                            break;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && C1341iu.m5078aL((String) obj2) != null) {
                                            this.f451Fp.putString(aA, (String) obj2);
                                            break;
                                        }
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: f */
    private void m399f(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int aB = f449Fo.mo4020aB(str);
        if (aB != i && aB != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + f448Fn[i]);
        }
    }

    public void addImage(WebImage image) {
        this.f450EA.add(image);
    }

    /* renamed from: bL */
    public JSONObject mo3998bL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.f452Fq);
        } catch (JSONException e) {
        }
        C1341iu.m5077a(jSONObject, this.f450EA);
        switch (this.f452Fq) {
            case 0:
                m396a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                m396a(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                m396a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                m396a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                m396a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                m396a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo3999c(JSONObject jSONObject) {
        clear();
        this.f452Fq = 0;
        try {
            this.f452Fq = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        C1341iu.m5076a(this.f450EA, jSONObject);
        switch (this.f452Fq) {
            case 0:
                m398b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                m398b(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                m398b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                m398b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                m398b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                m398b(jSONObject, new String[0]);
                return;
        }
    }

    public void clear() {
        this.f451Fp.clear();
        this.f450EA.clear();
    }

    public void clearImages() {
        this.f450EA.clear();
    }

    public boolean containsKey(String key) {
        return this.f451Fp.containsKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return m397a(this.f451Fp, mediaMetadata.f451Fp) && this.f450EA.equals(mediaMetadata.f450EA);
    }

    public Calendar getDate(String key) {
        m399f(key, 4);
        String string = this.f451Fp.getString(key);
        if (string != null) {
            return C1341iu.m5078aL(string);
        }
        return null;
    }

    public String getDateAsString(String key) {
        m399f(key, 4);
        return this.f451Fp.getString(key);
    }

    public double getDouble(String key) {
        m399f(key, 3);
        return this.f451Fp.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.f450EA;
    }

    public int getInt(String key) {
        m399f(key, 2);
        return this.f451Fp.getInt(key);
    }

    public int getMediaType() {
        return this.f452Fq;
    }

    public String getString(String key) {
        m399f(key, 1);
        return this.f451Fp.getString(key);
    }

    public boolean hasImages() {
        return this.f450EA != null && !this.f450EA.isEmpty();
    }

    public int hashCode() {
        int i = 17;
        Iterator it = this.f451Fp.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (i2 * 31) + this.f450EA.hashCode();
            }
            i = this.f451Fp.get((String) it.next()).hashCode() + (i2 * 31);
        }
    }

    public Set<String> keySet() {
        return this.f451Fp.keySet();
    }

    public void putDate(String key, Calendar value) {
        m399f(key, 4);
        this.f451Fp.putString(key, C1341iu.m5075a(value));
    }

    public void putDouble(String key, double value) {
        m399f(key, 3);
        this.f451Fp.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        m399f(key, 2);
        this.f451Fp.putInt(key, value);
    }

    public void putString(String key, String value) {
        m399f(key, 1);
        this.f451Fp.putString(key, value);
    }
}
