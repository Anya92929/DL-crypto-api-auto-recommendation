package p052pt.lumberapps.frases;

import android.app.Application;
import android.content.Intent;
import com.p028a.C0765a;

/* renamed from: pt.lumberapps.frases.MApp */
public class MApp extends Application {

    /* renamed from: a */
    public static String f7652a = "";

    /* renamed from: b */
    public static C0765a f7653b;

    /* renamed from: a */
    public static Intent m8271a(Intent intent, C2038ar arVar, int i) {
        intent.setAction("Action__Meu");
        intent.putExtra("frase_a_mostrar", arVar.mo10181b());
        intent.putExtra("tem_data", true);
        intent.putExtra("tema", i);
        intent.putExtra("autor", arVar.mo10179a());
        return intent;
    }

    /* renamed from: a */
    public static String m8272a(String str) {
        return str.length() < 3 ? "" : "(" + str + ")";
    }

    /* renamed from: a */
    public static C2038ar m8273a(Intent intent) {
        C2038ar arVar = new C2038ar();
        arVar.mo10182b(intent.getStringExtra("frase_a_mostrar"));
        intent.getIntExtra("tema", 0);
        arVar.mo10180a(intent.getStringExtra("autor"));
        return arVar;
    }

    /* renamed from: b */
    public static C2038ar m8274b(Intent intent) {
        C2038ar arVar = new C2038ar();
        if (intent.getType().startsWith("text/")) {
            String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
            if (stringExtra != null) {
                arVar.mo10182b(stringExtra);
            }
        } else {
            arVar.mo10182b("null");
        }
        return arVar;
    }

    /* renamed from: c */
    public static boolean m8275c(Intent intent) {
        if (!intent.getBooleanExtra("tem_data", false)) {
            return false;
        }
        intent.putExtra("tem_data", false);
        return true;
    }

    public void onCreate() {
        super.onCreate();
    }
}
