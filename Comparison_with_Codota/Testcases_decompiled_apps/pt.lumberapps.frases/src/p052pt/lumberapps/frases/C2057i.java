package p052pt.lumberapps.frases;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.p021v7.p022a.C0433ag;
import android.widget.RelativeLayout;
import com.google.android.gms.C1204R;
import java.io.File;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0000a;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0002c;
import p000a.p001a.p002a.p003a.p004a.p005a.p006a.C0004e;

/* renamed from: pt.lumberapps.frases.i */
public class C2057i extends C0433ag {

    /* renamed from: a */
    String f7747a;

    /* renamed from: b */
    Bitmap f7748b;

    /* renamed from: c */
    C0002c f7749c;

    /* renamed from: d */
    private Runnable f7750d = new C2058j(this);

    /* renamed from: e */
    private Runnable f7751e = new C2059k(this);

    /* renamed from: a */
    public void mo10212a(String str) {
        runOnUiThread(new C2060l(this, str));
    }

    @SuppressLint({"ResourceAsColor"})
    /* renamed from: b */
    public void mo10213b(String str) {
        if (this.f7749c == null) {
            this.f7749c = new C0004e().mo17e((int) C1204R.color.White).mo14b((int) C1204R.color.laranja_bts).mo12a();
        }
        C0000a.m0a(this, str, this.f7749c).mo1b();
    }

    /* renamed from: c */
    public void mo10214c(String str) {
        mo10212a(str);
    }

    /* renamed from: f */
    public void mo10215f() {
        mo10212a(this.f7747a);
    }

    /* renamed from: g */
    public void mo10216g() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1204R.C1205id.rela_frase);
        relativeLayout.setDrawingCacheEnabled(true);
        this.f7748b = Bitmap.createBitmap(relativeLayout.getDrawingCache());
        relativeLayout.setDrawingCacheEnabled(false);
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/LumberApps");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f7747a = file.getPath() + "/temp_black_white.jpg";
        new Thread(this.f7751e).start();
        mo10215f();
    }

    /* renamed from: h */
    public void mo10217h() {
        runOnUiThread(this.f7750d);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C0000a.m1a();
        super.onDestroy();
    }
}
