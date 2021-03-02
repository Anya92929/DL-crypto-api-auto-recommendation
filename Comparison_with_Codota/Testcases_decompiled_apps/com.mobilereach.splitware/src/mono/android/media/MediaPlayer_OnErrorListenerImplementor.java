package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnErrorListenerImplementor implements IGCUserPeer, MediaPlayer.OnErrorListener {
    public static final String __md_methods = "n_onError:(Landroid/media/MediaPlayer;II)Z:GetOnError_Landroid_media_MediaPlayer_IIHandler:Android.Media.MediaPlayer/IOnErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onError(MediaPlayer mediaPlayer, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnErrorListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnErrorListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnErrorListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return n_onError(mediaPlayer, i, i2);
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
