package android.support.p001v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import android.support.p001v4.media.routing.MediaRouterJellybean;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1 */
class MediaRouterJellybeanMr1 extends MediaRouterJellybean {

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$Callback */
    public interface Callback extends MediaRouterJellybean.Callback {
        void onRoutePresentationDisplayChanged(Object obj);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$RouteInfo */
    public static final class RouteInfo {
        public static boolean isEnabled(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }

        public static Display getPresentationDisplay(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$ActiveScanWorkaround */
    public static final class ActiveScanWorkaround implements Runnable {

        /* renamed from: a */
        private final DisplayManager f653a;

        /* renamed from: b */
        private final Handler f654b;

        /* renamed from: c */
        private Method f655c;

        /* renamed from: d */
        private boolean f656d;

        public ActiveScanWorkaround(Context context, Handler handler) {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            this.f653a = (DisplayManager) context.getSystemService("display");
            this.f654b = handler;
            try {
                this.f655c = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public void setActiveScanRouteTypes(int i) {
            if ((i & 2) != 0) {
                if (this.f656d) {
                    return;
                }
                if (this.f655c != null) {
                    this.f656d = true;
                    this.f654b.post(this);
                    return;
                }
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
            } else if (this.f656d) {
                this.f656d = false;
                this.f654b.removeCallbacks(this);
            }
        }

        public void run() {
            if (this.f656d) {
                try {
                    this.f655c.invoke(this.f653a, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
                } catch (InvocationTargetException e2) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
                }
                this.f654b.postDelayed(this, 15000);
            }
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$IsConnectingWorkaround */
    public static final class IsConnectingWorkaround {

        /* renamed from: a */
        private Method f657a;

        /* renamed from: b */
        private int f658b;

        public IsConnectingWorkaround() {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f658b = MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt((Object) null);
                this.f657a = MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException e) {
            }
        }

        public boolean isConnecting(Object obj) {
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) obj;
            if (this.f657a != null) {
                try {
                    return ((Integer) this.f657a.invoke(routeInfo, new Object[0])).intValue() == this.f658b;
                } catch (IllegalAccessException | InvocationTargetException e) {
                }
            }
            return false;
        }
    }
}
