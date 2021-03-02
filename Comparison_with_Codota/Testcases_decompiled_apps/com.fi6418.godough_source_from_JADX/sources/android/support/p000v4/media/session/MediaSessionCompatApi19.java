package android.support.p000v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.session.MediaSessionCompatApi14;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi19 */
public class MediaSessionCompatApi19 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi19$OnMetadataUpdateListener */
    class OnMetadataUpdateListener<T extends MediaSessionCompatApi14.Callback> implements RemoteControlClient.OnMetadataUpdateListener {

        /* renamed from: a */
        protected final T f970a;

        public OnMetadataUpdateListener(T t) {
            this.f970a = t;
        }

        public void onMetadataUpdate(int i, Object obj) {
            if (i == 268435457 && (obj instanceof Rating)) {
                this.f970a.onSetRating(obj);
            }
        }
    }

    /* renamed from: a */
    static int m735a(long j) {
        int a = MediaSessionCompatApi18.m734a(j);
        return (128 & j) != 0 ? a | 512 : a;
    }

    /* renamed from: a */
    static void m736a(Bundle bundle, RemoteControlClient.MetadataEditor metadataEditor) {
        if (bundle != null) {
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                metadataEditor.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                metadataEditor.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                metadataEditor.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
        }
    }

    public static Object createMetadataUpdateListener(MediaSessionCompatApi14.Callback callback) {
        return new OnMetadataUpdateListener(callback);
    }

    public static void setMetadata(Object obj, Bundle bundle, long j) {
        RemoteControlClient.MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        MediaSessionCompatApi14.m733a(bundle, editMetadata);
        m736a(bundle, editMetadata);
        if ((128 & j) != 0) {
            editMetadata.addEditableKey(268435457);
        }
        editMetadata.apply();
    }

    public static void setOnMetadataUpdateListener(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) obj2);
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m735a(j));
    }
}
