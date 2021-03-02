package p052pt.lumberapps.frases;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.p009v4.widget.DrawerLayout;
import android.support.p021v7.p022a.C0483e;
import android.support.p021v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appbrain.C1121k;
import com.google.android.gms.C1204R;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.util.Iterator;
import p052pt.lumberapps.lumbliv.C2090k;

/* renamed from: pt.lumberapps.frases.w */
public class C2076w extends C2057i {

    /* renamed from: I */
    public static boolean f7782I = false;

    /* renamed from: T */
    public static boolean f7783T = false;

    /* renamed from: U */
    public static int f7784U = 93;

    /* renamed from: V */
    public static int f7785V = 2300;

    /* renamed from: k */
    public static int f7786k;

    /* renamed from: l */
    public static int f7787l;

    /* renamed from: m */
    public static int f7788m;

    /* renamed from: n */
    public static int f7789n;

    /* renamed from: o */
    public static int f7790o;

    /* renamed from: v */
    public static final String[] f7791v = {"#000000", "#FFFFFF"};

    /* renamed from: A */
    C2055g f7792A;

    /* renamed from: B */
    boolean f7793B = false;

    /* renamed from: C */
    C0483e f7794C;

    /* renamed from: D */
    Toolbar f7795D;

    /* renamed from: E */
    DrawerLayout f7796E;

    /* renamed from: F */
    public RelativeLayout f7797F;

    /* renamed from: G */
    public boolean f7798G = true;

    /* renamed from: H */
    public final Handler f7799H = new Handler();

    /* renamed from: J */
    public ImageButton f7800J;

    /* renamed from: K */
    public ImageButton f7801K;

    /* renamed from: L */
    public TextView f7802L;

    /* renamed from: M */
    public TextView f7803M;

    /* renamed from: N */
    public Typeface f7804N;

    /* renamed from: O */
    public AdView f7805O;

    /* renamed from: P */
    public boolean f7806P = false;

    /* renamed from: Q */
    public boolean f7807Q = false;

    /* renamed from: R */
    int f7808R = 0;

    /* renamed from: S */
    C2090k f7809S;

    /* renamed from: W */
    Runnable f7810W = new C2078y(this);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f7811d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InterstitialAd f7812e;

    /* renamed from: g */
    public C2020a f7813g;

    /* renamed from: h */
    public C2062n f7814h;

    /* renamed from: i */
    public C2061m f7815i;

    /* renamed from: j */
    public C2056h f7816j;

    /* renamed from: p */
    public Animation f7817p;

    /* renamed from: q */
    public Animation f7818q;

    /* renamed from: r */
    public Animation f7819r;

    /* renamed from: s */
    public Animation f7820s;

    /* renamed from: t */
    String[] f7821t;

    /* renamed from: u */
    protected String[] f7822u;

    /* renamed from: w */
    MenuItem f7823w;

    /* renamed from: x */
    Drawable f7824x;

    /* renamed from: y */
    Drawable f7825y;

    /* renamed from: z */
    boolean f7826z = false;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo10238a(boolean z) {
        runOnUiThread(new C2028ah(this, mo10254t() + "\nwww.Mil-Frases.com", z, mo10254t()));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void mo10239b(int i) {
        this.f7807Q = true;
        String t = mo10254t();
        switch (i) {
            case 0:
                mo10238a(false);
                new C2023ac(this, t).start();
                return;
            case 1:
                mo10243e("sms");
                return;
            case 2:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", String.valueOf(t));
                intent.setType("application/twitter");
                startActivity(intent);
                return;
            case 3:
                if (Build.VERSION.SDK_INT < 11) {
                    ((ClipboardManager) getSystemService("clipboard")).setText(String.valueOf(t));
                } else {
                    ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label", String.valueOf(t)));
                }
                mo10212a(mo10240c(C1204R.string.frase_p_a_transferencia));
                return;
            case 4:
                mo10243e("todos");
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    public String mo10240c(int i) {
        return getResources().getString(i);
    }

    /* renamed from: d */
    public boolean mo10241d(String str) {
        this.f7826z = false;
        Iterator it = this.f7792A.mo10196a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((C2038ar) it.next()).f7707b.contains(str)) {
                    this.f7826z = true;
                    break;
                }
            } else {
                break;
            }
        }
        return this.f7826z;
    }

    /* renamed from: d */
    public String[] mo10242d(int i) {
        return getResources().getStringArray(i);
    }

    /* renamed from: e */
    public void mo10243e(String str) {
        String str2 = mo10254t() + "\nwww.Mil-Frases.com";
        if (str == "todos") {
            this.f7799H.post(new C2024ad(this, str2));
        } else if (str == "sms") {
            this.f7799H.post(new C2025ae(this, str2));
        } else {
            runOnUiThread(new C2026af(this));
        }
    }

