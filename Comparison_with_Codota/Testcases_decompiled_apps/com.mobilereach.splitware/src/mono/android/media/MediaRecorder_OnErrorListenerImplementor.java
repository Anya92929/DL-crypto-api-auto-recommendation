package mono.android.media;

import android.media.MediaRecorder;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaRecorder_OnErrorListenerImplementor implements IGCUserPeer, MediaRecorder.OnErrorListener {
    public static final String __md_methods = "n_onError:(Landroid/media/MediaRecorder;II)V:GetOnError_Landroid_media_MediaRecorder_IIHandler:Android.Media.MediaRecorder/IOnErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onError(MediaRecorder mediaRecorder, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaRecorder+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaRecorder_OnErrorListenerImplementor.class, __md_methods);
    }

    public MediaRecorder_OnErrorListenerImplementor() throws Throwable {
        if (getClass() == MediaRecorder_OnErrorListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaRecorder+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        n_onError(mediaRecorder, i, i2);
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
