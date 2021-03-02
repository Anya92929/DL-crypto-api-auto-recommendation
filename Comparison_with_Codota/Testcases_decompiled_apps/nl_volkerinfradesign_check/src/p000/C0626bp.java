package p000;

import android.media.Rating;

/* renamed from: bp */
public class C0626bp {
    /* renamed from: a */
    public static Object m3460a(int i) {
        return Rating.newUnratedRating(i);
    }

    /* renamed from: a */
    public static Object m3462a(boolean z) {
        return Rating.newHeartRating(z);
    }

    /* renamed from: b */
    public static Object m3465b(boolean z) {
        return Rating.newThumbRating(z);
    }

    /* renamed from: a */
    public static Object m3461a(int i, float f) {
        return Rating.newStarRating(i, f);
    }

    /* renamed from: a */
    public static Object m3459a(float f) {
        return Rating.newPercentageRating(f);
    }

    /* renamed from: a */
    public static boolean m3463a(Object obj) {
        return ((Rating) obj).isRated();
    }

    /* renamed from: b */
    public static int m3464b(Object obj) {
        return ((Rating) obj).getRatingStyle();
    }

    /* renamed from: c */
    public static boolean m3466c(Object obj) {
        return ((Rating) obj).hasHeart();
    }

    /* renamed from: d */
    public static boolean m3467d(Object obj) {
        return ((Rating) obj).isThumbUp();
    }

    /* renamed from: e */
    public static float m3468e(Object obj) {
        return ((Rating) obj).getStarRating();
    }

    /* renamed from: f */
    public static float m3469f(Object obj) {
        return ((Rating) obj).getPercentRating();
    }
}
