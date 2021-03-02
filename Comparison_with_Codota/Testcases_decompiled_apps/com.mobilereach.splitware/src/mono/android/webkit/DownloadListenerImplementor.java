package mono.android.webkit;

import android.webkit.DownloadListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DownloadListenerImplementor implements IGCUserPeer, DownloadListener {
    public static final String __md_methods = "n_onDownloadStart:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V:GetOnDownloadStart_Ljava_lang_String_Ljava_lang_String_Ljava_lang_String_Ljava_lang_String_JHandler:Android.Webkit.IDownloadListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDownloadStart(String str, String str2, String str3, String str4, long j);

    static {
        Runtime.register("Android.Webkit.IDownloadListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DownloadListenerImplementor.class, __md_methods);
    }

    public DownloadListenerImplementor() throws Throwable {
        if (getClass() == DownloadListenerImplementor.class) {
            TypeManager.Activate("Android.Webkit.IDownloadListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        n_onDownloadStart(str, str2, str3, str4, j);
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
