package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p000v4.app.ActivityCompat21;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.ActivityCompat */
public class ActivityCompat extends ContextCompat {

    /* renamed from: android.support.v4.app.ActivityCompat$OnRequestPermissionsResultCallback */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: android.support.v4.app.ActivityCompat$SharedElementCallback21Impl */
    class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21 {

        /* renamed from: a */
        private SharedElementCallback f279a;

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f279a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f279a.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f279a.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f279a.onMapSharedElements(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f279a.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f279a.onSharedElementEnd(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f279a.onSharedElementStart(list, list2, list3);
        }
    }

    /* renamed from: a */
    private static ActivityCompat21.SharedElementCallback21 m398a(SharedElementCallback sharedElementCallback) {
        if (sharedElementCallback != null) {
            return new SharedElementCallback21Impl(sharedElementCallback);
        }
        return null;
    }

    public static void finishAffinity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(activity);
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.finishAfterTransition(activity);
        } else {
            activity.finish();
        }
    }

    public static boolean invalidateOptionsMenu(Activity activity) {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        ActivityCompatHoneycomb.m400a(activity);
        return true;
    }

    public static void postponeEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.postponeEnterTransition(activity);
        }
    }

    public static void requestPermissions(final Activity activity, final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.requestPermissions(activity, strArr, i);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.setEnterSharedElementCallback(activity, m398a(sharedElementCallback));
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.setExitSharedElementCallback(activity, m398a(sharedElementCallback));
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivity(activity, intent, bundle);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.startPostponedEnterTransition(activity);
        }
    }

    public Uri getReferrer(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return ActivityCompat22.getReferrer(activity);
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }
}
