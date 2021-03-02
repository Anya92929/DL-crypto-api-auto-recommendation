package android.support.p001v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p001v4.media.MediaBrowserCompat;
import android.support.p001v4.p003os.ResultReceiver;

/* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3 */
class MediaBrowserCompat$MediaBrowserImplBase$3 extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ MediaBrowserCompat.ItemCallback f560a;

    /* renamed from: b */
    final /* synthetic */ String f561b;

    /* renamed from: c */
    final /* synthetic */ MediaBrowserCompat.C0154a f562c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaBrowserCompat$MediaBrowserImplBase$3(MediaBrowserCompat.C0154a aVar, Handler handler, MediaBrowserCompat.ItemCallback itemCallback, String str) {
        super(handler);
        this.f562c = aVar;
        this.f560a = itemCallback;
        this.f561b = str;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
            this.f560a.onError(this.f561b);
            return;
        }
        Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
        if (!(parcelable instanceof MediaBrowserCompat.MediaItem)) {
            this.f560a.onError(this.f561b);
        } else {
            this.f560a.onItemLoaded((MediaBrowserCompat.MediaItem) parcelable);
        }
    }
}
