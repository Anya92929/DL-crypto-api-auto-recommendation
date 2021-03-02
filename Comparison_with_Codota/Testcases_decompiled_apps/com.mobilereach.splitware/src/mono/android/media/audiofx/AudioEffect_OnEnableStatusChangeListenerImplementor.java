package mono.android.media.audiofx;

import android.media.audiofx.AudioEffect;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioEffect_OnEnableStatusChangeListenerImplementor implements IGCUserPeer, AudioEffect.OnEnableStatusChangeListener {
    public static final String __md_methods = "n_onEnableStatusChange:(Landroid/media/audiofx/AudioEffect;Z)V:GetOnEnableStatusChange_Landroid_media_audiofx_AudioEffect_ZHandler:Android.Media.Audiofx.AudioEffect/IOnEnableStatusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onEnableStatusChange(AudioEffect audioEffect, boolean z);

    static {
        Runtime.register("Android.Media.Audiofx.AudioEffect+IOnEnableStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioEffect_OnEnableStatusChangeListenerImplementor.class, __md_methods);
    }

    public AudioEffect_OnEnableStatusChangeListenerImplementor() throws Throwable {
        if (getClass() == AudioEffect_OnEnableStatusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.AudioEffect+IOnEnableStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onEnableStatusChange(AudioEffect audioEffect, boolean z) {
        n_onEnableStatusChange(audioEffect, z);
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
