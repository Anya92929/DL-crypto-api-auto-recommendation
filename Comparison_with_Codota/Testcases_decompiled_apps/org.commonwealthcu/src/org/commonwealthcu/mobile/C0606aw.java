package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RelativeLayout;
import com.vertifi.RDCGlobal;
import java.io.FileOutputStream;

/* renamed from: org.commonwealthcu.mobile.aw */
final class C0606aw extends AsyncTask {

    /* renamed from: a */
    private boolean f774a;

    /* renamed from: b */
    private int f775b;

    /* renamed from: c */
    private int f776c;

    /* renamed from: d */
    private Bitmap f777d;

    /* renamed from: e */
    private Bitmap f778e;

    /* renamed from: f */
    private /* synthetic */ C0599ap f779f;

    private C0606aw(C0599ap apVar) {
        this.f779f = apVar;
    }

    /* synthetic */ C0606aw(C0599ap apVar, byte b) {
        this(apVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Void doInBackground(Intent... intentArr) {
        int i = 1;
        try {
            this.f774a = intentArr[0].getBooleanExtra("com.Vertifi.ImageProcessing.FrontImage", true);
            if (this.f774a) {
                byte[] byteArrayExtra = intentArr[0].getByteArrayExtra("com.Vertifi.ImageProcessing.ImageColor");
                FileOutputStream openFileOutput = this.f779f.f751i.openFileOutput("front_color.jpg", 0);
                openFileOutput.write(byteArrayExtra);
                openFileOutput.close();
                byte[] byteArrayExtra2 = intentArr[0].getByteArrayExtra("com.Vertifi.ImageProcessing.ImageBW");
                FileOutputStream openFileOutput2 = this.f779f.f751i.openFileOutput("front.png", 0);
                openFileOutput2.write(byteArrayExtra2);
                openFileOutput2.close();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inSampleSize = 1;
                BitmapFactory.decodeFile(String.format("%s/%s", new Object[]{this.f779f.f751i.getFilesDir(), "front.png"}), options);
                this.f776c = options.outHeight;
                this.f775b = options.outWidth;
                RDCGlobal.mRectFront = new Rect(0, 0, this.f775b, this.f776c);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                int round = Math.round(((float) this.f775b) / (((float) RDCGlobal.mWindowWidth) * RDCGlobal.mScreenDensity));
                if (round > 0) {
                    i = round;
                }
                options.inSampleSize = i;
                this.f777d = BitmapFactory.decodeByteArray(byteArrayExtra2, 0, byteArrayExtra2.length, options);
                return null;
            }
            byte[] byteArrayExtra3 = intentArr[0].getByteArrayExtra("com.Vertifi.ImageProcessing.ImageBW");
            FileOutputStream openFileOutput3 = this.f779f.f751i.openFileOutput("back.png", 0);
            openFileOutput3.write(byteArrayExtra3);
            openFileOutput3.close();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            options2.inSampleSize = 1;
            BitmapFactory.decodeFile(String.format("%s/%s", new Object[]{this.f779f.f751i.getFilesDir(), "back.png"}), options2);
            this.f776c = options2.outHeight;
            this.f775b = options2.outWidth;
            options2.inJustDecodeBounds = false;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            int round2 = Math.round(((float) this.f775b) / (((float) RDCGlobal.mWindowWidth) * RDCGlobal.mScreenDensity));
            if (round2 > 0) {
                i = round2;
            }
            options2.inSampleSize = i;
            this.f778e = BitmapFactory.decodeByteArray(byteArrayExtra3, 0, byteArrayExtra3.length, options2);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        try {
            if (this.f774a) {
                if (this.f777d != null) {
                    this.f779f.f743a.setImageBitmap(this.f777d);
                    this.f779f.f743a.setBackgroundDrawable((Drawable) null);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f779f.f753k.getLayoutParams();
                    layoutParams.addRule(3, this.f779f.f743a.getId());
                    layoutParams.addRule(15, 0);
                    this.f779f.f753k.setLayoutParams(layoutParams);
                    try {
                        this.f778e = BitmapFactory.decodeStream(this.f779f.f751i.openFileInput("back.png"));
                        this.f779f.f744b.setImageBitmap(this.f778e);
                        this.f779f.f744b.setBackgroundDrawable((Drawable) null);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f779f.f754l.getLayoutParams();
                        layoutParams2.addRule(3, this.f779f.f744b.getId());
                        layoutParams2.addRule(15, 0);
                        this.f779f.f754l.setLayoutParams(layoutParams2);
                    } catch (Exception e) {
                    }
                }
            } else if (this.f778e != null) {
                try {
                    this.f777d = BitmapFactory.decodeStream(this.f779f.f751i.openFileInput("front.png"));
                    this.f779f.f743a.setImageBitmap(this.f777d);
                    this.f779f.f743a.setBackgroundDrawable((Drawable) null);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f779f.f753k.getLayoutParams();
                    layoutParams3.addRule(3, this.f779f.f743a.getId());
                    layoutParams3.addRule(15, 0);
                    this.f779f.f753k.setLayoutParams(layoutParams3);
                } catch (Exception e2) {
                }
                this.f779f.f744b.setImageBitmap(this.f778e);
                this.f779f.f744b.setBackgroundDrawable((Drawable) null);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f779f.f754l.getLayoutParams();
                layoutParams4.addRule(3, this.f779f.f744b.getId());
                layoutParams4.addRule(15, 0);
                this.f779f.f754l.setLayoutParams(layoutParams4);
            }
        } catch (Exception e3) {
            Log.e("VIPSample", e3.getMessage());
        }
        if (!RDCGlobal.mListErrors.isEmpty()) {
            if (this.f779f.f747e != null) {
                this.f779f.f747e.dismiss();
            }
            this.f779f.f747e = null;
            C0599ap apVar = this.f779f;
            AlertDialog.Builder builder = new AlertDialog.Builder(apVar.getActivity());
            builder.setTitle("Errors").setIcon(17301543).setCancelable(true).setItems((CharSequence[]) RDCGlobal.mListErrors.toArray(new String[0]), new C0601ar(apVar));
            builder.create().show();
            boolean unused = this.f779f.f765w = true;
            if (this.f774a) {
                this.f779f.mo5507a(this.f779f.f758p, 1, false);
                this.f779f.f745c.setTextColor(Color.rgb(255, 255, 255));
            } else {
                this.f779f.mo5507a(this.f779f.f760r, 1, false);
                this.f779f.f746d.setTextColor(Color.rgb(255, 255, 255));
            }
        } else {
            boolean unused2 = this.f779f.f765w = false;
            if (this.f774a) {
                new C0607ax(this.f779f, (byte) 0).execute(new Integer[]{0, 0});
            } else {
                this.f779f.mo5507a(this.f779f.f760r, 3, false);
                this.f779f.f746d.setTextColor(Color.rgb(255, 255, 255));
                boolean unused3 = this.f779f.f741A = true;
                if (this.f779f.f747e != null) {
                    this.f779f.f747e.dismiss();
                }
                this.f779f.f747e = null;
            }
        }
        this.f777d = null;
        this.f778e = null;
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        RDCGlobal.mListErrors.clear();
        this.f779f.f747e = ProgressDialog.show(this.f779f.f751i, "", "Processing. Please wait...", true);
    }
}
