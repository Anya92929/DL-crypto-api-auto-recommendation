package android.support.p001v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import p000.C0641bv;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi23 */
class MediaSessionCompatApi23 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$Callback */
    public interface Callback extends C0641bv.C0642a {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    /* renamed from: a */
    public static Object m838a(Callback callback) {
        return new C0210a(callback);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$a */
    static class C0210a<T extends Callback> extends C0641bv.C0643b<T> {
        public C0210a(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.f2436a).onPlayFromUri(uri, bundle);
        }
    }
}
