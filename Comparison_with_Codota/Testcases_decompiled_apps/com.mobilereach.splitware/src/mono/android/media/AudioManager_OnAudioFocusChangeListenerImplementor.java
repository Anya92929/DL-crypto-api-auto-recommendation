package mono.android.media;

import android.media.AudioManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioManager_OnAudioFocusChangeListenerImplementor implements IGCUserPeer, AudioManager.OnAudioFocusChangeListener {
    public static final String __md_methods = "n_onAudioFocusChange:(I)V:GetOnAudioFocusChange_IHandler:Android.Media.AudioManager/IOnAudioFocusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAudioFocusChange(int i);

    static {
        Runtime.register("Android.Media.AudioManager+IOnAudioFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioManager_OnAudioFocusChangeListenerImplementor.class, __md_methods);
    }

    public AudioManager_OnAudioFocusChangeListenerImplementor() throws Throwable {
        if (getClass() == AudioManager_OnAudioFocusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.AudioManager+IOnAudioFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAudioFocusChange(int i) {
        n_onAudioFocusChange(i);
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
