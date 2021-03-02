package android.support.p001v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.session.MediaController;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.ActivityCompat21 */
class ActivityCompat21 {

    /* renamed from: android.support.v4.app.ActivityCompat21$SharedElementCallback21 */
    public static abstract class SharedElementCallback21 {
        public abstract Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF);

        public abstract View onCreateSnapshotView(Context context, Parcelable parcelable);

        public abstract void onMapSharedElements(List<String> list, Map<String, View> map);

        public abstract void onRejectSharedElements(List<View> list);

        public abstract void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3);

        public abstract void onSharedElementStart(List<String> list, List<View> list2, List<View> list3);
    }

    /* renamed from: a */
    public static void m99a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    /* renamed from: a */
    public static void m97a(Activity activity) {
        activity.finishAfterTransition();
    }

    /* renamed from: a */
    public static void m98a(Activity activity, SharedElementCallback21 sharedElementCallback21) {
        activity.setEnterSharedElementCallback(m96a(sharedElementCallback21));
    }

    /* renamed from: b */
    public static void m101b(Activity activity, SharedElementCallback21 sharedElementCallback21) {
        activity.setExitSharedElementCallback(m96a(sharedElementCallback21));
    }

    /* renamed from: b */
    public static void m100b(Activity activity) {
        activity.postponeEnterTransition();
    }

    /* renamed from: c */
    public static void m102c(Activity activity) {
        activity.startPostponedEnterTransition();
    }

    /* renamed from: a */
    private static SharedElementCallback m96a(SharedElementCallback21 sharedElementCallback21) {
        if (sharedElementCallback21 != null) {
            return new C0037a(sharedElementCallback21);
        }
        return null;
    }

    /* renamed from: android.support.v4.app.ActivityCompat21$a */
    static class C0037a extends SharedElementCallback {

        /* renamed from: a */
        private SharedElementCallback21 f51a;

        public C0037a(SharedElementCallback21 sharedElementCallback21) {
            this.f51a = sharedElementCallback21;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f51a.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f51a.onSharedElementEnd(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f51a.onRejectSharedElements(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f51a.onMapSharedElements(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f51a.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f51a.onCreateSnapshotView(context, parcelable);
        }
    }
}
