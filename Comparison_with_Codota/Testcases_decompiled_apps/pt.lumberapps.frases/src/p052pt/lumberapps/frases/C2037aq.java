package p052pt.lumberapps.frases;

import android.support.p009v4.app.Fragment;
import android.support.p009v4.app.FragmentManager;
import android.support.p009v4.app.FragmentPagerAdapter;
import java.util.List;

/* renamed from: pt.lumberapps.frases.aq */
public class C2037aq extends FragmentPagerAdapter {

    /* renamed from: a */
    private String[] f7704a;

    /* renamed from: b */
    private List f7705b;

    public C2037aq(FragmentManager fragmentManager, List list, String[] strArr) {
        super(fragmentManager);
        this.f7704a = strArr;
        this.f7705b = list;
    }

    public int getCount() {
        return this.f7705b.size();
    }

    public Fragment getItem(int i) {
        return (Fragment) this.f7705b.get(i);
    }

    public CharSequence getPageTitle(int i) {
        return this.f7704a[i];
    }
}
