package md5f41bed51fcdeb5fc08f864fdf7ea78e1;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.TabPage;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class LoginDialog_LoginPage extends TabPage implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Preference.LoginDialog+LoginPage, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", LoginDialog_LoginPage.class, __md_methods);
    }

    public LoginDialog_LoginPage(Context context) throws Throwable {
        super(context);
        if (getClass() == LoginDialog_LoginPage.class) {
            TypeManager.Activate("Preference.LoginDialog+LoginPage, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public LoginDialog_LoginPage(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == LoginDialog_LoginPage.class) {
            TypeManager.Activate("Preference.LoginDialog+LoginPage, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public LoginDialog_LoginPage(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == LoginDialog_LoginPage.class) {
            TypeManager.Activate("Preference.LoginDialog+LoginPage, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
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
