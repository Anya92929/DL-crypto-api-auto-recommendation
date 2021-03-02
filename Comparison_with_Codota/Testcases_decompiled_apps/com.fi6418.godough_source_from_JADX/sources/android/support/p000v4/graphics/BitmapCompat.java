package android.support.p000v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* renamed from: android.support.v4.graphics.BitmapCompat */
public class BitmapCompat {

    /* renamed from: a */
    static final BitmapImpl f782a;

    /* renamed from: android.support.v4.graphics.BitmapCompat$BaseBitmapImpl */
    class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapImpl */
    interface BitmapImpl {
        int getAllocationByteCount(Bitmap bitmap);

        boolean hasMipMap(Bitmap bitmap);

        void setHasMipMap(Bitmap bitmap, boolean z);
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$HcMr1BitmapCompatImpl */
    class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatHoneycombMr1.m652a(bitmap);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$JbMr2BitmapCompatImpl */
    class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return BitmapCompatJellybeanMR2.hasMipMap(bitmap);
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
            BitmapCompatJellybeanMR2.setHasMipMap(bitmap, z);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$KitKatBitmapCompatImpl */
    class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatKitKat.m653a(bitmap);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f782a = new KitKatBitmapCompatImpl();
        } else if (i >= 18) {
            f782a = new JbMr2BitmapCompatImpl();
        } else if (i >= 12) {
            f782a = new HcMr1BitmapCompatImpl();
        } else {
            f782a = new BaseBitmapImpl();
        }
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return f782a.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return f782a.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        f782a.setHasMipMap(bitmap, z);
    }
}
