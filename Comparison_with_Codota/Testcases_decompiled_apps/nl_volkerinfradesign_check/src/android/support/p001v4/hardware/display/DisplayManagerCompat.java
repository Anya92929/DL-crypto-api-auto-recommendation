package android.support.p001v4.hardware.display;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.hardware.display.DisplayManagerCompat */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a */
    private static final WeakHashMap<Context, DisplayManagerCompat> f504a = new WeakHashMap<>();

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (f504a) {
            displayManagerCompat = f504a.get(context);
            if (displayManagerCompat == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new C0143a(context);
                } else {
                    displayManagerCompat = new C0144b(context);
                }
                f504a.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$b */
    static class C0144b extends DisplayManagerCompat {

        /* renamed from: a */
        private final WindowManager f506a;

        public C0144b(Context context) {
            this.f506a = (WindowManager) context.getSystemService("window");
        }

        public Display getDisplay(int i) {
            Display defaultDisplay = this.f506a.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        public Display[] getDisplays() {
            return new Display[]{this.f506a.getDefaultDisplay()};
        }

        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$a */
    static class C0143a extends DisplayManagerCompat {

        /* renamed from: a */
        private final Object f505a;

        public C0143a(Context context) {
            this.f505a = C0621bm.m3436a(context);
        }

        public Display getDisplay(int i) {
            return C0621bm.m3435a(this.f505a, i);
        }

        public Display[] getDisplays() {
            return C0621bm.m3437a(this.f505a);
        }

        public Display[] getDisplays(String str) {
            return C0621bm.m3438a(this.f505a, str);
        }
    }
}
