package opentk_1_0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public abstract class GameViewBase extends SurfaceView implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("OpenTK.GameViewBase, OpenTK-1.0, Version=1.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", GameViewBase.class, __md_methods);
    }

    public GameViewBase(Context context) throws Throwable {
        super(context);
        if (getClass() == GameViewBase.class) {
            TypeManager.Activate("OpenTK.GameViewBase, OpenTK-1.0, Version=1.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public GameViewBase(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == GameViewBase.class) {
            TypeManager.Activate("OpenTK.GameViewBase, OpenTK-1.0, Version=1.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public GameViewBase(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == GameViewBase.class) {
            TypeManager.Activate("OpenTK.GameViewBase, OpenTK-1.0, Version=1.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
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
