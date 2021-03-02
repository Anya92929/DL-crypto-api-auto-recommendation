package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.util.Pair;
import android.view.View;

/* renamed from: android.support.v4.app.ActivityOptionsCompat */
public class ActivityOptionsCompat {

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImpl21 */
    class ActivityOptionsImpl21 extends ActivityOptionsCompat {

        /* renamed from: a */
        private final ActivityOptionsCompat21 f281a;

        ActivityOptionsImpl21(ActivityOptionsCompat21 activityOptionsCompat21) {
            this.f281a = activityOptionsCompat21;
        }

        public Bundle toBundle() {
            return this.f281a.toBundle();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImpl21) {
                this.f281a.update(((ActivityOptionsImpl21) activityOptionsCompat).f281a);
            }
        }
    }

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$ActivityOptionsImplJB */
    class ActivityOptionsImplJB extends ActivityOptionsCompat {

        /* renamed from: a */
        private final ActivityOptionsCompatJB f282a;

        ActivityOptionsImplJB(ActivityOptionsCompatJB activityOptionsCompatJB) {
            this.f282a = activityOptionsCompatJB;
        }

        public Bundle toBundle() {
            return this.f282a.toBundle();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImplJB) {
                this.f282a.update(((ActivityOptionsImplJB) activityOptionsCompat).f282a);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, i, i2)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(view, i, i2, i3, i4)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        return Build.VERSION.SDK_INT >= 21 ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, view, str)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        View[] viewArr;
        String[] strArr = null;
        if (Build.VERSION.SDK_INT < 21) {
            return new ActivityOptionsCompat();
        }
        if (pairArr != null) {
            View[] viewArr2 = new View[pairArr.length];
            String[] strArr2 = new String[pairArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pairArr.length) {
                    break;
                }
                viewArr2[i2] = (View) pairArr[i2].first;
                strArr2[i2] = (String) pairArr[i2].second;
                i = i2 + 1;
            }
            strArr = strArr2;
            viewArr = viewArr2;
        } else {
            viewArr = null;
        }
        return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, viewArr, strArr));
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(view, bitmap, i, i2)) : new ActivityOptionsCompat();
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}
