package mono.android.runtime;

import java.io.OutputStream;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class OutputStreamAdapter extends OutputStream implements IGCUserPeer {
    public static final String __md_methods = "n_close:()V:GetCloseHandler\nn_flush:()V:GetFlushHandler\nn_write:([B)V:GetWrite_arrayBHandler\nn_write:([BII)V:GetWrite_arrayBIIHandler\nn_write:(I)V:GetWrite_IHandler\n";
    private ArrayList refList;

    private native void n_close();

    private native void n_flush();

    private native void n_write(int i);

    private native void n_write(byte[] bArr);

    private native void n_write(byte[] bArr, int i, int i2);

    static {
        Runtime.register("Android.Runtime.OutputStreamAdapter, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", OutputStreamAdapter.class, __md_methods);
    }

    public OutputStreamAdapter() throws Throwable {
        if (getClass() == OutputStreamAdapter.class) {
            TypeManager.Activate("Android.Runtime.OutputStreamAdapter, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void close() {
        n_close();
    }

    public void flush() {
        n_flush();
    }

    public void write(byte[] bArr) {
        n_write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        n_write(bArr, i, i2);
    }

    public void write(int i) {
        n_write(i);
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
