package android.support.p001v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.p001v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.content.Loader */
public class Loader<D> {

    /* renamed from: n */
    int f445n;

    /* renamed from: o */
    OnLoadCompleteListener<D> f446o;

    /* renamed from: p */
    OnLoadCanceledListener<D> f447p;

    /* renamed from: q */
    Context f448q;

    /* renamed from: r */
    boolean f449r = false;

    /* renamed from: s */
    boolean f450s = false;

    /* renamed from: t */
    boolean f451t = true;

    /* renamed from: u */
    boolean f452u = false;

    /* renamed from: v */
    boolean f453v = false;

    /* renamed from: android.support.v4.content.Loader$OnLoadCanceledListener */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    /* renamed from: android.support.v4.content.Loader$OnLoadCompleteListener */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d);
    }

    /* renamed from: android.support.v4.content.Loader$ForceLoadContentObserver */
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    public Loader(Context context) {
        this.f448q = context.getApplicationContext();
    }

    public void deliverResult(D d) {
        if (this.f446o != null) {
            this.f446o.onLoadComplete(this, d);
        }
    }

    public void deliverCancellation() {
        if (this.f447p != null) {
            this.f447p.onLoadCanceled(this);
        }
    }

    public Context getContext() {
        return this.f448q;
    }

    public int getId() {
        return this.f445n;
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f446o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f446o = onLoadCompleteListener;
        this.f445n = i;
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f446o == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f446o != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f446o = null;
        }
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f447p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f447p = onLoadCanceledListener;
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f447p == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f447p != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f447p = null;
        }
    }

    public boolean isStarted() {
        return this.f449r;
    }

    public boolean isAbandoned() {
        return this.f450s;
    }

    public boolean isReset() {
        return this.f451t;
    }

    public final void startLoading() {
        this.f449r = true;
        this.f451t = false;
        this.f450s = false;
        onStartLoading();
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        return false;
    }

    public void forceLoad() {
        onForceLoad();
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    public void stopLoading() {
        this.f449r = false;
        onStopLoading();
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public void abandon() {
        this.f450s = true;
        onAbandon();
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    public void reset() {
        onReset();
        this.f451t = true;
        this.f449r = false;
        this.f450s = false;
        this.f452u = false;
        this.f453v = false;
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    public boolean takeContentChanged() {
        boolean z = this.f452u;
        this.f452u = false;
        this.f453v |= z;
        return z;
    }

    public void commitContentChanged() {
        this.f453v = false;
    }

    public void rollbackContentChanged() {
        if (this.f453v) {
            this.f452u = true;
        }
    }

    public void onContentChanged() {
        if (this.f449r) {
            forceLoad();
        } else {
            this.f452u = true;
        }
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.f445n);
        sb.append("}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f445n);
        printWriter.print(" mListener=");
        printWriter.println(this.f446o);
        if (this.f449r || this.f452u || this.f453v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f449r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f452u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f453v);
        }
        if (this.f450s || this.f451t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f450s);
            printWriter.print(" mReset=");
            printWriter.println(this.f451t);
        }
    }
}
