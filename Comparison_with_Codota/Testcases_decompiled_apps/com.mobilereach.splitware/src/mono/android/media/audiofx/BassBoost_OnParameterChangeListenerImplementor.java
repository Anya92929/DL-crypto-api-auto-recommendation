package mono.android.media.audiofx;

import android.media.audiofx.BassBoost;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class BassBoost_OnParameterChangeListenerImplementor implements IGCUserPeer, BassBoost.OnParameterChangeListener {
    public static final String __md_methods = "n_onParameterChange:(Landroid/media/audiofx/BassBoost;IIS)V:GetOnParameterChange_Landroid_media_audiofx_BassBoost_IISHandler:Android.Media.Audiofx.BassBoost/IOnParameterChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onParameterChange(BassBoost bassBoost, int i, int i2, short s);

    static {
        Runtime.register("Android.Media.Audiofx.BassBoost+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", BassBoost_OnParameterChangeListenerImplementor.class, __md_methods);
    }

    public BassBoost_OnParameterChangeListenerImplementor() throws Throwable {
        if (getClass() == BassBoost_OnParameterChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.BassBoost+IOnParameterChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onParameterChange(BassBoost bassBoost, int i, int i2, short s) {
        n_onParameterChange(bassBoost, i, i2, s);
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
