package android.support.p001v4.media.routing;

import android.media.MediaRouter;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2 */
class MediaRouterJellybeanMr2 extends MediaRouterJellybeanMr1 {

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2$RouteInfo */
    public static final class RouteInfo {
        public static CharSequence getDescription(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getDescription();
        }

        public static boolean isConnecting(Object obj) {
            return ((MediaRouter.RouteInfo) obj).isConnecting();
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybeanMr2$UserRouteInfo */
    public static final class UserRouteInfo {
        public static void setDescription(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setDescription(charSequence);
        }
    }
}
