package mono.android.webkit;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WebIconDatabase_IconListenerImplementor implements IGCUserPeer, WebIconDatabase.IconListener {
    public static final String __md_methods = "n_onReceivedIcon:(Ljava/lang/String;Landroid/graphics/Bitmap;)V:GetOnReceivedIcon_Ljava_lang_String_Landroid_graphics_Bitmap_Handler:Android.Webkit.WebIconDatabase/IIconListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onReceivedIcon(String str, Bitmap bitmap);

    static {
        Runtime.register("Android.Webkit.WebIconDatabase+IIconListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", WebIconDatabase_IconListenerImplementor.class, __md_methods);
    }

    public WebIconDatabase_IconListenerImplementor() throws Throwable {
        if (getClass() == WebIconDatabase_IconListenerImplementor.class) {
            TypeManager.Activate("Android.Webkit.WebIconDatabase+IIconListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        n_onReceivedIcon(str, bitmap);
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
