package mono.android.media;

import android.media.AudioTrack;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioTrack_OnPlaybackPositionUpdateListenerImplementor implements IGCUserPeer, AudioTrack.OnPlaybackPositionUpdateListener {
    public static final String __md_methods = "n_onMarkerReached:(Landroid/media/AudioTrack;)V:GetOnMarkerReached_Landroid_media_AudioTrack_Handler:Android.Media.AudioTrack/IOnPlaybackPositionUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onPeriodicNotification:(Landroid/media/AudioTrack;)V:GetOnPeriodicNotification_Landroid_media_AudioTrack_Handler:Android.Media.AudioTrack/IOnPlaybackPositionUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onMarkerReached(AudioTrack audioTrack);

    private native void n_onPeriodicNotification(AudioTrack audioTrack);

    static {
        Runtime.register("Android.Media.AudioTrack+IOnPlaybackPositionUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioTrack_OnPlaybackPositionUpdateListenerImplementor.class, __md_methods);
    }

    public AudioTrack_OnPlaybackPositionUpdateListenerImplementor() throws Throwable {
        if (getClass() == AudioTrack_OnPlaybackPositionUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.AudioTrack+IOnPlaybackPositionUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onMarkerReached(AudioTrack audioTrack) {
        n_onMarkerReached(audioTrack);
    }

    public void onPeriodicNotification(AudioTrack audioTrack) {
        n_onPeriodicNotification(audioTrack);
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
