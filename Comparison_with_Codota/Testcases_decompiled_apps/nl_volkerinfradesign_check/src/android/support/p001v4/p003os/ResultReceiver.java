package android.support.p001v4.p003os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p001v4.p003os.IResultReceiver;

/* renamed from: android.support.v4.os.ResultReceiver */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: a */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };

    /* renamed from: d */
    final boolean f773d;

    /* renamed from: e */
    final Handler f774e;

    /* renamed from: f */
    IResultReceiver f775f;

    /* renamed from: android.support.v4.os.ResultReceiver$b */
    class C0229b implements Runnable {

        /* renamed from: a */
        final int f777a;

        /* renamed from: b */
        final Bundle f778b;

        C0229b(int i, Bundle bundle) {
            this.f777a = i;
            this.f778b = bundle;
        }

        public void run() {
            ResultReceiver.this.onReceiveResult(this.f777a, this.f778b);
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$a */
    class C0228a extends IResultReceiver.Stub {
        C0228a() {
        }

        public void send(int i, Bundle bundle) {
            if (ResultReceiver.this.f774e != null) {
                ResultReceiver.this.f774e.post(new C0229b(i, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    public ResultReceiver(Handler handler) {
        this.f773d = true;
        this.f774e = handler;
    }

    public void send(int i, Bundle bundle) {
        if (this.f773d) {
            if (this.f774e != null) {
                this.f774e.post(new C0229b(i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else if (this.f775f != null) {
            try {
                this.f775f.send(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f775f == null) {
                this.f775f = new C0228a();
            }
            parcel.writeStrongBinder(this.f775f.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f773d = false;
        this.f774e = null;
        this.f775f = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
}
