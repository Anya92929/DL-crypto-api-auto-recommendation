package mono.android.runtime;

import java.io.InputStream;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class InputStreamAdapter extends InputStream implements IGCUserPeer {
    public static final String __md_methods = "n_close:()V:GetCloseHandler\nn_read:()I:GetReadHandler\nn_read:([B)I:GetRead_arrayBHandler\nn_read:([BII)I:GetRead_arrayBIIHandler\n";
    private ArrayList refList;

    private native void n_close();

    private native int n_read();

    private native int n_read(byte[] bArr);

    private native int n_read(byte[] bArr, int i, int i2);

    static {
        Runtime.register("Android.Runtime.InputStreamAdapter, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", InputStreamAdapter.class, __md_methods);
    }

    public InputStreamAdapter() throws Throwable {
        if (getClass() == InputStreamAdapter.class) {
            TypeManager.Activate("Android.Runtime.InputStreamAdapter, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void close() {
        n_close();
    }

    public int read() {
        return n_read();
    }

    public int read(byte[] bArr) {
        return n_read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) {
        return n_read(bArr, i, i2);
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
