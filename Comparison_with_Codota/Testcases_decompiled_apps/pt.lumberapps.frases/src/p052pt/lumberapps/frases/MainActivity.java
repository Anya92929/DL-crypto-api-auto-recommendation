package p052pt.lumberapps.frases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.appbrain.C0783a;
import com.appbrain.C0980aa;
import com.google.android.gms.C1204R;
import com.p028a.C0765a;
import com.p046c.p047a.C1187q;
import p052pt.lumberapps.frases.outros.C2064a;
import p052pt.lumberapps.lumbliv.C2090k;

/* renamed from: pt.lumberapps.frases.MainActivity */
public class MainActivity extends C2076w implements View.OnLongClickListener, AdapterView.OnItemClickListener {

    /* renamed from: d */
    int f7655d = 0;

    /* renamed from: e */
    int f7656e = 0;

    /* renamed from: f */
    Spinner f7657f;

    /* renamed from: b */
    private void m8281b(Intent intent) {
        C2049bb.m8326b("Parsa Intent");
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals("android.intent.action.SEND")) {
            new C2055g(this).mo10198a(new C2038ar(MApp.m8274b(intent).mo10181b(), ""));
            mo10213b(mo10240c(C1204R.string.frase_add_favoritos));
            setResult(-1);
            finish();
        } else if (action.equals("Action__Meu")) {
            if (this.f7813g == null) {
                this.f7813g = new C2020a(this);
            }
            if (MApp.m8275c(intent)) {
                C2038ar a = MApp.m8273a(intent);
                this.f7802L.setText(a.mo10181b());
                this.f7803M.setText(a.mo10179a());
                f7788m = 0;
                C2020a.m8290a(a);
                this.f7806P = true;
                C2049bb.m8326b("Parsed");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m8282x() {
        if (f7783T) {
            mo10255u();
            getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            f7783T = false;
            return;
        }
        f7783T = true;
        mo10213b(mo10240c(C1204R.string.modo_automatico));
        if (f7782I) {
            f7784U = C0515k.AppCompatTheme_checkedTextViewStyle;
        } else {
            f7784U = 93;
        }
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        mo10255u();
        mo10129j();
    }

    /* renamed from: a */
    public void mo10125a(int i) {
        if (!this.f7806P) {
            C2049bb.m8326b("MudaTema");
            if (i == 5) {
                try {
                    this.f7813g.mo10150a((Context) this);
                } catch (Exception e) {
                    mo10213b(mo10240c(C1204R.string.sem_frases_fav_warn));
                    e.printStackTrace();
                    try {
                        this.f7657f.setSelection(0);
                        return;
                    } catch (NullPointerException e2) {
                        return;
                    }
                }
            }
            f7788m = 0;
            f7789n = 0;
            this.f7813g.mo10155d(i);
            f7786k = C2020a.m8291b();
            if (f7786k == 0) {
                mo10213b(mo10240c(C1204R.string.sem_frases_fav_warn));
                mo10125a(0);
                return;
            }
            this.f7814h.mo10223a(f7786k);
            if (!this.f7806P) {
                mo10126a(1, false, (C2038ar) null);
            }
            C2049bb.m8326b("Nao mostrou intent");
            return;
        }
        C2049bb.m8326b("mostrou intent");
    }

    /* renamed from: a */
    public void mo10126a(int i, boolean z, C2038ar arVar) {
        C2049bb.m8326b("Muda pos=" + f7788m);
        if (arVar != null) {
            this.f7802L.setText(arVar.mo10181b());
            this.f7803M.setText(arVar.mo10179a());
            return;
        }
        switch (i) {
            case -1:
                f7788m = this.f7814h.mo10225c(f7788m);
                break;
            case 1:
                f7788m = this.f7814h.mo10224b(f7788m);
                break;
        }
        if (f7782I) {
            f7789n = this.f7815i.mo10221a(f7789n);
            this.f7797F.setBackgroundResource(this.f7815i.mo10222b(f7789n));
        }
        C2038ar c = this.f7813g.mo10153c(f7788m);
        String str = c.f7707b;
        this.f7802L.setText(str);
        this.f7803M.setText(c.f7708c);
        if (z) {
            try {
                mo10241d(str);
                mo10247n();
            } catch (Exception e) {
                mo10214c(e.getMessage());
            }
            if (this.f7802L != null) {
                if (i == 1) {
                    C1187q.m5415a(this.f7802L, "translationX", 500.0f, 0.0f).mo4533c(200).mo4491a();
                    if (this.f7803M != null) {
                        C1187q.m5415a(this.f7803M, "translationX", -500.0f, 0.0f).mo4533c(200).mo4491a();
                    }
                }
                if (i == -1) {
                    C1187q.m5415a(this.f7802L, "translationX", -500.0f, 0.0f).mo4533c(200).mo4491a();
                    if (this.f7803M != null) {
                        C1187q.m5415a(this.f7803M, "translationX", 500.0f, 0.0f).mo4533c(200).mo4491a();
                    }
                }
            }
            if (f7788m == 20 || f7788m == 90 || f7788m == 60 || f7788m == 120) {
                mo10250p();
            }
        }
        if (this.f7803M.getText().length() < 3) {
            this.f7803M.setVisibility(4);
        } else {
            this.f7803M.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10127a(Activity activity, String str, String str2) {
        try {
            Intent launchIntentForPackage = activity.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                throw new PackageManager.NameNotFoundException();
            }
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.setAction("android.intent.action.SEND");
            launchIntentForPackage.putExtra("android.intent.extra.TEXT", mo10254t());
            launchIntentForPackage.setType("text/plain");
            activity.startActivity(launchIntentForPackage);
        } catch (PackageManager.NameNotFoundException e) {
            C2072s sVar = new C2072s(this, this, str2, activity, str);
            sVar.mo10272a(getResources().getColor(C1204R.color.azul_fescuro), -1);
            sVar.mo10271e();
        }
    }

    /* renamed from: i */
    public void mo10128i() {
        this.f7816j = new C2056h(this);
        String string = getResources().getString(C1204R.string.linguagem_default);
        Log.i("ling", string);
        MApp.f7652a = string;
        this.f7802L = (TextView) findViewById(C1204R.C1205id.textView1);
        this.f7803M = (TextView) findViewById(C1204R.C1205id.textView2);
        this.f7797F = (RelativeLayout) findViewById(C1204R.C1205id.relamain);
        this.f7800J = (ImageButton) findViewById(C1204R.C1205id.btVis);
        this.f7801K = (ImageButton) findViewById(C1204R.C1205id.dirButton);
        this.f7801K.setOnLongClickListener(this);
        this.f7809S = new C2090k(this, this, (ArrayAdapter) null, this.f7821t, getResources().getColor(C1204R.color.azul_fescuro), getResources().getColor(C1204R.color.Black), true);
        this.f7809S.mo10293a(new C0765a((Activity) this), getString(C1204R.string.linguagem_default));
        this.f7809S.mo10292a();
        ListView listView = (ListView) findViewById(C1204R.C1205id.listViewMenu);
        listView.setAdapter(new C2029ai(this, this, C1204R.layout.menuitem));
        listView.setOnItemClickListener(this);
        this.f7817p = AnimationUtils.loadAnimation(this, C1204R.anim.grow);
        this.f7818q = AnimationUtils.loadAnimation(this, C1204R.anim.fadein);
        this.f7819r = AnimationUtils.loadAnimation(this, C1204R.anim.slideoutbottom);
        this.f7820s = AnimationUtils.loadAnimation(this, C1204R.anim.slideinbottom);
        ((ScrollView) findViewById(C1204R.C1205id.idscroll)).setOnTouchListener(new C2069p(this));
        MApp.f7653b = new C0765a((Activity) this);
        MApp.f7652a = mo10240c(C1204R.string.linguagem_default);
        this.f7813g = new C2020a(this);
        f7786k = C2020a.m8291b();
        f7787l = 0;
        f7788m = 0;
        f7789n = 0;
        this.f7804N = Typeface.createFromAsset(getAssets(), "roboto-thin.ttf");
        if (f7782I) {
            mo10256v();
        }
        if (!this.f7816j.mo10210e()) {
            this.f7802L.setTypeface(this.f7804N);
            this.f7803M.setTypeface(this.f7804N);
        }
        this.f7814h = new C2062n(f7787l, f7786k);
        f7790o = 1;
        mo10251q();
        mo10244k();
    }

    /* renamed from: j */
    public void mo10129j() {
        new C2074u(this).start();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 33) {
            mo10250p();
        } else if (i2 == 32 && i == 15) {
            mo10252r();
        } else if (i == 12) {
            m8281b(intent);
        }
    }

    public void onBackPressed() {
        if (!mo10248o() && !C2064a.m8358a(this) && !C0980aa.m4089a().mo3905a(C0783a.f2051e).mo3904a((Activity) this).mo3909a((Context) this)) {
            super.onBackPressed();
        }
    }

    public void onClickDir(View view) {
        view.startAnimation(this.f7817p);
        if (this.f7816j.mo10206a("modoAutomatico")) {
            mo10213b(getString(C1204R.string.aprende_modo_automatico));
        }
        mo10255u();
    }

    public void onClickDireita(View view) {
        view.startAnimation(this.f7817p);
        mo10126a(1, true, (C2038ar) null);
    }

    public void onClickEsq(View view) {
        view.startAnimation(this.f7817p);
        if (f7782I) {
            f7782I = false;
            this.f7797F.setBackgroundResource(C1204R.drawable.fundo_azul);
            this.f7803M.setBackgroundResource(C1204R.drawable.gradi_transp);
            this.f7802L.setBackgroundResource(C1204R.drawable.gradi_transp);
            return;
        }
        f7782I = true;
        mo10256v();
    }

    public void onClickEsquerda(View view) {
        view.startAnimation(this.f7817p);
        mo10126a(-1, true, (C2038ar) null);
    }

    public void onClickGoLista(View view) {
        view.startAnimation(this.f7817p);
        startActivityForResult(new Intent(getApplicationContext(), ListaMain.class), 12);
    }

    public void onClickShare(View view) {
        try {
            C2070q qVar = new C2070q(this, this);
            qVar.mo10280a(getResources().getColor(C1204R.color.azul_fescuro), getResources().getColor(C1204R.color.laranja_bts), getString(C1204R.string.partilhar_frase));
            qVar.mo10281a(5, getString(C1204R.string.texto_factory), "pt.lumberapps.quotefactory", Integer.valueOf(C1204R.drawable.quotefactory));
            qVar.mo10281a(1, getString(C1204R.string.exort_as_img), "exportaimg", Integer.valueOf(C1204R.drawable.ic_fundo_pek));
            qVar.show();
        } catch (Exception e) {
            e.printStackTrace();
            mo10213b(getString(C1204R.string.nao_tem_instalada));
        }
    }

    public void onClickTemas(View view) {
        if (f7783T) {
            m8282x();
        }
    }

    public void onClickVis(View view) {
        view.startAnimation(this.f7817p);
        if (f7783T) {
            m8282x();
        } else {
            mo10255u();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(getBaseContext(), C1204R.array.temas_tabs, C1204R.layout.support_simple_spinner_dropdown_item);
        createFromResource.setDropDownViewResource(C1204R.layout.support_simple_spinner_dropdown_item);
        super.onCreate(bundle);
        setContentView((int) C1204R.layout.activity_main);
        this.f7795D = (Toolbar) findViewById(C1204R.C1205id.app_bar);
        mo1952a(this.f7795D);
        mo1955b().mo1916b(false);
        this.f7657f = (Spinner) findViewById(C1204R.C1205id.spinner_toolbar);
        this.f7657f.setAdapter(createFromResource);
        this.f7657f.setOnItemSelectedListener(new C2063o(this));
        this.f7822u = mo10242d((int) C1204R.array.temas);
        mo10128i();
    }

    public void onDestroy() {
        if (this.f7805O != null) {
            this.f7805O.destroy();
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f7799H.postDelayed(new C2073t(this, i), 300);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        if (f7783T) {
            m8282x();
        }
        return true;
    }

    public boolean onLongClick(View view) {
        m8282x();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case C1204R.C1205id.addFavoritos:
                if (f7783T) {
                    m8282x();
                }
                if (this.f7826z) {
                    mo10246m();
                } else {
                    mo10245l();
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (f7783T) {
            m8282x();
        }
        if (this.f7805O != null) {
            this.f7805O.pause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f7805O != null) {
            this.f7805O.resume();
        }
        if (this.f7807Q) {
            this.f7807Q = false;
            this.f7808R++;
            mo10250p();
        }
    }

    public void onStart() {
        super.onStart();
        m8281b(getIntent());
    }
}
