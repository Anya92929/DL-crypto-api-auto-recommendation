package android.support.p000v4.media.routing;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter;
import android.media.RemoteControlClient;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.routing.MediaRouterJellybean */
class MediaRouterJellybean {
    public static final int ALL_ROUTE_TYPES = 8388611;
    public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    public static final int ROUTE_TYPE_LIVE_VIDEO = 2;
    public static final int ROUTE_TYPE_USER = 8388608;

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$Callback */
    public interface Callback {
        void onRouteAdded(Object obj);

        void onRouteChanged(Object obj);

        void onRouteGrouped(Object obj, Object obj2, int i);

        void onRouteRemoved(Object obj);

        void onRouteSelected(int i, Object obj);

        void onRouteUngrouped(Object obj, Object obj2);

        void onRouteUnselected(int i, Object obj);

        void onRouteVolumeChanged(Object obj);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$CallbackProxy */
    class CallbackProxy<T extends Callback> extends MediaRouter.Callback {

        /* renamed from: a */
        protected final T f889a;

        public CallbackProxy(T t) {
            this.f889a = t;
        }

        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteAdded(routeInfo);
        }

        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteChanged(routeInfo);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i) {
            this.f889a.onRouteGrouped(routeInfo, routeGroup, i);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteRemoved(routeInfo);
        }

