package android.support.p000v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.p000v4.media.MediaDescriptionCompatApi21;

/* renamed from: android.support.v4.media.MediaDescriptionCompatApi23 */
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {

    /* renamed from: android.support.v4.media.MediaDescriptionCompatApi23$Builder */
    class Builder extends MediaDescriptionCompatApi21.Builder {
        Builder() {
        }

        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
