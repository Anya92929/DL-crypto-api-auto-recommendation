package p000;

import android.support.p001v4.media.session.PlaybackStateCompat;

/* renamed from: jg */
public final class C1317jg {

    /* renamed from: a */
    static C1316jf f4577a;

    /* renamed from: b */
    static long f4578b;

    private C1317jg() {
    }

    /* renamed from: a */
    public static C1316jf m5700a() {
        synchronized (C1317jg.class) {
            if (f4577a == null) {
                return new C1316jf();
            }
            C1316jf jfVar = f4577a;
            f4577a = jfVar.f4575f;
            jfVar.f4575f = null;
            f4578b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            return jfVar;
        }
    }

    /* renamed from: a */
    public static void m5701a(C1316jf jfVar) {
        if (jfVar.f4575f != null || jfVar.f4576g != null) {
            throw new IllegalArgumentException();
        } else if (!jfVar.f4573d) {
            synchronized (C1317jg.class) {
                if (f4578b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH <= 65536) {
                    f4578b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    jfVar.f4575f = f4577a;
                    jfVar.f4572c = 0;
                    jfVar.f4571b = 0;
                    f4577a = jfVar;
                }
            }
        }
    }
}
