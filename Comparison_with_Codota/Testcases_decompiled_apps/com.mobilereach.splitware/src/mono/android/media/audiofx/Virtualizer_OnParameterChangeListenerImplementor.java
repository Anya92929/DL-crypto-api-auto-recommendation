package mono.android.media.audiofx;

import android.media.audiofx.Virtualizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Virtualizer_OnParameterChangeListenerImplementor implements IGCUserPeer, Virtualizer.OnParameterChangeListener {
    public static final String __md_methods = "n_onParameterChange:(Landroid/media/audiofx/Virtualizer;IIS)V:GetOnParameterChange_Landroid_media_audiofx_Virtualizer_IISHandler:Android.Media.Audiofx.Virtualizer/IOnParameterChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onParameterChange(Virtualizer virtualizer, int i, int i2, short s);

    static {
        Runtime.register("Android.Media.Audiofx.Virtualizer+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Virtualizer_OnParameterChangeListenerImplementor.class, __md_methods);
    }

    public Virtualizer_OnParameterChangeListenerImplementor() throws Throwable {
        if (getClass() == Virtualizer_OnParameterChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.Virtualizer+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onParameterChange(Virtualizer virtualizer, int i, int i2, short s) {
        n_onParameterChange(virtualizer, i, i2, s);
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
