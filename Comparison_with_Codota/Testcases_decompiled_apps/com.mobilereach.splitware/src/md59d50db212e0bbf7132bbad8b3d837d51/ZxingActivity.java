package md59d50db212e0bbf7132bbad8b3d837d51;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.view.KeyEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ZxingActivity extends FragmentActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onResume:()V:GetOnResumeHandler\nn_onRequestPermissionsResult:(I[Ljava/lang/String;[I)V:GetOnRequestPermissionsResult_IarrayLjava_lang_String_arrayIHandler\nn_onConfigurationChanged:(Landroid/content/res/Configuration;)V:GetOnConfigurationChanged_Landroid_content_res_Configuration_Handler\nn_onKeyDown:(ILandroid/view/KeyEvent;)Z:GetOnKeyDown_ILandroid_view_KeyEvent_Handler\n";
    private ArrayList refList;

    private native void n_onConfigurationChanged(Configuration configuration);

    private native void n_onCreate(Bundle bundle);

    private native boolean n_onKeyDown(int i, KeyEvent keyEvent);

    private native void n_onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private native void n_onResume();

    static {
        Runtime.register("ZXing.Mobile.ZxingActivity, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", ZxingActivity.class, __md_methods);
    }

    public ZxingActivity() throws Throwable {
        if (getClass() == ZxingActivity.class) {
            TypeManager.Activate("ZXing.Mobile.ZxingActivity, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onResume() {
        n_onResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        n_onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onConfigurationChanged(Configuration configuration) {
        n_onConfigurationChanged(configuration);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return n_onKeyDown(i, keyEvent);
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
