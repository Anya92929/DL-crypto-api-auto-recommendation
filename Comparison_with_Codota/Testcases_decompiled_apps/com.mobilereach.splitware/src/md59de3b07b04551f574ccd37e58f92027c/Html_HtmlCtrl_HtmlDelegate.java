package md59de3b07b04551f574ccd37e58f92027c;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Html_HtmlCtrl_HtmlDelegate extends WebViewClient implements IGCUserPeer {
    public static final String __md_methods = "n_shouldOverrideUrlLoading:(Landroid/webkit/WebView;Ljava/lang/String;)Z:GetShouldOverrideUrlLoading_Landroid_webkit_WebView_Ljava_lang_String_Handler\nn_onReceivedError:(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V:GetOnReceivedError_Landroid_webkit_WebView_ILjava_lang_String_Ljava_lang_String_Handler\n";
    private ArrayList refList;

    private native void n_onReceivedError(WebView webView, int i, String str, String str2);

    private native boolean n_shouldOverrideUrlLoading(WebView webView, String str);

    static {
        Runtime.register("Controls.Html+HtmlCtrl+HtmlDelegate, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Html_HtmlCtrl_HtmlDelegate.class, __md_methods);
    }

    public Html_HtmlCtrl_HtmlDelegate() throws Throwable {
        if (getClass() == Html_HtmlCtrl_HtmlDelegate.class) {
            TypeManager.Activate("Controls.Html+HtmlCtrl+HtmlDelegate, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public Html_HtmlCtrl_HtmlDelegate(Html_HtmlCtrl html_HtmlCtrl) throws Throwable {
        if (getClass() == Html_HtmlCtrl_HtmlDelegate.class) {
            TypeManager.Activate("Controls.Html+HtmlCtrl+HtmlDelegate, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Controls.Html+HtmlCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{html_HtmlCtrl});
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n_shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        n_onReceivedError(webView, i, str, str2);
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
