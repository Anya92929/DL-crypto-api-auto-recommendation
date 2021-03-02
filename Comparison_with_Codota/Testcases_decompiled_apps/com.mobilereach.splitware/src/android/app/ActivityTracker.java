package android.app;

import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActivityTracker implements IGCUserPeer, Application.ActivityLifecycleCallbacks {
    public static final String __md_methods = "n_onActivityCreated:(Landroid/app/Activity;Landroid/os/Bundle;)V:GetOnActivityCreated_Landroid_app_Activity_Landroid_os_Bundle_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivityDestroyed:(Landroid/app/Activity;)V:GetOnActivityDestroyed_Landroid_app_Activity_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivityPaused:(Landroid/app/Activity;)V:GetOnActivityPaused_Landroid_app_Activity_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivityResumed:(Landroid/app/Activity;)V:GetOnActivityResumed_Landroid_app_Activity_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivitySaveInstanceState:(Landroid/app/Activity;Landroid/os/Bundle;)V:GetOnActivitySaveInstanceState_Landroid_app_Activity_Landroid_os_Bundle_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivityStarted:(Landroid/app/Activity;)V:GetOnActivityStarted_Landroid_app_Activity_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActivityStopped:(Landroid/app/Activity;)V:GetOnActivityStopped_Landroid_app_Activity_Handler:Android.App.Application/IActivityLifecycleCallbacksInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onActivityCreated(Activity activity, Bundle bundle);

    private native void n_onActivityDestroyed(Activity activity);

    private native void n_onActivityPaused(Activity activity);

    private native void n_onActivityResumed(Activity activity);

    private native void n_onActivitySaveInstanceState(Activity activity, Bundle bundle);

    private native void n_onActivityStarted(Activity activity);

    private native void n_onActivityStopped(Activity activity);

    static {
        Runtime.register("Android.App.ActivityTracker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ActivityTracker.class, __md_methods);
    }

    public ActivityTracker() throws Throwable {
        if (getClass() == ActivityTracker.class) {
            TypeManager.Activate("Android.App.ActivityTracker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        n_onActivityCreated(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        n_onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        n_onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        n_onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        n_onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        n_onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        n_onActivityStopped(activity);
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
