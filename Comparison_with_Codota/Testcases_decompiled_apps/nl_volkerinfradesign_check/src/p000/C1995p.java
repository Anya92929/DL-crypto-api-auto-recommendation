package p000;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

/* renamed from: p */
public class C1995p {

    /* renamed from: a */
    private final ActivityOptions f7280a;

    /* renamed from: a */
    public static C1995p m7554a(Context context, int i, int i2) {
        return new C1995p(ActivityOptions.makeCustomAnimation(context, i, i2));
    }

    /* renamed from: a */
    public static C1995p m7555a(View view, int i, int i2, int i3, int i4) {
        return new C1995p(ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4));
    }

    /* renamed from: a */
    public static C1995p m7556a(View view, Bitmap bitmap, int i, int i2) {
        return new C1995p(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
    }

    private C1995p(ActivityOptions activityOptions) {
        this.f7280a = activityOptions;
    }

    /* renamed from: a */
    public Bundle mo13696a() {
        return this.f7280a.toBundle();
    }

    /* renamed from: a */
    public void mo13697a(C1995p pVar) {
        this.f7280a.update(pVar.f7280a);
    }
}
