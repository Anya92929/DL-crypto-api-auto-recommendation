package android.support.p000v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import android.support.p000v4.media.routing.MediaRouterJellybean;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1 */
class MediaRouterJellybeanMr1 extends MediaRouterJellybean {

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$ActiveScanWorkaround */
    public final class ActiveScanWorkaround implements Runnable {

        /* renamed from: a */
        private final DisplayManager f893a;

        /* renamed from: b */
        private final Handler f894b;

        /* renamed from: c */
        private Method f895c;

        /* renamed from: d */
        private boolean f896d;

        public ActiveScanWorkaround(Context context, Handler handler) {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            this.f893a = (DisplayManager) context.getSystemService("display");
            this.f894b = handler;
            try {
                this.f895c = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public void run() {
            if (this.f896d) {
                try {
                    this.f895c.invoke(this.f893a, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
                } catch (InvocationTargetException e2) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
                }
                this.f894b.postDelayed(this, 15000);
            }
        }

        public void setActiveScanRouteTypes(int i) {
            if ((i & 2) != 0) {
                if (this.f896d) {
                    return;
                }
                if (this.f895c != null) {
                    this.f896d = true;
                    this.f894b.post(this);
                    return;
                }
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
            } else if (this.f896d) {
                this.f896d = false;
                this.f894b.removeCallbacks(this);
            }
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$Callback */
    public interface Callback extends MediaRouterJellybean.Callback {
        void onRoutePresentationDisplayChanged(Object obj);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$CallbackProxy */
    class CallbackProxy<T extends Callback> extends MediaRouterJellybean.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            ((Callback) this.f889a).onRoutePresentationDisplayChanged(routeInfo);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$IsConnectingWorkaround */
    public final class IsConnectingWorkaround {

        /* renamed from: a */
        private Method f897a;

        /* renamed from: b */
        private int f898b;

        public IsConnectingWorkaround() {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f898b = MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt((Object) null);
                this.f897a = MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException e) {
            }
        }

        public boolean isConnecting(Object obj) {
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) obj;
            if (this.f897a != null) {
                try {
                    return ((Integer) this.f897a.invoke(routeInfo, new Object[0])).intValue() == this.f898b;
                } catch (IllegalAccessException | InvocationTargetException e) {
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr1$RouteInfo */
    public final class RouteInfo {
        public static Display getPresentationDisplay(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPresentationDisplay();
        }

        public static boolean isEnabled(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isEnabled();
        }
    }

    MediaRouterJellybeanMr1() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
