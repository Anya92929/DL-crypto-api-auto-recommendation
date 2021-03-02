package p052pt.lumberapps.frases;

import android.os.Bundle;
import android.support.p009v4.app.Fragment;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.view.ViewPager;
import android.view.MenuItem;
import com.google.android.gms.C1204R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.viewpagerindicator.C2007a;
import com.viewpagerindicator.TitlePageIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* renamed from: pt.lumberapps.frases.ListaMain */
public class ListaMain extends FragmentActivity {

    /* renamed from: a */
    C2007a f7647a;

    /* renamed from: b */
    List f7648b = new Vector();

    /* renamed from: c */
    ArrayList f7649c = new ArrayList();

    /* renamed from: d */
    AdView f7650d;

    /* renamed from: e */
    private C2037aq f7651e;

    /* renamed from: b */
    private void m8269b() {
        this.f7648b.add(Fragment.instantiate(this, C2043aw.class.getName()));
        this.f7648b.add(Fragment.instantiate(this, C2039as.class.getName()));
        this.f7648b.add(Fragment.instantiate(this, C2040at.class.getName()));
        this.f7648b.add(Fragment.instantiate(this, C2041au.class.getName()));
        this.f7648b.add(Fragment.instantiate(this, C2042av.class.getName()));
        this.f7651e = new C2037aq(super.getSupportFragmentManager(), this.f7648b, getResources().getStringArray(C1204R.array.pagerAdapterTitulo));
        ViewPager viewPager = (ViewPager) super.findViewById(C1204R.C1205id.pager);
        viewPager.setAdapter(this.f7651e);
        this.f7647a = (TitlePageIndicator) findViewById(C1204R.C1205id.indicator);
        this.f7647a.setViewPager(viewPager);
        this.f7650d = (AdView) findViewById(C1204R.C1205id.adViewLista);
        this.f7650d.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("3C61727371E60E0BFD3663CCB7BFA8B4").build());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10116a() {
        getIntent().setAction("Action__Meu");
        setResult(33);
        finish();
    }

    public void onBackPressed() {
        mo10116a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(C1204R.anim.slideinright, C1204R.anim.slideoutleft);
        super.setContentView(C1204R.layout.frag_main);
        m8269b();
    }

    public void onDestroy() {
        if (this.f7650d != null) {
            this.f7650d.destroy();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                mo10116a();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.f7650d != null) {
            this.f7650d.pause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f7650d != null) {
            this.f7650d.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
