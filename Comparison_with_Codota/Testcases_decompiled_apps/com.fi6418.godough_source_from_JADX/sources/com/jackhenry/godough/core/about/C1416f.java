package com.jackhenry.godough.core.about;

import android.os.AsyncTask;
import com.google.android.gms.common.C0853e;

/* renamed from: com.jackhenry.godough.core.about.f */
class C1416f extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ PlayServicesDisclosuresFragment f5814a;

    private C1416f(PlayServicesDisclosuresFragment playServicesDisclosuresFragment) {
        this.f5814a = playServicesDisclosuresFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... voidArr) {
        return C0853e.m4254d(this.f5814a.getActivity());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.f5814a.f5806a.setText(str);
        this.f5814a.f5808c.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onProgressUpdate(Void... voidArr) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }
}
