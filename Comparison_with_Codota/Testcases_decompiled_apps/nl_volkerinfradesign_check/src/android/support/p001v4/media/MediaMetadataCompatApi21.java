package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import java.util.Set;

/* renamed from: android.support.v4.media.MediaMetadataCompatApi21 */
class MediaMetadataCompatApi21 {
    /* renamed from: a */
    public static Set<String> m620a(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }

    /* renamed from: a */
    public static Bitmap m619a(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    /* renamed from: b */
    public static long m621b(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    /* renamed from: c */
    public static Object m622c(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    /* renamed from: d */
    public static CharSequence m623d(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }

    /* renamed from: android.support.v4.media.MediaMetadataCompatApi21$Builder */
    public static class Builder {
        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        public static void putBitmap(Object obj, String str, Bitmap bitmap) {
            ((MediaMetadata.Builder) obj).putBitmap(str, bitmap);
        }

        public static void putLong(Object obj, String str, long j) {
            ((MediaMetadata.Builder) obj).putLong(str, j);
        }

        public static void putRating(Object obj, String str, Object obj2) {
            ((MediaMetadata.Builder) obj).putRating(str, (Rating) obj2);
        }

        public static void putText(Object obj, String str, CharSequence charSequence) {
            ((MediaMetadata.Builder) obj).putText(str, charSequence);
        }

        public static void putString(Object obj, String str, String str2) {
            ((MediaMetadata.Builder) obj).putString(str, str2);
        }

        public static Object build(Object obj) {
            return ((MediaMetadata.Builder) obj).build();
        }
    }
}
