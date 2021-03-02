package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnVideoSizeChangedListenerImplementor implements IGCUserPeer, MediaPlayer.OnVideoSizeChangedListener {
    public static final String __md_methods = "n_onVideoSizeChanged:(Landroid/media/MediaPlayer;II)V:GetOnVideoSizeChanged_Landroid_media_MediaPlayer_IIHandler:Android.Media.MediaPlayer/IOnVideoSizeChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnVideoSizeChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnVideoSizeChangedListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnVideoSizeChangedListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnVideoSizeChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnVideoSizeChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        n_onVideoSizeChanged(mediaPlayer, i, i2);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
