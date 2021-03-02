package p052pt.lumberapps.frases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.h */
public class C2056h {

    /* renamed from: a */
    public SharedPreferences f7746a;

    public C2056h(Context context) {
        this.f7746a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* renamed from: a */
    public String mo10202a(Context context) {
        return this.f7746a.getString("linguagem_ops", context.getString(C1204R.string.linguagem_default));
    }

    /* renamed from: a */
    public void mo10203a(int i, int i2) {
        this.f7746a.edit().putInt("hora", i).commit();
        this.f7746a.edit().putInt("min", i2).commit();
    }

    /* renamed from: a */
    public void mo10204a(Context context, String str) {
        this.f7746a.edit().putString("linguagem_ops", str).commit();
    }

    /* renamed from: a */
    public boolean mo10205a() {
        return this.f7746a.getBoolean("notifica", true);
    }

    /* renamed from: a */
    public boolean mo10206a(String str) {
        boolean z = this.f7746a.getBoolean("mostrou" + str, true);
        if (z) {
            this.f7746a.edit().putBoolean("mostrou" + str, false).commit();
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo10207b() {
        return this.f7746a.getBoolean("som_notifica", false);
    }

    /* renamed from: c */
    public int mo10208c() {
        return this.f7746a.getInt("min", 0);
    }

    /* renamed from: d */
    public int mo10209d() {
        return this.f7746a.getInt("hora", 9);
    }

    /* renamed from: e */
    public boolean mo10210e() {
        return this.f7746a.getBoolean("tipoletra", false);
    }

    /* renamed from: f */
    public boolean mo10211f() {
        boolean z = this.f7746a.getBoolean("firstLaunchnotificacoes", true);
        if (z) {
            this.f7746a.edit().putBoolean("firstLaunchnotificacoes", false).commit();
        }
        return z;
    }
}
