package android.support.p000v4.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

/* renamed from: android.support.v4.app.ActivityOptionsCompatJB */
class ActivityOptionsCompatJB {

    /* renamed from: a */
    private final ActivityOptions f284a;

    private ActivityOptionsCompatJB(ActivityOptions activityOptions) {
        this.f284a = activityOptions;
    }

    public static ActivityOptionsCompatJB makeCustomAnimation(Context context, int i, int i2) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeCustomAnimation(context, i, i2));
    }

    public static ActivityOptionsCompatJB makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4));
    }

    public static ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
    }

    public Bundle toBundle() {
        return this.f284a.toBundle();
    }

    public void update(ActivityOptionsCompatJB activityOptionsCompatJB) {
        this.f284a.update(activityOptionsCompatJB.f284a);
    }
}
