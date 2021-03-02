package mono.android.database.sqlite;

import android.database.sqlite.SQLiteTransactionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SQLiteTransactionListenerImplementor implements IGCUserPeer, SQLiteTransactionListener {
    public static final String __md_methods = "n_onBegin:()V:GetOnBeginHandler:Android.Database.Sqlite.ISQLiteTransactionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onCommit:()V:GetOnCommitHandler:Android.Database.Sqlite.ISQLiteTransactionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onRollback:()V:GetOnRollbackHandler:Android.Database.Sqlite.ISQLiteTransactionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onBegin();

    private native void n_onCommit();

    private native void n_onRollback();

    static {
        Runtime.register("Android.Database.Sqlite.ISQLiteTransactionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SQLiteTransactionListenerImplementor.class, __md_methods);
    }

    public SQLiteTransactionListenerImplementor() throws Throwable {
        if (getClass() == SQLiteTransactionListenerImplementor.class) {
            TypeManager.Activate("Android.Database.Sqlite.ISQLiteTransactionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onBegin() {
        n_onBegin();
    }

    public void onCommit() {
        n_onCommit();
    }

    public void onRollback() {
        n_onRollback();
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
