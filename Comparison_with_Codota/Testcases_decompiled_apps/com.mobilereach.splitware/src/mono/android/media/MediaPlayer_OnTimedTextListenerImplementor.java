package mono.android.media;

import android.media.MediaPlayer;
import android.media.TimedText;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnTimedTextListenerImplementor implements IGCUserPeer, MediaPlayer.OnTimedTextListener {
    public static final String __md_methods = "n_onTimedText:(Landroid/media/MediaPlayer;Landroid/media/TimedText;)V:GetOnTimedText_Landroid_media_MediaPlayer_Landroid_media_TimedText_Handler:Android.Media.MediaPlayer/IOnTimedTextListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimedText(MediaPlayer mediaPlayer, TimedText timedText);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnTimedTextListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnTimedTextListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnTimedTextListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnTimedTextListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnTimedTextListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
        n_onTimedText(mediaPlayer, timedText);
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
