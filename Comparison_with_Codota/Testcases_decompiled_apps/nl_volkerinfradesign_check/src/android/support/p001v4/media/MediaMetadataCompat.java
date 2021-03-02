package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.media.MediaDescriptionCompat;
import android.support.p001v4.media.MediaMetadataCompatApi21;
import android.support.p001v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: a */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    };
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ArrayMap<String, Integer> f622a = new ArrayMap<>();

    /* renamed from: b */
    private static final String[] f623b = {METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};

    /* renamed from: c */
    private static final String[] f624c = {METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};

    /* renamed from: d */
    private static final String[] f625d = {METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Bundle f626e;

    /* renamed from: f */
    private Object f627f;

    /* renamed from: g */
    private MediaDescriptionCompat f628g;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$BitmapKey */
    public @interface BitmapKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$LongKey */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$RatingKey */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$TextKey */
    public @interface TextKey {
    }

    static {
        f622a.put(METADATA_KEY_TITLE, 1);
        f622a.put(METADATA_KEY_ARTIST, 1);
        f622a.put(METADATA_KEY_DURATION, 0);
        f622a.put(METADATA_KEY_ALBUM, 1);
        f622a.put(METADATA_KEY_AUTHOR, 1);
        f622a.put(METADATA_KEY_WRITER, 1);
        f622a.put(METADATA_KEY_COMPOSER, 1);
        f622a.put(METADATA_KEY_COMPILATION, 1);
        f622a.put(METADATA_KEY_DATE, 1);
        f622a.put(METADATA_KEY_YEAR, 0);
        f622a.put(METADATA_KEY_GENRE, 1);
        f622a.put(METADATA_KEY_TRACK_NUMBER, 0);
        f622a.put(METADATA_KEY_NUM_TRACKS, 0);
        f622a.put(METADATA_KEY_DISC_NUMBER, 0);
        f622a.put(METADATA_KEY_ALBUM_ARTIST, 1);
        f622a.put(METADATA_KEY_ART, 2);
        f622a.put(METADATA_KEY_ART_URI, 1);
        f622a.put(METADATA_KEY_ALBUM_ART, 2);
        f622a.put(METADATA_KEY_ALBUM_ART_URI, 1);
        f622a.put(METADATA_KEY_USER_RATING, 3);
        f622a.put(METADATA_KEY_RATING, 3);
        f622a.put(METADATA_KEY_DISPLAY_TITLE, 1);
        f622a.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        f622a.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        f622a.put(METADATA_KEY_DISPLAY_ICON, 2);
        f622a.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        f622a.put(METADATA_KEY_MEDIA_ID, 1);
    }

    private MediaMetadataCompat(Bundle bundle) {
        this.f626e = new Bundle(bundle);
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.f626e = parcel.readBundle();
    }

    public boolean containsKey(String str) {
        return this.f626e.containsKey(str);
    }

    public CharSequence getText(String str) {
        return this.f626e.getCharSequence(str);
    }

    public String getString(String str) {
        CharSequence charSequence = this.f626e.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public long getLong(String str) {
        return this.f626e.getLong(str, 0);
    }

    public RatingCompat getRating(String str) {
        try {
            return (RatingCompat) this.f626e.getParcelable(str);
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.f626e.getParcelable(str);
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public MediaDescriptionCompat getDescription() {
        int i;
        Bitmap bitmap;
        Uri uri = null;
        if (this.f628g != null) {
            return this.f628g;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i3 < charSequenceArr.length && i2 < f623b.length) {
                int i4 = i2 + 1;
                CharSequence text2 = getText(f623b[i2]);
                if (!TextUtils.isEmpty(text2)) {
                    i = i3 + 1;
                    charSequenceArr[i3] = text2;
                } else {
                    i = i3;
                }
                i3 = i;
                i2 = i4;
            }
        }
        int i5 = 0;
        while (true) {
            if (i5 >= f624c.length) {
                bitmap = null;
                break;
            }
            Bitmap bitmap2 = getBitmap(f624c[i5]);
            if (bitmap2 != null) {
                bitmap = bitmap2;
                break;
            }
            i5++;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= f625d.length) {
                break;
            }
            String string2 = getString(f625d[i6]);
            if (!TextUtils.isEmpty(string2)) {
                uri = Uri.parse(string2);
                break;
            }
            i6++;
        }
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        this.f628g = builder.build();
        return this.f628g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f626e);
    }

    public int size() {
        return this.f626e.size();
    }

    public Set<String> keySet() {
        return this.f626e.keySet();
    }

    public Bundle getBundle() {
        return this.f626e;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        for (String next : MediaMetadataCompatApi21.m620a(obj)) {
            Integer num = f622a.get(next);
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        builder.putLong(next, MediaMetadataCompatApi21.m621b(obj, next));
                        break;
                    case 1:
                        builder.putText(next, MediaMetadataCompatApi21.m623d(obj, next));
                        break;
                    case 2:
                        builder.putBitmap(next, MediaMetadataCompatApi21.m619a(obj, next));
                        break;
                    case 3:
                        builder.putRating(next, RatingCompat.fromRating(MediaMetadataCompatApi21.m622c(obj, next)));
                        break;
                }
            }
        }
        MediaMetadataCompat build = builder.build();
        build.f627f = obj;
        return build;
    }

    public Object getMediaMetadata() {
        if (this.f627f != null || Build.VERSION.SDK_INT < 21) {
            return this.f627f;
        }
        Object newInstance = MediaMetadataCompatApi21.Builder.newInstance();
        for (String next : keySet()) {
            Integer num = f622a.get(next);
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        MediaMetadataCompatApi21.Builder.putLong(newInstance, next, getLong(next));
                        break;
                    case 1:
                        MediaMetadataCompatApi21.Builder.putText(newInstance, next, getText(next));
                        break;
                    case 2:
                        MediaMetadataCompatApi21.Builder.putBitmap(newInstance, next, getBitmap(next));
                        break;
                    case 3:
                        MediaMetadataCompatApi21.Builder.putRating(newInstance, next, getRating(next).getRating());
                        break;
                }
            }
        }
        this.f627f = MediaMetadataCompatApi21.Builder.build(newInstance);
        return this.f627f;
    }

    /* renamed from: android.support.v4.media.MediaMetadataCompat$Builder */
    public static final class Builder {

        /* renamed from: a */
        private final Bundle f629a;

        public Builder() {
            this.f629a = new Bundle();
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            this.f629a = new Bundle(mediaMetadataCompat.f626e);
        }

        public Builder putText(String str, CharSequence charSequence) {
            if (!MediaMetadataCompat.f622a.containsKey(str) || ((Integer) MediaMetadataCompat.f622a.get(str)).intValue() == 1) {
                this.f629a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }

        public Builder putString(String str, String str2) {
            if (!MediaMetadataCompat.f622a.containsKey(str) || ((Integer) MediaMetadataCompat.f622a.get(str)).intValue() == 1) {
                this.f629a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public Builder putLong(String str, long j) {
            if (!MediaMetadataCompat.f622a.containsKey(str) || ((Integer) MediaMetadataCompat.f622a.get(str)).intValue() == 0) {
                this.f629a.putLong(str, j);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            if (!MediaMetadataCompat.f622a.containsKey(str) || ((Integer) MediaMetadataCompat.f622a.get(str)).intValue() == 3) {
                this.f629a.putParcelable(str, ratingCompat);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            if (!MediaMetadataCompat.f622a.containsKey(str) || ((Integer) MediaMetadataCompat.f622a.get(str)).intValue() == 2) {
                this.f629a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.f629a);
        }
    }
}
