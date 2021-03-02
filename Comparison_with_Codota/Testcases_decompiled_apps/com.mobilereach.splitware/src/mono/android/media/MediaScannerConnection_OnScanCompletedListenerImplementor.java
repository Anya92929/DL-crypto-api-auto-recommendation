package mono.android.media;

import android.media.MediaScannerConnection;
import android.net.Uri;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaScannerConnection_OnScanCompletedListenerImplementor implements IGCUserPeer, MediaScannerConnection.OnScanCompletedListener {
    public static final String __md_methods = "n_onScanCompleted:(Ljava/lang/String;Landroid/net/Uri;)V:GetOnScanCompleted_Ljava_lang_String_Landroid_net_Uri_Handler:Android.Media.MediaScannerConnection/IOnScanCompletedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScanCompleted(String str, Uri uri);

    static {
        Runtime.register("Android.Media.MediaScannerConnection+IOnScanCompletedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaScannerConnection_OnScanCompletedListenerImplementor.class, __md_methods);
    }

    public MediaScannerConnection_OnScanCompletedListenerImplementor() throws Throwable {
        if (getClass() == MediaScannerConnection_OnScanCompletedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaScannerConnection+IOnScanCompletedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        n_onScanCompleted(str, uri);
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
