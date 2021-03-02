package com.p004a.p005a.p007b;

import android.os.AsyncTask;

/* renamed from: com.a.a.b.b */
public class C0345b extends AsyncTask<Void, Void, Exception> {

    /* renamed from: a */
    C0344a f3360a = null;

    /* renamed from: b */
    boolean f3361b;

    protected C0345b(C0344a aVar) {
        this.f3360a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Exception doInBackground(Void... voidArr) {
        try {
            this.f3361b = this.f3360a.mo6274b();
            return null;
        } catch (Exception e) {
            return e;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Exception exc) {
        this.f3360a.f3353b.set(this.f3361b);
        this.f3360a.mo6272a(false);
        if (exc == null) {
            this.f3360a.mo6275c();
        } else {
            this.f3360a.f3353b.set(this.f3360a.mo6273a(this.f3360a.f3352a, exc));
        }
        this.f3360a.mo6277e();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.f3360a.mo6272a(true);
    }
}
