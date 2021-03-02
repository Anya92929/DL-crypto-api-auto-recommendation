package mono.android.media;

import android.media.MediaPlayer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnInfoListenerImplementor implements IGCUserPeer, MediaPlayer.OnInfoListener {
    public static final String __md_methods = "n_onInfo:(Landroid/media/MediaPlayer;II)Z:GetOnInfo_Landroid_media_MediaPlayer_IIHandler:Android.Media.MediaPlayer/IOnInfoListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onInfo(MediaPlayer mediaPlayer, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnInfoListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnInfoListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnInfoListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return n_onInfo(mediaPlayer, i, i2);
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
