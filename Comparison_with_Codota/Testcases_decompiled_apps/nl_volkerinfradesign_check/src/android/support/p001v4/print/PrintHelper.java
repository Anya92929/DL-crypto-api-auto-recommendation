package android.support.p001v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.p001v4.print.PrintHelperKitkat;
import java.io.FileNotFoundException;

/* renamed from: android.support.v4.print.PrintHelper */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: a */
    C0235c f780a;

    /* renamed from: android.support.v4.print.PrintHelper$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* renamed from: android.support.v4.print.PrintHelper$c */
    interface C0235c {
        /* renamed from: a */
        int mo1485a();

        /* renamed from: a */
        void mo1486a(int i);

        /* renamed from: a */
        void mo1487a(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        /* renamed from: a */
        void mo1488a(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        /* renamed from: b */
        int mo1489b();

        /* renamed from: b */
        void mo1490b(int i);

        /* renamed from: c */
        int mo1491c();

        /* renamed from: c */
        void mo1492c(int i);
    }

    public static boolean systemSupportsPrint() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return false;
    }

    /* renamed from: android.support.v4.print.PrintHelper$b */
    static final class C0234b implements C0235c {

        /* renamed from: a */
        int f786a;

        /* renamed from: b */
        int f787b;

        /* renamed from: c */
        int f788c;

        private C0234b() {
            this.f786a = 2;
            this.f787b = 2;
            this.f788c = 1;
        }

        /* renamed from: a */
        public void mo1486a(int i) {
            this.f786a = i;
        }

        /* renamed from: b */
        public int mo1489b() {
            return this.f787b;
        }

        /* renamed from: b */
        public void mo1490b(int i) {
            this.f787b = i;
        }

        /* renamed from: c */
        public void mo1492c(int i) {
            this.f788c = i;
        }

        /* renamed from: c */
        public int mo1491c() {
            return this.f788c;
        }

        /* renamed from: a */
        public int mo1485a() {
            return this.f786a;
        }

        /* renamed from: a */
        public void mo1487a(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        /* renamed from: a */
        public void mo1488a(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }
    }

    /* renamed from: android.support.v4.print.PrintHelper$a */
    static final class C0231a implements C0235c {

        /* renamed from: a */
        private final PrintHelperKitkat f781a;

        C0231a(Context context) {
            this.f781a = new PrintHelperKitkat(context);
        }

        /* renamed from: a */
        public void mo1486a(int i) {
            this.f781a.mo1495a(i);
        }

        /* renamed from: a */
        public int mo1485a() {
            return this.f781a.mo1494a();
        }

        /* renamed from: b */
        public void mo1490b(int i) {
            this.f781a.mo1499b(i);
        }

        /* renamed from: b */
        public int mo1489b() {
            return this.f781a.mo1500c();
        }

        /* renamed from: c */
        public void mo1492c(int i) {
            this.f781a.mo1501c(i);
        }

        /* renamed from: c */
        public int mo1491c() {
            return this.f781a.mo1498b();
        }

        /* renamed from: a */
        public void mo1487a(String str, Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
            C02321 r0 = null;
            if (onPrintFinishCallback != null) {
                r0 = new PrintHelperKitkat.OnPrintFinishCallback() {
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.f781a.mo1496a(str, bitmap, (PrintHelperKitkat.OnPrintFinishCallback) r0);
        }

        /* renamed from: a */
        public void mo1488a(String str, Uri uri, final OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            C02332 r0 = null;
            if (onPrintFinishCallback != null) {
                r0 = new PrintHelperKitkat.OnPrintFinishCallback() {
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.f781a.mo1497a(str, uri, (PrintHelperKitkat.OnPrintFinishCallback) r0);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.f780a = new C0231a(context);
        } else {
            this.f780a = new C0234b();
        }
    }

    public void setScaleMode(int i) {
        this.f780a.mo1486a(i);
    }

    public int getScaleMode() {
        return this.f780a.mo1485a();
    }

    public void setColorMode(int i) {
        this.f780a.mo1490b(i);
    }

    public int getColorMode() {
        return this.f780a.mo1489b();
    }

    public void setOrientation(int i) {
        this.f780a.mo1492c(i);
    }

    public int getOrientation() {
        return this.f780a.mo1491c();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.f780a.mo1487a(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.f780a.mo1487a(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.f780a.mo1488a(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.f780a.mo1488a(str, uri, onPrintFinishCallback);
    }
}