    /* renamed from: k */
    public void mo10244k() {
        this.f7796E = (DrawerLayout) findViewById(C1204R.C1205id.drawer_main_activity);
        this.f7795D = (Toolbar) findViewById(C1204R.C1205id.app_bar);
        this.f7794C = new C2077x(this, this, this.f7796E, this.f7795D, C1204R.string.empty_string, C1204R.string.empty_string);
        this.f7796E.setDrawerListener(this.f7794C);
        mo1955b().mo1914a(true);
    }

    /* renamed from: l */
    public void mo10245l() {
        this.f7792A.mo10198a(new C2038ar(this.f7802L.getText().toString(), this.f7803M.getText().toString()));
        mo10213b(mo10240c(C1204R.string.frase_add_favoritos));
        this.f7826z = true;
        mo10247n();
    }

    /* renamed from: m */
    public void mo10246m() {
        this.f7792A.mo10199b(new C2038ar(this.f7802L.getText().toString(), this.f7803M.getText().toString()));
        mo10213b(mo10240c(C1204R.string.frase_removida_favoritos));
        this.f7826z = false;
        mo10247n();
    }

    /* renamed from: n */
    public void mo10247n() {
        if (this.f7823w == null) {
            return;
        }
        if (this.f7826z) {
            this.f7823w.setIcon(this.f7824x);
        } else {
            this.f7823w.setIcon(this.f7825y);
        }
    }

    /* renamed from: o */
    public boolean mo10248o() {
        if (!this.f7796E.mo1663g(8388611)) {
            return false;
        }
        this.f7796E.mo1661f(8388611);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7794C.mo2111a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7821t = mo10242d((int) C1204R.array.opcoes);
        this.f7792A = new C2055g(this);
        C1121k.m5208a(this);
        if (new C2056h(this).mo10211f()) {
            new C2030aj(this).mo10169c();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1204R.C1206menu.activity_main, menu);
        this.f7824x = getResources().getDrawable(C1204R.drawable.star_on);
        this.f7825y = getResources().getDrawable(C1204R.drawable.star_off);
        this.f7823w = menu.findItem(C1204R.C1205id.addFavoritos);
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f7794C.mo2109a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /* renamed from: p */
    public void mo10250p() {
        C2049bb.m8326b("Interstecial chamado");
        int i = this.f7811d + 1;
        this.f7811d = i;
        if (i >= 5) {
            return;
        }
        if (this.f7812e == null || !this.f7812e.isLoaded()) {
            this.f7799H.postDelayed(this.f7810W, 5000);
        } else {
            this.f7812e.show();
        }
    }

    /* renamed from: q */
    public void mo10251q() {
        this.f7805O = (AdView) findViewById(C1204R.C1205id.adView);
        MobileAds.initialize(getApplicationContext(), getString(C1204R.string.idads));
        this.f7799H.postDelayed(this.f7810W, 100);
        this.f7799H.postDelayed(new C2022ab(this), 500);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: r */
    public void mo10252r() {
        Intent intent = getIntent();
        this.f7813g.mo10154c();
        f7788m = 0;
        if (Build.VERSION.SDK_INT >= 11) {
            recreate();
            return;
        }
        intent.addFlags(65536);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    /* renamed from: s */
    public void mo10253s() {
        String[] d = mo10242d((int) C1204R.array.linguagens);
        String[] d2 = mo10242d((int) C1204R.array.linguagens_contantes);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(C1204R.string.linguagem_summary)).setItems(d, new C2027ag(this, d2));
        builder.show();
    }

    /* renamed from: t */
    public String mo10254t() {
        return this.f7813g.mo10148a(f7788m) + " " + MApp.m8272a(this.f7813g.mo10152b(f7788m));
    }

    /* renamed from: u */
    public void mo10255u() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C1204R.C1205id.relaBotoes);
        ImageView imageView = (ImageView) findViewById(C1204R.C1205id.linesq);
        ImageView imageView2 = (ImageView) findViewById(C1204R.C1205id.lindir);
        if (!this.f7798G) {
            this.f7798G = true;
            linearLayout.setVisibility(0);
            linearLayout.startAnimation(this.f7820s);
            imageView.setVisibility(0);
            linearLayout.startAnimation(this.f7820s);
            imageView2.setVisibility(0);
            linearLayout.startAnimation(this.f7820s);
            this.f7800J.setVisibility(4);
            return;
        }
        this.f7798G = false;
        linearLayout.setVisibility(4);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        linearLayout.startAnimation(this.f7819r);
        this.f7800J.setVisibility(0);
        this.f7800J.startAnimation(this.f7820s);
    }

    /* renamed from: v */
    public void mo10256v() {
        this.f7815i = new C2061m();
        f7789n = this.f7815i.mo10221a(f7789n);
        this.f7797F.setBackgroundResource(this.f7815i.mo10222b(f7789n));
        this.f7803M.setBackgroundResource(0);
        this.f7802L.setBackgroundResource(0);
    }

    /* renamed from: w */
    public String mo10257w() {
        if (f7790o != 1) {
            f7790o++;
        } else {
            f7790o = 0;
        }
        return f7791v[f7790o];
    }
}
