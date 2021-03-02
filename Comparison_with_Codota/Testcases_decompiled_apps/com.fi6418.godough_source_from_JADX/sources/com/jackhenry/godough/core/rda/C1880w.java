package com.jackhenry.godough.core.rda;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.jackhenry.godough.core.C1492ag;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.GoDoughApp;

/* renamed from: com.jackhenry.godough.core.rda.w */
class C1880w extends AsyncTask<String, Integer, Bitmap> {

    /* renamed from: a */
    private Activity f6771a;

    /* renamed from: b */
    private int f6772b;

    /* renamed from: c */
    private int f6773c;

    /* renamed from: d */
    private int f6774d;

    C1880w(Activity activity, int i, int i2) {
        this.f6771a = activity;
        this.f6773c = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f6774d = displayMetrics.densityDpi;
        if (i == 0) {
            this.f6772b = this.f6771a.getResources().getDimensionPixelSize(C1492ag.checkThumbHeight);
        } else if (i == 1) {
            this.f6772b = activity.getWindow().getWindowManager().getDefaultDisplay().getWidth();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        byte[] a = C1805aa.m6707a(this.f6773c, (Context) GoDoughApp.getApp());
        if (a == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(a, 0, a.length, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inDensity = this.f6774d;
        options.inScreenDensity = this.f6774d;
        options.inSampleSize = options.outHeight / this.f6772b;
        System.gc();
        return BitmapFactory.decodeByteArray(a, 0, a.length, options);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(this.f6771a.getResources(), C1493ah.ic_camera);
        }
        ((C1883z) this.f6771a).imageLoaded(bitmap, this.f6773c);
    }
}