        public void onRouteSelected(MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteSelected(i, routeInfo);
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
            this.f889a.onRouteUngrouped(routeInfo, routeGroup);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteUnselected(i, routeInfo);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            this.f889a.onRouteVolumeChanged(routeInfo);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$GetDefaultRouteWorkaround */
    public final class GetDefaultRouteWorkaround {

        /* renamed from: a */
        private Method f890a;

        public GetDefaultRouteWorkaround() {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f890a = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public Object getDefaultRoute(Object obj) {
            MediaRouter mediaRouter = (MediaRouter) obj;
            if (this.f890a != null) {
                try {
                    return this.f890a.invoke(mediaRouter, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException e) {
                }
            }
            return mediaRouter.getRouteAt(0);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteCategory */
    public final class RouteCategory {
        public static CharSequence getName(Object obj, Context context) {
            return ((MediaRouter.RouteCategory) obj).getName(context);
        }

        public static List getRoutes(Object obj) {
            ArrayList arrayList = new ArrayList();
            ((MediaRouter.RouteCategory) obj).getRoutes(arrayList);
            return arrayList;
        }

        public static int getSupportedTypes(Object obj) {
            return ((MediaRouter.RouteCategory) obj).getSupportedTypes();
        }

        public static boolean isGroupable(Object obj) {
            return ((MediaRouter.RouteCategory) obj).isGroupable();
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteGroup */
    public final class RouteGroup {
        public static List getGroupedRoutes(Object obj) {
            MediaRouter.RouteGroup routeGroup = (MediaRouter.RouteGroup) obj;
            int routeCount = routeGroup.getRouteCount();
            ArrayList arrayList = new ArrayList(routeCount);
            for (int i = 0; i < routeCount; i++) {
                arrayList.add(routeGroup.getRouteAt(i));
            }
            return arrayList;
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$RouteInfo */
    public final class RouteInfo {
        public static Object getCategory(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getCategory();
        }

        public static Object getGroup(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getGroup();
        }

        public static Drawable getIconDrawable(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getIconDrawable();
        }

        public static CharSequence getName(Object obj, Context context) {
            return ((MediaRouter.RouteInfo) obj).getName(context);
        }

        public static int getPlaybackStream(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackStream();
        }

        public static int getPlaybackType(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getPlaybackType();
        }

        public static CharSequence getStatus(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getStatus();
        }

        public static int getSupportedTypes(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getSupportedTypes();
        }

        public static Object getTag(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getTag();
        }

        public static int getVolume(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolume();
        }

        public static int getVolumeHandling(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeHandling();
        }

        public static int getVolumeMax(Object obj) {
            return ((MediaRouter.RouteInfo) obj).getVolumeMax();
        }

        public static boolean isGroup(Object obj) {
            return obj instanceof MediaRouter.RouteGroup;
        }

        public static void requestSetVolume(Object obj, int i) {
            ((MediaRouter.RouteInfo) obj).requestSetVolume(i);
        }

        public static void requestUpdateVolume(Object obj, int i) {
            ((MediaRouter.RouteInfo) obj).requestUpdateVolume(i);
        }

        public static void setTag(Object obj, Object obj2) {
            ((MediaRouter.RouteInfo) obj).setTag(obj2);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$SelectRouteWorkaround */
    public final class SelectRouteWorkaround {

        /* renamed from: a */
        private Method f891a;

        public SelectRouteWorkaround() {
            if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            Class<MediaRouter> cls = MediaRouter.class;
            try {
                this.f891a = cls.getMethod("selectRouteInt", new Class[]{Integer.TYPE, MediaRouter.RouteInfo.class});
            } catch (NoSuchMethodException e) {
            }
        }

        public void selectRoute(Object obj, int i, Object obj2) {
            MediaRouter mediaRouter = (MediaRouter) obj;
            MediaRouter.RouteInfo routeInfo = (MediaRouter.RouteInfo) obj2;
            if ((routeInfo.getSupportedTypes() & 8388608) == 0) {
                if (this.f891a != null) {
                    try {
                        this.f891a.invoke(mediaRouter, new Object[]{Integer.valueOf(i), routeInfo});
                        return;
                    } catch (IllegalAccessException e) {
                        Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e);
                    } catch (InvocationTargetException e2) {
                        Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e2);
                    }
                } else {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
                }
            }
            mediaRouter.selectRoute(i, routeInfo);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$UserRouteInfo */
    public final class UserRouteInfo {
        public static void setIconDrawable(Object obj, Drawable drawable) {
            ((MediaRouter.UserRouteInfo) obj).setIconDrawable(drawable);
        }

        public static void setName(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setName(charSequence);
        }

        public static void setPlaybackStream(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackStream(i);
        }

        public static void setPlaybackType(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setPlaybackType(i);
        }

        public static void setRemoteControlClient(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
        }

        public static void setStatus(Object obj, CharSequence charSequence) {
            ((MediaRouter.UserRouteInfo) obj).setStatus(charSequence);
        }

        public static void setVolume(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolume(i);
        }

        public static void setVolumeCallback(Object obj, Object obj2) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeCallback((MediaRouter.VolumeCallback) obj2);
        }

        public static void setVolumeHandling(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeHandling(i);
        }

        public static void setVolumeMax(Object obj, int i) {
            ((MediaRouter.UserRouteInfo) obj).setVolumeMax(i);
        }
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$VolumeCallback */
    public interface VolumeCallback {
        void onVolumeSetRequest(Object obj, int i);

        void onVolumeUpdateRequest(Object obj, int i);
    }

    /* renamed from: android.support.v4.media.routing.MediaRouterJellybean$VolumeCallbackProxy */
    class VolumeCallbackProxy<T extends VolumeCallback> extends MediaRouter.VolumeCallback {

        /* renamed from: a */
        protected final T f892a;

        public VolumeCallbackProxy(T t) {
            this.f892a = t;
        }

        public void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i) {
            this.f892a.onVolumeSetRequest(routeInfo, i);
        }

        public void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i) {
            this.f892a.onVolumeUpdateRequest(routeInfo, i);
        }
    }

    MediaRouterJellybean() {
    }

    public static void addCallback(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).addCallback(i, (MediaRouter.Callback) obj2);
    }

    public static void addUserRoute(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static Object createRouteCategory(Object obj, String str, boolean z) {
        return ((MediaRouter) obj).createRouteCategory(str, z);
    }

    public static Object createUserRoute(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((MediaRouter.RouteCategory) obj2);
    }

    public static Object createVolumeCallback(VolumeCallback volumeCallback) {
        return new VolumeCallbackProxy(volumeCallback);
    }

    public static List getCategories(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int categoryCount = mediaRouter.getCategoryCount();
        ArrayList arrayList = new ArrayList(categoryCount);
        for (int i = 0; i < categoryCount; i++) {
            arrayList.add(mediaRouter.getCategoryAt(i));
        }
        return arrayList;
    }

    public static Object getMediaRouter(Context context) {
        return context.getSystemService("media_router");
    }

    public static List getRoutes(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        for (int i = 0; i < routeCount; i++) {
            arrayList.add(mediaRouter.getRouteAt(i));
        }
        return arrayList;
    }

    public static Object getSelectedRoute(Object obj, int i) {
        return ((MediaRouter) obj).getSelectedRoute(i);
    }

    public static void removeCallback(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((MediaRouter.Callback) obj2);
    }

    public static void removeUserRoute(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((MediaRouter.UserRouteInfo) obj2);
    }

    public static void selectRoute(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).selectRoute(i, (MediaRouter.RouteInfo) obj2);
    }
}
