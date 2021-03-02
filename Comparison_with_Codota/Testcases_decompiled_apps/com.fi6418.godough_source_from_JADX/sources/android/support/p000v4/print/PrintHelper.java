package android.support.p000v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.print.PrintHelperKitkat;

/* renamed from: android.support.v4.print.PrintHelper */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: a */
    PrintHelperVersionImpl f1012a;

    /* renamed from: android.support.v4.print.PrintHelper$OnPrintFinishCallback */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperKitkatImpl */
    final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {

        /* renamed from: a */
        private final PrintHelperKitkat f1013a;

        PrintHelperKitkatImpl(Context context) {
            this.f1013a = new PrintHelperKitkat(context);
        }

        public int getColorMode() {
            return this.f1013a.getColorMode();
        }

        public int getOrientation() {
            return this.f1013a.getOrientation();
        }

        public int getScaleMode() {
            return this.f1013a.getScaleMode();
        }

        public void printBitmap(String str, Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
            C01521 r0 = null;
            if (onPrintFinishCallback != null) {
                r0 = new PrintHelperKitkat.OnPrintFinishCallback() {
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.f1013a.printBitmap(str, bitmap, (PrintHelperKitkat.OnPrintFinishCallback) r0);
        }

        public void printBitmap(String str, Uri uri, final OnPrintFinishCallback onPrintFinishCallback) {
            C01532 r0 = null;
            if (onPrintFinishCallback != null) {
                r0 = new PrintHelperKitkat.OnPrintFinishCallback() {
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.f1013a.printBitmap(str, uri, (PrintHelperKitkat.OnPrintFinishCallback) r0);
        }

        public void setColorMode(int i) {
            this.f1013a.setColorMode(i);
        }

        public void setOrientation(int i) {
            this.f1013a.setOrientation(i);
        }

        public void setScaleMode(int i) {
            this.f1013a.setScaleMode(i);
        }
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperStubImpl */
    final class PrintHelperStubImpl implements PrintHelperVersionImpl {

        /* renamed from: a */
        int f1018a;

        /* renamed from: b */
        int f1019b;

        /* renamed from: c */
        int f1020c;

        private PrintHelperStubImpl() {
            this.f1018a = 2;
            this.f1019b = 2;
            this.f1020c = 1;
        }

        public int getColorMode() {
            return this.f1019b;
        }

        public int getOrientation() {
            return this.f1020c;
        }

        public int getScaleMode() {
            return this.f1018a;
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public void setColorMode(int i) {
            this.f1019b = i;
        }

        public void setOrientation(int i) {
            this.f1020c = i;
        }

        public void setScaleMode(int i) {
            this.f1018a = i;
        }
    }

    /* renamed from: android.support.v4.print.PrintHelper$PrintHelperVersionImpl */
    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback);

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.f1012a = new PrintHelperKitkatImpl(context);
        } else {
            this.f1012a = new PrintHelperStubImpl();
        }
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.f1012a.getColorMode();
    }

    public int getOrientation() {
        return this.f1012a.getOrientation();
    }

    public int getScaleMode() {
        return this.f1012a.getScaleMode();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.f1012a.printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.f1012a.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) {
        this.f1012a.printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        this.f1012a.printBitmap(str, uri, onPrintFinishCallback);
    }

    public void setColorMode(int i) {
        this.f1012a.setColorMode(i);
    }

    public void setOrientation(int i) {
        this.f1012a.setOrientation(i);
    }

    public void setScaleMode(int i) {
        this.f1012a.setScaleMode(i);
    }
}
