package mono.com.google.android.gms.security;

import android.content.Intent;
import com.google.android.gms.security.ProviderInstaller;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ProviderInstaller_ProviderInstallListenerImplementor implements IGCUserPeer, ProviderInstaller.ProviderInstallListener {
    public static final String __md_methods = "n_onProviderInstallFailed:(ILandroid/content/Intent;)V:GetOnProviderInstallFailed_ILandroid_content_Intent_Handler:Android.Gms.Security.ProviderInstaller/IProviderInstallListenerInvoker, Xamarin.GooglePlayServices.Basement\nn_onProviderInstalled:()V:GetOnProviderInstalledHandler:Android.Gms.Security.ProviderInstaller/IProviderInstallListenerInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onProviderInstallFailed(int i, Intent intent);

    private native void n_onProviderInstalled();

    static {
        Runtime.register("Android.Gms.Security.ProviderInstaller+IProviderInstallListenerImplementor, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ProviderInstaller_ProviderInstallListenerImplementor.class, __md_methods);
    }

    public ProviderInstaller_ProviderInstallListenerImplementor() throws Throwable {
        if (getClass() == ProviderInstaller_ProviderInstallListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Security.ProviderInstaller+IProviderInstallListenerImplementor, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onProviderInstallFailed(int i, Intent intent) {
        n_onProviderInstallFailed(i, intent);
    }

    public void onProviderInstalled() {
        n_onProviderInstalled();
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
