package android.support.p000v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.p000v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.content.Loader */
public class Loader<D> {

    /* renamed from: n */
    int f739n;

    /* renamed from: o */
    OnLoadCompleteListener<D> f740o;

    /* renamed from: p */
    OnLoadCanceledListener<D> f741p;

    /* renamed from: q */
    Context f742q;

    /* renamed from: r */
    boolean f743r = false;

    /* renamed from: s */
    boolean f744s = false;

    /* renamed from: t */
    boolean f745t = true;

    /* renamed from: u */
    boolean f746u = false;

    /* renamed from: v */
    boolean f747v = false;

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

    /* renamed from: android.support.v4.content.Loader$OnLoadCanceledListener */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    /* renamed from: android.support.v4.content.Loader$OnLoadCompleteListener */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d);
    }

    public Loader(Context context) {
        this.f742q = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1134a() {
    }

    public void abandon() {
        this.f744s = true;
        mo1194h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1137b() {
        return false;
    }

    public boolean cancelLoad() {
        return mo1137b();
    }

    public void commitContentChanged() {
        this.f747v = false;
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        if (this.f741p != null) {
            this.f741p.onLoadCanceled(this);
        }
    }

    public void deliverResult(D d) {
        if (this.f740o != null) {
            this.f740o.onLoadComplete(this, d);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f739n);
        printWriter.print(" mListener=");
        printWriter.println(this.f740o);
        if (this.f743r || this.f746u || this.f747v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f743r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f746u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f747v);
        }
        if (this.f744s || this.f745t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f744s);
            printWriter.print(" mReset=");
            printWriter.println(this.f745t);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1158e() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo1159f() {
    }

    public void forceLoad() {
        mo1134a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1160g() {
    }

    public Context getContext() {
        return this.f742q;
    }

    public int getId() {
        return this.f739n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo1194h() {
    }

    public boolean isAbandoned() {
        return this.f744s;
    }

    public boolean isReset() {
        return this.f745t;
    }

    public boolean isStarted() {
        return this.f743r;
    }

    public void onContentChanged() {
        if (this.f743r) {
            forceLoad();
        } else {
            this.f746u = true;
        }
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f740o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f740o = onLoadCompleteListener;
        this.f739n = i;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f741p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f741p = onLoadCanceledListener;
    }

    public void reset() {
        mo1160g();
        this.f745t = true;
        this.f743r = false;
        this.f744s = false;
        this.f746u = false;
        this.f747v = false;
    }

    public void rollbackContentChanged() {
        if (this.f747v) {
            this.f746u = true;
        }
    }

    public final void startLoading() {
        this.f743r = true;
        this.f745t = false;
        this.f744s = false;
        mo1158e();
    }

    public void stopLoading() {
        this.f743r = false;
        mo1159f();
    }

    public boolean takeContentChanged() {
        boolean z = this.f746u;
        this.f746u = false;
        this.f747v |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.f739n);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f740o == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f740o != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f740o = null;
        }
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f741p == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f741p != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f741p = null;
        }
    }
}
