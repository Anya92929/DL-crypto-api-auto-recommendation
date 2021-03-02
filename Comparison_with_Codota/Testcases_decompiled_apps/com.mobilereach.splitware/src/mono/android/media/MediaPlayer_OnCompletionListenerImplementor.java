package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnCompletionListenerImplementor implements IGCUserPeer, MediaPlayer.OnCompletionListener {
    public static final String __md_methods = "n_onCompletion:(Landroid/media/MediaPlayer;)V:GetOnCompletion_Landroid_media_MediaPlayer_Handler:Android.Media.MediaPlayer/IOnCompletionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onCompletion(MediaPlayer mediaPlayer);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnCompletionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnCompletionListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnCompletionListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnCompletionListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnCompletionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        n_onCompletion(mediaPlayer);
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
