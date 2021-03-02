package mono.android.widget;

import android.widget.SearchView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SearchView_OnSuggestionListenerImplementor implements IGCUserPeer, SearchView.OnSuggestionListener {
    public static final String __md_methods = "n_onSuggestionClick:(I)Z:GetOnSuggestionClick_IHandler:Android.Widget.SearchView/IOnSuggestionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSuggestionSelect:(I)Z:GetOnSuggestionSelect_IHandler:Android.Widget.SearchView/IOnSuggestionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onSuggestionClick(int i);

    private native boolean n_onSuggestionSelect(int i);

    static {
        Runtime.register("Android.Widget.SearchView+IOnSuggestionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SearchView_OnSuggestionListenerImplementor.class, __md_methods);
    }

    public SearchView_OnSuggestionListenerImplementor() throws Throwable {
        if (getClass() == SearchView_OnSuggestionListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.SearchView+IOnSuggestionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onSuggestionClick(int i) {
        return n_onSuggestionClick(i);
    }

    public boolean onSuggestionSelect(int i) {
        return n_onSuggestionSelect(i);
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
