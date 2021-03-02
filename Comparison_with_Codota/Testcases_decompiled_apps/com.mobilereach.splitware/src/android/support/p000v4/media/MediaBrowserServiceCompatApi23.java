package android.support.p000v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.support.p000v4.media.MediaBrowserServiceCompatApi21;
import android.util.Log;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompatApi23 */
class MediaBrowserServiceCompatApi23 extends MediaBrowserServiceCompatApi21 {
    private static final String TAG = "MediaBrowserServiceCompatApi21";

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompatApi23$ItemCallback */
    public interface ItemCallback {
        void onItemLoaded(int i, Bundle bundle, Parcel parcel);
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompatApi23$ServiceImplApi23 */
    public interface ServiceImplApi23 extends MediaBrowserServiceCompatApi21.ServiceImplApi21 {
        void getMediaItem(String str, ItemCallback itemCallback);
    }

    MediaBrowserServiceCompatApi23() {
    }

    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi23();
    }

    public static void onCreate(Object serviceObj, ServiceImplApi23 serviceImpl) {
        ((MediaBrowserServiceAdaptorApi23) serviceObj).onCreate(serviceImpl);
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23 */
    static class MediaBrowserServiceAdaptorApi23 extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21 {
        MediaBrowserServiceAdaptorApi23() {
        }

        public void onCreate(ServiceImplApi23 serviceImpl) {
            this.mBinder = new ServiceBinderProxyApi23(serviceImpl);
        }

        /* renamed from: android.support.v4.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23 */
        private static class ServiceBinderProxyApi23 extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21.ServiceBinderProxyApi21 {
            ServiceImplApi23 mServiceImpl;

            ServiceBinderProxyApi23(ServiceImplApi23 serviceImpl) {
                super(serviceImpl);
                this.mServiceImpl = serviceImpl;
            }

            public void getMediaItem(String mediaId, final ResultReceiver receiver) {
                try {
                    final String KEY_MEDIA_ITEM = (String) MediaBrowserService.class.getDeclaredField("KEY_MEDIA_ITEM").get((Object) null);
                    this.mServiceImpl.getMediaItem(mediaId, new ItemCallback() {
                        public void onItemLoaded(int resultCode, Bundle resultData, Parcel itemParcel) {
                            if (itemParcel != null) {
                                itemParcel.setDataPosition(0);
                                resultData.putParcelable(KEY_MEDIA_ITEM, (MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(itemParcel));
                                itemParcel.recycle();
                            }
                            receiver.send(resultCode, resultData);
                        }
                    });
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    Log.i(MediaBrowserServiceCompatApi23.TAG, "Failed to get KEY_MEDIA_ITEM via reflection", e);
                }
            }
        }
    }
}
