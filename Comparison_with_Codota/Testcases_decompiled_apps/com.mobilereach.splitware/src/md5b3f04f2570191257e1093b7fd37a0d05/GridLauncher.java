package md5b3f04f2570191257e1093b7fd37a0d05;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GridLauncher extends BaseLauncher implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Launcher.GridLauncher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", GridLauncher.class, __md_methods);
    }

    public GridLauncher(Context context) throws Throwable {
        super(context);
        if (getClass() == GridLauncher.class) {
            TypeManager.Activate("Launcher.GridLauncher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public GridLauncher(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == GridLauncher.class) {
            TypeManager.Activate("Launcher.GridLauncher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public GridLauncher(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == GridLauncher.class) {
            TypeManager.Activate("Launcher.GridLauncher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
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
