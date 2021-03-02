package p000;

import android.media.MediaDescription;
import android.net.Uri;
import p000.C0622bn;

/* renamed from: bo */
public class C0624bo extends C0622bn {
    /* renamed from: h */
    public static Uri m3457h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    /* renamed from: bo$a */
    public static class C0625a extends C0622bn.C0623a {
        /* renamed from: b */
        public static void m3458b(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }
}
