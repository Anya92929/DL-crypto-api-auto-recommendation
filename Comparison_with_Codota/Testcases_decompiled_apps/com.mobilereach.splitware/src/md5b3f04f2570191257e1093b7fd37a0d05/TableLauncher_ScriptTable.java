package md5b3f04f2570191257e1093b7fd37a0d05;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import md59de3b07b04551f574ccd37e58f92027c.Table_3;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TableLauncher_ScriptTable extends Table_3 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Launcher.TableLauncher+ScriptTable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", TableLauncher_ScriptTable.class, __md_methods);
    }

    public TableLauncher_ScriptTable(Context context) throws Throwable {
        super(context);
        if (getClass() == TableLauncher_ScriptTable.class) {
            TypeManager.Activate("Launcher.TableLauncher+ScriptTable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public TableLauncher_ScriptTable(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == TableLauncher_ScriptTable.class) {
            TypeManager.Activate("Launcher.TableLauncher+ScriptTable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public TableLauncher_ScriptTable(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == TableLauncher_ScriptTable.class) {
            TypeManager.Activate("Launcher.TableLauncher+ScriptTable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
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
