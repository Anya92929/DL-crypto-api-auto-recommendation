package md59d50db212e0bbf7132bbad8b3d837d51;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ZXingScannerFragment extends Fragment implements IGCUserPeer {
    public static final String __md_methods = "n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\nn_onStart:()V:GetOnStartHandler\nn_onStop:()V:GetOnStopHandler\n";
    private ArrayList refList;

    private native View n_onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    private native void n_onStart();

    private native void n_onStop();

    static {
        Runtime.register("ZXing.Mobile.ZXingScannerFragment, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", ZXingScannerFragment.class, __md_methods);
    }

    public ZXingScannerFragment() throws Throwable {
        if (getClass() == ZXingScannerFragment.class) {
            TypeManager.Activate("ZXing.Mobile.ZXingScannerFragment, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return n_onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onStart() {
        n_onStart();
    }

    public void onStop() {
        n_onStop();
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
