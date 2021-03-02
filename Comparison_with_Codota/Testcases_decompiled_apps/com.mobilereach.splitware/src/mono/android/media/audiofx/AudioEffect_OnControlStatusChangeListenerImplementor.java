package mono.android.media.audiofx;

import android.media.audiofx.AudioEffect;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioEffect_OnControlStatusChangeListenerImplementor implements IGCUserPeer, AudioEffect.OnControlStatusChangeListener {
    public static final String __md_methods = "n_onControlStatusChange:(Landroid/media/audiofx/AudioEffect;Z)V:GetOnControlStatusChange_Landroid_media_audiofx_AudioEffect_ZHandler:Android.Media.Audiofx.AudioEffect/IOnControlStatusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onControlStatusChange(AudioEffect audioEffect, boolean z);

    static {
        Runtime.register("Android.Media.Audiofx.AudioEffect+IOnControlStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioEffect_OnControlStatusChangeListenerImplementor.class, __md_methods);
    }

    public AudioEffect_OnControlStatusChangeListenerImplementor() throws Throwable {
        if (getClass() == AudioEffect_OnControlStatusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.AudioEffect+IOnControlStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onControlStatusChange(AudioEffect audioEffect, boolean z) {
        n_onControlStatusChange(audioEffect, z);
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
