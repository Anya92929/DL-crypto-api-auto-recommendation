package com.p004a.p005a.p007b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.p004a.p005a.p006a.C0342a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.a.a.b.a */
public abstract class C0344a extends C0342a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f3352a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AtomicBoolean f3353b = new AtomicBoolean(true);

    /* renamed from: c */
    private Context f3354c;

    /* renamed from: d */
    private int f3355d = -1;

    /* renamed from: e */
    private int f3356e = -1;

    /* renamed from: f */
    private boolean f3357f = false;

    /* renamed from: g */
    private boolean f3358g = true;

    /* renamed from: h */
    private boolean f3359h = true;

    public C0344a(Context context, ListAdapter listAdapter, int i, int i2, boolean z) {
        super(listAdapter);
        this.f3354c = context;
        this.f3356e = i2;
        this.f3355d = i;
        this.f3353b.set(z);
    }

    @TargetApi(11)
    /* renamed from: a */
    private <T> void m2461a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        if (this.f3357f || Build.VERSION.SDK_INT < 11) {
            asyncTask.execute(tArr);
        } else {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo6271a(ViewGroup viewGroup, int i) {
        if (this.f3354c != null) {
            return ((LayoutInflater) this.f3354c.getSystemService("layout_inflater")).inflate(i, viewGroup, false);
        }
        throw new RuntimeException("You must either override getPendingView() or supply a pending View resource via the constructor");
    }

    /* renamed from: a */
    public void mo6272a(boolean z) {
        this.f3359h = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6273a(View view, Exception exc) {
        Log.e("EndlessAdapter", "Exception in cacheInBackground()", exc);
        return false;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo6274b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo6275c();

    /* renamed from: d */
    public void mo6276d() {
        this.f3353b.set(true);
    }

    /* renamed from: e */
    public void mo6277e() {
        this.f3352a = null;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C0345b mo6278f() {
        return new C0345b(this);
    }

    /* renamed from: g */
    public boolean mo6279g() {
        return this.f3359h;
    }

    public int getCount() {
        return this.f3353b.get() ? super.getCount() + 1 : super.getCount();
    }

    public Object getItem(int i) {
        if (i >= super.getCount()) {
            return null;
        }
        return super.getItem(i);
    }

    public int getItemViewType(int i) {
        if (i == mo6260a().getCount()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i != super.getCount() || !this.f3353b.get()) {
            return super.getView(i, view, viewGroup);
        }
        int count = super.getCount();
        if (this.f3352a == null) {
            this.f3352a = mo6271a(viewGroup, count == 0 ? this.f3355d : this.f3356e);
            if (this.f3358g) {
                m2461a(mo6278f(), (T[]) new Void[0]);
            } else {
                try {
                    this.f3353b.set(mo6274b());
                } catch (Exception e) {
                    this.f3353b.set(mo6273a(this.f3352a, e));
                }
            }
        }
        return this.f3352a;
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public boolean isEnabled(int i) {
        if (i >= super.getCount()) {
            return false;
        }
        return super.isEnabled(i);
    }
}
