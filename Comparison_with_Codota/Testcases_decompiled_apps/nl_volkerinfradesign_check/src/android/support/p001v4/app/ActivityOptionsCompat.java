package android.support.p001v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.p001v4.util.Pair;
import android.view.View;

/* renamed from: android.support.v4.app.ActivityOptionsCompat */
public class ActivityOptionsCompat {
    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new C0039b(C1995p.m7554a(context, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new C0039b(C1995p.m7555a(view, i, i2, i3, i4));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new C0039b(C1995p.m7556a(view, bitmap, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0038a(C1748o.m6478a(activity, view, str));
        }
        return new ActivityOptionsCompat();
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
        return new C0038a(C1748o.m6479a(activity, viewArr, strArr));
    }

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$b */
    static class C0039b extends ActivityOptionsCompat {

        /* renamed from: a */
        private final C1995p f53a;

        C0039b(C1995p pVar) {
            this.f53a = pVar;
        }

        public Bundle toBundle() {
            return this.f53a.mo13696a();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof C0039b) {
                this.f53a.mo13697a(((C0039b) activityOptionsCompat).f53a);
            }
        }
    }

    /* renamed from: android.support.v4.app.ActivityOptionsCompat$a */
    static class C0038a extends ActivityOptionsCompat {

        /* renamed from: a */
        private final C1748o f52a;

        C0038a(C1748o oVar) {
            this.f52a = oVar;
        }

        public Bundle toBundle() {
            return this.f52a.mo10511a();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof C0038a) {
                this.f52a.mo10512a(((C0038a) activityOptionsCompat).f52a);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}
