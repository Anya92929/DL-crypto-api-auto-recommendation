package android.support.p001v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;

    /* renamed from: a */
    private final int f630a;

    /* renamed from: b */
    private final float f631b;

    /* renamed from: c */
    private Object f632c;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$StarStyle */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$Style */
    public @interface Style {
    }

    private RatingCompat(int i, float f) {
        this.f630a = i;
        this.f631b = f;
    }

    public String toString() {
        return "Rating:style=" + this.f630a + " rating=" + (this.f631b < BitmapDescriptorFactory.HUE_RED ? "unrated" : String.valueOf(this.f631b));
    }

    public int describeContents() {
        return this.f630a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f630a);
        parcel.writeFloat(this.f631b);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= BitmapDescriptorFactory.HUE_RED && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= BitmapDescriptorFactory.HUE_RED && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public boolean isRated() {
        return this.f631b >= BitmapDescriptorFactory.HUE_RED;
    }

    public int getRatingStyle() {
        return this.f630a;
    }

    public boolean hasHeart() {
        boolean z = true;
        if (this.f630a != 1) {
            return false;
        }
        if (this.f631b != 1.0f) {
            z = false;
        }
        return z;
    }

    public boolean isThumbUp() {
        if (this.f630a == 2 && this.f631b == 1.0f) {
            return true;
        }
        return false;
    }

    public float getStarRating() {
        switch (this.f630a) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.f631b;
                }
                break;
        }
        return -1.0f;
    }

    public float getPercentRating() {
        if (this.f630a != 6 || !isRated()) {
            return -1.0f;
        }
        return this.f631b;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && Build.VERSION.SDK_INT >= 21) {
            int b = C0626bp.m3464b(obj);
            if (C0626bp.m3463a(obj)) {
                switch (b) {
                    case 1:
                        ratingCompat = newHeartRating(C0626bp.m3466c(obj));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(C0626bp.m3467d(obj));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(b, C0626bp.m3468e(obj));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(C0626bp.m3469f(obj));
                        break;
                }
            } else {
                ratingCompat = newUnratedRating(b);
            }
            ratingCompat.f632c = obj;
        }
        return ratingCompat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRating() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f632c
            if (r0 != 0) goto L_0x000a
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x000d
        L_0x000a:
            java.lang.Object r0 = r2.f632c
        L_0x000c:
            return r0
        L_0x000d:
            boolean r0 = r2.isRated()
            if (r0 == 0) goto L_0x004a
            int r0 = r2.f630a
            switch(r0) {
                case 1: goto L_0x001a;
                case 2: goto L_0x0027;
                case 3: goto L_0x0032;
                case 4: goto L_0x0032;
                case 5: goto L_0x0032;
                case 6: goto L_0x003f;
                default: goto L_0x0018;
            }
        L_0x0018:
            r0 = 0
            goto L_0x000c
        L_0x001a:
            boolean r0 = r2.hasHeart()
            java.lang.Object r0 = p000.C0626bp.m3462a((boolean) r0)
            r2.f632c = r0
        L_0x0024:
            java.lang.Object r0 = r2.f632c
            goto L_0x000c
        L_0x0027:
            boolean r0 = r2.isThumbUp()
            java.lang.Object r0 = p000.C0626bp.m3465b((boolean) r0)
            r2.f632c = r0
            goto L_0x0024
        L_0x0032:
            int r0 = r2.f630a
            float r1 = r2.getStarRating()
            java.lang.Object r0 = p000.C0626bp.m3461a(r0, r1)
            r2.f632c = r0
            goto L_0x0024
        L_0x003f:
            float r0 = r2.getPercentRating()
            java.lang.Object r0 = p000.C0626bp.m3459a((float) r0)
            r2.f632c = r0
            goto L_0x0018
        L_0x004a:
            int r0 = r2.f630a
            java.lang.Object r0 = p000.C0626bp.m3460a((int) r0)
            r2.f632c = r0
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.media.RatingCompat.getRating():java.lang.Object");
    }
}
