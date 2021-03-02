package android.support.v13.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.Arrays;

public class FragmentCompat {

    /* renamed from: a */
    static final C0017b f0a;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* renamed from: android.support.v13.app.FragmentCompat$b */
    interface C0017b {
        /* renamed from: a */
        void mo22a(Fragment fragment, boolean z);

        /* renamed from: a */
        void mo23a(Fragment fragment, String[] strArr, int i);

        /* renamed from: a */
        boolean mo24a(Fragment fragment, String str);

        /* renamed from: b */
        void mo25b(Fragment fragment, boolean z);
    }

    /* renamed from: android.support.v13.app.FragmentCompat$a */
    static class C0015a implements C0017b {
        C0015a() {
        }

        /* renamed from: a */
        public void mo22a(Fragment fragment, boolean z) {
        }

        /* renamed from: b */
        public void mo25b(Fragment fragment, boolean z) {
        }

        /* renamed from: a */
        public void mo23a(final Fragment fragment, final String[] strArr, final int i) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                        }
                    } else {
                        Arrays.fill(iArr, -1);
                    }
                    ((OnRequestPermissionsResultCallback) fragment).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }

        /* renamed from: a */
        public boolean mo24a(Fragment fragment, String str) {
            return false;
        }
    }

    /* renamed from: android.support.v13.app.FragmentCompat$c */
    static class C0018c extends C0015a {
        C0018c() {
        }

        /* renamed from: a */
        public void mo22a(Fragment fragment, boolean z) {
            C0608b.m3412a(fragment, z);
        }
    }

    /* renamed from: android.support.v13.app.FragmentCompat$d */
    static class C0019d extends C0018c {
        C0019d() {
        }

        /* renamed from: b */
        public void mo25b(Fragment fragment, boolean z) {
            C0650c.m3568a(fragment, z);
        }
    }

    /* renamed from: android.support.v13.app.FragmentCompat$e */
    static class C0020e extends C0019d {
        C0020e() {
        }

        /* renamed from: a */
        public void mo23a(Fragment fragment, String[] strArr, int i) {
            C0000a.m0a(fragment, strArr, i);
        }

        /* renamed from: a */
        public boolean mo24a(Fragment fragment, String str) {
            return C0000a.m1a(fragment, str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f0a = new C0020e();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f0a = new C0019d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f0a = new C0018c();
        } else {
            f0a = new C0015a();
        }
    }

    public static void setMenuVisibility(Fragment fragment, boolean z) {
        f0a.mo22a(fragment, z);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        f0a.mo25b(fragment, z);
    }

    public static void requestPermissions(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        f0a.mo23a(fragment, strArr, i);
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Fragment fragment, @NonNull String str) {
        return f0a.mo24a(fragment, str);
    }
}
