package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnSeekCompleteListenerImplementor implements IGCUserPeer, MediaPlayer.OnSeekCompleteListener {
    public static final String __md_methods = "n_onSeekComplete:(Landroid/media/MediaPlayer;)V:GetOnSeekComplete_Landroid_media_MediaPlayer_Handler:Android.Media.MediaPlayer/IOnSeekCompleteListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSeekComplete(MediaPlayer mediaPlayer);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnSeekCompleteListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnSeekCompleteListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnSeekCompleteListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnSeekCompleteListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnSeekCompleteListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        n_onSeekComplete(mediaPlayer);
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
