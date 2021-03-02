package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnBufferingUpdateListenerImplementor implements IGCUserPeer, MediaPlayer.OnBufferingUpdateListener {
    public static final String __md_methods = "n_onBufferingUpdate:(Landroid/media/MediaPlayer;I)V:GetOnBufferingUpdate_Landroid_media_MediaPlayer_IHandler:Android.Media.MediaPlayer/IOnBufferingUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onBufferingUpdate(MediaPlayer mediaPlayer, int i);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnBufferingUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnBufferingUpdateListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnBufferingUpdateListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnBufferingUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnBufferingUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        n_onBufferingUpdate(mediaPlayer, i);
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
