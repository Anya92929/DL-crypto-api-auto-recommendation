package mono.android.media;

import android.media.MediaRecorder;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaRecorder_OnInfoListenerImplementor implements IGCUserPeer, MediaRecorder.OnInfoListener {
    public static final String __md_methods = "n_onInfo:(Landroid/media/MediaRecorder;II)V:GetOnInfo_Landroid_media_MediaRecorder_IIHandler:Android.Media.MediaRecorder/IOnInfoListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onInfo(MediaRecorder mediaRecorder, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaRecorder+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaRecorder_OnInfoListenerImplementor.class, __md_methods);
    }

    public MediaRecorder_OnInfoListenerImplementor() throws Throwable {
        if (getClass() == MediaRecorder_OnInfoListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaRecorder+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        n_onInfo(mediaRecorder, i, i2);
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
