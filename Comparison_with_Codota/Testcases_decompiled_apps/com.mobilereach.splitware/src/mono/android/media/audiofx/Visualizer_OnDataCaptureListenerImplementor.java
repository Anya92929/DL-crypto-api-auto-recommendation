package mono.android.media.audiofx;

import android.media.audiofx.Visualizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Visualizer_OnDataCaptureListenerImplementor implements IGCUserPeer, Visualizer.OnDataCaptureListener {
    public static final String __md_methods = "n_onFftDataCapture:(Landroid/media/audiofx/Visualizer;[BI)V:GetOnFftDataCapture_Landroid_media_audiofx_Visualizer_arrayBIHandler:Android.Media.Audiofx.Visualizer/IOnDataCaptureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onWaveFormDataCapture:(Landroid/media/audiofx/Visualizer;[BI)V:GetOnWaveFormDataCapture_Landroid_media_audiofx_Visualizer_arrayBIHandler:Android.Media.Audiofx.Visualizer/IOnDataCaptureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFftDataCapture(Visualizer visualizer, byte[] bArr, int i);

    private native void n_onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i);

    static {
        Runtime.register("Android.Media.Audiofx.Visualizer+IOnDataCaptureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Visualizer_OnDataCaptureListenerImplementor.class, __md_methods);
    }

    public Visualizer_OnDataCaptureListenerImplementor() throws Throwable {
        if (getClass() == Visualizer_OnDataCaptureListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Audiofx.Visualizer+IOnDataCaptureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i) {
        n_onFftDataCapture(visualizer, bArr, i);
    }

    public void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i) {
        n_onWaveFormDataCapture(visualizer, bArr, i);
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
