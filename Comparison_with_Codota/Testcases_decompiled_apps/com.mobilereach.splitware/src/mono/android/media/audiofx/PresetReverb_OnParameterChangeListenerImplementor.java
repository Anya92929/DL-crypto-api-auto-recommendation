package mono.android.media.audiofx;

import android.media.audiofx.PresetReverb;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PresetReverb_OnParameterChangeListenerImplementor implements IGCUserPeer, PresetReverb.OnParameterChangeListener {
    public static final String __md_methods = "n_onParameterChange:(Landroid/media/audiofx/PresetReverb;IIS)V:GetOnParameterChange_Landroid_media_audiofx_PresetReverb_IISHandler:Android.Media.Audiofx.PresetReverb/IOnParameterChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onParameterChange(PresetReverb presetReverb, int i, int i2, short s);

    static {
        Runtime.register("Android.Media.Audiofx.PresetReverb+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", PresetReverb_OnParameterChangeListenerImplementor.class, __md_methods);
    }

    public PresetReverb_OnParameterChangeListenerImplementor() throws Throwable {
        if (getClass() == PresetReverb_OnParameterChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.PresetReverb+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onParameterChange(PresetReverb presetReverb, int i, int i2, short s) {
        n_onParameterChange(presetReverb, i, i2, s);
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
