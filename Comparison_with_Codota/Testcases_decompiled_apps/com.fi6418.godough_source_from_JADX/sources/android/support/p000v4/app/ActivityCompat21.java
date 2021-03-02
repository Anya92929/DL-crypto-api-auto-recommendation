package android.support.p000v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.ActivityCompat21 */
class ActivityCompat21 {

    /* renamed from: android.support.v4.app.ActivityCompat21$SharedElementCallback21 */
    public abstract class SharedElementCallback21 {
        public abstract Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF);

        public abstract View onCreateSnapshotView(Context context, Parcelable parcelable);

        public abstract void onMapSharedElements(List<String> list, Map<String, View> map);

        public abstract void onRejectSharedElements(List<View> list);

        public abstract void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3);

        public abstract void onSharedElementStart(List<String> list, List<View> list2, List<View> list3);
    }

    /* renamed from: android.support.v4.app.ActivityCompat21$SharedElementCallbackImpl */
    class SharedElementCallbackImpl extends SharedElementCallback {

        /* renamed from: a */
        private SharedElementCallback21 f280a;

        public SharedElementCallbackImpl(SharedElementCallback21 sharedElementCallback21) {
            this.f280a = sharedElementCallback21;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f280a.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f280a.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f280a.onMapSharedElements(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f280a.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f280a.onSharedElementEnd(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f280a.onSharedElementStart(list, list2, list3);
        }
    }

    ActivityCompat21() {
    }

    /* renamed from: a */
    private static SharedElementCallback m399a(SharedElementCallback21 sharedElementCallback21) {
        if (sharedElementCallback21 != null) {
            return new SharedElementCallbackImpl(sharedElementCallback21);
        }
        return null;
    }

    public static void finishAfterTransition(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void postponeEnterTransition(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback21 sharedElementCallback21) {
        activity.setEnterSharedElementCallback(m399a(sharedElementCallback21));
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback21 sharedElementCallback21) {
        activity.setExitSharedElementCallback(m399a(sharedElementCallback21));
    }

    public static void startPostponedEnterTransition(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
