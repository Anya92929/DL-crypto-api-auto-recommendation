package p000;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.p001v4.media.MediaMetadataCompat;
import p000.C0635bs;

/* renamed from: bu */
public class C0639bu {
    /* renamed from: a */
    public static void m3507a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m3504a(j));
    }

    /* renamed from: a */
    public static Object m3505a(C0635bs.C0636a aVar) {
        return new C0640a(aVar);
    }

    /* renamed from: a */
    public static void m3508a(Object obj, Bundle bundle, long j) {
        RemoteControlClient.MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        C0635bs.m3490a(bundle, editMetadata);
        m3506a(bundle, editMetadata);
        if ((128 & j) != 0) {
            editMetadata.addEditableKey(268435457);
        }
        editMetadata.apply();
    }

    /* renamed from: a */
    public static void m3509a(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) obj2);
    }

    /* renamed from: a */
    static int m3504a(long j) {
        int a = C0637bt.m3497a(j);
        if ((128 & j) != 0) {
            return a | 512;
        }
        return a;
    }

    /* renamed from: a */
    static void m3506a(Bundle bundle, RemoteControlClient.MetadataEditor metadataEditor) {
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

    /* renamed from: bu$a */
    static class C0640a<T extends C0635bs.C0636a> implements RemoteControlClient.OnMetadataUpdateListener {

        /* renamed from: a */
        protected final T f2435a;

        public C0640a(T t) {
            this.f2435a = t;
        }

        public void onMetadataUpdate(int i, Object obj) {
            if (i == 268435457 && (obj instanceof Rating)) {
                this.f2435a.mo1388a(obj);
            }
        }
    }
}
