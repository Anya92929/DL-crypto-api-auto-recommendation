package md529e4c2c8a026201f3a493bfa20264e47;

import android.content.Context;
import java.lang.Thread;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MrtApplication_MyUncaughtExceptionHandler implements IGCUserPeer, Thread.UncaughtExceptionHandler {
    public static final String __md_methods = "n_uncaughtException:(Ljava/lang/Thread;Ljava/lang/Throwable;)V:GetUncaughtException_Ljava_lang_Thread_Ljava_lang_Throwable_Handler:Java.Lang.Thread/IUncaughtExceptionHandlerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_uncaughtException(Thread thread, Throwable th);

    static {
        Runtime.register("UI.MrtApplication+MyUncaughtExceptionHandler, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", MrtApplication_MyUncaughtExceptionHandler.class, __md_methods);
    }

    public MrtApplication_MyUncaughtExceptionHandler() throws Throwable {
        if (getClass() == MrtApplication_MyUncaughtExceptionHandler.class) {
            TypeManager.Activate("UI.MrtApplication+MyUncaughtExceptionHandler, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public MrtApplication_MyUncaughtExceptionHandler(Context context) throws Throwable {
        if (getClass() == MrtApplication_MyUncaughtExceptionHandler.class) {
            TypeManager.Activate("UI.MrtApplication+MyUncaughtExceptionHandler, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        n_uncaughtException(thread, th);
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
