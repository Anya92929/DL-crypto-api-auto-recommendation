package android.support.p001v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* renamed from: android.support.v4.graphics.BitmapCompat */
public class BitmapCompat {

    /* renamed from: a */
    static final C0130b f489a;

    /* renamed from: android.support.v4.graphics.BitmapCompat$b */
    interface C0130b {
        /* renamed from: a */
        void mo864a(Bitmap bitmap, boolean z);

        /* renamed from: a */
        boolean mo865a(Bitmap bitmap);

        /* renamed from: b */
        int mo866b(Bitmap bitmap);
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$a */
    static class C0129a implements C0130b {
        C0129a() {
        }

        /* renamed from: a */
        public boolean mo865a(Bitmap bitmap) {
            return false;
        }

        /* renamed from: a */
        public void mo864a(Bitmap bitmap, boolean z) {
        }

        /* renamed from: b */
        public int mo866b(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$c */
    static class C0131c extends C0129a {
        C0131c() {
        }

        /* renamed from: b */
        public int mo866b(Bitmap bitmap) {
            return C0605ax.m3408a(bitmap);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$d */
    static class C0132d extends C0131c {
        C0132d() {
        }

        /* renamed from: a */
        public boolean mo865a(Bitmap bitmap) {
            return C0606ay.m3410a(bitmap);
        }

        /* renamed from: a */
        public void mo864a(Bitmap bitmap, boolean z) {
            C0606ay.m3409a(bitmap, z);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$e */
    static class C0133e extends C0132d {
        C0133e() {
        }

        /* renamed from: b */
        public int mo866b(Bitmap bitmap) {
            return C0607az.m3411a(bitmap);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f489a = new C0133e();
        } else if (i >= 18) {
            f489a = new C0132d();
        } else if (i >= 12) {
            f489a = new C0131c();
        } else {
            f489a = new C0129a();
        }
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return f489a.mo865a(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        f489a.mo864a(bitmap, z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return f489a.mo866b(bitmap);
    }
}
