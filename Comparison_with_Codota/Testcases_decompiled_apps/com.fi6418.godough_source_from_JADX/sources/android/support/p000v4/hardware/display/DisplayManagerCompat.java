package android.support.p000v4.hardware.display;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.hardware.display.DisplayManagerCompat */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a */
    private static final WeakHashMap<Context, DisplayManagerCompat> f808a = new WeakHashMap<>();

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$JellybeanMr1Impl */
    class JellybeanMr1Impl extends DisplayManagerCompat {

        /* renamed from: a */
        private final Object f809a;

        public JellybeanMr1Impl(Context context) {
            this.f809a = DisplayManagerJellybeanMr1.getDisplayManager(context);
        }

        public Display getDisplay(int i) {
            return DisplayManagerJellybeanMr1.getDisplay(this.f809a, i);
        }

        public Display[] getDisplays() {
            return DisplayManagerJellybeanMr1.getDisplays(this.f809a);
        }

        public Display[] getDisplays(String str) {
            return DisplayManagerJellybeanMr1.getDisplays(this.f809a, str);
        }
    }

    /* renamed from: android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl */
    class LegacyImpl extends DisplayManagerCompat {

        /* renamed from: a */
        private final WindowManager f810a;

        public LegacyImpl(Context context) {
            this.f810a = (WindowManager) context.getSystemService("window");
        }

        public Display getDisplay(int i) {
            Display defaultDisplay = this.f810a.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        public Display[] getDisplays() {
            return new Display[]{this.f810a.getDefaultDisplay()};
        }

        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (f808a) {
            displayManagerCompat = f808a.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = Build.VERSION.SDK_INT >= 17 ? new JellybeanMr1Impl(context) : new LegacyImpl(context);
                f808a.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);
}
